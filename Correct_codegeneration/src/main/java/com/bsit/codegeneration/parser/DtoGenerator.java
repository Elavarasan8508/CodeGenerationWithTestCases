package com.bsit.codegeneration.parser;

import com.bsit.codegeneration.model.*;
import com.bsit.codegeneration.util.Relationship;
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

public class DtoGenerator {

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
        String rawClassName = stripPrefix(tableName, naming.getStripPrefixes());
        String className = toCamelCase(rawClassName, naming.getUppercaseAcronyms(), true) + "DTO";

        CompilationUnit cu = new CompilationUnit();
        String packageName = target.getBasePackage() + ".dto";
        cu.setPackageDeclaration(packageName);

        // Create the DTO class
        ClassOrInterfaceDeclaration dtoClass = cu.addClass(className).setPublic(true);

        // Map to maintain field ordering
        Map<String, String> fieldTypes = new LinkedHashMap<>();
        Set<String> imports = new HashSet<>();
        Set<String> addedFields = new HashSet<>();
        Set<String> fkFieldNames = new HashSet<>();

        // Process fields
        processForwardRelationships(dtoConfig, relationships, naming, dtoClass, fieldTypes, addedFields, fkFieldNames, packageName, cu);
        processTableColumns(columns, dtoConfig, naming, dtoClass, fieldTypes, addedFields, fkFieldNames, imports);
        processReverseRelationships(dtoConfig, reverseRelationships, naming, dtoClass, fieldTypes, addedFields, packageName, cu);

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

        // Forward relationships
        if (dtoConfig.isIncludeRelationships()) {
            for (Relationship rel : relationships) {
                String relatedClass = toCamelCase(stripPrefix(rel.getRelatedTable(), naming.getStripPrefixes()), naming.getUppercaseAcronyms(), true) + "DTO";
                String fkField = toCamelCase(rel.getFkColumn(), naming.getUppercaseAcronyms(), false);
                String relationField = fkField.toLowerCase().endsWith("id") ? fkField.substring(0, fkField.length() - 2) : fkField;
                if (relationField.isEmpty()) {
                    relationField = toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false);
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
            String fieldName = toCamelCase(colName, naming.getUppercaseAcronyms(), false);
            String javaType = mapDbTypeToJava(columns.getString("TYPE_NAME"), colName);

            boolean isPk = colName.equalsIgnoreCase("id") || colName.toLowerCase().endsWith("_id");
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
                String relatedClass = toCamelCase(stripPrefix(rel.getRelatedTable(), naming.getStripPrefixes()), naming.getUppercaseAcronyms(), true) + "DTO";
                String fieldName = toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false) + "List";
                if (addedFields.add(fieldName)) {
                    fieldTypes.put(fieldName, "List<" + relatedClass + ">");
                }
            }
        }

        return fieldTypes;
    }

    // Forward relationships inclusion
    private static void processForwardRelationships(
            DtoConfig dtoConfig,
            List<Relationship> rels,
            NamingStrategyConfig naming,
            ClassOrInterfaceDeclaration dtoClass,
            Map<String, String> fieldTypes,
            Set<String> addedFields,
            Set<String> fkFieldNames,
            String packageName,
            CompilationUnit cu) {

        if (!dtoConfig.isIncludeRelationships()) return;
        for (Relationship rel : rels) {
            // small heuristic: if fk column contains a clear target name (like "staff"), prefer that
            String relatedTableName = rel.getRelatedTable();
            String fkColumnLower = rel.getFkColumn() == null ? "" : rel.getFkColumn().toLowerCase();
            if (fkColumnLower.contains("staff")) {
                relatedTableName = "staff"; // heuristic -- only when FK mentions 'staff'
            } else if (fkColumnLower.contains("customer")) {
                relatedTableName = "customer";
            } else if (fkColumnLower.contains("address")) {
                relatedTableName = "address";
            }
            // derive class name from the (possibly adjusted) table name
            String relatedClass = toCamelCase(stripPrefix(relatedTableName, naming.getStripPrefixes()), naming.getUppercaseAcronyms(), true) + "DTO";

            String fkField = toCamelCase(rel.getFkColumn(), naming.getUppercaseAcronyms(), false);
            String relationField = fkField.toLowerCase().endsWith("id") ? fkField.substring(0, fkField.length() - 2) : fkField;
            if (relationField.isEmpty()) {
                relationField = toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false);
            }
            // avoid adding a relationship field when a column with same name already exists as a non-DTO
            if (addedFields.contains(relationField)) {
                String existingType = fieldTypes.get(relationField);
                if (existingType != null && !existingType.endsWith("DTO")) {
                    // a real column (String/Integer/etc.) already exists with this name -> skip relationship
                    fkFieldNames.add(fkField); // still record fk column name for removal logic
                    continue;
                }
            }

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
            String fieldName = toCamelCase(colName, naming.getUppercaseAcronyms(), false);
            String javaType = mapDbTypeToJava(columns.getString("TYPE_NAME"), colName);

            boolean isPk = colName.equalsIgnoreCase("id") || colName.toLowerCase().endsWith("_id");
            if (dtoConfig.isRemoveForeignKeyIdFields() && fkFieldNames.contains(fieldName) && !isPk) {
                continue;
            }

            // If a relationship already created a field with this name and that field is a DTO,
            // prefer the concrete column type (String/Integer/etc.) and *replace* the DTO field.
            if (addedFields.contains(fieldName)) {
                String existingType = fieldTypes.get(fieldName);
                boolean existingIsDto = existingType != null && existingType.endsWith("DTO");
                boolean newIsDto = javaType != null && javaType.endsWith("DTO");

                if (existingIsDto && !newIsDto) {
                    // remove previously added DTO field declaration from the class
                    dtoClass.getFieldByName(fieldName).ifPresent(f -> f.remove());

                    // replace mapping and re-add column field
                    fieldTypes.put(fieldName, javaType);
                    dtoClass.addField(javaType, fieldName, Modifier.Keyword.PRIVATE);

                    if (javaType.contains(".")) {
                        imports.add(javaType);
                    }
                }
                // if existing is not DTO or new is DTO -> do nothing (keep existing)
                continue;
            }

            // Normal add
            if (addedFields.add(fieldName)) {
                dtoClass.addField(javaType, fieldName, Modifier.Keyword.PRIVATE);
                fieldTypes.put(fieldName, javaType);
                if (javaType.contains(".")) {
                    imports.add(javaType);
                }
            }
        }
    }



    // Reverse relationships (lists)
    private static void processReverseRelationships(
            DtoConfig dtoConfig,
            List<Relationship> revRels,
            NamingStrategyConfig naming,
            ClassOrInterfaceDeclaration dtoClass,
            Map<String, String> fieldTypes,
            Set<String> addedFields,
            String packageName,
            CompilationUnit cu) {

        if (!dtoConfig.isIncludeReverseRelationships()) return;
        for (Relationship rel : revRels) {
            String relatedClass = toCamelCase(stripPrefix(rel.getRelatedTable(), naming.getStripPrefixes()), naming.getUppercaseAcronyms(), true) + "DTO";
            String fieldName = toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false) + "List";
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
            dtoClass.addMethod("get" + capitalize(name), Modifier.Keyword.PUBLIC).setType(type)
                    .setBody(new BlockStmt().addStatement("return " + name + ";"));
            dtoClass.addMethod("set" + capitalize(name), Modifier.Keyword.PUBLIC).addParameter(type, name)
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
            body.addStatement("instance.set" + capitalize(name) + "(" + name + ");");
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

    // Utility methods
    private static String capitalize(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    private static String stripPrefix(String name, List<String> prefixes) {
        if (name == null || prefixes == null) return name;
        for (String prefix : prefixes) {
            if (name.startsWith(prefix)) return name.substring(prefix.length());
        }
        return name;
    }

    private static String toCamelCase(String name, List<String> acronyms, boolean capitalizeFirst) {
        if (name == null || name.isEmpty()) return name;
        boolean hasLeading = name.startsWith("_");
        boolean hasTrailing = name.endsWith("_");
        String clean = name;
        if (hasLeading) clean = clean.substring(1);
        if (hasTrailing) clean = clean.substring(0, clean.length() - 1);

        String[] parts = clean.toLowerCase().split("_");
        StringBuilder sb = new StringBuilder();
        if (hasLeading) sb.append("_");

        for (int i = 0; i < parts.length; i++) {
            String p = parts[i];
            if (p.isEmpty()) continue;
            boolean isAcronym = acronyms.contains(p.toUpperCase());
            if (isAcronym) {
                sb.append(p.toUpperCase());
            } else if (i == 0 && !capitalizeFirst) {
                sb.append(p);
            } else {
                sb.append(Character.toUpperCase(p.charAt(0))).append(p.substring(1));
            }
        }
        if (hasTrailing) sb.append("_");
        return sb.toString();
    }

    private static String mapDbTypeToJava(String dbType, String columnName) {
        if (columnName.equalsIgnoreCase("id") || columnName.toLowerCase().endsWith("_id")) {
            return "Integer";
        }
        dbType = dbType.toUpperCase();
        return switch (dbType) {
            case "VARCHAR", "CHAR", "TEXT", "CLOB" -> "String";
            case "INT", "INTEGER", "SMALLINT", "TINYINT" -> "Integer";
            case "BIGINT" -> "Long";
            case "DECIMAL", "NUMERIC", "NUMBER", "FLOAT" -> "Float";
            case "DATE", "TIMESTAMP", "TIMESTAMPTZ" -> "java.time.LocalDateTime";
            case "JSON", "JSONB" -> "java.util.Map<String, Object>";
            default -> "String";
        };
    }
}
