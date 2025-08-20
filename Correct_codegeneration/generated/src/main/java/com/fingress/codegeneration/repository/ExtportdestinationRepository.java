package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ExtportdestinationDao;
import com.bsit.codegeneration.record.Extportdestination;

public class ExtportdestinationRepository {

    private final Jdbi jdbi;

    public ExtportdestinationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Extportdestination> getAllExtportdestinations() {
        return jdbi.withExtension(ExtportdestinationDao.class, extportdestinationdao -> extportdestinationdao.findAll());
    }

    public Optional<Extportdestination> getExtportdestinationById(String id) {
        return jdbi.withExtension(ExtportdestinationDao.class, dao -> dao.findById(id));
    }

    public String createExtportdestination(Extportdestination entity) {
        return jdbi.withExtension(ExtportdestinationDao.class, dao -> dao.insert(entity));
    }

    public int updateExtportdestination(Extportdestination entity) {
        return jdbi.withExtension(ExtportdestinationDao.class, dao -> dao.update(entity));
    }

    public void deleteExtportdestination(String id) {
        jdbi.useExtension(ExtportdestinationDao.class, dao -> dao.delete(id));
    }
}
