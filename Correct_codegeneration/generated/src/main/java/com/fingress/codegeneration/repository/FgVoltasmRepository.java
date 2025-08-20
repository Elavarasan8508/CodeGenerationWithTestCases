package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgVoltasmDao;
import com.bsit.codegeneration.record.FgVoltasm;

public class FgVoltasmRepository {

    private final Jdbi jdbi;

    public FgVoltasmRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgVoltasm> getAllFgVoltasms() {
        return jdbi.withExtension(FgVoltasmDao.class, fgvoltasmdao -> fgvoltasmdao.findAll());
    }

    public Optional<FgVoltasm> getFgVoltasmById(String id) {
        return jdbi.withExtension(FgVoltasmDao.class, dao -> dao.findById(id));
    }

    public String createFgVoltasm(FgVoltasm entity) {
        return jdbi.withExtension(FgVoltasmDao.class, dao -> dao.insert(entity));
    }

    public int updateFgVoltasm(FgVoltasm entity) {
        return jdbi.withExtension(FgVoltasmDao.class, dao -> dao.update(entity));
    }

    public void deleteFgVoltasm(String id) {
        jdbi.useExtension(FgVoltasmDao.class, dao -> dao.delete(id));
    }
}
