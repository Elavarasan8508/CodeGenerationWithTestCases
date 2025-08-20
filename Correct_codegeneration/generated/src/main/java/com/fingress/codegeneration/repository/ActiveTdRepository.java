package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ActiveTdDao;
import com.bsit.codegeneration.record.ActiveTd;

public class ActiveTdRepository {

    private final Jdbi jdbi;

    public ActiveTdRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<ActiveTd> getAllActiveTds() {
        return jdbi.withExtension(ActiveTdDao.class, activetddao -> activetddao.findAll());
    }

    public Optional<ActiveTd> getActiveTdById(Long id) {
        return jdbi.withExtension(ActiveTdDao.class, dao -> dao.findById(id));
    }

    public Long createActiveTd(ActiveTd entity) {
        return jdbi.withExtension(ActiveTdDao.class, dao -> dao.insert(entity));
    }

    public int updateActiveTd(ActiveTd entity) {
        return jdbi.withExtension(ActiveTdDao.class, dao -> dao.update(entity));
    }

    public void deleteActiveTd(Long id) {
        jdbi.useExtension(ActiveTdDao.class, dao -> dao.delete(id));
    }
}
