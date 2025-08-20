package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActReCaseDefDao;
import com.bsit.codegeneration.record.FgActReCaseDef;

public class FgActReCaseDefRepository {

    private final Jdbi jdbi;

    public FgActReCaseDefRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActReCaseDef> getAllFgActReCaseDefs() {
        return jdbi.withExtension(FgActReCaseDefDao.class, fgactrecasedefdao -> fgactrecasedefdao.findAll());
    }

    public Optional<FgActReCaseDef> getFgActReCaseDefById(Long id) {
        return jdbi.withExtension(FgActReCaseDefDao.class, dao -> dao.findById(id));
    }

    public Long createFgActReCaseDef(FgActReCaseDef entity) {
        return jdbi.withExtension(FgActReCaseDefDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActReCaseDef(FgActReCaseDef entity) {
        return jdbi.withExtension(FgActReCaseDefDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActReCaseDef(Long id) {
        jdbi.useExtension(FgActReCaseDefDao.class, dao -> dao.delete(id));
    }
}
