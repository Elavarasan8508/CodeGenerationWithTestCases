package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgGodrejBoyceDao;
import com.bsit.codegeneration.record.FgGodrejBoyce;

public class FgGodrejBoyceRepository {

    private final Jdbi jdbi;

    public FgGodrejBoyceRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgGodrejBoyce> getAllFgGodrejBoyces() {
        return jdbi.withExtension(FgGodrejBoyceDao.class, fggodrejboycedao -> fggodrejboycedao.findAll());
    }

    public Optional<FgGodrejBoyce> getFgGodrejBoyceById(String id) {
        return jdbi.withExtension(FgGodrejBoyceDao.class, dao -> dao.findById(id));
    }

    public String createFgGodrejBoyce(FgGodrejBoyce entity) {
        return jdbi.withExtension(FgGodrejBoyceDao.class, dao -> dao.insert(entity));
    }

    public int updateFgGodrejBoyce(FgGodrejBoyce entity) {
        return jdbi.withExtension(FgGodrejBoyceDao.class, dao -> dao.update(entity));
    }

    public void deleteFgGodrejBoyce(String id) {
        jdbi.useExtension(FgGodrejBoyceDao.class, dao -> dao.delete(id));
    }
}
