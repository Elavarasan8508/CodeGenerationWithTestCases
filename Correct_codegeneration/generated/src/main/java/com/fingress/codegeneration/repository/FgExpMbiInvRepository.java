package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgExpMbiInvDao;
import com.bsit.codegeneration.record.FgExpMbiInv;

public class FgExpMbiInvRepository {

    private final Jdbi jdbi;

    public FgExpMbiInvRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgExpMbiInv> getAllFgExpMbiInvs() {
        return jdbi.withExtension(FgExpMbiInvDao.class, fgexpmbiinvdao -> fgexpmbiinvdao.findAll());
    }

    public Optional<FgExpMbiInv> getFgExpMbiInvById(Long id) {
        return jdbi.withExtension(FgExpMbiInvDao.class, dao -> dao.findById(id));
    }

    public Long createFgExpMbiInv(FgExpMbiInv entity) {
        return jdbi.withExtension(FgExpMbiInvDao.class, dao -> dao.insert(entity));
    }

    public int updateFgExpMbiInv(FgExpMbiInv entity) {
        return jdbi.withExtension(FgExpMbiInvDao.class, dao -> dao.update(entity));
    }

    public void deleteFgExpMbiInv(Long id) {
        jdbi.useExtension(FgExpMbiInvDao.class, dao -> dao.delete(id));
    }
}
