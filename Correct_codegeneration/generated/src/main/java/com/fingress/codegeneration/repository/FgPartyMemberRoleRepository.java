package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyMemberRoleDao;
import com.bsit.codegeneration.record.FgPartyMemberRole;

public class FgPartyMemberRoleRepository {

    private final Jdbi jdbi;

    public FgPartyMemberRoleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyMemberRole> getAllFgPartyMemberRoles() {
        return jdbi.withExtension(FgPartyMemberRoleDao.class, fgpartymemberroledao -> fgpartymemberroledao.findAll());
    }

    public Optional<FgPartyMemberRole> getFgPartyMemberRoleById(String id) {
        return jdbi.withExtension(FgPartyMemberRoleDao.class, dao -> dao.findById(id));
    }

    public String createFgPartyMemberRole(FgPartyMemberRole entity) {
        return jdbi.withExtension(FgPartyMemberRoleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyMemberRole(FgPartyMemberRole entity) {
        return jdbi.withExtension(FgPartyMemberRoleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyMemberRole(String id) {
        jdbi.useExtension(FgPartyMemberRoleDao.class, dao -> dao.delete(id));
    }
}
