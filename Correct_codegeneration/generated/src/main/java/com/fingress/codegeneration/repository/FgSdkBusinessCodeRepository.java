package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkBusinessCodeDao;
import com.bsit.codegeneration.record.FgSdkBusinessCode;

public class FgSdkBusinessCodeRepository {

    private final Jdbi jdbi;

    public FgSdkBusinessCodeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkBusinessCode> getAllFgSdkBusinessCodes() {
        return jdbi.withExtension(FgSdkBusinessCodeDao.class, fgsdkbusinesscodedao -> fgsdkbusinesscodedao.findAll());
    }

    public Optional<FgSdkBusinessCode> getFgSdkBusinessCodeById(Long id) {
        return jdbi.withExtension(FgSdkBusinessCodeDao.class, dao -> dao.findById(id));
    }

    public Long createFgSdkBusinessCode(FgSdkBusinessCode entity) {
        return jdbi.withExtension(FgSdkBusinessCodeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkBusinessCode(FgSdkBusinessCode entity) {
        return jdbi.withExtension(FgSdkBusinessCodeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkBusinessCode(Long id) {
        jdbi.useExtension(FgSdkBusinessCodeDao.class, dao -> dao.delete(id));
    }
}
