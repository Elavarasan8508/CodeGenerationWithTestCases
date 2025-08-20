package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDmsEventDao;
import com.bsit.codegeneration.record.FgDmsEvent;

public class FgDmsEventRepository {

    private final Jdbi jdbi;

    public FgDmsEventRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDmsEvent> getAllFgDmsEvents() {
        return jdbi.withExtension(FgDmsEventDao.class, fgdmseventdao -> fgdmseventdao.findAll());
    }

    public Optional<FgDmsEvent> getFgDmsEventById(String id) {
        return jdbi.withExtension(FgDmsEventDao.class, dao -> dao.findById(id));
    }

    public String createFgDmsEvent(FgDmsEvent entity) {
        return jdbi.withExtension(FgDmsEventDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDmsEvent(FgDmsEvent entity) {
        return jdbi.withExtension(FgDmsEventDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDmsEvent(String id) {
        jdbi.useExtension(FgDmsEventDao.class, dao -> dao.delete(id));
    }
}
