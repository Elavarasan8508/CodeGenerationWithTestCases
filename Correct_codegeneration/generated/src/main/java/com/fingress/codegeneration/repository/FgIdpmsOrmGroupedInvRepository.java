package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgIdpmsOrmGroupedInvDao;
import com.bsit.codegeneration.record.FgIdpmsOrmGroupedInv;

public class FgIdpmsOrmGroupedInvRepository {

    private final Jdbi jdbi;

    public FgIdpmsOrmGroupedInvRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgIdpmsOrmGroupedInv> getAllFgIdpmsOrmGroupedInvs() {
        return jdbi.withExtension(FgIdpmsOrmGroupedInvDao.class, fgidpmsormgroupedinvdao -> fgidpmsormgroupedinvdao.findAll());
    }

    public Optional<FgIdpmsOrmGroupedInv> getFgIdpmsOrmGroupedInvById(String id) {
        return jdbi.withExtension(FgIdpmsOrmGroupedInvDao.class, dao -> dao.findById(id));
    }

    public String createFgIdpmsOrmGroupedInv(FgIdpmsOrmGroupedInv entity) {
        return jdbi.withExtension(FgIdpmsOrmGroupedInvDao.class, dao -> dao.insert(entity));
    }

    public int updateFgIdpmsOrmGroupedInv(FgIdpmsOrmGroupedInv entity) {
        return jdbi.withExtension(FgIdpmsOrmGroupedInvDao.class, dao -> dao.update(entity));
    }

    public void deleteFgIdpmsOrmGroupedInv(String id) {
        jdbi.useExtension(FgIdpmsOrmGroupedInvDao.class, dao -> dao.delete(id));
    }
}
