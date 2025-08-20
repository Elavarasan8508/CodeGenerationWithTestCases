package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkFileSchemaDao;
import com.bsit.codegeneration.record.FgSdkFileSchema;

public class FgSdkFileSchemaRepository {

    private final Jdbi jdbi;

    public FgSdkFileSchemaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkFileSchema> getAllFgSdkFileSchemas() {
        return jdbi.withExtension(FgSdkFileSchemaDao.class, fgsdkfileschemadao -> fgsdkfileschemadao.findAll());
    }

    public Optional<FgSdkFileSchema> getFgSdkFileSchemaById(String id) {
        return jdbi.withExtension(FgSdkFileSchemaDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkFileSchema(FgSdkFileSchema entity) {
        return jdbi.withExtension(FgSdkFileSchemaDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkFileSchema(FgSdkFileSchema entity) {
        return jdbi.withExtension(FgSdkFileSchemaDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkFileSchema(String id) {
        jdbi.useExtension(FgSdkFileSchemaDao.class, dao -> dao.delete(id));
    }
}
