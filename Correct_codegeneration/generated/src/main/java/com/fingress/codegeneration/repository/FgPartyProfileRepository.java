package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyProfileDao;
import com.bsit.codegeneration.record.FgPartyProfile;

public class FgPartyProfileRepository {

    private final Jdbi jdbi;

    public FgPartyProfileRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyProfile> getAllFgPartyProfiles() {
        return jdbi.withExtension(FgPartyProfileDao.class, fgpartyprofiledao -> fgpartyprofiledao.findAll());
    }

    public Optional<FgPartyProfile> getFgPartyProfileById(Long id) {
        return jdbi.withExtension(FgPartyProfileDao.class, dao -> dao.findById(id));
    }

    public Long createFgPartyProfile(FgPartyProfile entity) {
        return jdbi.withExtension(FgPartyProfileDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyProfile(FgPartyProfile entity) {
        return jdbi.withExtension(FgPartyProfileDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyProfile(Long id) {
        jdbi.useExtension(FgPartyProfileDao.class, dao -> dao.delete(id));
    }
}
