package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDmsTagDao;
import com.bsit.codegeneration.record.FgDmsTag;

public class FgDmsTagRepository {

    private final Jdbi jdbi;

    public FgDmsTagRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDmsTag> getAllFgDmsTags() {
        return jdbi.withExtension(FgDmsTagDao.class, fgdmstagdao -> fgdmstagdao.findAll());
    }

    public Optional<FgDmsTag> getFgDmsTagById(Long id) {
        return jdbi.withExtension(FgDmsTagDao.class, dao -> dao.findById(id));
    }

    public Long createFgDmsTag(FgDmsTag entity) {
        return jdbi.withExtension(FgDmsTagDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDmsTag(FgDmsTag entity) {
        return jdbi.withExtension(FgDmsTagDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDmsTag(Long id) {
        jdbi.useExtension(FgDmsTagDao.class, dao -> dao.delete(id));
    }
}
