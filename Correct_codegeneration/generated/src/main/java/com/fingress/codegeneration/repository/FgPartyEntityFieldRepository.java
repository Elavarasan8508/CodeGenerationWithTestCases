package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPartyEntityFieldDao;
import com.bsit.codegeneration.record.FgPartyEntityField;

public class FgPartyEntityFieldRepository {

    private final Jdbi jdbi;

    public FgPartyEntityFieldRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPartyEntityField> getAllFgPartyEntityFields() {
        return jdbi.withExtension(FgPartyEntityFieldDao.class, fgpartyentityfielddao -> fgpartyentityfielddao.findAll());
    }

    public Optional<FgPartyEntityField> getFgPartyEntityFieldById(Long id) {
        return jdbi.withExtension(FgPartyEntityFieldDao.class, dao -> dao.findById(id));
    }

    public Long createFgPartyEntityField(FgPartyEntityField entity) {
        return jdbi.withExtension(FgPartyEntityFieldDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPartyEntityField(FgPartyEntityField entity) {
        return jdbi.withExtension(FgPartyEntityFieldDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPartyEntityField(Long id) {
        jdbi.useExtension(FgPartyEntityFieldDao.class, dao -> dao.delete(id));
    }
}
