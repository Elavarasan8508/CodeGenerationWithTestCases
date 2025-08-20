package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkReportTemplateDao;
import com.bsit.codegeneration.record.FgSdkReportTemplate;

public class FgSdkReportTemplateRepository {

    private final Jdbi jdbi;

    public FgSdkReportTemplateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkReportTemplate> getAllFgSdkReportTemplates() {
        return jdbi.withExtension(FgSdkReportTemplateDao.class, fgsdkreporttemplatedao -> fgsdkreporttemplatedao.findAll());
    }

    public Optional<FgSdkReportTemplate> getFgSdkReportTemplateById(String id) {
        return jdbi.withExtension(FgSdkReportTemplateDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkReportTemplate(FgSdkReportTemplate entity) {
        return jdbi.withExtension(FgSdkReportTemplateDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkReportTemplate(FgSdkReportTemplate entity) {
        return jdbi.withExtension(FgSdkReportTemplateDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkReportTemplate(String id) {
        jdbi.useExtension(FgSdkReportTemplateDao.class, dao -> dao.delete(id));
    }
}
