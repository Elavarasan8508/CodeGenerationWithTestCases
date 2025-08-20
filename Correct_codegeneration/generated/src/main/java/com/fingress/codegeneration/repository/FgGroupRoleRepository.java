package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgGroupRoleDao;
import com.bsit.codegeneration.record.FgGroupRole;

public class FgGroupRoleRepository {

    private final Jdbi jdbi;

    public FgGroupRoleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgGroupRole> getAllFgGroupRoles() {
        return jdbi.withExtension(FgGroupRoleDao.class, fggrouproledao -> fggrouproledao.findAll());
    }

    public Optional<FgGroupRole> getFgGroupRoleById(Long id) {
        return jdbi.withExtension(FgGroupRoleDao.class, dao -> dao.findById(id));
    }

    public Long createFgGroupRole(FgGroupRole entity) {
        return jdbi.withExtension(FgGroupRoleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgGroupRole(FgGroupRole entity) {
        return jdbi.withExtension(FgGroupRoleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgGroupRole(Long id) {
        jdbi.useExtension(FgGroupRoleDao.class, dao -> dao.delete(id));
    }
}
