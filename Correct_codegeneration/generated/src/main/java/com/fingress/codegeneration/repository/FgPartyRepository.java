package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyDao;
import com.bsit.codegeneration.record.FgParty;

public class FgPartyRepository {

    private final Jdbi jdbi;

    public FgPartyRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgParty> getAllFgPartys() {
        return jdbi.withExtension(FgPartyDao.class, fgpartydao -> fgpartydao.findAll());
    }

    public Optional<FgParty> getFgPartyById(String id) {
        return jdbi.withExtension(FgPartyDao.class, dao -> dao.findById(id));
    }

    public String createFgParty(FgParty entity) {
        return jdbi.withExtension(FgPartyDao.class, dao -> dao.insert(entity));
    }

    public int updateFgParty(FgParty entity) {
        return jdbi.withExtension(FgPartyDao.class, dao -> dao.update(entity));
    }

    public void deleteFgParty(String id) {
        jdbi.useExtension(FgPartyDao.class, dao -> dao.delete(id));
    }
}
