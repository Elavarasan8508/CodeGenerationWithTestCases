package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgMyQueueViewDao;
import com.bsit.codegeneration.record.FgMyQueueView;

public class FgMyQueueViewRepository {

    private final Jdbi jdbi;

    public FgMyQueueViewRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgMyQueueView> getAllFgMyQueueViews() {
        return jdbi.withExtension(FgMyQueueViewDao.class, fgmyqueueviewdao -> fgmyqueueviewdao.findAll());
    }

    public Optional<FgMyQueueView> getFgMyQueueViewById(String id) {
        return jdbi.withExtension(FgMyQueueViewDao.class, dao -> dao.findById(id));
    }

    public String createFgMyQueueView(FgMyQueueView entity) {
        return jdbi.withExtension(FgMyQueueViewDao.class, dao -> dao.insert(entity));
    }

    public int updateFgMyQueueView(FgMyQueueView entity) {
        return jdbi.withExtension(FgMyQueueViewDao.class, dao -> dao.update(entity));
    }

    public void deleteFgMyQueueView(String id) {
        jdbi.useExtension(FgMyQueueViewDao.class, dao -> dao.delete(id));
    }
}
