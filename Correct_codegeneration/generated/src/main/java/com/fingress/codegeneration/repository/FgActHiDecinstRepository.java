package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiDecinstDao;
import com.bsit.codegeneration.record.FgActHiDecinst;

public class FgActHiDecinstRepository {

    private final Jdbi jdbi;

    public FgActHiDecinstRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiDecinst> getAllFgActHiDecinsts() {
        return jdbi.withExtension(FgActHiDecinstDao.class, fgacthidecinstdao -> fgacthidecinstdao.findAll());
    }

    public Optional<FgActHiDecinst> getFgActHiDecinstById(String id) {
        return jdbi.withExtension(FgActHiDecinstDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiDecinst(FgActHiDecinst entity) {
        return jdbi.withExtension(FgActHiDecinstDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiDecinst(FgActHiDecinst entity) {
        return jdbi.withExtension(FgActHiDecinstDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiDecinst(String id) {
        jdbi.useExtension(FgActHiDecinstDao.class, dao -> dao.delete(id));
    }
}
