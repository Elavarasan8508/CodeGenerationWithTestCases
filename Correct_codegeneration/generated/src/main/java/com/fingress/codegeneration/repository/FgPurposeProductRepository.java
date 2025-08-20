package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPurposeProductDao;
import com.bsit.codegeneration.record.FgPurposeProduct;

public class FgPurposeProductRepository {

    private final Jdbi jdbi;

    public FgPurposeProductRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPurposeProduct> getAllFgPurposeProducts() {
        return jdbi.withExtension(FgPurposeProductDao.class, fgpurposeproductdao -> fgpurposeproductdao.findAll());
    }

    public Optional<FgPurposeProduct> getFgPurposeProductById(Long id) {
        return jdbi.withExtension(FgPurposeProductDao.class, dao -> dao.findById(id));
    }

    public Long createFgPurposeProduct(FgPurposeProduct entity) {
        return jdbi.withExtension(FgPurposeProductDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPurposeProduct(FgPurposeProduct entity) {
        return jdbi.withExtension(FgPurposeProductDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPurposeProduct(Long id) {
        jdbi.useExtension(FgPurposeProductDao.class, dao -> dao.delete(id));
    }
}
