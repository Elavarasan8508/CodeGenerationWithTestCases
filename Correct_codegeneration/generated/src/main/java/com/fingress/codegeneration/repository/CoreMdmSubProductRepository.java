package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.CoreMdmSubProductDao;
import com.bsit.codegeneration.record.CoreMdmSubProduct;

public class CoreMdmSubProductRepository {

    private final Jdbi jdbi;

    public CoreMdmSubProductRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<CoreMdmSubProduct> getAllCoreMdmSubProducts() {
        return jdbi.withExtension(CoreMdmSubProductDao.class, coremdmsubproductdao -> coremdmsubproductdao.findAll());
    }

    public Optional<CoreMdmSubProduct> getCoreMdmSubProductById(String id) {
        return jdbi.withExtension(CoreMdmSubProductDao.class, dao -> dao.findById(id));
    }

    public String createCoreMdmSubProduct(CoreMdmSubProduct entity) {
        return jdbi.withExtension(CoreMdmSubProductDao.class, dao -> dao.insert(entity));
    }

    public int updateCoreMdmSubProduct(CoreMdmSubProduct entity) {
        return jdbi.withExtension(CoreMdmSubProductDao.class, dao -> dao.update(entity));
    }

    public void deleteCoreMdmSubProduct(String id) {
        jdbi.useExtension(CoreMdmSubProductDao.class, dao -> dao.delete(id));
    }
}
