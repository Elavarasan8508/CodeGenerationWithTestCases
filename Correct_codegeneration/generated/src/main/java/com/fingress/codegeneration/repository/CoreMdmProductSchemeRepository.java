package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.CoreMdmProductSchemeDao;
import com.bsit.codegeneration.record.CoreMdmProductScheme;

public class CoreMdmProductSchemeRepository {

    private final Jdbi jdbi;

    public CoreMdmProductSchemeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<CoreMdmProductScheme> getAllCoreMdmProductSchemes() {
        return jdbi.withExtension(CoreMdmProductSchemeDao.class, coremdmproductschemedao -> coremdmproductschemedao.findAll());
    }

    public Optional<CoreMdmProductScheme> getCoreMdmProductSchemeById(String id) {
        return jdbi.withExtension(CoreMdmProductSchemeDao.class, dao -> dao.findById(id));
    }

    public String createCoreMdmProductScheme(CoreMdmProductScheme entity) {
        return jdbi.withExtension(CoreMdmProductSchemeDao.class, dao -> dao.insert(entity));
    }

    public int updateCoreMdmProductScheme(CoreMdmProductScheme entity) {
        return jdbi.withExtension(CoreMdmProductSchemeDao.class, dao -> dao.update(entity));
    }

    public void deleteCoreMdmProductScheme(String id) {
        jdbi.useExtension(CoreMdmProductSchemeDao.class, dao -> dao.delete(id));
    }
}
