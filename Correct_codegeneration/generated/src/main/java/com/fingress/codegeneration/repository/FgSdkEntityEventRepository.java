package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkEntityEventDao;
import com.bsit.codegeneration.record.FgSdkEntityEvent;

public class FgSdkEntityEventRepository {

    private final Jdbi jdbi;

    public FgSdkEntityEventRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkEntityEvent> getAllFgSdkEntityEvents() {
        return jdbi.withExtension(FgSdkEntityEventDao.class, fgsdkentityeventdao -> fgsdkentityeventdao.findAll());
    }

    public Optional<FgSdkEntityEvent> getFgSdkEntityEventById(String id) {
        return jdbi.withExtension(FgSdkEntityEventDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkEntityEvent(FgSdkEntityEvent entity) {
        return jdbi.withExtension(FgSdkEntityEventDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkEntityEvent(FgSdkEntityEvent entity) {
        return jdbi.withExtension(FgSdkEntityEventDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkEntityEvent(String id) {
        jdbi.useExtension(FgSdkEntityEventDao.class, dao -> dao.delete(id));
    }
}
