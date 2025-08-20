package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgCpUploadDao;
import com.bsit.codegeneration.record.FgCpUpload;

public class FgCpUploadRepository {

    private final Jdbi jdbi;

    public FgCpUploadRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgCpUpload> getAllFgCpUploads() {
        return jdbi.withExtension(FgCpUploadDao.class, fgcpuploaddao -> fgcpuploaddao.findAll());
    }

    public Optional<FgCpUpload> getFgCpUploadById(String id) {
        return jdbi.withExtension(FgCpUploadDao.class, dao -> dao.findById(id));
    }

    public String createFgCpUpload(FgCpUpload entity) {
        return jdbi.withExtension(FgCpUploadDao.class, dao -> dao.insert(entity));
    }

    public int updateFgCpUpload(FgCpUpload entity) {
        return jdbi.withExtension(FgCpUploadDao.class, dao -> dao.update(entity));
    }

    public void deleteFgCpUpload(String id) {
        jdbi.useExtension(FgCpUploadDao.class, dao -> dao.delete(id));
    }
}
