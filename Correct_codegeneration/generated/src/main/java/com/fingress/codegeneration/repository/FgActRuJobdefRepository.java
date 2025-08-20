package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuJobdefDao;
import com.bsit.codegeneration.record.FgActRuJobdef;

public class FgActRuJobdefRepository {

    private final Jdbi jdbi;

    public FgActRuJobdefRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuJobdef> getAllFgActRuJobdefs() {
        return jdbi.withExtension(FgActRuJobdefDao.class, fgactrujobdefdao -> fgactrujobdefdao.findAll());
    }

    public Optional<FgActRuJobdef> getFgActRuJobdefById(String id) {
        return jdbi.withExtension(FgActRuJobdefDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuJobdef(FgActRuJobdef entity) {
        return jdbi.withExtension(FgActRuJobdefDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuJobdef(FgActRuJobdef entity) {
        return jdbi.withExtension(FgActRuJobdefDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuJobdef(String id) {
        jdbi.useExtension(FgActRuJobdefDao.class, dao -> dao.delete(id));
    }
}
