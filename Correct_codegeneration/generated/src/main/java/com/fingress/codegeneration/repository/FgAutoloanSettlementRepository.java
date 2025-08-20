package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAutoloanSettlementDao;
import com.bsit.codegeneration.record.FgAutoloanSettlement;

public class FgAutoloanSettlementRepository {

    private final Jdbi jdbi;

    public FgAutoloanSettlementRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAutoloanSettlement> getAllFgAutoloanSettlements() {
        return jdbi.withExtension(FgAutoloanSettlementDao.class, fgautoloansettlementdao -> fgautoloansettlementdao.findAll());
    }

    public Optional<FgAutoloanSettlement> getFgAutoloanSettlementById(String id) {
        return jdbi.withExtension(FgAutoloanSettlementDao.class, dao -> dao.findById(id));
    }

    public String createFgAutoloanSettlement(FgAutoloanSettlement entity) {
        return jdbi.withExtension(FgAutoloanSettlementDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAutoloanSettlement(FgAutoloanSettlement entity) {
        return jdbi.withExtension(FgAutoloanSettlementDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAutoloanSettlement(String id) {
        jdbi.useExtension(FgAutoloanSettlementDao.class, dao -> dao.delete(id));
    }
}
