package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.IvsDao;
import com.bsit.codegeneration.record.Ivs;

public class IvsRepository {

    private final Jdbi jdbi;

    public IvsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Ivs> getAllIvss() {
        return jdbi.withExtension(IvsDao.class, ivsdao -> ivsdao.findAll());
    }

    public Optional<Ivs> getIvsById(Long id) {
        return jdbi.withExtension(IvsDao.class, dao -> dao.findById(id));
    }

    public Long createIvs(Ivs entity) {
        return jdbi.withExtension(IvsDao.class, dao -> dao.insert(entity));
    }

    public int updateIvs(Ivs entity) {
        return jdbi.withExtension(IvsDao.class, dao -> dao.update(entity));
    }

    public void deleteIvs(Long id) {
        jdbi.useExtension(IvsDao.class, dao -> dao.delete(id));
    }
}
