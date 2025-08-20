package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAlertCodeDao;
import com.bsit.codegeneration.record.FgAlertCode;

public class FgAlertCodeRepository {

    private final Jdbi jdbi;

    public FgAlertCodeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAlertCode> getAllFgAlertCodes() {
        return jdbi.withExtension(FgAlertCodeDao.class, fgalertcodedao -> fgalertcodedao.findAll());
    }

    public Optional<FgAlertCode> getFgAlertCodeById(String id) {
        return jdbi.withExtension(FgAlertCodeDao.class, dao -> dao.findById(id));
    }

    public String createFgAlertCode(FgAlertCode entity) {
        return jdbi.withExtension(FgAlertCodeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAlertCode(FgAlertCode entity) {
        return jdbi.withExtension(FgAlertCodeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAlertCode(String id) {
        jdbi.useExtension(FgAlertCodeDao.class, dao -> dao.delete(id));
    }
}
