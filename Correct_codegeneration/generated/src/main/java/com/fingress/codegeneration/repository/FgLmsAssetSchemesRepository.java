package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLmsAssetSchemesDao;
import com.bsit.codegeneration.record.FgLmsAssetSchemes;

public class FgLmsAssetSchemesRepository {

    private final Jdbi jdbi;

    public FgLmsAssetSchemesRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLmsAssetSchemes> getAllFgLmsAssetSchemess() {
        return jdbi.withExtension(FgLmsAssetSchemesDao.class, fglmsassetschemesdao -> fglmsassetschemesdao.findAll());
    }

    public Optional<FgLmsAssetSchemes> getFgLmsAssetSchemesById(java.time.LocalDateTime id) {
        return jdbi.withExtension(FgLmsAssetSchemesDao.class, dao -> dao.findById(id));
    }

    public java.time.LocalDateTime createFgLmsAssetSchemes(FgLmsAssetSchemes entity) {
        return jdbi.withExtension(FgLmsAssetSchemesDao.class, dao -> dao.insert(entity));
    }

    public int updateFgLmsAssetSchemes(FgLmsAssetSchemes entity) {
        return jdbi.withExtension(FgLmsAssetSchemesDao.class, dao -> dao.update(entity));
    }

    public void deleteFgLmsAssetSchemes(java.time.LocalDateTime id) {
        jdbi.useExtension(FgLmsAssetSchemesDao.class, dao -> dao.delete(id));
    }
}
