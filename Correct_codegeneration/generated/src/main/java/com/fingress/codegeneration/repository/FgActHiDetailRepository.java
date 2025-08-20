package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiDetailDao;
import com.bsit.codegeneration.record.FgActHiDetail;

public class FgActHiDetailRepository {

    private final Jdbi jdbi;

    public FgActHiDetailRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiDetail> getAllFgActHiDetails() {
        return jdbi.withExtension(FgActHiDetailDao.class, fgacthidetaildao -> fgacthidetaildao.findAll());
    }

    public Optional<FgActHiDetail> getFgActHiDetailById(Long id) {
        return jdbi.withExtension(FgActHiDetailDao.class, dao -> dao.findById(id));
    }

    public Long createFgActHiDetail(FgActHiDetail entity) {
        return jdbi.withExtension(FgActHiDetailDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiDetail(FgActHiDetail entity) {
        return jdbi.withExtension(FgActHiDetailDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiDetail(Long id) {
        jdbi.useExtension(FgActHiDetailDao.class, dao -> dao.delete(id));
    }
}
