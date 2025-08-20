package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTestFormDao;
import com.bsit.codegeneration.record.FgTestForm;

public class FgTestFormRepository {

    private final Jdbi jdbi;

    public FgTestFormRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTestForm> getAllFgTestForms() {
        return jdbi.withExtension(FgTestFormDao.class, fgtestformdao -> fgtestformdao.findAll());
    }

    public Optional<FgTestForm> getFgTestFormById(Long id) {
        return jdbi.withExtension(FgTestFormDao.class, dao -> dao.findById(id));
    }

    public Long createFgTestForm(FgTestForm entity) {
        return jdbi.withExtension(FgTestFormDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTestForm(FgTestForm entity) {
        return jdbi.withExtension(FgTestFormDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTestForm(Long id) {
        jdbi.useExtension(FgTestFormDao.class, dao -> dao.delete(id));
    }
}
