package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.IntMessageGroupDao;
import com.bsit.codegeneration.record.IntMessageGroup;

public class IntMessageGroupRepository {

    private final Jdbi jdbi;

    public IntMessageGroupRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<IntMessageGroup> getAllIntMessageGroups() {
        return jdbi.withExtension(IntMessageGroupDao.class, intmessagegroupdao -> intmessagegroupdao.findAll());
    }

    public Optional<IntMessageGroup> getIntMessageGroupById(String id) {
        return jdbi.withExtension(IntMessageGroupDao.class, dao -> dao.findById(id));
    }

    public String createIntMessageGroup(IntMessageGroup entity) {
        return jdbi.withExtension(IntMessageGroupDao.class, dao -> dao.insert(entity));
    }

    public int updateIntMessageGroup(IntMessageGroup entity) {
        return jdbi.withExtension(IntMessageGroupDao.class, dao -> dao.update(entity));
    }

    public void deleteIntMessageGroup(String id) {
        jdbi.useExtension(IntMessageGroupDao.class, dao -> dao.delete(id));
    }
}
