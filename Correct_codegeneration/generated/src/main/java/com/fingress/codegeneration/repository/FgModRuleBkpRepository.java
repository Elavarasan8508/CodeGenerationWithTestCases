package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModRuleBkpDao;
import com.bsit.codegeneration.record.FgModRuleBkp;

public class FgModRuleBkpRepository {

    private final Jdbi jdbi;

    public FgModRuleBkpRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModRuleBkp> getAllFgModRuleBkps() {
        return jdbi.withExtension(FgModRuleBkpDao.class, fgmodrulebkpdao -> fgmodrulebkpdao.findAll());
    }

    public Optional<FgModRuleBkp> getFgModRuleBkpById(String id) {
        return jdbi.withExtension(FgModRuleBkpDao.class, dao -> dao.findById(id));
    }

    public String createFgModRuleBkp(FgModRuleBkp entity) {
        return jdbi.withExtension(FgModRuleBkpDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModRuleBkp(FgModRuleBkp entity) {
        return jdbi.withExtension(FgModRuleBkpDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModRuleBkp(String id) {
        jdbi.useExtension(FgModRuleBkpDao.class, dao -> dao.delete(id));
    }
}
