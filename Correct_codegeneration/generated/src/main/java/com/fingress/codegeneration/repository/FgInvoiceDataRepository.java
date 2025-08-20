package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgInvoiceDataDao;
import com.bsit.codegeneration.record.FgInvoiceData;

public class FgInvoiceDataRepository {

    private final Jdbi jdbi;

    public FgInvoiceDataRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgInvoiceData> getAllFgInvoiceDatas() {
        return jdbi.withExtension(FgInvoiceDataDao.class, fginvoicedatadao -> fginvoicedatadao.findAll());
    }

    public Optional<FgInvoiceData> getFgInvoiceDataById(String id) {
        return jdbi.withExtension(FgInvoiceDataDao.class, dao -> dao.findById(id));
    }

    public String createFgInvoiceData(FgInvoiceData entity) {
        return jdbi.withExtension(FgInvoiceDataDao.class, dao -> dao.insert(entity));
    }

    public int updateFgInvoiceData(FgInvoiceData entity) {
        return jdbi.withExtension(FgInvoiceDataDao.class, dao -> dao.update(entity));
    }

    public void deleteFgInvoiceData(String id) {
        jdbi.useExtension(FgInvoiceDataDao.class, dao -> dao.delete(id));
    }
}
