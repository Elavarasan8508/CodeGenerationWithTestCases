package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDocumentTemplateDao;
import com.bsit.codegeneration.record.FgDocumentTemplate;

public class FgDocumentTemplateRepository {

    private final Jdbi jdbi;

    public FgDocumentTemplateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDocumentTemplate> getAllFgDocumentTemplates() {
        return jdbi.withExtension(FgDocumentTemplateDao.class, fgdocumenttemplatedao -> fgdocumenttemplatedao.findAll());
    }

    public Optional<FgDocumentTemplate> getFgDocumentTemplateById(Long id) {
        return jdbi.withExtension(FgDocumentTemplateDao.class, dao -> dao.findById(id));
    }

    public Long createFgDocumentTemplate(FgDocumentTemplate entity) {
        return jdbi.withExtension(FgDocumentTemplateDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDocumentTemplate(FgDocumentTemplate entity) {
        return jdbi.withExtension(FgDocumentTemplateDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDocumentTemplate(Long id) {
        jdbi.useExtension(FgDocumentTemplateDao.class, dao -> dao.delete(id));
    }
}
