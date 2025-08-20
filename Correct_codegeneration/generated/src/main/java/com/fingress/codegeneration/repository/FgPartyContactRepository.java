package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyContactDao;
import com.bsit.codegeneration.record.FgPartyContact;

public class FgPartyContactRepository {

    private final Jdbi jdbi;

    public FgPartyContactRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyContact> getAllFgPartyContacts() {
        return jdbi.withExtension(FgPartyContactDao.class, fgpartycontactdao -> fgpartycontactdao.findAll());
    }

    public Optional<FgPartyContact> getFgPartyContactById(Long id) {
        return jdbi.withExtension(FgPartyContactDao.class, dao -> dao.findById(id));
    }

    public Long createFgPartyContact(FgPartyContact entity) {
        return jdbi.withExtension(FgPartyContactDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyContact(FgPartyContact entity) {
        return jdbi.withExtension(FgPartyContactDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyContact(Long id) {
        jdbi.useExtension(FgPartyContactDao.class, dao -> dao.delete(id));
    }
}
