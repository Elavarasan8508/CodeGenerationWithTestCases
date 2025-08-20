package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ServicelogBkDao;
import com.bsit.codegeneration.record.ServicelogBk;

public class ServicelogBkRepository {

    private final Jdbi jdbi;

    public ServicelogBkRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<ServicelogBk> getAllServicelogBks() {
        return jdbi.withExtension(ServicelogBkDao.class, servicelogbkdao -> servicelogbkdao.findAll());
    }

    public Optional<ServicelogBk> getServicelogBkById(Long id) {
        return jdbi.withExtension(ServicelogBkDao.class, dao -> dao.findById(id));
    }

    public Long createServicelogBk(ServicelogBk entity) {
        return jdbi.withExtension(ServicelogBkDao.class, dao -> dao.insert(entity));
    }

    public int updateServicelogBk(ServicelogBk entity) {
        return jdbi.withExtension(ServicelogBkDao.class, dao -> dao.update(entity));
    }

    public void deleteServicelogBk(Long id) {
        jdbi.useExtension(ServicelogBkDao.class, dao -> dao.delete(id));
    }
}
