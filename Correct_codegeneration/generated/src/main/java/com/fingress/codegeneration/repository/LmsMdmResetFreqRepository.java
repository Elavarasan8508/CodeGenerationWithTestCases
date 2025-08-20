package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LmsMdmResetFreqDao;
import com.bsit.codegeneration.record.LmsMdmResetFreq;

public class LmsMdmResetFreqRepository {

    private final Jdbi jdbi;

    public LmsMdmResetFreqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LmsMdmResetFreq> getAllLmsMdmResetFreqs() {
        return jdbi.withExtension(LmsMdmResetFreqDao.class, lmsmdmresetfreqdao -> lmsmdmresetfreqdao.findAll());
    }

    public Optional<LmsMdmResetFreq> getLmsMdmResetFreqById(String id) {
        return jdbi.withExtension(LmsMdmResetFreqDao.class, dao -> dao.findById(id));
    }

    public String createLmsMdmResetFreq(LmsMdmResetFreq entity) {
        return jdbi.withExtension(LmsMdmResetFreqDao.class, dao -> dao.insert(entity));
    }

    public int updateLmsMdmResetFreq(LmsMdmResetFreq entity) {
        return jdbi.withExtension(LmsMdmResetFreqDao.class, dao -> dao.update(entity));
    }

    public void deleteLmsMdmResetFreq(String id) {
        jdbi.useExtension(LmsMdmResetFreqDao.class, dao -> dao.delete(id));
    }
}
