package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.TestPostProcessorDao;
import com.bsit.codegeneration.record.TestPostProcessor;

public class TestPostProcessorRepository {

    private final Jdbi jdbi;

    public TestPostProcessorRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<TestPostProcessor> getAllTestPostProcessors() {
        return jdbi.withExtension(TestPostProcessorDao.class, testpostprocessordao -> testpostprocessordao.findAll());
    }

    public Optional<TestPostProcessor> getTestPostProcessorById(String id) {
        return jdbi.withExtension(TestPostProcessorDao.class, dao -> dao.findById(id));
    }

    public String createTestPostProcessor(TestPostProcessor entity) {
        return jdbi.withExtension(TestPostProcessorDao.class, dao -> dao.insert(entity));
    }

    public int updateTestPostProcessor(TestPostProcessor entity) {
        return jdbi.withExtension(TestPostProcessorDao.class, dao -> dao.update(entity));
    }

    public void deleteTestPostProcessor(String id) {
        jdbi.useExtension(TestPostProcessorDao.class, dao -> dao.delete(id));
    }
}
