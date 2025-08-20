package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkDocTemplateDao;
import com.bsit.codegeneration.record.FgSdkDocTemplate;

public class FgSdkDocTemplateRepository {

    private final Jdbi jdbi;

    public FgSdkDocTemplateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkDocTemplate> getAllFgSdkDocTemplates() {
        return jdbi.withExtension(FgSdkDocTemplateDao.class, fgsdkdoctemplatedao -> fgsdkdoctemplatedao.findAll());
    }

    public Optional<FgSdkDocTemplate> getFgSdkDocTemplateById(String id) {
        return jdbi.withExtension(FgSdkDocTemplateDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkDocTemplate(FgSdkDocTemplate entity) {
        return jdbi.withExtension(FgSdkDocTemplateDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkDocTemplate(FgSdkDocTemplate entity) {
        return jdbi.withExtension(FgSdkDocTemplateDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkDocTemplate(String id) {
        jdbi.useExtension(FgSdkDocTemplateDao.class, dao -> dao.delete(id));
    }
}
