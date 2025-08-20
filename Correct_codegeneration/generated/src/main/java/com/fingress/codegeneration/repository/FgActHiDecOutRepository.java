package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiDecOutDao;
import com.bsit.codegeneration.record.FgActHiDecOut;

public class FgActHiDecOutRepository {

    private final Jdbi jdbi;

    public FgActHiDecOutRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiDecOut> getAllFgActHiDecOuts() {
        return jdbi.withExtension(FgActHiDecOutDao.class, fgacthidecoutdao -> fgacthidecoutdao.findAll());
    }

    public Optional<FgActHiDecOut> getFgActHiDecOutById(String id) {
        return jdbi.withExtension(FgActHiDecOutDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiDecOut(FgActHiDecOut entity) {
        return jdbi.withExtension(FgActHiDecOutDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiDecOut(FgActHiDecOut entity) {
        return jdbi.withExtension(FgActHiDecOutDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiDecOut(String id) {
        jdbi.useExtension(FgActHiDecOutDao.class, dao -> dao.delete(id));
    }
}
