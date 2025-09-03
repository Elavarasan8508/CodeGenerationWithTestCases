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

    /**
     * Generate full DTO class
     */
    public static void generateDto(
            String tableName,
            ResultSet columns,
            DatabaseConfig dbConfig,
            TargetConfig target,
            DtoConfig dtoConfig,
            List<Relationship> relationships,
            List<Relationship> reverseRelationships
    ) throws SQLException, IOException {

        NamingStrategyConfig naming = dbConfig.getNamingStrategy();
        String rawClassName = StringUtils.stripPrefix(tableName, naming.getStripPrefixes());
        String className = StringUtils.toCamelCase(rawClassName, naming.getUppercaseAcronyms(), true);

        CompilationUnit cu = new CompilationUnit();
        String packageName = target.getBasePackage() + ".pojo";
        cu.setPackageDeclaration(packageName);

        ClassOrInterfaceDeclaration dtoClass = cu.addClass(className).setPublic(true);

        // Extract field types from columns and relationships
        LinkedHashMap<String, String> fieldTypes = extractDtoFieldTypes(
                columns, relationships, reverseRelationships, dtoConfig, dbConfig
        );

        Set<String> imports = new HashSet<>();
        fieldTypes.forEach((name, type) -> {
            dtoClass.addField(type, name, Modifier.Keyword.PRIVATE);
            if (type.contains(".")) imports.add(type);
            if (type.startsWith("List<")) imports.add("java.util.List");
        });

        generateConstructors(dtoClass, fieldTypes);
        generateAccessors(dtoClass, fieldTypes);

        if (dtoConfig.isBuilderPattern()) {
            generateBuilder(dtoClass, className, fieldTypes);
        }

        imports.forEach(cu::addImport);

        writeToFile(target, packageName, className, cu);
    }

    /**
     * Extract DTO field types for backward compatibility
     */
    public static LinkedHashMap<String, String> extractDtoFieldTypes(
            ResultSet columns,
            List<Relationship> relationships,
            List<Relationship> reverseRelationships,
            DtoConfig dtoConfig,
            DatabaseConfig dbConfig
    ) throws SQLException {

        NamingStrategyConfig naming = dbConfig.getNamingStrategy();
        LinkedHashMap<String, String> fieldTypes = new LinkedHashMap<>();
        Set<String> addedFields = new HashSet<>();
        Set<String> fkFieldNames = new HashSet<>();
        Set<String> columnFieldNames = new HashSet<>();

        // Collect column field names and types
        while (columns.next()) {
            String colName = columns.getString("COLUMN_NAME");
            String fieldName = StringUtils.toCamelCase(colName, naming.getUppercaseAcronyms(), false);
            columnFieldNames.add(fieldName);

            String javaType = mapDbTypeToJava(columns.getString("TYPE_NAME"), colName, columns);
            fieldTypes.put(fieldName, javaType);
            addedFields.add(fieldName);
        }

        // Forward relationships
        if (dtoConfig.isIncludeRelationships() && relationships != null) {
            for (Relationship rel : relationships) {
                String relatedClass = StringUtils.toCamelCase(
                        StringUtils.stripPrefix(rel.getRelatedTable(), naming.getStripPrefixes()),
                        naming.getUppercaseAcronyms(),
                        true
                );
                String fkField = StringUtils.toCamelCase(rel.getFkColumn(), naming.getUppercaseAcronyms(), false);
                if (!fkField.toLowerCase().endsWith("id")) continue;

                String relationField = fkField.toLowerCase().endsWith("id")
                        ? fkField.substring(0, fkField.length() - 2)
                        : StringUtils.toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false);

                if (columnFieldNames.contains(relationField)) continue;
                if (addedFields.add(relationField)) {
                    fieldTypes.put(relationField, relatedClass);
                    fkFieldNames.add(fkField);
                }
            }
        }

        // Reverse relationships
        if (dtoConfig.isIncludeReverseRelationships() && reverseRelationships != null) {
            for (Relationship rel : reverseRelationships) {
                String relatedClass = StringUtils.toCamelCase(
                        StringUtils.stripPrefix(rel.getRelatedTable(), naming.getStripPrefixes()),
                        naming.getUppercaseAcronyms(),
                        true
                );
                String fieldName = StringUtils.toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false) + "List";
                if (columnFieldNames.contains(fieldName)) continue;
                if (addedFields.add(fieldName)) {
                    fieldTypes.put(fieldName, "List<" + relatedClass + ">");
                }
            }
        }

        return fieldTypes;
    }

    /**
     * Constructors
     */
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

    /**
     * Getters and Setters
     */
    private static void generateAccessors(ClassOrInterfaceDeclaration dtoClass, Map<String, String> fieldTypes) {
        fieldTypes.forEach((name, type) -> {
            dtoClass.addMethod("get" + StringUtils.capitalize(name), Modifier.Keyword.PUBLIC)
                    .setType(type)
                    .setBody(new BlockStmt().addStatement("return " + name + ";"));

            dtoClass.addMethod("set" + StringUtils.capitalize(name), Modifier.Keyword.PUBLIC)
                    .addParameter(type, name)
                    .setBody(new BlockStmt().addStatement("this." + name + " = " + name + ";"));
        });
    }

    /**
     * Builder pattern
     */
    private static void generateBuilder(ClassOrInterfaceDeclaration dtoClass, String className, Map<String, String> fieldTypes) {
        ClassOrInterfaceDeclaration builder = new ClassOrInterfaceDeclaration()
                .setName("Builder")
                .setModifiers(Modifier.Keyword.PUBLIC, Modifier.Keyword.STATIC);
        dtoClass.addMember(builder);

        FieldDeclaration instanceField = builder.addField(className, "instance", Modifier.Keyword.PRIVATE);
        instanceField.getVariable(0).setInitializer("new " + className + "()");

        fieldTypes.forEach((name, type) -> {
            MethodDeclaration method = builder.addMethod(name, Modifier.Keyword.PUBLIC)
                    .setType("Builder")
                    .addParameter(type, name);

            BlockStmt body = new BlockStmt();
            body.addStatement("instance.set" + StringUtils.capitalize(name) + "(" + name + ");");
            body.addStatement("return this;");
            method.setBody(body);
        });

        MethodDeclaration buildMethod = builder.addMethod("build", Modifier.Keyword.PUBLIC)
                .setType(className);
        BlockStmt buildBody = new BlockStmt();
        buildBody.addStatement("return instance;");
        buildMethod.setBody(buildBody);
    }

    /**
     * Write DTO to file
     */
    private static void writeToFile(TargetConfig target, String packageName, String className, CompilationUnit cu) throws IOException {
        Path outputPath = Paths.get(target.getOutputDirectory(), packageName.replace(".", "/"), className + ".java");
        Files.createDirectories(outputPath.getParent());
        Files.writeString(outputPath, cu.toString());
        System.out.println("Generated DTO: " + outputPath);
    }

    /**
     * Map database type to Java type (Oracle-safe)
     */
    private static String mapDbTypeToJava(String dbType, String columnName, ResultSet columns) throws SQLException {
        if (columnName == null) return "String";

        String colNameLower = columnName.toLowerCase();
        if (colNameLower.equals("active") || colNameLower.equals("is_active") ||
                colNameLower.equals("enabled") || colNameLower.equals("is_enabled")) {
            return "Boolean";
        }
        if (colNameLower.contains("duration") || colNameLower.contains("length") ||
                colNameLower.equals("release_year") || colNameLower.equals("year")) {
            return "Integer";
        }
        if (colNameLower.contains("date") || colNameLower.contains("time") ||
                colNameLower.contains("created") || colNameLower.contains("updated") ||
                colNameLower.contains("modified") || colNameLower.contains("timestamp")) {
            // fall through to date mapping
        } else if (colNameLower.contains("amount") || colNameLower.contains("price") ||
                colNameLower.contains("cost") || colNameLower.contains("rate") ||
                colNameLower.contains("fee") || colNameLower.contains("balance") ||
                colNameLower.contains("total") || colNameLower.equals("payment") ||
                colNameLower.contains("payment_amount") || colNameLower.contains("payment_total")) {
            return "java.math.BigDecimal";
        }
        if (colNameLower.equals("id") || colNameLower.endsWith("_id")) return "Integer";

        if (dbType == null) return "String";

        dbType = dbType.toUpperCase();
        int precision = 0, scale = 0;
        try {
            if (columns != null) {
                precision = columns.getInt("COLUMN_SIZE");
                scale = columns.getInt("DECIMAL_DIGITS");
            }
        } catch (SQLException ignored) {}

        return switch (dbType) {
            case "VARCHAR", "VARCHAR2", "CHAR", "CLOB", "LONG" -> "String";
            case "INT", "INTEGER", "NUMBER" -> {
                if (scale > 0 || precision > 10) yield "java.math.BigDecimal";
                else if (precision > 9) yield "Long";
                else yield "Integer";
            }
            case "FLOAT", "BINARY_FLOAT", "BINARY_DOUBLE", "REAL", "DOUBLE" -> "Double";
            case "DATE", "TIMESTAMP" -> "java.time.LocalDateTime";
            case "TIMESTAMP WITH TIME ZONE", "TIMESTAMP WITH LOCAL TIME ZONE" -> "java.time.OffsetDateTime";
            case "BLOB", "RAW", "LONG RAW" -> "byte[]";
            default -> "String";
        };
    }
}
