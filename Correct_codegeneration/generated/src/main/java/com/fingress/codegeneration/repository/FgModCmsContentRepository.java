package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModCmsContentDao;
import com.bsit.codegeneration.record.FgModCmsContent;

public class FgModCmsContentRepository {

    private final Jdbi jdbi;

    public FgModCmsContentRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModCmsContent> getAllFgModCmsContents() {
        return jdbi.withExtension(FgModCmsContentDao.class, fgmodcmscontentdao -> fgmodcmscontentdao.findAll());
    }

    public Optional<FgModCmsContent> getFgModCmsContentById(String id) {
        return jdbi.withExtension(FgModCmsContentDao.class, dao -> dao.findById(id));
    }

    public String createFgModCmsContent(FgModCmsContent entity) {
        return jdbi.withExtension(FgModCmsContentDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModCmsContent(FgModCmsContent entity) {
        return jdbi.withExtension(FgModCmsContentDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModCmsContent(String id) {
        jdbi.useExtension(FgModCmsContentDao.class, dao -> dao.delete(id));
    }
}
