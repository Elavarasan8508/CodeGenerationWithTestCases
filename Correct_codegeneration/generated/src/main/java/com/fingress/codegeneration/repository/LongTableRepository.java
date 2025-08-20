package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LongTableDao;
import com.bsit.codegeneration.record.LongTable;

public class LongTableRepository {

    private final Jdbi jdbi;

    public LongTableRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LongTable> getAllLongTables() {
        return jdbi.withExtension(LongTableDao.class, longtabledao -> longtabledao.findAll());
    }

    public Optional<LongTable> getLongTableById(String id) {
        return jdbi.withExtension(LongTableDao.class, dao -> dao.findById(id));
    }

    public String createLongTable(LongTable entity) {
        return jdbi.withExtension(LongTableDao.class, dao -> dao.insert(entity));
    }

    public int updateLongTable(LongTable entity) {
        return jdbi.withExtension(LongTableDao.class, dao -> dao.update(entity));
    }

    public void deleteLongTable(String id) {
        jdbi.useExtension(LongTableDao.class, dao -> dao.delete(id));
    }
}
