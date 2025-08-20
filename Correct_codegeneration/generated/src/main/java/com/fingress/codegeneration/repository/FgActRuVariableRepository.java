package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuVariableDao;
import com.bsit.codegeneration.record.FgActRuVariable;

public class FgActRuVariableRepository {

    private final Jdbi jdbi;

    public FgActRuVariableRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuVariable> getAllFgActRuVariables() {
        return jdbi.withExtension(FgActRuVariableDao.class, fgactruvariabledao -> fgactruvariabledao.findAll());
    }

    public Optional<FgActRuVariable> getFgActRuVariableById(String id) {
        return jdbi.withExtension(FgActRuVariableDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuVariable(FgActRuVariable entity) {
        return jdbi.withExtension(FgActRuVariableDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuVariable(FgActRuVariable entity) {
        return jdbi.withExtension(FgActRuVariableDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuVariable(String id) {
        jdbi.useExtension(FgActRuVariableDao.class, dao -> dao.delete(id));
    }
}
