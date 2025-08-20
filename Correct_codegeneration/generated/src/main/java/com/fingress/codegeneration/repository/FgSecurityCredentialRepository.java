package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSecurityCredentialDao;
import com.bsit.codegeneration.record.FgSecurityCredential;

public class FgSecurityCredentialRepository {

    private final Jdbi jdbi;

    public FgSecurityCredentialRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSecurityCredential> getAllFgSecurityCredentials() {
        return jdbi.withExtension(FgSecurityCredentialDao.class, fgsecuritycredentialdao -> fgsecuritycredentialdao.findAll());
    }

    public Optional<FgSecurityCredential> getFgSecurityCredentialById(String id) {
        return jdbi.withExtension(FgSecurityCredentialDao.class, dao -> dao.findById(id));
    }

    public String createFgSecurityCredential(FgSecurityCredential entity) {
        return jdbi.withExtension(FgSecurityCredentialDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSecurityCredential(FgSecurityCredential entity) {
        return jdbi.withExtension(FgSecurityCredentialDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSecurityCredential(String id) {
        jdbi.useExtension(FgSecurityCredentialDao.class, dao -> dao.delete(id));
    }
}
