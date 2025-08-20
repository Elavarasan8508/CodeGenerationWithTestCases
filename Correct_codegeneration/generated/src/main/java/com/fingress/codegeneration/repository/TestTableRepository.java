package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.TestTableDao;
import com.bsit.codegeneration.record.TestTable;

public class TestTableRepository {

    private final Jdbi jdbi;

    public TestTableRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<TestTable> getAllTestTables() {
        return jdbi.withExtension(TestTableDao.class, testtabledao -> testtabledao.findAll());
    }

    public Optional<TestTable> getTestTableById(String id) {
        return jdbi.withExtension(TestTableDao.class, dao -> dao.findById(id));
    }

    public String createTestTable(TestTable entity) {
        return jdbi.withExtension(TestTableDao.class, dao -> dao.insert(entity));
    }

    public int updateTestTable(TestTable entity) {
        return jdbi.withExtension(TestTableDao.class, dao -> dao.update(entity));
    }

    public void deleteTestTable(String id) {
        jdbi.useExtension(TestTableDao.class, dao -> dao.delete(id));
    }
}
