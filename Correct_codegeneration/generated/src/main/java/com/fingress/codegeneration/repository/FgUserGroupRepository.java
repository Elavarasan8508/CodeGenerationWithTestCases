package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgUserGroupDao;
import com.bsit.codegeneration.record.FgUserGroup;

public class FgUserGroupRepository {

    private final Jdbi jdbi;

    public FgUserGroupRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgUserGroup> getAllFgUserGroups() {
        return jdbi.withExtension(FgUserGroupDao.class, fgusergroupdao -> fgusergroupdao.findAll());
    }

    public Optional<FgUserGroup> getFgUserGroupById(Long id) {
        return jdbi.withExtension(FgUserGroupDao.class, dao -> dao.findById(id));
    }

    public Long createFgUserGroup(FgUserGroup entity) {
        return jdbi.withExtension(FgUserGroupDao.class, dao -> dao.insert(entity));
    }

    public int updateFgUserGroup(FgUserGroup entity) {
        return jdbi.withExtension(FgUserGroupDao.class, dao -> dao.update(entity));
    }

    public void deleteFgUserGroup(Long id) {
        jdbi.useExtension(FgUserGroupDao.class, dao -> dao.delete(id));
    }
}
