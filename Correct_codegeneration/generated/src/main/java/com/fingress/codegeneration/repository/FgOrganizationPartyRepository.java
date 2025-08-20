package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgOrganizationPartyDao;
import com.bsit.codegeneration.record.FgOrganizationParty;

public class FgOrganizationPartyRepository {

    private final Jdbi jdbi;

    public FgOrganizationPartyRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgOrganizationParty> getAllFgOrganizationPartys() {
        return jdbi.withExtension(FgOrganizationPartyDao.class, fgorganizationpartydao -> fgorganizationpartydao.findAll());
    }

    public Optional<FgOrganizationParty> getFgOrganizationPartyById(String id) {
        return jdbi.withExtension(FgOrganizationPartyDao.class, dao -> dao.findById(id));
    }

    public String createFgOrganizationParty(FgOrganizationParty entity) {
        return jdbi.withExtension(FgOrganizationPartyDao.class, dao -> dao.insert(entity));
    }

    public int updateFgOrganizationParty(FgOrganizationParty entity) {
        return jdbi.withExtension(FgOrganizationPartyDao.class, dao -> dao.update(entity));
    }

    public void deleteFgOrganizationParty(String id) {
        jdbi.useExtension(FgOrganizationPartyDao.class, dao -> dao.delete(id));
    }
}
