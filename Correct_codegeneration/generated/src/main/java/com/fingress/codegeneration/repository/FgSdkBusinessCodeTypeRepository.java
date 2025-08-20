package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkBusinessCodeTypeDao;
import com.bsit.codegeneration.record.FgSdkBusinessCodeType;

public class FgSdkBusinessCodeTypeRepository {

    private final Jdbi jdbi;

    public FgSdkBusinessCodeTypeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkBusinessCodeType> getAllFgSdkBusinessCodeTypes() {
        return jdbi.withExtension(FgSdkBusinessCodeTypeDao.class, fgsdkbusinesscodetypedao -> fgsdkbusinesscodetypedao.findAll());
    }

    public Optional<FgSdkBusinessCodeType> getFgSdkBusinessCodeTypeById(String id) {
        return jdbi.withExtension(FgSdkBusinessCodeTypeDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkBusinessCodeType(FgSdkBusinessCodeType entity) {
        return jdbi.withExtension(FgSdkBusinessCodeTypeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkBusinessCodeType(FgSdkBusinessCodeType entity) {
        return jdbi.withExtension(FgSdkBusinessCodeTypeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkBusinessCodeType(String id) {
        jdbi.useExtension(FgSdkBusinessCodeTypeDao.class, dao -> dao.delete(id));
    }
}
