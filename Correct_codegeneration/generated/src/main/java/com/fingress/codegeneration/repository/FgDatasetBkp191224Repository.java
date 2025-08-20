package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDatasetBkp191224Dao;
import com.bsit.codegeneration.record.FgDatasetBkp191224;

public class FgDatasetBkp191224Repository {

    private final Jdbi jdbi;

    public FgDatasetBkp191224Repository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDatasetBkp191224> getAllFgDatasetBkp191224s() {
        return jdbi.withExtension(FgDatasetBkp191224Dao.class, fgdatasetbkp191224dao -> fgdatasetbkp191224dao.findAll());
    }

    public Optional<FgDatasetBkp191224> getFgDatasetBkp191224ById(String id) {
        return jdbi.withExtension(FgDatasetBkp191224Dao.class, dao -> dao.findById(id));
    }

    public String createFgDatasetBkp191224(FgDatasetBkp191224 entity) {
        return jdbi.withExtension(FgDatasetBkp191224Dao.class, dao -> dao.insert(entity));
    }

    public int updateFgDatasetBkp191224(FgDatasetBkp191224 entity) {
        return jdbi.withExtension(FgDatasetBkp191224Dao.class, dao -> dao.update(entity));
    }

    public void deleteFgDatasetBkp191224(String id) {
        jdbi.useExtension(FgDatasetBkp191224Dao.class, dao -> dao.delete(id));
    }
}
