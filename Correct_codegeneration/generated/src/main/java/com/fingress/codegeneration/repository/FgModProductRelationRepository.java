package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModProductRelationDao;
import com.bsit.codegeneration.record.FgModProductRelation;

public class FgModProductRelationRepository {

    private final Jdbi jdbi;

    public FgModProductRelationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModProductRelation> getAllFgModProductRelations() {
        return jdbi.withExtension(FgModProductRelationDao.class, fgmodproductrelationdao -> fgmodproductrelationdao.findAll());
    }

    public Optional<FgModProductRelation> getFgModProductRelationById(Long id) {
        return jdbi.withExtension(FgModProductRelationDao.class, dao -> dao.findById(id));
    }

    public Long createFgModProductRelation(FgModProductRelation entity) {
        return jdbi.withExtension(FgModProductRelationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModProductRelation(FgModProductRelation entity) {
        return jdbi.withExtension(FgModProductRelationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModProductRelation(Long id) {
        jdbi.useExtension(FgModProductRelationDao.class, dao -> dao.delete(id));
    }
}
