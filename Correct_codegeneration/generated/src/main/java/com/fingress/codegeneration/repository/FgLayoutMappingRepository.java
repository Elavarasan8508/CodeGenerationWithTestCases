package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLayoutMappingDao;
import com.bsit.codegeneration.record.FgLayoutMapping;

public class FgLayoutMappingRepository {

    private final Jdbi jdbi;

    public FgLayoutMappingRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLayoutMapping> getAllFgLayoutMappings() {
        return jdbi.withExtension(FgLayoutMappingDao.class, fglayoutmappingdao -> fglayoutmappingdao.findAll());
    }

    public Optional<FgLayoutMapping> getFgLayoutMappingById(String id) {
        return jdbi.withExtension(FgLayoutMappingDao.class, dao -> dao.findById(id));
    }

    public String createFgLayoutMapping(FgLayoutMapping entity) {
        return jdbi.withExtension(FgLayoutMappingDao.class, dao -> dao.insert(entity));
    }

    public int updateFgLayoutMapping(FgLayoutMapping entity) {
        return jdbi.withExtension(FgLayoutMappingDao.class, dao -> dao.update(entity));
    }

    public void deleteFgLayoutMapping(String id) {
        jdbi.useExtension(FgLayoutMappingDao.class, dao -> dao.delete(id));
    }
}
