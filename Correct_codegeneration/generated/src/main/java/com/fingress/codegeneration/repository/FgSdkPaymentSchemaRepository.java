package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkPaymentSchemaDao;
import com.bsit.codegeneration.record.FgSdkPaymentSchema;

public class FgSdkPaymentSchemaRepository {

    private final Jdbi jdbi;

    public FgSdkPaymentSchemaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkPaymentSchema> getAllFgSdkPaymentSchemas() {
        return jdbi.withExtension(FgSdkPaymentSchemaDao.class, fgsdkpaymentschemadao -> fgsdkpaymentschemadao.findAll());
    }

    public Optional<FgSdkPaymentSchema> getFgSdkPaymentSchemaById(String id) {
        return jdbi.withExtension(FgSdkPaymentSchemaDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkPaymentSchema(FgSdkPaymentSchema entity) {
        return jdbi.withExtension(FgSdkPaymentSchemaDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkPaymentSchema(FgSdkPaymentSchema entity) {
        return jdbi.withExtension(FgSdkPaymentSchemaDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkPaymentSchema(String id) {
        jdbi.useExtension(FgSdkPaymentSchemaDao.class, dao -> dao.delete(id));
    }
}
