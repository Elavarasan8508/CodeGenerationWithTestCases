package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSiteMembershipDao;
import com.bsit.codegeneration.record.FgSiteMembership;

public class FgSiteMembershipRepository {

    private final Jdbi jdbi;

    public FgSiteMembershipRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSiteMembership> getAllFgSiteMemberships() {
        return jdbi.withExtension(FgSiteMembershipDao.class, fgsitemembershipdao -> fgsitemembershipdao.findAll());
    }

    public Optional<FgSiteMembership> getFgSiteMembershipById(String id) {
        return jdbi.withExtension(FgSiteMembershipDao.class, dao -> dao.findById(id));
    }

    public String createFgSiteMembership(FgSiteMembership entity) {
        return jdbi.withExtension(FgSiteMembershipDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSiteMembership(FgSiteMembership entity) {
        return jdbi.withExtension(FgSiteMembershipDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSiteMembership(String id) {
        jdbi.useExtension(FgSiteMembershipDao.class, dao -> dao.delete(id));
    }
}
