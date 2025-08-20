package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiIdentitylinkDao;
import com.bsit.codegeneration.record.FgActHiIdentitylink;

public class FgActHiIdentitylinkRepository {

    private final Jdbi jdbi;

    public FgActHiIdentitylinkRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiIdentitylink> getAllFgActHiIdentitylinks() {
        return jdbi.withExtension(FgActHiIdentitylinkDao.class, fgacthiidentitylinkdao -> fgacthiidentitylinkdao.findAll());
    }

    public Optional<FgActHiIdentitylink> getFgActHiIdentitylinkById(String id) {
        return jdbi.withExtension(FgActHiIdentitylinkDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiIdentitylink(FgActHiIdentitylink entity) {
        return jdbi.withExtension(FgActHiIdentitylinkDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiIdentitylink(FgActHiIdentitylink entity) {
        return jdbi.withExtension(FgActHiIdentitylinkDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiIdentitylink(String id) {
        jdbi.useExtension(FgActHiIdentitylinkDao.class, dao -> dao.delete(id));
    }
}
