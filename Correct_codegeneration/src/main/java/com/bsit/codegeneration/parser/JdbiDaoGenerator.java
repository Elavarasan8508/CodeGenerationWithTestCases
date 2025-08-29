package com.bsit.codegeneration.parser;

import com.bsit.codegeneration.model.*;
import com.bsit.codegeneration.model.DaoConfig;
import com.bsit.codegeneration.model.DatabaseConfig;
import com.bsit.codegeneration.model.NamingStrategyConfig;
import com.bsit.codegeneration.model.TargetConfig;
import com.bsit.codegeneration.util.Relationship;
import com.bsit.codegeneration.util.Relationship.Type;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JdbiDaoGenerator {

    private static class ColumnInfo {
        String columnName;
        String javaType;
        String dbType;
        boolean isAutoIncrement;
        String defaultValue;
        boolean isGenerated;
        boolean isPrimaryKey;
        boolean isForeignKey;
    }

    public static void generateDao(String tableName, ResultSet columnsRs, DatabaseConfig dbConfig,
                                   TargetConfig target, DaoConfig daoConfig,
                                   List<Relationship> relationships, List<Relationship> reverseRelationships)
            throws IOException, SQLException {

        NamingStrategyConfig naming = dbConfig.getNamingStrategy();
        String rawClassName = stripPrefix(tableName, naming.getStripPrefixes());
        String entityClassName = toCamelCase(rawClassName, naming.getUppercaseAcronyms(), true);
        String daoClassName = entityClassName + "Dao";
        String packageName = "com.bsit.codegeneration.jdbidao";

        CompilationUnit cu = new CompilationUnit();
        cu.setPackageDeclaration(packageName);

        // Add JDBI imports
        cu.addImport("org.jdbi.v3.sqlobject.customizer.Bind");
        cu.addImport("org.jdbi.v3.sqlobject.customizer.BindBean");
        cu.addImport("org.jdbi.v3.sqlobject.statement.GetGeneratedKeys");
        cu.addImport("org.jdbi.v3.sqlobject.statement.SqlQuery");
        cu.addImport("org.jdbi.v3.sqlobject.statement.SqlUpdate");
        cu.addImport("java.util.List");

        // Import entity
        cu.addImport("com.jdbi.codegeneration.entity." + entityClassName);

        // Create interface
        ClassOrInterfaceDeclaration dao = cu.addInterface(daoClassName).setPublic(true);

        // Collect column info
        List<ColumnInfo> columns = new ArrayList<>();
        String primaryKeyColumn = null;
        String primaryKeyCamel = null;
        String primaryKeyType = "int";
        boolean hasAutoPk = false;

        // Get primary keys
        Set<String> pkColumns = new HashSet<>();
        DatabaseMetaData metaData = columnsRs.getStatement().getConnection().getMetaData();
        try (ResultSet pks = metaData.getPrimaryKeys(null, dbConfig.getSchema(), tableName)) {
            while (pks.next()) {
                String pk = pks.getString("COLUMN_NAME");
                pkColumns.add(pk);
                if (primaryKeyColumn == null) {
                    primaryKeyColumn = pk;
                }
            }
        }

        // Get foreign keys
        Set<String> fkColumns = new HashSet<>();
        try (ResultSet fks = metaData.getImportedKeys(null, dbConfig.getSchema(), tableName)) {
            while (fks.next()) {
                fkColumns.add(fks.getString("FKCOLUMN_NAME"));
            }
        }

        // Process columns
        while (columnsRs.next()) {
            ColumnInfo col = new ColumnInfo();
            col.columnName = columnsRs.getString("COLUMN_NAME");
            col.dbType = columnsRs.getString("TYPE_NAME");
            col.javaType = mapDbTypeToJava(col.dbType, col.columnName, fkColumns);
            col.isAutoIncrement = "YES".equals(columnsRs.getString("IS_AUTOINCREMENT"));
            col.defaultValue = columnsRs.getString("COLUMN_DEF");
            col.isPrimaryKey = pkColumns.contains(col.columnName);
            col.isForeignKey = fkColumns.contains(col.columnName);
            col.isGenerated = col.isAutoIncrement || col.columnName.toLowerCase().equals("last_update");
            columns.add(col);

            if (col.isPrimaryKey) {
                hasAutoPk = col.isAutoIncrement || (col.defaultValue != null && col.defaultValue.toLowerCase().contains("nextval"));
            }
        }

        if (primaryKeyColumn == null) {
            primaryKeyColumn = tableName + "_id";
        }
        primaryKeyCamel = toCamelCase(primaryKeyColumn, naming.getUppercaseAcronyms(), false);

        // Deduplicate relationships by fkColumn
        Map<String, Relationship> uniqueRelationships = new HashMap<>();
        for (Relationship rel : relationships) {
            if (rel.getType() == Type.MANY_TO_ONE && !uniqueRelationships.containsKey(rel.getFkColumn())) {
                uniqueRelationships.put(rel.getFkColumn(), rel);
            }
        }

        // Debug logging
        System.out.println("Table: " + tableName + ", Columns: " + columns);
        System.out.println("Table: " + tableName + ", Relationships: " + uniqueRelationships.values());

        // Detect if join table
        boolean isJoinTable = uniqueRelationships.size() == 2 &&
                uniqueRelationships.values().stream().allMatch(r -> r.getType() == Type.MANY_TO_ONE) &&
                columns.stream().filter(c -> !c.isGenerated && !c.isPrimaryKey && !c.isForeignKey).count() == 0 &&
                columns.stream().filter(c -> c.isForeignKey).count() == 2 &&
                columns.stream().filter(c -> c.isPrimaryKey && !c.isForeignKey).count() == 0;

        if (isJoinTable) {
            generateJoinDao(dao, tableName, entityClassName, columns, new ArrayList<>(uniqueRelationships.values()), naming);
        } else {
            generateStandardDao(dao, tableName, entityClassName, columns, new ArrayList<>(uniqueRelationships.values()), naming, primaryKeyColumn, primaryKeyCamel, hasAutoPk);
        }

        // Write file
        Path outputPath = Paths.get(target.getOutputDirectory(), packageName.replace(".", "/"), daoClassName + ".java");
        Files.createDirectories(outputPath.getParent());
        Files.writeString(outputPath, cu.toString());
    }

    private static void generateJoinDao(ClassOrInterfaceDeclaration dao, String tableName, String entityClassName,
                                        List<ColumnInfo> columns, List<Relationship> relationships,
                                        NamingStrategyConfig naming) {

        Relationship rel1 = relationships.get(0);
        Relationship rel2 = relationships.get(1);

        String fk1Column = rel1.getFkColumn();
        String fk1Camel = toCamelCase(fk1Column, naming.getUppercaseAcronyms(), false);
        String fk1Type = "int";

        String fk2Column = rel2.getFkColumn();
        String fk2Camel = toCamelCase(fk2Column, naming.getUppercaseAcronyms(), false);
        String fk2Type = "int";

        // Insert
        MethodDeclaration insert = dao.addMethod("insert", Modifier.Keyword.PUBLIC);
        insert.setType("void");
        insert.addAnnotation(new SingleMemberAnnotationExpr(new Name("SqlUpdate"),
                new StringLiteralExpr("INSERT INTO " + tableName + " (" + fk1Column + ", " + fk2Column + ") VALUES (:" + fk1Camel + ", :" + fk2Camel + ")")));
        insert.addParameter(new Parameter().setType(fk1Type).setName(fk1Camel).addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr(fk1Camel))));
        insert.addParameter(new Parameter().setType(fk2Type).setName(fk2Camel).addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr(fk2Camel))));
        insert.setBody(null);

        // Find by both
        String rel1Class = toCamelCase(rel1.getRelatedTable(), naming.getUppercaseAcronyms(), true);
        String rel2Class = toCamelCase(rel2.getRelatedTable(), naming.getUppercaseAcronyms(), true);
        MethodDeclaration findByBoth = dao.addMethod("findBy" + rel1Class + "And" + rel2Class, Modifier.Keyword.PUBLIC);
        findByBoth.setType(entityClassName);
        findByBoth.addAnnotation(new SingleMemberAnnotationExpr(new Name("SqlQuery"),
                new StringLiteralExpr("SELECT * FROM " + tableName + " WHERE " + fk1Column + " = :" + fk1Camel + " AND " + fk2Column + " = :" + fk2Camel)));
        findByBoth.addParameter(new Parameter().setType(fk1Type).setName(fk1Camel).addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr(fk1Camel))));
        findByBoth.addParameter(new Parameter().setType(fk2Type).setName(fk2Camel).addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr(fk2Camel))));
        findByBoth.setBody(null);

        // Find by first
        MethodDeclaration findByFirst = dao.addMethod("findBy" + rel1Class + "Id", Modifier.Keyword.PUBLIC);
        findByFirst.setType("List<" + entityClassName + ">");
        findByFirst.addAnnotation(new SingleMemberAnnotationExpr(new Name("SqlQuery"),
                new StringLiteralExpr("SELECT * FROM " + tableName + " WHERE " + fk1Column + " = :" + fk1Camel)));
        findByFirst.addParameter(new Parameter().setType(fk1Type).setName(fk1Camel).addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr(fk1Camel))));
        findByFirst.setBody(null);

        // Find by second
        MethodDeclaration findBySecond = dao.addMethod("findBy" + rel2Class + "Id", Modifier.Keyword.PUBLIC);
        findBySecond.setType("List<" + entityClassName + ">");
        findBySecond.addAnnotation(new SingleMemberAnnotationExpr(new Name("SqlQuery"),
                new StringLiteralExpr("SELECT * FROM " + tableName + " WHERE " + fk2Column + " = :" + fk2Camel)));
        findBySecond.addParameter(new Parameter().setType(fk2Type).setName(fk2Camel).addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr(fk2Camel))));
        findBySecond.setBody(null);

        // Delete by both
        MethodDeclaration delete = dao.addMethod("delete", Modifier.Keyword.PUBLIC);
        delete.setType("void");
        delete.addAnnotation(new SingleMemberAnnotationExpr(new Name("SqlUpdate"),
                new StringLiteralExpr("DELETE FROM " + tableName + " WHERE " + fk1Column + " = :" + fk1Camel + " AND " + fk2Column + " = :" + fk2Camel)));
        delete.addParameter(new Parameter().setType(fk1Type).setName(fk1Camel).addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr(fk1Camel))));
        delete.addParameter(new Parameter().setType(fk2Type).setName(fk2Camel).addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr(fk2Camel))));
        delete.setBody(null);
    }

    private static void generateStandardDao(ClassOrInterfaceDeclaration dao, String tableName, String entityClassName,
                                            List<ColumnInfo> columns, List<Relationship> relationships,
                                            NamingStrategyConfig naming, String primaryKeyColumn,
                                            String primaryKeyCamel, boolean hasAutoPk) {

        // Insert: @BindBean if many fields, else individual @Bind
        List<ColumnInfo> insertCols = columns.stream()
                .filter(c -> !c.isGenerated && !(hasAutoPk && c.isPrimaryKey))
                .toList();
        // Deduplicate columns by columnName
        Set<String> uniqueInsertCols = new LinkedHashSet<>();
        List<ColumnInfo> dedupedInsertCols = insertCols.stream()
                .filter(c -> uniqueInsertCols.add(c.columnName))
                .toList();
        String insertFields = String.join(", ", dedupedInsertCols.stream().map(c -> c.columnName).toList());
        String insertValues = String.join(", ", dedupedInsertCols.stream().map(c -> ":" + toCamelCase(c.columnName, naming.getUppercaseAcronyms(), false)).toList());
        String insertSql = "INSERT INTO " + tableName + " (" + insertFields + ") VALUES (" + insertValues + ")";

        MethodDeclaration insert = dao.addMethod("insert", Modifier.Keyword.PUBLIC);
        insert.setType(hasAutoPk ? "int" : "void");
        insert.addAnnotation(new SingleMemberAnnotationExpr(new Name("SqlUpdate"), new StringLiteralExpr(insertSql)));
        if (hasAutoPk) insert.addMarkerAnnotation("GetGeneratedKeys");
        if (dedupedInsertCols.size() > 3) {
            insert.addParameter(new Parameter().setType(entityClassName).setName(entityClassName.toLowerCase()).addMarkerAnnotation("BindBean"));
        } else {
            for (ColumnInfo col : dedupedInsertCols) {
                String camel = toCamelCase(col.columnName, naming.getUppercaseAcronyms(), false);
                insert.addParameter(new Parameter().setType(col.javaType).setName(camel).addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr(camel))));
            }
        }
        insert.setBody(null);

        // Find by ID
        MethodDeclaration findById = dao.addMethod("findById", Modifier.Keyword.PUBLIC);
        findById.setType(entityClassName);
        findById.addAnnotation(new SingleMemberAnnotationExpr(new Name("SqlQuery"),
                new StringLiteralExpr("SELECT * FROM " + tableName + " WHERE " + primaryKeyColumn + " = :id")));
        findById.addParameter(new Parameter().setType("int").setName("id").addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr("id"))));
        findById.setBody(null);

        // Find all
        MethodDeclaration findAll = dao.addMethod("findAll", Modifier.Keyword.PUBLIC);
        findAll.setType("List<" + entityClassName + ">");
        findAll.addAnnotation(new SingleMemberAnnotationExpr(new Name("SqlQuery"),
                new StringLiteralExpr("SELECT * FROM " + tableName)));
        findAll.setBody(null);

        // Update
        List<ColumnInfo> updateCols = columns.stream()
                .filter(c -> !c.isGenerated && !c.isPrimaryKey)
                .toList();
        // Deduplicate update columns
        Set<String> uniqueUpdateCols = new LinkedHashSet<>();
        List<ColumnInfo> dedupedUpdateCols = updateCols.stream()
                .filter(c -> uniqueUpdateCols.add(c.columnName))
                .toList();
        List<String> setClauses = dedupedUpdateCols.stream()
                .map(c -> c.columnName + " = :" + toCamelCase(c.columnName, naming.getUppercaseAcronyms(), false))
                .toList();
        String updateSql = "UPDATE " + tableName + " SET " + String.join(", ", setClauses) + " WHERE " + primaryKeyColumn + " = :" + primaryKeyCamel;

        MethodDeclaration update = dao.addMethod("update", Modifier.Keyword.PUBLIC);
        update.setType("void");
        update.addAnnotation(new SingleMemberAnnotationExpr(new Name("SqlUpdate"), new StringLiteralExpr(updateSql)));
        update.addParameter(new Parameter().setType(entityClassName).setName(entityClassName.toLowerCase()).addMarkerAnnotation("BindBean"));
        update.setBody(null);

        // Delete by ID
        MethodDeclaration deleteById = dao.addMethod("deleteById", Modifier.Keyword.PUBLIC);
        deleteById.setType("void");
        deleteById.addAnnotation(new SingleMemberAnnotationExpr(new Name("SqlUpdate"),
                new StringLiteralExpr("DELETE FROM " + tableName + " WHERE " + primaryKeyColumn + " = :id")));
        deleteById.addParameter(new Parameter().setType("int").setName("id").addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr("id"))));
        deleteById.setBody(null);

        // Add unique findBy for each MANY_TO_ONE relationship
        Set<String> addedRelations = new HashSet<>();
        for (Relationship rel : relationships) {
            if (rel.getType() == Type.MANY_TO_ONE) {
                String fkColumn = rel.getFkColumn();
                String fkCamel = toCamelCase(fkColumn, naming.getUppercaseAcronyms(), false);
                String relName = toCamelCase(fkColumn, naming.getUppercaseAcronyms(), true);

                // Check uniqueness based on fkColumn
                if (addedRelations.add(fkColumn)) {
                    MethodDeclaration findByRel = dao.addMethod("findBy" + relName, Modifier.Keyword.PUBLIC);
                    findByRel.setType("List<" + entityClassName + ">");
                    findByRel.addAnnotation(new SingleMemberAnnotationExpr(new Name("SqlQuery"),
                            new StringLiteralExpr("SELECT * FROM " + tableName + " WHERE " + fkColumn + " = :" + fkCamel)));
                    findByRel.addParameter(new Parameter().setType("int").setName(fkCamel).addAnnotation(new SingleMemberAnnotationExpr(new Name("Bind"), new StringLiteralExpr(fkCamel))));
                    findByRel.setBody(null);
                }
            }
        }
    }

    private static String stripPrefix(String name, List<String> prefixes) {
        for (String prefix : prefixes) {
            if (name != null && name.startsWith(prefix)) {
                return name.substring(prefix.length());
            }
        }
        return name != null ? name : "";
    }

    private static String toCamelCase(String name, List<String> acronyms, boolean capitalizeFirst) {
        if (name == null || name.isEmpty()) return name;

        String[] parts = name.toLowerCase().split("_");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.isEmpty()) continue;

            // Explicitly prevent 'ID' from being treated as an acronym
            if (acronyms.contains(part.toUpperCase()) && !part.equalsIgnoreCase("id")) {
                result.append(part.toUpperCase());
            } else if (i == 0 && !capitalizeFirst) {
                result.append(part);
            } else {
                result.append(Character.toUpperCase(part.charAt(0)));
                if (part.length() > 1) {
                    result.append(part.substring(1));
                }
            }
        }
        return result.toString();
    }

    private static String mapDbTypeToJava(String dbType, String columnName, Set<String> fkColumns) {
        // Force int for primary keys and foreign keys (columns ending with _id or in fkColumns)
        if (columnName != null && (columnName.toLowerCase().endsWith("_id") || fkColumns.contains(columnName))) {
            return "int";
        }
        if (dbType == null) return "String";
        dbType = dbType.toUpperCase();
        return switch (dbType) {
            case "VARCHAR", "VARCHAR2", "CHAR", "TEXT", "CLOB" -> "String";
            case "NUMBER", "DECIMAL", "NUMERIC", "FLOAT" -> "java.math.BigDecimal";
            case "INT", "INTEGER", "SMALLINT", "SERIAL" -> "int";
            case "BIGINT", "BIGSERIAL" -> "long";
            case "DATE", "DATETIME", "TIMESTAMP", "TIMESTAMPTZ" -> "java.sql.Timestamp";
            case "BOOLEAN", "BOOL" -> "boolean";
            case "JSON", "JSONB" -> "String";
            default -> "String";
        };
    }
}