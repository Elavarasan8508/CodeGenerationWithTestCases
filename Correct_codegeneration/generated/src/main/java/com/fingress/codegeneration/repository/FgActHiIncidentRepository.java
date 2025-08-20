package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiIncidentDao;
import com.bsit.codegeneration.record.FgActHiIncident;

public class FgActHiIncidentRepository {

    private final Jdbi jdbi;

    public FgActHiIncidentRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiIncident> getAllFgActHiIncidents() {
        return jdbi.withExtension(FgActHiIncidentDao.class, fgacthiincidentdao -> fgacthiincidentdao.findAll());
    }

    public Optional<FgActHiIncident> getFgActHiIncidentById(String id) {
        return jdbi.withExtension(FgActHiIncidentDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiIncident(FgActHiIncident entity) {
        return jdbi.withExtension(FgActHiIncidentDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiIncident(FgActHiIncident entity) {
        return jdbi.withExtension(FgActHiIncidentDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiIncident(String id) {
        jdbi.useExtension(FgActHiIncidentDao.class, dao -> dao.delete(id));
    }
}
