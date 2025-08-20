package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProvisioningRuleDao;
import com.bsit.codegeneration.record.FgProvisioningRule;

public class FgProvisioningRuleRepository {

    private final Jdbi jdbi;

    public FgProvisioningRuleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProvisioningRule> getAllFgProvisioningRules() {
        return jdbi.withExtension(FgProvisioningRuleDao.class, fgprovisioningruledao -> fgprovisioningruledao.findAll());
    }

    public Optional<FgProvisioningRule> getFgProvisioningRuleById(String id) {
        return jdbi.withExtension(FgProvisioningRuleDao.class, dao -> dao.findById(id));
    }

    public String createFgProvisioningRule(FgProvisioningRule entity) {
        return jdbi.withExtension(FgProvisioningRuleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProvisioningRule(FgProvisioningRule entity) {
        return jdbi.withExtension(FgProvisioningRuleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProvisioningRule(String id) {
        jdbi.useExtension(FgProvisioningRuleDao.class, dao -> dao.delete(id));
    }
}
