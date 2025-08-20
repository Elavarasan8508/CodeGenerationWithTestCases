package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyError;
import com.bsit.codegeneration.mapper.FgPartyErrorMapper;
import java.util.*;

@RegisterRowMapper(FgPartyErrorMapper.class)
public interface FgPartyErrorDao {

    @SqlQuery("SELECT * FROM FG_PARTY_ERROR")
    public List<FgPartyError> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_ERROR WHERE id = :id")
    public Optional<FgPartyError> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PARTY_ERROR(IGNORE, CATEGORY, SEVERITY, TYPE_CODE, SUB_TYPE_CODE, PARTY_REFERENCE_ID, PARTY_CODE, MESSAGE, DETAILS, CREATED_ON, LAST_UPDATED_ON, PARENT_PARTY_CODE) VALUES (:IGNORE, :CATEGORY, :SEVERITY, :TYPE_CODE, :SUB_TYPE_CODE, :PARTY_REFERENCE_ID, :PARTY_CODE, :MESSAGE, :DETAILS, :CREATED_ON, :LAST_UPDATED_ON, :PARENT_PARTY_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPartyError entity);

    @SqlQuery("UPDATE FG_PARTY_ERROR SET IGNORE = :IGNORE, CATEGORY = :CATEGORY, SEVERITY = :SEVERITY, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, PARTY_REFERENCE_ID = :PARTY_REFERENCE_ID, PARTY_CODE = :PARTY_CODE, MESSAGE = :MESSAGE, DETAILS = :DETAILS, CREATED_ON = :CREATED_ON, LAST_UPDATED_ON = :LAST_UPDATED_ON, PARENT_PARTY_CODE = :PARENT_PARTY_CODE WHERE id = :id")
    public int update(@BindBean() FgPartyError entity);

    @SqlQuery("DELETE FROM FG_PARTY_ERROR WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
