package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgRuleProfilesDao;
import com.bsit.codegeneration.record.FgRuleProfiles;

public class FgRuleProfilesRepository {

    private final Jdbi jdbi;

    public FgRuleProfilesRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgRuleProfiles> getAllFgRuleProfiless() {
        return jdbi.withExtension(FgRuleProfilesDao.class, fgruleprofilesdao -> fgruleprofilesdao.findAll());
    }

    public Optional<FgRuleProfiles> getFgRuleProfilesById(String id) {
        return jdbi.withExtension(FgRuleProfilesDao.class, dao -> dao.findById(id));
    }

    public String createFgRuleProfiles(FgRuleProfiles entity) {
        return jdbi.withExtension(FgRuleProfilesDao.class, dao -> dao.insert(entity));
    }

    public int updateFgRuleProfiles(FgRuleProfiles entity) {
        return jdbi.withExtension(FgRuleProfilesDao.class, dao -> dao.update(entity));
    }

    public void deleteFgRuleProfiles(String id) {
        jdbi.useExtension(FgRuleProfilesDao.class, dao -> dao.delete(id));
    }
}
