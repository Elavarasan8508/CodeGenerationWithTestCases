package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProductEntityLockDao;
import com.bsit.codegeneration.record.FgProductEntityLock;

public class FgProductEntityLockRepository {

    private final Jdbi jdbi;

    public FgProductEntityLockRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProductEntityLock> getAllFgProductEntityLocks() {
        return jdbi.withExtension(FgProductEntityLockDao.class, fgproductentitylockdao -> fgproductentitylockdao.findAll());
    }

    public Optional<FgProductEntityLock> getFgProductEntityLockById(Long id) {
        return jdbi.withExtension(FgProductEntityLockDao.class, dao -> dao.findById(id));
    }

    public Long createFgProductEntityLock(FgProductEntityLock entity) {
        return jdbi.withExtension(FgProductEntityLockDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProductEntityLock(FgProductEntityLock entity) {
        return jdbi.withExtension(FgProductEntityLockDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProductEntityLock(Long id) {
        jdbi.useExtension(FgProductEntityLockDao.class, dao -> dao.delete(id));
    }
}
