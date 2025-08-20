package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgConfigSchemaDao;
import com.bsit.codegeneration.record.FgConfigSchema;

public class FgConfigSchemaRepository {

    private final Jdbi jdbi;

    public FgConfigSchemaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgConfigSchema> getAllFgConfigSchemas() {
        return jdbi.withExtension(FgConfigSchemaDao.class, fgconfigschemadao -> fgconfigschemadao.findAll());
    }

    public Optional<FgConfigSchema> getFgConfigSchemaById(String id) {
        return jdbi.withExtension(FgConfigSchemaDao.class, dao -> dao.findById(id));
    }

    public String createFgConfigSchema(FgConfigSchema entity) {
        return jdbi.withExtension(FgConfigSchemaDao.class, dao -> dao.insert(entity));
    }

    public int updateFgConfigSchema(FgConfigSchema entity) {
        return jdbi.withExtension(FgConfigSchemaDao.class, dao -> dao.update(entity));
    }

    public void deleteFgConfigSchema(String id) {
        jdbi.useExtension(FgConfigSchemaDao.class, dao -> dao.delete(id));
    }
}
