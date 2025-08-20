package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActIDMembershipDao;
import com.bsit.codegeneration.record.FgActIDMembership;

public class FgActIDMembershipRepository {

    private final Jdbi jdbi;

    public FgActIDMembershipRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActIDMembership> getAllFgActIDMemberships() {
        return jdbi.withExtension(FgActIDMembershipDao.class, fgactidmembershipdao -> fgactidmembershipdao.findAll());
    }

    public Optional<FgActIDMembership> getFgActIDMembershipById(String id) {
        return jdbi.withExtension(FgActIDMembershipDao.class, dao -> dao.findById(id));
    }

    public String createFgActIDMembership(FgActIDMembership entity) {
        return jdbi.withExtension(FgActIDMembershipDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActIDMembership(FgActIDMembership entity) {
        return jdbi.withExtension(FgActIDMembershipDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActIDMembership(String id) {
        jdbi.useExtension(FgActIDMembershipDao.class, dao -> dao.delete(id));
    }
}
