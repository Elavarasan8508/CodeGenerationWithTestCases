package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModBatchTnxDao;
import com.bsit.codegeneration.record.FgModBatchTnx;

public class FgModBatchTnxRepository {

    private final Jdbi jdbi;

    public FgModBatchTnxRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModBatchTnx> getAllFgModBatchTnxs() {
        return jdbi.withExtension(FgModBatchTnxDao.class, fgmodbatchtnxdao -> fgmodbatchtnxdao.findAll());
    }

    public Optional<FgModBatchTnx> getFgModBatchTnxById(Long id) {
        return jdbi.withExtension(FgModBatchTnxDao.class, dao -> dao.findById(id));
    }

    public Long createFgModBatchTnx(FgModBatchTnx entity) {
        return jdbi.withExtension(FgModBatchTnxDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModBatchTnx(FgModBatchTnx entity) {
        return jdbi.withExtension(FgModBatchTnxDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModBatchTnx(Long id) {
        jdbi.useExtension(FgModBatchTnxDao.class, dao -> dao.delete(id));
    }
}
