package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdRemittanceDao;
import com.bsit.codegeneration.record.FgTrdRemittance;

public class FgTrdRemittanceRepository {

    private final Jdbi jdbi;

    public FgTrdRemittanceRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdRemittance> getAllFgTrdRemittances() {
        return jdbi.withExtension(FgTrdRemittanceDao.class, fgtrdremittancedao -> fgtrdremittancedao.findAll());
    }

    public Optional<FgTrdRemittance> getFgTrdRemittanceById(String id) {
        return jdbi.withExtension(FgTrdRemittanceDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdRemittance(FgTrdRemittance entity) {
        return jdbi.withExtension(FgTrdRemittanceDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdRemittance(FgTrdRemittance entity) {
        return jdbi.withExtension(FgTrdRemittanceDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdRemittance(String id) {
        jdbi.useExtension(FgTrdRemittanceDao.class, dao -> dao.delete(id));
    }
}
