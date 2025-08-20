package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgBankGuaranteeDao;
import com.bsit.codegeneration.record.FgBankGuarantee;

public class FgBankGuaranteeRepository {

    private final Jdbi jdbi;

    public FgBankGuaranteeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgBankGuarantee> getAllFgBankGuarantees() {
        return jdbi.withExtension(FgBankGuaranteeDao.class, fgbankguaranteedao -> fgbankguaranteedao.findAll());
    }

    public Optional<FgBankGuarantee> getFgBankGuaranteeById(String id) {
        return jdbi.withExtension(FgBankGuaranteeDao.class, dao -> dao.findById(id));
    }

    public String createFgBankGuarantee(FgBankGuarantee entity) {
        return jdbi.withExtension(FgBankGuaranteeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgBankGuarantee(FgBankGuarantee entity) {
        return jdbi.withExtension(FgBankGuaranteeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgBankGuarantee(String id) {
        jdbi.useExtension(FgBankGuaranteeDao.class, dao -> dao.delete(id));
    }
}
