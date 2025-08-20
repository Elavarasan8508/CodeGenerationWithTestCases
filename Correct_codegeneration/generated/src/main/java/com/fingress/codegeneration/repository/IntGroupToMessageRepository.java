package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.IntGroupToMessageDao;
import com.bsit.codegeneration.record.IntGroupToMessage;

public class IntGroupToMessageRepository {

    private final Jdbi jdbi;

    public IntGroupToMessageRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<IntGroupToMessage> getAllIntGroupToMessages() {
        return jdbi.withExtension(IntGroupToMessageDao.class, intgrouptomessagedao -> intgrouptomessagedao.findAll());
    }

    public Optional<IntGroupToMessage> getIntGroupToMessageById(String id) {
        return jdbi.withExtension(IntGroupToMessageDao.class, dao -> dao.findById(id));
    }

    public String createIntGroupToMessage(IntGroupToMessage entity) {
        return jdbi.withExtension(IntGroupToMessageDao.class, dao -> dao.insert(entity));
    }

    public int updateIntGroupToMessage(IntGroupToMessage entity) {
        return jdbi.withExtension(IntGroupToMessageDao.class, dao -> dao.update(entity));
    }

    public void deleteIntGroupToMessage(String id) {
        jdbi.useExtension(IntGroupToMessageDao.class, dao -> dao.delete(id));
    }
}
