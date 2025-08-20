package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkUploadErrorDao;
import com.bsit.codegeneration.record.FgSdkUploadError;

public class FgSdkUploadErrorRepository {

    private final Jdbi jdbi;

    public FgSdkUploadErrorRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkUploadError> getAllFgSdkUploadErrors() {
        return jdbi.withExtension(FgSdkUploadErrorDao.class, fgsdkuploaderrordao -> fgsdkuploaderrordao.findAll());
    }

    public Optional<FgSdkUploadError> getFgSdkUploadErrorById(Long id) {
        return jdbi.withExtension(FgSdkUploadErrorDao.class, dao -> dao.findById(id));
    }

    public Long createFgSdkUploadError(FgSdkUploadError entity) {
        return jdbi.withExtension(FgSdkUploadErrorDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkUploadError(FgSdkUploadError entity) {
        return jdbi.withExtension(FgSdkUploadErrorDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkUploadError(Long id) {
        jdbi.useExtension(FgSdkUploadErrorDao.class, dao -> dao.delete(id));
    }
}
