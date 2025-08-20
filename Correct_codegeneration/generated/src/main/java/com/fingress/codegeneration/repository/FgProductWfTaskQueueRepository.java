package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProductWfTaskQueueDao;
import com.bsit.codegeneration.record.FgProductWfTaskQueue;

public class FgProductWfTaskQueueRepository {

    private final Jdbi jdbi;

    public FgProductWfTaskQueueRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProductWfTaskQueue> getAllFgProductWfTaskQueues() {
        return jdbi.withExtension(FgProductWfTaskQueueDao.class, fgproductwftaskqueuedao -> fgproductwftaskqueuedao.findAll());
    }

    public Optional<FgProductWfTaskQueue> getFgProductWfTaskQueueById(String id) {
        return jdbi.withExtension(FgProductWfTaskQueueDao.class, dao -> dao.findById(id));
    }

    public String createFgProductWfTaskQueue(FgProductWfTaskQueue entity) {
        return jdbi.withExtension(FgProductWfTaskQueueDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProductWfTaskQueue(FgProductWfTaskQueue entity) {
        return jdbi.withExtension(FgProductWfTaskQueueDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProductWfTaskQueue(String id) {
        jdbi.useExtension(FgProductWfTaskQueueDao.class, dao -> dao.delete(id));
    }
}
