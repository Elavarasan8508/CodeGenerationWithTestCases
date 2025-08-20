package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.Bkp110824FgLayoutTemplateDao;
import com.bsit.codegeneration.record.Bkp110824FgLayoutTemplate;

public class Bkp110824FgLayoutTemplateRepository {

    private final Jdbi jdbi;

    public Bkp110824FgLayoutTemplateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Bkp110824FgLayoutTemplate> getAllBkp110824FgLayoutTemplates() {
        return jdbi.withExtension(Bkp110824FgLayoutTemplateDao.class, bkp110824fglayouttemplatedao -> bkp110824fglayouttemplatedao.findAll());
    }

    public Optional<Bkp110824FgLayoutTemplate> getBkp110824FgLayoutTemplateById(String id) {
        return jdbi.withExtension(Bkp110824FgLayoutTemplateDao.class, dao -> dao.findById(id));
    }

    public String createBkp110824FgLayoutTemplate(Bkp110824FgLayoutTemplate entity) {
        return jdbi.withExtension(Bkp110824FgLayoutTemplateDao.class, dao -> dao.insert(entity));
    }

    public int updateBkp110824FgLayoutTemplate(Bkp110824FgLayoutTemplate entity) {
        return jdbi.withExtension(Bkp110824FgLayoutTemplateDao.class, dao -> dao.update(entity));
    }

    public void deleteBkp110824FgLayoutTemplate(String id) {
        jdbi.useExtension(Bkp110824FgLayoutTemplateDao.class, dao -> dao.delete(id));
    }
}
