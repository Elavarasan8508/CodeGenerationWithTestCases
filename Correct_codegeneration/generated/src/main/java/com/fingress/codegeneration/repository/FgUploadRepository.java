package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgUploadDao;
import com.bsit.codegeneration.record.FgUpload;

public class FgUploadRepository {

    private final Jdbi jdbi;

    public FgUploadRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgUpload> getAllFgUploads() {
        return jdbi.withExtension(FgUploadDao.class, fguploaddao -> fguploaddao.findAll());
    }

    public Optional<FgUpload> getFgUploadById(String id) {
        return jdbi.withExtension(FgUploadDao.class, dao -> dao.findById(id));
    }

    public String createFgUpload(FgUpload entity) {
        return jdbi.withExtension(FgUploadDao.class, dao -> dao.insert(entity));
    }

    public int updateFgUpload(FgUpload entity) {
        return jdbi.withExtension(FgUploadDao.class, dao -> dao.update(entity));
    }

    public void deleteFgUpload(String id) {
        jdbi.useExtension(FgUploadDao.class, dao -> dao.delete(id));
    }
}
