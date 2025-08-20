package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgBusinessCodeDao;
import com.bsit.codegeneration.record.FgBusinessCode;

public class FgBusinessCodeRepository {

    private final Jdbi jdbi;

    public FgBusinessCodeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgBusinessCode> getAllFgBusinessCodes() {
        return jdbi.withExtension(FgBusinessCodeDao.class, fgbusinesscodedao -> fgbusinesscodedao.findAll());
    }

    public Optional<FgBusinessCode> getFgBusinessCodeById(String id) {
        return jdbi.withExtension(FgBusinessCodeDao.class, dao -> dao.findById(id));
    }

    public String createFgBusinessCode(FgBusinessCode entity) {
        return jdbi.withExtension(FgBusinessCodeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgBusinessCode(FgBusinessCode entity) {
        return jdbi.withExtension(FgBusinessCodeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgBusinessCode(String id) {
        jdbi.useExtension(FgBusinessCodeDao.class, dao -> dao.delete(id));
    }
}
