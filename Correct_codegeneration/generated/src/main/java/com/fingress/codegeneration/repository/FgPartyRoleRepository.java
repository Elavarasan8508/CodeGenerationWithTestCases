package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyRoleDao;
import com.bsit.codegeneration.record.FgPartyRole;

public class FgPartyRoleRepository {

    private final Jdbi jdbi;

    public FgPartyRoleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyRole> getAllFgPartyRoles() {
        return jdbi.withExtension(FgPartyRoleDao.class, fgpartyroledao -> fgpartyroledao.findAll());
    }

    public Optional<FgPartyRole> getFgPartyRoleById(String id) {
        return jdbi.withExtension(FgPartyRoleDao.class, dao -> dao.findById(id));
    }

    public String createFgPartyRole(FgPartyRole entity) {
        return jdbi.withExtension(FgPartyRoleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyRole(FgPartyRole entity) {
        return jdbi.withExtension(FgPartyRoleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyRole(String id) {
        jdbi.useExtension(FgPartyRoleDao.class, dao -> dao.delete(id));
    }
}
