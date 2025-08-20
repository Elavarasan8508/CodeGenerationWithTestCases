package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyEntityDao;
import com.bsit.codegeneration.record.FgPartyEntity;

public class FgPartyEntityRepository {

    private final Jdbi jdbi;

    public FgPartyEntityRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyEntity> getAllFgPartyEntitys() {
        return jdbi.withExtension(FgPartyEntityDao.class, fgpartyentitydao -> fgpartyentitydao.findAll());
    }

    public Optional<FgPartyEntity> getFgPartyEntityById(Long id) {
        return jdbi.withExtension(FgPartyEntityDao.class, dao -> dao.findById(id));
    }

    public Long createFgPartyEntity(FgPartyEntity entity) {
        return jdbi.withExtension(FgPartyEntityDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyEntity(FgPartyEntity entity) {
        return jdbi.withExtension(FgPartyEntityDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyEntity(Long id) {
        jdbi.useExtension(FgPartyEntityDao.class, dao -> dao.delete(id));
    }
}
