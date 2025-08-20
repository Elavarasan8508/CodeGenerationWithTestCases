package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgCounterpartyDao;
import com.bsit.codegeneration.record.FgCounterparty;

public class FgCounterpartyRepository {

    private final Jdbi jdbi;

    public FgCounterpartyRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgCounterparty> getAllFgCounterpartys() {
        return jdbi.withExtension(FgCounterpartyDao.class, fgcounterpartydao -> fgcounterpartydao.findAll());
    }

    public Optional<FgCounterparty> getFgCounterpartyById(String id) {
        return jdbi.withExtension(FgCounterpartyDao.class, dao -> dao.findById(id));
    }

    public String createFgCounterparty(FgCounterparty entity) {
        return jdbi.withExtension(FgCounterpartyDao.class, dao -> dao.insert(entity));
    }

    public int updateFgCounterparty(FgCounterparty entity) {
        return jdbi.withExtension(FgCounterpartyDao.class, dao -> dao.update(entity));
    }

    public void deleteFgCounterparty(String id) {
        jdbi.useExtension(FgCounterpartyDao.class, dao -> dao.delete(id));
    }
}
