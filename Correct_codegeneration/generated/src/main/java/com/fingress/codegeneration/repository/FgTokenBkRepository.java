package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTokenBkDao;
import com.bsit.codegeneration.record.FgTokenBk;

public class FgTokenBkRepository {

    private final Jdbi jdbi;

    public FgTokenBkRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTokenBk> getAllFgTokenBks() {
        return jdbi.withExtension(FgTokenBkDao.class, fgtokenbkdao -> fgtokenbkdao.findAll());
    }

    public Optional<FgTokenBk> getFgTokenBkById(String id) {
        return jdbi.withExtension(FgTokenBkDao.class, dao -> dao.findById(id));
    }

    public String createFgTokenBk(FgTokenBk entity) {
        return jdbi.withExtension(FgTokenBkDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTokenBk(FgTokenBk entity) {
        return jdbi.withExtension(FgTokenBkDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTokenBk(String id) {
        jdbi.useExtension(FgTokenBkDao.class, dao -> dao.delete(id));
    }
}
