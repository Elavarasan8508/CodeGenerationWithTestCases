package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ScfFileTxnDao;
import com.bsit.codegeneration.record.ScfFileTxn;

public class ScfFileTxnRepository {

    private final Jdbi jdbi;

    public ScfFileTxnRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<ScfFileTxn> getAllScfFileTxns() {
        return jdbi.withExtension(ScfFileTxnDao.class, scffiletxndao -> scffiletxndao.findAll());
    }

    public Optional<ScfFileTxn> getScfFileTxnById(String id) {
        return jdbi.withExtension(ScfFileTxnDao.class, dao -> dao.findById(id));
    }

    public String createScfFileTxn(ScfFileTxn entity) {
        return jdbi.withExtension(ScfFileTxnDao.class, dao -> dao.insert(entity));
    }

    public int updateScfFileTxn(ScfFileTxn entity) {
        return jdbi.withExtension(ScfFileTxnDao.class, dao -> dao.update(entity));
    }

    public void deleteScfFileTxn(String id) {
        jdbi.useExtension(ScfFileTxnDao.class, dao -> dao.delete(id));
    }
}
