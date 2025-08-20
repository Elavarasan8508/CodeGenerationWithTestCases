package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgFileUploadErrorDao;
import com.bsit.codegeneration.record.FgFileUploadError;

public class FgFileUploadErrorRepository {

    private final Jdbi jdbi;

    public FgFileUploadErrorRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgFileUploadError> getAllFgFileUploadErrors() {
        return jdbi.withExtension(FgFileUploadErrorDao.class, fgfileuploaderrordao -> fgfileuploaderrordao.findAll());
    }

    public Optional<FgFileUploadError> getFgFileUploadErrorById(String id) {
        return jdbi.withExtension(FgFileUploadErrorDao.class, dao -> dao.findById(id));
    }

    public String createFgFileUploadError(FgFileUploadError entity) {
        return jdbi.withExtension(FgFileUploadErrorDao.class, dao -> dao.insert(entity));
    }

    public int updateFgFileUploadError(FgFileUploadError entity) {
        return jdbi.withExtension(FgFileUploadErrorDao.class, dao -> dao.update(entity));
    }

    public void deleteFgFileUploadError(String id) {
        jdbi.useExtension(FgFileUploadErrorDao.class, dao -> dao.delete(id));
    }
}
