package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPermissionDao;
import com.bsit.codegeneration.record.FgPermission;

public class FgPermissionRepository {

    private final Jdbi jdbi;

    public FgPermissionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPermission> getAllFgPermissions() {
        return jdbi.withExtension(FgPermissionDao.class, fgpermissiondao -> fgpermissiondao.findAll());
    }

    public Optional<FgPermission> getFgPermissionById(Long id) {
        return jdbi.withExtension(FgPermissionDao.class, dao -> dao.findById(id));
    }

    public Long createFgPermission(FgPermission entity) {
        return jdbi.withExtension(FgPermissionDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPermission(FgPermission entity) {
        return jdbi.withExtension(FgPermissionDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPermission(Long id) {
        jdbi.useExtension(FgPermissionDao.class, dao -> dao.delete(id));
    }
}
