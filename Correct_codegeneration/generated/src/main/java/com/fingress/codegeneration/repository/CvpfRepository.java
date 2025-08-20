package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.CvpfDao;
import com.bsit.codegeneration.record.Cvpf;

public class CvpfRepository {

    private final Jdbi jdbi;

    public CvpfRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Cvpf> getAllCvpfs() {
        return jdbi.withExtension(CvpfDao.class, cvpfdao -> cvpfdao.findAll());
    }

    public Optional<Cvpf> getCvpfById(String id) {
        return jdbi.withExtension(CvpfDao.class, dao -> dao.findById(id));
    }

    public String createCvpf(Cvpf entity) {
        return jdbi.withExtension(CvpfDao.class, dao -> dao.insert(entity));
    }

    public int updateCvpf(Cvpf entity) {
        return jdbi.withExtension(CvpfDao.class, dao -> dao.update(entity));
    }

    public void deleteCvpf(String id) {
        jdbi.useExtension(CvpfDao.class, dao -> dao.delete(id));
    }
}
