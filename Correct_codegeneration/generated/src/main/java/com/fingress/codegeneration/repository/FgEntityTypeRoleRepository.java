package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgEntityTypeRoleDao;
import com.bsit.codegeneration.record.FgEntityTypeRole;

public class FgEntityTypeRoleRepository {

    private final Jdbi jdbi;

    public FgEntityTypeRoleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgEntityTypeRole> getAllFgEntityTypeRoles() {
        return jdbi.withExtension(FgEntityTypeRoleDao.class, fgentitytyperoledao -> fgentitytyperoledao.findAll());
    }

    public Optional<FgEntityTypeRole> getFgEntityTypeRoleById(String id) {
        return jdbi.withExtension(FgEntityTypeRoleDao.class, dao -> dao.findById(id));
    }

    public String createFgEntityTypeRole(FgEntityTypeRole entity) {
        return jdbi.withExtension(FgEntityTypeRoleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgEntityTypeRole(FgEntityTypeRole entity) {
        return jdbi.withExtension(FgEntityTypeRoleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgEntityTypeRole(String id) {
        jdbi.useExtension(FgEntityTypeRoleDao.class, dao -> dao.delete(id));
    }
}
