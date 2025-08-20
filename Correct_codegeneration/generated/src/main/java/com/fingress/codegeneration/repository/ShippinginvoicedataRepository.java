package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ShippinginvoicedataDao;
import com.bsit.codegeneration.record.Shippinginvoicedata;

public class ShippinginvoicedataRepository {

    private final Jdbi jdbi;

    public ShippinginvoicedataRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Shippinginvoicedata> getAllShippinginvoicedatas() {
        return jdbi.withExtension(ShippinginvoicedataDao.class, shippinginvoicedatadao -> shippinginvoicedatadao.findAll());
    }

    public Optional<Shippinginvoicedata> getShippinginvoicedataById(String id) {
        return jdbi.withExtension(ShippinginvoicedataDao.class, dao -> dao.findById(id));
    }

    public String createShippinginvoicedata(Shippinginvoicedata entity) {
        return jdbi.withExtension(ShippinginvoicedataDao.class, dao -> dao.insert(entity));
    }

    public int updateShippinginvoicedata(Shippinginvoicedata entity) {
        return jdbi.withExtension(ShippinginvoicedataDao.class, dao -> dao.update(entity));
    }

    public void deleteShippinginvoicedata(String id) {
        jdbi.useExtension(ShippinginvoicedataDao.class, dao -> dao.delete(id));
    }
}
