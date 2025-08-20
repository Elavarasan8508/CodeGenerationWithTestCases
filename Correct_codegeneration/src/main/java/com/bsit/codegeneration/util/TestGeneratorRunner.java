package com.bsit.codegeneration.util;

import com.bsit.codegeneration.model.*;
import com.bsit.codegeneration.parser.DtoTestGenerator;
import com.bsit.codegeneration.util.Relationship;

import java.sql.*;
import java.util.*;

public class TestGeneratorRunner {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "root";

        System.out.println("Starting test generation...");

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
                    // Use schema "public" for Postgres (change if needed)
                    String schema = "public";
                    columns = conn.getMetaData().getColumns(null, schema, tableName, null);

                    if (!hasColumns(columns)) {
                        System.err.println("  No columns found for table: " + tableName);
                        failCount++;
                        continue;
                    }

                    // Re-open columns ResultSet for generator (some drivers don't support beforeFirst reliably)
                    if (columns != null) columns.close();
                    columns = conn.getMetaData().getColumns(null, schema, tableName, null);

                    DatabaseConfig dbConfig = createDatabaseConfig();
                    TargetConfig targetConfig = createTargetConfig();
                    DtoConfig dtoConfig = createDtoConfig();

                    // DISCOVER relationships for this table
                    List<Relationship> forwardRels = discoverImportedKeys(conn, schema, tableName);
                    List<Relationship> reverseRels = discoverExportedKeys(conn, schema, tableName);

                    // Debug
                    System.out.println("  forward relationships: " + forwardRels.size());
                    System.out.println("  reverse relationships: " + reverseRels.size());

                    // Generate tests passing the discovered relationships
                    DtoTestGenerator.generateDtoTest(
                            tableName,
                            columns,
                            dbConfig,
                            targetConfig,
                            dtoConfig,
                            forwardRels,
                            reverseRels
                    );

                    successCount++;
                    System.out.println(" Successfully generated test for: " + tableName);

                } catch (Exception e) {
                    System.err.println(" Failed to generate test for " + tableName + ": " + e.getMessage());
                    e.printStackTrace();
                    failCount++;
                } finally {
                    if (columns != null) try { columns.close(); } catch (SQLException ignore) {}
                }
            }

            System.out.println("\n=== GENERATION SUMMARY ===");
            System.out.println("Total tables discovered: " + allTables.size());
            System.out.println("Successfully generated: " + successCount);
            System.out.println("Failed: " + failCount);

        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            throw e;
        }

        System.out.println("Test generation completed!");
    }

    /**
     * Discover imported keys (forward relationships).
     * For each FK on this table, create Relationship(relatedTable(pk table), pkColumn, fkColumn, reverse=false, MANY_TO_ONE, null)
     */
    private static List<Relationship> discoverImportedKeys(Connection conn, String schema, String tableName) throws SQLException {
        List<Relationship> rels = new ArrayList<>();
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet fk = meta.getImportedKeys(null, schema, tableName)) {
            while (fk.next()) {
                String pkTable = fk.getString("PKTABLE_NAME");    // referenced table
                String pkColumn = fk.getString("PKCOLUMN_NAME");  // referenced column (PK column in referenced table)
                String fkColumn = fk.getString("FKCOLUMN_NAME");  // column in this table (the FK)
                // create Relationship: relatedTable = pkTable, pkColumn = pkColumn, fkColumn = fkColumn
                Relationship r = new Relationship(
                        pkTable,
                        pkColumn,
                        fkColumn,
                        false, // not reverse: this is forward relationship from this table -> related table
                        Relationship.Type.MANY_TO_ONE,
                        null // join table name not applicable here
                );
                rels.add(r);
            }
        }
        return rels;
    }

    /**
     * Discover exported keys (reverse relationships).
     * For each FK in other tables that reference this table, create Relationship(relatedTable = fkTable, pkColumn=this table pk, fkColumn=fkColumn, reverse=true, ONE_TO_MANY, null)
     */
    private static List<Relationship> discoverExportedKeys(Connection conn, String schema, String tableName) throws SQLException {
        List<Relationship> rels = new ArrayList<>();
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet fk = meta.getExportedKeys(null, schema, tableName)) {
            while (fk.next()) {
                String fkTable = fk.getString("FKTABLE_NAME");   // other table that references this table
                String pkColumn = fk.getString("PKCOLUMN_NAME"); // column in this table (the PK column referenced)
                String fkColumn = fk.getString("FKCOLUMN_NAME"); // column in the other table that references this table
                Relationship r = new Relationship(
                        fkTable,
                        pkColumn,
                        fkColumn,
                        true, // reverse relationship: other table references this table
                        Relationship.Type.ONE_TO_MANY,
                        null
                );
                rels.add(r);
            }
        }
        return rels;
    }

    // --- helpers (unchanged mostly) ---

    private static List<String> discoverAllTables(Connection conn) throws SQLException {
        List<String> tableNames = new ArrayList<>();
        DatabaseMetaData metaData = conn.getMetaData();
        String[] types = {"TABLE"};
        // Use schema "public" for Postgres; change if your DB uses a different schema
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
        return lower.startsWith("pg_") || lower.startsWith("information_schema") || lower.startsWith("sql_") || lower.equals("dual");
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

    private static DtoConfig createDtoConfig() {
        DtoConfig config = new DtoConfig();
        config.setBuilderPattern(true);

        // IMPORTANT: enable relationship flags so DTO generation & test extraction include relations
        config.setIncludeRelationships(true);
        config.setIncludeReverseRelationships(true);

        // you may also want to keep/remove FK id fields depending on your preference:
        // config.setRemoveForeignKeyIdFields(true/false);
        return config;
    }
}
