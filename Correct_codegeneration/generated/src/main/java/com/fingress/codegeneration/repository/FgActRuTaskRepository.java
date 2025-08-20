package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuTaskDao;
import com.bsit.codegeneration.record.FgActRuTask;

public class FgActRuTaskRepository {

    private final Jdbi jdbi;

    public FgActRuTaskRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuTask> getAllFgActRuTasks() {
        return jdbi.withExtension(FgActRuTaskDao.class, fgactrutaskdao -> fgactrutaskdao.findAll());
    }

    public Optional<FgActRuTask> getFgActRuTaskById(String id) {
        return jdbi.withExtension(FgActRuTaskDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuTask(FgActRuTask entity) {
        return jdbi.withExtension(FgActRuTaskDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuTask(FgActRuTask entity) {
        return jdbi.withExtension(FgActRuTaskDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuTask(String id) {
        jdbi.useExtension(FgActRuTaskDao.class, dao -> dao.delete(id));
    }
}
