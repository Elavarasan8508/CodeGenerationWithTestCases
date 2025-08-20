package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.APIOutstandingBillDetailDao;
import com.bsit.codegeneration.record.APIOutstandingBillDetail;

public class APIOutstandingBillDetailRepository {

    private final Jdbi jdbi;

    public APIOutstandingBillDetailRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<APIOutstandingBillDetail> getAllAPIOutstandingBillDetails() {
        return jdbi.withExtension(APIOutstandingBillDetailDao.class, apioutstandingbilldetaildao -> apioutstandingbilldetaildao.findAll());
    }

    public Optional<APIOutstandingBillDetail> getAPIOutstandingBillDetailById(Long id) {
        return jdbi.withExtension(APIOutstandingBillDetailDao.class, dao -> dao.findById(id));
    }

    public Long createAPIOutstandingBillDetail(APIOutstandingBillDetail entity) {
        return jdbi.withExtension(APIOutstandingBillDetailDao.class, dao -> dao.insert(entity));
    }

    public int updateAPIOutstandingBillDetail(APIOutstandingBillDetail entity) {
        return jdbi.withExtension(APIOutstandingBillDetailDao.class, dao -> dao.update(entity));
    }

    public void deleteAPIOutstandingBillDetail(Long id) {
        jdbi.useExtension(APIOutstandingBillDetailDao.class, dao -> dao.delete(id));
    }
}
