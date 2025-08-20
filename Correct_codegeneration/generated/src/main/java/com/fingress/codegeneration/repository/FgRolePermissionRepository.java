package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgRolePermissionDao;
import com.bsit.codegeneration.record.FgRolePermission;

public class FgRolePermissionRepository {

    private final Jdbi jdbi;

    public FgRolePermissionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgRolePermission> getAllFgRolePermissions() {
        return jdbi.withExtension(FgRolePermissionDao.class, fgrolepermissiondao -> fgrolepermissiondao.findAll());
    }

    public Optional<FgRolePermission> getFgRolePermissionById(Long id) {
        return jdbi.withExtension(FgRolePermissionDao.class, dao -> dao.findById(id));
    }

    public Long createFgRolePermission(FgRolePermission entity) {
        return jdbi.withExtension(FgRolePermissionDao.class, dao -> dao.insert(entity));
    }

    public int updateFgRolePermission(FgRolePermission entity) {
        return jdbi.withExtension(FgRolePermissionDao.class, dao -> dao.update(entity));
    }

    public void deleteFgRolePermission(Long id) {
        jdbi.useExtension(FgRolePermissionDao.class, dao -> dao.delete(id));
    }
}
