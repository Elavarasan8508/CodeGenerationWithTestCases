package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgVaultDao;
import com.bsit.codegeneration.record.FgVault;

public class FgVaultRepository {

    private final Jdbi jdbi;

    public FgVaultRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgVault> getAllFgVaults() {
        return jdbi.withExtension(FgVaultDao.class, fgvaultdao -> fgvaultdao.findAll());
    }

    public Optional<FgVault> getFgVaultById(Long id) {
        return jdbi.withExtension(FgVaultDao.class, dao -> dao.findById(id));
    }

    public Long createFgVault(FgVault entity) {
        return jdbi.withExtension(FgVaultDao.class, dao -> dao.insert(entity));
    }

    public int updateFgVault(FgVault entity) {
        return jdbi.withExtension(FgVaultDao.class, dao -> dao.update(entity));
    }

    public void deleteFgVault(Long id) {
        jdbi.useExtension(FgVaultDao.class, dao -> dao.delete(id));
    }
}
