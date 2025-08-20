package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgMbiPortcodeDao;
import com.bsit.codegeneration.record.FgMbiPortcode;

public class FgMbiPortcodeRepository {

    private final Jdbi jdbi;

    public FgMbiPortcodeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgMbiPortcode> getAllFgMbiPortcodes() {
        return jdbi.withExtension(FgMbiPortcodeDao.class, fgmbiportcodedao -> fgmbiportcodedao.findAll());
    }

    public Optional<FgMbiPortcode> getFgMbiPortcodeById(String id) {
        return jdbi.withExtension(FgMbiPortcodeDao.class, dao -> dao.findById(id));
    }

    public String createFgMbiPortcode(FgMbiPortcode entity) {
        return jdbi.withExtension(FgMbiPortcodeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgMbiPortcode(FgMbiPortcode entity) {
        return jdbi.withExtension(FgMbiPortcodeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgMbiPortcode(String id) {
        jdbi.useExtension(FgMbiPortcodeDao.class, dao -> dao.delete(id));
    }
}
