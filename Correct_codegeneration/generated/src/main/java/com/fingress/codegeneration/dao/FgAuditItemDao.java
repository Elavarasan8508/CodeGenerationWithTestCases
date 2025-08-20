package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgAuditItem;
import com.bsit.codegeneration.mapper.FgAuditItemMapper;
import java.util.*;

@RegisterRowMapper(FgAuditItemMapper.class)
public interface FgAuditItemDao {

    @SqlQuery("SELECT * FROM FG_AUDIT_ITEM")
    public List<FgAuditItem> findAll();

    @SqlQuery("SELECT * FROM FG_AUDIT_ITEM WHERE id = :id")
    public Optional<FgAuditItem> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_AUDIT_ITEM(UUID, AUDIT_MASTER_ID, OUTPUT_CONTEXT, ERROR_CONTEXT) VALUES (:UUID, :AUDIT_MASTER_ID, :OUTPUT_CONTEXT, :ERROR_CONTEXT)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgAuditItem entity);

    @SqlQuery("UPDATE FG_AUDIT_ITEM SET UUID = :UUID, AUDIT_MASTER_ID = :AUDIT_MASTER_ID, OUTPUT_CONTEXT = :OUTPUT_CONTEXT, ERROR_CONTEXT = :ERROR_CONTEXT WHERE id = :id")
    public int update(@BindBean() FgAuditItem entity);

    @SqlQuery("DELETE FROM FG_AUDIT_ITEM WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
