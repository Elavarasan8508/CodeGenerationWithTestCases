package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkUploadSchemaDao;
import com.bsit.codegeneration.record.FgSdkUploadSchema;

public class FgSdkUploadSchemaRepository {

    private final Jdbi jdbi;

    public FgSdkUploadSchemaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkUploadSchema> getAllFgSdkUploadSchemas() {
        return jdbi.withExtension(FgSdkUploadSchemaDao.class, fgsdkuploadschemadao -> fgsdkuploadschemadao.findAll());
    }

    public Optional<FgSdkUploadSchema> getFgSdkUploadSchemaById(String id) {
        return jdbi.withExtension(FgSdkUploadSchemaDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkUploadSchema(FgSdkUploadSchema entity) {
        return jdbi.withExtension(FgSdkUploadSchemaDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkUploadSchema(FgSdkUploadSchema entity) {
        return jdbi.withExtension(FgSdkUploadSchemaDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkUploadSchema(String id) {
        jdbi.useExtension(FgSdkUploadSchemaDao.class, dao -> dao.delete(id));
    }
}
