package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LmsMdmProductGroupDao;
import com.bsit.codegeneration.record.LmsMdmProductGroup;

public class LmsMdmProductGroupRepository {

    private final Jdbi jdbi;

    public LmsMdmProductGroupRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LmsMdmProductGroup> getAllLmsMdmProductGroups() {
        return jdbi.withExtension(LmsMdmProductGroupDao.class, lmsmdmproductgroupdao -> lmsmdmproductgroupdao.findAll());
    }

    public Optional<LmsMdmProductGroup> getLmsMdmProductGroupById(String id) {
        return jdbi.withExtension(LmsMdmProductGroupDao.class, dao -> dao.findById(id));
    }

    public String createLmsMdmProductGroup(LmsMdmProductGroup entity) {
        return jdbi.withExtension(LmsMdmProductGroupDao.class, dao -> dao.insert(entity));
    }

    public int updateLmsMdmProductGroup(LmsMdmProductGroup entity) {
        return jdbi.withExtension(LmsMdmProductGroupDao.class, dao -> dao.update(entity));
    }

    public void deleteLmsMdmProductGroup(String id) {
        jdbi.useExtension(LmsMdmProductGroupDao.class, dao -> dao.delete(id));
    }
}
