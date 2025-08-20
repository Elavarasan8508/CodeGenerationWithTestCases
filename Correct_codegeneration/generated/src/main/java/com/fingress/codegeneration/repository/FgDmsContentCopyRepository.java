package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDmsContentCopyDao;
import com.bsit.codegeneration.record.FgDmsContentCopy;

public class FgDmsContentCopyRepository {

    private final Jdbi jdbi;

    public FgDmsContentCopyRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDmsContentCopy> getAllFgDmsContentCopys() {
        return jdbi.withExtension(FgDmsContentCopyDao.class, fgdmscontentcopydao -> fgdmscontentcopydao.findAll());
    }

    public Optional<FgDmsContentCopy> getFgDmsContentCopyById(Long id) {
        return jdbi.withExtension(FgDmsContentCopyDao.class, dao -> dao.findById(id));
    }

    public Long createFgDmsContentCopy(FgDmsContentCopy entity) {
        return jdbi.withExtension(FgDmsContentCopyDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDmsContentCopy(FgDmsContentCopy entity) {
        return jdbi.withExtension(FgDmsContentCopyDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDmsContentCopy(Long id) {
        jdbi.useExtension(FgDmsContentCopyDao.class, dao -> dao.delete(id));
    }
}
