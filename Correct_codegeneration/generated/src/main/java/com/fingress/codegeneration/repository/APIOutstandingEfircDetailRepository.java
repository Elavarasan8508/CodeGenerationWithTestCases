package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.APIOutstandingEfircDetailDao;
import com.bsit.codegeneration.record.APIOutstandingEfircDetail;

public class APIOutstandingEfircDetailRepository {

    private final Jdbi jdbi;

    public APIOutstandingEfircDetailRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<APIOutstandingEfircDetail> getAllAPIOutstandingEfircDetails() {
        return jdbi.withExtension(APIOutstandingEfircDetailDao.class, apioutstandingefircdetaildao -> apioutstandingefircdetaildao.findAll());
    }

    public Optional<APIOutstandingEfircDetail> getAPIOutstandingEfircDetailById(String id) {
        return jdbi.withExtension(APIOutstandingEfircDetailDao.class, dao -> dao.findById(id));
    }

    public String createAPIOutstandingEfircDetail(APIOutstandingEfircDetail entity) {
        return jdbi.withExtension(APIOutstandingEfircDetailDao.class, dao -> dao.insert(entity));
    }

    public int updateAPIOutstandingEfircDetail(APIOutstandingEfircDetail entity) {
        return jdbi.withExtension(APIOutstandingEfircDetailDao.class, dao -> dao.update(entity));
    }

    public void deleteAPIOutstandingEfircDetail(String id) {
        jdbi.useExtension(APIOutstandingEfircDetailDao.class, dao -> dao.delete(id));
    }
}
