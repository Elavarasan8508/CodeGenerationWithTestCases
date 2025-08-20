package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyIdentificationDao;
import com.bsit.codegeneration.record.FgPartyIdentification;

public class FgPartyIdentificationRepository {

    private final Jdbi jdbi;

    public FgPartyIdentificationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyIdentification> getAllFgPartyIdentifications() {
        return jdbi.withExtension(FgPartyIdentificationDao.class, fgpartyidentificationdao -> fgpartyidentificationdao.findAll());
    }

    public Optional<FgPartyIdentification> getFgPartyIdentificationById(String id) {
        return jdbi.withExtension(FgPartyIdentificationDao.class, dao -> dao.findById(id));
    }

    public String createFgPartyIdentification(FgPartyIdentification entity) {
        return jdbi.withExtension(FgPartyIdentificationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyIdentification(FgPartyIdentification entity) {
        return jdbi.withExtension(FgPartyIdentificationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyIdentification(String id) {
        jdbi.useExtension(FgPartyIdentificationDao.class, dao -> dao.delete(id));
    }
}
