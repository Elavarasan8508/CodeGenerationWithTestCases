package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuIdentitylinkDao;
import com.bsit.codegeneration.record.FgActRuIdentitylink;

public class FgActRuIdentitylinkRepository {

    private final Jdbi jdbi;

    public FgActRuIdentitylinkRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuIdentitylink> getAllFgActRuIdentitylinks() {
        return jdbi.withExtension(FgActRuIdentitylinkDao.class, fgactruidentitylinkdao -> fgactruidentitylinkdao.findAll());
    }

    public Optional<FgActRuIdentitylink> getFgActRuIdentitylinkById(String id) {
        return jdbi.withExtension(FgActRuIdentitylinkDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuIdentitylink(FgActRuIdentitylink entity) {
        return jdbi.withExtension(FgActRuIdentitylinkDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuIdentitylink(FgActRuIdentitylink entity) {
        return jdbi.withExtension(FgActRuIdentitylinkDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuIdentitylink(String id) {
        jdbi.useExtension(FgActRuIdentitylinkDao.class, dao -> dao.delete(id));
    }
}
