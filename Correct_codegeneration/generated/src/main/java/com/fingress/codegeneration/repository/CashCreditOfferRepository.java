package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.CashCreditOfferDao;
import com.bsit.codegeneration.record.CashCreditOffer;

public class CashCreditOfferRepository {

    private final Jdbi jdbi;

    public CashCreditOfferRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<CashCreditOffer> getAllCashCreditOffers() {
        return jdbi.withExtension(CashCreditOfferDao.class, cashcreditofferdao -> cashcreditofferdao.findAll());
    }

    public Optional<CashCreditOffer> getCashCreditOfferById(String id) {
        return jdbi.withExtension(CashCreditOfferDao.class, dao -> dao.findById(id));
    }

    public String createCashCreditOffer(CashCreditOffer entity) {
        return jdbi.withExtension(CashCreditOfferDao.class, dao -> dao.insert(entity));
    }

    public int updateCashCreditOffer(CashCreditOffer entity) {
        return jdbi.withExtension(CashCreditOfferDao.class, dao -> dao.update(entity));
    }

    public void deleteCashCreditOffer(String id) {
        jdbi.useExtension(CashCreditOfferDao.class, dao -> dao.delete(id));
    }
}
