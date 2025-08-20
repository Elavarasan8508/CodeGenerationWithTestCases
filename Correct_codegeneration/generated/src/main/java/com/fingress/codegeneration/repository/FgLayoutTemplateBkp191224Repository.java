package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLayoutTemplateBkp191224Dao;
import com.bsit.codegeneration.record.FgLayoutTemplateBkp191224;

public class FgLayoutTemplateBkp191224Repository {

    private final Jdbi jdbi;

    public FgLayoutTemplateBkp191224Repository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLayoutTemplateBkp191224> getAllFgLayoutTemplateBkp191224s() {
        return jdbi.withExtension(FgLayoutTemplateBkp191224Dao.class, fglayouttemplatebkp191224dao -> fglayouttemplatebkp191224dao.findAll());
    }

    public Optional<FgLayoutTemplateBkp191224> getFgLayoutTemplateBkp191224ById(String id) {
        return jdbi.withExtension(FgLayoutTemplateBkp191224Dao.class, dao -> dao.findById(id));
    }

    public String createFgLayoutTemplateBkp191224(FgLayoutTemplateBkp191224 entity) {
        return jdbi.withExtension(FgLayoutTemplateBkp191224Dao.class, dao -> dao.insert(entity));
    }

    public int updateFgLayoutTemplateBkp191224(FgLayoutTemplateBkp191224 entity) {
        return jdbi.withExtension(FgLayoutTemplateBkp191224Dao.class, dao -> dao.update(entity));
    }

    public void deleteFgLayoutTemplateBkp191224(String id) {
        jdbi.useExtension(FgLayoutTemplateBkp191224Dao.class, dao -> dao.delete(id));
    }
}
