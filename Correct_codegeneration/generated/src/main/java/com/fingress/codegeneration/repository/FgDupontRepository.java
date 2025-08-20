package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDupontDao;
import com.bsit.codegeneration.record.FgDupont;

public class FgDupontRepository {

    private final Jdbi jdbi;

    public FgDupontRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDupont> getAllFgDuponts() {
        return jdbi.withExtension(FgDupontDao.class, fgdupontdao -> fgdupontdao.findAll());
    }

    public Optional<FgDupont> getFgDupontById(String id) {
        return jdbi.withExtension(FgDupontDao.class, dao -> dao.findById(id));
    }

    public String createFgDupont(FgDupont entity) {
        return jdbi.withExtension(FgDupontDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDupont(FgDupont entity) {
        return jdbi.withExtension(FgDupontDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDupont(String id) {
        jdbi.useExtension(FgDupontDao.class, dao -> dao.delete(id));
    }
}
