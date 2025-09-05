package com.bsit.codegeneration.metadata;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.bsit.codegeneration.model.CustomGeneratorConstructor;
import com.bsit.codegeneration.model.GeneratorConfig;
import com.bsit.codegeneration.model.GeneratorSettings;
import com.bsit.codegeneration.model.RepositoryConfig;
import com.bsit.codegeneration.model.DatabaseConfig;
import com.bsit.codegeneration.model.TargetConfig;
import com.bsit.codegeneration.model.DtoConfig;
import com.bsit.codegeneration.model.RecordConfig;
import com.bsit.codegeneration.model.DaoConfig;
import org.yaml.snakeyaml.Yaml;

import static com.bsit.codegeneration.parser.JdbcDaoGenerator.log;

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
            

            log.info(" Code generation completed successfully");
        }
    }
}
