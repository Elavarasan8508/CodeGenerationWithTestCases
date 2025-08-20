package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModEiEventDao;
import com.bsit.codegeneration.record.FgModEiEvent;

public class FgModEiEventRepository {

    private final Jdbi jdbi;

    public FgModEiEventRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModEiEvent> getAllFgModEiEvents() {
        return jdbi.withExtension(FgModEiEventDao.class, fgmodeieventdao -> fgmodeieventdao.findAll());
    }

    public Optional<FgModEiEvent> getFgModEiEventById(Long id) {
        return jdbi.withExtension(FgModEiEventDao.class, dao -> dao.findById(id));
    }

    public Long createFgModEiEvent(FgModEiEvent entity) {
        return jdbi.withExtension(FgModEiEventDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModEiEvent(FgModEiEvent entity) {
        return jdbi.withExtension(FgModEiEventDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModEiEvent(Long id) {
        jdbi.useExtension(FgModEiEventDao.class, dao -> dao.delete(id));
    }
}
