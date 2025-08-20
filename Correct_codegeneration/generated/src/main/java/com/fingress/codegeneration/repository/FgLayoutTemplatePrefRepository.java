package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLayoutTemplatePrefDao;
import com.bsit.codegeneration.record.FgLayoutTemplatePref;

public class FgLayoutTemplatePrefRepository {

    private final Jdbi jdbi;

    public FgLayoutTemplatePrefRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLayoutTemplatePref> getAllFgLayoutTemplatePrefs() {
        return jdbi.withExtension(FgLayoutTemplatePrefDao.class, fglayouttemplateprefdao -> fglayouttemplateprefdao.findAll());
    }

    public Optional<FgLayoutTemplatePref> getFgLayoutTemplatePrefById(String id) {
        return jdbi.withExtension(FgLayoutTemplatePrefDao.class, dao -> dao.findById(id));
    }

    public String createFgLayoutTemplatePref(FgLayoutTemplatePref entity) {
        return jdbi.withExtension(FgLayoutTemplatePrefDao.class, dao -> dao.insert(entity));
    }

    public int updateFgLayoutTemplatePref(FgLayoutTemplatePref entity) {
        return jdbi.withExtension(FgLayoutTemplatePrefDao.class, dao -> dao.update(entity));
    }

    public void deleteFgLayoutTemplatePref(String id) {
        jdbi.useExtension(FgLayoutTemplatePrefDao.class, dao -> dao.delete(id));
    }
}
