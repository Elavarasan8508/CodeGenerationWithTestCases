package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.APIOutstandingBoeDetailDao;
import com.bsit.codegeneration.record.APIOutstandingBoeDetail;

public class APIOutstandingBoeDetailRepository {

    private final Jdbi jdbi;

    public APIOutstandingBoeDetailRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<APIOutstandingBoeDetail> getAllAPIOutstandingBoeDetails() {
        return jdbi.withExtension(APIOutstandingBoeDetailDao.class, apioutstandingboedetaildao -> apioutstandingboedetaildao.findAll());
    }

    public Optional<APIOutstandingBoeDetail> getAPIOutstandingBoeDetailById(String id) {
        return jdbi.withExtension(APIOutstandingBoeDetailDao.class, dao -> dao.findById(id));
    }

    public String createAPIOutstandingBoeDetail(APIOutstandingBoeDetail entity) {
        return jdbi.withExtension(APIOutstandingBoeDetailDao.class, dao -> dao.insert(entity));
    }

    public int updateAPIOutstandingBoeDetail(APIOutstandingBoeDetail entity) {
        return jdbi.withExtension(APIOutstandingBoeDetailDao.class, dao -> dao.update(entity));
    }

    public void deleteAPIOutstandingBoeDetail(String id) {
        jdbi.useExtension(APIOutstandingBoeDetailDao.class, dao -> dao.delete(id));
    }
}
