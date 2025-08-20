package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActIDUserDao;
import com.bsit.codegeneration.record.FgActIDUser;

public class FgActIDUserRepository {

    private final Jdbi jdbi;

    public FgActIDUserRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActIDUser> getAllFgActIDUsers() {
        return jdbi.withExtension(FgActIDUserDao.class, fgactiduserdao -> fgactiduserdao.findAll());
    }

    public Optional<FgActIDUser> getFgActIDUserById(Long id) {
        return jdbi.withExtension(FgActIDUserDao.class, dao -> dao.findById(id));
    }

    public Long createFgActIDUser(FgActIDUser entity) {
        return jdbi.withExtension(FgActIDUserDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActIDUser(FgActIDUser entity) {
        return jdbi.withExtension(FgActIDUserDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActIDUser(Long id) {
        jdbi.useExtension(FgActIDUserDao.class, dao -> dao.delete(id));
    }
}
