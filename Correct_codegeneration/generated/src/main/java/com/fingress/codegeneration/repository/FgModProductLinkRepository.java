package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModProductLinkDao;
import com.bsit.codegeneration.record.FgModProductLink;

public class FgModProductLinkRepository {

    private final Jdbi jdbi;

    public FgModProductLinkRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModProductLink> getAllFgModProductLinks() {
        return jdbi.withExtension(FgModProductLinkDao.class, fgmodproductlinkdao -> fgmodproductlinkdao.findAll());
    }

    public Optional<FgModProductLink> getFgModProductLinkById(String id) {
        return jdbi.withExtension(FgModProductLinkDao.class, dao -> dao.findById(id));
    }

    public String createFgModProductLink(FgModProductLink entity) {
        return jdbi.withExtension(FgModProductLinkDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModProductLink(FgModProductLink entity) {
        return jdbi.withExtension(FgModProductLinkDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModProductLink(String id) {
        jdbi.useExtension(FgModProductLinkDao.class, dao -> dao.delete(id));
    }
}
