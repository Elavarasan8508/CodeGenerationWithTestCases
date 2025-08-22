package com.bsit.codegeneration.parser;

import com.bsit.codegeneration.model.*;
import com.bsit.codegeneration.util.Relationship;
import com.bsit.codegeneration.util.StringUtils;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

import java.io.IOException;
import java.nio.file.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class DaoGenerator {

    private static class ColumnInfo {
        String name;
        String javaType;
        boolean isAutoIncrement;

        ColumnInfo(String name, String javaType, boolean isAutoIncrement) {
            this.name = name;
            this.javaType = javaType;
            this.isAutoIncrement = isAutoIncrement;
        }
    }

    public static void generateDao(
            String tableName,
            ResultSet columns,
            DatabaseConfig dbConfig,
            TargetConfig target,
            DtoConfig dtoConfig,
            List<Relationship> relationships,
            List<Relationship> reverseRelationships)
            throws Exception {

        NamingStrategyConfig naming = dbConfig.getNamingStrategy();
        String rawClassName = StringUtils.stripPrefix(tableName, naming.getStripPrefixes());
        String className = StringUtils.toCamelCase(rawClassName, naming.getUppercaseAcronyms(), true);
        String recordClassName = className + "DTO";
        String daoClassName = className + "JdbcDao";
        String packageName = target.getBasePackage() + "." + target.getDaoPackage();

        // Safely handle null database configuration values
        String url = dbConfig.getUrl() != null ? dbConfig.getUrl() : "";
        String username = dbConfig.getName() != null ? dbConfig.getName() : "";
        String password = dbConfig.getPassword() != null ? dbConfig.getPassword() : "";

        // Collect column information
        List<ColumnInfo> columnsInfo = new ArrayList<>();
        String pkField = null;
        String idType = null;
        boolean pkIsAuto = false;

        while (columns.next()) {
            String colName = columns.getString("COLUMN_NAME");
            String dbType = columns.getString("TYPE_NAME");
            int decimalDigits = 0;
            try { decimalDigits = columns.getInt("DECIMAL_DIGITS"); } catch (Exception ignored) {}
            String javaType = mapDbTypeToJava(dbType, colName, decimalDigits);

            boolean isAutoIncrement = false;
            try {
                String isAutoStr = columns.getString("IS_AUTOINCREMENT");
                isAutoIncrement = "YES".equals(isAutoStr);
            } catch (SQLException ignored) {}
            if (dbType.equalsIgnoreCase("SERIAL")) {
                isAutoIncrement = true;
            }

            columnsInfo.add(new ColumnInfo(colName, javaType, isAutoIncrement));

            if (pkField == null && colName.equalsIgnoreCase("id")) {
                pkField = colName;
                idType = javaType;
                pkIsAuto = isAutoIncrement;
            } else if (pkField == null && colName.toLowerCase().endsWith("_id")) {
                pkField = colName;
                idType = javaType;
                pkIsAuto = isAutoIncrement;
            }
        }

        if (pkField == null && !columnsInfo.isEmpty()) {
            pkField = columnsInfo.get(0).name;
            idType = columnsInfo.get(0).javaType;
            pkIsAuto = columnsInfo.get(0).isAutoIncrement;
        }
        if (pkField == null) {
            pkField = "id";
            idType = "Integer";
            pkIsAuto = false;
        }

        // Get DTO field types and order from DtoGenerator to ensure sync
        LinkedHashMap<String, String> orderedFields = DtoGenerator.extractDtoFieldTypes(
                columns, relationships, reverseRelationships, dtoConfig, dbConfig);

        // Build class using JavaParser
        CompilationUnit cu = new CompilationUnit();
        cu.setPackageDeclaration(packageName);

        // imports
        cu.addImport("java.sql.*");
        cu.addImport("java.util.*");
        cu.addImport("java.time.LocalDateTime");
        cu.addImport(target.getBasePackage() + "." + target.getRecordPackage() + "." + recordClassName);

        // class
        ClassOrInterfaceDeclaration daoClass = cu.addClass(daoClassName, Modifier.Keyword.PUBLIC);

        // constants with null-safe initialization
        FieldDeclaration urlField = daoClass.addFieldWithInitializer("String", "DB_URL",
                new StringLiteralExpr(url), Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);
        FieldDeclaration userField = daoClass.addFieldWithInitializer("String", "DB_USER",
                new StringLiteralExpr(username), Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);
        FieldDeclaration passField = daoClass.addFieldWithInitializer("String", "DB_PASSWORD",
                new StringLiteralExpr(password), Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // connection field
        daoClass.addField("Connection", "conn", Modifier.Keyword.PRIVATE);

        // constructor
        ConstructorDeclaration ctor = daoClass.addConstructor(Modifier.Keyword.PUBLIC);
        ctor.addThrownException(new ClassOrInterfaceType(null, "SQLException"));
        BlockStmt ctorBody = new BlockStmt();
        ctorBody.addStatement("this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);");
        ctor.setBody(ctorBody);

        // close()
        MethodDeclaration closeMethod = daoClass.addMethod("close", Modifier.Keyword.PUBLIC);
        closeMethod.addThrownException(new ClassOrInterfaceType(null, "SQLException"));
        StringBuilder closeBlock = new StringBuilder();
        closeBlock.append("{\n");
        closeBlock.append("  if (conn != null && !conn.isClosed()) {\n");
        closeBlock.append("    conn.close();\n");
        closeBlock.append("  }\n");
        closeBlock.append("}\n");
        BlockStmt closeBody = StaticJavaParser.parseBlock(closeBlock.toString());
        closeMethod.setBody(closeBody);

        // findById
        createFindByIdMethod(daoClass, tableName, recordClassName, pkField, idType, orderedFields, naming);

        // insert
        createInsertMethod(daoClass, tableName, recordClassName, pkField, idType, columnsInfo, naming, pkIsAuto);

        // update
        createUpdateMethod(daoClass, tableName, recordClassName, pkField, idType, columnsInfo, naming);

        // delete
        createDeleteMethod(daoClass, tableName, pkField, idType, naming);

        // helper methods
        createHelperMethods(daoClass);

        // write file
        writeToFile(target, packageName, daoClassName, cu);
    }

    private static void createFindByIdMethod(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            String recordClassName,
            String pkField,
            String idType,
            LinkedHashMap<String, String> orderedFields,
            NamingStrategyConfig naming) {

        String pkCamel = StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), false);
        MethodDeclaration m = daoClass.addMethod("findById", Modifier.Keyword.PUBLIC);
        m.setType(recordClassName);
        m.addParameter(idType, pkCamel);
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        // Build body as a parseable block (keeps code readable)
        StringBuilder block = new StringBuilder();
        block.append("{\n");
        block.append("  String sql = \"SELECT * FROM ").append(tableName).append(" WHERE ").append(pkField).append(" = ?\";\n");
        block.append("  try (PreparedStatement ps = conn.prepareStatement(sql)) {\n");
        block.append("   ps.").append(getPreparedStatementSetter(idType)).append("(1, ").append(pkCamel).append(");\n");
        block.append("   try (ResultSet rs = ps.executeQuery()) {\n");
        block.append("    if (rs.next()) {\n");
        block.append("     return new ").append(recordClassName).append("(");

        List<Map.Entry<String, String>> validFields = orderedFields.entrySet().stream()
                .filter(entry -> !entry.getValue().startsWith("List<"))
                .collect(Collectors.toList());

        for (int i = 0; i < validFields.size(); i++) {
            Map.Entry<String, String> entry = validFields.get(i);
            String field = entry.getKey();
            String type = entry.getValue();

            if (type.endsWith("DTO")) {
                block.append("null");
            } else if ("java.time.LocalDateTime".equals(type)) {
                block.append("toLocalDateTime(rs.getTimestamp(\"").append(toDbColumn(field)).append("\"))");
            } else {
                String columnName = field.equals(pkCamel) ? pkField : toDbColumn(field);
                block.append("rs.").append(getResultSetGetter(type)).append("(\"").append(columnName).append("\")");
            }
            if (i < validFields.size() - 1) block.append(", ");
        }

        block.append(");\n"); // close constructor call
        block.append("    }\n");
        block.append("    return null;\n");
        block.append("   }\n");
        block.append("  }\n");
        block.append("}\n");

        BlockStmt body = StaticJavaParser.parseBlock(block.toString());
        m.setBody(body);
    }

    private static void createInsertMethod(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            String recordClassName,
            String pkField,
            String idType,
            List<ColumnInfo> columnsInfo,
            NamingStrategyConfig naming,
            boolean pkIsAuto) {

        MethodDeclaration m = daoClass.addMethod("insert", Modifier.Keyword.PUBLIC);
        m.setType(idType);
        m.addParameter(recordClassName, "entity");
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        List<ColumnInfo> insertCols = columnsInfo.stream()
                .filter(c -> !(pkIsAuto && c.name.equals(pkField)))
                .collect(Collectors.toList());

        String columnList = insertCols.stream().map(c -> c.name).collect(Collectors.joining(", "));
        String placeholders = insertCols.stream().map(c -> "?").collect(Collectors.joining(", "));

        StringBuilder block = new StringBuilder();
        block.append("{\n");
        block.append("  String sql = \"INSERT INTO ").append(tableName).append(" (").append(columnList).append(") VALUES (").append(placeholders).append(")\";\n");
        if (pkIsAuto) {
            block.append("  try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {\n");
        } else {
            block.append("  try (PreparedStatement ps = conn.prepareStatement(sql)) {\n");
        }
        for (int i = 0; i < insertCols.size(); i++) {
            ColumnInfo c = insertCols.get(i);
            String getter = "entity.get" + StringUtils.toCamelCase(c.name, naming.getUppercaseAcronyms(), true) + "()";
            int idx = i + 1;
            if ("java.time.LocalDateTime".equals(c.javaType)) {
                block.append("   ps.setTimestamp(").append(idx).append(", toTimestamp(").append(getter).append("));\n");
            } else {
                block.append("   ps.").append(getPreparedStatementSetter(c.javaType)).append("(").append(idx).append(", ").append(getter).append(");\n");
            }
        }
        block.append("   int rows = ps.executeUpdate();\n");
        if (pkIsAuto) {
            block.append("   if (rows > 0) {\n");
            block.append("     try (ResultSet genKeys = ps.getGeneratedKeys()) {\n");
            block.append("       if (genKeys.next()) {\n");
            block.append("         return genKeys.").append(getResultSetGetter(idType)).append("(1);\n");
            block.append("       }\n");
            block.append("     }\n");
            block.append("   }\n");
            block.append("   return null;\n");
        } else {
            block.append("   return entity.get").append(StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true)).append("();\n");
        }
        block.append("  }\n");
        block.append("}\n");

        m.setBody(StaticJavaParser.parseBlock(block.toString()));
    }

    private static void createUpdateMethod(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            String recordClassName,
            String pkField,
            String idType,
            List<ColumnInfo> columnsInfo,
            NamingStrategyConfig naming) {

        MethodDeclaration m = daoClass.addMethod("update", Modifier.Keyword.PUBLIC);
        m.setType("int");
        m.addParameter(recordClassName, "entity");
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        List<ColumnInfo> updateCols = columnsInfo.stream()
                .filter(c -> !c.name.equalsIgnoreCase(pkField))
                .collect(Collectors.toList());

        String setClause = updateCols.stream().map(c -> c.name + " = ?").collect(Collectors.joining(", "));

        StringBuilder block = new StringBuilder();
        block.append("{\n");
        block.append("  String sql = \"UPDATE ").append(tableName).append(" SET ").append(setClause)
                .append(" WHERE ").append(pkField).append(" = ?\";\n");
        block.append("  try (PreparedStatement ps = conn.prepareStatement(sql)) {\n");

        for (int i = 0; i < updateCols.size(); i++) {
            ColumnInfo c = updateCols.get(i);
            String getter = "entity.get" + StringUtils.toCamelCase(c.name, naming.getUppercaseAcronyms(), true) + "()";
            int idx = i + 1;
            if ("java.time.LocalDateTime".equals(c.javaType)) {
                block.append("   ps.setTimestamp(").append(idx).append(", toTimestamp(").append(getter).append("));\n");
            } else {
                block.append("   ps.").append(getPreparedStatementSetter(c.javaType)).append("(").append(idx).append(", ").append(getter).append(");\n");
            }
        }

        // set PK at the end
        block.append("   ps.").append(getPreparedStatementSetter(idType)).append("(")
                .append(updateCols.size() + 1).append(", entity.get")
                .append(StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true)).append("());\n");

        block.append("   return ps.executeUpdate();\n");
        block.append("  }\n");
        block.append("}\n");

        m.setBody(StaticJavaParser.parseBlock(block.toString()));
    }

    private static void createDeleteMethod(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            String pkField,
            String idType,
            NamingStrategyConfig naming) {

        String pkCamel = StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), false);
        MethodDeclaration m = daoClass.addMethod("delete", Modifier.Keyword.PUBLIC);
        m.setType("int");
        m.addParameter(idType, pkCamel);
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        StringBuilder block = new StringBuilder();
        block.append("{\n");
        block.append("  String sql = \"DELETE FROM ").append(tableName).append(" WHERE ").append(pkField).append(" = ?\";\n");
        block.append("  try (PreparedStatement ps = conn.prepareStatement(sql)) {\n");
        block.append("   ps.").append(getPreparedStatementSetter(idType)).append("(1, ").append(pkCamel).append(");\n");
        block.append("   return ps.executeUpdate();\n");
        block.append("  }\n");
        block.append("}\n");

        m.setBody(StaticJavaParser.parseBlock(block.toString()));
    }

    private static void createHelperMethods(ClassOrInterfaceDeclaration daoClass) {
        // toTimestamp
        MethodDeclaration toTs = daoClass.addMethod("toTimestamp", Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC);
        toTs.setType("Timestamp");
        toTs.addParameter("LocalDateTime", "localDateTime");
        toTs.setBody(StaticJavaParser.parseBlock("{ return localDateTime != null ? Timestamp.valueOf(localDateTime) : null; }"));

        // toLocalDateTime
        MethodDeclaration toLd = daoClass.addMethod("toLocalDateTime", Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC);
        toLd.setType("LocalDateTime");
        toLd.addParameter("Timestamp", "timestamp");
        toLd.setBody(StaticJavaParser.parseBlock("{ return timestamp != null ? timestamp.toLocalDateTime() : null; }"));
    }

    private static void writeToFile(TargetConfig target, String packageName, String className, CompilationUnit cu) throws IOException {
        Path outputPath = Paths.get(target.getOutputDirectory(), packageName.replace(".", "/"), className + ".java");
        Files.createDirectories(outputPath.getParent());
        Files.writeString(outputPath, cu.toString());
        System.out.println("Generated DAO: " + outputPath);
    }

    /* ---------- utility methods ---------- */

    private static String toDbColumn(String fieldName) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fieldName.length(); i++) {
            char c = fieldName.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i > 0) result.append('_');
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static String mapDbTypeToJava(String dbType, String columnName, int decimalDigits) {
        if (columnName.equalsIgnoreCase("id") || columnName.toLowerCase().endsWith("_id")) {
            return "Integer";
        }
        dbType = dbType == null ? "" : dbType.toUpperCase();
        return switch (dbType) {
            case "SERIAL" -> "Integer";
            case "VARCHAR", "VARCHAR2", "CHAR", "TEXT", "CLOB" -> "String";
            case "INT", "INTEGER", "SMALLINT", "TINYINT", "YEAR" -> "Integer";
            case "BIGINT" -> "Long";
            case "NUMBER", "DECIMAL", "NUMERIC", "FLOAT", "REAL" -> decimalDigits > 0 ? "Float" : "Long";
            case "DOUBLE", "DOUBLE PRECISION" -> "Double";
            case "DATE", "TIMESTAMP", "TIMESTAMPTZ" -> "java.time.LocalDateTime";
            case "JSON", "JSONB" -> "java.util.Map<String, Object>";
            default -> "String";
        };
    }

    private static String getResultSetGetter(String javaType) {
        return switch (javaType) {
            case "String" -> "getString";
            case "Integer" -> "getInt";
            case "Long" -> "getLong";
            case "Float" -> "getFloat";
            case "Double" -> "getDouble";
            case "java.time.LocalDateTime" -> "getTimestamp";
            case "java.util.Map<String, Object>" -> "getObject";
            default -> "getObject";
        };
    }

    private static String getPreparedStatementSetter(String javaType) {
        return switch (javaType) {
            case "String" -> "setString";
            case "Integer" -> "setInt";
            case "Long" -> "setLong";
            case "Float" -> "setFloat";
            case "Double" -> "setDouble";
            case "java.time.LocalDateTime" -> "setTimestamp";
            case "java.util.Map<String, Object>" -> "setObject";
            default -> "setObject";
        };
    }
}
