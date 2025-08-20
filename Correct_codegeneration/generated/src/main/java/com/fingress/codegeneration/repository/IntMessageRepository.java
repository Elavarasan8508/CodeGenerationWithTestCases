package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.IntMessageDao;
import com.bsit.codegeneration.record.IntMessage;

public class IntMessageRepository {

    private final Jdbi jdbi;

    public IntMessageRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<IntMessage> getAllIntMessages() {
        return jdbi.withExtension(IntMessageDao.class, intmessagedao -> intmessagedao.findAll());
    }

    public Optional<IntMessage> getIntMessageById(String id) {
        return jdbi.withExtension(IntMessageDao.class, dao -> dao.findById(id));
    }

    public String createIntMessage(IntMessage entity) {
        return jdbi.withExtension(IntMessageDao.class, dao -> dao.insert(entity));
    }

    public int updateIntMessage(IntMessage entity) {
        return jdbi.withExtension(IntMessageDao.class, dao -> dao.update(entity));
    }

    public void deleteIntMessage(String id) {
        jdbi.useExtension(IntMessageDao.class, dao -> dao.delete(id));
    }
}
