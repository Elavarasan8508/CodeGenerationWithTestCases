package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgRoleDao;
import com.bsit.codegeneration.record.FgRole;

public class FgRoleRepository {

    private final Jdbi jdbi;

    public FgRoleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgRole> getAllFgRoles() {
        return jdbi.withExtension(FgRoleDao.class, fgroledao -> fgroledao.findAll());
    }

    public Optional<FgRole> getFgRoleById(String id) {
        return jdbi.withExtension(FgRoleDao.class, dao -> dao.findById(id));
    }

    public String createFgRole(FgRole entity) {
        return jdbi.withExtension(FgRoleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgRole(FgRole entity) {
        return jdbi.withExtension(FgRoleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgRole(String id) {
        jdbi.useExtension(FgRoleDao.class, dao -> dao.delete(id));
    }
}
