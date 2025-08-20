package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.TestShippingbillQueryDao;
import com.bsit.codegeneration.record.TestShippingbillQuery;

public class TestShippingbillQueryRepository {

    private final Jdbi jdbi;

    public TestShippingbillQueryRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<TestShippingbillQuery> getAllTestShippingbillQuerys() {
        return jdbi.withExtension(TestShippingbillQueryDao.class, testshippingbillquerydao -> testshippingbillquerydao.findAll());
    }

    public Optional<TestShippingbillQuery> getTestShippingbillQueryById(Long id) {
        return jdbi.withExtension(TestShippingbillQueryDao.class, dao -> dao.findById(id));
    }

    public Long createTestShippingbillQuery(TestShippingbillQuery entity) {
        return jdbi.withExtension(TestShippingbillQueryDao.class, dao -> dao.insert(entity));
    }

    public int updateTestShippingbillQuery(TestShippingbillQuery entity) {
        return jdbi.withExtension(TestShippingbillQueryDao.class, dao -> dao.update(entity));
    }

    public void deleteTestShippingbillQuery(Long id) {
        jdbi.useExtension(TestShippingbillQueryDao.class, dao -> dao.delete(id));
    }
}
