package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.CreditOfferPartyMapDao;
import com.bsit.codegeneration.record.CreditOfferPartyMap;

public class CreditOfferPartyMapRepository {

    private final Jdbi jdbi;

    public CreditOfferPartyMapRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<CreditOfferPartyMap> getAllCreditOfferPartyMaps() {
        return jdbi.withExtension(CreditOfferPartyMapDao.class, creditofferpartymapdao -> creditofferpartymapdao.findAll());
    }

    public Optional<CreditOfferPartyMap> getCreditOfferPartyMapById(Long id) {
        return jdbi.withExtension(CreditOfferPartyMapDao.class, dao -> dao.findById(id));
    }

    public Long createCreditOfferPartyMap(CreditOfferPartyMap entity) {
        return jdbi.withExtension(CreditOfferPartyMapDao.class, dao -> dao.insert(entity));
    }

    public int updateCreditOfferPartyMap(CreditOfferPartyMap entity) {
        return jdbi.withExtension(CreditOfferPartyMapDao.class, dao -> dao.update(entity));
    }

    public void deleteCreditOfferPartyMap(Long id) {
        jdbi.useExtension(CreditOfferPartyMapDao.class, dao -> dao.delete(id));
    }
}
