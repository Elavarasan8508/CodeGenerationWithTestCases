package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActIDGroupDao;
import com.bsit.codegeneration.record.FgActIDGroup;

public class FgActIDGroupRepository {

    private final Jdbi jdbi;

    public FgActIDGroupRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActIDGroup> getAllFgActIDGroups() {
        return jdbi.withExtension(FgActIDGroupDao.class, fgactidgroupdao -> fgactidgroupdao.findAll());
    }

    public Optional<FgActIDGroup> getFgActIDGroupById(String id) {
        return jdbi.withExtension(FgActIDGroupDao.class, dao -> dao.findById(id));
    }

    public String createFgActIDGroup(FgActIDGroup entity) {
        return jdbi.withExtension(FgActIDGroupDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActIDGroup(FgActIDGroup entity) {
        return jdbi.withExtension(FgActIDGroupDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActIDGroup(String id) {
        jdbi.useExtension(FgActIDGroupDao.class, dao -> dao.delete(id));
    }
}
