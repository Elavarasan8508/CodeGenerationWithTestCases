package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.QrtzCalendarsDao;
import com.bsit.codegeneration.record.QrtzCalendars;

public class QrtzCalendarsRepository {

    private final Jdbi jdbi;

    public QrtzCalendarsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<QrtzCalendars> getAllQrtzCalendarss() {
        return jdbi.withExtension(QrtzCalendarsDao.class, qrtzcalendarsdao -> qrtzcalendarsdao.findAll());
    }

    public Optional<QrtzCalendars> getQrtzCalendarsById(String id) {
        return jdbi.withExtension(QrtzCalendarsDao.class, dao -> dao.findById(id));
    }

    public String createQrtzCalendars(QrtzCalendars entity) {
        return jdbi.withExtension(QrtzCalendarsDao.class, dao -> dao.insert(entity));
    }

    public int updateQrtzCalendars(QrtzCalendars entity) {
        return jdbi.withExtension(QrtzCalendarsDao.class, dao -> dao.update(entity));
    }

    public void deleteQrtzCalendars(String id) {
        jdbi.useExtension(QrtzCalendarsDao.class, dao -> dao.delete(id));
    }
}
