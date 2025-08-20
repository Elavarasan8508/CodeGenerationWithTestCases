package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdBillSbDao;
import com.bsit.codegeneration.record.FgTrdBillSb;

public class FgTrdBillSbRepository {

    private final Jdbi jdbi;

    public FgTrdBillSbRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdBillSb> getAllFgTrdBillSbs() {
        return jdbi.withExtension(FgTrdBillSbDao.class, fgtrdbillsbdao -> fgtrdbillsbdao.findAll());
    }

    public Optional<FgTrdBillSb> getFgTrdBillSbById(Long id) {
        return jdbi.withExtension(FgTrdBillSbDao.class, dao -> dao.findById(id));
    }

    public Long createFgTrdBillSb(FgTrdBillSb entity) {
        return jdbi.withExtension(FgTrdBillSbDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdBillSb(FgTrdBillSb entity) {
        return jdbi.withExtension(FgTrdBillSbDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdBillSb(Long id) {
        jdbi.useExtension(FgTrdBillSbDao.class, dao -> dao.delete(id));
    }
}
