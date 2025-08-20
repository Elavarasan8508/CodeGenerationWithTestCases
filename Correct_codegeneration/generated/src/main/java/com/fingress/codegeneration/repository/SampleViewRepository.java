package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.SampleViewDao;
import com.bsit.codegeneration.record.SampleView;

public class SampleViewRepository {

    private final Jdbi jdbi;

    public SampleViewRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<SampleView> getAllSampleViews() {
        return jdbi.withExtension(SampleViewDao.class, sampleviewdao -> sampleviewdao.findAll());
    }

    public Optional<SampleView> getSampleViewById(String id) {
        return jdbi.withExtension(SampleViewDao.class, dao -> dao.findById(id));
    }

    public String createSampleView(SampleView entity) {
        return jdbi.withExtension(SampleViewDao.class, dao -> dao.insert(entity));
    }

    public int updateSampleView(SampleView entity) {
        return jdbi.withExtension(SampleViewDao.class, dao -> dao.update(entity));
    }

    public void deleteSampleView(String id) {
        jdbi.useExtension(SampleViewDao.class, dao -> dao.delete(id));
    }
}
