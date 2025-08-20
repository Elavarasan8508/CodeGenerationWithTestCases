package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgMbiEfircDao;
import com.bsit.codegeneration.record.FgMbiEfirc;

public class FgMbiEfircRepository {

    private final Jdbi jdbi;

    public FgMbiEfircRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgMbiEfirc> getAllFgMbiEfircs() {
        return jdbi.withExtension(FgMbiEfircDao.class, fgmbiefircdao -> fgmbiefircdao.findAll());
    }

    public Optional<FgMbiEfirc> getFgMbiEfircById(String id) {
        return jdbi.withExtension(FgMbiEfircDao.class, dao -> dao.findById(id));
    }

    public String createFgMbiEfirc(FgMbiEfirc entity) {
        return jdbi.withExtension(FgMbiEfircDao.class, dao -> dao.insert(entity));
    }

    public int updateFgMbiEfirc(FgMbiEfirc entity) {
        return jdbi.withExtension(FgMbiEfircDao.class, dao -> dao.update(entity));
    }

    public void deleteFgMbiEfirc(String id) {
        jdbi.useExtension(FgMbiEfircDao.class, dao -> dao.delete(id));
    }
}
