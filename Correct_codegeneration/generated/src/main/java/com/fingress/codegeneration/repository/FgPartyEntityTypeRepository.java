package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyEntityTypeDao;
import com.bsit.codegeneration.record.FgPartyEntityType;

public class FgPartyEntityTypeRepository {

    private final Jdbi jdbi;

    public FgPartyEntityTypeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyEntityType> getAllFgPartyEntityTypes() {
        return jdbi.withExtension(FgPartyEntityTypeDao.class, fgpartyentitytypedao -> fgpartyentitytypedao.findAll());
    }

    public Optional<FgPartyEntityType> getFgPartyEntityTypeById(String id) {
        return jdbi.withExtension(FgPartyEntityTypeDao.class, dao -> dao.findById(id));
    }

    public String createFgPartyEntityType(FgPartyEntityType entity) {
        return jdbi.withExtension(FgPartyEntityTypeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyEntityType(FgPartyEntityType entity) {
        return jdbi.withExtension(FgPartyEntityTypeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyEntityType(String id) {
        jdbi.useExtension(FgPartyEntityTypeDao.class, dao -> dao.delete(id));
    }
}
