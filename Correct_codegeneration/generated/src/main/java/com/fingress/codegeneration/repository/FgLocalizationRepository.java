package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLocalizationDao;
import com.bsit.codegeneration.record.FgLocalization;

public class FgLocalizationRepository {

    private final Jdbi jdbi;

    public FgLocalizationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLocalization> getAllFgLocalizations() {
        return jdbi.withExtension(FgLocalizationDao.class, fglocalizationdao -> fglocalizationdao.findAll());
    }

    public Optional<FgLocalization> getFgLocalizationById(Long id) {
        return jdbi.withExtension(FgLocalizationDao.class, dao -> dao.findById(id));
    }

    public Long createFgLocalization(FgLocalization entity) {
        return jdbi.withExtension(FgLocalizationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgLocalization(FgLocalization entity) {
        return jdbi.withExtension(FgLocalizationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgLocalization(Long id) {
        jdbi.useExtension(FgLocalizationDao.class, dao -> dao.delete(id));
    }
}
