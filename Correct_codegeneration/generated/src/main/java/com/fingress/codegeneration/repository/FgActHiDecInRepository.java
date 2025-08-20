package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiDecInDao;
import com.bsit.codegeneration.record.FgActHiDecIn;

public class FgActHiDecInRepository {

    private final Jdbi jdbi;

    public FgActHiDecInRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiDecIn> getAllFgActHiDecIns() {
        return jdbi.withExtension(FgActHiDecInDao.class, fgacthidecindao -> fgacthidecindao.findAll());
    }

    public Optional<FgActHiDecIn> getFgActHiDecInById(String id) {
        return jdbi.withExtension(FgActHiDecInDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiDecIn(FgActHiDecIn entity) {
        return jdbi.withExtension(FgActHiDecInDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiDecIn(FgActHiDecIn entity) {
        return jdbi.withExtension(FgActHiDecInDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiDecIn(String id) {
        jdbi.useExtension(FgActHiDecInDao.class, dao -> dao.delete(id));
    }
}
