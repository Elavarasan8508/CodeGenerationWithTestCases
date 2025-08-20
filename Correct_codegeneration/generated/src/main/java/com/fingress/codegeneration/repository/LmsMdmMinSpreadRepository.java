package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LmsMdmMinSpreadDao;
import com.bsit.codegeneration.record.LmsMdmMinSpread;

public class LmsMdmMinSpreadRepository {

    private final Jdbi jdbi;

    public LmsMdmMinSpreadRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LmsMdmMinSpread> getAllLmsMdmMinSpreads() {
        return jdbi.withExtension(LmsMdmMinSpreadDao.class, lmsmdmminspreaddao -> lmsmdmminspreaddao.findAll());
    }

    public Optional<LmsMdmMinSpread> getLmsMdmMinSpreadById(String id) {
        return jdbi.withExtension(LmsMdmMinSpreadDao.class, dao -> dao.findById(id));
    }

    public String createLmsMdmMinSpread(LmsMdmMinSpread entity) {
        return jdbi.withExtension(LmsMdmMinSpreadDao.class, dao -> dao.insert(entity));
    }

    public int updateLmsMdmMinSpread(LmsMdmMinSpread entity) {
        return jdbi.withExtension(LmsMdmMinSpreadDao.class, dao -> dao.update(entity));
    }

    public void deleteLmsMdmMinSpread(String id) {
        jdbi.useExtension(LmsMdmMinSpreadDao.class, dao -> dao.delete(id));
    }
}
