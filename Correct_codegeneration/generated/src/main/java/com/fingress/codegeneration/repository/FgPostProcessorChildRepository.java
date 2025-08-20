package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPostProcessorChildDao;
import com.bsit.codegeneration.record.FgPostProcessorChild;

public class FgPostProcessorChildRepository {

    private final Jdbi jdbi;

    public FgPostProcessorChildRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPostProcessorChild> getAllFgPostProcessorChilds() {
        return jdbi.withExtension(FgPostProcessorChildDao.class, fgpostprocessorchilddao -> fgpostprocessorchilddao.findAll());
    }

    public Optional<FgPostProcessorChild> getFgPostProcessorChildById(String id) {
        return jdbi.withExtension(FgPostProcessorChildDao.class, dao -> dao.findById(id));
    }

    public String createFgPostProcessorChild(FgPostProcessorChild entity) {
        return jdbi.withExtension(FgPostProcessorChildDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPostProcessorChild(FgPostProcessorChild entity) {
        return jdbi.withExtension(FgPostProcessorChildDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPostProcessorChild(String id) {
        jdbi.useExtension(FgPostProcessorChildDao.class, dao -> dao.delete(id));
    }
}
