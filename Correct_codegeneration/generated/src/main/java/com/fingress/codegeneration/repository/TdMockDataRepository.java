package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.TdMockDataDao;
import com.bsit.codegeneration.record.TdMockData;

public class TdMockDataRepository {

    private final Jdbi jdbi;

    public TdMockDataRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<TdMockData> getAllTdMockDatas() {
        return jdbi.withExtension(TdMockDataDao.class, tdmockdatadao -> tdmockdatadao.findAll());
    }

    public Optional<TdMockData> getTdMockDataById(String id) {
        return jdbi.withExtension(TdMockDataDao.class, dao -> dao.findById(id));
    }

    public String createTdMockData(TdMockData entity) {
        return jdbi.withExtension(TdMockDataDao.class, dao -> dao.insert(entity));
    }

    public int updateTdMockData(TdMockData entity) {
        return jdbi.withExtension(TdMockDataDao.class, dao -> dao.update(entity));
    }

    public void deleteTdMockData(String id) {
        jdbi.useExtension(TdMockDataDao.class, dao -> dao.delete(id));
    }
}
