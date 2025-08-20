package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.D4pfDao;
import com.bsit.codegeneration.record.D4pf;

public class D4pfRepository {

    private final Jdbi jdbi;

    public D4pfRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<D4pf> getAllD4pfs() {
        return jdbi.withExtension(D4pfDao.class, d4pfdao -> d4pfdao.findAll());
    }

    public Optional<D4pf> getD4pfById(String id) {
        return jdbi.withExtension(D4pfDao.class, dao -> dao.findById(id));
    }

    public String createD4pf(D4pf entity) {
        return jdbi.withExtension(D4pfDao.class, dao -> dao.insert(entity));
    }

    public int updateD4pf(D4pf entity) {
        return jdbi.withExtension(D4pfDao.class, dao -> dao.update(entity));
    }

    public void deleteD4pf(String id) {
        jdbi.useExtension(D4pfDao.class, dao -> dao.delete(id));
    }
}
