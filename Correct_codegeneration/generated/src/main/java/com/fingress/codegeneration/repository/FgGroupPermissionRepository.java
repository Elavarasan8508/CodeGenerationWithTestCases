package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgGroupPermissionDao;
import com.bsit.codegeneration.record.FgGroupPermission;

public class FgGroupPermissionRepository {

    private final Jdbi jdbi;

    public FgGroupPermissionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgGroupPermission> getAllFgGroupPermissions() {
        return jdbi.withExtension(FgGroupPermissionDao.class, fggrouppermissiondao -> fggrouppermissiondao.findAll());
    }

    public Optional<FgGroupPermission> getFgGroupPermissionById(Long id) {
        return jdbi.withExtension(FgGroupPermissionDao.class, dao -> dao.findById(id));
    }

    public Long createFgGroupPermission(FgGroupPermission entity) {
        return jdbi.withExtension(FgGroupPermissionDao.class, dao -> dao.insert(entity));
    }

    public int updateFgGroupPermission(FgGroupPermission entity) {
        return jdbi.withExtension(FgGroupPermissionDao.class, dao -> dao.update(entity));
    }

    public void deleteFgGroupPermission(Long id) {
        jdbi.useExtension(FgGroupPermissionDao.class, dao -> dao.delete(id));
    }
}
