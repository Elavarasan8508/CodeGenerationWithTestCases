package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgUploadErrorDao;
import com.bsit.codegeneration.record.FgUploadError;

public class FgUploadErrorRepository {

    private final Jdbi jdbi;

    public FgUploadErrorRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgUploadError> getAllFgUploadErrors() {
        return jdbi.withExtension(FgUploadErrorDao.class, fguploaderrordao -> fguploaderrordao.findAll());
    }

    public Optional<FgUploadError> getFgUploadErrorById(Long id) {
        return jdbi.withExtension(FgUploadErrorDao.class, dao -> dao.findById(id));
    }

    public Long createFgUploadError(FgUploadError entity) {
        return jdbi.withExtension(FgUploadErrorDao.class, dao -> dao.insert(entity));
    }

    public int updateFgUploadError(FgUploadError entity) {
        return jdbi.withExtension(FgUploadErrorDao.class, dao -> dao.update(entity));
    }

    public void deleteFgUploadError(Long id) {
        jdbi.useExtension(FgUploadErrorDao.class, dao -> dao.delete(id));
    }
}
