package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSettingCutoffDao;
import com.bsit.codegeneration.record.FgSettingCutoff;

public class FgSettingCutoffRepository {

    private final Jdbi jdbi;

    public FgSettingCutoffRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSettingCutoff> getAllFgSettingCutoffs() {
        return jdbi.withExtension(FgSettingCutoffDao.class, fgsettingcutoffdao -> fgsettingcutoffdao.findAll());
    }

    public Optional<FgSettingCutoff> getFgSettingCutoffById(String id) {
        return jdbi.withExtension(FgSettingCutoffDao.class, dao -> dao.findById(id));
    }

    public String createFgSettingCutoff(FgSettingCutoff entity) {
        return jdbi.withExtension(FgSettingCutoffDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSettingCutoff(FgSettingCutoff entity) {
        return jdbi.withExtension(FgSettingCutoffDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSettingCutoff(String id) {
        jdbi.useExtension(FgSettingCutoffDao.class, dao -> dao.delete(id));
    }
}
