package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuExtTaskDao;
import com.bsit.codegeneration.record.FgActRuExtTask;

public class FgActRuExtTaskRepository {

    private final Jdbi jdbi;

    public FgActRuExtTaskRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuExtTask> getAllFgActRuExtTasks() {
        return jdbi.withExtension(FgActRuExtTaskDao.class, fgactruexttaskdao -> fgactruexttaskdao.findAll());
    }

    public Optional<FgActRuExtTask> getFgActRuExtTaskById(Long id) {
        return jdbi.withExtension(FgActRuExtTaskDao.class, dao -> dao.findById(id));
    }

    public Long createFgActRuExtTask(FgActRuExtTask entity) {
        return jdbi.withExtension(FgActRuExtTaskDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuExtTask(FgActRuExtTask entity) {
        return jdbi.withExtension(FgActRuExtTaskDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuExtTask(Long id) {
        jdbi.useExtension(FgActRuExtTaskDao.class, dao -> dao.delete(id));
    }
}
