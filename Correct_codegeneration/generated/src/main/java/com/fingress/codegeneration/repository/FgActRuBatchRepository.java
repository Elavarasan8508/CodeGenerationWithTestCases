package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuBatchDao;
import com.bsit.codegeneration.record.FgActRuBatch;

public class FgActRuBatchRepository {

    private final Jdbi jdbi;

    public FgActRuBatchRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuBatch> getAllFgActRuBatchs() {
        return jdbi.withExtension(FgActRuBatchDao.class, fgactrubatchdao -> fgactrubatchdao.findAll());
    }

    public Optional<FgActRuBatch> getFgActRuBatchById(String id) {
        return jdbi.withExtension(FgActRuBatchDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuBatch(FgActRuBatch entity) {
        return jdbi.withExtension(FgActRuBatchDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuBatch(FgActRuBatch entity) {
        return jdbi.withExtension(FgActRuBatchDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuBatch(String id) {
        jdbi.useExtension(FgActRuBatchDao.class, dao -> dao.delete(id));
    }
}
