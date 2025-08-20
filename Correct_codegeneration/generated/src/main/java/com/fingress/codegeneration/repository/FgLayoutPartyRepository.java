package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLayoutPartyDao;
import com.bsit.codegeneration.record.FgLayoutParty;

public class FgLayoutPartyRepository {

    private final Jdbi jdbi;

    public FgLayoutPartyRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLayoutParty> getAllFgLayoutPartys() {
        return jdbi.withExtension(FgLayoutPartyDao.class, fglayoutpartydao -> fglayoutpartydao.findAll());
    }

    public Optional<FgLayoutParty> getFgLayoutPartyById(Long id) {
        return jdbi.withExtension(FgLayoutPartyDao.class, dao -> dao.findById(id));
    }

    public Long createFgLayoutParty(FgLayoutParty entity) {
        return jdbi.withExtension(FgLayoutPartyDao.class, dao -> dao.insert(entity));
    }

    public int updateFgLayoutParty(FgLayoutParty entity) {
        return jdbi.withExtension(FgLayoutPartyDao.class, dao -> dao.update(entity));
    }

    public void deleteFgLayoutParty(Long id) {
        jdbi.useExtension(FgLayoutPartyDao.class, dao -> dao.delete(id));
    }
}
