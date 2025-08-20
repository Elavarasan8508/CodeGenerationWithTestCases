package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPostProcessorDao;
import com.bsit.codegeneration.record.FgPostProcessor;

public class FgPostProcessorRepository {

    private final Jdbi jdbi;

    public FgPostProcessorRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPostProcessor> getAllFgPostProcessors() {
        return jdbi.withExtension(FgPostProcessorDao.class, fgpostprocessordao -> fgpostprocessordao.findAll());
    }

    public Optional<FgPostProcessor> getFgPostProcessorById(String id) {
        return jdbi.withExtension(FgPostProcessorDao.class, dao -> dao.findById(id));
    }

    public String createFgPostProcessor(FgPostProcessor entity) {
        return jdbi.withExtension(FgPostProcessorDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPostProcessor(FgPostProcessor entity) {
        return jdbi.withExtension(FgPostProcessorDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPostProcessor(String id) {
        jdbi.useExtension(FgPostProcessorDao.class, dao -> dao.delete(id));
    }
}
