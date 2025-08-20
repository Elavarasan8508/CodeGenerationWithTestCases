package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTokenCloneDao;
import com.bsit.codegeneration.record.FgTokenClone;

public class FgTokenCloneRepository {

    private final Jdbi jdbi;

    public FgTokenCloneRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTokenClone> getAllFgTokenClones() {
        return jdbi.withExtension(FgTokenCloneDao.class, fgtokenclonedao -> fgtokenclonedao.findAll());
    }

    public Optional<FgTokenClone> getFgTokenCloneById(String id) {
        return jdbi.withExtension(FgTokenCloneDao.class, dao -> dao.findById(id));
    }

    public String createFgTokenClone(FgTokenClone entity) {
        return jdbi.withExtension(FgTokenCloneDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTokenClone(FgTokenClone entity) {
        return jdbi.withExtension(FgTokenCloneDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTokenClone(String id) {
        jdbi.useExtension(FgTokenCloneDao.class, dao -> dao.delete(id));
    }
}
