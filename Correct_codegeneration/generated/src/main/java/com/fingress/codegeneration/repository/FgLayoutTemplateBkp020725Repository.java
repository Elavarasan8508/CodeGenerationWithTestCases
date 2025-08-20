package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLayoutTemplateBkp020725Dao;
import com.bsit.codegeneration.record.FgLayoutTemplateBkp020725;

public class FgLayoutTemplateBkp020725Repository {

    private final Jdbi jdbi;

    public FgLayoutTemplateBkp020725Repository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLayoutTemplateBkp020725> getAllFgLayoutTemplateBkp020725s() {
        return jdbi.withExtension(FgLayoutTemplateBkp020725Dao.class, fglayouttemplatebkp020725dao -> fglayouttemplatebkp020725dao.findAll());
    }

    public Optional<FgLayoutTemplateBkp020725> getFgLayoutTemplateBkp020725ById(String id) {
        return jdbi.withExtension(FgLayoutTemplateBkp020725Dao.class, dao -> dao.findById(id));
    }

    public String createFgLayoutTemplateBkp020725(FgLayoutTemplateBkp020725 entity) {
        return jdbi.withExtension(FgLayoutTemplateBkp020725Dao.class, dao -> dao.insert(entity));
    }

    public int updateFgLayoutTemplateBkp020725(FgLayoutTemplateBkp020725 entity) {
        return jdbi.withExtension(FgLayoutTemplateBkp020725Dao.class, dao -> dao.update(entity));
    }

    public void deleteFgLayoutTemplateBkp020725(String id) {
        jdbi.useExtension(FgLayoutTemplateBkp020725Dao.class, dao -> dao.delete(id));
    }
}
