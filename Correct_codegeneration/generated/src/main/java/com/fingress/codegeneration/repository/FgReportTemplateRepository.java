package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgReportTemplateDao;
import com.bsit.codegeneration.record.FgReportTemplate;

public class FgReportTemplateRepository {

    private final Jdbi jdbi;

    public FgReportTemplateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgReportTemplate> getAllFgReportTemplates() {
        return jdbi.withExtension(FgReportTemplateDao.class, fgreporttemplatedao -> fgreporttemplatedao.findAll());
    }

    public Optional<FgReportTemplate> getFgReportTemplateById(Long id) {
        return jdbi.withExtension(FgReportTemplateDao.class, dao -> dao.findById(id));
    }

    public Long createFgReportTemplate(FgReportTemplate entity) {
        return jdbi.withExtension(FgReportTemplateDao.class, dao -> dao.insert(entity));
    }

    public int updateFgReportTemplate(FgReportTemplate entity) {
        return jdbi.withExtension(FgReportTemplateDao.class, dao -> dao.update(entity));
    }

    public void deleteFgReportTemplate(Long id) {
        jdbi.useExtension(FgReportTemplateDao.class, dao -> dao.delete(id));
    }
}
