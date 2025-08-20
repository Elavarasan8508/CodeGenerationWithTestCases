package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgFileEventsDao;
import com.bsit.codegeneration.record.FgFileEvents;

public class FgFileEventsRepository {

    private final Jdbi jdbi;

    public FgFileEventsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgFileEvents> getAllFgFileEventss() {
        return jdbi.withExtension(FgFileEventsDao.class, fgfileeventsdao -> fgfileeventsdao.findAll());
    }

    public Optional<FgFileEvents> getFgFileEventsById(String id) {
        return jdbi.withExtension(FgFileEventsDao.class, dao -> dao.findById(id));
    }

    public String createFgFileEvents(FgFileEvents entity) {
        return jdbi.withExtension(FgFileEventsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgFileEvents(FgFileEvents entity) {
        return jdbi.withExtension(FgFileEventsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgFileEvents(String id) {
        jdbi.useExtension(FgFileEventsDao.class, dao -> dao.delete(id));
    }
}
