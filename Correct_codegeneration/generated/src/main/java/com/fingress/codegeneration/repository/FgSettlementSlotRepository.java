package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSettlementSlotDao;
import com.bsit.codegeneration.record.FgSettlementSlot;

public class FgSettlementSlotRepository {

    private final Jdbi jdbi;

    public FgSettlementSlotRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSettlementSlot> getAllFgSettlementSlots() {
        return jdbi.withExtension(FgSettlementSlotDao.class, fgsettlementslotdao -> fgsettlementslotdao.findAll());
    }

    public Optional<FgSettlementSlot> getFgSettlementSlotById(String id) {
        return jdbi.withExtension(FgSettlementSlotDao.class, dao -> dao.findById(id));
    }

    public String createFgSettlementSlot(FgSettlementSlot entity) {
        return jdbi.withExtension(FgSettlementSlotDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSettlementSlot(FgSettlementSlot entity) {
        return jdbi.withExtension(FgSettlementSlotDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSettlementSlot(String id) {
        jdbi.useExtension(FgSettlementSlotDao.class, dao -> dao.delete(id));
    }
}
