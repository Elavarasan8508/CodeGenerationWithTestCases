package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.CoreProductPartyMapDao;
import com.bsit.codegeneration.record.CoreProductPartyMap;

public class CoreProductPartyMapRepository {

    private final Jdbi jdbi;

    public CoreProductPartyMapRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<CoreProductPartyMap> getAllCoreProductPartyMaps() {
        return jdbi.withExtension(CoreProductPartyMapDao.class, coreproductpartymapdao -> coreproductpartymapdao.findAll());
    }

    public Optional<CoreProductPartyMap> getCoreProductPartyMapById(String id) {
        return jdbi.withExtension(CoreProductPartyMapDao.class, dao -> dao.findById(id));
    }

    public String createCoreProductPartyMap(CoreProductPartyMap entity) {
        return jdbi.withExtension(CoreProductPartyMapDao.class, dao -> dao.insert(entity));
    }

    public int updateCoreProductPartyMap(CoreProductPartyMap entity) {
        return jdbi.withExtension(CoreProductPartyMapDao.class, dao -> dao.update(entity));
    }

    public void deleteCoreProductPartyMap(String id) {
        jdbi.useExtension(CoreProductPartyMapDao.class, dao -> dao.delete(id));
    }
}
