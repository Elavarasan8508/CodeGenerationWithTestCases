package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgEdpmsSbInvDao;
import com.bsit.codegeneration.record.FgEdpmsSbInv;

public class FgEdpmsSbInvRepository {

    private final Jdbi jdbi;

    public FgEdpmsSbInvRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgEdpmsSbInv> getAllFgEdpmsSbInvs() {
        return jdbi.withExtension(FgEdpmsSbInvDao.class, fgedpmssbinvdao -> fgedpmssbinvdao.findAll());
    }

    public Optional<FgEdpmsSbInv> getFgEdpmsSbInvById(Long id) {
        return jdbi.withExtension(FgEdpmsSbInvDao.class, dao -> dao.findById(id));
    }

    public Long createFgEdpmsSbInv(FgEdpmsSbInv entity) {
        return jdbi.withExtension(FgEdpmsSbInvDao.class, dao -> dao.insert(entity));
    }

    public int updateFgEdpmsSbInv(FgEdpmsSbInv entity) {
        return jdbi.withExtension(FgEdpmsSbInvDao.class, dao -> dao.update(entity));
    }

    public void deleteFgEdpmsSbInv(Long id) {
        jdbi.useExtension(FgEdpmsSbInvDao.class, dao -> dao.delete(id));
    }
}
