package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAuditItemDao;
import com.bsit.codegeneration.record.FgAuditItem;

public class FgAuditItemRepository {

    private final Jdbi jdbi;

    public FgAuditItemRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAuditItem> getAllFgAuditItems() {
        return jdbi.withExtension(FgAuditItemDao.class, fgaudititemdao -> fgaudititemdao.findAll());
    }

    public Optional<FgAuditItem> getFgAuditItemById(String id) {
        return jdbi.withExtension(FgAuditItemDao.class, dao -> dao.findById(id));
    }

    public String createFgAuditItem(FgAuditItem entity) {
        return jdbi.withExtension(FgAuditItemDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAuditItem(FgAuditItem entity) {
        return jdbi.withExtension(FgAuditItemDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAuditItem(String id) {
        jdbi.useExtension(FgAuditItemDao.class, dao -> dao.delete(id));
    }
}
