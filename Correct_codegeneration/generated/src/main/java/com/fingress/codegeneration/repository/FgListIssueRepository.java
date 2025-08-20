package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgListIssueDao;
import com.bsit.codegeneration.record.FgListIssue;

public class FgListIssueRepository {

    private final Jdbi jdbi;

    public FgListIssueRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgListIssue> getAllFgListIssues() {
        return jdbi.withExtension(FgListIssueDao.class, fglistissuedao -> fglistissuedao.findAll());
    }

    public Optional<FgListIssue> getFgListIssueById(Long id) {
        return jdbi.withExtension(FgListIssueDao.class, dao -> dao.findById(id));
    }

    public Long createFgListIssue(FgListIssue entity) {
        return jdbi.withExtension(FgListIssueDao.class, dao -> dao.insert(entity));
    }

    public int updateFgListIssue(FgListIssue entity) {
        return jdbi.withExtension(FgListIssueDao.class, dao -> dao.update(entity));
    }

    public void deleteFgListIssue(Long id) {
        jdbi.useExtension(FgListIssueDao.class, dao -> dao.delete(id));
    }
}
