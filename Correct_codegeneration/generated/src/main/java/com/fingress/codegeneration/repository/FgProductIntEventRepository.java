package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProductIntEventDao;
import com.bsit.codegeneration.record.FgProductIntEvent;

public class FgProductIntEventRepository {

    private final Jdbi jdbi;

    public FgProductIntEventRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProductIntEvent> getAllFgProductIntEvents() {
        return jdbi.withExtension(FgProductIntEventDao.class, fgproductinteventdao -> fgproductinteventdao.findAll());
    }

    public Optional<FgProductIntEvent> getFgProductIntEventById(String id) {
        return jdbi.withExtension(FgProductIntEventDao.class, dao -> dao.findById(id));
    }

    public String createFgProductIntEvent(FgProductIntEvent entity) {
        return jdbi.withExtension(FgProductIntEventDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProductIntEvent(FgProductIntEvent entity) {
        return jdbi.withExtension(FgProductIntEventDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProductIntEvent(String id) {
        jdbi.useExtension(FgProductIntEventDao.class, dao -> dao.delete(id));
    }
}
