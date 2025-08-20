package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdLcDao;
import com.bsit.codegeneration.record.FgTrdLc;

public class FgTrdLcRepository {

    private final Jdbi jdbi;

    public FgTrdLcRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdLc> getAllFgTrdLcs() {
        return jdbi.withExtension(FgTrdLcDao.class, fgtrdlcdao -> fgtrdlcdao.findAll());
    }

    public Optional<FgTrdLc> getFgTrdLcById(String id) {
        return jdbi.withExtension(FgTrdLcDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdLc(FgTrdLc entity) {
        return jdbi.withExtension(FgTrdLcDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdLc(FgTrdLc entity) {
        return jdbi.withExtension(FgTrdLcDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdLc(String id) {
        jdbi.useExtension(FgTrdLcDao.class, dao -> dao.delete(id));
    }
}
