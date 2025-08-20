package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgEntityTypeBkp191224Dao;
import com.bsit.codegeneration.record.FgEntityTypeBkp191224;

public class FgEntityTypeBkp191224Repository {

    private final Jdbi jdbi;

    public FgEntityTypeBkp191224Repository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgEntityTypeBkp191224> getAllFgEntityTypeBkp191224s() {
        return jdbi.withExtension(FgEntityTypeBkp191224Dao.class, fgentitytypebkp191224dao -> fgentitytypebkp191224dao.findAll());
    }

    public Optional<FgEntityTypeBkp191224> getFgEntityTypeBkp191224ById(Long id) {
        return jdbi.withExtension(FgEntityTypeBkp191224Dao.class, dao -> dao.findById(id));
    }

    public Long createFgEntityTypeBkp191224(FgEntityTypeBkp191224 entity) {
        return jdbi.withExtension(FgEntityTypeBkp191224Dao.class, dao -> dao.insert(entity));
    }

    public int updateFgEntityTypeBkp191224(FgEntityTypeBkp191224 entity) {
        return jdbi.withExtension(FgEntityTypeBkp191224Dao.class, dao -> dao.update(entity));
    }

    public void deleteFgEntityTypeBkp191224(Long id) {
        jdbi.useExtension(FgEntityTypeBkp191224Dao.class, dao -> dao.delete(id));
    }
}
