package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LmsMdmUploadErrorDao;
import com.bsit.codegeneration.record.LmsMdmUploadError;

public class LmsMdmUploadErrorRepository {

    private final Jdbi jdbi;

    public LmsMdmUploadErrorRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LmsMdmUploadError> getAllLmsMdmUploadErrors() {
        return jdbi.withExtension(LmsMdmUploadErrorDao.class, lmsmdmuploaderrordao -> lmsmdmuploaderrordao.findAll());
    }

    public Optional<LmsMdmUploadError> getLmsMdmUploadErrorById(String id) {
        return jdbi.withExtension(LmsMdmUploadErrorDao.class, dao -> dao.findById(id));
    }

    public String createLmsMdmUploadError(LmsMdmUploadError entity) {
        return jdbi.withExtension(LmsMdmUploadErrorDao.class, dao -> dao.insert(entity));
    }

    public int updateLmsMdmUploadError(LmsMdmUploadError entity) {
        return jdbi.withExtension(LmsMdmUploadErrorDao.class, dao -> dao.update(entity));
    }

    public void deleteLmsMdmUploadError(String id) {
        jdbi.useExtension(LmsMdmUploadErrorDao.class, dao -> dao.delete(id));
    }
}
