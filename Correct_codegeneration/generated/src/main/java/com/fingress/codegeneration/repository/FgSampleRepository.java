package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSampleDao;
import com.bsit.codegeneration.record.FgSample;

public class FgSampleRepository {

    private final Jdbi jdbi;

    public FgSampleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSample> getAllFgSamples() {
        return jdbi.withExtension(FgSampleDao.class, fgsampledao -> fgsampledao.findAll());
    }

    public Optional<FgSample> getFgSampleById(Long id) {
        return jdbi.withExtension(FgSampleDao.class, dao -> dao.findById(id));
    }

    public Long createFgSample(FgSample entity) {
        return jdbi.withExtension(FgSampleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSample(FgSample entity) {
        return jdbi.withExtension(FgSampleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSample(Long id) {
        jdbi.useExtension(FgSampleDao.class, dao -> dao.delete(id));
    }
}
