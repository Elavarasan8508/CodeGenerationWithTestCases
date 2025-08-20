package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdBillFircDao;
import com.bsit.codegeneration.record.FgTrdBillFirc;

public class FgTrdBillFircRepository {

    private final Jdbi jdbi;

    public FgTrdBillFircRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdBillFirc> getAllFgTrdBillFircs() {
        return jdbi.withExtension(FgTrdBillFircDao.class, fgtrdbillfircdao -> fgtrdbillfircdao.findAll());
    }

    public Optional<FgTrdBillFirc> getFgTrdBillFircById(String id) {
        return jdbi.withExtension(FgTrdBillFircDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdBillFirc(FgTrdBillFirc entity) {
        return jdbi.withExtension(FgTrdBillFircDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdBillFirc(FgTrdBillFirc entity) {
        return jdbi.withExtension(FgTrdBillFircDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdBillFirc(String id) {
        jdbi.useExtension(FgTrdBillFircDao.class, dao -> dao.delete(id));
    }
}
