package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgBusinessCodeTypeBkpDao;
import com.bsit.codegeneration.record.FgBusinessCodeTypeBkp;

public class FgBusinessCodeTypeBkpRepository {

    private final Jdbi jdbi;

    public FgBusinessCodeTypeBkpRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgBusinessCodeTypeBkp> getAllFgBusinessCodeTypeBkps() {
        return jdbi.withExtension(FgBusinessCodeTypeBkpDao.class, fgbusinesscodetypebkpdao -> fgbusinesscodetypebkpdao.findAll());
    }

    public Optional<FgBusinessCodeTypeBkp> getFgBusinessCodeTypeBkpById(String id) {
        return jdbi.withExtension(FgBusinessCodeTypeBkpDao.class, dao -> dao.findById(id));
    }

    public String createFgBusinessCodeTypeBkp(FgBusinessCodeTypeBkp entity) {
        return jdbi.withExtension(FgBusinessCodeTypeBkpDao.class, dao -> dao.insert(entity));
    }

    public int updateFgBusinessCodeTypeBkp(FgBusinessCodeTypeBkp entity) {
        return jdbi.withExtension(FgBusinessCodeTypeBkpDao.class, dao -> dao.update(entity));
    }

    public void deleteFgBusinessCodeTypeBkp(String id) {
        jdbi.useExtension(FgBusinessCodeTypeBkpDao.class, dao -> dao.delete(id));
    }
}
