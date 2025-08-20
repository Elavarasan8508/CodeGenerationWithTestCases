package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.TestModelDao;
import com.bsit.codegeneration.record.TestModel;

public class TestModelRepository {

    private final Jdbi jdbi;

    public TestModelRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<TestModel> getAllTestModels() {
        return jdbi.withExtension(TestModelDao.class, testmodeldao -> testmodeldao.findAll());
    }

    public Optional<TestModel> getTestModelById(String id) {
        return jdbi.withExtension(TestModelDao.class, dao -> dao.findById(id));
    }

    public String createTestModel(TestModel entity) {
        return jdbi.withExtension(TestModelDao.class, dao -> dao.insert(entity));
    }

    public int updateTestModel(TestModel entity) {
        return jdbi.withExtension(TestModelDao.class, dao -> dao.update(entity));
    }

    public void deleteTestModel(String id) {
        jdbi.useExtension(TestModelDao.class, dao -> dao.delete(id));
    }
}
