package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgOnlineImportDao;
import com.bsit.codegeneration.record.FgOnlineImport;

public class FgOnlineImportRepository {

    private final Jdbi jdbi;

    public FgOnlineImportRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgOnlineImport> getAllFgOnlineImports() {
        return jdbi.withExtension(FgOnlineImportDao.class, fgonlineimportdao -> fgonlineimportdao.findAll());
    }

    public Optional<FgOnlineImport> getFgOnlineImportById(String id) {
        return jdbi.withExtension(FgOnlineImportDao.class, dao -> dao.findById(id));
    }

    public String createFgOnlineImport(FgOnlineImport entity) {
        return jdbi.withExtension(FgOnlineImportDao.class, dao -> dao.insert(entity));
    }

    public int updateFgOnlineImport(FgOnlineImport entity) {
        return jdbi.withExtension(FgOnlineImportDao.class, dao -> dao.update(entity));
    }

    public void deleteFgOnlineImport(String id) {
        jdbi.useExtension(FgOnlineImportDao.class, dao -> dao.delete(id));
    }
}
