package com.bsit.codegeneration.metadata;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.bsit.codegeneration.model.*;

import org.yaml.snakeyaml.Yaml;

public class YamlParser {

    public  void generate() throws Exception {
        Yaml yaml = new Yaml(new CustomGeneratorConstructor());

        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/generator.yml"))) {
            GeneratorConfig config = yaml.loadAs(input, GeneratorConfig.class);
            GeneratorSettings generator = config.getGenerator();

            DatabaseConfig dbConfig = generator.getDatabase();
            TargetConfig targetConfig = generator.getTarget();
            DtoConfig dtoConfig = generator.getDto();
            RecordConfig recordConfig = generator.getRecord();
            DaoConfig daoConfig = generator.getDao();
            RepositoryConfig repositoryConfig =generator.getRepository();


            DbReader.readDatabase(dbConfig, targetConfig, dtoConfig, recordConfig, daoConfig,repositoryConfig);
            

            System.out.println(" Code generation completed successfully");
        }
    }
}
