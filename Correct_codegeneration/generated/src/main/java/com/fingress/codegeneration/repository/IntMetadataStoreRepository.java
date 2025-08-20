package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.IntMetadataStoreDao;
import com.bsit.codegeneration.record.IntMetadataStore;

public class IntMetadataStoreRepository {

    private final Jdbi jdbi;

    public IntMetadataStoreRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<IntMetadataStore> getAllIntMetadataStores() {
        return jdbi.withExtension(IntMetadataStoreDao.class, intmetadatastoredao -> intmetadatastoredao.findAll());
    }

    public Optional<IntMetadataStore> getIntMetadataStoreById(String id) {
        return jdbi.withExtension(IntMetadataStoreDao.class, dao -> dao.findById(id));
    }

    public String createIntMetadataStore(IntMetadataStore entity) {
        return jdbi.withExtension(IntMetadataStoreDao.class, dao -> dao.insert(entity));
    }

    public int updateIntMetadataStore(IntMetadataStore entity) {
        return jdbi.withExtension(IntMetadataStoreDao.class, dao -> dao.update(entity));
    }

    public void deleteIntMetadataStore(String id) {
        jdbi.useExtension(IntMetadataStoreDao.class, dao -> dao.delete(id));
    }
}
