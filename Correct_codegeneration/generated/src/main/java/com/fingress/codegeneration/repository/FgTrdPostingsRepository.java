package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdPostingsDao;
import com.bsit.codegeneration.record.FgTrdPostings;

public class FgTrdPostingsRepository {

    private final Jdbi jdbi;

    public FgTrdPostingsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdPostings> getAllFgTrdPostingss() {
        return jdbi.withExtension(FgTrdPostingsDao.class, fgtrdpostingsdao -> fgtrdpostingsdao.findAll());
    }

    public Optional<FgTrdPostings> getFgTrdPostingsById(String id) {
        return jdbi.withExtension(FgTrdPostingsDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdPostings(FgTrdPostings entity) {
        return jdbi.withExtension(FgTrdPostingsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdPostings(FgTrdPostings entity) {
        return jdbi.withExtension(FgTrdPostingsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdPostings(String id) {
        jdbi.useExtension(FgTrdPostingsDao.class, dao -> dao.delete(id));
    }
}
