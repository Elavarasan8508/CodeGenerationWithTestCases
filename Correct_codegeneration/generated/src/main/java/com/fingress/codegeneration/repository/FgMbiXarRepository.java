package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgMbiXarDao;
import com.bsit.codegeneration.record.FgMbiXar;

public class FgMbiXarRepository {

    private final Jdbi jdbi;

    public FgMbiXarRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgMbiXar> getAllFgMbiXars() {
        return jdbi.withExtension(FgMbiXarDao.class, fgmbixardao -> fgmbixardao.findAll());
    }

    public Optional<FgMbiXar> getFgMbiXarById(String id) {
        return jdbi.withExtension(FgMbiXarDao.class, dao -> dao.findById(id));
    }

    public String createFgMbiXar(FgMbiXar entity) {
        return jdbi.withExtension(FgMbiXarDao.class, dao -> dao.insert(entity));
    }

    public int updateFgMbiXar(FgMbiXar entity) {
        return jdbi.withExtension(FgMbiXarDao.class, dao -> dao.update(entity));
    }

    public void deleteFgMbiXar(String id) {
        jdbi.useExtension(FgMbiXarDao.class, dao -> dao.delete(id));
    }
}
