package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiCaseinstDao;
import com.bsit.codegeneration.record.FgActHiCaseinst;

public class FgActHiCaseinstRepository {

    private final Jdbi jdbi;

    public FgActHiCaseinstRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiCaseinst> getAllFgActHiCaseinsts() {
        return jdbi.withExtension(FgActHiCaseinstDao.class, fgacthicaseinstdao -> fgacthicaseinstdao.findAll());
    }

    public Optional<FgActHiCaseinst> getFgActHiCaseinstById(String id) {
        return jdbi.withExtension(FgActHiCaseinstDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiCaseinst(FgActHiCaseinst entity) {
        return jdbi.withExtension(FgActHiCaseinstDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiCaseinst(FgActHiCaseinst entity) {
        return jdbi.withExtension(FgActHiCaseinstDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiCaseinst(String id) {
        jdbi.useExtension(FgActHiCaseinstDao.class, dao -> dao.delete(id));
    }
}
