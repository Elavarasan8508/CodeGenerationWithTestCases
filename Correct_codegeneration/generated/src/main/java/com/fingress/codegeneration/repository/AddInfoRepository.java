package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.AddInfoDao;
import com.bsit.codegeneration.record.AddInfo;

public class AddInfoRepository {

    private final Jdbi jdbi;

    public AddInfoRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<AddInfo> getAllAddInfos() {
        return jdbi.withExtension(AddInfoDao.class, addinfodao -> addinfodao.findAll());
    }

    public Optional<AddInfo> getAddInfoById(Long id) {
        return jdbi.withExtension(AddInfoDao.class, dao -> dao.findById(id));
    }

    public Long createAddInfo(AddInfo entity) {
        return jdbi.withExtension(AddInfoDao.class, dao -> dao.insert(entity));
    }

    public int updateAddInfo(AddInfo entity) {
        return jdbi.withExtension(AddInfoDao.class, dao -> dao.update(entity));
    }

    public void deleteAddInfo(Long id) {
        jdbi.useExtension(AddInfoDao.class, dao -> dao.delete(id));
    }
}
