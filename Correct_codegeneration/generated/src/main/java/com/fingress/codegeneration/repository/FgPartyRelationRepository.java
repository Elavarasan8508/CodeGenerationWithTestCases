package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyRelationDao;
import com.bsit.codegeneration.record.FgPartyRelation;

public class FgPartyRelationRepository {

    private final Jdbi jdbi;

    public FgPartyRelationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyRelation> getAllFgPartyRelations() {
        return jdbi.withExtension(FgPartyRelationDao.class, fgpartyrelationdao -> fgpartyrelationdao.findAll());
    }

    public Optional<FgPartyRelation> getFgPartyRelationById(Long id) {
        return jdbi.withExtension(FgPartyRelationDao.class, dao -> dao.findById(id));
    }

    public Long createFgPartyRelation(FgPartyRelation entity) {
        return jdbi.withExtension(FgPartyRelationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyRelation(FgPartyRelation entity) {
        return jdbi.withExtension(FgPartyRelationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyRelation(Long id) {
        jdbi.useExtension(FgPartyRelationDao.class, dao -> dao.delete(id));
    }
}
