package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyErrorDao;
import com.bsit.codegeneration.record.FgPartyError;

public class FgPartyErrorRepository {

    private final Jdbi jdbi;

    public FgPartyErrorRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyError> getAllFgPartyErrors() {
        return jdbi.withExtension(FgPartyErrorDao.class, fgpartyerrordao -> fgpartyerrordao.findAll());
    }

    public Optional<FgPartyError> getFgPartyErrorById(String id) {
        return jdbi.withExtension(FgPartyErrorDao.class, dao -> dao.findById(id));
    }

    public String createFgPartyError(FgPartyError entity) {
        return jdbi.withExtension(FgPartyErrorDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyError(FgPartyError entity) {
        return jdbi.withExtension(FgPartyErrorDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyError(String id) {
        jdbi.useExtension(FgPartyErrorDao.class, dao -> dao.delete(id));
    }
}
