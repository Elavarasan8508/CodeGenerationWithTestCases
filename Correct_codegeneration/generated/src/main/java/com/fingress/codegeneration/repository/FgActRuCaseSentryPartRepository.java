package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuCaseSentryPartDao;
import com.bsit.codegeneration.record.FgActRuCaseSentryPart;

public class FgActRuCaseSentryPartRepository {

    private final Jdbi jdbi;

    public FgActRuCaseSentryPartRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuCaseSentryPart> getAllFgActRuCaseSentryParts() {
        return jdbi.withExtension(FgActRuCaseSentryPartDao.class, fgactrucasesentrypartdao -> fgactrucasesentrypartdao.findAll());
    }

    public Optional<FgActRuCaseSentryPart> getFgActRuCaseSentryPartById(String id) {
        return jdbi.withExtension(FgActRuCaseSentryPartDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuCaseSentryPart(FgActRuCaseSentryPart entity) {
        return jdbi.withExtension(FgActRuCaseSentryPartDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuCaseSentryPart(FgActRuCaseSentryPart entity) {
        return jdbi.withExtension(FgActRuCaseSentryPartDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuCaseSentryPart(String id) {
        jdbi.useExtension(FgActRuCaseSentryPartDao.class, dao -> dao.delete(id));
    }
}
