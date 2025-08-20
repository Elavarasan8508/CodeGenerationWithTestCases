package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgChetakImportDao;
import com.bsit.codegeneration.record.FgChetakImport;

public class FgChetakImportRepository {

    private final Jdbi jdbi;

    public FgChetakImportRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgChetakImport> getAllFgChetakImports() {
        return jdbi.withExtension(FgChetakImportDao.class, fgchetakimportdao -> fgchetakimportdao.findAll());
    }

    public Optional<FgChetakImport> getFgChetakImportById(String id) {
        return jdbi.withExtension(FgChetakImportDao.class, dao -> dao.findById(id));
    }

    public String createFgChetakImport(FgChetakImport entity) {
        return jdbi.withExtension(FgChetakImportDao.class, dao -> dao.insert(entity));
    }

    public int updateFgChetakImport(FgChetakImport entity) {
        return jdbi.withExtension(FgChetakImportDao.class, dao -> dao.update(entity));
    }

    public void deleteFgChetakImport(String id) {
        jdbi.useExtension(FgChetakImportDao.class, dao -> dao.delete(id));
    }
}
