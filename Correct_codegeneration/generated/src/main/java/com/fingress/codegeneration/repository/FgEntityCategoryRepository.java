package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgEntityCategoryDao;
import com.bsit.codegeneration.record.FgEntityCategory;

public class FgEntityCategoryRepository {

    private final Jdbi jdbi;

    public FgEntityCategoryRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgEntityCategory> getAllFgEntityCategorys() {
        return jdbi.withExtension(FgEntityCategoryDao.class, fgentitycategorydao -> fgentitycategorydao.findAll());
    }

    public Optional<FgEntityCategory> getFgEntityCategoryById(Long id) {
        return jdbi.withExtension(FgEntityCategoryDao.class, dao -> dao.findById(id));
    }

    public Long createFgEntityCategory(FgEntityCategory entity) {
        return jdbi.withExtension(FgEntityCategoryDao.class, dao -> dao.insert(entity));
    }

    public int updateFgEntityCategory(FgEntityCategory entity) {
        return jdbi.withExtension(FgEntityCategoryDao.class, dao -> dao.update(entity));
    }

    public void deleteFgEntityCategory(Long id) {
        jdbi.useExtension(FgEntityCategoryDao.class, dao -> dao.delete(id));
    }
}
