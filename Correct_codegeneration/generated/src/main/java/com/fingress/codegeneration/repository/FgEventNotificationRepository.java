package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgEventNotificationDao;
import com.bsit.codegeneration.record.FgEventNotification;

public class FgEventNotificationRepository {

    private final Jdbi jdbi;

    public FgEventNotificationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgEventNotification> getAllFgEventNotifications() {
        return jdbi.withExtension(FgEventNotificationDao.class, fgeventnotificationdao -> fgeventnotificationdao.findAll());
    }

    public Optional<FgEventNotification> getFgEventNotificationById(Long id) {
        return jdbi.withExtension(FgEventNotificationDao.class, dao -> dao.findById(id));
    }

    public Long createFgEventNotification(FgEventNotification entity) {
        return jdbi.withExtension(FgEventNotificationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgEventNotification(FgEventNotification entity) {
        return jdbi.withExtension(FgEventNotificationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgEventNotification(Long id) {
        jdbi.useExtension(FgEventNotificationDao.class, dao -> dao.delete(id));
    }
}
