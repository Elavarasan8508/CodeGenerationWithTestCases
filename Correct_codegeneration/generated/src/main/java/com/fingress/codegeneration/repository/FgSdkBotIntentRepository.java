package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkBotIntentDao;
import com.bsit.codegeneration.record.FgSdkBotIntent;

public class FgSdkBotIntentRepository {

    private final Jdbi jdbi;

    public FgSdkBotIntentRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkBotIntent> getAllFgSdkBotIntents() {
        return jdbi.withExtension(FgSdkBotIntentDao.class, fgsdkbotintentdao -> fgsdkbotintentdao.findAll());
    }

    public Optional<FgSdkBotIntent> getFgSdkBotIntentById(Long id) {
        return jdbi.withExtension(FgSdkBotIntentDao.class, dao -> dao.findById(id));
    }

    public Long createFgSdkBotIntent(FgSdkBotIntent entity) {
        return jdbi.withExtension(FgSdkBotIntentDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkBotIntent(FgSdkBotIntent entity) {
        return jdbi.withExtension(FgSdkBotIntentDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkBotIntent(Long id) {
        jdbi.useExtension(FgSdkBotIntentDao.class, dao -> dao.delete(id));
    }
}
