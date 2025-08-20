package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgApplicationPropertiesDemoDao;
import com.bsit.codegeneration.record.FgApplicationPropertiesDemo;

public class FgApplicationPropertiesDemoRepository {

    private final Jdbi jdbi;

    public FgApplicationPropertiesDemoRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgApplicationPropertiesDemo> getAllFgApplicationPropertiesDemos() {
        return jdbi.withExtension(FgApplicationPropertiesDemoDao.class, fgapplicationpropertiesdemodao -> fgapplicationpropertiesdemodao.findAll());
    }

    public Optional<FgApplicationPropertiesDemo> getFgApplicationPropertiesDemoById(String id) {
        return jdbi.withExtension(FgApplicationPropertiesDemoDao.class, dao -> dao.findById(id));
    }

    public String createFgApplicationPropertiesDemo(FgApplicationPropertiesDemo entity) {
        return jdbi.withExtension(FgApplicationPropertiesDemoDao.class, dao -> dao.insert(entity));
    }

    public int updateFgApplicationPropertiesDemo(FgApplicationPropertiesDemo entity) {
        return jdbi.withExtension(FgApplicationPropertiesDemoDao.class, dao -> dao.update(entity));
    }

    public void deleteFgApplicationPropertiesDemo(String id) {
        jdbi.useExtension(FgApplicationPropertiesDemoDao.class, dao -> dao.delete(id));
    }
}
