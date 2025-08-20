package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModCmsSpaceDao;
import com.bsit.codegeneration.record.FgModCmsSpace;

public class FgModCmsSpaceRepository {

    private final Jdbi jdbi;

    public FgModCmsSpaceRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModCmsSpace> getAllFgModCmsSpaces() {
        return jdbi.withExtension(FgModCmsSpaceDao.class, fgmodcmsspacedao -> fgmodcmsspacedao.findAll());
    }

    public Optional<FgModCmsSpace> getFgModCmsSpaceById(Long id) {
        return jdbi.withExtension(FgModCmsSpaceDao.class, dao -> dao.findById(id));
    }

    public Long createFgModCmsSpace(FgModCmsSpace entity) {
        return jdbi.withExtension(FgModCmsSpaceDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModCmsSpace(FgModCmsSpace entity) {
        return jdbi.withExtension(FgModCmsSpaceDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModCmsSpace(Long id) {
        jdbi.useExtension(FgModCmsSpaceDao.class, dao -> dao.delete(id));
    }
}
