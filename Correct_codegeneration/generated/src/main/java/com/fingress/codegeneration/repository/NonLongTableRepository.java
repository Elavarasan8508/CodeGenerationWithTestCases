package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.NonLongTableDao;
import com.bsit.codegeneration.record.NonLongTable;

public class NonLongTableRepository {

    private final Jdbi jdbi;

    public NonLongTableRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<NonLongTable> getAllNonLongTables() {
        return jdbi.withExtension(NonLongTableDao.class, nonlongtabledao -> nonlongtabledao.findAll());
    }

    public Optional<NonLongTable> getNonLongTableById(String id) {
        return jdbi.withExtension(NonLongTableDao.class, dao -> dao.findById(id));
    }

    public String createNonLongTable(NonLongTable entity) {
        return jdbi.withExtension(NonLongTableDao.class, dao -> dao.insert(entity));
    }

    public int updateNonLongTable(NonLongTable entity) {
        return jdbi.withExtension(NonLongTableDao.class, dao -> dao.update(entity));
    }

    public void deleteNonLongTable(String id) {
        jdbi.useExtension(NonLongTableDao.class, dao -> dao.delete(id));
    }
}
