package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.TabRefDao;
import com.bsit.codegeneration.record.TabRef;

public class TabRefRepository {

    private final Jdbi jdbi;

    public TabRefRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<TabRef> getAllTabRefs() {
        return jdbi.withExtension(TabRefDao.class, tabrefdao -> tabrefdao.findAll());
    }

    public Optional<TabRef> getTabRefById(String id) {
        return jdbi.withExtension(TabRefDao.class, dao -> dao.findById(id));
    }

    public String createTabRef(TabRef entity) {
        return jdbi.withExtension(TabRefDao.class, dao -> dao.insert(entity));
    }

    public int updateTabRef(TabRef entity) {
        return jdbi.withExtension(TabRefDao.class, dao -> dao.update(entity));
    }

    public void deleteTabRef(String id) {
        jdbi.useExtension(TabRefDao.class, dao -> dao.delete(id));
    }
}
