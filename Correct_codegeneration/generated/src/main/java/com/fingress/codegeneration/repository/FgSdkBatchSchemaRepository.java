package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkBatchSchemaDao;
import com.bsit.codegeneration.record.FgSdkBatchSchema;

public class FgSdkBatchSchemaRepository {

    private final Jdbi jdbi;

    public FgSdkBatchSchemaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkBatchSchema> getAllFgSdkBatchSchemas() {
        return jdbi.withExtension(FgSdkBatchSchemaDao.class, fgsdkbatchschemadao -> fgsdkbatchschemadao.findAll());
    }

    public Optional<FgSdkBatchSchema> getFgSdkBatchSchemaById(String id) {
        return jdbi.withExtension(FgSdkBatchSchemaDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkBatchSchema(FgSdkBatchSchema entity) {
        return jdbi.withExtension(FgSdkBatchSchemaDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkBatchSchema(FgSdkBatchSchema entity) {
        return jdbi.withExtension(FgSdkBatchSchemaDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkBatchSchema(String id) {
        jdbi.useExtension(FgSdkBatchSchemaDao.class, dao -> dao.delete(id));
    }
}
