package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAlSettlementDao;
import com.bsit.codegeneration.record.FgAlSettlement;

public class FgAlSettlementRepository {

    private final Jdbi jdbi;

    public FgAlSettlementRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAlSettlement> getAllFgAlSettlements() {
        return jdbi.withExtension(FgAlSettlementDao.class, fgalsettlementdao -> fgalsettlementdao.findAll());
    }

    public Optional<FgAlSettlement> getFgAlSettlementById(Long id) {
        return jdbi.withExtension(FgAlSettlementDao.class, dao -> dao.findById(id));
    }

    public Long createFgAlSettlement(FgAlSettlement entity) {
        return jdbi.withExtension(FgAlSettlementDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAlSettlement(FgAlSettlement entity) {
        return jdbi.withExtension(FgAlSettlementDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAlSettlement(Long id) {
        jdbi.useExtension(FgAlSettlementDao.class, dao -> dao.delete(id));
    }
}
