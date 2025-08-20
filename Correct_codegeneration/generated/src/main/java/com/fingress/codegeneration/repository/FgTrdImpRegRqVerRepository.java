package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdImpRegRqVerDao;
import com.bsit.codegeneration.record.FgTrdImpRegRqVer;

public class FgTrdImpRegRqVerRepository {

    private final Jdbi jdbi;

    public FgTrdImpRegRqVerRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdImpRegRqVer> getAllFgTrdImpRegRqVers() {
        return jdbi.withExtension(FgTrdImpRegRqVerDao.class, fgtrdimpregrqverdao -> fgtrdimpregrqverdao.findAll());
    }

    public Optional<FgTrdImpRegRqVer> getFgTrdImpRegRqVerById(Long id) {
        return jdbi.withExtension(FgTrdImpRegRqVerDao.class, dao -> dao.findById(id));
    }

    public Long createFgTrdImpRegRqVer(FgTrdImpRegRqVer entity) {
        return jdbi.withExtension(FgTrdImpRegRqVerDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdImpRegRqVer(FgTrdImpRegRqVer entity) {
        return jdbi.withExtension(FgTrdImpRegRqVerDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdImpRegRqVer(Long id) {
        jdbi.useExtension(FgTrdImpRegRqVerDao.class, dao -> dao.delete(id));
    }
}
