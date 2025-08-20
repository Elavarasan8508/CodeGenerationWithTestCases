package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiTaskinstDao;
import com.bsit.codegeneration.record.FgActHiTaskinst;

public class FgActHiTaskinstRepository {

    private final Jdbi jdbi;

    public FgActHiTaskinstRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiTaskinst> getAllFgActHiTaskinsts() {
        return jdbi.withExtension(FgActHiTaskinstDao.class, fgacthitaskinstdao -> fgacthitaskinstdao.findAll());
    }

    public Optional<FgActHiTaskinst> getFgActHiTaskinstById(String id) {
        return jdbi.withExtension(FgActHiTaskinstDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiTaskinst(FgActHiTaskinst entity) {
        return jdbi.withExtension(FgActHiTaskinstDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiTaskinst(FgActHiTaskinst entity) {
        return jdbi.withExtension(FgActHiTaskinstDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiTaskinst(String id) {
        jdbi.useExtension(FgActHiTaskinstDao.class, dao -> dao.delete(id));
    }
}
