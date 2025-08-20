package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkNotificationRuleDao;
import com.bsit.codegeneration.record.FgSdkNotificationRule;

public class FgSdkNotificationRuleRepository {

    private final Jdbi jdbi;

    public FgSdkNotificationRuleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkNotificationRule> getAllFgSdkNotificationRules() {
        return jdbi.withExtension(FgSdkNotificationRuleDao.class, fgsdknotificationruledao -> fgsdknotificationruledao.findAll());
    }

    public Optional<FgSdkNotificationRule> getFgSdkNotificationRuleById(String id) {
        return jdbi.withExtension(FgSdkNotificationRuleDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkNotificationRule(FgSdkNotificationRule entity) {
        return jdbi.withExtension(FgSdkNotificationRuleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkNotificationRule(FgSdkNotificationRule entity) {
        return jdbi.withExtension(FgSdkNotificationRuleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkNotificationRule(String id) {
        jdbi.useExtension(FgSdkNotificationRuleDao.class, dao -> dao.delete(id));
    }
}
