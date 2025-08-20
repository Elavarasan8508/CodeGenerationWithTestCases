package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModCaseEntityDao;
import com.bsit.codegeneration.record.FgModCaseEntity;

public class FgModCaseEntityRepository {

    private final Jdbi jdbi;

    public FgModCaseEntityRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModCaseEntity> getAllFgModCaseEntitys() {
        return jdbi.withExtension(FgModCaseEntityDao.class, fgmodcaseentitydao -> fgmodcaseentitydao.findAll());
    }

    public Optional<FgModCaseEntity> getFgModCaseEntityById(Long id) {
        return jdbi.withExtension(FgModCaseEntityDao.class, dao -> dao.findById(id));
    }

    public Long createFgModCaseEntity(FgModCaseEntity entity) {
        return jdbi.withExtension(FgModCaseEntityDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModCaseEntity(FgModCaseEntity entity) {
        return jdbi.withExtension(FgModCaseEntityDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModCaseEntity(Long id) {
        jdbi.useExtension(FgModCaseEntityDao.class, dao -> dao.delete(id));
    }
}
