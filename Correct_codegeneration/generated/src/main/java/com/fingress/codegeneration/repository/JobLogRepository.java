package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.JobLogDao;
import com.bsit.codegeneration.record.JobLog;

public class JobLogRepository {

    private final Jdbi jdbi;

    public JobLogRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<JobLog> getAllJobLogs() {
        return jdbi.withExtension(JobLogDao.class, joblogdao -> joblogdao.findAll());
    }

    public Optional<JobLog> getJobLogById(String id) {
        return jdbi.withExtension(JobLogDao.class, dao -> dao.findById(id));
    }

    public String createJobLog(JobLog entity) {
        return jdbi.withExtension(JobLogDao.class, dao -> dao.insert(entity));
    }

    public int updateJobLog(JobLog entity) {
        return jdbi.withExtension(JobLogDao.class, dao -> dao.update(entity));
    }

    public void deleteJobLog(String id) {
        jdbi.useExtension(JobLogDao.class, dao -> dao.delete(id));
    }
}
