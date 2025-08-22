package com.bsit.codegeneration.util;

import com.bsit.codegeneration.model.*;
import com.bsit.codegeneration.parser.RecordTestGenerator;
import org.yaml.snakeyaml.Yaml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class RecordTestGeneratorRunner {

    private static final Logger logger = LoggerFactory.getLogger(RecordTestGeneratorRunner.class);
    private static DatabaseConfig dbConfig;
    private static TargetConfig targetConfig;
    private static RecordConfig recordConfig;
    private static final String DEFAULT_SCHEMA = "public";

    public static void main(String[] args) throws Exception {
        loadConfigurationFromYaml();

        System.out.println("Starting record test generation...");
        System.out.println("Connecting to: " + dbConfig.getUrl());

        try (Connection conn = DriverManager.getConnection(
                dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword())) {

            System.out.println("Database connected successfully!");

            List<String> allTables = DatabaseUtils.discoverAllTables(conn, dbConfig.getSchema());
            System.out.println("Discovered " + allTables.size() + " tables: " + allTables);

            GenerationResult result = processAllTables(conn, allTables);
            printSummary(allTables.size(), result.successCount, result.failCount);

        } catch (SQLException e) {
            handleDatabaseConnectionError(e);
        }

        System.out.println("Record test generation completed!");
    }

    private static GenerationResult processAllTables(Connection conn, List<String> allTables) {
        int successCount = 0, failCount = 0;

        for (String tableName : allTables) {
            System.out.println("\n=== Processing table: " + tableName + " ===");

            try {
                if (processTable(conn, tableName)) {
                    successCount++;
                    System.out.println(" Successfully generated record test for: " + tableName);
                } else {
                    failCount++;
                }
            } catch (Exception e) {
                handleTableProcessingError(tableName, e);
                failCount++;
            }
        }

        return new GenerationResult(successCount, failCount);
    }

    private static boolean processTable(Connection conn, String tableName) throws SQLException {
        String schema = dbConfig.getSchema();

        try (ResultSet columns = DatabaseUtils.getTableColumns(conn, schema, tableName)) {
            if (!DatabaseUtils.hasColumns(columns)) {
                System.err.println("  No columns found for table: " + tableName);
                return false;
            }
        }

        // Re-open columns ResultSet for generator
        try (ResultSet columns = DatabaseUtils.getTableColumns(conn, schema, tableName)) {
            List<Relationship> forwardRels = DatabaseUtils.discoverRelationships(conn, schema, tableName, false);
            List<Relationship> reverseRels = DatabaseUtils.discoverRelationships(conn, schema, tableName, true);

            // Detect many-to-many relationships
            DatabaseUtils.detectManyToMany(conn, schema, tableName, reverseRels);

            System.out.println("  forward relationships: " + forwardRels.size());
            System.out.println("  reverse relationships: " + reverseRels.size());

            try {
                RecordTestGenerator.generateRecordTest(
                        tableName,
                        columns,
                        dbConfig,
                        targetConfig,
                        recordConfig,
                        forwardRels,
                        reverseRels
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return true;
        }
    }

    private static void loadConfigurationFromYaml() throws Exception {
        Yaml yaml = new Yaml(new CustomGeneratorConstructor());

        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/generator.yml"))) {
            GeneratorConfig config = yaml.loadAs(input, GeneratorConfig.class);
            GeneratorSettings generator = config.getGenerator();

            dbConfig = generator.getDatabase();
            recordConfig = generator.getRecord();
            targetConfig = createTargetConfig();

            if (dbConfig.getUrl() == null || dbConfig.getUser() == null) {
                throw new RuntimeException("Database URL and user are required in YAML configuration");
            }

            if (dbConfig.getSchema() == null) {
                dbConfig.setSchema(DEFAULT_SCHEMA);
            }

            System.out.println("Configuration loaded from YAML successfully");
            System.out.println("Database: " + dbConfig.getUrl());
            System.out.println("Schema: " + dbConfig.getSchema());
            System.out.println("Output Directory: " + targetConfig.getOutputDirectory());

        } catch (Exception e) {
            System.err.println("Failed to load configuration from YAML: " + e.getMessage());
            throw new RuntimeException("YAML configuration loading failed", e);
        }
    }

    private static TargetConfig createTargetConfig() {
        TargetConfig config = new TargetConfig();
        config.setBasePackage("com.bsit.codegeneration");
        config.setOutputDirectory("src/test/java");
        return config;
    }

    // Helper methods to reduce duplication
    private static void handleDatabaseConnectionError(SQLException e) throws SQLException {
        System.err.println("Database connection failed: " + e.getMessage());
        throw e;
    }

    private static void handleTableProcessingError(String tableName, Exception e) {
        logger.error("Failed to generate record test for " + tableName, e);
        System.err.println("An internal error occurred. Please contact support.");
    }

    private static void printSummary(int totalTables, int successCount, int failCount) {
        System.out.println("\n=== RECORD TEST GENERATION SUMMARY ===");
        System.out.println("Total tables discovered: " + totalTables);
        System.out.println("Successfully generated: " + successCount);
        System.out.println("Failed: " + failCount);
    }

    // Helper class to encapsulate generation results
    private static class GenerationResult {
        final int successCount;
        final int failCount;

        GenerationResult(int successCount, int failCount) {
            this.successCount = successCount;
            this.failCount = failCount;
        }
    }
}
