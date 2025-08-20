package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiBatchDao;
import com.bsit.codegeneration.record.FgActHiBatch;

public class FgActHiBatchRepository {

    private final Jdbi jdbi;

    public FgActHiBatchRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiBatch> getAllFgActHiBatchs() {
        return jdbi.withExtension(FgActHiBatchDao.class, fgacthibatchdao -> fgacthibatchdao.findAll());
    }

    public Optional<FgActHiBatch> getFgActHiBatchById(String id) {
        return jdbi.withExtension(FgActHiBatchDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiBatch(FgActHiBatch entity) {
        return jdbi.withExtension(FgActHiBatchDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiBatch(FgActHiBatch entity) {
        return jdbi.withExtension(FgActHiBatchDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiBatch(String id) {
        jdbi.useExtension(FgActHiBatchDao.class, dao -> dao.delete(id));
    }
}
