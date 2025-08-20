package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiCommentDao;
import com.bsit.codegeneration.record.FgActHiComment;

public class FgActHiCommentRepository {

    private final Jdbi jdbi;

    public FgActHiCommentRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiComment> getAllFgActHiComments() {
        return jdbi.withExtension(FgActHiCommentDao.class, fgacthicommentdao -> fgacthicommentdao.findAll());
    }

    public Optional<FgActHiComment> getFgActHiCommentById(String id) {
        return jdbi.withExtension(FgActHiCommentDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiComment(FgActHiComment entity) {
        return jdbi.withExtension(FgActHiCommentDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiComment(FgActHiComment entity) {
        return jdbi.withExtension(FgActHiCommentDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiComment(String id) {
        jdbi.useExtension(FgActHiCommentDao.class, dao -> dao.delete(id));
    }
}
