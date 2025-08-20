package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModEiFileDao;
import com.bsit.codegeneration.record.FgModEiFile;

public class FgModEiFileRepository {

    private final Jdbi jdbi;

    public FgModEiFileRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModEiFile> getAllFgModEiFiles() {
        return jdbi.withExtension(FgModEiFileDao.class, fgmodeifiledao -> fgmodeifiledao.findAll());
    }

    public Optional<FgModEiFile> getFgModEiFileById(Long id) {
        return jdbi.withExtension(FgModEiFileDao.class, dao -> dao.findById(id));
    }

    public Long createFgModEiFile(FgModEiFile entity) {
        return jdbi.withExtension(FgModEiFileDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModEiFile(FgModEiFile entity) {
        return jdbi.withExtension(FgModEiFileDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModEiFile(Long id) {
        jdbi.useExtension(FgModEiFileDao.class, dao -> dao.delete(id));
    }
}
