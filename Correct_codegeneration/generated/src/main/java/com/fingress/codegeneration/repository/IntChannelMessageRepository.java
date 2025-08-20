package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.IntChannelMessageDao;
import com.bsit.codegeneration.record.IntChannelMessage;

public class IntChannelMessageRepository {

    private final Jdbi jdbi;

    public IntChannelMessageRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<IntChannelMessage> getAllIntChannelMessages() {
        return jdbi.withExtension(IntChannelMessageDao.class, intchannelmessagedao -> intchannelmessagedao.findAll());
    }

    public Optional<IntChannelMessage> getIntChannelMessageById(String id) {
        return jdbi.withExtension(IntChannelMessageDao.class, dao -> dao.findById(id));
    }

    public String createIntChannelMessage(IntChannelMessage entity) {
        return jdbi.withExtension(IntChannelMessageDao.class, dao -> dao.insert(entity));
    }

    public int updateIntChannelMessage(IntChannelMessage entity) {
        return jdbi.withExtension(IntChannelMessageDao.class, dao -> dao.update(entity));
    }

    public void deleteIntChannelMessage(String id) {
        jdbi.useExtension(IntChannelMessageDao.class, dao -> dao.delete(id));
    }
}
