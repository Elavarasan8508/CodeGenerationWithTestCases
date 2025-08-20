package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdPurposeCodeDao;
import com.bsit.codegeneration.record.FgTrdPurposeCode;

public class FgTrdPurposeCodeRepository {

    private final Jdbi jdbi;

    public FgTrdPurposeCodeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdPurposeCode> getAllFgTrdPurposeCodes() {
        return jdbi.withExtension(FgTrdPurposeCodeDao.class, fgtrdpurposecodedao -> fgtrdpurposecodedao.findAll());
    }

    public Optional<FgTrdPurposeCode> getFgTrdPurposeCodeById(Long id) {
        return jdbi.withExtension(FgTrdPurposeCodeDao.class, dao -> dao.findById(id));
    }

    public Long createFgTrdPurposeCode(FgTrdPurposeCode entity) {
        return jdbi.withExtension(FgTrdPurposeCodeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdPurposeCode(FgTrdPurposeCode entity) {
        return jdbi.withExtension(FgTrdPurposeCodeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdPurposeCode(Long id) {
        jdbi.useExtension(FgTrdPurposeCodeDao.class, dao -> dao.delete(id));
    }
}
