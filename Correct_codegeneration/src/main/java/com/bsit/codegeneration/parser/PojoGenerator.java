package com.bsit.codegeneration.parser;
import com.bsit.codegeneration.model.*;
import com.bsit.codegeneration.util.Relationship;
import com.bsit.codegeneration.util.StringUtils;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class PojoGenerator {
    public static final String STRING_TYPE = "String";
    // Public entry point to generate full DTO class
    public static void generateDto(
            String tableName,
            ResultSet columns,
            DatabaseConfig dbConfig,
            TargetConfig target,
            DtoConfig dtoConfig,
            List<Relationship> relationships,
            List<Relationship> reverseRelationships)
            throws SQLException, IOException {
        NamingStrategyConfig naming = dbConfig.getNamingStrategy();
        String rawClassName = StringUtils.stripPrefix(tableName, naming.getStripPrefixes());
        String className = StringUtils.toCamelCase(rawClassName, naming.getUppercaseAcronyms(), true);
        CompilationUnit cu = new CompilationUnit();
        String packageName = target.getBasePackage() + ".pojo";
        cu.setPackageDeclaration(packageName);
        // Create the DTO class
        ClassOrInterfaceDeclaration dtoClass = cu.addClass(className).setPublic(true);
        // Map to maintain field ordering
        Map<String, String> fieldTypes = new LinkedHashMap<>();
        Set<String> imports = new HashSet<>();
        Set<String> addedFields = new HashSet<>();
        Set<String> fkFieldNames = new HashSet<>();
        // Collect column field names
        Set<String> columnFieldNames = new HashSet<>();
        columns.beforeFirst();
        while (columns.next()) {
            String colName = columns.getString("COLUMN_NAME");
            String fieldName = StringUtils.toCamelCase(colName, naming.getUppercaseAcronyms(), false);
            columnFieldNames.add(fieldName);
        }
        columns.beforeFirst();
        // Process fields
        processForwardRelationships(dtoConfig, relationships, naming, dtoClass, fieldTypes, addedFields, fkFieldNames, packageName, cu, columnFieldNames);
        processTableColumns(columns, dtoConfig, naming, dtoClass, fieldTypes, addedFields, fkFieldNames, imports);
        processReverseRelationships(dtoConfig, reverseRelationships, naming, dtoClass, fieldTypes, addedFields, packageName, cu, columnFieldNames);
        // Constructor, accessors, and builder
        generateConstructors(dtoClass, fieldTypes);
        imports.forEach(cu::addImport);
        generateAccessors(dtoClass, fieldTypes);
        if (dtoConfig.isBuilderPattern()) {
            generateBuilder(dtoClass, className, fieldTypes);
        }
        // Write to file
        writeToFile(target, packageName, className, cu);
    }
    // Shared utility to extract field-ordered map (useful for syncing with DAO generator)
    public static LinkedHashMap<String, String> extractDtoFieldTypes(
            ResultSet columns,
            List<Relationship> relationships,
            List<Relationship> reverseRelationships,
            DtoConfig dtoConfig,
            DatabaseConfig dbConfig) throws SQLException {
        NamingStrategyConfig naming = dbConfig.getNamingStrategy();
        LinkedHashMap<String, String> fieldTypes = new LinkedHashMap<>();
        Set<String> addedFields = new HashSet<>();
        Set<String> fkFieldNames = new HashSet<>();
        // Collect column field names
        Set<String> columnFieldNames = new HashSet<>();
        columns.beforeFirst();
        while (columns.next()) {
            String colName = columns.getString("COLUMN_NAME");
            String fieldName = StringUtils.toCamelCase(colName, naming.getUppercaseAcronyms(), false);
            columnFieldNames.add(fieldName);
        }
        columns.beforeFirst();
        // Forward relationships
        if (dtoConfig.isIncludeRelationships()) {
            for (Relationship rel : relationships) {
                String relatedClass = StringUtils.toCamelCase(StringUtils.stripPrefix(rel.getRelatedTable(), naming.getStripPrefixes()), naming.getUppercaseAcronyms(), true);
                String fkField = StringUtils.toCamelCase(rel.getFkColumn(), naming.getUppercaseAcronyms(), false);
                if (!fkField.toLowerCase().endsWith("id")) {
                    continue;
                }
                String relationField = fkField.toLowerCase().endsWith("id") ? fkField.substring(0, fkField.length() - 2) : StringUtils.toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false);
                if (relationField.isEmpty()) {
                    relationField = StringUtils.toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false);
                }
                if (columnFieldNames.contains(relationField)) {
                    continue;
                }
                if (addedFields.add(relationField)) {
                    fieldTypes.put(relationField, relatedClass);
                    fkFieldNames.add(fkField);
                }
            }
        }
        // Columns
        columns.beforeFirst();
        while (columns.next()) {
            String colName = columns.getString("COLUMN_NAME");
            String fieldName = StringUtils.toCamelCase(colName, naming.getUppercaseAcronyms(), false);
            String javaType = mapDbTypeToJava(columns.getString("TYPE_NAME"), colName, columns);
            boolean isPk = (colName != null && (colName.equalsIgnoreCase("id") || colName.toLowerCase().endsWith("_id")));
            if (dtoConfig.isRemoveForeignKeyIdFields() && fkFieldNames.contains(fieldName) && !isPk) {
                continue;
            }
            if (addedFields.add(fieldName)) {
                fieldTypes.put(fieldName, javaType);
            }
        }
        columns.beforeFirst();
        // Reverse relationships
        if (dtoConfig.isIncludeReverseRelationships()) {
            for (Relationship rel : reverseRelationships) {
                String relatedClass = StringUtils.toCamelCase(StringUtils.stripPrefix(rel.getRelatedTable(), naming.getStripPrefixes()), naming.getUppercaseAcronyms(), true);
                String fieldName = StringUtils.toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false) + "List";
                if (columnFieldNames.contains(fieldName)) {
                    continue;
                }
                if (addedFields.add(fieldName)) {
                    fieldTypes.put(fieldName, "List<" + relatedClass + ">");
                }
            }
        }
        return fieldTypes;
    }
    // Generalized forward relationships processing
    private static void processForwardRelationships(
            DtoConfig dtoConfig,
            List<Relationship> rels,
            NamingStrategyConfig naming,
            ClassOrInterfaceDeclaration dtoClass,
            Map<String, String> fieldTypes,
            Set<String> addedFields,
            Set<String> fkFieldNames,
            String packageName,
            CompilationUnit cu,
            Set<String> columnFieldNames) {
        if (!dtoConfig.isIncludeRelationships() || rels == null) return;
        for (Relationship rel : rels) {
            String relatedTableName = rel.getRelatedTable();
            if (relatedTableName == null) continue;
            // Use the actual related table name from the relationship
            String relatedClass = StringUtils.toCamelCase(StringUtils.stripPrefix(relatedTableName, naming.getStripPrefixes()), naming.getUppercaseAcronyms(), true);
            String fkField = StringUtils.toCamelCase(rel.getFkColumn(), naming.getUppercaseAcronyms(), false);
            if (!fkField.toLowerCase().endsWith("id")) {
                continue;
            }
            // Generate relationship field name from foreign key column
            String relationField;
            if (fkField != null && fkField.toLowerCase().endsWith("id")) {
                relationField = fkField.substring(0, fkField.length() - 2);
            } else {
                relationField = StringUtils.toCamelCase(relatedTableName, naming.getUppercaseAcronyms(), false);
            }
            // Fallback to using table name if field name is empty
            if (relationField == null || relationField.isEmpty()) {
                relationField = StringUtils.toCamelCase(relatedTableName, naming.getUppercaseAcronyms(), false);
            }
            if (columnFieldNames.contains(relationField)) {
                continue;
            }
            // Skip if field already exists
            if (addedFields.contains(relationField)) {
                fkFieldNames.add(fkField);
                continue;
            }
            // Add the relationship field
            if (addedFields.add(relationField)) {
                dtoClass.addField(relatedClass, relationField, Modifier.Keyword.PRIVATE);
                fieldTypes.put(relationField, relatedClass);
                cu.addImport(packageName + "." + relatedClass);
                fkFieldNames.add(fkField);
            }
        }
    }
    // Table columns inclusion
    private static void processTableColumns(
            ResultSet columns,
            DtoConfig dtoConfig,
            NamingStrategyConfig naming,
            ClassOrInterfaceDeclaration dtoClass,
            Map<String, String> fieldTypes,
            Set<String> addedFields,
            Set<String> fkFieldNames,
            Set<String> imports) throws SQLException {
        while (columns.next()) {
            String colName = columns.getString("COLUMN_NAME");
            String fieldName = StringUtils.toCamelCase(colName, naming.getUppercaseAcronyms(), false);
            String javaType = mapDbTypeToJava(columns.getString("TYPE_NAME"), colName, columns);
            boolean isPk = (colName != null && (colName.equalsIgnoreCase("id") || colName.toLowerCase().endsWith("_id")));
            if (dtoConfig.isRemoveForeignKeyIdFields() && fkFieldNames.contains(fieldName) && !isPk) {
                continue;
            }
            // Skip if field already exists (from relationship)
            if (addedFields.contains(fieldName)) {
                continue;
            }
            // Add the field
            if (addedFields.add(fieldName)) {
                dtoClass.addField(javaType, fieldName, Modifier.Keyword.PRIVATE);
                fieldTypes.put(fieldName, javaType);
                if (javaType.contains(".")) {
                    imports.add(javaType);
                }
            }
        }
    }
    // Reverse relationships (lists) processing
    private static void processReverseRelationships(
            DtoConfig dtoConfig,
            List<Relationship> revRels,
            NamingStrategyConfig naming,
            ClassOrInterfaceDeclaration dtoClass,
            Map<String, String> fieldTypes,
            Set<String> addedFields,
            String packageName,
            CompilationUnit cu,
            Set<String> columnFieldNames) {
        if (!dtoConfig.isIncludeReverseRelationships() || revRels == null) return;
        for (Relationship rel : revRels) {
            String relatedClass = StringUtils.toCamelCase(StringUtils.stripPrefix(rel.getRelatedTable(), naming.getStripPrefixes()), naming.getUppercaseAcronyms(), true);
            String fieldName = StringUtils.toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false) + "List";
            if (columnFieldNames.contains(fieldName)) {
                continue;
            }
            if (addedFields.add(fieldName)) {
                dtoClass.addField("List<" + relatedClass + ">", fieldName, Modifier.Keyword.PRIVATE);
                cu.addImport("java.util.List");
                cu.addImport(packageName + "." + relatedClass);
                fieldTypes.put(fieldName, "List<" + relatedClass + ">");
            }
        }
    }
    // Constructors
    private static void generateConstructors(ClassOrInterfaceDeclaration dtoClass, Map<String, String> fieldTypes) {
        dtoClass.addConstructor(Modifier.Keyword.PUBLIC).setBody(new BlockStmt());
        ConstructorDeclaration ctor = dtoClass.addConstructor(Modifier.Keyword.PUBLIC);
        BlockStmt body = new BlockStmt();
        fieldTypes.forEach((name, type) -> {
            if (!type.startsWith("List<")) {
                ctor.addParameter(type, name);
                body.addStatement("this." + name + " = " + name + ";");
            }
        });
        ctor.setBody(body);
    }
    // Getters and Setters
    private static void generateAccessors(ClassOrInterfaceDeclaration dtoClass, Map<String, String> fieldTypes) {
        fieldTypes.forEach((name, type) -> {
            dtoClass.addMethod("get" + StringUtils.capitalize(name), Modifier.Keyword.PUBLIC).setType(type)
                    .setBody(new BlockStmt().addStatement("return " + name + ";"));
            dtoClass.addMethod("set" + StringUtils.capitalize(name), Modifier.Keyword.PUBLIC).addParameter(type, name)
                    .setBody(new BlockStmt().addStatement("this." + name + " = " + name + ";"));
        });
    }
    // Fluent Builder
    private static void generateBuilder(ClassOrInterfaceDeclaration dtoClass, String className, Map<String, String> fieldTypes) {
        ClassOrInterfaceDeclaration builder = new ClassOrInterfaceDeclaration()
                .setName("Builder")
                .setModifiers(Modifier.Keyword.PUBLIC, Modifier.Keyword.STATIC);
        dtoClass.addMember(builder);
        FieldDeclaration instanceField = builder.addField(className, "instance", Modifier.Keyword.PRIVATE);
        instanceField.getVariable(0).setInitializer("new " + className + "()");
        fieldTypes.forEach((name, type) -> {
            MethodDeclaration method = builder.addMethod(name, Modifier.Keyword.PUBLIC).setType("Builder")
                    .addParameter(type, name);
            BlockStmt body = new BlockStmt();
            body.addStatement("instance.set" + StringUtils.capitalize(name) + "(" + name + ");");
            body.addStatement("return this;");
            method.setBody(body);
        });
        MethodDeclaration buildMethod = builder.addMethod("build", Modifier.Keyword.PUBLIC).setType(className);
        BlockStmt buildBody = new BlockStmt();
        buildBody.addStatement("return instance;");
        buildMethod.setBody(buildBody);
    }
    // Write file
    private static void writeToFile(TargetConfig target, String packageName, String className, CompilationUnit cu) throws IOException {
        Path outputPath = Paths.get(target.getOutputDirectory(), packageName.replace(".", "/"), className + ".java");
        Files.createDirectories(outputPath.getParent());
        Files.writeString(outputPath, cu.toString());
        System.out.println("Generated DTO: " + outputPath);
    }
    // Enhanced type mapping with column name context
    private static String mapDbTypeToJava(String dbType, String columnName, ResultSet columns) throws SQLException {
        // Handle null columnName safely
        if (columnName == null) {
            return "String";
        }
        // Convert to lowercase for case-insensitive comparison
        String colNameLower = columnName.toLowerCase();
        // Handle active/inactive flags as Boolean
        if (colNameLower.equals("active") || colNameLower.equals("is_active") ||
                colNameLower.equals("enabled") || colNameLower.equals("is_enabled")) {
            return "Boolean";
        }
        // Handle duration fields as Integer
        if (colNameLower.contains("duration") || colNameLower.contains("length") ||
                colNameLower.equals("release_year") || colNameLower.equals("year")) {
            return "Integer";
        }
        // Handle date/time fields BEFORE monetary fields to avoid conflicts
        if (colNameLower.contains("date") || colNameLower.contains("time") ||
                colNameLower.contains("created") || colNameLower.contains("updated") ||
                colNameLower.contains("modified") || colNameLower.contains("timestamp")) {
            // Let the database type mapping handle the specific date/time type
            // This will be processed later in the switch statement
        } else {
            // Handle monetary/financial fields as BigDecimal (moved after date check)
            if (colNameLower.contains("amount") || colNameLower.contains("price") ||
                    colNameLower.contains("cost") || colNameLower.contains("rate") ||
                    colNameLower.contains("fee") || colNameLower.contains("balance") ||
                    colNameLower.contains("total") || colNameLower.equals("payment") ||
                    colNameLower.contains("payment_amount") || colNameLower.contains("payment_total")) {
                return "java.math.BigDecimal";
            }
        }
        // Handle ID fields
        if (colNameLower.equals("id") || colNameLower.endsWith("_id")) {
            return "Integer";
        }
        // Handle null dbType safely
        if (dbType == null) {
            return "String";
        }
        dbType = dbType.toUpperCase();
        // Check column precision for numeric types
        int precision = 0;
        int scale = 0;
        try {
            precision = columns.getInt("COLUMN_SIZE");
            scale = columns.getInt("DECIMAL_DIGITS");
        } catch (SQLException e) {
            // Ignore if these columns don't exist
        }
        // Database type mapping - takes precedence over column name patterns
        return switch (dbType) {
            case "VARCHAR", "VARCHAR2", "CHAR", "TEXT", "CLOB", "LONGTEXT", "MEDIUMTEXT" -> "String";
            case "INT", "INTEGER", "SMALLINT", "TINYINT", "INT4", "INT2" -> "Integer";
            case "BIGINT", "INT8" -> "Long";
            case "DECIMAL", "NUMERIC", "NUMBER" -> {
                // Use BigDecimal for monetary values or high precision decimals
                if (scale > 0 || precision > 10) {
                    yield "java.math.BigDecimal";
                } else if (precision > 9) {
                    yield "Long";
                } else {
                    yield "Integer";
                }
            }
            case "FLOAT", "REAL", "DOUBLE" -> {
                // For monetary columns, use BigDecimal even if stored as FLOAT
                if (colNameLower.contains("amount") || colNameLower.contains("price") ||
                        colNameLower.contains("cost") || colNameLower.contains("rate")) {
                    yield "java.math.BigDecimal";
                }
                yield "Double";
            }
            case "BOOLEAN", "BOOL", "BIT" -> "Boolean";
            case "DATE" -> "java.time.LocalDate";
            case "TIME" -> "java.time.LocalTime";
            case "TIMESTAMP", "TIMESTAMPTZ", "DATETIME" -> "java.time.LocalDateTime";
            case "JSON", "JSONB" -> "java.util.Map<String, Object>";
            case "ARRAY" -> "java.util.List<Object>";
            case "BLOB", "BYTEA" -> "byte[]";
            case "UUID" -> "java.util.UUID";
            default -> "String";
        };
    }
    // Overloaded version for backward compatibility
    private static String mapDbTypeToJava(String dbType, String columnName) {
        try {
            return mapDbTypeToJava(dbType, columnName, null);
        } catch (SQLException e) {
            // This shouldn't happen with null ResultSet
            return "String";
        }
    }
}