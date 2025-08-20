package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.GfpfDao;
import com.bsit.codegeneration.record.Gfpf;

public class GfpfRepository {

    private final Jdbi jdbi;

    public GfpfRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Gfpf> getAllGfpfs() {
        return jdbi.withExtension(GfpfDao.class, gfpfdao -> gfpfdao.findAll());
    }

    public Optional<Gfpf> getGfpfById(String id) {
        return jdbi.withExtension(GfpfDao.class, dao -> dao.findById(id));
    }

    public String createGfpf(Gfpf entity) {
        return jdbi.withExtension(GfpfDao.class, dao -> dao.insert(entity));
    }

    public int updateGfpf(Gfpf entity) {
        return jdbi.withExtension(GfpfDao.class, dao -> dao.update(entity));
    }

    public void deleteGfpf(String id) {
        jdbi.useExtension(GfpfDao.class, dao -> dao.delete(id));
    }
}
