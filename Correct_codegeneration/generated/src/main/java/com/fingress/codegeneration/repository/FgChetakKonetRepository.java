package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgChetakKonetDao;
import com.bsit.codegeneration.record.FgChetakKonet;

public class FgChetakKonetRepository {

    private final Jdbi jdbi;

    public FgChetakKonetRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgChetakKonet> getAllFgChetakKonets() {
        return jdbi.withExtension(FgChetakKonetDao.class, fgchetakkonetdao -> fgchetakkonetdao.findAll());
    }

    public Optional<FgChetakKonet> getFgChetakKonetById(String id) {
        return jdbi.withExtension(FgChetakKonetDao.class, dao -> dao.findById(id));
    }

    public String createFgChetakKonet(FgChetakKonet entity) {
        return jdbi.withExtension(FgChetakKonetDao.class, dao -> dao.insert(entity));
    }

    public int updateFgChetakKonet(FgChetakKonet entity) {
        return jdbi.withExtension(FgChetakKonetDao.class, dao -> dao.update(entity));
    }

    public void deleteFgChetakKonet(String id) {
        jdbi.useExtension(FgChetakKonetDao.class, dao -> dao.delete(id));
    }
}
