package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuIncidentDao;
import com.bsit.codegeneration.record.FgActRuIncident;

public class FgActRuIncidentRepository {

    private final Jdbi jdbi;

    public FgActRuIncidentRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuIncident> getAllFgActRuIncidents() {
        return jdbi.withExtension(FgActRuIncidentDao.class, fgactruincidentdao -> fgactruincidentdao.findAll());
    }

    public Optional<FgActRuIncident> getFgActRuIncidentById(String id) {
        return jdbi.withExtension(FgActRuIncidentDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuIncident(FgActRuIncident entity) {
        return jdbi.withExtension(FgActRuIncidentDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuIncident(FgActRuIncident entity) {
        return jdbi.withExtension(FgActRuIncidentDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuIncident(String id) {
        jdbi.useExtension(FgActRuIncidentDao.class, dao -> dao.delete(id));
    }
}
