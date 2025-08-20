package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuFilterDao;
import com.bsit.codegeneration.record.FgActRuFilter;

public class FgActRuFilterRepository {

    private final Jdbi jdbi;

    public FgActRuFilterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuFilter> getAllFgActRuFilters() {
        return jdbi.withExtension(FgActRuFilterDao.class, fgactrufilterdao -> fgactrufilterdao.findAll());
    }

    public Optional<FgActRuFilter> getFgActRuFilterById(String id) {
        return jdbi.withExtension(FgActRuFilterDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuFilter(FgActRuFilter entity) {
        return jdbi.withExtension(FgActRuFilterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuFilter(FgActRuFilter entity) {
        return jdbi.withExtension(FgActRuFilterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuFilter(String id) {
        jdbi.useExtension(FgActRuFilterDao.class, dao -> dao.delete(id));
    }
}
