package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkDataSetDao;
import com.bsit.codegeneration.record.FgSdkDataSet;

public class FgSdkDataSetRepository {

    private final Jdbi jdbi;

    public FgSdkDataSetRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkDataSet> getAllFgSdkDataSets() {
        return jdbi.withExtension(FgSdkDataSetDao.class, fgsdkdatasetdao -> fgsdkdatasetdao.findAll());
    }

    public Optional<FgSdkDataSet> getFgSdkDataSetById(String id) {
        return jdbi.withExtension(FgSdkDataSetDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkDataSet(FgSdkDataSet entity) {
        return jdbi.withExtension(FgSdkDataSetDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkDataSet(FgSdkDataSet entity) {
        return jdbi.withExtension(FgSdkDataSetDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkDataSet(String id) {
        jdbi.useExtension(FgSdkDataSetDao.class, dao -> dao.delete(id));
    }
}
