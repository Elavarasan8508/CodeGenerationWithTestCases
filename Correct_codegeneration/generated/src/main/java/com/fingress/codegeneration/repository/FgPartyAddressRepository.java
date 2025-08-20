package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyAddressDao;
import com.bsit.codegeneration.record.FgPartyAddress;

public class FgPartyAddressRepository {

    private final Jdbi jdbi;

    public FgPartyAddressRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyAddress> getAllFgPartyAddresss() {
        return jdbi.withExtension(FgPartyAddressDao.class, fgpartyaddressdao -> fgpartyaddressdao.findAll());
    }

    public Optional<FgPartyAddress> getFgPartyAddressById(Long id) {
        return jdbi.withExtension(FgPartyAddressDao.class, dao -> dao.findById(id));
    }

    public Long createFgPartyAddress(FgPartyAddress entity) {
        return jdbi.withExtension(FgPartyAddressDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyAddress(FgPartyAddress entity) {
        return jdbi.withExtension(FgPartyAddressDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyAddress(Long id) {
        jdbi.useExtension(FgPartyAddressDao.class, dao -> dao.delete(id));
    }
}
