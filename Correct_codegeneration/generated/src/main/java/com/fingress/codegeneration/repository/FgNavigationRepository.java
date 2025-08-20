package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgNavigationDao;
import com.bsit.codegeneration.record.FgNavigation;

public class FgNavigationRepository {

    private final Jdbi jdbi;

    public FgNavigationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgNavigation> getAllFgNavigations() {
        return jdbi.withExtension(FgNavigationDao.class, fgnavigationdao -> fgnavigationdao.findAll());
    }

    public Optional<FgNavigation> getFgNavigationById(String id) {
        return jdbi.withExtension(FgNavigationDao.class, dao -> dao.findById(id));
    }

    public String createFgNavigation(FgNavigation entity) {
        return jdbi.withExtension(FgNavigationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgNavigation(FgNavigation entity) {
        return jdbi.withExtension(FgNavigationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgNavigation(String id) {
        jdbi.useExtension(FgNavigationDao.class, dao -> dao.delete(id));
    }
}
