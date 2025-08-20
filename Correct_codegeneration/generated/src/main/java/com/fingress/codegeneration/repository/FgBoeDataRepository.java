package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgBoeDataDao;
import com.bsit.codegeneration.record.FgBoeData;

public class FgBoeDataRepository {

    private final Jdbi jdbi;

    public FgBoeDataRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgBoeData> getAllFgBoeDatas() {
        return jdbi.withExtension(FgBoeDataDao.class, fgboedatadao -> fgboedatadao.findAll());
    }

    public Optional<FgBoeData> getFgBoeDataById(Long id) {
        return jdbi.withExtension(FgBoeDataDao.class, dao -> dao.findById(id));
    }

    public Long createFgBoeData(FgBoeData entity) {
        return jdbi.withExtension(FgBoeDataDao.class, dao -> dao.insert(entity));
    }

    public int updateFgBoeData(FgBoeData entity) {
        return jdbi.withExtension(FgBoeDataDao.class, dao -> dao.update(entity));
    }

    public void deleteFgBoeData(Long id) {
        jdbi.useExtension(FgBoeDataDao.class, dao -> dao.delete(id));
    }
}
