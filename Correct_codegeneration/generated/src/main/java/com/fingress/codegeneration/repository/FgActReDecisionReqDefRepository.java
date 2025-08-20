package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActReDecisionReqDefDao;
import com.bsit.codegeneration.record.FgActReDecisionReqDef;

public class FgActReDecisionReqDefRepository {

    private final Jdbi jdbi;

    public FgActReDecisionReqDefRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActReDecisionReqDef> getAllFgActReDecisionReqDefs() {
        return jdbi.withExtension(FgActReDecisionReqDefDao.class, fgactredecisionreqdefdao -> fgactredecisionreqdefdao.findAll());
    }

    public Optional<FgActReDecisionReqDef> getFgActReDecisionReqDefById(String id) {
        return jdbi.withExtension(FgActReDecisionReqDefDao.class, dao -> dao.findById(id));
    }

    public String createFgActReDecisionReqDef(FgActReDecisionReqDef entity) {
        return jdbi.withExtension(FgActReDecisionReqDefDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActReDecisionReqDef(FgActReDecisionReqDef entity) {
        return jdbi.withExtension(FgActReDecisionReqDefDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActReDecisionReqDef(String id) {
        jdbi.useExtension(FgActReDecisionReqDefDao.class, dao -> dao.delete(id));
    }
}
