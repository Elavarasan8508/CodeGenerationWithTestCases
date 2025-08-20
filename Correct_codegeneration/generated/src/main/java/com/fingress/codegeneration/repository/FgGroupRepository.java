package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgGroupDao;
import com.bsit.codegeneration.record.FgGroup;

public class FgGroupRepository {

    private final Jdbi jdbi;

    public FgGroupRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgGroup> getAllFgGroups() {
        return jdbi.withExtension(FgGroupDao.class, fggroupdao -> fggroupdao.findAll());
    }

    public Optional<FgGroup> getFgGroupById(String id) {
        return jdbi.withExtension(FgGroupDao.class, dao -> dao.findById(id));
    }

    public String createFgGroup(FgGroup entity) {
        return jdbi.withExtension(FgGroupDao.class, dao -> dao.insert(entity));
    }

    public int updateFgGroup(FgGroup entity) {
        return jdbi.withExtension(FgGroupDao.class, dao -> dao.update(entity));
    }

    public void deleteFgGroup(String id) {
        jdbi.useExtension(FgGroupDao.class, dao -> dao.delete(id));
    }
}
