package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiCaseactinstDao;
import com.bsit.codegeneration.record.FgActHiCaseactinst;

public class FgActHiCaseactinstRepository {

    private final Jdbi jdbi;

    public FgActHiCaseactinstRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiCaseactinst> getAllFgActHiCaseactinsts() {
        return jdbi.withExtension(FgActHiCaseactinstDao.class, fgacthicaseactinstdao -> fgacthicaseactinstdao.findAll());
    }

    public Optional<FgActHiCaseactinst> getFgActHiCaseactinstById(String id) {
        return jdbi.withExtension(FgActHiCaseactinstDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiCaseactinst(FgActHiCaseactinst entity) {
        return jdbi.withExtension(FgActHiCaseactinstDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiCaseactinst(FgActHiCaseactinst entity) {
        return jdbi.withExtension(FgActHiCaseactinstDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiCaseactinst(String id) {
        jdbi.useExtension(FgActHiCaseactinstDao.class, dao -> dao.delete(id));
    }
}
