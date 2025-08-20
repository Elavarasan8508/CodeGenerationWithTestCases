package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgUserDao;
import com.bsit.codegeneration.record.FgUser;

public class FgUserRepository {

    private final Jdbi jdbi;

    public FgUserRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgUser> getAllFgUsers() {
        return jdbi.withExtension(FgUserDao.class, fguserdao -> fguserdao.findAll());
    }

    public Optional<FgUser> getFgUserById(String id) {
        return jdbi.withExtension(FgUserDao.class, dao -> dao.findById(id));
    }

    public String createFgUser(FgUser entity) {
        return jdbi.withExtension(FgUserDao.class, dao -> dao.insert(entity));
    }

    public int updateFgUser(FgUser entity) {
        return jdbi.withExtension(FgUserDao.class, dao -> dao.update(entity));
    }

    public void deleteFgUser(String id) {
        jdbi.useExtension(FgUserDao.class, dao -> dao.delete(id));
    }
}
