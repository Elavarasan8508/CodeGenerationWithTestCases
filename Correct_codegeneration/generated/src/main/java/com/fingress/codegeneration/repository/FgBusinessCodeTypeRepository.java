package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgBusinessCodeTypeDao;
import com.bsit.codegeneration.record.FgBusinessCodeType;

public class FgBusinessCodeTypeRepository {

    private final Jdbi jdbi;

    public FgBusinessCodeTypeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgBusinessCodeType> getAllFgBusinessCodeTypes() {
        return jdbi.withExtension(FgBusinessCodeTypeDao.class, fgbusinesscodetypedao -> fgbusinesscodetypedao.findAll());
    }

    public Optional<FgBusinessCodeType> getFgBusinessCodeTypeById(String id) {
        return jdbi.withExtension(FgBusinessCodeTypeDao.class, dao -> dao.findById(id));
    }

    public String createFgBusinessCodeType(FgBusinessCodeType entity) {
        return jdbi.withExtension(FgBusinessCodeTypeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgBusinessCodeType(FgBusinessCodeType entity) {
        return jdbi.withExtension(FgBusinessCodeTypeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgBusinessCodeType(String id) {
        jdbi.useExtension(FgBusinessCodeTypeDao.class, dao -> dao.delete(id));
    }
}
