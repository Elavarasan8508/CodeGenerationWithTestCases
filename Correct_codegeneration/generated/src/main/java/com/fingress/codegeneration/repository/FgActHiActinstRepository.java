package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiActinstDao;
import com.bsit.codegeneration.record.FgActHiActinst;

public class FgActHiActinstRepository {

    private final Jdbi jdbi;

    public FgActHiActinstRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiActinst> getAllFgActHiActinsts() {
        return jdbi.withExtension(FgActHiActinstDao.class, fgacthiactinstdao -> fgacthiactinstdao.findAll());
    }

    public Optional<FgActHiActinst> getFgActHiActinstById(String id) {
        return jdbi.withExtension(FgActHiActinstDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiActinst(FgActHiActinst entity) {
        return jdbi.withExtension(FgActHiActinstDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiActinst(FgActHiActinst entity) {
        return jdbi.withExtension(FgActHiActinstDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiActinst(String id) {
        jdbi.useExtension(FgActHiActinstDao.class, dao -> dao.delete(id));
    }
}
