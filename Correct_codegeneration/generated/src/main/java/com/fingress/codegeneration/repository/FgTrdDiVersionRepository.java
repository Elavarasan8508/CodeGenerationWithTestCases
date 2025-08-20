package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdDiVersionDao;
import com.bsit.codegeneration.record.FgTrdDiVersion;

public class FgTrdDiVersionRepository {

    private final Jdbi jdbi;

    public FgTrdDiVersionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdDiVersion> getAllFgTrdDiVersions() {
        return jdbi.withExtension(FgTrdDiVersionDao.class, fgtrddiversiondao -> fgtrddiversiondao.findAll());
    }

    public Optional<FgTrdDiVersion> getFgTrdDiVersionById(Long id) {
        return jdbi.withExtension(FgTrdDiVersionDao.class, dao -> dao.findById(id));
    }

    public Long createFgTrdDiVersion(FgTrdDiVersion entity) {
        return jdbi.withExtension(FgTrdDiVersionDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdDiVersion(FgTrdDiVersion entity) {
        return jdbi.withExtension(FgTrdDiVersionDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdDiVersion(Long id) {
        jdbi.useExtension(FgTrdDiVersionDao.class, dao -> dao.delete(id));
    }
}
