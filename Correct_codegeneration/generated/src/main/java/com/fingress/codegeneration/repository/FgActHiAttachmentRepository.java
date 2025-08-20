package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiAttachmentDao;
import com.bsit.codegeneration.record.FgActHiAttachment;

public class FgActHiAttachmentRepository {

    private final Jdbi jdbi;

    public FgActHiAttachmentRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiAttachment> getAllFgActHiAttachments() {
        return jdbi.withExtension(FgActHiAttachmentDao.class, fgacthiattachmentdao -> fgacthiattachmentdao.findAll());
    }

    public Optional<FgActHiAttachment> getFgActHiAttachmentById(String id) {
        return jdbi.withExtension(FgActHiAttachmentDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiAttachment(FgActHiAttachment entity) {
        return jdbi.withExtension(FgActHiAttachmentDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiAttachment(FgActHiAttachment entity) {
        return jdbi.withExtension(FgActHiAttachmentDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiAttachment(String id) {
        jdbi.useExtension(FgActHiAttachmentDao.class, dao -> dao.delete(id));
    }
}
