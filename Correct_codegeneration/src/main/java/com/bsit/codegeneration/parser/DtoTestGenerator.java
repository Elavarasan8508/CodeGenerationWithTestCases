package com.bsit.codegeneration.parser;

import com.bsit.codegeneration.model.*;
import com.bsit.codegeneration.util.Relationship;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ParseProblemException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DtoTestGenerator {

    public static void generateDtoTest(
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
        String dtoClassName = toCamelCase(rawClassName, naming.getUppercaseAcronyms(), true) + "DTO";
        String testClassName = dtoClassName + "Test";

        CompilationUnit cu = new CompilationUnit();
        String packageName = target.getBasePackage() + ".test.dto";
        cu.setPackageDeclaration(packageName);

        // Add proper imports
        cu.addImport("org.junit.jupiter.api.Test");
        cu.addImport("org.junit.jupiter.api.DisplayName");
        cu.addImport("static org.junit.jupiter.api.Assertions.*");

        // Import DTO under test
        String dtoPackage = target.getBasePackage() + ".dto." + dtoClassName;
        cu.addImport(dtoPackage);

        ClassOrInterfaceDeclaration testClass = cu.addClass(testClassName).setPublic(true);

        // Attempt to load source analysis (fields, constructors, overrides)
        SourceDtoInfo info = analyzeDtoSource(dtoClassName, target);

        // fallback: extract from DtoGenerator (keeps backwards compatibility)
        LinkedHashMap<String, String> extracted = DtoGenerator.extractDtoFieldTypes(
                columns, relationships, reverseRelationships, dtoConfig, dbConfig);

        LinkedHashMap<String, String> fieldTypes;
        if (info != null && info.fields != null && !info.fields.isEmpty()) {
            fieldTypes = info.fields;
        } else {
            fieldTypes = extracted;
        }

        if (fieldTypes.isEmpty()) {
            System.out.println("Warning: No fields found for " + tableName + ". Skipping test generation.");
            return;
        }

        // Add test data constants
        addTestDataConstants(testClass, fieldTypes, cu, target);

        // Test default constructor
        generateDefaultConstructorTest(testClass, dtoClassName, fieldTypes);

        // Test getters and setters
        generateGettersSettersTest(testClass, dtoClassName, fieldTypes);

        // Parameterized constructor tests, collecting field-sets
        List<Set<String>> constructorFieldSets = new ArrayList<>();
        if (info != null && !info.constructors.isEmpty()) {
            int ctorIndex = 1;
            for (ConstructorInfo ctor : info.constructors) {
                // Skip no-argument constructors to avoid generating duplicate parameterized constructor tests
                if (ctor.paramNames.isEmpty()) {
                    continue;
                }
                Set<String> fieldsSet = generateConstructorTestForSourceCtor(
                        testClass, dtoClassName, fieldTypes, ctor, ctorIndex++);
                constructorFieldSets.add(fieldsSet);
            }
        } else {
            generateParameterizedConstructorTestFallback(testClass, dtoClassName, fieldTypes);
        }

        // Test builder if enabled — skip if a constructor already sets all fields
        if (dtoConfig.isBuilderPattern()) {
            Set<String> allFields = new HashSet<>(fieldTypes.keySet());
            boolean anyCtorSetsAll = constructorFieldSets.stream()
                    .anyMatch(s -> s.equals(allFields));
            if (!anyCtorSetsAll) {
                generateBuilderTest(testClass, dtoClassName, fieldTypes);
            }
        }

        // Test equals and hashCode only if overridden
        if (info != null && info.hasEquals && info.hasHashCode) {
            generateEqualsHashCodeTest(testClass, dtoClassName, fieldTypes);
        }

        // Test toString only if overridden
        if (info != null && info.hasToString) {
            generateToStringTest(testClass, dtoClassName);
        }

        // Test relational fields if relationships exist
        if (!relationships.isEmpty() || !reverseRelationships.isEmpty()) {
            generateRelationalFieldTests(testClass, dtoClassName,
                    fieldTypes, relationships, reverseRelationships, target, cu, naming);
        }

        // Write to file
        Path outputPath = Paths.get(
                target.getOutputDirectory(),
                packageName.replace(".", "/"),
                testClassName + ".java");
        Files.createDirectories(outputPath.getParent());
        Files.writeString(outputPath, cu.toString());
        System.out.println("Generated Test: " + outputPath);
    }

    // ---------- Source analysis helpers ----------

    private static class ConstructorInfo {
        final List<String> paramNames = new ArrayList<>();
        final List<String> paramTypes = new ArrayList<>();
    }

    private static class SourceDtoInfo {
        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        List<ConstructorInfo> constructors = new ArrayList<>();
        boolean hasEquals = false;
        boolean hasHashCode = false;
        boolean hasToString = false;
    }

    private static SourceDtoInfo analyzeDtoSource(String dtoClassName, TargetConfig target) {
        List<String> candidateRoots = new ArrayList<>();
        if (target != null && target.getOutputDirectory() != null) {
            candidateRoots.add(target.getOutputDirectory());
        }
        candidateRoots.add("src/main/java");
        candidateRoots.add("src");

        String basePkgPath = (target != null && target.getBasePackage() != null)
                ? target.getBasePackage().replace('.', '/')
                : "com/bsit/codegeneration";

        for (String root : candidateRoots) {
            if (root == null) continue;
            Path candidate = Paths.get(root, basePkgPath, "dto", dtoClassName + ".java");
            if (Files.exists(candidate)) {
                try {
                    CompilationUnit dtoCu = StaticJavaParser.parse(candidate);
                    Optional<ClassOrInterfaceDeclaration> clsOpt = dtoCu.getClassByName(dtoClassName);
                    if (clsOpt.isPresent()) {
                        ClassOrInterfaceDeclaration cls = clsOpt.get();
                        SourceDtoInfo info = new SourceDtoInfo();

                        for (BodyDeclaration<?> member : cls.getMembers()) {
                            if (!(member instanceof FieldDeclaration)) continue;
                            FieldDeclaration fd = (FieldDeclaration) member;
                            for (VariableDeclarator var : fd.getVariables()) {
                                info.fields.put(var.getNameAsString(), var.getType().toString());
                            }
                        }

                        for (ConstructorDeclaration cd : cls.getConstructors()) {
                            ConstructorInfo ci = new ConstructorInfo();
                            cd.getParameters().forEach(p -> {
                                ci.paramNames.add(p.getNameAsString());
                                ci.paramTypes.add(p.getType().toString());
                            });
                            info.constructors.add(ci);
                        }

                        for (MethodDeclaration md : cls.getMethods()) {
                            if (md.getNameAsString().equals("equals") && md.getParameters().size() == 1) {
                                info.hasEquals = true;
                            }
                            if (md.getNameAsString().equals("hashCode") && md.getParameters().isEmpty()) {
                                info.hasHashCode = true;
                            }
                            if (md.getNameAsString().equals("toString") && md.getParameters().isEmpty()) {
                                info.hasToString = true;
                            }
                        }
                        return info;
                    }
                } catch (IOException | ParseProblemException ignored) { }
            }
        }
        return null;
    }

    // ---------- Test generation helpers ----------

    private static void addTestDataConstants(
            ClassOrInterfaceDeclaration testClass,
            LinkedHashMap<String, String> fieldTypes,
            CompilationUnit cu,
            TargetConfig target) {
        int counter = 1;
        for (Map.Entry<String, String> entry : fieldTypes.entrySet()) {
            String field = entry.getKey();
            String type = entry.getValue();
            String constantName = field.toLowerCase();
            String testValue = getRealisticTestValue(type, field, counter++, cu, target);
            FieldDeclaration fd = testClass.addField(
                    type, constantName,
                    Modifier.Keyword.PRIVATE,
                    Modifier.Keyword.STATIC,
                    Modifier.Keyword.FINAL);
            fd.getVariable(0).setInitializer(testValue);
        }
    }

    private static void generateDefaultConstructorTest(
            ClassOrInterfaceDeclaration testClass,
            String dtoClassName,
            LinkedHashMap<String, String> fieldTypes) {

        MethodDeclaration m = testClass.addMethod("testDefaultConstructor", Modifier.Keyword.PUBLIC);
        m.addAnnotation("Test");
        m.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("DisplayName"),
                new StringLiteralExpr("Should create DTO with default constructor and null/default values")));

        BlockStmt body = new BlockStmt();
        body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                new VariableDeclarator(
                        new ClassOrInterfaceType(null, dtoClassName),
                        "dto",
                        new ObjectCreationExpr(null, new ClassOrInterfaceType(null, dtoClassName), new NodeList<>())))));
        body.addStatement(new ExpressionStmt(new MethodCallExpr(null, "assertNotNull",
                new NodeList<>(new NameExpr("dto")))));

        for (String field : fieldTypes.keySet()) {
            String getter = "get" + capitalize(field);
            body.addStatement(new ExpressionStmt(new MethodCallExpr(null, "assertNull",
                    new NodeList<>(new MethodCallExpr(new NameExpr("dto"), getter)))));
        }
        m.setBody(body);
    }

    private static void generateGettersSettersTest(
            ClassOrInterfaceDeclaration testClass,
            String dtoClassName,
            LinkedHashMap<String, String> fieldTypes) {

        MethodDeclaration m = testClass.addMethod("testGettersAndSetters", Modifier.Keyword.PUBLIC);
        m.addAnnotation("Test");
        m.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("DisplayName"),
                new StringLiteralExpr("Should get and set all properties correctly")));

        BlockStmt body = new BlockStmt();
        body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                new VariableDeclarator(
                        new ClassOrInterfaceType(null, dtoClassName),
                        "dto",
                        new ObjectCreationExpr(null, new ClassOrInterfaceType(null, dtoClassName), new NodeList<>())))));

        for (String field : fieldTypes.keySet()) {
            String setter = "set" + capitalize(field);
            String getter = "get" + capitalize(field);
            String constant = field.toLowerCase();

            body.addStatement(new ExpressionStmt(new MethodCallExpr(
                    new NameExpr("dto"), setter, new NodeList<>(new NameExpr(constant)))));
            body.addStatement(new ExpressionStmt(new MethodCallExpr(
                    null, "assertEquals",
                    new NodeList<>(new NameExpr(constant), new MethodCallExpr(new NameExpr("dto"), getter)))));
        }
        m.setBody(body);
    }

    private static Set<String> generateConstructorTestForSourceCtor(
            ClassOrInterfaceDeclaration testClass,
            String dtoClassName,
            LinkedHashMap<String, String> fieldTypes,
            ConstructorInfo ctor,
            int ctorIndex) {

        String testName = "testParameterizedConstructor";
        MethodDeclaration m = testClass.addMethod(testName, Modifier.Keyword.PUBLIC);
        m.addAnnotation("Test");
        m.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("DisplayName"),
                new StringLiteralExpr("Should create DTO using constructor #" + ctorIndex)));

        BlockStmt body = new BlockStmt();
        NodeList<Expression> args = new NodeList<>();
        Set<String> fieldsSet = new HashSet<>();

        for (int i = 0; i < ctor.paramNames.size(); i++) {
            String pName = ctor.paramNames.get(i);
            String pType = ctor.paramTypes.get(i);
            String matched = null;

            if (fieldTypes.containsKey(pName)) {
                matched = pName;
            } else {
                for (Map.Entry<String, String> fe : fieldTypes.entrySet()) {
                    if (typesMatch(pType, fe.getValue())) {
                        matched = fe.getKey();
                        break;
                    }
                }
            }

            if (matched != null) {
                fieldsSet.add(matched);
                args.add(new NameExpr(matched.toLowerCase()));
            } else {
                args.add(new NameExpr("null"));
            }
        }

        body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                new VariableDeclarator(
                        new ClassOrInterfaceType(null, dtoClassName),
                        "dto",
                        new ObjectCreationExpr(null, new ClassOrInterfaceType(null, dtoClassName), args)))));
        body.addStatement(new ExpressionStmt(new MethodCallExpr(null, "assertNotNull",
                new NodeList<>(new NameExpr("dto")))));

        for (String field : fieldTypes.keySet()) {
            String getter = "get" + capitalize(field);
            if (fieldsSet.contains(field)) {
                body.addStatement(new ExpressionStmt(new MethodCallExpr(
                        null, "assertEquals",
                        new NodeList<>(new NameExpr(field.toLowerCase()),
                                new MethodCallExpr(new NameExpr("dto"), getter)))));
            } else {
                body.addStatement(new ExpressionStmt(new MethodCallExpr(
                        null, "assertNull",
                        new NodeList<>(new MethodCallExpr(new NameExpr("dto"), getter)))));
            }
        }

        m.setBody(body);
        return fieldsSet;
    }

    private static void generateParameterizedConstructorTestFallback(
            ClassOrInterfaceDeclaration testClass,
            String dtoClassName,
            LinkedHashMap<String, String> fieldTypes) {

        MethodDeclaration m = testClass.addMethod("testParameterizedConstructor_full", Modifier.Keyword.PUBLIC);
        m.addAnnotation("Test");
        m.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("DisplayName"),
                new StringLiteralExpr("Should create DTO with full parameterized constructor")));

        BlockStmt body = new BlockStmt();
        NodeList<Expression> args = new NodeList<>();
        for (String field : fieldTypes.keySet()) {
            args.add(new NameExpr(field.toLowerCase()));
        }

        if (!args.isEmpty()) {
            body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                    new VariableDeclarator(
                            new ClassOrInterfaceType(null, dtoClassName),
                            "dto",
                            new ObjectCreationExpr(null, new ClassOrInterfaceType(null, dtoClassName), args)))));
            body.addStatement(new ExpressionStmt(new MethodCallExpr(null, "assertNotNull",
                    new NodeList<>(new NameExpr("dto")))));

            for (String field : fieldTypes.keySet()) {
                String getter = "get" + capitalize(field);
                body.addStatement(new ExpressionStmt(new MethodCallExpr(
                        null, "assertEquals",
                        new NodeList<>(new NameExpr(field.toLowerCase()),
                                new MethodCallExpr(new NameExpr("dto"), getter)))));
            }
        }

        m.setBody(body);
    }

    private static void generateBuilderTest(
            ClassOrInterfaceDeclaration testClass,
            String dtoClassName,
            LinkedHashMap<String, String> fieldTypes) {

        MethodDeclaration m = testClass.addMethod("testBuilder", Modifier.Keyword.PUBLIC);
        m.addAnnotation("Test");
        m.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("DisplayName"),
                new StringLiteralExpr("Should build DTO using builder pattern")));

        BlockStmt body = new BlockStmt();
        Expression builderExpr = new ObjectCreationExpr(
                null,
                new ClassOrInterfaceType(null, dtoClassName + ".Builder"),
                new NodeList<>());

        for (String field : fieldTypes.keySet()) {
            builderExpr = new MethodCallExpr(
                    builderExpr,
                    field,
                    new NodeList<>(new NameExpr(field.toLowerCase())));
        }
        builderExpr = new MethodCallExpr(builderExpr, "build");

        body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                new VariableDeclarator(
                        new ClassOrInterfaceType(null, dtoClassName),
                        "dto",
                        builderExpr))));
        body.addStatement(new ExpressionStmt(new MethodCallExpr(null, "assertNotNull",
                new NodeList<>(new NameExpr("dto")))));

        for (String field : fieldTypes.keySet()) {
            String getter = "get" + capitalize(field);
            body.addStatement(new ExpressionStmt(new MethodCallExpr(
                    null, "assertEquals",
                    new NodeList<>(new NameExpr(field.toLowerCase()),
                            new MethodCallExpr(new NameExpr("dto"), getter)))));
        }

        m.setBody(body);
    }

    private static void generateEqualsHashCodeTest(
            ClassOrInterfaceDeclaration testClass,
            String dtoClassName,
            LinkedHashMap<String, String> fieldTypes) {

        MethodDeclaration m = testClass.addMethod("testEqualsAndHashCode", Modifier.Keyword.PUBLIC);
        m.addAnnotation("Test");
        m.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("DisplayName"),
                new StringLiteralExpr("Should implement equals and hashCode correctly")));

        BlockStmt body = new BlockStmt();

        body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                new VariableDeclarator(
                        new ClassOrInterfaceType(null, dtoClassName),
                        "dto1",
                        new ObjectCreationExpr(null, new ClassOrInterfaceType(null, dtoClassName), new NodeList<>())))));
        body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                new VariableDeclarator(
                        new ClassOrInterfaceType(null, dtoClassName),
                        "dto2",
                        new ObjectCreationExpr(null, new ClassOrInterfaceType(null, dtoClassName), new NodeList<>())))));

        for (String field : fieldTypes.keySet()) {
            String setter = "set" + capitalize(field);
            body.addStatement(new ExpressionStmt(new MethodCallExpr(
                    new NameExpr("dto1"),
                    setter,
                    new NodeList<>(new NameExpr(field.toLowerCase())))));
            body.addStatement(new ExpressionStmt(new MethodCallExpr(
                    new NameExpr("dto2"),
                    setter,
                    new NodeList<>(new NameExpr(field.toLowerCase())))));
        }

        body.addStatement(new ExpressionStmt(new MethodCallExpr(
                null, "assertEquals",
                new NodeList<>(new NameExpr("dto1"), new NameExpr("dto2")))));

        body.addStatement(new ExpressionStmt(new MethodCallExpr(
                null, "assertEquals",
                new NodeList<>(
                        new MethodCallExpr(new NameExpr("dto1"), "hashCode"),
                        new MethodCallExpr(new NameExpr("dto2"), "hashCode")))));

        m.setBody(body);
    }

    private static void generateToStringTest(
            ClassOrInterfaceDeclaration testClass,
            String dtoClassName) {

        MethodDeclaration m = testClass.addMethod("testToString", Modifier.Keyword.PUBLIC);
        m.addAnnotation("Test");
        m.addAnnotation(new SingleMemberAnnotationExpr(
                new Name("DisplayName"),
                new StringLiteralExpr("Should have meaningful toString implementation")));

        BlockStmt body = new BlockStmt();
        body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                new VariableDeclarator(
                        new ClassOrInterfaceType(null, dtoClassName),
                        "dto",
                        new ObjectCreationExpr(null, new ClassOrInterfaceType(null, dtoClassName), new NodeList<>())))));

        body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                new VariableDeclarator(
                        new ClassOrInterfaceType(null, "String"),
                        "result",
                        new MethodCallExpr(new NameExpr("dto"), "toString")))));
        body.addStatement(new ExpressionStmt(new MethodCallExpr(
                null, "assertNotNull",
                new NodeList<>(new NameExpr("result")))));

        m.setBody(body);
    }

    private static void generateRelationalFieldTests(
            ClassOrInterfaceDeclaration testClass,
            String dtoClassName,
            LinkedHashMap<String, String> fieldTypes,
            List<Relationship> relationships,
            List<Relationship> reverseRelationships,
            TargetConfig target,
            CompilationUnit cu,
            NamingStrategyConfig naming) {

        // Forward relationships
        for (Relationship rel : relationships) {
            String rawName = stripPrefix(rel.getRelatedTable(), naming.getStripPrefixes());
            String relatedDto = toCamelCase(rawName, naming.getUppercaseAcronyms(), true) + "DTO";
            String fk = toCamelCase(rel.getFkColumn(), naming.getUppercaseAcronyms(), false);
            String fieldName = fk.toLowerCase().endsWith("id")
                    ? fk.substring(0, fk.length() - 2)
                    : fk;
            if (fieldName.isEmpty()) {
                fieldName = toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false);
            }
            String suffix = capitalize(fieldName);
            String testName = "test" + suffix + "Relationship";

            // SKIP if already generated
            if (!testClass.getMethodsByName(testName).isEmpty()) {
                continue;
            }

            cu.addImport(target.getBasePackage() + ".dto." + relatedDto);

            MethodDeclaration m = testClass.addMethod(testName, Modifier.Keyword.PUBLIC);
            m.addAnnotation("Test");
            m.addAnnotation(new SingleMemberAnnotationExpr(
                    new Name("DisplayName"),
                    new StringLiteralExpr("Should set and get " + fieldName + " relationship correctly")));

            BlockStmt body = new BlockStmt();
            body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                    new VariableDeclarator(
                            new ClassOrInterfaceType(null, dtoClassName),
                            "dto",
                            new ObjectCreationExpr(null, new ClassOrInterfaceType(null, dtoClassName), new NodeList<>())))));

            String constant = fieldName.toLowerCase();
            Expression init = fieldTypes.containsKey(fieldName)
                    ? new NameExpr(constant)
                    : new ObjectCreationExpr(null, new ClassOrInterfaceType(null, relatedDto), new NodeList<>());
            body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                    new VariableDeclarator(
                            new ClassOrInterfaceType(null, relatedDto),
                            "relatedDto",
                            init))));

            body.addStatement(new ExpressionStmt(new MethodCallExpr(
                    new NameExpr("dto"),
                    "set" + suffix,
                    new NodeList<>(new NameExpr("relatedDto")))));

            body.addStatement(new ExpressionStmt(new MethodCallExpr(
                    null, "assertSame",
                    new NodeList<>(new NameExpr("relatedDto"),
                            new MethodCallExpr(new NameExpr("dto"), "get" + suffix)))));

            m.setBody(body);
        }

        // Reverse relationships
        for (Relationship rel : reverseRelationships) {
            String rawName = stripPrefix(rel.getRelatedTable(), naming.getStripPrefixes());
            String relatedDto = toCamelCase(rawName, naming.getUppercaseAcronyms(), true) + "DTO";
            String listField = toCamelCase(rel.getRelatedTable(), naming.getUppercaseAcronyms(), false) + "List";
            String testName = "test" + capitalize(listField) + "Relationship";

            // SKIP if already generated
            if (!testClass.getMethodsByName(testName).isEmpty()) {
                continue;
            }

            cu.addImport("java.util.List");
            cu.addImport("java.util.ArrayList");
            cu.addImport(target.getBasePackage() + ".dto." + relatedDto);

            MethodDeclaration m = testClass.addMethod(testName, Modifier.Keyword.PUBLIC);
            m.addAnnotation("Test");
            m.addAnnotation(new SingleMemberAnnotationExpr(
                    new Name("DisplayName"),
                    new StringLiteralExpr("Should manage " + listField + " relationship correctly")));

            BlockStmt body = new BlockStmt();
            body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                    new VariableDeclarator(
                            new ClassOrInterfaceType(null, dtoClassName),
                            "dto",
                            new ObjectCreationExpr(null, new ClassOrInterfaceType(null, dtoClassName), new NodeList<>())))));

            String constant = listField.toLowerCase();
            Expression init = fieldTypes.containsKey(listField)
                    ? new NameExpr(constant)
                    : new ObjectCreationExpr(null,
                    new ClassOrInterfaceType(null, "ArrayList<>"),
                    new NodeList<>());
            body.addStatement(new ExpressionStmt(new VariableDeclarationExpr(
                    new VariableDeclarator(
                            new ClassOrInterfaceType(null, "List<" + relatedDto + ">"),
                            "relatedList",
                            init))));

            if (!fieldTypes.containsKey(listField)) {
                body.addStatement(new ExpressionStmt(new MethodCallExpr(
                        new NameExpr("relatedList"),
                        "add",
                        new NodeList<>(new ObjectCreationExpr(null, new ClassOrInterfaceType(null, relatedDto), new NodeList<>())))));
            }

            body.addStatement(new ExpressionStmt(new MethodCallExpr(
                    new NameExpr("dto"),
                    "set" + capitalize(listField),
                    new NodeList<>(new NameExpr("relatedList")))));

            body.addStatement(new ExpressionStmt(new MethodCallExpr(
                    null, "assertNotNull",
                    new NodeList<>(new MethodCallExpr(new NameExpr("dto"), "get" + capitalize(listField))))));
            body.addStatement(new ExpressionStmt(new MethodCallExpr(
                    null, "assertEquals",
                    new NodeList<>(new NameExpr("relatedList"),
                            new MethodCallExpr(new NameExpr("dto"), "get" + capitalize(listField))))));

            m.setBody(body);
        }
    }

    // ---------- Utilities ----------

    private static boolean typesMatch(String pType, String fType) {
        if (pType == null || fType == null) return false;
        String pSimple = pType.contains(".")
                ? pType.substring(pType.lastIndexOf('.') + 1)
                : pType;
        String fSimple = fType.contains(".")
                ? fType.substring(fType.lastIndexOf('.') + 1)
                : fType;
        return pType.equals(fType)
                || pSimple.equalsIgnoreCase(fSimple)
                || pType.replaceAll("\\s+", "").equalsIgnoreCase(fType.replaceAll("\\s+", ""));
    }

    private static String getRealisticTestValue(
            String type,
            String fieldName,
            int counter,
            CompilationUnit cu,
            TargetConfig target) {

        if (type == null) return "null";
        String lower = type.toLowerCase();

        if (type.startsWith("List<") && type.endsWith(">")) {
            String inner = type.substring(type.indexOf('<') + 1, type.lastIndexOf('>')).trim();
            if (inner.endsWith("DTO")) {
                if (target != null) cu.addImport(target.getBasePackage() + ".dto." + inner);
                cu.addImport("java.util.ArrayList");
                cu.addImport("java.util.Arrays");
                cu.addImport("java.util.List");
                return "new ArrayList<>(Arrays.asList(new " + inner + "()))";
            } else {
                cu.addImport("java.util.ArrayList");
                cu.addImport("java.util.List");
                return "new ArrayList<>()";
            }
        }

        if (type.endsWith("DTO")) {
            if (target != null) cu.addImport(target.getBasePackage() + ".dto." + type);
            return "new " + type + "()";
        }

        switch (lower) {
            case "string":
                if (fieldName.toLowerCase().contains("name")) {
                    return "\"Test Name " + counter + "\"";
                }
                if (fieldName.toLowerCase().contains("email")) {
                    return "\"test" + counter + "@example.com\"";
                }
                if (fieldName.toLowerCase().contains("description")) {
                    return "\"Test description for " + fieldName + "\"";
                }
                return "\"TestValue" + counter + "\"";

            case "integer":
            case "int":
                return String.valueOf(counter * 10);

            case "long":
                return (counter * 100L) + "L";

            case "float":
                return (counter * 1.5f) + "f";

            case "double":
                return (counter * 2.5) + "d";

            case "boolean":
                return counter % 2 == 0 ? "true" : "false";

            case "java.time.localdatetime":
                cu.addImport("java.time.LocalDateTime");
                return "LocalDateTime.of(2023, "
                        + Math.max(1, counter % 12) + ", "
                        + Math.max(1, counter % 28)
                        + ", 10, 30, 0)";

            case "java.time.localdate":
                cu.addImport("java.time.LocalDate");
                return "LocalDate.of(2023, "
                        + Math.max(1, counter % 12) + ", "
                        + Math.max(1, counter % 28) + ")";

            case "java.util.map<string, object>":
                cu.addImport("java.util.HashMap");
                cu.addImport("java.util.Map");
                return "new HashMap<>()";

            case "java.math.bigdecimal":
                cu.addImport("java.math.BigDecimal");
                return "new BigDecimal(\"" + (counter * 10.99) + "\")";

            default:
                if (lower.startsWith("list<")) {
                    cu.addImport("java.util.ArrayList");
                    return "new ArrayList<>()";
                }
                return "null";
        }
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    private static String stripPrefix(String name, List<String> prefixes) {
        if (name == null || prefixes == null) return name;
        for (String prefix : prefixes) {
            if (name.startsWith(prefix)) {
                return name.substring(prefix.length());
            }
        }
        return name;
    }

    private static String toCamelCase(
            String name,
            List<String> acronyms,
            boolean capitalizeFirst) {

        if (name == null || name.isEmpty()) return name;

        boolean leading = name.startsWith("_");
        boolean trailing = name.endsWith("_");
        String clean = name;
        if (leading) clean = clean.substring(1);
        if (trailing) clean = clean.substring(0, clean.length() - 1);

        String[] parts = clean.toLowerCase().split("_");
        StringBuilder sb = new StringBuilder();
        if (leading) sb.append("_");

        for (int i = 0; i < parts.length; i++) {
            String p = parts[i];
            if (p.isEmpty()) continue;
            boolean isAcronym = acronyms != null && acronyms.contains(p.toUpperCase());
            if (isAcronym) {
                sb.append(p.toUpperCase());
            } else if (i == 0 && !capitalizeFirst) {
                sb.append(p);
            } else {
                sb.append(Character.toUpperCase(p.charAt(0)))
                        .append(p.substring(1));
            }
        }

        if (trailing) sb.append("_");
        return sb.toString();
    }
}
