package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdConfigurationDao;
import com.bsit.codegeneration.record.FgTdConfiguration;

public class FgTdConfigurationRepository {

    private final Jdbi jdbi;

    public FgTdConfigurationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdConfiguration> getAllFgTdConfigurations() {
        return jdbi.withExtension(FgTdConfigurationDao.class, fgtdconfigurationdao -> fgtdconfigurationdao.findAll());
    }

    public Optional<FgTdConfiguration> getFgTdConfigurationById(String id) {
        return jdbi.withExtension(FgTdConfigurationDao.class, dao -> dao.findById(id));
    }

    public String createFgTdConfiguration(FgTdConfiguration entity) {
        return jdbi.withExtension(FgTdConfigurationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdConfiguration(FgTdConfiguration entity) {
        return jdbi.withExtension(FgTdConfigurationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdConfiguration(String id) {
        jdbi.useExtension(FgTdConfigurationDao.class, dao -> dao.delete(id));
    }
}
