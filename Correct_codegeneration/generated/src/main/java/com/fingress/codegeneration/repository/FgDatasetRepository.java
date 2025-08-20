package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDatasetDao;
import com.bsit.codegeneration.record.FgDataset;

public class FgDatasetRepository {

    private final Jdbi jdbi;

    public FgDatasetRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDataset> getAllFgDatasets() {
        return jdbi.withExtension(FgDatasetDao.class, fgdatasetdao -> fgdatasetdao.findAll());
    }

    public Optional<FgDataset> getFgDatasetById(String id) {
        return jdbi.withExtension(FgDatasetDao.class, dao -> dao.findById(id));
    }

    public String createFgDataset(FgDataset entity) {
        return jdbi.withExtension(FgDatasetDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDataset(FgDataset entity) {
        return jdbi.withExtension(FgDatasetDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDataset(String id) {
        jdbi.useExtension(FgDatasetDao.class, dao -> dao.delete(id));
    }
}
