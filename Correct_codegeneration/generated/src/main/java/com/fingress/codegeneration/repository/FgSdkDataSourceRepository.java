package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkDataSourceDao;
import com.bsit.codegeneration.record.FgSdkDataSource;

public class FgSdkDataSourceRepository {

    private final Jdbi jdbi;

    public FgSdkDataSourceRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkDataSource> getAllFgSdkDataSources() {
        return jdbi.withExtension(FgSdkDataSourceDao.class, fgsdkdatasourcedao -> fgsdkdatasourcedao.findAll());
    }

    public Optional<FgSdkDataSource> getFgSdkDataSourceById(String id) {
        return jdbi.withExtension(FgSdkDataSourceDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkDataSource(FgSdkDataSource entity) {
        return jdbi.withExtension(FgSdkDataSourceDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkDataSource(FgSdkDataSource entity) {
        return jdbi.withExtension(FgSdkDataSourceDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkDataSource(String id) {
        jdbi.useExtension(FgSdkDataSourceDao.class, dao -> dao.delete(id));
    }
}
