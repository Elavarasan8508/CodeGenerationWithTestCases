package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkUploadDao;
import com.bsit.codegeneration.record.FgSdkUpload;

public class FgSdkUploadRepository {

    private final Jdbi jdbi;

    public FgSdkUploadRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkUpload> getAllFgSdkUploads() {
        return jdbi.withExtension(FgSdkUploadDao.class, fgsdkuploaddao -> fgsdkuploaddao.findAll());
    }

    public Optional<FgSdkUpload> getFgSdkUploadById(String id) {
        return jdbi.withExtension(FgSdkUploadDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkUpload(FgSdkUpload entity) {
        return jdbi.withExtension(FgSdkUploadDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkUpload(FgSdkUpload entity) {
        return jdbi.withExtension(FgSdkUploadDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkUpload(String id) {
        jdbi.useExtension(FgSdkUploadDao.class, dao -> dao.delete(id));
    }
}
