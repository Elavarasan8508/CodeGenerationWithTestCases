package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgExpMbiFircDao;
import com.bsit.codegeneration.record.FgExpMbiFirc;

public class FgExpMbiFircRepository {

    private final Jdbi jdbi;

    public FgExpMbiFircRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgExpMbiFirc> getAllFgExpMbiFircs() {
        return jdbi.withExtension(FgExpMbiFircDao.class, fgexpmbifircdao -> fgexpmbifircdao.findAll());
    }

    public Optional<FgExpMbiFirc> getFgExpMbiFircById(Long id) {
        return jdbi.withExtension(FgExpMbiFircDao.class, dao -> dao.findById(id));
    }

    public Long createFgExpMbiFirc(FgExpMbiFirc entity) {
        return jdbi.withExtension(FgExpMbiFircDao.class, dao -> dao.insert(entity));
    }

    public int updateFgExpMbiFirc(FgExpMbiFirc entity) {
        return jdbi.withExtension(FgExpMbiFircDao.class, dao -> dao.update(entity));
    }

    public void deleteFgExpMbiFirc(Long id) {
        jdbi.useExtension(FgExpMbiFircDao.class, dao -> dao.delete(id));
    }
}
