package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAgentRepositoryEventDao;
import com.bsit.codegeneration.record.FgAgentRepositoryEvent;

public class FgAgentRepositoryEventRepository {

    private final Jdbi jdbi;

    public FgAgentRepositoryEventRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAgentRepositoryEvent> getAllFgAgentRepositoryEvents() {
        return jdbi.withExtension(FgAgentRepositoryEventDao.class, fgagentrepositoryeventdao -> fgagentrepositoryeventdao.findAll());
    }

    public Optional<FgAgentRepositoryEvent> getFgAgentRepositoryEventById(String id) {
        return jdbi.withExtension(FgAgentRepositoryEventDao.class, dao -> dao.findById(id));
    }

    public String createFgAgentRepositoryEvent(FgAgentRepositoryEvent entity) {
        return jdbi.withExtension(FgAgentRepositoryEventDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAgentRepositoryEvent(FgAgentRepositoryEvent entity) {
        return jdbi.withExtension(FgAgentRepositoryEventDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAgentRepositoryEvent(String id) {
        jdbi.useExtension(FgAgentRepositoryEventDao.class, dao -> dao.delete(id));
    }
}
