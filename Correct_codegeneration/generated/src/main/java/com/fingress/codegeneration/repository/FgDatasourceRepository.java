package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDatasourceDao;
import com.bsit.codegeneration.record.FgDatasource;

public class FgDatasourceRepository {

    private final Jdbi jdbi;

    public FgDatasourceRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDatasource> getAllFgDatasources() {
        return jdbi.withExtension(FgDatasourceDao.class, fgdatasourcedao -> fgdatasourcedao.findAll());
    }

    public Optional<FgDatasource> getFgDatasourceById(String id) {
        return jdbi.withExtension(FgDatasourceDao.class, dao -> dao.findById(id));
    }

    public String createFgDatasource(FgDatasource entity) {
        return jdbi.withExtension(FgDatasourceDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDatasource(FgDatasource entity) {
        return jdbi.withExtension(FgDatasourceDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDatasource(String id) {
        jdbi.useExtension(FgDatasourceDao.class, dao -> dao.delete(id));
    }
}
