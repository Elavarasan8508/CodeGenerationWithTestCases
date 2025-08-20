package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAddressDao;
import com.bsit.codegeneration.record.FgAddress;

public class FgAddressRepository {

    private final Jdbi jdbi;

    public FgAddressRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAddress> getAllFgAddresss() {
        return jdbi.withExtension(FgAddressDao.class, fgaddressdao -> fgaddressdao.findAll());
    }

    public Optional<FgAddress> getFgAddressById(String id) {
        return jdbi.withExtension(FgAddressDao.class, dao -> dao.findById(id));
    }

    public String createFgAddress(FgAddress entity) {
        return jdbi.withExtension(FgAddressDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAddress(FgAddress entity) {
        return jdbi.withExtension(FgAddressDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAddress(String id) {
        jdbi.useExtension(FgAddressDao.class, dao -> dao.delete(id));
    }
}
