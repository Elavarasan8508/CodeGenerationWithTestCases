package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSettingCutoffBkp0410Dao;
import com.bsit.codegeneration.record.FgSettingCutoffBkp0410;

public class FgSettingCutoffBkp0410Repository {

    private final Jdbi jdbi;

    public FgSettingCutoffBkp0410Repository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSettingCutoffBkp0410> getAllFgSettingCutoffBkp0410s() {
        return jdbi.withExtension(FgSettingCutoffBkp0410Dao.class, fgsettingcutoffbkp0410dao -> fgsettingcutoffbkp0410dao.findAll());
    }

    public Optional<FgSettingCutoffBkp0410> getFgSettingCutoffBkp0410ById(String id) {
        return jdbi.withExtension(FgSettingCutoffBkp0410Dao.class, dao -> dao.findById(id));
    }

    public String createFgSettingCutoffBkp0410(FgSettingCutoffBkp0410 entity) {
        return jdbi.withExtension(FgSettingCutoffBkp0410Dao.class, dao -> dao.insert(entity));
    }

    public int updateFgSettingCutoffBkp0410(FgSettingCutoffBkp0410 entity) {
        return jdbi.withExtension(FgSettingCutoffBkp0410Dao.class, dao -> dao.update(entity));
    }

    public void deleteFgSettingCutoffBkp0410(String id) {
        jdbi.useExtension(FgSettingCutoffBkp0410Dao.class, dao -> dao.delete(id));
    }
}
