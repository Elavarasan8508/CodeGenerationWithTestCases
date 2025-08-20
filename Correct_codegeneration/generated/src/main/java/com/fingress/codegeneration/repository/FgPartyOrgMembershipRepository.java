package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyOrgMembershipDao;
import com.bsit.codegeneration.record.FgPartyOrgMembership;

public class FgPartyOrgMembershipRepository {

    private final Jdbi jdbi;

    public FgPartyOrgMembershipRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyOrgMembership> getAllFgPartyOrgMemberships() {
        return jdbi.withExtension(FgPartyOrgMembershipDao.class, fgpartyorgmembershipdao -> fgpartyorgmembershipdao.findAll());
    }

    public Optional<FgPartyOrgMembership> getFgPartyOrgMembershipById(String id) {
        return jdbi.withExtension(FgPartyOrgMembershipDao.class, dao -> dao.findById(id));
    }

    public String createFgPartyOrgMembership(FgPartyOrgMembership entity) {
        return jdbi.withExtension(FgPartyOrgMembershipDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyOrgMembership(FgPartyOrgMembership entity) {
        return jdbi.withExtension(FgPartyOrgMembershipDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyOrgMembership(String id) {
        jdbi.useExtension(FgPartyOrgMembershipDao.class, dao -> dao.delete(id));
    }
}
