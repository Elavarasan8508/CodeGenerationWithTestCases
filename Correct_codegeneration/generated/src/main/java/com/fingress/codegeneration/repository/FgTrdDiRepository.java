package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdDiDao;
import com.bsit.codegeneration.record.FgTrdDi;

public class FgTrdDiRepository {

    private final Jdbi jdbi;

    public FgTrdDiRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdDi> getAllFgTrdDis() {
        return jdbi.withExtension(FgTrdDiDao.class, fgtrddidao -> fgtrddidao.findAll());
    }

    public Optional<FgTrdDi> getFgTrdDiById(String id) {
        return jdbi.withExtension(FgTrdDiDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdDi(FgTrdDi entity) {
        return jdbi.withExtension(FgTrdDiDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdDi(FgTrdDi entity) {
        return jdbi.withExtension(FgTrdDiDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdDi(String id) {
        jdbi.useExtension(FgTrdDiDao.class, dao -> dao.delete(id));
    }
}
