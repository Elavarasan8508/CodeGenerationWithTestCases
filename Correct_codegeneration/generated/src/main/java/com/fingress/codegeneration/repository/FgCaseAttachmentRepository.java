package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgCaseAttachmentDao;
import com.bsit.codegeneration.record.FgCaseAttachment;

public class FgCaseAttachmentRepository {

    private final Jdbi jdbi;

    public FgCaseAttachmentRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgCaseAttachment> getAllFgCaseAttachments() {
        return jdbi.withExtension(FgCaseAttachmentDao.class, fgcaseattachmentdao -> fgcaseattachmentdao.findAll());
    }

    public Optional<FgCaseAttachment> getFgCaseAttachmentById(java.time.LocalDateTime id) {
        return jdbi.withExtension(FgCaseAttachmentDao.class, dao -> dao.findById(id));
    }

    public java.time.LocalDateTime createFgCaseAttachment(FgCaseAttachment entity) {
        return jdbi.withExtension(FgCaseAttachmentDao.class, dao -> dao.insert(entity));
    }

    public int updateFgCaseAttachment(FgCaseAttachment entity) {
        return jdbi.withExtension(FgCaseAttachmentDao.class, dao -> dao.update(entity));
    }

    public void deleteFgCaseAttachment(java.time.LocalDateTime id) {
        jdbi.useExtension(FgCaseAttachmentDao.class, dao -> dao.delete(id));
    }
}
