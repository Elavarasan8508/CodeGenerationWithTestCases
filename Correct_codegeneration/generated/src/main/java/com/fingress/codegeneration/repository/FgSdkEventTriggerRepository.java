package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSdkEventTriggerDao;
import com.bsit.codegeneration.record.FgSdkEventTrigger;

public class FgSdkEventTriggerRepository {

    private final Jdbi jdbi;

    public FgSdkEventTriggerRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSdkEventTrigger> getAllFgSdkEventTriggers() {
        return jdbi.withExtension(FgSdkEventTriggerDao.class, fgsdkeventtriggerdao -> fgsdkeventtriggerdao.findAll());
    }

    public Optional<FgSdkEventTrigger> getFgSdkEventTriggerById(String id) {
        return jdbi.withExtension(FgSdkEventTriggerDao.class, dao -> dao.findById(id));
    }

    public String createFgSdkEventTrigger(FgSdkEventTrigger entity) {
        return jdbi.withExtension(FgSdkEventTriggerDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSdkEventTrigger(FgSdkEventTrigger entity) {
        return jdbi.withExtension(FgSdkEventTriggerDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSdkEventTrigger(String id) {
        jdbi.useExtension(FgSdkEventTriggerDao.class, dao -> dao.delete(id));
    }
}
