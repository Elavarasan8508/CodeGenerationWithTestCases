package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdBillIrmDao;
import com.bsit.codegeneration.record.FgTrdBillIrm;

public class FgTrdBillIrmRepository {

    private final Jdbi jdbi;

    public FgTrdBillIrmRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdBillIrm> getAllFgTrdBillIrms() {
        return jdbi.withExtension(FgTrdBillIrmDao.class, fgtrdbillirmdao -> fgtrdbillirmdao.findAll());
    }

    public Optional<FgTrdBillIrm> getFgTrdBillIrmById(String id) {
        return jdbi.withExtension(FgTrdBillIrmDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdBillIrm(FgTrdBillIrm entity) {
        return jdbi.withExtension(FgTrdBillIrmDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdBillIrm(FgTrdBillIrm entity) {
        return jdbi.withExtension(FgTrdBillIrmDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdBillIrm(String id) {
        jdbi.useExtension(FgTrdBillIrmDao.class, dao -> dao.delete(id));
    }
}
