package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDocumentTemplatePartyDao;
import com.bsit.codegeneration.record.FgDocumentTemplateParty;

public class FgDocumentTemplatePartyRepository {

    private final Jdbi jdbi;

    public FgDocumentTemplatePartyRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDocumentTemplateParty> getAllFgDocumentTemplatePartys() {
        return jdbi.withExtension(FgDocumentTemplatePartyDao.class, fgdocumenttemplatepartydao -> fgdocumenttemplatepartydao.findAll());
    }

    public Optional<FgDocumentTemplateParty> getFgDocumentTemplatePartyById(Long id) {
        return jdbi.withExtension(FgDocumentTemplatePartyDao.class, dao -> dao.findById(id));
    }

    public Long createFgDocumentTemplateParty(FgDocumentTemplateParty entity) {
        return jdbi.withExtension(FgDocumentTemplatePartyDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDocumentTemplateParty(FgDocumentTemplateParty entity) {
        return jdbi.withExtension(FgDocumentTemplatePartyDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDocumentTemplateParty(Long id) {
        jdbi.useExtension(FgDocumentTemplatePartyDao.class, dao -> dao.delete(id));
    }
}
