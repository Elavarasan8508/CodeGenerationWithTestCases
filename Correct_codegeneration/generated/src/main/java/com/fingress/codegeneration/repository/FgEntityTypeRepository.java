package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgEntityTypeDao;
import com.bsit.codegeneration.record.FgEntityType;

public class FgEntityTypeRepository {

    private final Jdbi jdbi;

    public FgEntityTypeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgEntityType> getAllFgEntityTypes() {
        return jdbi.withExtension(FgEntityTypeDao.class, fgentitytypedao -> fgentitytypedao.findAll());
    }

    public Optional<FgEntityType> getFgEntityTypeById(Long id) {
        return jdbi.withExtension(FgEntityTypeDao.class, dao -> dao.findById(id));
    }

    public Long createFgEntityType(FgEntityType entity) {
        return jdbi.withExtension(FgEntityTypeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgEntityType(FgEntityType entity) {
        return jdbi.withExtension(FgEntityTypeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgEntityType(Long id) {
        jdbi.useExtension(FgEntityTypeDao.class, dao -> dao.delete(id));
    }
}
