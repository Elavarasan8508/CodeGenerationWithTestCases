package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLayoutTemplateDao;
import com.bsit.codegeneration.record.FgLayoutTemplate;

public class FgLayoutTemplateRepository {

    private final Jdbi jdbi;

    public FgLayoutTemplateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLayoutTemplate> getAllFgLayoutTemplates() {
        return jdbi.withExtension(FgLayoutTemplateDao.class, fglayouttemplatedao -> fglayouttemplatedao.findAll());
    }

    public Optional<FgLayoutTemplate> getFgLayoutTemplateById(String id) {
        return jdbi.withExtension(FgLayoutTemplateDao.class, dao -> dao.findById(id));
    }

    public String createFgLayoutTemplate(FgLayoutTemplate entity) {
        return jdbi.withExtension(FgLayoutTemplateDao.class, dao -> dao.insert(entity));
    }

    public int updateFgLayoutTemplate(FgLayoutTemplate entity) {
        return jdbi.withExtension(FgLayoutTemplateDao.class, dao -> dao.update(entity));
    }

    public void deleteFgLayoutTemplate(String id) {
        jdbi.useExtension(FgLayoutTemplateDao.class, dao -> dao.delete(id));
    }
}
