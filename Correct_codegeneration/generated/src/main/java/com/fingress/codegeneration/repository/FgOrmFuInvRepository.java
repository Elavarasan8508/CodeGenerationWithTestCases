package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgOrmFuInvDao;
import com.bsit.codegeneration.record.FgOrmFuInv;

public class FgOrmFuInvRepository {

    private final Jdbi jdbi;

    public FgOrmFuInvRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgOrmFuInv> getAllFgOrmFuInvs() {
        return jdbi.withExtension(FgOrmFuInvDao.class, fgormfuinvdao -> fgormfuinvdao.findAll());
    }

    public Optional<FgOrmFuInv> getFgOrmFuInvById(String id) {
        return jdbi.withExtension(FgOrmFuInvDao.class, dao -> dao.findById(id));
    }

    public String createFgOrmFuInv(FgOrmFuInv entity) {
        return jdbi.withExtension(FgOrmFuInvDao.class, dao -> dao.insert(entity));
    }

    public int updateFgOrmFuInv(FgOrmFuInv entity) {
        return jdbi.withExtension(FgOrmFuInvDao.class, dao -> dao.update(entity));
    }

    public void deleteFgOrmFuInv(String id) {
        jdbi.useExtension(FgOrmFuInvDao.class, dao -> dao.delete(id));
    }
}
