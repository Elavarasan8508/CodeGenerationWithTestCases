package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActIDTenantMemberDao;
import com.bsit.codegeneration.record.FgActIDTenantMember;

public class FgActIDTenantMemberRepository {

    private final Jdbi jdbi;

    public FgActIDTenantMemberRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActIDTenantMember> getAllFgActIDTenantMembers() {
        return jdbi.withExtension(FgActIDTenantMemberDao.class, fgactidtenantmemberdao -> fgactidtenantmemberdao.findAll());
    }

    public Optional<FgActIDTenantMember> getFgActIDTenantMemberById(String id) {
        return jdbi.withExtension(FgActIDTenantMemberDao.class, dao -> dao.findById(id));
    }

    public String createFgActIDTenantMember(FgActIDTenantMember entity) {
        return jdbi.withExtension(FgActIDTenantMemberDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActIDTenantMember(FgActIDTenantMember entity) {
        return jdbi.withExtension(FgActIDTenantMemberDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActIDTenantMember(String id) {
        jdbi.useExtension(FgActIDTenantMemberDao.class, dao -> dao.delete(id));
    }
}
