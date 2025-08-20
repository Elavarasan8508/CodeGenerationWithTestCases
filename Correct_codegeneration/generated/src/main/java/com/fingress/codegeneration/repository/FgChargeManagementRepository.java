package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgChargeManagementDao;
import com.bsit.codegeneration.record.FgChargeManagement;

public class FgChargeManagementRepository {

    private final Jdbi jdbi;

    public FgChargeManagementRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgChargeManagement> getAllFgChargeManagements() {
        return jdbi.withExtension(FgChargeManagementDao.class, fgchargemanagementdao -> fgchargemanagementdao.findAll());
    }

    public Optional<FgChargeManagement> getFgChargeManagementById(String id) {
        return jdbi.withExtension(FgChargeManagementDao.class, dao -> dao.findById(id));
    }

    public String createFgChargeManagement(FgChargeManagement entity) {
        return jdbi.withExtension(FgChargeManagementDao.class, dao -> dao.insert(entity));
    }

    public int updateFgChargeManagement(FgChargeManagement entity) {
        return jdbi.withExtension(FgChargeManagementDao.class, dao -> dao.update(entity));
    }

    public void deleteFgChargeManagement(String id) {
        jdbi.useExtension(FgChargeManagementDao.class, dao -> dao.delete(id));
    }
}
