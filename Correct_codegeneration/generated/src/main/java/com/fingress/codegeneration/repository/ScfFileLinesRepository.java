package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ScfFileLinesDao;
import com.bsit.codegeneration.record.ScfFileLines;

public class ScfFileLinesRepository {

    private final Jdbi jdbi;

    public ScfFileLinesRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<ScfFileLines> getAllScfFileLiness() {
        return jdbi.withExtension(ScfFileLinesDao.class, scffilelinesdao -> scffilelinesdao.findAll());
    }

    public Optional<ScfFileLines> getScfFileLinesById(String id) {
        return jdbi.withExtension(ScfFileLinesDao.class, dao -> dao.findById(id));
    }

    public String createScfFileLines(ScfFileLines entity) {
        return jdbi.withExtension(ScfFileLinesDao.class, dao -> dao.insert(entity));
    }

    public int updateScfFileLines(ScfFileLines entity) {
        return jdbi.withExtension(ScfFileLinesDao.class, dao -> dao.update(entity));
    }

    public void deleteScfFileLines(String id) {
        jdbi.useExtension(ScfFileLinesDao.class, dao -> dao.delete(id));
    }
}
