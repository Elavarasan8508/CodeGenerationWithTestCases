package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActIDTenantDao;
import com.bsit.codegeneration.record.FgActIDTenant;

public class FgActIDTenantRepository {

    private final Jdbi jdbi;

    public FgActIDTenantRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActIDTenant> getAllFgActIDTenants() {
        return jdbi.withExtension(FgActIDTenantDao.class, fgactidtenantdao -> fgactidtenantdao.findAll());
    }

    public Optional<FgActIDTenant> getFgActIDTenantById(String id) {
        return jdbi.withExtension(FgActIDTenantDao.class, dao -> dao.findById(id));
    }

    public String createFgActIDTenant(FgActIDTenant entity) {
        return jdbi.withExtension(FgActIDTenantDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActIDTenant(FgActIDTenant entity) {
        return jdbi.withExtension(FgActIDTenantDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActIDTenant(String id) {
        jdbi.useExtension(FgActIDTenantDao.class, dao -> dao.delete(id));
    }
}
