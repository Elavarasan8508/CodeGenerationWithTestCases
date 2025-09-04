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
import com.github.javaparser.ast.type.TypeParameter;

import java.io.IOException;
import java.nio.file.*;
import java.sql.DatabaseMetaData;
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
        String daoClassName = "Jdbc" + className + "Dao";
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

            // Improved PK detection: Prioritize columns ending with '_no' or 'id', or use first column
            if (pkField == null && colName.equalsIgnoreCase("td_account_no")) { // Example: Prioritize TD_ACCOUNT_NO as per problem
                pkField = colName;
                idType = javaType;
                pkIsAuto = isAutoIncrement;
            } else if (pkField == null && colName.equalsIgnoreCase("id")) {
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
        cu.addImport(target.getBasePackage() + ".pojo.*");
        cu.addImport("org.slf4j.Logger");
        cu.addImport("org.slf4j.LoggerFactory");
        cu.addImport("java.util.Collections");
        cu.addImport("java.util.stream.Collectors");

        // Conditional import for BigDecimal
        boolean usesBigDecimal = columnsInfo.stream().anyMatch(c -> "java.math.BigDecimal".equals(c.javaType));
        if (usesBigDecimal) {
            cu.addImport("java.math.BigDecimal");
        }

        // class
        ClassOrInterfaceDeclaration daoClass = cu.addClass(daoClassName, Modifier.Keyword.PUBLIC);

        // Add logger
        daoClass.addFieldWithInitializer("Logger", "logger",
                StaticJavaParser.parseExpression("LoggerFactory.getLogger(" + daoClassName + ".class)"),
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // Create constants (vendor-aware)
        createConstants(daoClass, tableName, columnsInfo, pkField, pkIsAuto, relationships, naming, vendor);

        // Add utility methods for generalization (chunkList only, since vendor detection simplified)
        createUtilityMethods(daoClass);

        // Create methods
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

        // Compute select columns
        String selectColumns = columnsInfo.stream()
                .map(c -> c.name)
                .collect(Collectors.joining(", "));

        // INSERT_SQL
        List<ColumnInfo> insertCols = columnsInfo.stream()
                .filter(c -> !(pkIsAuto && c.name.equals(pkField)))
                .collect(Collectors.toList());
        String insertColumnsStr = insertCols.stream()
                .map(c -> "%s")
                .collect(Collectors.joining(", "));
        String insertPlaceholders = insertCols.stream().map(c -> "?").collect(Collectors.joining(", "));
        StringBuilder insertSqlBuilder = new StringBuilder();
        insertSqlBuilder.append("\"\"\"\n");
        insertSqlBuilder.append("        INSERT INTO %s (").append(insertColumnsStr).append(")\n");
        insertSqlBuilder.append("        VALUES (").append(insertPlaceholders).append(")\n");
        insertSqlBuilder.append("        \"\"\"");

        MethodCallExpr insertSqlExpr = new MethodCallExpr(
                StaticJavaParser.parseExpression(insertSqlBuilder.toString()), "formatted");
        insertSqlExpr.addArgument(new NameExpr("TABLE"));
        for (ColumnInfo c : insertCols) {
            insertSqlExpr.addArgument(new NameExpr("COL_" + c.name.toUpperCase()));
        }

        daoClass.addFieldWithInitializer("String", "INSERT_SQL", insertSqlExpr,
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // SELECT_BY_ID_SQL
        StringBuilder selectByIdBuilder = new StringBuilder();
        selectByIdBuilder.append("\"\"\"\n");
        selectByIdBuilder.append("        SELECT %s FROM %s WHERE %s = ?\n");
        selectByIdBuilder.append("        \"\"\"");

        MethodCallExpr selectByIdSqlExpr = new MethodCallExpr(
                StaticJavaParser.parseExpression(selectByIdBuilder.toString()), "formatted");
        selectByIdSqlExpr.addArgument(new StringLiteralExpr(selectColumns));
        selectByIdSqlExpr.addArgument(new NameExpr("TABLE"));
        selectByIdSqlExpr.addArgument(new NameExpr("COL_" + pkField.toUpperCase()));

        daoClass.addFieldWithInitializer("String", "SELECT_BY_ID_SQL", selectByIdSqlExpr,
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // SELECT_ALL_BASE
        StringBuilder selectAllBaseBuilder = new StringBuilder();
        selectAllBaseBuilder.append("\"\"\"\n");
        selectAllBaseBuilder.append("        SELECT %s FROM %s ORDER BY %s\n");
        selectAllBaseBuilder.append("        \"\"\"");

        MethodCallExpr selectAllBaseExpr = new MethodCallExpr(
                StaticJavaParser.parseExpression(selectAllBaseBuilder.toString()), "formatted");
        selectAllBaseExpr.addArgument(new StringLiteralExpr(selectColumns));
        selectAllBaseExpr.addArgument(new NameExpr("TABLE"));
        selectAllBaseExpr.addArgument(new NameExpr("COL_" + pkField.toUpperCase()));

        daoClass.addFieldWithInitializer("String", "SELECT_ALL_BASE", selectAllBaseExpr,
                Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);

        // CREATE FK SELECT SQL constants
        if (relationships != null) {
            for (Relationship rel : relationships) {
                if (rel.getType() == Relationship.Type.MANY_TO_ONE) {
                    String fkColumn = rel.getFkColumn();
                    String constantName = "SELECT_BY_" + fkColumn.toUpperCase() + "_SQL";

                    StringBuilder fkBuilder = new StringBuilder();
                    fkBuilder.append("\"\"\"\n");
                    fkBuilder.append("        SELECT %s FROM %s WHERE %s = ?\n");
                    fkBuilder.append("        \"\"\"");

                    MethodCallExpr fkSqlExpr = new MethodCallExpr(
                            StaticJavaParser.parseExpression(fkBuilder.toString()), "formatted");
                    fkSqlExpr.addArgument(new StringLiteralExpr(selectColumns));
                    fkSqlExpr.addArgument(new NameExpr("TABLE"));
                    fkSqlExpr.addArgument(new NameExpr("COL_" + fkColumn.toUpperCase()));

                    daoClass.addFieldWithInitializer("String", constantName, fkSqlExpr,
                            Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL);
                }
            }
        }

        // UPDATE_SQL (exclude immutable fields like EFFECTIVE_DATE if needed; assuming all updatable for generality)
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

    private static void createUtilityMethods(ClassOrInterfaceDeclaration daoClass) {
        // Utility to chunk lists (for IN clauses and batches)
        MethodDeclaration chunkList = daoClass.addMethod("chunkList", Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC);
        chunkList.addTypeParameter(new TypeParameter("T"));
        chunkList.setType("List<List<T>>");
        chunkList.addParameter("List<T>", "list");
        chunkList.addParameter("int", "chunkSize");
        BlockStmt chunkBlock = new BlockStmt();
        chunkBlock.addStatement(StaticJavaParser.parseStatement("List<List<T>> chunks = new ArrayList<>();"));

        ForStmt forStmt = new ForStmt();
        NodeList<Expression> initialization = new NodeList<>();
        initialization.add(StaticJavaParser.parseStatement("int i = 0;").asExpressionStmt().getExpression());
        forStmt.setInitialization(initialization);
        forStmt.setCompare(StaticJavaParser.parseExpression("i < list.size()"));
        NodeList<Expression> update = new NodeList<>();
        update.add(StaticJavaParser.parseExpression("i += chunkSize"));
        forStmt.setUpdate(update);
        BlockStmt forBody = new BlockStmt();
        forBody.addStatement(StaticJavaParser.parseStatement("chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));"));
        forStmt.setBody(forBody);
        chunkBlock.addStatement(forStmt);

        chunkBlock.addStatement(StaticJavaParser.parseStatement("return chunks;"));
        chunkList.setBody(chunkBlock);
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
        m.setType(mapJavaTypeToMethod(idType));
        m.addParameter("Connection", "conn");
        m.addParameter(modelClassName, StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false));
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        String paramName = StringUtils.toCamelCase(modelClassName, naming.getUppercaseAcronyms(), false);
        String className = modelClassName;

        BlockStmt block = new BlockStmt();
        block.addStatement(StaticJavaParser.parseStatement("logger.debug(\"Inserting " + modelClassName.toLowerCase() + ": {}\", " + paramName + ");"));
        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        Expression psInitializer = pkIsAuto ?
                StaticJavaParser.parseExpression("conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)") :
                StaticJavaParser.parseExpression("conn.prepareStatement(INSERT_SQL)");

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(psInitializer);
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        tryBlock.addStatement(StaticJavaParser.parseStatement("set" + className + "Params(ps, " + paramName + ");"));

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
            ifBlock.addStatement(StaticJavaParser.parseStatement(idType + " id = rs." + getResultSetGetter(idType) + "(1);"));
            ifBlock.addStatement(StaticJavaParser.parseStatement(
                    paramName + ".set" + StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true) + "(id);"));
            ifBlock.addStatement(new ReturnStmt(new NameExpr("id")));

            BlockStmt elseBlock = new BlockStmt();
            elseBlock.addStatement(StaticJavaParser.parseStatement("logger.error(\"Failed to retrieve generated ID for inserted " + modelClassName.toLowerCase() + "\");"));
            elseBlock.addStatement(new ThrowStmt(StaticJavaParser.parseExpression("new SQLException(\"Failed to retrieve generated ID for inserted " + modelClassName.toLowerCase() + "\")")));

            innerTryBlock.addStatement(new IfStmt(
                    StaticJavaParser.parseExpression("rs.next()"), ifBlock, elseBlock));
            innerTryStmt.setTryBlock(innerTryBlock);
            tryBlock.addStatement(innerTryStmt);
        } else {
            tryBlock.addStatement(new ReturnStmt(StaticJavaParser.parseExpression(paramName + ".get" + StringUtils.toCamelCase(pkField, naming.getUppercaseAcronyms(), true) + "()")));
        }

        tryStmt.setTryBlock(tryBlock);
        block.addStatement(tryStmt);

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

        // Null-check with index
        ForStmt nullCheckFor = new ForStmt();
        NodeList<Expression> nullInit = new NodeList<>();
        nullInit.add(StaticJavaParser.parseStatement("int i = 0;").asExpressionStmt().getExpression());
        nullCheckFor.setInitialization(nullInit);
        nullCheckFor.setCompare(StaticJavaParser.parseExpression("i < " + paramName + ".size()"));
        NodeList<Expression> nullUpdate = new NodeList<>();
        nullUpdate.add(StaticJavaParser.parseExpression("i++"));
        nullCheckFor.setUpdate(nullUpdate);
        BlockStmt nullBody = new BlockStmt();
        nullBody.addStatement(new IfStmt(
                StaticJavaParser.parseExpression(paramName + ".get(i) == null"),
                new ThrowStmt(StaticJavaParser.parseExpression("new IllegalArgumentException(\"Null DTO at index \" + i + \" in batch insert\")")),
                null
        ));
        nullCheckFor.setBody(nullBody);
        block.addStatement(nullCheckFor);

        block.addStatement(StaticJavaParser.parseStatement("int batchSize = 500;")); // Oracle safe limit
        block.addStatement(StaticJavaParser.parseStatement("List<List<" + modelClassName + ">> batches = chunkList(" + paramName + ", batchSize);"));
        block.addStatement(StaticJavaParser.parseStatement("int[] totalResults = new int[" + paramName + ".size()];"));
        block.addStatement(StaticJavaParser.parseStatement("int resultIndex = 0;"));

        block.addStatement(StaticJavaParser.parseStatement("boolean autoCommit = conn.getAutoCommit();"));
        TryStmt outerTry = new TryStmt();
        BlockStmt outerTryBlock = new BlockStmt();
        outerTryBlock.addStatement(StaticJavaParser.parseStatement("conn.setAutoCommit(false);"));

        ForEachStmt batchLoop = new ForEachStmt();
        batchLoop.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, "List<" + modelClassName + ">"), "batch"));
        batchLoop.setIterable(new NameExpr("batches"));
        BlockStmt batchBody = new BlockStmt();

        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        Expression psInitializer = pkIsAuto ?
                StaticJavaParser.parseExpression("conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)") :
                StaticJavaParser.parseExpression("conn.prepareStatement(INSERT_SQL)");

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(psInitializer);
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        ForEachStmt innerLoop = new ForEachStmt();
        innerLoop.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, modelClassName), itemVar));
        innerLoop.setIterable(new NameExpr("batch"));
        BlockStmt innerBody = new BlockStmt();
        innerBody.addStatement(StaticJavaParser.parseStatement("set" + className + "Params(ps, " + itemVar + ");"));
        innerBody.addStatement(StaticJavaParser.parseStatement("ps.addBatch();"));
        innerLoop.setBody(innerBody);
        tryBlock.addStatement(innerLoop);

        tryBlock.addStatement(StaticJavaParser.parseStatement("int[] results = ps.executeBatch();"));
        tryBlock.addStatement(StaticJavaParser.parseStatement("System.arraycopy(results, 0, totalResults, resultIndex, results.length);"));
        tryBlock.addStatement(StaticJavaParser.parseStatement("resultIndex += results.length;"));
        tryBlock.addStatement(StaticJavaParser.parseStatement("logger.debug(\"Inserted {} rows in batch\", results.length);"));

        if (pkIsAuto) {
            String keyRetrieval = getResultSetGetter(idType) + "(1)";

            TryStmt innerTryStmt = new TryStmt();
            BlockStmt innerTryBlock = new BlockStmt();

            VariableDeclarator rsDeclarator = new VariableDeclarator();
            rsDeclarator.setName("rs");
            rsDeclarator.setType(new ClassOrInterfaceType(null, "ResultSet"));
            rsDeclarator.setInitializer(StaticJavaParser.parseExpression("ps.getGeneratedKeys()"));
            innerTryStmt.getResources().add(new VariableDeclarationExpr(rsDeclarator));

            innerTryBlock.addStatement(StaticJavaParser.parseStatement("List<" + idType + "> keys = new ArrayList<>();"));
            WhileStmt whileStmt = new WhileStmt();
            whileStmt.setCondition(StaticJavaParser.parseExpression("rs.next()"));
            BlockStmt whileBody = new BlockStmt();
            whileBody.addStatement(StaticJavaParser.parseStatement("keys.add(rs." + keyRetrieval + ");"));
            whileStmt.setBody(whileBody);
            innerTryBlock.addStatement(whileStmt);

            ForStmt forStmt = new ForStmt();
            NodeList<Expression> initialization = new NodeList<>();
            initialization.add(StaticJavaParser.parseStatement("int i = 0;").asExpressionStmt().getExpression());
            forStmt.setInitialization(initialization);
            forStmt.setCompare(StaticJavaParser.parseExpression("i < batch.size() && i < keys.size()"));
            NodeList<Expression> update = new NodeList<>();
            update.add(StaticJavaParser.parseExpression("i++"));
            forStmt.setUpdate(update);
            BlockStmt forBody = new BlockStmt();
            forBody.addStatement(StaticJavaParser.parseStatement("batch.get(i)" + pkSetter + "(keys.get(i));"));
            forStmt.setBody(forBody);
            innerTryBlock.addStatement(forStmt);
            innerTryStmt.setTryBlock(innerTryBlock);
            tryBlock.addStatement(innerTryStmt);
        }

        tryStmt.setTryBlock(tryBlock);
        CatchClause catchClause = new CatchClause();
        catchClause.setParameter(new Parameter(new ClassOrInterfaceType("SQLException"), "e"));
        BlockStmt catchBlock = new BlockStmt();
        catchBlock.addStatement(StaticJavaParser.parseStatement("logger.error(\"Batch insert failed\", e);"));
        catchBlock.addStatement(StaticJavaParser.parseStatement("throw e;"));
        tryStmt.getCatchClauses().add(catchClause);

        batchBody.addStatement(tryStmt);
        batchLoop.setBody(batchBody);
        outerTryBlock.addStatement(batchLoop);

        outerTryBlock.addStatement(StaticJavaParser.parseStatement("conn.commit();"));

        outerTry.setTryBlock(outerTryBlock);

        CatchClause outerCatch = new CatchClause();
        outerCatch.setParameter(new Parameter(new ClassOrInterfaceType("SQLException"), "e"));
        BlockStmt outerCatchBlock = new BlockStmt();
        outerCatchBlock.addStatement(StaticJavaParser.parseStatement("conn.rollback();"));
        outerCatchBlock.addStatement(StaticJavaParser.parseStatement("logger.error(\"Batch insert failed, rolled back\", e);"));
        outerCatchBlock.addStatement(StaticJavaParser.parseStatement("throw e;"));
        outerCatch.setBody(outerCatchBlock);
        outerTry.getCatchClauses().add(outerCatch);

        BlockStmt finallyBlock = new BlockStmt();
        finallyBlock.addStatement(StaticJavaParser.parseStatement("conn.setAutoCommit(autoCommit);"));
        outerTry.setFinallyBlock(finallyBlock);

        block.addStatement(outerTry);
        block.addStatement(StaticJavaParser.parseStatement("return totalResults;"));
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
        block.addStatement(StaticJavaParser.parseStatement("if (page < 1) throw new IllegalArgumentException(\"Page must be >= 1\");"));
        block.addStatement(StaticJavaParser.parseStatement("if (pageSize < 1) throw new IllegalArgumentException(\"Page size must be >= 1\");"));

        block.addStatement(StaticJavaParser.parseStatement("String sql = SELECT_ALL_BASE + \" OFFSET ? ROWS FETCH NEXT ? ROWS ONLY\";"));
        block.addStatement(StaticJavaParser.parseStatement("List<" + modelClassName + "> list = new ArrayList<>();"));

        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(StaticJavaParser.parseExpression("conn.prepareStatement(sql)"));
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        tryBlock.addStatement(StaticJavaParser.parseStatement("ps.setInt(1, (page - 1) * pageSize);"));
        tryBlock.addStatement(StaticJavaParser.parseStatement("ps.setInt(2, pageSize);"));

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
                ColumnInfo fkColInfo = columnsInfo.stream().filter(c -> c.name.equals(fkColumn)).findFirst().orElse(null);
                if (fkColInfo == null) continue;
                String fkType = fkColInfo.javaType;
                String methodName = "findBy" + StringUtils.toCamelCase(fkColumn, naming.getUppercaseAcronyms(), true);
                String constantName = "SELECT_BY_" + fkColumn.toUpperCase() + "_SQL";
                String paramFkName = StringUtils.toCamelCase(fkColumn, naming.getUppercaseAcronyms(), false);

                MethodDeclaration m = daoClass.addMethod(methodName, Modifier.Keyword.PUBLIC);
                m.setType("List<" + modelClassName + ">");
                m.addParameter("Connection", "conn");
                m.addParameter(mapJavaTypeToMethod(fkType), paramFkName);
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
                        "ps." + getPreparedStatementSetter(fkType) + "(1, " + paramFkName + ");"));

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
        block.addStatement(StaticJavaParser.parseStatement("if (" + pkGetter + " == null) throw new IllegalArgumentException(\"Primary key cannot be null for update\");"));

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

        ForEachStmt checkLoop = new ForEachStmt();
        checkLoop.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, modelClassName), itemVar));
        checkLoop.setIterable(new NameExpr(paramName));
        BlockStmt checkBody = new BlockStmt();
        checkBody.addStatement(new IfStmt(StaticJavaParser.parseExpression(itemVar + " == null"), new ThrowStmt(StaticJavaParser.parseExpression("new IllegalArgumentException(\"Null DTO in batch update\")")), null));
        checkBody.addStatement(new IfStmt(StaticJavaParser.parseExpression(pkGetter + " == null"), new ThrowStmt(StaticJavaParser.parseExpression("new IllegalArgumentException(\"Null primary key in batch update\")")), null));
        checkLoop.setBody(checkBody);
        block.addStatement(checkLoop);

        block.addStatement(StaticJavaParser.parseStatement("int batchSize = 500;"));
        block.addStatement(StaticJavaParser.parseStatement("List<List<" + modelClassName + ">> batches = chunkList(" + paramName + ", batchSize);"));
        block.addStatement(StaticJavaParser.parseStatement("int[] totalResults = new int[" + paramName + ".size()];"));
        block.addStatement(StaticJavaParser.parseStatement("int resultIndex = 0;"));

        block.addStatement(StaticJavaParser.parseStatement("boolean autoCommit = conn.getAutoCommit();"));
        TryStmt outerTry = new TryStmt();
        BlockStmt outerTryBlock = new BlockStmt();
        outerTryBlock.addStatement(StaticJavaParser.parseStatement("conn.setAutoCommit(false);"));

        ForEachStmt batchLoop = new ForEachStmt();
        batchLoop.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, "List<" + modelClassName + ">"), "batch"));
        batchLoop.setIterable(new NameExpr("batches"));
        BlockStmt batchBody = new BlockStmt();

        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(StaticJavaParser.parseExpression("conn.prepareStatement(UPDATE_SQL)"));
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        ForEachStmt innerLoop = new ForEachStmt();
        innerLoop.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, modelClassName), itemVar));
        innerLoop.setIterable(new NameExpr("batch"));
        BlockStmt innerBody = new BlockStmt();
        innerBody.addStatement(StaticJavaParser.parseStatement("set" + className + "Params(ps, " + itemVar + ");"));
        innerBody.addStatement(StaticJavaParser.parseStatement(
                "ps." + getPreparedStatementSetter(idType) + "(" + (updateCols.size() + 1) + ", " + pkGetter + ");"));
        innerBody.addStatement(StaticJavaParser.parseStatement("ps.addBatch();"));
        innerLoop.setBody(innerBody);
        tryBlock.addStatement(innerLoop);

        tryBlock.addStatement(StaticJavaParser.parseStatement("int[] results = ps.executeBatch();"));
        tryBlock.addStatement(StaticJavaParser.parseStatement("System.arraycopy(results, 0, totalResults, resultIndex, results.length);"));
        tryBlock.addStatement(StaticJavaParser.parseStatement("resultIndex += results.length;"));
        tryBlock.addStatement(StaticJavaParser.parseStatement("logger.debug(\"Updated {} rows in batch\", results.length);"));

        tryStmt.setTryBlock(tryBlock);
        CatchClause catchClause = new CatchClause();
        catchClause.setParameter(new Parameter(new ClassOrInterfaceType("SQLException"), "e"));
        BlockStmt catchBlock = new BlockStmt();
        catchBlock.addStatement(StaticJavaParser.parseStatement("logger.error(\"Batch update failed\", e);"));
        catchBlock.addStatement(StaticJavaParser.parseStatement("throw e;"));
        tryStmt.getCatchClauses().add(catchClause);

        batchBody.addStatement(tryStmt);
        batchLoop.setBody(batchBody);
        outerTryBlock.addStatement(batchLoop);

        outerTryBlock.addStatement(StaticJavaParser.parseStatement("conn.commit();"));

        outerTry.setTryBlock(outerTryBlock);

        CatchClause outerCatch = new CatchClause();
        outerCatch.setParameter(new Parameter(new ClassOrInterfaceType("SQLException"), "e"));
        BlockStmt outerCatchBlock = new BlockStmt();
        outerCatchBlock.addStatement(StaticJavaParser.parseStatement("conn.rollback();"));
        outerCatchBlock.addStatement(StaticJavaParser.parseStatement("logger.error(\"Batch update failed, rolled back\", e);"));
        outerCatchBlock.addStatement(StaticJavaParser.parseStatement("throw e;"));
        outerCatch.setBody(outerCatchBlock);
        outerTry.getCatchClauses().add(outerCatch);

        BlockStmt finallyBlock = new BlockStmt();
        finallyBlock.addStatement(StaticJavaParser.parseStatement("conn.setAutoCommit(autoCommit);"));
        outerTry.setFinallyBlock(finallyBlock);

        block.addStatement(outerTry);
        block.addStatement(StaticJavaParser.parseStatement("return totalResults;"));
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
        m.setType("int");
        m.addParameter("Connection", "conn");
        m.addParameter("List<" + idType + ">", "ids");
        m.addThrownException(new ClassOrInterfaceType(null, "SQLException"));

        BlockStmt block = new BlockStmt();
        block.addStatement(StaticJavaParser.parseStatement("if (ids == null || ids.isEmpty()) return 0;"));

        ForEachStmt checkLoop = new ForEachStmt();
        checkLoop.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, idType), "id"));
        checkLoop.setIterable(new NameExpr("ids"));
        BlockStmt checkBody = new BlockStmt();
        checkBody.addStatement(new IfStmt(StaticJavaParser.parseExpression("id == null"), new ThrowStmt(StaticJavaParser.parseExpression("new IllegalArgumentException(\"Null ID in batch delete\")")), null));
        checkLoop.setBody(checkBody);
        block.addStatement(checkLoop);

        block.addStatement(StaticJavaParser.parseStatement("int chunkSize = 1000;")); // Oracle IN clause safe limit
        block.addStatement(StaticJavaParser.parseStatement("List<List<" + idType + ">> chunks = chunkList(ids, chunkSize);"));
        block.addStatement(StaticJavaParser.parseStatement("int totalDeleted = 0;"));

        block.addStatement(StaticJavaParser.parseStatement("boolean autoCommit = conn.getAutoCommit();"));
        TryStmt outerTry = new TryStmt();
        BlockStmt outerTryBlock = new BlockStmt();
        outerTryBlock.addStatement(StaticJavaParser.parseStatement("conn.setAutoCommit(false);"));

        ForEachStmt chunkLoop = new ForEachStmt();
        chunkLoop.setVariable(new VariableDeclarationExpr(new ClassOrInterfaceType(null, "List<" + idType + ">"), "chunk"));
        chunkLoop.setIterable(new NameExpr("chunks"));
        BlockStmt chunkBody = new BlockStmt();

        chunkBody.addStatement(StaticJavaParser.parseStatement("String placeholders = String.join(\", \", java.util.Collections.nCopies(chunk.size(), \"?\"));"));
        chunkBody.addStatement(StaticJavaParser.parseStatement("String sql = String.format(\"DELETE FROM %s WHERE %s IN (%s)\", TABLE, COL_" + pkField.toUpperCase() + ", placeholders);"));

        TryStmt tryStmt = new TryStmt();
        BlockStmt tryBlock = new BlockStmt();

        VariableDeclarator psDeclarator = new VariableDeclarator();
        psDeclarator.setName("ps");
        psDeclarator.setType(new ClassOrInterfaceType(null, "PreparedStatement"));
        psDeclarator.setInitializer(StaticJavaParser.parseExpression("conn.prepareStatement(sql)"));
        tryStmt.getResources().add(new VariableDeclarationExpr(psDeclarator));

        ForStmt setLoop = new ForStmt();
        NodeList<Expression> init = new NodeList<>();
        init.add(StaticJavaParser.parseStatement("int i = 0;").asExpressionStmt().getExpression());
        setLoop.setInitialization(init);
        setLoop.setCompare(StaticJavaParser.parseExpression("i < chunk.size()"));
        NodeList<Expression> update = new NodeList<>();
        update.add(StaticJavaParser.parseExpression("i++"));
        setLoop.setUpdate(update);
        BlockStmt setBody = new BlockStmt();
        setBody.addStatement(StaticJavaParser.parseStatement("ps." + getPreparedStatementSetter(idType) + "(i + 1, chunk.get(i));"));
        setLoop.setBody(setBody);
        tryBlock.addStatement(setLoop);

        tryBlock.addStatement(StaticJavaParser.parseStatement("int affected = ps.executeUpdate();"));
        tryBlock.addStatement(StaticJavaParser.parseStatement("totalDeleted += affected;"));
        tryBlock.addStatement(StaticJavaParser.parseStatement("logger.debug(\"Deleted {} rows in batch\", affected);"));

        tryStmt.setTryBlock(tryBlock);
        CatchClause catchClause = new CatchClause();
        catchClause.setParameter(new Parameter(new ClassOrInterfaceType("SQLException"), "e"));
        BlockStmt catchBlock = new BlockStmt();
        catchBlock.addStatement(StaticJavaParser.parseStatement("logger.error(\"Batch delete failed\", e);"));
        catchBlock.addStatement(StaticJavaParser.parseStatement("throw e;"));
        tryStmt.getCatchClauses().add(catchClause);

        chunkBody.addStatement(tryStmt);
        chunkLoop.setBody(chunkBody);
        outerTryBlock.addStatement(chunkLoop);

        outerTryBlock.addStatement(StaticJavaParser.parseStatement("conn.commit();"));

        outerTry.setTryBlock(outerTryBlock);

        CatchClause outerCatch = new CatchClause();
        outerCatch.setParameter(new Parameter(new ClassOrInterfaceType("SQLException"), "e"));
        BlockStmt outerCatchBlock = new BlockStmt();
        outerCatchBlock.addStatement(StaticJavaParser.parseStatement("conn.rollback();"));
        outerCatchBlock.addStatement(StaticJavaParser.parseStatement("logger.error(\"Batch delete failed, rolled back\", e);"));
        outerCatchBlock.addStatement(StaticJavaParser.parseStatement("throw e;"));
        outerCatch.setBody(outerCatchBlock);
        outerTry.getCatchClauses().add(outerCatch);

        BlockStmt finallyBlock = new BlockStmt();
        finallyBlock.addStatement(StaticJavaParser.parseStatement("conn.setAutoCommit(autoCommit);"));
        outerTry.setFinallyBlock(finallyBlock);

        block.addStatement(outerTry);
        block.addStatement(StaticJavaParser.parseStatement("return totalDeleted;"));
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

            String setterMethod = getPreparedStatementSetter(c.javaType);
            String typesConstant = getTypesConstant(c.javaType);

            if (c.isForeignKey) {
                String baseName = c.name.toLowerCase().endsWith("_id") ? c.name.substring(0, c.name.length() - 3) : c.name;
                String relationshipName = StringUtils.toCamelCase(baseName, naming.getUppercaseAcronyms(), true);
                String relationGetter = paramName + ".get" + relationshipName + "()";
                String relatedPk = c.referencedTable + "_id";
                String relatedPkCamel = StringUtils.toCamelCase(relatedPk, naming.getUppercaseAcronyms(), true);

                Expression condition = StaticJavaParser.parseExpression(relationGetter + " != null");
                BlockStmt thenBlock = new BlockStmt();
                thenBlock.addStatement(StaticJavaParser.parseStatement(
                        "ps.setObject(" + idx + ", " + relationGetter + ".get" + relatedPkCamel + "(), " + typesConstant + ");"));
                BlockStmt elseBlock = new BlockStmt();
                elseBlock.addStatement(StaticJavaParser.parseStatement("ps.setNull(" + idx + ", " + typesConstant + ");"));
                block.addStatement(new IfStmt(condition, thenBlock, elseBlock));
            } else if ("java.time.LocalDateTime".equals(c.javaType)) {
                String varName = "val" + idx;
                block.addStatement(StaticJavaParser.parseStatement("java.time.LocalDateTime " + varName + " = " + getter + ";"));
                Expression condition = StaticJavaParser.parseExpression(varName + " != null");
                BlockStmt thenBlock = new BlockStmt();
                thenBlock.addStatement(StaticJavaParser.parseStatement("ps.setObject(" + idx + ", java.sql.Timestamp.valueOf(" + varName + "), Types.TIMESTAMP);"));
                BlockStmt elseBlock = new BlockStmt();
                elseBlock.addStatement(StaticJavaParser.parseStatement("ps.setNull(" + idx + ", Types.TIMESTAMP);"));
                block.addStatement(new IfStmt(condition, thenBlock, elseBlock));
            } else if ("java.time.LocalDate".equals(c.javaType)) {
                String varName = "val" + idx;
                block.addStatement(StaticJavaParser.parseStatement("java.time.LocalDate " + varName + " = " + getter + ";"));
                Expression condition = StaticJavaParser.parseExpression(varName + " != null");
                BlockStmt thenBlock = new BlockStmt();
                thenBlock.addStatement(StaticJavaParser.parseStatement("ps.setObject(" + idx + ", java.sql.Date.valueOf(" + varName + "), Types.DATE);"));
                BlockStmt elseBlock = new BlockStmt();
                elseBlock.addStatement(StaticJavaParser.parseStatement("ps.setNull(" + idx + ", Types.DATE);"));
                block.addStatement(new IfStmt(condition, thenBlock, elseBlock));
            } else if ("java.time.LocalTime".equals(c.javaType)) {
                String varName = "val" + idx;
                block.addStatement(StaticJavaParser.parseStatement("java.time.LocalTime " + varName + " = " + getter + ";"));
                Expression condition = StaticJavaParser.parseExpression(varName + " != null");
                BlockStmt thenBlock = new BlockStmt();
                thenBlock.addStatement(StaticJavaParser.parseStatement("ps.setObject(" + idx + ", java.sql.Time.valueOf(" + varName + "), Types.TIME);"));
                BlockStmt elseBlock = new BlockStmt();
                elseBlock.addStatement(StaticJavaParser.parseStatement("ps.setNull(" + idx + ", Types.TIME);"));
                block.addStatement(new IfStmt(condition, thenBlock, elseBlock));
            } else if (c.javaType.equals("String") && c.isBinary) {
                String varName = "val" + idx;
                block.addStatement(StaticJavaParser.parseStatement("String " + varName + " = " + getter + ";"));
                Expression condition = StaticJavaParser.parseExpression(varName + " != null");
                BlockStmt thenBlock = new BlockStmt();
                thenBlock.addStatement(StaticJavaParser.parseStatement("ps.setObject(" + idx + ", " + varName + ".getBytes(), Types.BINARY);"));
                BlockStmt elseBlock = new BlockStmt();
                elseBlock.addStatement(StaticJavaParser.parseStatement("ps.setNull(" + idx + ", Types.BINARY);"));
                block.addStatement(new IfStmt(condition, thenBlock, elseBlock));
            } else if (Arrays.asList("Integer", "Long", "Float", "Double", "java.math.BigDecimal", "Boolean").contains(c.javaType)) {
                String varName = "val" + idx;
                block.addStatement(StaticJavaParser.parseStatement(c.javaType + " " + varName + " = " + getter + ";"));
                Expression condition = StaticJavaParser.parseExpression(varName + " != null");
                BlockStmt thenBlock = new BlockStmt();
                thenBlock.addStatement(StaticJavaParser.parseStatement(
                        "ps.setObject(" + idx + ", " + varName + ", " + getTypesConstant(c.javaType) + ");"));
                BlockStmt elseBlock = new BlockStmt();
                elseBlock.addStatement(StaticJavaParser.parseStatement(
                        "ps.setNull(" + idx + ", " + getTypesConstant(c.javaType) + ");"));
                block.addStatement(new IfStmt(condition, thenBlock, elseBlock));
            } else {
                block.addStatement(StaticJavaParser.parseStatement(
                        "ps.setObject(" + idx + ", " + getter + ", " + getTypesConstant(c.javaType) + ");"));
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
                        c.javaType + " " + c.name + " = rs.getObject(" + colConst + ", " + c.javaType + ".class);"));
                block.addStatement(StaticJavaParser.parseStatement(setter + "(" + c.name + ");"));
                BlockStmt ifBlock = new BlockStmt();
                ifBlock.addStatement(StaticJavaParser.parseStatement(
                        relatedClass + " " + relatedObjectName + " = new " + relatedClass + "();"));
                ifBlock.addStatement(StaticJavaParser.parseStatement(
                        relatedObjectName + ".set" + relatedPkCamel + "(" + c.name + ");"));
                ifBlock.addStatement(StaticJavaParser.parseStatement(
                        objectName + ".set" + relationshipName + "(" + relatedObjectName + ");"));
                block.addStatement(new IfStmt(
                        StaticJavaParser.parseExpression(c.name + " != null"),
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

        // Handle ID fields explicitly as Integer (or Long if needed)
        if (colNameLower.equals("id") || colNameLower.endsWith("_id") || colNameLower.endsWith("_no")) {
            // Adjust to "Long" if your schema uses big integers for these; otherwise keep "Integer"
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
            case "VARCHAR", "VARCHAR2", "CHAR", "TEXT", "CLOB", "LONGTEXT", "MEDIUMTEXT", "NVARCHAR2", "NCLOB",
                 "LONG" -> "String";
            case "INT", "INTEGER", "SMALLINT", "TINYINT", "YEAR", "INT4", "INT2" -> {
                // special-case: MySQL TINYINT(1) commonly used for boolean
                if ("TINYINT".equals(dbType) && columnSize == 1) {
                    yield "Boolean";
                }
                yield "Integer";
            }
            case "BIGINT", "INT8" -> "Long";
            case "DECIMAL", "NUMERIC", "NUMBER" ->
                    "java.math.BigDecimal"; // Always use BigDecimal for decimal types
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
            case "java.math.BigDecimal" -> "Types.NUMERIC";
            case "byte[]" -> "Types.BINARY";
            case "String" -> "Types.VARCHAR";
            default -> "Types.OTHER";
        };
    }
}
