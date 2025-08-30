package com.bsit.codegeneration.parser;

import com.bsit.codegeneration.model.*;
import com.bsit.codegeneration.util.Relationship;
import com.bsit.codegeneration.util.StringUtils;
import com.github.javaparser.StaticJavaParser;
import static com.github.javaparser.ParserConfiguration.LanguageLevel.*;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.PrimitiveType;

import java.io.IOException;
import java.nio.file.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class JdbcDaoGenerator {

    private static class ColumnInfo {
        String name;
        String javaType;
        boolean isAutoIncrement;
        boolean isForeignKey;
        String referencedTable;
        String dbType;
        boolean isBinary;

        ColumnInfo(String name, String javaType, boolean isAutoIncrement, String dbType) {
            this.name = name;
            this.javaType = javaType;
            this.isAutoIncrement = isAutoIncrement;
            this.isForeignKey = false;
            this.referencedTable = null;
            this.dbType = dbType;
            this.isBinary = dbType != null && (dbType.toUpperCase().contains("BLOB") || dbType.toUpperCase().equals("BYTEA") || dbType.toUpperCase().contains("BINARY") || dbType.toUpperCase().contains("RAW"));
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

        // Configure JavaParser to support Java 15 text blocks
        StaticJavaParser.getParserConfiguration().setLanguageLevel(JAVA_15);

        String vendor = dbConfig.getDatabaseVendor() == null ? "" : dbConfig.getDatabaseVendor().toUpperCase();

        NamingStrategyConfig naming = dbConfig.getNamingStrategy();
        String rawClassName = StringUtils.stripPrefix(tableName, naming.getStripPrefixes());
        String className = StringUtils.toCamelCase(rawClassName, naming.getUppercaseAcronyms(), true);
        String modelClassName = className;
        String daoClassName = "Jdbc"+className + "Dao";
        String packageName = "com.bsit.codegeneration.jdbcdao";

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
            int columnSize = 0;
            try {
                decimalDigits = columns.getInt("DECIMAL_DIGITS");
            } catch (Exception ignored) {
            }
            try {
                columnSize = columns.getInt("COLUMN_SIZE");
            } catch (Exception ignored) {
            }
            String javaType = mapDbTypeToJava(dbType, colName, decimalDigits, columnSize, vendor);

            boolean isAutoIncrement = false;
            try {
                String isAutoStr = columns.getString("IS_AUTOINCREMENT");
                isAutoIncrement = "YES".equals(isAutoStr);
            } catch (SQLException ignored) {
            }
            if (dbType != null && dbType.equalsIgnoreCase("SERIAL")) {
                isAutoIncrement = true;
            }

            ColumnInfo colInfo = new ColumnInfo(colName, javaType, isAutoIncrement, dbType);

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
        cu.addImport("java.util.Objects");
        cu.addImport("java.time.LocalDateTime");
        cu.addImport("java.math.BigDecimal");
        cu.addImport(target.getBasePackage()+".pojo.*");

        // class
        ClassOrInterfaceDeclaration daoClass = cu.addClass(daoClassName, Modifier.Keyword.PUBLIC);

        // Create constants (vendor-aware)
        createConstants(daoClass, tableName, columnsInfo, pkField, pkIsAuto, relationships, naming, vendor);

        // Create methods (pass vendor where needed)
        createInsertMethod(daoClass, tableName, modelClassName, pkField, idType, columnsInfo, naming, pkIsAuto, vendor);
        createBulkInsertMethod(daoClass, modelClassName, pkField, idType, columnsInfo, naming, pkIsAuto, vendor);
        createFindByIdMethod(daoClass, tableName, modelClassName, pkField, idType, columnsInfo, naming);
        createFindAllMethod(daoClass, tableName, modelClassName, columnsInfo, pkField, naming, vendor);
        createUpdateMethod(daoClass, tableName, modelClassName, pkField, idType, columnsInfo, naming);
        createBulkUpdateMethod(daoClass, modelClassName, pkField, idType, columnsInfo, naming);
        createDeleteMethod(daoClass, tableName, pkField, idType, naming);
        createBulkDeleteMethod(daoClass, pkField, idType, naming);

        // Create relationship-based finder methods
        createRelationshipMethods(daoClass, tableName, modelClassName, columnsInfo, relationships, naming);

        // Create setParams method
        createSetParamsMethod(daoClass, modelClassName, columnsInfo, pkField, pkIsAuto, naming);

        // Create extract method
        createExtractMethod(daoClass, modelClassName, columnsInfo, naming);

        // write file
        writeToFile(target, packageName, daoClassName, cu);
    }

    private static void createConstants(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            List<ColumnInfo> columnsInfo,
            String pkField,
            boolean pkIsAuto,
            List<Relationship> relationships,
            NamingStrategyConfig naming,
            String vendor) {

        // TABLE constant
        daoClass.addFieldWithInitializer("String", "TABLE",
                new StringLiteralExpr(tableName),
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // COL_ constants
        for (ColumnInfo c : columnsInfo) {
            String colConstantName = "COL_" + c.name.toUpperCase();
            daoClass.addFieldWithInitializer("String", colConstantName,
                    new StringLiteralExpr(c.name),
                    Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);
        }

        // INSERT_SQL
        List<ColumnInfo> insertCols = columnsInfo.stream()
                .filter(c -> !(pkIsAuto && c.name.equals(pkField)))
                .collect(Collectors.toList());

        String insertColumns = insertCols.stream()
                .map(c -> "%s")
                .collect(Collectors.joining(", "));
        String insertPlaceholders = insertCols.stream().map(c -> "?").collect(Collectors.joining(", "));

        StringBuilder insertSqlBuilder = new StringBuilder();
        insertSqlBuilder.append("\"\"\"\n");
        insertSqlBuilder.append("        INSERT INTO %s (").append(insertColumns).append(")\n");
        insertSqlBuilder.append("        VALUES (").append(insertPlaceholders).append(")");

        // Postgres: append RETURNING clause if PK is auto
        boolean isPostgres = vendor != null && (vendor.contains("POSTGRES") || vendor.contains("POSTGRESQL"));
        if (pkIsAuto && isPostgres) {
            insertSqlBuilder.append(" RETURNING %s\n");
        } else {
            insertSqlBuilder.append("\n");
        }
        insertSqlBuilder.append("        \"\"\"");

        MethodCallExpr insertSqlExpr = new MethodCallExpr(
                StaticJavaParser.parseExpression(insertSqlBuilder.toString()), "formatted");
        insertSqlExpr.addArgument(new NameExpr("TABLE"));
        for (ColumnInfo c : insertCols) {
            insertSqlExpr.addArgument(new NameExpr("COL_" + c.name.toUpperCase()));
        }
        if (pkIsAuto && isPostgres) {
            insertSqlExpr.addArgument(new NameExpr("COL_" + pkField.toUpperCase()));
        }

        daoClass.addFieldWithInitializer("String", "INSERT_SQL", insertSqlExpr,
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // SELECT_BY_ID_SQL
        StringBuilder selectByIdBuilder = new StringBuilder();
        selectByIdBuilder.append("\"\"\"\n");
        selectByIdBuilder.append("        SELECT * FROM %s WHERE %s = ?\n");
        selectByIdBuilder.append("        \"\"\"");

        MethodCallExpr selectByIdSqlExpr = new MethodCallExpr(
                StaticJavaParser.parseExpression(selectByIdBuilder.toString()), "formatted");
        selectByIdSqlExpr.addArgument(new NameExpr("TABLE"));
        selectByIdSqlExpr.addArgument(new NameExpr("COL_" + pkField.toUpperCase()));

        daoClass.addFieldWithInitializer("String", "SELECT_BY_ID_SQL", selectByIdSqlExpr,
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // SELECT_ALL_SQL with LIMIT and OFFSET for pagination
        String selectAllFormat;
        if ("ORACLE".equals(vendor)) {
            selectAllFormat = "\"\"\"\n        SELECT * FROM %s ORDER BY %s OFFSET ? ROWS FETCH NEXT ? ROWS ONLY\n        \"\"\"";
        } else {
            selectAllFormat = "\"\"\"\n        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?\n        \"\"\"";
        }
        MethodCallExpr selectAllSqlExpr = new MethodCallExpr(
                StaticJavaParser.parseExpression(selectAllFormat), "formatted");
        selectAllSqlExpr.addArgument(new NameExpr("TABLE"));
        selectAllSqlExpr.addArgument(new NameExpr("COL_" + pkField.toUpperCase()));

        daoClass.addFieldWithInitializer("String", "SELECT_ALL_SQL", selectAllSqlExpr,
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // CREATE FK SELECT SQL constants
        if (relationships != null) {
            for (Relationship rel : relationships) {
                if (rel.getType() == Relationship.Type.MANY_TO_ONE) {
                    String fkColumn = rel.getFkColumn();
                    String constantName = "SELECT_BY_" + fkColumn.toUpperCase() + "_SQL";

                    StringBuilder fkBuilder = new StringBuilder();
                    fkBuilder.append("\"\"\"\n");
                    fkBuilder.append("        SELECT * FROM %s WHERE %s = ?\n");
                    fkBuilder.append("        \"\"\"");

                    MethodCallExpr fkSqlExpr = new MethodCallExpr(
                            StaticJavaParser.parseExpression(fkBuilder.toString()), "formatted");
                    fkSqlExpr.addArgument(new NameExpr("TABLE"));
                    fkSqlExpr.addArgument(new NameExpr("COL_" + fkColumn.toUpperCase()));

                    daoClass.addFieldWithInitializer("String", constantName, fkSqlExpr,
                            Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);
                }
            }
        }

        // UPDATE_SQL
        List<ColumnInfo> updateCols = columnsInfo.stream()
                .filter(c -> !c.name.equalsIgnoreCase(pkField))
                .collect(Collectors.toList());

        String setClause = updateCols.stream().map(c -> "%s = ?").collect(Collectors.joining(", "));

        StringBuilder updateBuilder = new StringBuilder();
        updateBuilder.append("\"\"\"\n");
        updateBuilder.append("        UPDATE %s\n");
        updateBuilder.append("        SET ").append(setClause).append("\n");
        updateBuilder.append("        WHERE %s = ?\n");
        updateBuilder.append("        \"\"\"");

        MethodCallExpr updateSqlExpr = new MethodCallExpr(
                StaticJavaParser.parseExpression(updateBuilder.toString()), "formatted");
        updateSqlExpr.addArgument(new NameExpr("TABLE"));
        for (ColumnInfo c : updateCols) {
            updateSqlExpr.addArgument(new NameExpr("COL_" + c.name.toUpperCase()));
        }
        updateSqlExpr.addArgument(new NameExpr("COL_" + pkField.toUpperCase()));

        daoClass.addFieldWithInitializer("String", "UPDATE_SQL", updateSqlExpr,
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // DELETE_SQL
        StringBuilder deleteBuilder = new StringBuilder();
        deleteBuilder.append("\"\"\"\n");
        deleteBuilder.append("        DELETE FROM %s WHERE %s = ?\n");
        deleteBuilder.append("        \"\"\"");

        MethodCallExpr deleteSqlExpr = new MethodCallExpr(
                StaticJavaParser.parseExpression(deleteBuilder.toString()), "formatted");
        deleteSqlExpr.addArgument(new NameExpr("TABLE"));
        deleteSqlExpr.addArgument(new NameExpr("COL_" + pkField.toUpperCase()));

        daoClass.addFieldWithInitializer("String", "DELETE_SQL", deleteSqlExpr,
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
            boolean pkIsAuto,
            String vendor) {

        MethodDeclaration m = daoClass.addMethod("insert", Modifier.Keyword.PUBLIC);
        m.setType("int");
        m.addParameter("Connection", "conn");
        m.addParameter(modelClassName, StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false));
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        String paramName = StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false);
        String className = modelClassName;

        BlockStmt block = new BlockStmt();
        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        boolean isPostgres = vendor != null && (vendor.contains("POSTGRES") || vendor.contains("POSTGRESQL"));

        Expression psInitializer = pkIsAuto ?
                (isPostgres ? StaticJavaParser.parseExpression("conn.prepareStatement(INSERT_SQL)") : StaticJavaParser.parseExpression("conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)")) :
                StaticJavaParser.parseExpression("conn.prepareStatement(INSERT_SQL)");

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(psInitializer);
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        tryBlock.addStatement(StaticJavaParser.parseStatement("set" + className + "Params(ps, " + paramName + ");"));

        if (pkIsAuto && isPostgres) {
            // Postgres: INSERT ... RETURNING pk
            TryStmt innerTryStmt = new TryStmt();
            BlockStmt innerTryBlock = new BlockStmt();

            VariableDeclarator rsDeclarator = new VariableDeclarator();
            rsDeclarator.setName("rs");
            rsDeclarator.setType(new ClassOrInterfaceType(null, "ResultSet"));
            rsDeclarator.setInitializer(StaticJavaParser.parseExpression("ps.executeQuery()"));
            innerTryStmt.getResources().add(new VariableDeclarationExpr(rsDeclarator));

            BlockStmt ifBlock = new BlockStmt();
            ifBlock.addStatement(StaticJavaParser.parseStatement("int id = rs.getInt(1);"));
            ifBlock.addStatement(StaticJavaParser.parseStatement(
                    paramName + ".set" + StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true) + "(id);"));
            ifBlock.addStatement(new ReturnStmt(new NameExpr("id")));
            innerTryBlock.addStatement(new IfStmt(
                    StaticJavaParser.parseExpression("rs.next()"), ifBlock, null));
            innerTryStmt.setTryBlock(innerTryBlock);
            tryBlock.addStatement(innerTryStmt);
        } else {
            // Non-Postgres or not PK auto: standard executeUpdate with optional getGeneratedKeys
            tryBlock.addStatement(StaticJavaParser.parseStatement("ps.executeUpdate();"));

            if (pkIsAuto) {
                TryStmt innerTryStmt = new TryStmt();
                BlockStmt innerTryBlock = new BlockStmt();

                VariableDeclarator rsDeclarator = new VariableDeclarator();
                rsDeclarator.setName("rs");
                rsDeclarator.setType(new ClassOrInterfaceType(null, "ResultSet"));
                rsDeclarator.setInitializer(StaticJavaParser.parseExpression("ps.getGeneratedKeys()"));
                innerTryStmt.getResources().add(new VariableDeclarationExpr(rsDeclarator));

                BlockStmt ifBlock = new BlockStmt();
                ifBlock.addStatement(StaticJavaParser.parseStatement("int id = rs.getInt(1);"));
                ifBlock.addStatement(StaticJavaParser.parseStatement(
                        paramName + ".set" + StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true) + "(id);"));
                ifBlock.addStatement(new ReturnStmt(new NameExpr("id")));
                innerTryBlock.addStatement(new IfStmt(
                        StaticJavaParser.parseExpression("rs.next()"), ifBlock, null));
                innerTryStmt.setTryBlock(innerTryBlock);
                tryBlock.addStatement(innerTryStmt);
            }
        }

        tryStmt.setTryBlock(tryBlock);
        block.addStatement(tryStmt);

        if (pkIsAuto) {
            block.addStatement(new ReturnStmt(new NameExpr("-1")));
        } else {
            ColumnInfo pkCol = columnsInfo.stream().filter(c -> c.name.equals(pkField)).findFirst().orElse(null);
            String returnExpr;
            if (pkCol != null && pkCol.isForeignKey) {
                String baseName = pkField.toLowerCase().endsWith("_id") ? pkField.substring(0, pkField.length() - 3) : pkField;
                String relName = StringUtils.toCamelCase(baseName, naming.getUppercaseAcronyms(), true);
                String relGetter = paramName + ".get" + relName + "()";
                String relPk = pkCol.referencedTable + "_id";
                String relPkCamel = StringUtils.toCamelCase(relPk, naming.getUppercaseAcronyms(), true);
                returnExpr = relGetter + ".get" + relPkCamel + "()";
            } else {
                String pkCamel = StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true);
                returnExpr = paramName + ".get" + pkCamel + "()";
            }
            block.addStatement(new ReturnStmt(StaticJavaParser.parseExpression(returnExpr)));
        }

        m.setBody(block);
    }

    private static void createBulkInsertMethod(
            ClassOrInterfaceDeclaration daoClass,
            String modelClassName,
            String pkField,
            String idType,
            List<ColumnInfo> columnsInfo,
            NamingStrategyConfig naming,
            boolean pkIsAuto,
            String vendor) {

        MethodDeclaration m = daoClass.addMethod("insertAll", Modifier.Keyword.PUBLIC);
        m.setType("int[]");
        m.addParameter("Connection", "conn");
        m.addParameter("List<" + modelClassName + ">", StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false) + "s");
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        String paramName = StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false) + "s";
        String className = modelClassName.replace("DTO", "");
        String itemVar = StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false);
        String pkSetter = ".set" + StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true) + "";

        BlockStmt block = new BlockStmt();
        block.addStatement(StaticJavaParser.parseStatement("if (" + paramName + " == null || " + paramName + ".isEmpty()) return new int[0];"));

        // results declared before try (in scope for return)
        block.addStatement(StaticJavaParser.parseStatement("int[] results = new int[0];"));

        // Null-check with index (so we can show which index caused the problem)
        block.addStatement(StaticJavaParser.parseStatement(
                "for (int i = 0; i < " + paramName + ".size(); i++) {\n" +
                        "    if (" + paramName + ".get(i) == null) throw new IllegalArgumentException(\"Null DTO at index \" + i + \" in batch insert\");\n" +
                        "}"));

        boolean isPostgres = vendor != null && (vendor.contains("POSTGRES") || vendor.contains("POSTGRESQL"));

        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        if (pkIsAuto && isPostgres) {
            // For Postgres with RETURNING we cannot rely on executeBatch to return generated keys in the same way,
            // so we execute per-row and collect generated keys while returning array of update counts (1 = success)
            tryBlock.addStatement(StaticJavaParser.parseStatement("results = new int[" + paramName + ".size()];"));

            VariableDeclarator psDeclarator = new VariableDeclarator();
            psDeclarator.setName("ps");
            psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
            psDeclarator.setInitializer(StaticJavaParser.parseExpression("conn.prepareStatement(INSERT_SQL)"));
            tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

            // Create for loop: for(int i = 0; i < paramName.size(); i++)
            ForStmt forIdx = new ForStmt();

            // Create variable declaration: int i = 0
            VariableDeclarationExpr initExpr = new VariableDeclarationExpr(
                    new VariableDeclarator(new PrimitiveType(PrimitiveType.Primitive.INT), "i", new IntegerLiteralExpr("0"))
            );

            // Set initialization
            NodeList<Expression> initList = new NodeList<>();
            initList.add(initExpr);
            forIdx.setInitialization(initList);

            // Set compare condition
            forIdx.setCompare(StaticJavaParser.parseExpression("i < " + paramName + ".size()"));

            // Set update expression (i++)
            NodeList<Expression> updateList = new NodeList<>();
            updateList.add(new UnaryExpr(new NameExpr("i"), UnaryExpr.Operator.POSTFIX_INCREMENT));
            forIdx.setUpdate(updateList);

            // Create for loop body
            BlockStmt forBody = new BlockStmt();
            forBody.addStatement(StaticJavaParser.parseStatement(modelClassName + " item = " + paramName + ".get(i);"));
            forBody.addStatement(StaticJavaParser.parseStatement("set" + className + "Params(ps, item);"));

            // Create inner try-with-resources for ResultSet
            TryStmt innerTryStmt = new TryStmt();
            VariableDeclarator rsDeclarator = new VariableDeclarator();
            rsDeclarator.setName("rs");
            rsDeclarator.setType(new ClassOrInterfaceType(null, "ResultSet"));
            rsDeclarator.setInitializer(StaticJavaParser.parseExpression("ps.executeQuery()"));
            innerTryStmt.getResources().add(new VariableDeclarationExpr(rsDeclarator));

            BlockStmt innerTryBody = new BlockStmt();
            BlockStmt ifBlock = new BlockStmt();
            ifBlock.addStatement(StaticJavaParser.parseStatement("item" + pkSetter + "(rs.getInt(1));"));
            ifBlock.addStatement(StaticJavaParser.parseStatement("results[i] = 1;"));

            innerTryBody.addStatement(new IfStmt(
                    StaticJavaParser.parseExpression("rs.next()"), ifBlock, null));
            innerTryStmt.setTryBlock(innerTryBody);

            forBody.addStatement(innerTryStmt);
            forIdx.setBody(forBody);
            tryBlock.addStatement(forIdx);

            tryStmt.setTryBlock(tryBlock);
            block.addStatement(tryStmt);
            block.addStatement(new ReturnStmt(new NameExpr("results")));
            m.setBody(block);
            return;
        }

        // Non-PostgreSQL or non-auto-increment case
        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(pkIsAuto ?
                StaticJavaParser.parseExpression("conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)") :
                StaticJavaParser.parseExpression("conn.prepareStatement(INSERT_SQL)"));
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        // Add batch entries
        ForEachStmt batchLoop = new ForEachStmt();
        batchLoop.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, modelClassName), itemVar));
        batchLoop.setIterable(new NameExpr(paramName));
        BlockStmt batchBody = new BlockStmt();
        batchBody.addStatement(StaticJavaParser.parseStatement("set" + className + "Params(ps, " + itemVar + ");"));
        batchBody.addStatement(StaticJavaParser.parseStatement("ps.addBatch();"));
        batchLoop.setBody(batchBody);
        tryBlock.addStatement(batchLoop);

        // executeBatch and assign results
        tryBlock.addStatement(StaticJavaParser.parseStatement("results = ps.executeBatch();"));

        if (pkIsAuto) {
            // determine proper ResultSet getter based on idType (int/long/String/other)
            String keyRetrieval;
            String idTypeNormalized = idType == null ? "" : idType.trim();
            if ("int".equalsIgnoreCase(idTypeNormalized) || "Integer".equalsIgnoreCase(idTypeNormalized)) {
                keyRetrieval = "rs.getInt(1)";
            } else if ("long".equalsIgnoreCase(idTypeNormalized) || "Long".equalsIgnoreCase(idTypeNormalized)) {
                keyRetrieval = "rs.getLong(1)";
            } else if ("String".equalsIgnoreCase(idTypeNormalized)) {
                keyRetrieval = "rs.getString(1)";
            } else if (!idTypeNormalized.isEmpty()) {
                // fallback to typed getObject if a wrapper class name provided
                keyRetrieval = "rs.getObject(1, " + idTypeNormalized + ".class)";
            } else {
                // ultimate fallback
                keyRetrieval = "rs.getObject(1)";
            }

            TryStmt innerTryStmt = new TryStmt();
            BlockStmt innerTryBlock = new BlockStmt();

            VariableDeclarator rsDeclarator = new VariableDeclarator();
            rsDeclarator.setName("rs");
            rsDeclarator.setType(new ClassOrInterfaceType(null, "ResultSet"));
            rsDeclarator.setInitializer(StaticJavaParser.parseExpression("ps.getGeneratedKeys()"));
            innerTryStmt.getResources().add(new VariableDeclarationExpr(rsDeclarator));

            innerTryBlock.addStatement(StaticJavaParser.parseStatement("int index = 0;"));
            WhileStmt whileStmt = new WhileStmt();
            whileStmt.setCondition(StaticJavaParser.parseExpression("rs.next() && index < " + paramName + ".size()"));
            BlockStmt whileBody = new BlockStmt();

            // map key to DTO using chosen getter and include index in potential debug
            whileBody.addStatement(StaticJavaParser.parseStatement(
                    "try {\n" +
                            "    " + paramName + ".get(index)" + pkSetter + "(" + keyRetrieval + ");\n" +
                            "} catch (Exception e) {\n" +
                            "    // if mapping the key fails, wrap to give context\n" +
                            "    throw new SQLException(\"Failed to set generated key for index \" + index + \": \" + e.getMessage(), e);\n" +
                            "}"
            ));
            whileBody.addStatement(StaticJavaParser.parseStatement("index++;"));
            whileStmt.setBody(whileBody);
            innerTryBlock.addStatement(whileStmt);
            innerTryStmt.setTryBlock(innerTryBlock);
            tryBlock.addStatement(innerTryStmt);
        }

        tryStmt.setTryBlock(tryBlock);
        block.addStatement(tryStmt);

        // return results
        block.addStatement(new ReturnStmt(new NameExpr("results")));
        m.setBody(block);
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

        BlockStmt block = new BlockStmt();
        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(StaticJavaParser.parseExpression("conn.prepareStatement(SELECT_BY_ID_SQL)"));
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        tryBlock.addStatement(StaticJavaParser.parseStatement("ps." + getPreparedStatementSetter(idType) + "(1, id);"));

        TryStmt innerTryStmt = new TryStmt();
        BlockStmt innerTryBlock = new BlockStmt();

        VariableDeclarator rsDeclarator = new VariableDeclarator();
        rsDeclarator.setName("rs");
        rsDeclarator.setType(new ClassOrInterfaceType(null, "ResultSet"));
        rsDeclarator.setInitializer(StaticJavaParser.parseExpression("ps.executeQuery()"));
        innerTryStmt.getResources().add(new VariableDeclarationExpr(rsDeclarator));

        innerTryBlock.addStatement(new ReturnStmt(
                StaticJavaParser.parseExpression("rs.next() ? extract(rs) : null")));
        innerTryStmt.setTryBlock(innerTryBlock);
        tryBlock.addStatement(innerTryStmt);

        tryStmt.setTryBlock(tryBlock);
        block.addStatement(tryStmt);

        m.setBody(block);
    }

    private static void createFindAllMethod(
            ClassOrInterfaceDeclaration daoClass,
            String tableName,
            String modelClassName,
            List<ColumnInfo> columnsInfo,
            String pkField,
            NamingStrategyConfig naming,
            String vendor) {

        MethodDeclaration m = daoClass.addMethod("findAll", Modifier.Keyword.PUBLIC);
        m.setType("List<" + modelClassName + ">");
        m.addParameter("Connection", "conn");
        m.addParameter("int", "page");
        m.addParameter("int", "pageSize");
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        BlockStmt block = new BlockStmt();

        block.addStatement(StaticJavaParser.parseStatement("if (page < 1) throw new IllegalArgumentException(\"Page must be at least 1\");"));
        block.addStatement(StaticJavaParser.parseStatement("if (pageSize < 1) throw new IllegalArgumentException(\"Page size must be at least 1\");"));

        block.addStatement(StaticJavaParser.parseStatement("List<" + modelClassName + "> list = new ArrayList<>();"));

        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(StaticJavaParser.parseExpression("conn.prepareStatement(SELECT_ALL_SQL)"));
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        boolean isOracle = "ORACLE".equals(vendor);
        if (isOracle) {
            tryBlock.addStatement(StaticJavaParser.parseStatement("ps.setInt(1, (page - 1) * pageSize);"));
            tryBlock.addStatement(StaticJavaParser.parseStatement("ps.setInt(2, pageSize);"));
        } else {
            tryBlock.addStatement(StaticJavaParser.parseStatement("ps.setInt(1, pageSize);"));
            tryBlock.addStatement(StaticJavaParser.parseStatement("ps.setInt(2, (page - 1) * pageSize);"));
        }

        TryStmt innerTryStmt = new TryStmt();
        BlockStmt innerTryBlock = new BlockStmt();

        VariableDeclarator rsDeclarator = new VariableDeclarator();
        rsDeclarator.setName("rs");
        rsDeclarator.setType(new ClassOrInterfaceType(null, "ResultSet"));
        rsDeclarator.setInitializer(StaticJavaParser.parseExpression("ps.executeQuery()"));
        innerTryStmt.getResources().add(new VariableDeclarationExpr(rsDeclarator));

        WhileStmt whileStmt = new WhileStmt();
        whileStmt.setCondition(StaticJavaParser.parseExpression("rs.next()"));
        BlockStmt whileBlock = new BlockStmt();
        whileBlock.addStatement(StaticJavaParser.parseStatement("list.add(extract(rs));"));
        whileStmt.setBody(whileBlock);
        innerTryBlock.addStatement(whileStmt);

        innerTryStmt.setTryBlock(innerTryBlock);
        tryBlock.addStatement(innerTryStmt);

        tryStmt.setTryBlock(tryBlock);
        block.addStatement(tryStmt);

        block.addStatement(new ReturnStmt(new NameExpr("list")));
        m.setBody(block);
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
                String paramFkName = StringUtils.toCamelCase(fkColumn, naming.getUppercaseAcronyms(), false);

                MethodDeclaration m = daoClass.addMethod(methodName, Modifier.Keyword.PUBLIC);
                m.setType("List<" + modelClassName + ">");
                m.addParameter("Connection", "conn");
                m.addParameter("int", paramFkName);
                m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

                BlockStmt block = new BlockStmt();
                block.addStatement(StaticJavaParser.parseStatement("List<" + modelClassName + "> list = new ArrayList<>();"));

                TryStmt tryStmt = new TryStmt();
                BlockStmt tryBlock = new BlockStmt();

                VariableDeclarator psDeclarator = new VariableDeclarator();
                psDeclarator.setName("ps");
                psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
                psDeclarator.setInitializer(StaticJavaParser.parseExpression("conn.prepareStatement(" + constantName + ")"));
                tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

                tryBlock.addStatement(StaticJavaParser.parseStatement(
                        "ps.setInt(1, " + paramFkName + ");"));

                TryStmt innerTryStmt = new TryStmt();
                BlockStmt innerTryBlock = new BlockStmt();

                VariableDeclarator rsDeclarator = new VariableDeclarator();
                rsDeclarator.setName("rs");
                rsDeclarator.setType(new ClassOrInterfaceType(null, "ResultSet"));
                rsDeclarator.setInitializer(StaticJavaParser.parseExpression("ps.executeQuery()"));
                innerTryStmt.getResources().add(new VariableDeclarationExpr(rsDeclarator));

                WhileStmt whileStmt = new WhileStmt();
                whileStmt.setCondition(StaticJavaParser.parseExpression("rs.next()"));
                BlockStmt whileBlock = new BlockStmt();
                whileBlock.addStatement(StaticJavaParser.parseStatement("list.add(extract(rs));"));
                whileStmt.setBody(whileBlock);
                innerTryBlock.addStatement(whileStmt);

                innerTryStmt.setTryBlock(innerTryBlock);
                tryBlock.addStatement(innerTryStmt);

                tryStmt.setTryBlock(tryBlock);
                block.addStatement(tryStmt);

                block.addStatement(new ReturnStmt(new NameExpr("list")));
                m.setBody(block);
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
        String className = modelClassName.replace("DTO", "");
        String pkGetter = paramName + ".get" + StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true) + "()";

        BlockStmt block = new BlockStmt();
        block.addStatement(StaticJavaParser.parseStatement("if (" + pkGetter + " == 0) throw new IllegalArgumentException(\"Primary key cannot be null for update\");"));

        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(StaticJavaParser.parseExpression("conn.prepareStatement(UPDATE_SQL)"));
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        tryBlock.addStatement(StaticJavaParser.parseStatement("set" + className + "Params(ps, " + paramName + ");"));
        tryBlock.addStatement(StaticJavaParser.parseStatement(
                "ps." + getPreparedStatementSetter(idType) + "(" + (updateCols.size() + 1) + ", " + pkGetter + ");"));

        tryBlock.addStatement(new ReturnStmt(
                StaticJavaParser.parseExpression("ps.executeUpdate() > 0")));
        tryStmt.setTryBlock(tryBlock);
        block.addStatement(tryStmt);

        m.setBody(block);
    }

    private static void createBulkUpdateMethod(
            ClassOrInterfaceDeclaration daoClass,
            String modelClassName,
            String pkField,
            String idType,
            List<ColumnInfo> columnsInfo,
            NamingStrategyConfig naming) {

        MethodDeclaration m = daoClass.addMethod("updateAll", Modifier.Keyword.PUBLIC);
        m.setType("int[]");
        m.addParameter("Connection", "conn");
        m.addParameter("List<" + modelClassName + ">", StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false) + "s");
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        List<ColumnInfo> updateCols = columnsInfo.stream()
                .filter(c -> !c.name.equalsIgnoreCase(pkField))
                .collect(Collectors.toList());

        String paramName = StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false) + "s";
        String className = modelClassName.replace("DTO", "");
        String itemVar = StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false);
        String pkGetter = itemVar + ".get" + StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true) + "()";

        BlockStmt block = new BlockStmt();
        block.addStatement(StaticJavaParser.parseStatement("if (" + paramName + " == null || " + paramName + ".isEmpty()) return new int[0];"));

        // Check for null DTOs and null PKs
        ForEachStmt checkLoop = new ForEachStmt();
        checkLoop.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, modelClassName), itemVar));
        checkLoop.setIterable(new NameExpr(paramName));
        BlockStmt checkBody = new BlockStmt();
        checkBody.addStatement(new IfStmt(StaticJavaParser.parseExpression(itemVar + " == null"), new ThrowStmt(StaticJavaParser.parseExpression("new IllegalArgumentException(\"Null DTO in batch update\")")), null));
        checkBody.addStatement(new IfStmt(StaticJavaParser.parseExpression(pkGetter + " == 0"), new ThrowStmt(StaticJavaParser.parseExpression("new IllegalArgumentException(\"Null primary key in batch update\")")), null));
        checkLoop.setBody(checkBody);
        block.addStatement(checkLoop);

        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(StaticJavaParser.parseExpression("conn.prepareStatement(UPDATE_SQL)"));
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        ForEachStmt forEachStmt = new ForEachStmt();
        forEachStmt.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, modelClassName), itemVar));
        forEachStmt.setIterable(new NameExpr(paramName));

        BlockStmt forEachBody = new BlockStmt();
        forEachBody.addStatement(StaticJavaParser.parseStatement("set" + className + "Params(ps, " + itemVar + ");"));
        forEachBody.addStatement(StaticJavaParser.parseStatement(
                "ps." + getPreparedStatementSetter(idType) + "(" + (updateCols.size() + 1) + ", " + pkGetter + ");"));
        forEachBody.addStatement(StaticJavaParser.parseStatement("ps.addBatch();"));
        forEachStmt.setBody(forEachBody);

        tryBlock.addStatement(forEachStmt);
        tryBlock.addStatement(StaticJavaParser.parseStatement("int[] results = ps.executeBatch();"));
        tryBlock.addStatement(new ReturnStmt(new NameExpr("results")));

        tryStmt.setTryBlock(tryBlock);
        block.addStatement(tryStmt);

        m.setBody(block);
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

        BlockStmt block = new BlockStmt();
        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(StaticJavaParser.parseExpression("conn.prepareStatement(DELETE_SQL)"));
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        tryBlock.addStatement(StaticJavaParser.parseStatement("ps." + getPreparedStatementSetter(idType) + "(1, id);"));
        tryBlock.addStatement(new ReturnStmt(
                StaticJavaParser.parseExpression("ps.executeUpdate() > 0")));

        tryStmt.setTryBlock(tryBlock);
        block.addStatement(tryStmt);

        m.setBody(block);
    }

    private static void createBulkDeleteMethod(
            ClassOrInterfaceDeclaration daoClass,
            String pkField,
            String idType,
            NamingStrategyConfig naming) {

        MethodDeclaration m = daoClass.addMethod("deleteAllByIds", Modifier.Keyword.PUBLIC);
        m.setType("int[]");
        m.addParameter("Connection", "conn");
        m.addParameter("List<" + idType + ">", "ids");
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        BlockStmt block = new BlockStmt();
        block.addStatement(StaticJavaParser.parseStatement("if (ids == null || ids.isEmpty()) return new int[0];"));

        // Check for null IDs
        ForEachStmt checkLoop = new ForEachStmt();
        checkLoop.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, idType), "id"));
        checkLoop.setIterable(new NameExpr("ids"));
        BlockStmt checkBody = new BlockStmt();
        checkBody.addStatement(new IfStmt(StaticJavaParser.parseExpression("id == null"), new ThrowStmt(StaticJavaParser.parseExpression("new IllegalArgumentException(\"Null ID in batch delete\")")), null));
        checkLoop.setBody(checkBody);
        block.addStatement(checkLoop);

        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(StaticJavaParser.parseExpression("conn.prepareStatement(DELETE_SQL)"));
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        ForEachStmt forEachStmt = new ForEachStmt();
        forEachStmt.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, idType), "id"));
        forEachStmt.setIterable(new NameExpr("ids"));

        BlockStmt forEachBody = new BlockStmt();
        forEachBody.addStatement(StaticJavaParser.parseStatement("ps." + getPreparedStatementSetter(idType) + "(1, id);"));
        forEachBody.addStatement(StaticJavaParser.parseStatement("ps.addBatch();"));
        forEachStmt.setBody(forEachBody);

        tryBlock.addStatement(forEachStmt);
        tryBlock.addStatement(StaticJavaParser.parseStatement("int[] results = ps.executeBatch();"));
        tryBlock.addStatement(new ReturnStmt(new NameExpr("results")));

        tryStmt.setTryBlock(tryBlock);
        block.addStatement(tryStmt);

        m.setBody(block);
    }

    private static void createSetParamsMethod(
            ClassOrInterfaceDeclaration daoClass,
            String modelClassName,
            List<ColumnInfo> columnsInfo,
            String pkField,
            boolean pkIsAuto,
            NamingStrategyConfig naming) {

        String className = modelClassName.replace("DTO", "");
        MethodDeclaration m = daoClass.addMethod("set" + className + "Params", Modifier.Keyword.PRIVATE);
        m.setType("void");
        m.addParameter("PreparedStatement", "ps");
        m.addParameter(modelClassName, StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false));
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        List<ColumnInfo> paramsCols = columnsInfo.stream()
                .filter(c -> !(pkIsAuto && c.name.equals(pkField)))
                .collect(Collectors.toList());

        String paramName = StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false);

        BlockStmt block = new BlockStmt();

        for (int i = 0; i < paramsCols.size(); i++) {
            ColumnInfo c = paramsCols.get(i);
            String getter = paramName + ".get" + StringUtils.toCamelCase(c.name, naming.getUppercaseAcronyms(), true) + "()";
            int idx = i + 1;

            if (c.isForeignKey) {
                String baseName = c.name.toLowerCase().endsWith("_id") ? c.name.substring(0, c.name.length() - 3) : c.name;
                String relationshipName = StringUtils.toCamelCase(baseName, naming.getUppercaseAcronyms(), true);
                String relationGetter = paramName + ".get" + relationshipName + "()";
                String relatedPk = c.referencedTable + "_id";
                String relatedPkCamel = StringUtils.toCamelCase(relatedPk, naming.getUppercaseAcronyms(), true);

                Expression condition = StaticJavaParser.parseExpression(
                        relationGetter + " != null && " + relationGetter + ".get" + relatedPkCamel + "() > 0");
                BlockStmt thenBlock = new BlockStmt();
                thenBlock.addStatement(StaticJavaParser.parseStatement(
                        "ps.setInt(" + idx + ", " + relationGetter + ".get" + relatedPkCamel + "());"));
                BlockStmt elseBlock = new BlockStmt();
                elseBlock.addStatement(StaticJavaParser.parseStatement("ps.setNull(" + idx + ", Types.INTEGER);"));
                block.addStatement(new IfStmt(condition, thenBlock, elseBlock));
            } else if ("java.time.LocalDateTime".equals(c.javaType)) {
                String varName = "updateTime" + idx;
                Expression defaultExpr = StaticJavaParser.parseExpression(
                        "Objects.requireNonNullElse(" + getter + ", LocalDateTime.now())");
                block.addStatement(StaticJavaParser.parseStatement("LocalDateTime " + varName + " = " + defaultExpr + ";"));
                block.addStatement(StaticJavaParser.parseStatement("ps.setTimestamp(" + idx + ", Timestamp.valueOf(" + varName + "));"));
            } else if ("java.time.LocalDate".equals(c.javaType)) {
                String varName = "val" + idx;
                block.addStatement(StaticJavaParser.parseStatement("java.time.LocalDate " + varName + " = " + getter + ";"));
                Expression condition = StaticJavaParser.parseExpression(varName + " != null");
                BlockStmt thenBlock = new BlockStmt();
                thenBlock.addStatement(StaticJavaParser.parseStatement("ps.setDate(" + idx + ", java.sql.Date.valueOf(" + varName + "));"));
                BlockStmt elseBlock = new BlockStmt();
                elseBlock.addStatement(StaticJavaParser.parseStatement("ps.setNull(" + idx + ", Types.DATE);"));
                block.addStatement(new IfStmt(condition, thenBlock, elseBlock));
            } else if ("java.time.LocalTime".equals(c.javaType)) {
                String varName = "val" + idx;
                block.addStatement(StaticJavaParser.parseStatement("java.time.LocalTime " + varName + " = " + getter + ";"));
                Expression condition = StaticJavaParser.parseExpression(varName + " != null");
                BlockStmt thenBlock = new BlockStmt();
                thenBlock.addStatement(StaticJavaParser.parseStatement("ps.setTime(" + idx + ", java.sql.Time.valueOf(" + varName + "));"));
                BlockStmt elseBlock = new BlockStmt();
                elseBlock.addStatement(StaticJavaParser.parseStatement("ps.setNull(" + idx + ", Types.TIME);"));
                block.addStatement(new IfStmt(condition, thenBlock, elseBlock));
            } else if (c.javaType.equals("String") && c.isBinary) {
                String varName = "val" + idx;
                block.addStatement(StaticJavaParser.parseStatement("String " + varName + " = " + getter + ";"));
                Expression condition = StaticJavaParser.parseExpression(varName + " != null");
                BlockStmt thenBlock = new BlockStmt();
                thenBlock.addStatement(StaticJavaParser.parseStatement("ps.setBytes(" + idx + ", " + varName + ".getBytes());"));
                BlockStmt elseBlock = new BlockStmt();
                elseBlock.addStatement(StaticJavaParser.parseStatement("ps.setNull(" + idx + ", Types.BINARY);"));
                block.addStatement(new IfStmt(condition, thenBlock, elseBlock));
            } else if (Arrays.asList("Integer", "Long", "Float", "Double", "java.math.BigDecimal", "Boolean").contains(c.javaType)) {
                String varName = "val" + idx;
                block.addStatement(StaticJavaParser.parseStatement(c.javaType + " " + varName + " = " + getter + ";"));
                Expression condition = StaticJavaParser.parseExpression(varName + " != null");
                BlockStmt thenBlock = new BlockStmt();
                thenBlock.addStatement(StaticJavaParser.parseStatement(
                        "ps." + getPreparedStatementSetter(c.javaType) + "(" + idx + ", " + varName + ");"));
                BlockStmt elseBlock = new BlockStmt();
                elseBlock.addStatement(StaticJavaParser.parseStatement(
                        "ps.setNull(" + idx + ", " + getTypesConstant(c.javaType) + ");"));
                block.addStatement(new IfStmt(condition, thenBlock, elseBlock));
            } else {
                block.addStatement(StaticJavaParser.parseStatement(
                        "ps." + getPreparedStatementSetter(c.javaType) + "(" + idx + ", " + getter + ");"));
            }
        }

        m.setBody(block);
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

        BlockStmt block = new BlockStmt();
        block.addStatement(StaticJavaParser.parseStatement(
                modelClassName + " " + objectName + " = new " + modelClassName + "();"));

        for (ColumnInfo c : columnsInfo) {
            String colConst = "COL_" + c.name.toUpperCase();
            String setter = objectName + ".set" + StringUtils.toCamelCase(c.name, naming.getUppercaseAcronyms(), true);

            if ("java.time.LocalDateTime".equals(c.javaType)) {
                block.addStatement(StaticJavaParser.parseStatement("Timestamp " + c.name + " = rs.getTimestamp(" + colConst + ");"));
                block.addStatement(new IfStmt(
                        StaticJavaParser.parseExpression(c.name + " != null"),
                        new ExpressionStmt(StaticJavaParser.parseExpression(setter + "(" + c.name + ".toLocalDateTime())")),
                        null));
            } else if ("java.time.LocalDate".equals(c.javaType)) {
                block.addStatement(StaticJavaParser.parseStatement("java.sql.Date " + c.name + " = rs.getDate(" + colConst + ");"));
                block.addStatement(new IfStmt(
                        StaticJavaParser.parseExpression(c.name + " != null"),
                        new ExpressionStmt(StaticJavaParser.parseExpression(setter + "(" + c.name + ".toLocalDate())")),
                        null));
            } else if ("java.time.LocalTime".equals(c.javaType)) {
                block.addStatement(StaticJavaParser.parseStatement("java.sql.Time " + c.name + " = rs.getTime(" + colConst + ");"));
                block.addStatement(new IfStmt(
                        StaticJavaParser.parseExpression(c.name + " != null"),
                        new ExpressionStmt(StaticJavaParser.parseExpression(setter + "(" + c.name + ".toLocalTime())")),
                        null));
            } else if (c.isForeignKey) {
                String baseName = c.name.toLowerCase().endsWith("_id") ? c.name.substring(0, c.name.length() - 3) : c.name;
                String relationshipName = StringUtils.toCamelCase(baseName, naming.getUppercaseAcronyms(), true);
                String relatedObjectName = StringUtils.toCamelCase(baseName, naming.getUppercaseAcronyms(), false);
                String relatedClass = StringUtils.toCamelCase(c.referencedTable, naming.getUppercaseAcronyms(), true);
                String relatedPk = c.referencedTable + "_id";
                String relatedPkCamel = StringUtils.toCamelCase(relatedPk, naming.getUppercaseAcronyms(), true);

                block.addStatement(StaticJavaParser.parseStatement(
                        "Integer " + c.name + " = rs.getObject(" + colConst + ", Integer.class);"));
                block.addStatement(StaticJavaParser.parseStatement(setter + "(" + c.name + ");"));
                BlockStmt ifBlock = new BlockStmt();
                ifBlock.addStatement(StaticJavaParser.parseStatement(
                        relatedClass + " " + relatedObjectName + " = new " + relatedClass + "();"));
                ifBlock.addStatement(StaticJavaParser.parseStatement(
                        relatedObjectName + ".set" + relatedPkCamel + "(" + c.name + ");"));
                ifBlock.addStatement(StaticJavaParser.parseStatement(
                        objectName + ".set" + relationshipName + "(" + relatedObjectName + ");"));
                block.addStatement(new IfStmt(
                        StaticJavaParser.parseExpression(c.name + " != null && " + c.name + " > 0"),
                        ifBlock,
                        null));
            } else if (c.javaType.equals("String") && c.isBinary) {
                block.addStatement(StaticJavaParser.parseStatement("byte[] bytes = rs.getBytes(" + colConst + ");"));
                block.addStatement(StaticJavaParser.parseStatement(setter + "(bytes != null ? new String(bytes) : null);"));
            } else if (Arrays.asList("Integer", "Long", "Float", "Double", "java.math.BigDecimal", "Boolean").contains(c.javaType)) {
                block.addStatement(StaticJavaParser.parseStatement(
                        c.javaType + " " + c.name + " = rs.getObject(" + colConst + ", " + c.javaType + ".class);"));
                block.addStatement(StaticJavaParser.parseStatement(setter + "(" + c.name + ");"));
            } else {
                block.addStatement(StaticJavaParser.parseStatement(
                        setter + "(rs." + getResultSetGetter(c.javaType) + "(" + colConst + "));"));
            }
        }

        block.addStatement(new ReturnStmt(new NameExpr(objectName)));
        m.setBody(block);
    }

    private static void writeToFile(TargetConfig target, String packageName, String className, CompilationUnit cu) throws IOException {
        Path outputPath = Paths.get(target.getOutputDirectory(), packageName.replace(".", "/"), className + ".java");
        Files.createDirectories(outputPath.getParent());
        Files.writeString(outputPath, cu.toString());
        System.out.println("Generated DAO: " + outputPath);
    }

    /* ---------- utility methods ---------- */

    private static String mapDbTypeToJava(String dbType, String columnName, int decimalDigits, int columnSize, String vendor) {
        // Handle null columnName safely
        if (columnName == null) {
            return "String";
        }

        // Convert to lowercase for case-insensitive comparison
        String colNameLower = columnName.toLowerCase();

        // Special handling for specific column names
        // Handle address as String (not as Address object)
        if (colNameLower.equals("address") || colNameLower.equals("address2")) {
            return "String";
        }

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

        // Vendor-specific adjustments
        if ("ORACLE".equals(vendor) && "DATE".equals(dbType)) {
            return "java.time.LocalDateTime";
        }

        // Database type mapping - this takes precedence over column name patterns
        return switch (dbType) {
            case "SERIAL" -> "Integer";
            case "VARCHAR", "VARCHAR2", "CHAR", "TEXT", "CLOB", "LONGTEXT", "MEDIUMTEXT", "NVARCHAR2", "NCLOB", "LONG" -> "String";
            case "INT", "INTEGER", "SMALLINT", "TINYINT", "YEAR", "INT4", "INT2" -> {
                // special-case: MySQL TINYINT(1) commonly used for boolean
                if ("TINYINT".equals(dbType) && columnSize == 1) {
                    yield "Boolean";
                }
                yield "Integer";
            }
            case "BIGINT", "INT8" -> "Long";
            case "DECIMAL", "NUMERIC", "NUMBER" -> {
                // Use BigDecimal for monetary values or high precision decimals
                if (decimalDigits > 0 || colNameLower.contains("amount") || colNameLower.contains("price") ||
                        colNameLower.contains("cost") || colNameLower.contains("rate")) {
                    yield "java.math.BigDecimal";
                } else {
                    yield "Long";
                }
            }
            case "FLOAT", "REAL", "BINARY_FLOAT" -> {
                // For monetary columns, use BigDecimal even if stored as FLOAT
                if (colNameLower.contains("amount") || colNameLower.contains("price") ||
                        colNameLower.contains("cost") || colNameLower.contains("rate")) {
                    yield "java.math.BigDecimal";
                }
                yield "Float";
            }
            case "DOUBLE", "DOUBLE PRECISION", "BINARY_DOUBLE" -> {
                // For monetary columns, use BigDecimal even if stored as DOUBLE
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
            case "BLOB", "BYTEA", "BINARY", "VARBINARY", "RAW" -> "byte[]";
            case "UUID" -> "java.util.UUID";
            default -> "String";
        };
    }

    private static String mapJavaTypeToMethod(String javaType) {
        return switch (javaType) {
            case "Integer" -> "int";
            case "Long" -> "long";
            case "Float" -> "float";
            case "Double" -> "double";
            case "Boolean" -> "boolean";
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
            case "Boolean" -> "getBoolean";
            case "java.time.LocalDate" -> "getDate";
            case "java.time.LocalTime" -> "getTime";
            case "java.time.LocalDateTime" -> "getTimestamp";
            case "java.math.BigDecimal" -> "getBigDecimal";
            case "byte[]" -> "getBytes";
            case "java.util.UUID" -> "getObject";
            case "java.util.Map<String, Object>" -> "getObject";
            case "java.util.List<Object>" -> "getObject";
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
            case "Boolean" -> "setBoolean";
            case "java.time.LocalDate" -> "setDate";
            case "java.time.LocalTime" -> "setTime";
            case "java.time.LocalDateTime" -> "setTimestamp";
            case "java.math.BigDecimal" -> "setBigDecimal";
            case "byte[]" -> "setBytes";
            case "java.util.UUID" -> "setObject";
            case "java.util.Map<String, Object>" -> "setObject";
            case "java.util.List<Object>" -> "setObject";
            default -> "setObject";
        };
    }

    private static String getTypesConstant(String javaType) {
        return switch (javaType) {
            case "Integer" -> "Types.INTEGER";
            case "Long" -> "Types.BIGINT";
            case "Float" -> "Types.FLOAT";
            case "Double" -> "Types.DOUBLE";
            case "Boolean" -> "Types.BOOLEAN";
            case "java.time.LocalDate" -> "Types.DATE";
            case "java.time.LocalTime" -> "Types.TIME";
            case "java.time.LocalDateTime" -> "Types.TIMESTAMP";
            case "java.math.BigDecimal" -> "Types.DECIMAL";
            case "byte[]" -> "Types.BINARY";
            case "String" -> "Types.VARCHAR";
            default -> "Types.OTHER";
        };
    }
}