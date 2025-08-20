package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDoaDemoDao;
import com.bsit.codegeneration.record.FgDoaDemo;

public class FgDoaDemoRepository {

    private final Jdbi jdbi;

    public FgDoaDemoRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDoaDemo> getAllFgDoaDemos() {
        return jdbi.withExtension(FgDoaDemoDao.class, fgdoademodao -> fgdoademodao.findAll());
    }

    public Optional<FgDoaDemo> getFgDoaDemoById(String id) {
        return jdbi.withExtension(FgDoaDemoDao.class, dao -> dao.findById(id));
    }

    public String createFgDoaDemo(FgDoaDemo entity) {
        return jdbi.withExtension(FgDoaDemoDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDoaDemo(FgDoaDemo entity) {
        return jdbi.withExtension(FgDoaDemoDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDoaDemo(String id) {
        jdbi.useExtension(FgDoaDemoDao.class, dao -> dao.delete(id));
    }
}
