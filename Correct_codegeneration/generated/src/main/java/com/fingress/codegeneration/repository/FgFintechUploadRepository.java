package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgFintechUploadDao;
import com.bsit.codegeneration.record.FgFintechUpload;

public class FgFintechUploadRepository {

    private final Jdbi jdbi;

    public FgFintechUploadRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgFintechUpload> getAllFgFintechUploads() {
        return jdbi.withExtension(FgFintechUploadDao.class, fgfintechuploaddao -> fgfintechuploaddao.findAll());
    }

    public Optional<FgFintechUpload> getFgFintechUploadById(String id) {
        return jdbi.withExtension(FgFintechUploadDao.class, dao -> dao.findById(id));
    }

    public String createFgFintechUpload(FgFintechUpload entity) {
        return jdbi.withExtension(FgFintechUploadDao.class, dao -> dao.insert(entity));
    }

    public int updateFgFintechUpload(FgFintechUpload entity) {
        return jdbi.withExtension(FgFintechUploadDao.class, dao -> dao.update(entity));
    }

    public void deleteFgFintechUpload(String id) {
        jdbi.useExtension(FgFintechUploadDao.class, dao -> dao.delete(id));
    }
}
