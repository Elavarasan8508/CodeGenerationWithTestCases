package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLmsDelinquencySchemeDao;
import com.bsit.codegeneration.record.FgLmsDelinquencyScheme;

public class FgLmsDelinquencySchemeRepository {

    private final Jdbi jdbi;

    public FgLmsDelinquencySchemeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLmsDelinquencyScheme> getAllFgLmsDelinquencySchemes() {
        return jdbi.withExtension(FgLmsDelinquencySchemeDao.class, fglmsdelinquencyschemedao -> fglmsdelinquencyschemedao.findAll());
    }

    public Optional<FgLmsDelinquencyScheme> getFgLmsDelinquencySchemeById(Long id) {
        return jdbi.withExtension(FgLmsDelinquencySchemeDao.class, dao -> dao.findById(id));
    }

    public Long createFgLmsDelinquencyScheme(FgLmsDelinquencyScheme entity) {
        return jdbi.withExtension(FgLmsDelinquencySchemeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgLmsDelinquencyScheme(FgLmsDelinquencyScheme entity) {
        return jdbi.withExtension(FgLmsDelinquencySchemeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgLmsDelinquencyScheme(Long id) {
        jdbi.useExtension(FgLmsDelinquencySchemeDao.class, dao -> dao.delete(id));
    }
}
