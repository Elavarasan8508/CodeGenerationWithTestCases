package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ExtifsccDao;
import com.bsit.codegeneration.record.Extifscc;

public class ExtifsccRepository {

    private final Jdbi jdbi;

    public ExtifsccRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Extifscc> getAllExtifsccs() {
        return jdbi.withExtension(ExtifsccDao.class, extifsccdao -> extifsccdao.findAll());
    }

    public Optional<Extifscc> getExtifsccById(String id) {
        return jdbi.withExtension(ExtifsccDao.class, dao -> dao.findById(id));
    }

    public String createExtifscc(Extifscc entity) {
        return jdbi.withExtension(ExtifsccDao.class, dao -> dao.insert(entity));
    }

    public int updateExtifscc(Extifscc entity) {
        return jdbi.withExtension(ExtifsccDao.class, dao -> dao.update(entity));
    }

    public void deleteExtifscc(String id) {
        jdbi.useExtension(ExtifsccDao.class, dao -> dao.delete(id));
    }
}
