package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyGroupDao;
import com.bsit.codegeneration.record.FgPartyGroup;

public class FgPartyGroupRepository {

    private final Jdbi jdbi;

    public FgPartyGroupRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyGroup> getAllFgPartyGroups() {
        return jdbi.withExtension(FgPartyGroupDao.class, fgpartygroupdao -> fgpartygroupdao.findAll());
    }

    public Optional<FgPartyGroup> getFgPartyGroupById(String id) {
        return jdbi.withExtension(FgPartyGroupDao.class, dao -> dao.findById(id));
    }

    public String createFgPartyGroup(FgPartyGroup entity) {
        return jdbi.withExtension(FgPartyGroupDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyGroup(FgPartyGroup entity) {
        return jdbi.withExtension(FgPartyGroupDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyGroup(String id) {
        jdbi.useExtension(FgPartyGroupDao.class, dao -> dao.delete(id));
    }
}
