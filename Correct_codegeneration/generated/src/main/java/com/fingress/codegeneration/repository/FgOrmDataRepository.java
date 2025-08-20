package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgOrmDataDao;
import com.bsit.codegeneration.record.FgOrmData;

public class FgOrmDataRepository {

    private final Jdbi jdbi;

    public FgOrmDataRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgOrmData> getAllFgOrmDatas() {
        return jdbi.withExtension(FgOrmDataDao.class, fgormdatadao -> fgormdatadao.findAll());
    }

    public Optional<FgOrmData> getFgOrmDataById(String id) {
        return jdbi.withExtension(FgOrmDataDao.class, dao -> dao.findById(id));
    }

    public String createFgOrmData(FgOrmData entity) {
        return jdbi.withExtension(FgOrmDataDao.class, dao -> dao.insert(entity));
    }

    public int updateFgOrmData(FgOrmData entity) {
        return jdbi.withExtension(FgOrmDataDao.class, dao -> dao.update(entity));
    }

    public void deleteFgOrmData(String id) {
        jdbi.useExtension(FgOrmDataDao.class, dao -> dao.delete(id));
    }
}
