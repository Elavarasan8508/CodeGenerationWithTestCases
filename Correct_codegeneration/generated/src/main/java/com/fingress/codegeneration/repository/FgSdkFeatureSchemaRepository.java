package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkFeatureSchemaDao;
import com.bsit.codegeneration.record.FgSdkFeatureSchema;

public class FgSdkFeatureSchemaRepository {

    private final Jdbi jdbi;

    public FgSdkFeatureSchemaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkFeatureSchema> getAllFgSdkFeatureSchemas() {
        return jdbi.withExtension(FgSdkFeatureSchemaDao.class, fgsdkfeatureschemadao -> fgsdkfeatureschemadao.findAll());
    }

    public Optional<FgSdkFeatureSchema> getFgSdkFeatureSchemaById(String id) {
        return jdbi.withExtension(FgSdkFeatureSchemaDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkFeatureSchema(FgSdkFeatureSchema entity) {
        return jdbi.withExtension(FgSdkFeatureSchemaDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkFeatureSchema(FgSdkFeatureSchema entity) {
        return jdbi.withExtension(FgSdkFeatureSchemaDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkFeatureSchema(String id) {
        jdbi.useExtension(FgSdkFeatureSchemaDao.class, dao -> dao.delete(id));
    }
}
