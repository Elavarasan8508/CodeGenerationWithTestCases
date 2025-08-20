package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgStateTransitionDao;
import com.bsit.codegeneration.record.FgStateTransition;

public class FgStateTransitionRepository {

    private final Jdbi jdbi;

    public FgStateTransitionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgStateTransition> getAllFgStateTransitions() {
        return jdbi.withExtension(FgStateTransitionDao.class, fgstatetransitiondao -> fgstatetransitiondao.findAll());
    }

    public Optional<FgStateTransition> getFgStateTransitionById(String id) {
        return jdbi.withExtension(FgStateTransitionDao.class, dao -> dao.findById(id));
    }

    public String createFgStateTransition(FgStateTransition entity) {
        return jdbi.withExtension(FgStateTransitionDao.class, dao -> dao.insert(entity));
    }

    public int updateFgStateTransition(FgStateTransition entity) {
        return jdbi.withExtension(FgStateTransitionDao.class, dao -> dao.update(entity));
    }

    public void deleteFgStateTransition(String id) {
        jdbi.useExtension(FgStateTransitionDao.class, dao -> dao.delete(id));
    }
}
