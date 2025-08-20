package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgIrNostroStaggingDao;
import com.bsit.codegeneration.record.FgIrNostroStagging;

public class FgIrNostroStaggingRepository {

    private final Jdbi jdbi;

    public FgIrNostroStaggingRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgIrNostroStagging> getAllFgIrNostroStaggings() {
        return jdbi.withExtension(FgIrNostroStaggingDao.class, fgirnostrostaggingdao -> fgirnostrostaggingdao.findAll());
    }

    public Optional<FgIrNostroStagging> getFgIrNostroStaggingById(String id) {
        return jdbi.withExtension(FgIrNostroStaggingDao.class, dao -> dao.findById(id));
    }

    public String createFgIrNostroStagging(FgIrNostroStagging entity) {
        return jdbi.withExtension(FgIrNostroStaggingDao.class, dao -> dao.insert(entity));
    }

    public int updateFgIrNostroStagging(FgIrNostroStagging entity) {
        return jdbi.withExtension(FgIrNostroStaggingDao.class, dao -> dao.update(entity));
    }

    public void deleteFgIrNostroStagging(String id) {
        jdbi.useExtension(FgIrNostroStaggingDao.class, dao -> dao.delete(id));
    }
}
