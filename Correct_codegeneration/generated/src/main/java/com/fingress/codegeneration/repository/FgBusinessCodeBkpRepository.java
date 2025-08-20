package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgBusinessCodeBkpDao;
import com.bsit.codegeneration.record.FgBusinessCodeBkp;

public class FgBusinessCodeBkpRepository {

    private final Jdbi jdbi;

    public FgBusinessCodeBkpRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgBusinessCodeBkp> getAllFgBusinessCodeBkps() {
        return jdbi.withExtension(FgBusinessCodeBkpDao.class, fgbusinesscodebkpdao -> fgbusinesscodebkpdao.findAll());
    }

    public Optional<FgBusinessCodeBkp> getFgBusinessCodeBkpById(String id) {
        return jdbi.withExtension(FgBusinessCodeBkpDao.class, dao -> dao.findById(id));
    }

    public String createFgBusinessCodeBkp(FgBusinessCodeBkp entity) {
        return jdbi.withExtension(FgBusinessCodeBkpDao.class, dao -> dao.insert(entity));
    }

    public int updateFgBusinessCodeBkp(FgBusinessCodeBkp entity) {
        return jdbi.withExtension(FgBusinessCodeBkpDao.class, dao -> dao.update(entity));
    }

    public void deleteFgBusinessCodeBkp(String id) {
        jdbi.useExtension(FgBusinessCodeBkpDao.class, dao -> dao.delete(id));
    }
}
