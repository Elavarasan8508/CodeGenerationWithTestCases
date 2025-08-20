package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.GtpXchRatesDao;
import com.bsit.codegeneration.record.GtpXchRates;

public class GtpXchRatesRepository {

    private final Jdbi jdbi;

    public GtpXchRatesRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<GtpXchRates> getAllGtpXchRatess() {
        return jdbi.withExtension(GtpXchRatesDao.class, gtpxchratesdao -> gtpxchratesdao.findAll());
    }

    public Optional<GtpXchRates> getGtpXchRatesById(String id) {
        return jdbi.withExtension(GtpXchRatesDao.class, dao -> dao.findById(id));
    }

    public String createGtpXchRates(GtpXchRates entity) {
        return jdbi.withExtension(GtpXchRatesDao.class, dao -> dao.insert(entity));
    }

    public int updateGtpXchRates(GtpXchRates entity) {
        return jdbi.withExtension(GtpXchRatesDao.class, dao -> dao.update(entity));
    }

    public void deleteGtpXchRates(String id) {
        jdbi.useExtension(GtpXchRatesDao.class, dao -> dao.delete(id));
    }
}
