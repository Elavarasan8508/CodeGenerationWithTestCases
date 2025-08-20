package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.BdUploadErrorDao;
import com.bsit.codegeneration.record.BdUploadError;

public class BdUploadErrorRepository {

    private final Jdbi jdbi;

    public BdUploadErrorRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<BdUploadError> getAllBdUploadErrors() {
        return jdbi.withExtension(BdUploadErrorDao.class, bduploaderrordao -> bduploaderrordao.findAll());
    }

    public Optional<BdUploadError> getBdUploadErrorById(Long id) {
        return jdbi.withExtension(BdUploadErrorDao.class, dao -> dao.findById(id));
    }

    public Long createBdUploadError(BdUploadError entity) {
        return jdbi.withExtension(BdUploadErrorDao.class, dao -> dao.insert(entity));
    }

    public int updateBdUploadError(BdUploadError entity) {
        return jdbi.withExtension(BdUploadErrorDao.class, dao -> dao.update(entity));
    }

    public void deleteBdUploadError(Long id) {
        jdbi.useExtension(BdUploadErrorDao.class, dao -> dao.delete(id));
    }
}
