package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.DateDimensionDao;
import com.bsit.codegeneration.record.DateDimension;

public class DateDimensionRepository {

    private final Jdbi jdbi;

    public DateDimensionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<DateDimension> getAllDateDimensions() {
        return jdbi.withExtension(DateDimensionDao.class, datedimensiondao -> datedimensiondao.findAll());
    }

    public Optional<DateDimension> getDateDimensionById(Long id) {
        return jdbi.withExtension(DateDimensionDao.class, dao -> dao.findById(id));
    }

    public Long createDateDimension(DateDimension entity) {
        return jdbi.withExtension(DateDimensionDao.class, dao -> dao.insert(entity));
    }

    public int updateDateDimension(DateDimension entity) {
        return jdbi.withExtension(DateDimensionDao.class, dao -> dao.update(entity));
    }

    public void deleteDateDimension(Long id) {
        jdbi.useExtension(DateDimensionDao.class, dao -> dao.delete(id));
    }
}
