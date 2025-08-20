package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LmsMdmFtpDao;
import com.bsit.codegeneration.record.LmsMdmFtp;

public class LmsMdmFtpRepository {

    private final Jdbi jdbi;

    public LmsMdmFtpRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LmsMdmFtp> getAllLmsMdmFtps() {
        return jdbi.withExtension(LmsMdmFtpDao.class, lmsmdmftpdao -> lmsmdmftpdao.findAll());
    }

    public Optional<LmsMdmFtp> getLmsMdmFtpById(java.time.LocalDateTime id) {
        return jdbi.withExtension(LmsMdmFtpDao.class, dao -> dao.findById(id));
    }

    public java.time.LocalDateTime createLmsMdmFtp(LmsMdmFtp entity) {
        return jdbi.withExtension(LmsMdmFtpDao.class, dao -> dao.insert(entity));
    }

    public int updateLmsMdmFtp(LmsMdmFtp entity) {
        return jdbi.withExtension(LmsMdmFtpDao.class, dao -> dao.update(entity));
    }

    public void deleteLmsMdmFtp(java.time.LocalDateTime id) {
        jdbi.useExtension(LmsMdmFtpDao.class, dao -> dao.delete(id));
    }
}
