package com.bsit.codegeneration.parser;

import com.bsit.codegeneration.model.*;
import com.bsit.codegeneration.util.Relationship;
import com.bsit.codegeneration.util.Relationship.Type;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class JdbiDaoGenerator {

    private static class ColumnInfo {
        final String columnName;
        final String javaType;
        final String dbType;
        final boolean isAutoIncrement;
        final String defaultValue;
        final boolean isGenerated;
        final boolean isPrimaryKey;
        final boolean isForeignKey;

        public ColumnInfo(String columnName, String javaType, String dbType,
                          boolean isAutoIncrement, String defaultValue,
                          boolean isGenerated, boolean isPrimaryKey, boolean isForeignKey) {
            this.columnName = columnName;
            this.javaType = javaType;
            this.dbType = dbType;
            this.isAutoIncrement = isAutoIncrement;
            this.defaultValue = defaultValue;
            this.isGenerated = isGenerated;
            this.isPrimaryKey = isPrimaryKey;
            this.isForeignKey = isForeignKey;
        }

        @Override
        public String toString() {
            return "ColumnInfo{columnName='" + columnName + "', javaType='" + javaType +
                    "', isPrimaryKey=" + isPrimaryKey + ", isGenerated=" + isGenerated + '}';
        }
    }

    private static class TableMetadata {
        final String tableName;
        final List<ColumnInfo> columns;
        final String primaryKeyColumn;
        final String primaryKeyCamel;
        final String primaryKeyType;
        final boolean hasAutoPk;
        final Map<String, Relationship> relationships;
        final boolean isJoinTable;

        public TableMetadata(String tableName, List<ColumnInfo> columns, String primaryKeyColumn,
                             String primaryKeyCamel, String primaryKeyType, boolean hasAutoPk,
                             Map<String, Relationship> relationships, boolean isJoinTable) {
            this.tableName = tableName;
            this.columns = columns;
            this.primaryKeyColumn = primaryKeyColumn;
            this.primaryKeyCamel = primaryKeyCamel;
            this.primaryKeyType = primaryKeyType;
            this.hasAutoPk = hasAutoPk;
            this.relationships = relationships != null ? relationships : new HashMap<>();
            this.isJoinTable = isJoinTable;
        }
    }

    public static void generateDao(String tableName, ResultSet columnsRs, DatabaseConfig dbConfig,
                                   TargetConfig target, DaoConfig daoConfig,
                                   List<Relationship> relationships, List<Relationship> reverseRelationships)
            throws IOException, SQLException {

        NamingStrategyConfig naming = dbConfig.getNamingStrategy();
        String entityClassName = generateEntityClassName(tableName, naming);
        String daoClassName = entityClassName + "Dao";

        // Create compilation unit with proper imports
        CompilationUnit cu = createCompilationUnit(entityClassName);

        // Create DAO interface
        ClassOrInterfaceDeclaration dao = cu.addInterface(daoClassName)
                .setPublic(true);

        // Process table metadata
        TableMetadata metadata = processTableMetadata(tableName, columnsRs, dbConfig,
                naming, relationships);

        // Debug logging
        logTableInfo(metadata);

        // Generate DAO methods
        if (metadata.isJoinTable) {
            generateJoinTableDao(dao, metadata, naming, entityClassName);
        } else {
            generateStandardDao(dao, metadata, naming, entityClassName);
        }

        // Write to file
        writeToFile(cu, target, daoClassName);
    }

    private static String generateEntityClassName(String tableName, NamingStrategyConfig naming) {
        String rawClassName = stripPrefix(tableName, naming.getStripPrefixes());
        return toCamelCase(rawClassName, naming.getUppercaseAcronyms(), true);
    }

    private static CompilationUnit createCompilationUnit(String entityClassName) {
        CompilationUnit cu = new CompilationUnit();
        cu.setPackageDeclaration("com.bsit.codegeneration.jdbidao");

        // Add JDBI imports
        cu.addImport("org.jdbi.v3.sqlobject.batch.SqlBatch"); // NEW: Bulk operations
        cu.addImport("org.jdbi.v3.sqlobject.customizer.Bind");
        cu.addImport("org.jdbi.v3.sqlobject.customizer.BindBean");
        cu.addImport("org.jdbi.v3.sqlobject.statement.GetGeneratedKeys");
        cu.addImport("org.jdbi.v3.sqlobject.statement.SqlQuery");
        cu.addImport("org.jdbi.v3.sqlobject.statement.SqlUpdate");
        cu.addImport("org.jdbi.v3.sqlobject.config.RegisterBeanMapper");

        // Add Java imports
        cu.addImport("java.util.List");
        cu.addImport("java.util.Optional");
        cu.addImport("java.util.Collection"); // NEW: For bulk operations

        // Add entity import
        cu.addImport("com.bsit.codegeneration.entity." + entityClassName);

        return cu;
    }

    private static TableMetadata processTableMetadata(String tableName, ResultSet columnsRs,
                                                      DatabaseConfig dbConfig, NamingStrategyConfig naming,
                                                      List<Relationship> relationships) throws SQLException {

        DatabaseMetaData dbMetaData = columnsRs.getStatement().getConnection().getMetaData();

        // Get primary and foreign keys
        Set<String> pkColumns = getPrimaryKeys(dbMetaData, dbConfig.getSchema(), tableName);
        Set<String> fkColumns = getForeignKeys(dbMetaData, dbConfig.getSchema(), tableName);

        // Process columns
        List<ColumnInfo> columns = processColumns(columnsRs, pkColumns, fkColumns);

        // Determine primary key info
        String primaryKeyColumn = pkColumns.isEmpty() ? tableName + "_id" : pkColumns.iterator().next();
        String primaryKeyCamel = toCamelCase(primaryKeyColumn, naming.getUppercaseAcronyms(), false);

        ColumnInfo pkColumn = columns.stream()
                .filter(c -> c.isPrimaryKey)
                .findFirst()
                .orElse(null);

        String primaryKeyType = pkColumn != null ? pkColumn.javaType : "int";
        boolean hasAutoPk = pkColumn != null && pkColumn.isAutoIncrement;

        // Process relationships
        Map<String, Relationship> relationshipMap = processRelationships(relationships);

        // Determine if join table
        boolean isJoinTable = isJoinTable(columns, relationshipMap);

        return new TableMetadata(tableName, columns, primaryKeyColumn, primaryKeyCamel,
                primaryKeyType, hasAutoPk, relationshipMap, isJoinTable);
    }

    private static Set<String> getPrimaryKeys(DatabaseMetaData metaData, String schema, String tableName)
            throws SQLException {
        Set<String> pkColumns = new HashSet<>();
        try (ResultSet pks = metaData.getPrimaryKeys(null, schema, tableName)) {
            while (pks.next()) {
                pkColumns.add(pks.getString("COLUMN_NAME"));
            }
        }
        return pkColumns;
    }

    private static Set<String> getForeignKeys(DatabaseMetaData metaData, String schema, String tableName)
            throws SQLException {
        Set<String> fkColumns = new HashSet<>();
        try (ResultSet fks = metaData.getImportedKeys(null, schema, tableName)) {
            while (fks.next()) {
                fkColumns.add(fks.getString("FKCOLUMN_NAME"));
            }
        }
        return fkColumns;
    }

    private static List<ColumnInfo> processColumns(ResultSet columnsRs, Set<String> pkColumns,
                                                   Set<String> fkColumns) throws SQLException {
        List<ColumnInfo> columns = new ArrayList<>();

        while (columnsRs.next()) {
            String columnName = columnsRs.getString("COLUMN_NAME");
            String dbType = columnsRs.getString("TYPE_NAME");
            String javaType = mapDbTypeToJava(dbType, columnName, fkColumns);
            boolean isAutoIncrement = "YES".equals(columnsRs.getString("IS_AUTOINCREMENT"));
            String defaultValue = columnsRs.getString("COLUMN_DEF");
            boolean isPrimaryKey = pkColumns.contains(columnName);
            boolean isForeignKey = fkColumns.contains(columnName);
            boolean isGenerated = isAutoIncrement ||
                    columnName.toLowerCase().matches(".*(created|updated|last_update).*");

            columns.add(new ColumnInfo(columnName, javaType, dbType, isAutoIncrement,
                    defaultValue, isGenerated, isPrimaryKey, isForeignKey));
        }

        return columns;
    }

    private static Map<String, Relationship> processRelationships(List<Relationship> relationships) {
        Map<String, Relationship> relationshipMap = new HashMap<>();

        if (relationships != null) {
            for (Relationship rel : relationships) {
                if (rel.getType() == Type.MANY_TO_ONE) {
                    relationshipMap.putIfAbsent(rel.getFkColumn(), rel);
                }
            }
        }

        return relationshipMap;
    }

    private static boolean isJoinTable(List<ColumnInfo> columns, Map<String, Relationship> relationships) {
        long fkCount = columns.stream().filter(c -> c.isForeignKey).count();
        long nonGeneratedNonPkNonFkCount = columns.stream()
                .filter(c -> !c.isGenerated && !c.isPrimaryKey && !c.isForeignKey)
                .count();
        long pkNonFkCount = columns.stream()
                .filter(c -> c.isPrimaryKey && !c.isForeignKey)
                .count();

        return relationships.size() == 2 &&
                fkCount == 2 &&
                nonGeneratedNonPkNonFkCount == 0 &&
                pkNonFkCount == 0;
    }

    private static void generateStandardDao(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                            NamingStrategyConfig naming, String entityClassName) {

        // Generate single record CRUD methods
        generateInsert(dao, metadata, entityClassName, naming);
        generateFindById(dao, metadata, entityClassName);
        generateFindAllMethods(dao, metadata, entityClassName, naming);
        generateUpdate(dao, metadata, entityClassName, naming);
        generateDeleteById(dao, metadata);
        generateCountAll(dao, metadata.tableName);

        // Generate bulk operations
        generateBulkInsert(dao, metadata, entityClassName, naming);
        generateBulkUpdate(dao, metadata, entityClassName, naming);
        generateBulkDelete(dao, metadata, entityClassName, naming);

        // Generate additional bulk helpers
        generateBulkFindByIds(dao, metadata, entityClassName);

        // Generate relationship finders
        generateRelationshipFinders(dao, metadata, entityClassName, naming);
    }

    private static void generateInsert(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                       String entityClassName, NamingStrategyConfig naming) {

        List<ColumnInfo> insertColumns = metadata.columns.stream()
                .filter(c -> !c.isGenerated && !(metadata.hasAutoPk && c.isPrimaryKey))
                .collect(Collectors.toList());

        if (insertColumns.isEmpty()) {
            return; // No columns to insert
        }

        String columnList = insertColumns.stream()
                .map(c -> c.columnName)
                .collect(Collectors.joining(", "));

        String valuesList = insertColumns.stream()
                .map(c -> ":" + toCamelCase(c.columnName, naming.getUppercaseAcronyms(), false))
                .collect(Collectors.joining(", "));

        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)",
                metadata.tableName, columnList, valuesList);

        MethodDeclaration method = dao.addMethod("insert", Modifier.Keyword.PUBLIC);
        method.setType(metadata.hasAutoPk ? metadata.primaryKeyType : "int");

        // Add Javadoc
        method.setJavadocComment("Inserts a new " + entityClassName + (metadata.hasAutoPk ? " and returns the generated ID." : " and returns the number of affected rows."));

        // Add SQL annotation
        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlUpdate"), new StringLiteralExpr(sql)));

        // Add GetGeneratedKeys if needed
        if (metadata.hasAutoPk) {
            method.addMarkerAnnotation("GetGeneratedKeys");
        }

        // Add parameters
        if (insertColumns.size() > 3) {
            // Use @BindBean for complex objects
            method.addParameter(new Parameter()
                    .setType(entityClassName)
                    .setName(toCamelCase(entityClassName, naming.getUppercaseAcronyms(), false))
                    .addMarkerAnnotation("BindBean"));
        } else {
            // Use individual @Bind for simple cases
            for (ColumnInfo col : insertColumns) {
                String paramName = toCamelCase(col.columnName, naming.getUppercaseAcronyms(), false);
                method.addParameter(new Parameter()
                        .setType(col.javaType)
                        .setName(paramName)
                        .addAnnotation(new SingleMemberAnnotationExpr(
                                new Name("Bind"), new StringLiteralExpr(paramName))));
            }
        }

        method.setBody(null);
    }

    // NEW: Generate bulk insert methods
    private static void generateBulkInsert(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                           String entityClassName, NamingStrategyConfig naming) {

        List<ColumnInfo> insertColumns = metadata.columns.stream()
                .filter(c -> !c.isGenerated && !(metadata.hasAutoPk && c.isPrimaryKey))
                .collect(Collectors.toList());

        if (insertColumns.isEmpty()) {
            return; // No columns to insert
        }

        String columnList = insertColumns.stream()
                .map(c -> c.columnName)
                .collect(Collectors.joining(", "));

        String valuesList = insertColumns.stream()
                .map(c -> ":" + toCamelCase(c.columnName, naming.getUppercaseAcronyms(), false))
                .collect(Collectors.joining(", "));

        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)",
                metadata.tableName, columnList, valuesList);

        // Method 1: Bulk insert with entity list
        MethodDeclaration bulkInsertEntities = dao.addMethod("bulkInsert", Modifier.Keyword.PUBLIC);
        bulkInsertEntities.setType(metadata.hasAutoPk ? metadata.primaryKeyType + "[]" : "int[]");

        bulkInsertEntities.setJavadocComment("Bulk insert multiple " + entityClassName + " entities" +
                (metadata.hasAutoPk ? " and returns generated IDs." : " and returns affected row counts."));

        bulkInsertEntities.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlBatch"), new StringLiteralExpr(sql)));

        if (metadata.hasAutoPk) {
            bulkInsertEntities.addMarkerAnnotation("GetGeneratedKeys");
        }

        bulkInsertEntities.addParameter(new Parameter()
                .setType(String.format("List<%s>", entityClassName))
                .setName(toCamelCase(entityClassName, naming.getUppercaseAcronyms(), false) + "s")
                .addMarkerAnnotation("BindBean"));

        bulkInsertEntities.setBody(null);

        // Method 2: Bulk insert with individual parameter lists (for simple cases)
        if (insertColumns.size() <= 3) {
            MethodDeclaration bulkInsertParams = dao.addMethod("bulkInsertParams", Modifier.Keyword.PUBLIC);
            bulkInsertParams.setType(metadata.hasAutoPk ? metadata.primaryKeyType + "[]" : "int[]");

            bulkInsertParams.setJavadocComment("Bulk insert with individual parameter lists" +
                    (metadata.hasAutoPk ? " and returns generated IDs." : " and returns affected row counts."));

            bulkInsertParams.addAnnotation(new SingleMemberAnnotationExpr(
                    new Name("SqlBatch"), new StringLiteralExpr(sql)));

            if (metadata.hasAutoPk) {
                bulkInsertParams.addMarkerAnnotation("GetGeneratedKeys");
            }

            for (ColumnInfo col : insertColumns) {
                String paramName = toCamelCase(col.columnName, naming.getUppercaseAcronyms(), false);
                bulkInsertParams.addParameter(new Parameter()
                        .setType(String.format("List<%s>", getWrapperType(col.javaType)))
                        .setName(paramName + "s")
                        .addAnnotation(new SingleMemberAnnotationExpr(
                                new Name("Bind"), new StringLiteralExpr(paramName))));
            }

            bulkInsertParams.setBody(null);
        }
    }

    // NEW: Generate bulk update methods
    private static void generateBulkUpdate(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                           String entityClassName, NamingStrategyConfig naming) {

        List<ColumnInfo> updateColumns = metadata.columns.stream()
                .filter(c -> !c.isGenerated && !c.isPrimaryKey)
                .collect(Collectors.toList());

        if (updateColumns.isEmpty()) {
            return; // No columns to update
        }

        String setClause = updateColumns.stream()
                .map(c -> c.columnName + " = :" + toCamelCase(c.columnName, naming.getUppercaseAcronyms(), false))
                .collect(Collectors.joining(", "));

        String sql = String.format("UPDATE %s SET %s WHERE %s = :%s",
                metadata.tableName, setClause,
                metadata.primaryKeyColumn, metadata.primaryKeyCamel);

        // Method 1: Bulk update with entity list
        MethodDeclaration bulkUpdate = dao.addMethod("bulkUpdate", Modifier.Keyword.PUBLIC);
        bulkUpdate.setType("int[]");

        bulkUpdate.setJavadocComment("Bulk update multiple " + entityClassName + " entities and returns affected row counts for each.");

        bulkUpdate.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlBatch"), new StringLiteralExpr(sql)));

        bulkUpdate.addParameter(new Parameter()
                .setType(String.format("List<%s>", entityClassName))
                .setName(toCamelCase(entityClassName, naming.getUppercaseAcronyms(), false) + "s")
                .addMarkerAnnotation("BindBean"));

        bulkUpdate.setBody(null);

        // Method 2: Bulk update with individual parameter lists (for simple cases)
        if (updateColumns.size() <= 3) {
            MethodDeclaration bulkUpdateParams = dao.addMethod("bulkUpdateParams", Modifier.Keyword.PUBLIC);
            bulkUpdateParams.setType("int[]");

            bulkUpdateParams.setJavadocComment("Bulk update with individual parameter lists and returns affected row counts for each.");

            bulkUpdateParams.addAnnotation(new SingleMemberAnnotationExpr(
                    new Name("SqlBatch"), new StringLiteralExpr(sql)));

            // Add update columns parameters
            for (ColumnInfo col : updateColumns) {
                String paramName = toCamelCase(col.columnName, naming.getUppercaseAcronyms(), false);
                bulkUpdateParams.addParameter(new Parameter()
                        .setType(String.format("List<%s>", getWrapperType(col.javaType)))
                        .setName(paramName + "s")
                        .addAnnotation(new SingleMemberAnnotationExpr(
                                new Name("Bind"), new StringLiteralExpr(paramName))));
            }

            // Add primary key parameter
            bulkUpdateParams.addParameter(new Parameter()
                    .setType(String.format("List<%s>", getWrapperType(metadata.primaryKeyType)))
                    .setName(metadata.primaryKeyCamel + "s")
                    .addAnnotation(new SingleMemberAnnotationExpr(
                            new Name("Bind"), new StringLiteralExpr(metadata.primaryKeyCamel))));

            bulkUpdateParams.setBody(null);
        }
    }

    // NEW: Generate bulk delete methods
    private static void generateBulkDelete(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                           String entityClassName, NamingStrategyConfig naming) {

        // Method 1: Bulk delete by IDs (single query with IN clause)
        MethodDeclaration bulkDeleteByIds = dao.addMethod("bulkDeleteByIds", Modifier.Keyword.PUBLIC);
        bulkDeleteByIds.setType("int");

        bulkDeleteByIds.setJavadocComment("Bulk delete multiple records by IDs using IN clause and returns total affected rows.");

        String inClauseSql = String.format("DELETE FROM %s WHERE %s IN (<ids>)",
                metadata.tableName, metadata.primaryKeyColumn);

        bulkDeleteByIds.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlUpdate"), new StringLiteralExpr(inClauseSql)));

        bulkDeleteByIds.addParameter(new Parameter()
                .setType(String.format("Collection<%s>", getWrapperType(metadata.primaryKeyType)))
                .setName("ids")
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr("ids"))));

        bulkDeleteByIds.setBody(null);

        // Method 2: Bulk delete by IDs (batch processing)
        MethodDeclaration bulkDeleteBatch = dao.addMethod("bulkDeleteBatch", Modifier.Keyword.PUBLIC);
        bulkDeleteBatch.setType("int[]");

        bulkDeleteBatch.setJavadocComment("Bulk delete multiple records using batch processing and returns affected row counts for each.");

        String batchSql = String.format("DELETE FROM %s WHERE %s = :id",
                metadata.tableName, metadata.primaryKeyColumn);

        bulkDeleteBatch.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlBatch"), new StringLiteralExpr(batchSql)));

        bulkDeleteBatch.addParameter(new Parameter()
                .setType(String.format("List<%s>", getWrapperType(metadata.primaryKeyType)))
                .setName("ids")
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr("id"))));

        bulkDeleteBatch.setBody(null);
    }

    // NEW: Generate bulk find by IDs method
    private static void generateBulkFindByIds(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                              String entityClassName) {

        MethodDeclaration bulkFindByIds = dao.addMethod("findByIds", Modifier.Keyword.PUBLIC);
        bulkFindByIds.setType(String.format("List<%s>", entityClassName));

        bulkFindByIds.setJavadocComment("Finds multiple " + entityClassName + " records by their IDs.");

        String sql = String.format("SELECT * FROM %s WHERE %s IN (<ids>)",
                metadata.tableName, metadata.primaryKeyColumn);

        bulkFindByIds.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlQuery"), new StringLiteralExpr(sql)));

        bulkFindByIds.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("RegisterBeanMapper"),
                new ClassExpr(new ClassOrInterfaceType(null, entityClassName))));

        bulkFindByIds.addParameter(new Parameter()
                .setType(String.format("Collection<%s>", getWrapperType(metadata.primaryKeyType)))
                .setName("ids")
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr("ids"))));

        bulkFindByIds.setBody(null);
    }

    private static void generateFindById(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                         String entityClassName) {
        String sql = String.format("SELECT * FROM %s WHERE %s = :id",
                metadata.tableName, metadata.primaryKeyColumn);

        MethodDeclaration method = dao.addMethod("findById", Modifier.Keyword.PUBLIC);
        method.setType(String.format("Optional<%s>", entityClassName));

        // Add Javadoc
        method.setJavadocComment("Finds a " + entityClassName + " by its ID.");

        // Add annotations
        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlQuery"), new StringLiteralExpr(sql)));

        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("RegisterBeanMapper"),
                new ClassExpr(new ClassOrInterfaceType(null, entityClassName))));

        // Add parameter
        method.addParameter(new Parameter()
                .setType(metadata.primaryKeyType)
                .setName("id")
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr("id"))));

        method.setBody(null);
    }

    private static void generateFindAllMethods(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                               String entityClassName, NamingStrategyConfig naming) {

        // Generate standard findAll method (no parameters)
        generateStandardFindAll(dao, metadata.tableName, entityClassName);

        // Generate paginated findAll method
        generatePaginatedFindAll(dao, metadata, entityClassName, naming);
    }

    private static void generateStandardFindAll(ClassOrInterfaceDeclaration dao, String tableName,
                                                String entityClassName) {
        String sql = "SELECT * FROM " + tableName;

        MethodDeclaration method = dao.addMethod("findAll", Modifier.Keyword.PUBLIC);
        method.setType(String.format("List<%s>", entityClassName));

        // Add Javadoc
        method.setJavadocComment("Retrieves all records from the table. Use with caution for large tables.");

        // Add annotations
        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlQuery"), new StringLiteralExpr(sql)));

        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("RegisterBeanMapper"),
                new ClassExpr(new ClassOrInterfaceType(null, entityClassName))));

        method.setBody(null);
    }

    private static void generatePaginatedFindAll(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                                 String entityClassName, NamingStrategyConfig naming) {

        // Determine the primary ordering column (prefer primary key or first column)
        String orderByColumn = metadata.primaryKeyColumn;
        if (orderByColumn == null && !metadata.columns.isEmpty()) {
            orderByColumn = metadata.columns.get(0).columnName;
        }

        String sql = String.format("SELECT * FROM %s ORDER BY %s LIMIT :limit OFFSET :offset",
                metadata.tableName, orderByColumn != null ? orderByColumn : "1");

        MethodDeclaration method = dao.addMethod("findAllPaged", Modifier.Keyword.PUBLIC);
        method.setType(String.format("List<%s>", entityClassName));

        // Add Javadoc
        method.setJavadocComment("Retrieves paginated records from the table.");

        // Add annotations
        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlQuery"), new StringLiteralExpr(sql)));

        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("RegisterBeanMapper"),
                new ClassExpr(new ClassOrInterfaceType(null, entityClassName))));

        // Add pagination parameters
        method.addParameter(new Parameter()
                .setType("int")
                .setName("limit")
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr("limit"))));

        method.addParameter(new Parameter()
                .setType("int")
                .setName("offset")
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr("offset"))));

        method.setBody(null);
    }

    private static void generateCountAll(ClassOrInterfaceDeclaration dao, String tableName) {
        String sql = String.format("SELECT COUNT(*) FROM %s", tableName);

        MethodDeclaration method = dao.addMethod("countAll", Modifier.Keyword.PUBLIC);
        method.setType("long");

        // Add Javadoc
        method.setJavadocComment("Returns the total count of records in the table.");

        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlQuery"), new StringLiteralExpr(sql)));

        method.setBody(null);
    }

    private static void generateUpdate(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                       String entityClassName, NamingStrategyConfig naming) {

        List<ColumnInfo> updateColumns = metadata.columns.stream()
                .filter(c -> !c.isGenerated && !c.isPrimaryKey)
                .collect(Collectors.toList());

        if (updateColumns.isEmpty()) {
            return; // No columns to update
        }

        String setClause = updateColumns.stream()
                .map(c -> c.columnName + " = :" + toCamelCase(c.columnName, naming.getUppercaseAcronyms(), false))
                .collect(Collectors.joining(", "));

        String sql = String.format("UPDATE %s SET %s WHERE %s = :%s",
                metadata.tableName, setClause,
                metadata.primaryKeyColumn, metadata.primaryKeyCamel);

        MethodDeclaration method = dao.addMethod("update", Modifier.Keyword.PUBLIC);
        method.setType("int");

        // Add Javadoc
        method.setJavadocComment("Updates a " + entityClassName + " and returns the number of affected rows.");

        // Add SQL annotation
        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlUpdate"), new StringLiteralExpr(sql)));

        // Add parameter
        method.addParameter(new Parameter()
                .setType(entityClassName)
                .setName(toCamelCase(entityClassName, naming.getUppercaseAcronyms(), false))
                .addMarkerAnnotation("BindBean"));

        method.setBody(null);
    }

    private static void generateDeleteById(ClassOrInterfaceDeclaration dao, TableMetadata metadata) {
        String sql = String.format("DELETE FROM %s WHERE %s = :id",
                metadata.tableName, metadata.primaryKeyColumn);

        MethodDeclaration method = dao.addMethod("deleteById", Modifier.Keyword.PUBLIC);
        method.setType("int");

        // Add Javadoc
        method.setJavadocComment("Deletes a record by ID and returns the number of affected rows.");

        // Add SQL annotation
        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlUpdate"), new StringLiteralExpr(sql)));

        // Add parameter
        method.addParameter(new Parameter()
                .setType(metadata.primaryKeyType)
                .setName("id")
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr("id"))));

        method.setBody(null);
    }

    private static void generateRelationshipFinders(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                                    String entityClassName, NamingStrategyConfig naming) {

        for (Relationship relationship : metadata.relationships.values()) {
            String fkColumn = relationship.getFkColumn();
            String fkCamel = toCamelCase(fkColumn, naming.getUppercaseAcronyms(), false);
            String methodName = "findBy" + toCamelCase(fkColumn, naming.getUppercaseAcronyms(), true);

            String sql = String.format("SELECT * FROM %s WHERE %s = :%s",
                    metadata.tableName, fkColumn, fkCamel);

            MethodDeclaration method = dao.addMethod(methodName, Modifier.Keyword.PUBLIC);
            method.setType(String.format("List<%s>", entityClassName));

            // Add Javadoc
            method.setJavadocComment("Finds all " + entityClassName + " records by " + fkCamel + ".");

            // Add annotations
            method.addAnnotation(new SingleMemberAnnotationExpr(
                    new Name("SqlQuery"), new StringLiteralExpr(sql)));

            method.addAnnotation(new SingleMemberAnnotationExpr(
                    new Name("RegisterBeanMapper"),
                    new ClassExpr(new ClassOrInterfaceType(null, entityClassName))));

            // Add parameter
            method.addParameter(new Parameter()
                    .setType("int")
                    .setName(fkCamel)
                    .addAnnotation(new SingleMemberAnnotationExpr(
                            new Name("Bind"), new StringLiteralExpr(fkCamel))));

            method.setBody(null);
        }
    }

    private static void generateJoinTableDao(ClassOrInterfaceDeclaration dao, TableMetadata metadata,
                                             NamingStrategyConfig naming, String entityClassName) {

        if (metadata.relationships.size() != 2) {
            throw new IllegalStateException("Join table must have exactly 2 relationships");
        }

        List<Relationship> rels = new ArrayList<>(metadata.relationships.values());
        Relationship rel1 = rels.get(0);
        Relationship rel2 = rels.get(1);

        // Generate insert method
        generateJoinInsert(dao, metadata.tableName, rel1, rel2, naming, entityClassName);

        // Generate finder methods
        generateJoinFinders(dao, metadata.tableName, entityClassName, rel1, rel2, naming);

        // Generate delete method
        generateJoinDelete(dao, metadata.tableName, rel1, rel2, naming, entityClassName);

        // Generate bulk operations for join tables
        generateJoinBulkOperations(dao, metadata.tableName, rel1, rel2, naming, entityClassName);
    }

    private static void generateJoinInsert(ClassOrInterfaceDeclaration dao, String tableName,
                                           Relationship rel1, Relationship rel2, NamingStrategyConfig naming,
                                           String entityClassName) {
        String fk1Camel = toCamelCase(rel1.getFkColumn(), naming.getUppercaseAcronyms(), false);
        String fk2Camel = toCamelCase(rel2.getFkColumn(), naming.getUppercaseAcronyms(), false);

        String sql = String.format("INSERT INTO %s (%s, %s) VALUES (:%s, :%s)",
                tableName, rel1.getFkColumn(), rel2.getFkColumn(), fk1Camel, fk2Camel);

        MethodDeclaration method = dao.addMethod("insert", Modifier.Keyword.PUBLIC);
        method.setType("int");

        // Add Javadoc
        method.setJavadocComment("Inserts a new join record and returns the number of affected rows.");

        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlUpdate"), new StringLiteralExpr(sql)));

        method.addParameter(new Parameter()
                .setType("int")
                .setName(fk1Camel)
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr(fk1Camel))));

        method.addParameter(new Parameter()
                .setType("int")
                .setName(fk2Camel)
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr(fk2Camel))));

        method.setBody(null);
    }

    // NEW: Generate bulk operations for join tables
    private static void generateJoinBulkOperations(ClassOrInterfaceDeclaration dao, String tableName,
                                                   Relationship rel1, Relationship rel2, NamingStrategyConfig naming,
                                                   String entityClassName) {
        String fk1Camel = toCamelCase(rel1.getFkColumn(), naming.getUppercaseAcronyms(), false);
        String fk2Camel = toCamelCase(rel2.getFkColumn(), naming.getUppercaseAcronyms(), false);

        // Bulk insert for join table
        String sql = String.format("INSERT INTO %s (%s, %s) VALUES (:%s, :%s)",
                tableName, rel1.getFkColumn(), rel2.getFkColumn(), fk1Camel, fk2Camel);

        MethodDeclaration bulkInsert = dao.addMethod("bulkInsert", Modifier.Keyword.PUBLIC);
        bulkInsert.setType("int[]");

        bulkInsert.setJavadocComment("Bulk insert join records and returns affected row counts for each.");

        bulkInsert.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlBatch"), new StringLiteralExpr(sql)));

        bulkInsert.addParameter(new Parameter()
                .setType("List<Integer>")
                .setName(fk1Camel + "s")
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr(fk1Camel))));

        bulkInsert.addParameter(new Parameter()
                .setType("List<Integer>")
                .setName(fk2Camel + "s")
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr(fk2Camel))));

        bulkInsert.setBody(null);

        // Bulk delete for join table
        String deleteSql = String.format("DELETE FROM %s WHERE %s = :%s AND %s = :%s",
                tableName, rel1.getFkColumn(), fk1Camel, rel2.getFkColumn(), fk2Camel);

        MethodDeclaration bulkDelete = dao.addMethod("bulkDelete", Modifier.Keyword.PUBLIC);
        bulkDelete.setType("int[]");

        bulkDelete.setJavadocComment("Bulk delete join records and returns affected row counts for each.");

        bulkDelete.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlBatch"), new StringLiteralExpr(deleteSql)));

        bulkDelete.addParameter(new Parameter()
                .setType("List<Integer>")
                .setName(fk1Camel + "s")
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr(fk1Camel))));

        bulkDelete.addParameter(new Parameter()
                .setType("List<Integer>")
                .setName(fk2Camel + "s")
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr(fk2Camel))));

        bulkDelete.setBody(null);
    }

    private static void generateJoinFinders(ClassOrInterfaceDeclaration dao, String tableName,
                                            String entityClassName, Relationship rel1, Relationship rel2,
                                            NamingStrategyConfig naming) {

        String fk1Camel = toCamelCase(rel1.getFkColumn(), naming.getUppercaseAcronyms(), false);
        String fk2Camel = toCamelCase(rel2.getFkColumn(), naming.getUppercaseAcronyms(), false);
        String rel1Class = toCamelCase(rel1.getRelatedTable(), naming.getUppercaseAcronyms(), true);
        String rel2Class = toCamelCase(rel2.getRelatedTable(), naming.getUppercaseAcronyms(), true);

        // Find by first FK
        generateJoinFinder(dao, tableName, entityClassName, rel1.getFkColumn(),
                fk1Camel, "findBy" + rel1Class + "Id");

        // Find by second FK
        generateJoinFinder(dao, tableName, entityClassName, rel2.getFkColumn(),
                fk2Camel, "findBy" + rel2Class + "Id");
    }

    private static void generateJoinFinder(ClassOrInterfaceDeclaration dao, String tableName,
                                           String entityClassName, String fkColumn, String paramName,
                                           String methodName) {
        String sql = String.format("SELECT * FROM %s WHERE %s = :%s", tableName, fkColumn, paramName);

        MethodDeclaration method = dao.addMethod(methodName, Modifier.Keyword.PUBLIC);
        method.setType(String.format("List<%s>", entityClassName));

        // Add Javadoc
        method.setJavadocComment("Finds join records by " + paramName + ".");

        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlQuery"), new StringLiteralExpr(sql)));

        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("RegisterBeanMapper"),
                new ClassExpr(new ClassOrInterfaceType(null, entityClassName))));

        method.addParameter(new Parameter()
                .setType("int")
                .setName(paramName)
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr(paramName))));

        method.setBody(null);
    }

    private static void generateJoinDelete(ClassOrInterfaceDeclaration dao, String tableName,
                                           Relationship rel1, Relationship rel2, NamingStrategyConfig naming,
                                           String entityClassName) {
        String fk1Camel = toCamelCase(rel1.getFkColumn(), naming.getUppercaseAcronyms(), false);
        String fk2Camel = toCamelCase(rel2.getFkColumn(), naming.getUppercaseAcronyms(), false);

        String sql = String.format("DELETE FROM %s WHERE %s = :%s AND %s = :%s",
                tableName, rel1.getFkColumn(), fk1Camel, rel2.getFkColumn(), fk2Camel);

        MethodDeclaration method = dao.addMethod("delete", Modifier.Keyword.PUBLIC);
        method.setType("int");

        // Add Javadoc
        method.setJavadocComment("Deletes a join record and returns the number of affected rows.");

        method.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("SqlUpdate"), new StringLiteralExpr(sql)));

        method.addParameter(new Parameter()
                .setType("int")
                .setName(fk1Camel)
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr(fk1Camel))));

        method.addParameter(new Parameter()
                .setType("int")
                .setName(fk2Camel)
                .addAnnotation(new SingleMemberAnnotationExpr(
                        new Name("Bind"), new StringLiteralExpr(fk2Camel))));

        method.setBody(null);
    }

    // NEW: Helper method to get wrapper types for primitives
    private static String getWrapperType(String primitiveType) {
        return switch (primitiveType.toLowerCase()) {
            case "int" -> "Integer";
            case "long" -> "Long";
            case "double" -> "Double";
            case "float" -> "Float";
            case "boolean" -> "Boolean";
            case "byte" -> "Byte";
            case "short" -> "Short";
            case "char" -> "Character";
            default -> primitiveType; // Already a wrapper or reference type
        };
    }

    private static void logTableInfo(TableMetadata metadata) {
        System.out.println("Table: " + metadata.tableName + ", Columns: " + metadata.columns);
        System.out.println("Primary Key: " + metadata.primaryKeyColumn + " (" + metadata.primaryKeyType + ")");
        System.out.println("Relationships: " + metadata.relationships.values());
    }

    private static void writeToFile(CompilationUnit cu, TargetConfig target, String daoClassName)
            throws IOException {
        String packageName = "com.bsit.codegeneration.jdbidao";
        Path outputPath = Paths.get(target.getOutputDirectory(),
                packageName.replace(".", "/"),
                daoClassName + ".java");
        Files.createDirectories(outputPath.getParent());
        Files.writeString(outputPath, cu.toString());
    }

    // Utility Methods
    private static String stripPrefix(String name, List<String> prefixes) {
        if (name == null || prefixes == null) return name != null ? name : "";

        for (String prefix : prefixes) {
            if (name.startsWith(prefix)) {
                return name.substring(prefix.length());
            }
        }
        return name;
    }

    private static String toCamelCase(String name, List<String> acronyms, boolean capitalizeFirst) {
        if (name == null || name.isEmpty()) return name != null ? name : "";

        String[] parts = name.toLowerCase().split("_");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.isEmpty()) continue;

            if (acronyms != null && acronyms.contains(part.toUpperCase()) && !part.equalsIgnoreCase("id")) {
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
        // Force int for foreign keys and ID columns
        if (columnName != null && (columnName.toLowerCase().endsWith("_id") ||
                (fkColumns != null && fkColumns.contains(columnName)))) {
            return "int";
        }

        if (dbType == null) return "String";

        return switch (dbType.toUpperCase()) {
            case "VARCHAR", "VARCHAR2", "CHAR", "TEXT", "CLOB" -> "String";
            case "NUMBER", "DECIMAL", "NUMERIC", "FLOAT", "DOUBLE" -> "java.math.BigDecimal";
            case "INT", "INTEGER", "SMALLINT", "SERIAL" -> "int";
            case "BIGINT", "BIGSERIAL" -> "long";
            case "DATE", "DATETIME", "TIMESTAMP", "TIMESTAMPTZ" -> "java.sql.Timestamp";
            case "BOOLEAN", "BOOL" -> "boolean";
            case "JSON", "JSONB" -> "String";
            default -> "String";
        };
    }
}
