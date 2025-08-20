package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPersonDao;
import com.bsit.codegeneration.record.FgPerson;

public class FgPersonRepository {

    private final Jdbi jdbi;

    public FgPersonRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPerson> getAllFgPersons() {
        return jdbi.withExtension(FgPersonDao.class, fgpersondao -> fgpersondao.findAll());
    }

    public Optional<FgPerson> getFgPersonById(String id) {
        return jdbi.withExtension(FgPersonDao.class, dao -> dao.findById(id));
    }

    public String createFgPerson(FgPerson entity) {
        return jdbi.withExtension(FgPersonDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPerson(FgPerson entity) {
        return jdbi.withExtension(FgPersonDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPerson(String id) {
        jdbi.useExtension(FgPersonDao.class, dao -> dao.delete(id));
    }
}
