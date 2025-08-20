package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiProcinstDao;
import com.bsit.codegeneration.record.FgActHiProcinst;

public class FgActHiProcinstRepository {

    private final Jdbi jdbi;

    public FgActHiProcinstRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiProcinst> getAllFgActHiProcinsts() {
        return jdbi.withExtension(FgActHiProcinstDao.class, fgacthiprocinstdao -> fgacthiprocinstdao.findAll());
    }

    public Optional<FgActHiProcinst> getFgActHiProcinstById(String id) {
        return jdbi.withExtension(FgActHiProcinstDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiProcinst(FgActHiProcinst entity) {
        return jdbi.withExtension(FgActHiProcinstDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiProcinst(FgActHiProcinst entity) {
        return jdbi.withExtension(FgActHiProcinstDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiProcinst(String id) {
        jdbi.useExtension(FgActHiProcinstDao.class, dao -> dao.delete(id));
    }
}
