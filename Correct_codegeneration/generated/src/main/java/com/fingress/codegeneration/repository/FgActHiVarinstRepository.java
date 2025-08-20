package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiVarinstDao;
import com.bsit.codegeneration.record.FgActHiVarinst;

public class FgActHiVarinstRepository {

    private final Jdbi jdbi;

    public FgActHiVarinstRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiVarinst> getAllFgActHiVarinsts() {
        return jdbi.withExtension(FgActHiVarinstDao.class, fgacthivarinstdao -> fgacthivarinstdao.findAll());
    }

    public Optional<FgActHiVarinst> getFgActHiVarinstById(String id) {
        return jdbi.withExtension(FgActHiVarinstDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiVarinst(FgActHiVarinst entity) {
        return jdbi.withExtension(FgActHiVarinstDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiVarinst(FgActHiVarinst entity) {
        return jdbi.withExtension(FgActHiVarinstDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiVarinst(String id) {
        jdbi.useExtension(FgActHiVarinstDao.class, dao -> dao.delete(id));
    }
}
