package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdItTypeMasterDao;
import com.bsit.codegeneration.record.FgTdItTypeMaster;

public class FgTdItTypeMasterRepository {

    private final Jdbi jdbi;

    public FgTdItTypeMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdItTypeMaster> getAllFgTdItTypeMasters() {
        return jdbi.withExtension(FgTdItTypeMasterDao.class, fgtdittypemasterdao -> fgtdittypemasterdao.findAll());
    }

    public Optional<FgTdItTypeMaster> getFgTdItTypeMasterById(String id) {
        return jdbi.withExtension(FgTdItTypeMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgTdItTypeMaster(FgTdItTypeMaster entity) {
        return jdbi.withExtension(FgTdItTypeMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdItTypeMaster(FgTdItTypeMaster entity) {
        return jdbi.withExtension(FgTdItTypeMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdItTypeMaster(String id) {
        jdbi.useExtension(FgTdItTypeMasterDao.class, dao -> dao.delete(id));
    }
}
