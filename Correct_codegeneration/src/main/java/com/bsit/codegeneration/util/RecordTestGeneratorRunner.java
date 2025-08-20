package com.bsit.codegeneration.util;

import com.bsit.codegeneration.model.*;
import com.bsit.codegeneration.parser.RecordTestGenerator;
import com.bsit.codegeneration.util.Relationship;

import java.sql.*;
import java.util.*;

public class RecordTestGeneratorRunner {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "root";

        System.out.println("Starting record test generation...");

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected successfully!");

            // Auto-discover all tables
            List<String> allTables = discoverAllTables(conn);
            System.out.println("Discovered " + allTables.size() + " tables: " + allTables);

            int successCount = 0, failCount = 0;

            for (String tableName : allTables) {
                System.out.println("\n=== Processing table: " + tableName + " ===");
                ResultSet columns = null;
                try {
                    String schema = "public";
                    columns = conn.getMetaData().getColumns(null, schema, tableName, null);

                    if (!hasColumns(columns)) {
                        System.err.println("  No columns found for table: " + tableName);
                        failCount++;
                        continue;
                    }

                    if (columns != null) columns.close();
                    columns = conn.getMetaData().getColumns(null, schema, tableName, null);

                    DatabaseConfig dbConfig = createDatabaseConfig();
                    TargetConfig targetConfig = createTargetConfig();
                    RecordConfig recordConfig = createRecordConfig();

                    // DISCOVER relationships for this table
                    List<Relationship> forwardRels = discoverImportedKeys(conn, schema, tableName);
                    List<Relationship> reverseRels = discoverExportedKeys(conn, schema, tableName);

                    // Detect and add many-to-many relationships
                    for (Relationship rev : new ArrayList<>(reverseRels)) {
                        String joinTable = rev.getRelatedTable();
                        if (isJoinTable(conn, schema, joinTable)) {
                            String targetTable = getOtherTarget(conn, schema, joinTable, tableName);
                            if (targetTable != null) {
                                // Add many-to-many relationship
                                Relationship mmRel = new Relationship(
                                        targetTable,
                                        null,
                                        null,
                                        true,
                                        Relationship.Type.MANY_TO_MANY,
                                        joinTable  // assuming the constructor supports this
                                );
                                reverseRels.add(mmRel);
                            }
                        }
                    }

                    // Debug
                    System.out.println("  forward relationships: " + forwardRels.size());
                    System.out.println("  reverse relationships: " + reverseRels.size());

                    // Generate record tests
                    RecordTestGenerator.generateRecordTest(
                            tableName,
                            columns,
                            dbConfig,
                            targetConfig,
                            recordConfig,
                            forwardRels,
                            reverseRels
                    );

                    successCount++;
                    System.out.println("✓ Successfully generated record test for: " + tableName);

                } catch (Exception e) {
                    System.err.println("✗ Failed to generate record test for " + tableName + ": " + e.getMessage());
                    e.printStackTrace();
                    failCount++;
                } finally {
                    if (columns != null) try { columns.close(); } catch (SQLException ignore) {}
                }
            }

            System.out.println("\n=== RECORD TEST GENERATION SUMMARY ===");
            System.out.println("Total tables discovered: " + allTables.size());
            System.out.println("Successfully generated: " + successCount);
            System.out.println("Failed: " + failCount);

        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            throw e;
        }

        System.out.println("Record test generation completed!");
    }

    private static boolean isJoinTable(Connection conn, String schema, String tableName) throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();

        // Count columns
        try (ResultSet columns = meta.getColumns(null, schema, tableName, null)) {
            int columnCount = 0;
            while (columns.next()) {
                columnCount++;
            }

            // Get imported keys (FKs)
            try (ResultSet fks = meta.getImportedKeys(null, schema, tableName)) {
                Set<String> fkTargets = new HashSet<>();
                while (fks.next()) {
                    String pkTable = fks.getString("PKTABLE_NAME");
                    fkTargets.add(pkTable);
                }

                // Heuristic: exactly 2 FK targets and limited columns (e.g., FKs + optional last_update)
                return fkTargets.size() == 2 && columnCount <= 4;
            }
        }
    }

    private static String getOtherTarget(Connection conn, String schema, String joinTable, String currentTable) throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet fks = meta.getImportedKeys(null, schema, joinTable)) {
            while (fks.next()) {
                String pkTable = fks.getString("PKTABLE_NAME");
                if (!pkTable.equals(currentTable)) {
                    return pkTable;
                }
            }
        }
        return null;
    }

    private static List<Relationship> discoverImportedKeys(Connection conn, String schema, String tableName) throws SQLException {
        List<Relationship> rels = new ArrayList<>();
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet fk = meta.getImportedKeys(null, schema, tableName)) {
            while (fk.next()) {
                String pkTable = fk.getString("PKTABLE_NAME");
                String pkColumn = fk.getString("PKCOLUMN_NAME");
                String fkColumn = fk.getString("FKCOLUMN_NAME");
                Relationship r = new Relationship(
                        pkTable,
                        pkColumn,
                        fkColumn,
                        false,
                        Relationship.Type.MANY_TO_ONE,
                        null
                );
                rels.add(r);
            }
        }
        return rels;
    }

    private static List<Relationship> discoverExportedKeys(Connection conn, String schema, String tableName) throws SQLException {
        List<Relationship> rels = new ArrayList<>();
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet fk = meta.getExportedKeys(null, schema, tableName)) {
            while (fk.next()) {
                String fkTable = fk.getString("FKTABLE_NAME");
                String pkColumn = fk.getString("PKCOLUMN_NAME");
                String fkColumn = fk.getString("FKCOLUMN_NAME");
                Relationship r = new Relationship(
                        fkTable,
                        pkColumn,
                        fkColumn,
                        true,
                        Relationship.Type.ONE_TO_MANY,
                        null
                );
                rels.add(r);
            }
        }
        return rels;
    }

    private static List<String> discoverAllTables(Connection conn) throws SQLException {
        List<String> tableNames = new ArrayList<>();
        DatabaseMetaData metaData = conn.getMetaData();
        String[] types = {"TABLE"};
        try (ResultSet tables = metaData.getTables(null, "public", "%", types)) {
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                if (!isSystemTable(tableName)) tableNames.add(tableName);
            }
        }
        Collections.sort(tableNames);
        return tableNames;
    }

    private static boolean hasColumns(ResultSet columns) throws SQLException {
        boolean has = columns.next();
        try { columns.beforeFirst(); } catch (SQLException ignored) {}
        return has;
    }

    private static boolean isSystemTable(String tableName) {
        String lower = tableName.toLowerCase();
        return lower.startsWith("pg_") || lower.startsWith("information_schema") ||
                lower.startsWith("sql_") || lower.equals("dual");
    }

    private static DatabaseConfig createDatabaseConfig() {
        DatabaseConfig config = new DatabaseConfig();
        NamingStrategyConfig naming = new NamingStrategyConfig();
        naming.setStripPrefixes(Arrays.asList("tbl_", "t_"));
        naming.setUppercaseAcronyms(Arrays.asList("ID", "URL", "API"));
        config.setNamingStrategy(naming);
        return config;
    }

    private static TargetConfig createTargetConfig() {
        TargetConfig config = new TargetConfig();
        config.setBasePackage("com.bsit.codegeneration");
        config.setOutputDirectory("src/test/java");
        return config;
    }

    private static RecordConfig createRecordConfig() {
        RecordConfig config = new RecordConfig();
        config.setBuilderPattern(true);
        config.setUseJavaTime(true);
        config.setPackageName("record"); // Records go in 'record' package

        // Enable relationships for records
        config.setIncludeRelationships(true);
        config.setIncludeReverseRelationships(true);

        return config;
    }
}