package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkBotSchemaDao;
import com.bsit.codegeneration.record.FgSdkBotSchema;

public class FgSdkBotSchemaRepository {

    private final Jdbi jdbi;

    public FgSdkBotSchemaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkBotSchema> getAllFgSdkBotSchemas() {
        return jdbi.withExtension(FgSdkBotSchemaDao.class, fgsdkbotschemadao -> fgsdkbotschemadao.findAll());
    }

    public Optional<FgSdkBotSchema> getFgSdkBotSchemaById(String id) {
        return jdbi.withExtension(FgSdkBotSchemaDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkBotSchema(FgSdkBotSchema entity) {
        return jdbi.withExtension(FgSdkBotSchemaDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkBotSchema(FgSdkBotSchema entity) {
        return jdbi.withExtension(FgSdkBotSchemaDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkBotSchema(String id) {
        jdbi.useExtension(FgSdkBotSchemaDao.class, dao -> dao.delete(id));
    }
}
