package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.TestEfircQueryDao;
import com.bsit.codegeneration.record.TestEfircQuery;

public class TestEfircQueryRepository {

    private final Jdbi jdbi;

    public TestEfircQueryRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<TestEfircQuery> getAllTestEfircQuerys() {
        return jdbi.withExtension(TestEfircQueryDao.class, testefircquerydao -> testefircquerydao.findAll());
    }

    public Optional<TestEfircQuery> getTestEfircQueryById(String id) {
        return jdbi.withExtension(TestEfircQueryDao.class, dao -> dao.findById(id));
    }

    public String createTestEfircQuery(TestEfircQuery entity) {
        return jdbi.withExtension(TestEfircQueryDao.class, dao -> dao.insert(entity));
    }

    public int updateTestEfircQuery(TestEfircQuery entity) {
        return jdbi.withExtension(TestEfircQueryDao.class, dao -> dao.update(entity));
    }

    public void deleteTestEfircQuery(String id) {
        jdbi.useExtension(TestEfircQueryDao.class, dao -> dao.delete(id));
    }
}
