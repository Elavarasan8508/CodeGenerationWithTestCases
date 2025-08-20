package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgExpMbiXarDao;
import com.bsit.codegeneration.record.FgExpMbiXar;

public class FgExpMbiXarRepository {

    private final Jdbi jdbi;

    public FgExpMbiXarRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgExpMbiXar> getAllFgExpMbiXars() {
        return jdbi.withExtension(FgExpMbiXarDao.class, fgexpmbixardao -> fgexpmbixardao.findAll());
    }

    public Optional<FgExpMbiXar> getFgExpMbiXarById(Long id) {
        return jdbi.withExtension(FgExpMbiXarDao.class, dao -> dao.findById(id));
    }

    public Long createFgExpMbiXar(FgExpMbiXar entity) {
        return jdbi.withExtension(FgExpMbiXarDao.class, dao -> dao.insert(entity));
    }

    public int updateFgExpMbiXar(FgExpMbiXar entity) {
        return jdbi.withExtension(FgExpMbiXarDao.class, dao -> dao.update(entity));
    }

    public void deleteFgExpMbiXar(Long id) {
        jdbi.useExtension(FgExpMbiXarDao.class, dao -> dao.delete(id));
    }
}
