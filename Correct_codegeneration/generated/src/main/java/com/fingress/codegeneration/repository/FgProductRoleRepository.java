package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProductRoleDao;
import com.bsit.codegeneration.record.FgProductRole;

public class FgProductRoleRepository {

    private final Jdbi jdbi;

    public FgProductRoleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProductRole> getAllFgProductRoles() {
        return jdbi.withExtension(FgProductRoleDao.class, fgproductroledao -> fgproductroledao.findAll());
    }

    public Optional<FgProductRole> getFgProductRoleById(String id) {
        return jdbi.withExtension(FgProductRoleDao.class, dao -> dao.findById(id));
    }

    public String createFgProductRole(FgProductRole entity) {
        return jdbi.withExtension(FgProductRoleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProductRole(FgProductRole entity) {
        return jdbi.withExtension(FgProductRoleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProductRole(String id) {
        jdbi.useExtension(FgProductRoleDao.class, dao -> dao.delete(id));
    }
}
