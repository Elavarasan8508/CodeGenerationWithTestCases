package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgCpUploadErrorDao;
import com.bsit.codegeneration.record.FgCpUploadError;

public class FgCpUploadErrorRepository {

    private final Jdbi jdbi;

    public FgCpUploadErrorRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgCpUploadError> getAllFgCpUploadErrors() {
        return jdbi.withExtension(FgCpUploadErrorDao.class, fgcpuploaderrordao -> fgcpuploaderrordao.findAll());
    }

    public Optional<FgCpUploadError> getFgCpUploadErrorById(Long id) {
        return jdbi.withExtension(FgCpUploadErrorDao.class, dao -> dao.findById(id));
    }

    public Long createFgCpUploadError(FgCpUploadError entity) {
        return jdbi.withExtension(FgCpUploadErrorDao.class, dao -> dao.insert(entity));
    }

    public int updateFgCpUploadError(FgCpUploadError entity) {
        return jdbi.withExtension(FgCpUploadErrorDao.class, dao -> dao.update(entity));
    }

    public void deleteFgCpUploadError(Long id) {
        jdbi.useExtension(FgCpUploadErrorDao.class, dao -> dao.delete(id));
    }
}
