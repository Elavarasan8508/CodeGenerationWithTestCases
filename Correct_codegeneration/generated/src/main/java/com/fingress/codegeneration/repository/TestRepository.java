package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.TestDao;
import com.bsit.codegeneration.record.Test;

public class TestRepository {

    private final Jdbi jdbi;

    public TestRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Test> getAllTests() {
        return jdbi.withExtension(TestDao.class, testdao -> testdao.findAll());
    }

    public Optional<Test> getTestById(Long id) {
        return jdbi.withExtension(TestDao.class, dao -> dao.findById(id));
    }

    public Long createTest(Test entity) {
        return jdbi.withExtension(TestDao.class, dao -> dao.insert(entity));
    }

    public int updateTest(Test entity) {
        return jdbi.withExtension(TestDao.class, dao -> dao.update(entity));
    }

    public void deleteTest(Long id) {
        jdbi.useExtension(TestDao.class, dao -> dao.delete(id));
    }
}
