package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyRegistrationDao;
import com.bsit.codegeneration.record.FgPartyRegistration;

public class FgPartyRegistrationRepository {

    private final Jdbi jdbi;

    public FgPartyRegistrationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyRegistration> getAllFgPartyRegistrations() {
        return jdbi.withExtension(FgPartyRegistrationDao.class, fgpartyregistrationdao -> fgpartyregistrationdao.findAll());
    }

    public Optional<FgPartyRegistration> getFgPartyRegistrationById(String id) {
        return jdbi.withExtension(FgPartyRegistrationDao.class, dao -> dao.findById(id));
    }

    public String createFgPartyRegistration(FgPartyRegistration entity) {
        return jdbi.withExtension(FgPartyRegistrationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyRegistration(FgPartyRegistration entity) {
        return jdbi.withExtension(FgPartyRegistrationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyRegistration(String id) {
        jdbi.useExtension(FgPartyRegistrationDao.class, dao -> dao.delete(id));
    }
}
