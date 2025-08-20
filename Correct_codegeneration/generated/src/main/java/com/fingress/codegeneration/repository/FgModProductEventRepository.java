package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModProductEventDao;
import com.bsit.codegeneration.record.FgModProductEvent;

public class FgModProductEventRepository {

    private final Jdbi jdbi;

    public FgModProductEventRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModProductEvent> getAllFgModProductEvents() {
        return jdbi.withExtension(FgModProductEventDao.class, fgmodproducteventdao -> fgmodproducteventdao.findAll());
    }

    public Optional<FgModProductEvent> getFgModProductEventById(String id) {
        return jdbi.withExtension(FgModProductEventDao.class, dao -> dao.findById(id));
    }

    public String createFgModProductEvent(FgModProductEvent entity) {
        return jdbi.withExtension(FgModProductEventDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModProductEvent(FgModProductEvent entity) {
        return jdbi.withExtension(FgModProductEventDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModProductEvent(String id) {
        jdbi.useExtension(FgModProductEventDao.class, dao -> dao.delete(id));
    }
}
