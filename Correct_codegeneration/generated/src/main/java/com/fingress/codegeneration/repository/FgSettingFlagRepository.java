package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSettingFlagDao;
import com.bsit.codegeneration.record.FgSettingFlag;

public class FgSettingFlagRepository {

    private final Jdbi jdbi;

    public FgSettingFlagRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSettingFlag> getAllFgSettingFlags() {
        return jdbi.withExtension(FgSettingFlagDao.class, fgsettingflagdao -> fgsettingflagdao.findAll());
    }

    public Optional<FgSettingFlag> getFgSettingFlagById(String id) {
        return jdbi.withExtension(FgSettingFlagDao.class, dao -> dao.findById(id));
    }

    public String createFgSettingFlag(FgSettingFlag entity) {
        return jdbi.withExtension(FgSettingFlagDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSettingFlag(FgSettingFlag entity) {
        return jdbi.withExtension(FgSettingFlagDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSettingFlag(String id) {
        jdbi.useExtension(FgSettingFlagDao.class, dao -> dao.delete(id));
    }
}
