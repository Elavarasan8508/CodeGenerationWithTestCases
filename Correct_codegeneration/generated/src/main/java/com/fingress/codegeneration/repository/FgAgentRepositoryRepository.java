package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAgentRepositoryDao;
import com.bsit.codegeneration.record.FgAgentRepository;

public class FgAgentRepositoryRepository {

    private final Jdbi jdbi;

    public FgAgentRepositoryRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAgentRepository> getAllFgAgentRepositorys() {
        return jdbi.withExtension(FgAgentRepositoryDao.class, fgagentrepositorydao -> fgagentrepositorydao.findAll());
    }

    public Optional<FgAgentRepository> getFgAgentRepositoryById(String id) {
        return jdbi.withExtension(FgAgentRepositoryDao.class, dao -> dao.findById(id));
    }

    public String createFgAgentRepository(FgAgentRepository entity) {
        return jdbi.withExtension(FgAgentRepositoryDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAgentRepository(FgAgentRepository entity) {
        return jdbi.withExtension(FgAgentRepositoryDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAgentRepository(String id) {
        jdbi.useExtension(FgAgentRepositoryDao.class, dao -> dao.delete(id));
    }
}
