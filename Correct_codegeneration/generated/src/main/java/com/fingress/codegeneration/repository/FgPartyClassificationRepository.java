package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyClassificationDao;
import com.bsit.codegeneration.record.FgPartyClassification;

public class FgPartyClassificationRepository {

    private final Jdbi jdbi;

    public FgPartyClassificationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyClassification> getAllFgPartyClassifications() {
        return jdbi.withExtension(FgPartyClassificationDao.class, fgpartyclassificationdao -> fgpartyclassificationdao.findAll());
    }

    public Optional<FgPartyClassification> getFgPartyClassificationById(String id) {
        return jdbi.withExtension(FgPartyClassificationDao.class, dao -> dao.findById(id));
    }

    public String createFgPartyClassification(FgPartyClassification entity) {
        return jdbi.withExtension(FgPartyClassificationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyClassification(FgPartyClassification entity) {
        return jdbi.withExtension(FgPartyClassificationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyClassification(String id) {
        jdbi.useExtension(FgPartyClassificationDao.class, dao -> dao.delete(id));
    }
}
