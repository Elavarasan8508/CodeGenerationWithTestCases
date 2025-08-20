package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModCmsPtyRoleDao;
import com.bsit.codegeneration.record.FgModCmsPtyRole;

public class FgModCmsPtyRoleRepository {

    private final Jdbi jdbi;

    public FgModCmsPtyRoleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModCmsPtyRole> getAllFgModCmsPtyRoles() {
        return jdbi.withExtension(FgModCmsPtyRoleDao.class, fgmodcmsptyroledao -> fgmodcmsptyroledao.findAll());
    }

    public Optional<FgModCmsPtyRole> getFgModCmsPtyRoleById(String id) {
        return jdbi.withExtension(FgModCmsPtyRoleDao.class, dao -> dao.findById(id));
    }

    public String createFgModCmsPtyRole(FgModCmsPtyRole entity) {
        return jdbi.withExtension(FgModCmsPtyRoleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModCmsPtyRole(FgModCmsPtyRole entity) {
        return jdbi.withExtension(FgModCmsPtyRoleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModCmsPtyRole(String id) {
        jdbi.useExtension(FgModCmsPtyRoleDao.class, dao -> dao.delete(id));
    }
}
