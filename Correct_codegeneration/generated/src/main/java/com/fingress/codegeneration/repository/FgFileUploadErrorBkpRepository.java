package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgFileUploadErrorBkpDao;
import com.bsit.codegeneration.record.FgFileUploadErrorBkp;

public class FgFileUploadErrorBkpRepository {

    private final Jdbi jdbi;

    public FgFileUploadErrorBkpRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgFileUploadErrorBkp> getAllFgFileUploadErrorBkps() {
        return jdbi.withExtension(FgFileUploadErrorBkpDao.class, fgfileuploaderrorbkpdao -> fgfileuploaderrorbkpdao.findAll());
    }

    public Optional<FgFileUploadErrorBkp> getFgFileUploadErrorBkpById(Long id) {
        return jdbi.withExtension(FgFileUploadErrorBkpDao.class, dao -> dao.findById(id));
    }

    public Long createFgFileUploadErrorBkp(FgFileUploadErrorBkp entity) {
        return jdbi.withExtension(FgFileUploadErrorBkpDao.class, dao -> dao.insert(entity));
    }

    public int updateFgFileUploadErrorBkp(FgFileUploadErrorBkp entity) {
        return jdbi.withExtension(FgFileUploadErrorBkpDao.class, dao -> dao.update(entity));
    }

    public void deleteFgFileUploadErrorBkp(Long id) {
        jdbi.useExtension(FgFileUploadErrorBkpDao.class, dao -> dao.delete(id));
    }
}
