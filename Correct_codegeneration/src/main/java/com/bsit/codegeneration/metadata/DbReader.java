package com.bsit.codegeneration.metadata;

import java.sql.*;
import java.util.*;
import com.bsit.codegeneration.model.*;
import com.bsit.codegeneration.parser.DaoGenerator;
import com.bsit.codegeneration.parser.DtoGenerator;
import com.bsit.codegeneration.parser.RecordGenerator;
import com.bsit.codegeneration.parser.RepositoryGenerator;
import com.bsit.codegeneration.util.Relationship;
import com.bsit.codegeneration.util.Relationship.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbReader {

    private static final Logger logger = LoggerFactory.getLogger(DbReader.class);
    private static final Logger filmLogger = LoggerFactory.getLogger("filmLogger"); // Custom logger for "film" table

    public static void readDatabase(DatabaseConfig dbConfig,
                                    TargetConfig target,
                                    DtoConfig dtoConfig,
                                    RecordConfig recordConfig,
                                    DaoConfig daoConfig,
                                    RepositoryConfig repositoryConfig) throws Exception {

        Class.forName(dbConfig.getDriver());

        try (Connection conn = DriverManager.getConnection(
                dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword())) {

            DatabaseMetaData metaData = conn.getMetaData();
            String schema = dbConfig.getSchema();
            List<String> tableTypes = dbConfig.getInputFilter().getTableTypes();

            ResultSet tables = metaData.getTables(null, schema, "%", tableTypes.toArray(new String[0]));
            Set<String> processedTables = new HashSet<>();
            int count = 0;
            Map<String, List<Relationship>> allRelationships = readRelationships(conn, schema);

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                if (processedTables.contains(tableName.toLowerCase())) continue;
                processedTables.add(tableName.toLowerCase());

                if (!isIncluded(tableName, dbConfig.getIncludes(), dbConfig.getExcludes())) {
                    continue;
                }

                // Custom logging: Use filmLogger for "film" table (configurable to file), else default logger (console)
                Logger currentLogger = tableName.equalsIgnoreCase("film") ? filmLogger : logger;
                currentLogger.info("Reading table: {}", tableName); // Placeholder for efficiency
                count++;

                List<Relationship> relationships = dtoConfig.isIncludeRelationships()
                        ? allRelationships.getOrDefault(tableName, Collections.emptyList())
                        : Collections.emptyList();

                List<Relationship> reverseRelationships = dtoConfig.isIncludeReverseRelationships()
                        ? getReverseRelationships(metaData, schema, tableName) : Collections.emptyList();

                try (ResultSet columns = metaData.getColumns(null, schema, tableName, "%")) {
                    if (dtoConfig.isGenerate()) {
                        DtoGenerator.generateDto(tableName, columns, dbConfig, target, dtoConfig, relationships, reverseRelationships);
                    }
                }

                try (ResultSet columns = metaData.getColumns(null, schema, tableName, "%")) {
                    if (recordConfig.isGenerate()) {
                        RecordGenerator.generateRecord(tableName, columns, dbConfig, target, recordConfig, relationships, reverseRelationships);
                        currentLogger.info("Record generated for: {}", tableName);
                    }
                }

                try (ResultSet columns = metaData.getColumns(null, schema, tableName, "%")) {
                    if (daoConfig.isGenerate()) {
                        DaoGenerator.generateDao(tableName, columns, dbConfig, target, dtoConfig, relationships, reverseRelationships);
                        currentLogger.info("DAO generated for: {}", tableName);
                    }
                }

                try (ResultSet columns = metaData.getColumns(null, schema, tableName, "%")) {
                    if (repositoryConfig.isGenerate()) {
                        RepositoryGenerator.generateRepository(tableName, columns, dbConfig, target);
                        currentLogger.info("Repository generated for: {}", tableName);
                    }
                }
            }

            logger.info("Total processed tables: {}", count);
            tables.close();
        }
    }

    private static boolean isIncluded(String tableName, List<String> includes, List<String> excludes) {
        for (String pattern : excludes) {
            if (tableName.matches(pattern)) return false;
        }
        for (String pattern : includes) {
            if (tableName.matches(pattern)) return true;
        }
        return false;
    }

    private static List<Relationship> getReverseRelationships(DatabaseMetaData metaData, String schema, String tableName) throws SQLException {
        List<Relationship> revRels = new ArrayList<>();
        try (ResultSet rs = metaData.getExportedKeys(null, schema, tableName)) {
            while (rs.next()) {
                revRels.add(new Relationship(
                    rs.getString("FKTABLE_NAME"),
                    rs.getString("PKCOLUMN_NAME"),
                    rs.getString("FKCOLUMN_NAME"),
                    true,
                    Relationship.Type.ONE_TO_MANY,
                    null
                ));
            }
        }
        return revRels;
    }

    private static Map<String, List<Relationship>> readRelationships(Connection connection, String schema) throws SQLException {
        Map<String, List<Relationship>> relationshipMap = new HashMap<>();
        DatabaseMetaData metaData = connection.getMetaData();

        // Collect table names first

        List<String> tableNames = new ArrayList<>();
        try (ResultSet tables = metaData.getTables(null, schema, null, new String[]{"TABLE"})) {
            while (tables.next()) {
                tableNames.add(tables.getString("TABLE_NAME"));
            }
        }

        // Process each table

        Map<String, List<Relationship>> fkRels = new HashMap<>();
        for (String tableName : tableNames) {
            try (ResultSet fks = metaData.getImportedKeys(null, schema, tableName)) {
                List<Relationship> currentRels = new ArrayList<>();
                while (fks.next()) {
                    String pkTable = fks.getString("PKTABLE_NAME");
                    String fkColumn = fks.getString("FKCOLUMN_NAME");
                    String pkColumn = fks.getString("PKCOLUMN_NAME");
                    Relationship rel = new Relationship(pkTable, pkColumn, fkColumn, false, Type.MANY_TO_ONE, null);
                    currentRels.add(rel);

                    relationshipMap.computeIfAbsent(pkTable, k -> new ArrayList<>())
                            .add(new Relationship(tableName, pkColumn, fkColumn, true, Type.ONE_TO_MANY, null));
                }
                if (!currentRels.isEmpty()) {
                    fkRels.put(tableName, currentRels);
                }
                relationshipMap.put(tableName, currentRels);
            }
        }

        // Detect MANY_TO_MANY join tables

        for (Map.Entry<String, List<Relationship>> entry : fkRels.entrySet()) {
            String joinTable = entry.getKey();
            List<Relationship> rels = entry.getValue();
            if (rels.size() == 2) {
                Relationship r1 = rels.get(0);
                Relationship r2 = rels.get(1);

                relationshipMap.computeIfAbsent(r1.getRelatedTable(), k -> new ArrayList<>())
                        .add(new Relationship(r2.getRelatedTable(), r2.getPkColumn(), r2.getFkColumn(), false, Type.MANY_TO_MANY, joinTable));
                relationshipMap.computeIfAbsent(r2.getRelatedTable(), k -> new ArrayList<>())
                        .add(new Relationship(r1.getRelatedTable(), r1.getPkColumn(), r1.getFkColumn(), false, Type.MANY_TO_MANY, joinTable));
            }
        }

        return relationshipMap;
    }
}