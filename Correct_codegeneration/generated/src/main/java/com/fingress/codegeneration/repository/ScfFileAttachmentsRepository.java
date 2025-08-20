package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ScfFileAttachmentsDao;
import com.bsit.codegeneration.record.ScfFileAttachments;

public class ScfFileAttachmentsRepository {

    private final Jdbi jdbi;

    public ScfFileAttachmentsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<ScfFileAttachments> getAllScfFileAttachmentss() {
        return jdbi.withExtension(ScfFileAttachmentsDao.class, scffileattachmentsdao -> scffileattachmentsdao.findAll());
    }

    public Optional<ScfFileAttachments> getScfFileAttachmentsById(Long id) {
        return jdbi.withExtension(ScfFileAttachmentsDao.class, dao -> dao.findById(id));
    }

    public Long createScfFileAttachments(ScfFileAttachments entity) {
        return jdbi.withExtension(ScfFileAttachmentsDao.class, dao -> dao.insert(entity));
    }

    public int updateScfFileAttachments(ScfFileAttachments entity) {
        return jdbi.withExtension(ScfFileAttachmentsDao.class, dao -> dao.update(entity));
    }

    public void deleteScfFileAttachments(Long id) {
        jdbi.useExtension(ScfFileAttachmentsDao.class, dao -> dao.delete(id));
    }
}
