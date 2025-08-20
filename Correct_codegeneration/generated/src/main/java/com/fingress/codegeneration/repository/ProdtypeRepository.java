package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ProdtypeDao;
import com.bsit.codegeneration.record.Prodtype;

public class ProdtypeRepository {

    private final Jdbi jdbi;

    public ProdtypeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Prodtype> getAllProdtypes() {
        return jdbi.withExtension(ProdtypeDao.class, prodtypedao -> prodtypedao.findAll());
    }

    public Optional<Prodtype> getProdtypeById(String id) {
        return jdbi.withExtension(ProdtypeDao.class, dao -> dao.findById(id));
    }

    public String createProdtype(Prodtype entity) {
        return jdbi.withExtension(ProdtypeDao.class, dao -> dao.insert(entity));
    }

    public int updateProdtype(Prodtype entity) {
        return jdbi.withExtension(ProdtypeDao.class, dao -> dao.update(entity));
    }

    public void deleteProdtype(String id) {
        jdbi.useExtension(ProdtypeDao.class, dao -> dao.delete(id));
    }
}
