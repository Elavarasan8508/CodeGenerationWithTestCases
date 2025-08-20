package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkActionSchemaDao;
import com.bsit.codegeneration.record.FgSdkActionSchema;

public class FgSdkActionSchemaRepository {

    private final Jdbi jdbi;

    public FgSdkActionSchemaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkActionSchema> getAllFgSdkActionSchemas() {
        return jdbi.withExtension(FgSdkActionSchemaDao.class, fgsdkactionschemadao -> fgsdkactionschemadao.findAll());
    }

    public Optional<FgSdkActionSchema> getFgSdkActionSchemaById(String id) {
        return jdbi.withExtension(FgSdkActionSchemaDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkActionSchema(FgSdkActionSchema entity) {
        return jdbi.withExtension(FgSdkActionSchemaDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkActionSchema(FgSdkActionSchema entity) {
        return jdbi.withExtension(FgSdkActionSchemaDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkActionSchema(String id) {
        jdbi.useExtension(FgSdkActionSchemaDao.class, dao -> dao.delete(id));
    }
}
