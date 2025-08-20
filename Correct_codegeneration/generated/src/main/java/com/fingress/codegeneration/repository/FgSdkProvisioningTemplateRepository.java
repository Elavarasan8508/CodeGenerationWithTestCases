package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkProvisioningTemplateDao;
import com.bsit.codegeneration.record.FgSdkProvisioningTemplate;

public class FgSdkProvisioningTemplateRepository {

    private final Jdbi jdbi;

    public FgSdkProvisioningTemplateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkProvisioningTemplate> getAllFgSdkProvisioningTemplates() {
        return jdbi.withExtension(FgSdkProvisioningTemplateDao.class, fgsdkprovisioningtemplatedao -> fgsdkprovisioningtemplatedao.findAll());
    }

    public Optional<FgSdkProvisioningTemplate> getFgSdkProvisioningTemplateById(String id) {
        return jdbi.withExtension(FgSdkProvisioningTemplateDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkProvisioningTemplate(FgSdkProvisioningTemplate entity) {
        return jdbi.withExtension(FgSdkProvisioningTemplateDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkProvisioningTemplate(FgSdkProvisioningTemplate entity) {
        return jdbi.withExtension(FgSdkProvisioningTemplateDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkProvisioningTemplate(String id) {
        jdbi.useExtension(FgSdkProvisioningTemplateDao.class, dao -> dao.delete(id));
    }
}
