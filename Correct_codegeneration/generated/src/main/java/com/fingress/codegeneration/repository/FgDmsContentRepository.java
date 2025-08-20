package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDmsContentDao;
import com.bsit.codegeneration.record.FgDmsContent;

public class FgDmsContentRepository {

    private final Jdbi jdbi;

    public FgDmsContentRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDmsContent> getAllFgDmsContents() {
        return jdbi.withExtension(FgDmsContentDao.class, fgdmscontentdao -> fgdmscontentdao.findAll());
    }

    public Optional<FgDmsContent> getFgDmsContentById(Long id) {
        return jdbi.withExtension(FgDmsContentDao.class, dao -> dao.findById(id));
    }

    public Long createFgDmsContent(FgDmsContent entity) {
        return jdbi.withExtension(FgDmsContentDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDmsContent(FgDmsContent entity) {
        return jdbi.withExtension(FgDmsContentDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDmsContent(Long id) {
        jdbi.useExtension(FgDmsContentDao.class, dao -> dao.delete(id));
    }
}
