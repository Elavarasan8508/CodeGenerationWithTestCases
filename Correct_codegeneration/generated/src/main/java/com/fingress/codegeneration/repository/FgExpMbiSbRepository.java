package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgExpMbiSbDao;
import com.bsit.codegeneration.record.FgExpMbiSb;

public class FgExpMbiSbRepository {

    private final Jdbi jdbi;

    public FgExpMbiSbRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgExpMbiSb> getAllFgExpMbiSbs() {
        return jdbi.withExtension(FgExpMbiSbDao.class, fgexpmbisbdao -> fgexpmbisbdao.findAll());
    }

    public Optional<FgExpMbiSb> getFgExpMbiSbById(String id) {
        return jdbi.withExtension(FgExpMbiSbDao.class, dao -> dao.findById(id));
    }

    public String createFgExpMbiSb(FgExpMbiSb entity) {
        return jdbi.withExtension(FgExpMbiSbDao.class, dao -> dao.insert(entity));
    }

    public int updateFgExpMbiSb(FgExpMbiSb entity) {
        return jdbi.withExtension(FgExpMbiSbDao.class, dao -> dao.update(entity));
    }

    public void deleteFgExpMbiSb(String id) {
        jdbi.useExtension(FgExpMbiSbDao.class, dao -> dao.delete(id));
    }
}
