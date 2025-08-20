package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActIDInfoDao;
import com.bsit.codegeneration.record.FgActIDInfo;

public class FgActIDInfoRepository {

    private final Jdbi jdbi;

    public FgActIDInfoRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActIDInfo> getAllFgActIDInfos() {
        return jdbi.withExtension(FgActIDInfoDao.class, fgactidinfodao -> fgactidinfodao.findAll());
    }

    public Optional<FgActIDInfo> getFgActIDInfoById(String id) {
        return jdbi.withExtension(FgActIDInfoDao.class, dao -> dao.findById(id));
    }

    public String createFgActIDInfo(FgActIDInfo entity) {
        return jdbi.withExtension(FgActIDInfoDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActIDInfo(FgActIDInfo entity) {
        return jdbi.withExtension(FgActIDInfoDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActIDInfo(String id) {
        jdbi.useExtension(FgActIDInfoDao.class, dao -> dao.delete(id));
    }
}
