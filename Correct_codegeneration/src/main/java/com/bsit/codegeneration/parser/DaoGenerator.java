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
        boolean isForeignKey;
        String referencedTable;

        ColumnInfo(String name, String javaType, boolean isAutoIncrement) {
            this.name = name;
            this.javaType = javaType;
            this.isAutoIncrement = isAutoIncrement;
            this.isForeignKey = false;
            this.referencedTable = null;
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
        String modelClassName = className+"DTO";
        String daoClassName = className + "Dao";
        String packageName = target.getBasePackage() + "." + target.getDaoPackage();

        // Collect column information
        List<ColumnInfo> columnsInfo = new ArrayList<>();
        Map<String, String> foreignKeyMap = new HashMap<>();
        String pkField = null;
        String idType = null;
        boolean pkIsAuto = false;

        // Map foreign keys from relationships
        if (relationships != null) {
            for (Relationship rel : relationships) {
                if (rel.getType() == Relationship.Type.MANY_TO_ONE) {
                    foreignKeyMap.put(rel.getFkColumn(), rel.getRelatedTable());
                }
            }
        }

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

            ColumnInfo colInfo = new ColumnInfo(colName, javaType, isAutoIncrement);

            // Check if this column is a foreign key
            if (foreignKeyMap.containsKey(colName)) {
                colInfo.isForeignKey = true;
                colInfo.referencedTable = foreignKeyMap.get(colName);
            }

            columnsInfo.add(colInfo);

            if (pkField == null && colName.equalsIgnoreCase("id")) {
                pkField = colName;
                idType = javaType;
                pkIsAuto = isAutoIncrement;
            } else if (pkField == null && colName.toLowerCase().endsWith("_id") && !colInfo.isForeignKey) {
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

        // Build class using JavaParser
        CompilationUnit cu = new CompilationUnit();
        cu.setPackageDeclaration(packageName);

        // imports
        cu.addImport("java.sql.*");
        cu.addImport("java.util.ArrayList");
        cu.addImport("java.util.List");
        cu.addImport(target.getBasePackage() + "." + target.getRecordPackage() + ".*");

        // class
        ClassOrInterfaceDeclaration daoClass = cu.addClass(daoClassName, Modifier.Keyword.PUBLIC);

        // Create SQL constant fields
        createSqlConstants(daoClass, tableName, columnsInfo, pkField, pkIsAuto, relationships);

        // Create methods
        createInsertMethod(daoClass, tableName, modelClassName, pkField, idType, columnsInfo, naming, pkIsAuto);
        createFindByIdMethod(daoClass, tableName, modelClassName, pkField, idType, columnsInfo, naming);
        createFindAllMethod(daoClass, tableName, modelClassName, columnsInfo, naming);
        createUpdateMethod(daoClass, tableName, modelClassName, pkField, idType, columnsInfo, naming);
        createDeleteMethod(daoClass, tableName, pkField, idType, naming);

        // Create relationship-based finder methods
        createRelationshipMethods(daoClass, tableName, modelClassName, columnsInfo, relationships, naming);

        // Create extract method
        createExtractMethod(daoClass, modelClassName, columnsInfo, naming);

        // write file
        writeToFile(target, packageName, daoClassName, cu);
    }

    private static void createSqlConstants(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            List<ColumnInfo> columnsInfo,
            String pkField,
            boolean pkIsAuto,
            List<Relationship> relationships) {

        // INSERT_SQL
        List<ColumnInfo> insertCols = columnsInfo.stream()
                .filter(c -> !(pkIsAuto && c.name.equals(pkField)))
                .collect(Collectors.toList());
        String insertColumns = insertCols.stream().map(c -> c.name).collect(Collectors.joining(", "));
        String insertPlaceholders = insertCols.stream().map(c -> "?").collect(Collectors.joining(", "));
        String insertSql = "INSERT INTO " + tableName + " (" + insertColumns + ") VALUES (" + insertPlaceholders + ")";
        daoClass.addFieldWithInitializer("String", "INSERT_SQL",
                new StringLiteralExpr(insertSql),
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // SELECT_BY_ID_SQL
        String selectByIdSql = "SELECT * FROM " + tableName + " WHERE " + pkField + " = ?";
        daoClass.addFieldWithInitializer("String", "SELECT_BY_ID_SQL",
                new StringLiteralExpr(selectByIdSql),
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // SELECT_ALL_SQL
        String selectAllSql = "SELECT * FROM " + tableName + " ORDER BY " + pkField;
        daoClass.addFieldWithInitializer("String", "SELECT_ALL_SQL",
                new StringLiteralExpr(selectAllSql),
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // CREATE FK SELECT METHODS
        if (relationships != null) {
            for (Relationship rel : relationships) {
                if (rel.getType() == Relationship.Type.MANY_TO_ONE) {
                    String fkColumn = rel.getFkColumn();
                    String constantName = "SELECT_BY_" + fkColumn.toUpperCase() + "_SQL";
                    String sql = "SELECT * FROM " + tableName + " WHERE " + fkColumn + " = ?";
                    daoClass.addFieldWithInitializer("String", constantName,
                            new StringLiteralExpr(sql),
                            Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);
                }
            }
        }

        // UPDATE_SQL
        List<ColumnInfo> updateCols = columnsInfo.stream()
                .filter(c -> !c.name.equalsIgnoreCase(pkField))
                .collect(Collectors.toList());
        String setClause = updateCols.stream().map(c -> c.name + " = ?").collect(Collectors.joining(", "));
        String updateSql = "UPDATE " + tableName + " SET " + setClause + " WHERE " + pkField + " = ?";
        daoClass.addFieldWithInitializer("String", "UPDATE_SQL",
                new StringLiteralExpr(updateSql),
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // DELETE_SQL
        String deleteSql = "DELETE FROM " + tableName + " WHERE " + pkField + " = ?";
        daoClass.addFieldWithInitializer("String", "DELETE_SQL",
                new StringLiteralExpr(deleteSql),
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);
    }

    private static void createInsertMethod(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            String modelClassName,
            String pkField,
            String idType,
            List<ColumnInfo> columnsInfo,
            NamingStrategyConfig naming,
            boolean pkIsAuto) {

        MethodDeclaration m = daoClass.addMethod("insert", Modifier.Keyword.PUBLIC);
        m.setType("int");
        m.addParameter("Connection", "conn");
        m.addParameter(modelClassName, StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false));
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        List<ColumnInfo> insertCols = columnsInfo.stream()
                .filter(c -> !(pkIsAuto && c.name.equals(pkField)))
                .collect(Collectors.toList());

        String paramName = StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false);

        StringBuilder block = new StringBuilder();
        block.append("{\n");
        if (pkIsAuto) {
            block.append("        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {\n");
        } else {
            block.append("        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {\n");
        }

        // Set parameters
        for (int i = 0; i < insertCols.size(); i++) {
            ColumnInfo c = insertCols.get(i);
            String getter = paramName + ".get" + StringUtils.toCamelCase(c.name, naming.getUppercaseAcronyms(), true) + "()";
            int idx = i + 1;

            if (c.isForeignKey) {
                String baseName = c.name.toLowerCase().endsWith("_id") ? c.name.substring(0, c.name.length() - 3) : c.name;
                String relationshipName = StringUtils.toCamelCase(baseName, naming.getUppercaseAcronyms(), true);
                String relationGetter = paramName + ".get" + relationshipName + "()";
                String relatedPk = c.referencedTable + "_id";
                String relatedPkCamel = StringUtils.toCamelCase(relatedPk, naming.getUppercaseAcronyms(), true);

                block.append("            if (").append(relationGetter).append(" != null && ")
                        .append(relationGetter).append(".get").append(relatedPkCamel).append("() > 0) {\n");
                block.append("                ps.setInt(").append(idx).append(", ").append(relationGetter)
                        .append(".get").append(relatedPkCamel).append("());\n");
                block.append("            } else {\n");
                block.append("                ps.setNull(").append(idx).append(", Types.INTEGER);\n");
                block.append("            }\n");
            } else if ("java.time.LocalDateTime".equals(c.javaType)) {
                block.append("            ps.setTimestamp(").append(idx).append(", Timestamp.valueOf(\n");
                block.append("                ").append(getter).append(" != null ? ").append(getter)
                        .append(" : java.time.LocalDateTime.now()\n");
                block.append("            ));\n");
            } else if (Arrays.asList("Integer", "Long", "Float", "Double").contains(c.javaType)) {
                block.append("            ").append(c.javaType).append(" val").append(idx).append(" = ").append(getter).append(";\n");
                block.append("            if (val").append(idx).append(" != null) {\n");
                block.append("                ps.").append(getPreparedStatementSetter(c.javaType)).append("(").append(idx).append(", val").append(idx).append(");\n");
                block.append("            } else {\n");
                block.append("                ps.setNull(").append(idx).append(", ").append(getTypesConstant(c.javaType)).append(");\n");
                block.append("            }\n");
            } else {
                block.append("            ps.").append(getPreparedStatementSetter(c.javaType))
                        .append("(").append(idx).append(", ").append(getter).append(");\n");
            }
        }

        block.append("\n");
        block.append("            ps.executeUpdate();\n");

        if (pkIsAuto) {
            block.append("\n");
            block.append("            try (ResultSet rs = ps.getGeneratedKeys()) {\n");
            block.append("                if (rs.next()) {\n");
            block.append("                    int id = rs.getInt(1);\n");
            block.append("                    ").append(paramName).append(".set")
                    .append(StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true))
                    .append("(id);\n");
            block.append("                    return id;\n");
            block.append("                }\n");
            block.append("            }\n");
        }

        block.append("        }\n");
        if (pkIsAuto) {
            block.append("        return -1;\n");
        } else {
            String pkGetter = paramName + ".get" + StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true) + "()";
            block.append("        return ").append(pkGetter).append(";\n");
        }
        block.append("    }");

        m.setBody(StaticJavaParser.parseBlock(block.toString()));
    }

    private static void createFindByIdMethod(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            String modelClassName,
            String pkField,
            String idType,
            List<ColumnInfo> columnsInfo,
            NamingStrategyConfig naming) {

        MethodDeclaration m = daoClass.addMethod("findById", Modifier.Keyword.PUBLIC);
        m.setType(modelClassName);
        m.addParameter("Connection", "conn");
        m.addParameter(mapJavaTypeToMethod(idType), "id");
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        StringBuilder block = new StringBuilder();
        block.append("{\n");
        block.append("        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {\n");
        block.append("            ps.setInt(1, id);\n");
        block.append("            try (ResultSet rs = ps.executeQuery()) {\n");
        block.append("                return rs.next() ? extract(rs) : null;\n");
        block.append("            }\n");
        block.append("        }\n");
        block.append("    }");

        m.setBody(StaticJavaParser.parseBlock(block.toString()));
    }

    private static void createFindAllMethod(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            String modelClassName,
            List<ColumnInfo> columnsInfo,
            NamingStrategyConfig naming) {

        MethodDeclaration m = daoClass.addMethod("findAll", Modifier.Keyword.PUBLIC);
        m.setType("List<" + modelClassName + ">");
        m.addParameter("Connection", "conn");
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        StringBuilder block = new StringBuilder();
        block.append("{\n");
        block.append("        List<").append(modelClassName).append("> list = new ArrayList<>();\n");
        block.append("        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);\n");
        block.append("             ResultSet rs = ps.executeQuery()) {\n");
        block.append("            while (rs.next()) {\n");
        block.append("                list.add(extract(rs));\n");
        block.append("            }\n");
        block.append("        }\n");
        block.append("        return list;\n");
        block.append("    }");

        m.setBody(StaticJavaParser.parseBlock(block.toString()));
    }

    private static void createRelationshipMethods(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            String modelClassName,
            List<ColumnInfo> columnsInfo,
            List<Relationship> relationships,
            NamingStrategyConfig naming) {

        if (relationships == null) return;

        for (Relationship rel : relationships) {
            if (rel.getType() == Relationship.Type.MANY_TO_ONE) {
                String fkColumn = rel.getFkColumn();
                String methodName = "findBy" + StringUtils.toCamelCase(fkColumn, naming.getUppercaseAcronyms(), true);
                String constantName = "SELECT_BY_" + fkColumn.toUpperCase() + "_SQL";

                MethodDeclaration m = daoClass.addMethod(methodName, Modifier.Keyword.PUBLIC);
                m.setType("List<" + modelClassName + ">");
                m.addParameter("Connection", "conn");
                m.addParameter("int", StringUtils.toCamelCase(fkColumn, naming.getUppercaseAcronyms(), false));
                m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

                StringBuilder block = new StringBuilder();
                block.append("{\n");
                block.append("        List<").append(modelClassName).append("> list = new ArrayList<>();\n");
                block.append("        try (PreparedStatement ps = conn.prepareStatement(").append(constantName).append(")) {\n");
                block.append("            ps.setInt(1, ").append(StringUtils.toCamelCase(fkColumn, naming.getUppercaseAcronyms(), false)).append(");\n");
                block.append("            try (ResultSet rs = ps.executeQuery()) {\n");
                block.append("                while (rs.next()) list.add(extract(rs));\n");
                block.append("            }\n");
                block.append("        }\n");
                block.append("        return list;\n");
                block.append("    }");

                m.setBody(StaticJavaParser.parseBlock(block.toString()));
            }
        }
    }

    private static void createUpdateMethod(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            String modelClassName,
            String pkField,
            String idType,
            List<ColumnInfo> columnsInfo,
            NamingStrategyConfig naming) {

        MethodDeclaration m = daoClass.addMethod("update", Modifier.Keyword.PUBLIC);
        m.setType("boolean");
        m.addParameter("Connection", "conn");
        m.addParameter(modelClassName, StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false));
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        List<ColumnInfo> updateCols = columnsInfo.stream()
                .filter(c -> !c.name.equalsIgnoreCase(pkField))
                .collect(Collectors.toList());

        String paramName = StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false);

        StringBuilder block = new StringBuilder();
        block.append("{\n");
        block.append("        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {\n");

        // Set update parameters
        for (int i = 0; i < updateCols.size(); i++) {
            ColumnInfo c = updateCols.get(i);
            String getter = paramName + ".get" + StringUtils.toCamelCase(c.name, naming.getUppercaseAcronyms(), true) + "()";
            int idx = i + 1;

            if (c.isForeignKey) {
                String baseName = c.name.toLowerCase().endsWith("_id") ? c.name.substring(0, c.name.length() - 3) : c.name;
                String relationshipName = StringUtils.toCamelCase(baseName, naming.getUppercaseAcronyms(), true);
                String relationGetter = paramName + ".get" + relationshipName + "()";
                String relatedPk = c.referencedTable + "_id";
                String relatedPkCamel = StringUtils.toCamelCase(relatedPk, naming.getUppercaseAcronyms(), true);

                block.append("            if (").append(relationGetter).append(" != null && ")
                        .append(relationGetter).append(".get").append(relatedPkCamel).append("() > 0) {\n");
                block.append("                ps.setInt(").append(idx).append(", ").append(relationGetter)
                        .append(".get").append(relatedPkCamel).append("());\n");
                block.append("            } else {\n");
                block.append("                ps.setNull(").append(idx).append(", Types.INTEGER);\n");
                block.append("            }\n");
            } else if ("java.time.LocalDateTime".equals(c.javaType)) {
                block.append("            ps.setTimestamp(").append(idx).append(", Timestamp.valueOf(\n");
                block.append("                ").append(getter).append(" != null ? ").append(getter)
                        .append(" : java.time.LocalDateTime.now()\n");
                block.append("            ));\n");
            } else if (Arrays.asList("Integer", "Long", "Float", "Double").contains(c.javaType)) {
                block.append("            ").append(c.javaType).append(" val").append(idx).append(" = ").append(getter).append(";\n");
                block.append("            if (val").append(idx).append(" != null) {\n");
                block.append("                ps.").append(getPreparedStatementSetter(c.javaType)).append("(").append(idx).append(", val").append(idx).append(");\n");
                block.append("            } else {\n");
                block.append("                ps.setNull(").append(idx).append(", ").append(getTypesConstant(c.javaType)).append(");\n");
                block.append("            }\n");
            } else {
                block.append("            ps.").append(getPreparedStatementSetter(c.javaType))
                        .append("(").append(idx).append(", ").append(getter).append(");\n");
            }
        }

        // Set PK parameter
        String pkGetter = paramName + ".get" + StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true) + "()";
        block.append("\n");
        block.append("            ps.setInt(").append(updateCols.size() + 1).append(", ").append(pkGetter).append(");\n");

        block.append("\n");
        block.append("            return ps.executeUpdate() > 0;\n");
        block.append("        }\n");
        block.append("    }");

        m.setBody(StaticJavaParser.parseBlock(block.toString()));
    }

    private static void createDeleteMethod(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            String pkField,
            String idType,
            NamingStrategyConfig naming) {

        MethodDeclaration m = daoClass.addMethod("deleteById", Modifier.Keyword.PUBLIC);
        m.setType("boolean");
        m.addParameter("Connection", "conn");
        m.addParameter(mapJavaTypeToMethod(idType), "id");
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        StringBuilder block = new StringBuilder();
        block.append("{\n");
        block.append("        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {\n");
        block.append("            ps.setInt(1, id);\n");
        block.append("            return ps.executeUpdate() > 0;\n");
        block.append("        }\n");
        block.append("    }");

        m.setBody(StaticJavaParser.parseBlock(block.toString()));
    }

    private static void createExtractMethod(
            ClassOrInterfaceDeclaration daoClass,
            String modelClassName,
            List<ColumnInfo> columnsInfo,
            NamingStrategyConfig naming) {

        MethodDeclaration m = daoClass.addMethod("extract", Modifier.Keyword.PRIVATE);
        m.setType(modelClassName);
        m.addParameter("ResultSet", "rs");
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        String objectName = StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false);

        StringBuilder block = new StringBuilder();
        block.append("{\n");
        block.append("        ").append(modelClassName).append(" ").append(objectName)
                .append(" = new ").append(modelClassName).append("();\n");

        // Set all fields
        for (ColumnInfo c : columnsInfo) {
            String setter = objectName + ".set" + StringUtils.toCamelCase(c.name, naming.getUppercaseAcronyms(), true);

            if ("java.time.LocalDateTime".equals(c.javaType)) {
                block.append("        Timestamp ").append(c.name).append(" = rs.getTimestamp(\"").append(c.name).append("\");\n");
                block.append("        if (").append(c.name).append(" != null) ").append(setter).append("(").append(c.name).append(".toLocalDateTime());\n");
            } else if (c.isForeignKey) {
                String baseName = c.name.toLowerCase().endsWith("_id") ? c.name.substring(0, c.name.length() - 3) : c.name;
                String relationshipName = StringUtils.toCamelCase(baseName, naming.getUppercaseAcronyms(), true);
                String relatedObjectName = StringUtils.toCamelCase(baseName, naming.getUppercaseAcronyms(), false);
                String relatedClass = StringUtils.toCamelCase(c.referencedTable, naming.getUppercaseAcronyms(), true) + "DTO";
                String relatedPk = c.referencedTable + "_id";
                String relatedPkCamel = StringUtils.toCamelCase(relatedPk, naming.getUppercaseAcronyms(), true);

                block.append("        Integer ").append(c.name).append(" = rs.getObject(\"").append(c.name).append("\", Integer.class);\n");
                block.append("        ").append(setter).append("(").append(c.name).append(");\n");
                block.append("        if (").append(c.name).append(" != null && ").append(c.name).append(" > 0) {\n");
                block.append("            ").append(relatedClass).append(" ").append(relatedObjectName)
                        .append(" = new ").append(relatedClass).append("();\n");
                block.append("            ").append(relatedObjectName)
                        .append(".set").append(relatedPkCamel)
                        .append("(").append(c.name).append(");\n");
                block.append("            ").append(objectName)
                        .append(".set").append(relationshipName)
                        .append("(").append(relatedObjectName).append(");\n");
                block.append("        }\n");
            } else if (Arrays.asList("Integer", "Long", "Float", "Double").contains(c.javaType)) {
                block.append("        ").append(c.javaType).append(" ").append(c.name).append(" = rs.getObject(\"").append(c.name).append("\", ").append(c.javaType).append(".class);\n");
                block.append("        ").append(setter).append("(").append(c.name).append(");\n");
            } else {
                block.append("        ").append(setter).append("(rs.")
                        .append(getResultSetGetter(c.javaType)).append("(\"").append(c.name).append("\"));\n");
            }
        }

        block.append("        return ").append(objectName).append(";\n");
        block.append("    }");

        m.setBody(StaticJavaParser.parseBlock(block.toString()));
    }


    private static void writeToFile(TargetConfig target, String packageName, String className, CompilationUnit cu) throws IOException {
        Path outputPath = Paths.get(target.getOutputDirectory(), packageName.replace(".", "/"), className + ".java");
        Files.createDirectories(outputPath.getParent());
        Files.writeString(outputPath, cu.toString());
        System.out.println("Generated DAO: " + outputPath);
    }

    /* ---------- utility methods ---------- */

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

    private static String mapJavaTypeToMethod(String javaType) {
        return switch (javaType) {
            case "Integer" -> "int";
            case "Long" -> "long";
            case "Float" -> "float";
            case "Double" -> "double";
            default -> javaType;
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

    private static String getTypesConstant(String javaType) {
        return switch (javaType) {
            case "Integer" -> "Types.INTEGER";
            case "Long" -> "Types.BIGINT";
            case "Float" -> "Types.FLOAT";
            case "Double" -> "Types.DOUBLE";
            default -> "Types.OTHER";
        };
    }
}