package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.APIOutstandingIrmDetailDao;
import com.bsit.codegeneration.record.APIOutstandingIrmDetail;

public class APIOutstandingIrmDetailRepository {

    private final Jdbi jdbi;

    public APIOutstandingIrmDetailRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<APIOutstandingIrmDetail> getAllAPIOutstandingIrmDetails() {
        return jdbi.withExtension(APIOutstandingIrmDetailDao.class, apioutstandingirmdetaildao -> apioutstandingirmdetaildao.findAll());
    }

    public Optional<APIOutstandingIrmDetail> getAPIOutstandingIrmDetailById(String id) {
        return jdbi.withExtension(APIOutstandingIrmDetailDao.class, dao -> dao.findById(id));
    }

    public String createAPIOutstandingIrmDetail(APIOutstandingIrmDetail entity) {
        return jdbi.withExtension(APIOutstandingIrmDetailDao.class, dao -> dao.insert(entity));
    }

    public int updateAPIOutstandingIrmDetail(APIOutstandingIrmDetail entity) {
        return jdbi.withExtension(APIOutstandingIrmDetailDao.class, dao -> dao.update(entity));
    }

    public void deleteAPIOutstandingIrmDetail(String id) {
        jdbi.useExtension(APIOutstandingIrmDetailDao.class, dao -> dao.delete(id));
    }
}
