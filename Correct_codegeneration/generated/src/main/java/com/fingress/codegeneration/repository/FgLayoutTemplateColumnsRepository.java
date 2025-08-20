package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLayoutTemplateColumnsDao;
import com.bsit.codegeneration.record.FgLayoutTemplateColumns;

public class FgLayoutTemplateColumnsRepository {

    private final Jdbi jdbi;

    public FgLayoutTemplateColumnsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLayoutTemplateColumns> getAllFgLayoutTemplateColumnss() {
        return jdbi.withExtension(FgLayoutTemplateColumnsDao.class, fglayouttemplatecolumnsdao -> fglayouttemplatecolumnsdao.findAll());
    }

    public Optional<FgLayoutTemplateColumns> getFgLayoutTemplateColumnsById(String id) {
        return jdbi.withExtension(FgLayoutTemplateColumnsDao.class, dao -> dao.findById(id));
    }

    public String createFgLayoutTemplateColumns(FgLayoutTemplateColumns entity) {
        return jdbi.withExtension(FgLayoutTemplateColumnsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgLayoutTemplateColumns(FgLayoutTemplateColumns entity) {
        return jdbi.withExtension(FgLayoutTemplateColumnsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgLayoutTemplateColumns(String id) {
        jdbi.useExtension(FgLayoutTemplateColumnsDao.class, dao -> dao.delete(id));
    }
}
