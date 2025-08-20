package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ScfFileEventsDao;
import com.bsit.codegeneration.record.ScfFileEvents;

public class ScfFileEventsRepository {

    private final Jdbi jdbi;

    public ScfFileEventsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<ScfFileEvents> getAllScfFileEventss() {
        return jdbi.withExtension(ScfFileEventsDao.class, scffileeventsdao -> scffileeventsdao.findAll());
    }

    public Optional<ScfFileEvents> getScfFileEventsById(String id) {
        return jdbi.withExtension(ScfFileEventsDao.class, dao -> dao.findById(id));
    }

    public String createScfFileEvents(ScfFileEvents entity) {
        return jdbi.withExtension(ScfFileEventsDao.class, dao -> dao.insert(entity));
    }

    public int updateScfFileEvents(ScfFileEvents entity) {
        return jdbi.withExtension(ScfFileEventsDao.class, dao -> dao.update(entity));
    }

    public void deleteScfFileEvents(String id) {
        jdbi.useExtension(ScfFileEventsDao.class, dao -> dao.delete(id));
    }
}
