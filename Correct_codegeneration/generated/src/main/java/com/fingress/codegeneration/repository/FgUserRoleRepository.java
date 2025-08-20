package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgUserRoleDao;
import com.bsit.codegeneration.record.FgUserRole;

public class FgUserRoleRepository {

    private final Jdbi jdbi;

    public FgUserRoleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgUserRole> getAllFgUserRoles() {
        return jdbi.withExtension(FgUserRoleDao.class, fguserroledao -> fguserroledao.findAll());
    }

    public Optional<FgUserRole> getFgUserRoleById(Long id) {
        return jdbi.withExtension(FgUserRoleDao.class, dao -> dao.findById(id));
    }

    public Long createFgUserRole(FgUserRole entity) {
        return jdbi.withExtension(FgUserRoleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgUserRole(FgUserRole entity) {
        return jdbi.withExtension(FgUserRoleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgUserRole(Long id) {
        jdbi.useExtension(FgUserRoleDao.class, dao -> dao.delete(id));
    }
}
