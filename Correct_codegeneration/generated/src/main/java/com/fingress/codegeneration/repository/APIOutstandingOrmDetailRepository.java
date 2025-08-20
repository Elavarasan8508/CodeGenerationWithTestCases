package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.APIOutstandingOrmDetailDao;
import com.bsit.codegeneration.record.APIOutstandingOrmDetail;

public class APIOutstandingOrmDetailRepository {

    private final Jdbi jdbi;

    public APIOutstandingOrmDetailRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<APIOutstandingOrmDetail> getAllAPIOutstandingOrmDetails() {
        return jdbi.withExtension(APIOutstandingOrmDetailDao.class, apioutstandingormdetaildao -> apioutstandingormdetaildao.findAll());
    }

    public Optional<APIOutstandingOrmDetail> getAPIOutstandingOrmDetailById(String id) {
        return jdbi.withExtension(APIOutstandingOrmDetailDao.class, dao -> dao.findById(id));
    }

    public String createAPIOutstandingOrmDetail(APIOutstandingOrmDetail entity) {
        return jdbi.withExtension(APIOutstandingOrmDetailDao.class, dao -> dao.insert(entity));
    }

    public int updateAPIOutstandingOrmDetail(APIOutstandingOrmDetail entity) {
        return jdbi.withExtension(APIOutstandingOrmDetailDao.class, dao -> dao.update(entity));
    }

    public void deleteAPIOutstandingOrmDetail(String id) {
        jdbi.useExtension(APIOutstandingOrmDetailDao.class, dao -> dao.delete(id));
    }
}
