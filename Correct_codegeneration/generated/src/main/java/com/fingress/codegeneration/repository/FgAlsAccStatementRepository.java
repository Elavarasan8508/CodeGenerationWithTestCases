package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAlsAccStatementDao;
import com.bsit.codegeneration.record.FgAlsAccStatement;

public class FgAlsAccStatementRepository {

    private final Jdbi jdbi;

    public FgAlsAccStatementRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAlsAccStatement> getAllFgAlsAccStatements() {
        return jdbi.withExtension(FgAlsAccStatementDao.class, fgalsaccstatementdao -> fgalsaccstatementdao.findAll());
    }

    public Optional<FgAlsAccStatement> getFgAlsAccStatementById(String id) {
        return jdbi.withExtension(FgAlsAccStatementDao.class, dao -> dao.findById(id));
    }

    public String createFgAlsAccStatement(FgAlsAccStatement entity) {
        return jdbi.withExtension(FgAlsAccStatementDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAlsAccStatement(FgAlsAccStatement entity) {
        return jdbi.withExtension(FgAlsAccStatementDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAlsAccStatement(String id) {
        jdbi.useExtension(FgAlsAccStatementDao.class, dao -> dao.delete(id));
    }
}
