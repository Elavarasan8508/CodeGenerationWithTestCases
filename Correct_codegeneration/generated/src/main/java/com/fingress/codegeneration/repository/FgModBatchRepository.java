package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModBatchDao;
import com.bsit.codegeneration.record.FgModBatch;

public class FgModBatchRepository {

    private final Jdbi jdbi;

    public FgModBatchRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModBatch> getAllFgModBatchs() {
        return jdbi.withExtension(FgModBatchDao.class, fgmodbatchdao -> fgmodbatchdao.findAll());
    }

    public Optional<FgModBatch> getFgModBatchById(String id) {
        return jdbi.withExtension(FgModBatchDao.class, dao -> dao.findById(id));
    }

    public String createFgModBatch(FgModBatch entity) {
        return jdbi.withExtension(FgModBatchDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModBatch(FgModBatch entity) {
        return jdbi.withExtension(FgModBatchDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModBatch(String id) {
        jdbi.useExtension(FgModBatchDao.class, dao -> dao.delete(id));
    }
}
