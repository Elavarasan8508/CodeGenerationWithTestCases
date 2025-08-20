package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAlkemBdDao;
import com.bsit.codegeneration.record.FgAlkemBd;

public class FgAlkemBdRepository {

    private final Jdbi jdbi;

    public FgAlkemBdRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAlkemBd> getAllFgAlkemBds() {
        return jdbi.withExtension(FgAlkemBdDao.class, fgalkembddao -> fgalkembddao.findAll());
    }

    public Optional<FgAlkemBd> getFgAlkemBdById(String id) {
        return jdbi.withExtension(FgAlkemBdDao.class, dao -> dao.findById(id));
    }

    public String createFgAlkemBd(FgAlkemBd entity) {
        return jdbi.withExtension(FgAlkemBdDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAlkemBd(FgAlkemBd entity) {
        return jdbi.withExtension(FgAlkemBdDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAlkemBd(String id) {
        jdbi.useExtension(FgAlkemBdDao.class, dao -> dao.delete(id));
    }
}
