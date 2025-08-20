package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTest01Dao;
import com.bsit.codegeneration.record.FgTest01;

public class FgTest01Repository {

    private final Jdbi jdbi;

    public FgTest01Repository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTest01> getAllFgTest01s() {
        return jdbi.withExtension(FgTest01Dao.class, fgtest01dao -> fgtest01dao.findAll());
    }

    public Optional<FgTest01> getFgTest01ById(String id) {
        return jdbi.withExtension(FgTest01Dao.class, dao -> dao.findById(id));
    }

    public String createFgTest01(FgTest01 entity) {
        return jdbi.withExtension(FgTest01Dao.class, dao -> dao.insert(entity));
    }

    public int updateFgTest01(FgTest01 entity) {
        return jdbi.withExtension(FgTest01Dao.class, dao -> dao.update(entity));
    }

    public void deleteFgTest01(String id) {
        jdbi.useExtension(FgTest01Dao.class, dao -> dao.delete(id));
    }
}
