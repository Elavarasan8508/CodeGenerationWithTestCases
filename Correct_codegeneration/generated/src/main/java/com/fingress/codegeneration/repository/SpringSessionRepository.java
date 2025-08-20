package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.SpringSessionDao;
import com.bsit.codegeneration.record.SpringSession;

public class SpringSessionRepository {

    private final Jdbi jdbi;

    public SpringSessionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<SpringSession> getAllSpringSessions() {
        return jdbi.withExtension(SpringSessionDao.class, springsessiondao -> springsessiondao.findAll());
    }

    public Optional<SpringSession> getSpringSessionById(String id) {
        return jdbi.withExtension(SpringSessionDao.class, dao -> dao.findById(id));
    }

    public String createSpringSession(SpringSession entity) {
        return jdbi.withExtension(SpringSessionDao.class, dao -> dao.insert(entity));
    }

    public int updateSpringSession(SpringSession entity) {
        return jdbi.withExtension(SpringSessionDao.class, dao -> dao.update(entity));
    }

    public void deleteSpringSession(String id) {
        jdbi.useExtension(SpringSessionDao.class, dao -> dao.delete(id));
    }
}
