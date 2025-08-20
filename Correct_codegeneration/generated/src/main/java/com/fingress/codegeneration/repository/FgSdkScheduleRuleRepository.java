package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkScheduleRuleDao;
import com.bsit.codegeneration.record.FgSdkScheduleRule;

public class FgSdkScheduleRuleRepository {

    private final Jdbi jdbi;

    public FgSdkScheduleRuleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkScheduleRule> getAllFgSdkScheduleRules() {
        return jdbi.withExtension(FgSdkScheduleRuleDao.class, fgsdkscheduleruledao -> fgsdkscheduleruledao.findAll());
    }

    public Optional<FgSdkScheduleRule> getFgSdkScheduleRuleById(String id) {
        return jdbi.withExtension(FgSdkScheduleRuleDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkScheduleRule(FgSdkScheduleRule entity) {
        return jdbi.withExtension(FgSdkScheduleRuleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkScheduleRule(FgSdkScheduleRule entity) {
        return jdbi.withExtension(FgSdkScheduleRuleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkScheduleRule(String id) {
        jdbi.useExtension(FgSdkScheduleRuleDao.class, dao -> dao.delete(id));
    }
}
