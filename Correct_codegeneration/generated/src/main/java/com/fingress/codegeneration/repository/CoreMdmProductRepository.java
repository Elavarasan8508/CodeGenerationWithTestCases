package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.CoreMdmProductDao;
import com.bsit.codegeneration.record.CoreMdmProduct;

public class CoreMdmProductRepository {

    private final Jdbi jdbi;

    public CoreMdmProductRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<CoreMdmProduct> getAllCoreMdmProducts() {
        return jdbi.withExtension(CoreMdmProductDao.class, coremdmproductdao -> coremdmproductdao.findAll());
    }

    public Optional<CoreMdmProduct> getCoreMdmProductById(String id) {
        return jdbi.withExtension(CoreMdmProductDao.class, dao -> dao.findById(id));
    }

    public String createCoreMdmProduct(CoreMdmProduct entity) {
        return jdbi.withExtension(CoreMdmProductDao.class, dao -> dao.insert(entity));
    }

    public int updateCoreMdmProduct(CoreMdmProduct entity) {
        return jdbi.withExtension(CoreMdmProductDao.class, dao -> dao.update(entity));
    }

    public void deleteCoreMdmProduct(String id) {
        jdbi.useExtension(CoreMdmProductDao.class, dao -> dao.delete(id));
    }
}
