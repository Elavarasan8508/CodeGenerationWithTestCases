package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModTagRelDao;
import com.bsit.codegeneration.record.FgModTagRel;

public class FgModTagRelRepository {

    private final Jdbi jdbi;

    public FgModTagRelRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModTagRel> getAllFgModTagRels() {
        return jdbi.withExtension(FgModTagRelDao.class, fgmodtagreldao -> fgmodtagreldao.findAll());
    }

    public Optional<FgModTagRel> getFgModTagRelById(String id) {
        return jdbi.withExtension(FgModTagRelDao.class, dao -> dao.findById(id));
    }

    public String createFgModTagRel(FgModTagRel entity) {
        return jdbi.withExtension(FgModTagRelDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModTagRel(FgModTagRel entity) {
        return jdbi.withExtension(FgModTagRelDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModTagRel(String id) {
        jdbi.useExtension(FgModTagRelDao.class, dao -> dao.delete(id));
    }
}
