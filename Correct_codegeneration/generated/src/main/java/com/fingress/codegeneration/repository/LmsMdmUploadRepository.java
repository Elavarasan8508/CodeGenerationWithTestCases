package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LmsMdmUploadDao;
import com.bsit.codegeneration.record.LmsMdmUpload;

public class LmsMdmUploadRepository {

    private final Jdbi jdbi;

    public LmsMdmUploadRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LmsMdmUpload> getAllLmsMdmUploads() {
        return jdbi.withExtension(LmsMdmUploadDao.class, lmsmdmuploaddao -> lmsmdmuploaddao.findAll());
    }

    public Optional<LmsMdmUpload> getLmsMdmUploadById(String id) {
        return jdbi.withExtension(LmsMdmUploadDao.class, dao -> dao.findById(id));
    }

    public String createLmsMdmUpload(LmsMdmUpload entity) {
        return jdbi.withExtension(LmsMdmUploadDao.class, dao -> dao.insert(entity));
    }

    public int updateLmsMdmUpload(LmsMdmUpload entity) {
        return jdbi.withExtension(LmsMdmUploadDao.class, dao -> dao.update(entity));
    }

    public void deleteLmsMdmUpload(String id) {
        jdbi.useExtension(LmsMdmUploadDao.class, dao -> dao.delete(id));
    }
}
