package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.IntLockDao;
import com.bsit.codegeneration.record.IntLock;

public class IntLockRepository {

    private final Jdbi jdbi;

    public IntLockRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<IntLock> getAllIntLocks() {
        return jdbi.withExtension(IntLockDao.class, intlockdao -> intlockdao.findAll());
    }

    public Optional<IntLock> getIntLockById(String id) {
        return jdbi.withExtension(IntLockDao.class, dao -> dao.findById(id));
    }

    public String createIntLock(IntLock entity) {
        return jdbi.withExtension(IntLockDao.class, dao -> dao.insert(entity));
    }

    public int updateIntLock(IntLock entity) {
        return jdbi.withExtension(IntLockDao.class, dao -> dao.update(entity));
    }

    public void deleteIntLock(String id) {
        jdbi.useExtension(IntLockDao.class, dao -> dao.delete(id));
    }
}
