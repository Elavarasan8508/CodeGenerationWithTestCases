package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgFileUploadDao;
import com.bsit.codegeneration.record.FgFileUpload;

public class FgFileUploadRepository {

    private final Jdbi jdbi;

    public FgFileUploadRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgFileUpload> getAllFgFileUploads() {
        return jdbi.withExtension(FgFileUploadDao.class, fgfileuploaddao -> fgfileuploaddao.findAll());
    }

    public Optional<FgFileUpload> getFgFileUploadById(String id) {
        return jdbi.withExtension(FgFileUploadDao.class, dao -> dao.findById(id));
    }

    public String createFgFileUpload(FgFileUpload entity) {
        return jdbi.withExtension(FgFileUploadDao.class, dao -> dao.insert(entity));
    }

    public int updateFgFileUpload(FgFileUpload entity) {
        return jdbi.withExtension(FgFileUploadDao.class, dao -> dao.update(entity));
    }

    public void deleteFgFileUpload(String id) {
        jdbi.useExtension(FgFileUploadDao.class, dao -> dao.delete(id));
    }
}
