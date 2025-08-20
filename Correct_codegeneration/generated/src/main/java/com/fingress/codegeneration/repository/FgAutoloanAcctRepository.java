package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAutoloanAcctDao;
import com.bsit.codegeneration.record.FgAutoloanAcct;

public class FgAutoloanAcctRepository {

    private final Jdbi jdbi;

    public FgAutoloanAcctRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAutoloanAcct> getAllFgAutoloanAccts() {
        return jdbi.withExtension(FgAutoloanAcctDao.class, fgautoloanacctdao -> fgautoloanacctdao.findAll());
    }

    public Optional<FgAutoloanAcct> getFgAutoloanAcctById(String id) {
        return jdbi.withExtension(FgAutoloanAcctDao.class, dao -> dao.findById(id));
    }

    public String createFgAutoloanAcct(FgAutoloanAcct entity) {
        return jdbi.withExtension(FgAutoloanAcctDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAutoloanAcct(FgAutoloanAcct entity) {
        return jdbi.withExtension(FgAutoloanAcctDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAutoloanAcct(String id) {
        jdbi.useExtension(FgAutoloanAcctDao.class, dao -> dao.delete(id));
    }
}
