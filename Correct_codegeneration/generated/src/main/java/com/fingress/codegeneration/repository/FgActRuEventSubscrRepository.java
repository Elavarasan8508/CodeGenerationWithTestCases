package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuEventSubscrDao;
import com.bsit.codegeneration.record.FgActRuEventSubscr;

public class FgActRuEventSubscrRepository {

    private final Jdbi jdbi;

    public FgActRuEventSubscrRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuEventSubscr> getAllFgActRuEventSubscrs() {
        return jdbi.withExtension(FgActRuEventSubscrDao.class, fgactrueventsubscrdao -> fgactrueventsubscrdao.findAll());
    }

    public Optional<FgActRuEventSubscr> getFgActRuEventSubscrById(String id) {
        return jdbi.withExtension(FgActRuEventSubscrDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuEventSubscr(FgActRuEventSubscr entity) {
        return jdbi.withExtension(FgActRuEventSubscrDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuEventSubscr(FgActRuEventSubscr entity) {
        return jdbi.withExtension(FgActRuEventSubscrDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuEventSubscr(String id) {
        jdbi.useExtension(FgActRuEventSubscrDao.class, dao -> dao.delete(id));
    }
}
