package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ShippingbilldataDao;
import com.bsit.codegeneration.record.Shippingbilldata;

public class ShippingbilldataRepository {

    private final Jdbi jdbi;

    public ShippingbilldataRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Shippingbilldata> getAllShippingbilldatas() {
        return jdbi.withExtension(ShippingbilldataDao.class, shippingbilldatadao -> shippingbilldatadao.findAll());
    }

    public Optional<Shippingbilldata> getShippingbilldataById(String id) {
        return jdbi.withExtension(ShippingbilldataDao.class, dao -> dao.findById(id));
    }

    public String createShippingbilldata(Shippingbilldata entity) {
        return jdbi.withExtension(ShippingbilldataDao.class, dao -> dao.insert(entity));
    }

    public int updateShippingbilldata(Shippingbilldata entity) {
        return jdbi.withExtension(ShippingbilldataDao.class, dao -> dao.update(entity));
    }

    public void deleteShippingbilldata(String id) {
        jdbi.useExtension(ShippingbilldataDao.class, dao -> dao.delete(id));
    }
}
