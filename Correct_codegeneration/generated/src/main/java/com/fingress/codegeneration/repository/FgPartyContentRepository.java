package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyContentDao;
import com.bsit.codegeneration.record.FgPartyContent;

public class FgPartyContentRepository {

    private final Jdbi jdbi;

    public FgPartyContentRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyContent> getAllFgPartyContents() {
        return jdbi.withExtension(FgPartyContentDao.class, fgpartycontentdao -> fgpartycontentdao.findAll());
    }

    public Optional<FgPartyContent> getFgPartyContentById(Long id) {
        return jdbi.withExtension(FgPartyContentDao.class, dao -> dao.findById(id));
    }

    public Long createFgPartyContent(FgPartyContent entity) {
        return jdbi.withExtension(FgPartyContentDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyContent(FgPartyContent entity) {
        return jdbi.withExtension(FgPartyContentDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyContent(Long id) {
        jdbi.useExtension(FgPartyContentDao.class, dao -> dao.delete(id));
    }
}
