package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkReportSchemaDao;
import com.bsit.codegeneration.record.FgSdkReportSchema;

public class FgSdkReportSchemaRepository {

    private final Jdbi jdbi;

    public FgSdkReportSchemaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkReportSchema> getAllFgSdkReportSchemas() {
        return jdbi.withExtension(FgSdkReportSchemaDao.class, fgsdkreportschemadao -> fgsdkreportschemadao.findAll());
    }

    public Optional<FgSdkReportSchema> getFgSdkReportSchemaById(String id) {
        return jdbi.withExtension(FgSdkReportSchemaDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkReportSchema(FgSdkReportSchema entity) {
        return jdbi.withExtension(FgSdkReportSchemaDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkReportSchema(FgSdkReportSchema entity) {
        return jdbi.withExtension(FgSdkReportSchemaDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkReportSchema(String id) {
        jdbi.useExtension(FgSdkReportSchemaDao.class, dao -> dao.delete(id));
    }
}
