package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgScheduleCodeDao;
import com.bsit.codegeneration.record.FgScheduleCode;

public class FgScheduleCodeRepository {

    private final Jdbi jdbi;

    public FgScheduleCodeRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgScheduleCode> getAllFgScheduleCodes() {
        return jdbi.withExtension(FgScheduleCodeDao.class, fgschedulecodedao -> fgschedulecodedao.findAll());
    }

    public Optional<FgScheduleCode> getFgScheduleCodeById(String id) {
        return jdbi.withExtension(FgScheduleCodeDao.class, dao -> dao.findById(id));
    }

    public String createFgScheduleCode(FgScheduleCode entity) {
        return jdbi.withExtension(FgScheduleCodeDao.class, dao -> dao.insert(entity));
    }

    public int updateFgScheduleCode(FgScheduleCode entity) {
        return jdbi.withExtension(FgScheduleCodeDao.class, dao -> dao.update(entity));
    }

    public void deleteFgScheduleCode(String id) {
        jdbi.useExtension(FgScheduleCodeDao.class, dao -> dao.delete(id));
    }
}
