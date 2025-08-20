package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActGePropertyDao;
import com.bsit.codegeneration.record.FgActGeProperty;

public class FgActGePropertyRepository {

    private final Jdbi jdbi;

    public FgActGePropertyRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActGeProperty> getAllFgActGePropertys() {
        return jdbi.withExtension(FgActGePropertyDao.class, fgactgepropertydao -> fgactgepropertydao.findAll());
    }

    public Optional<FgActGeProperty> getFgActGePropertyById(Long id) {
        return jdbi.withExtension(FgActGePropertyDao.class, dao -> dao.findById(id));
    }

    public Long createFgActGeProperty(FgActGeProperty entity) {
        return jdbi.withExtension(FgActGePropertyDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActGeProperty(FgActGeProperty entity) {
        return jdbi.withExtension(FgActGePropertyDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActGeProperty(Long id) {
        jdbi.useExtension(FgActGePropertyDao.class, dao -> dao.delete(id));
    }
}
