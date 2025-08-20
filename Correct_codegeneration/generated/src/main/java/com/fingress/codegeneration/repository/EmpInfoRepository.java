package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.EmpInfoDao;
import com.bsit.codegeneration.record.EmpInfo;

public class EmpInfoRepository {

    private final Jdbi jdbi;

    public EmpInfoRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<EmpInfo> getAllEmpInfos() {
        return jdbi.withExtension(EmpInfoDao.class, empinfodao -> empinfodao.findAll());
    }

    public Optional<EmpInfo> getEmpInfoById(String id) {
        return jdbi.withExtension(EmpInfoDao.class, dao -> dao.findById(id));
    }

    public String createEmpInfo(EmpInfo entity) {
        return jdbi.withExtension(EmpInfoDao.class, dao -> dao.insert(entity));
    }

    public int updateEmpInfo(EmpInfo entity) {
        return jdbi.withExtension(EmpInfoDao.class, dao -> dao.update(entity));
    }

    public void deleteEmpInfo(String id) {
        jdbi.useExtension(EmpInfoDao.class, dao -> dao.delete(id));
    }
}
