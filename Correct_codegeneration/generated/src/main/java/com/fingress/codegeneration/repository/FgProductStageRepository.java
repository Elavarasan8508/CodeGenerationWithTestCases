package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProductStageDao;
import com.bsit.codegeneration.record.FgProductStage;

public class FgProductStageRepository {

    private final Jdbi jdbi;

    public FgProductStageRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProductStage> getAllFgProductStages() {
        return jdbi.withExtension(FgProductStageDao.class, fgproductstagedao -> fgproductstagedao.findAll());
    }

    public Optional<FgProductStage> getFgProductStageById(String id) {
        return jdbi.withExtension(FgProductStageDao.class, dao -> dao.findById(id));
    }

    public String createFgProductStage(FgProductStage entity) {
        return jdbi.withExtension(FgProductStageDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProductStage(FgProductStage entity) {
        return jdbi.withExtension(FgProductStageDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProductStage(String id) {
        jdbi.useExtension(FgProductStageDao.class, dao -> dao.delete(id));
    }
}
