package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgAlSettlement;
import com.bsit.codegeneration.mapper.FgAlSettlementMapper;
import java.util.*;

@RegisterRowMapper(FgAlSettlementMapper.class)
public interface FgAlSettlementDao {

    @SqlQuery("SELECT * FROM FG_AL_SETTLEMENT")
    public List<FgAlSettlement> findAll();

    @SqlQuery("SELECT * FROM FG_AL_SETTLEMENT WHERE id = :id")
    public Optional<FgAlSettlement> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_AL_SETTLEMENT(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUSTOMER_CRN, ACCOUNT_NUMBER, PROCESS_ID, IS_MASTER_VERSION, VERSION_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :CUSTOMER_CRN, :ACCOUNT_NUMBER, :PROCESS_ID, :IS_MASTER_VERSION, :VERSION_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgAlSettlement entity);

    @SqlQuery("UPDATE FG_AL_SETTLEMENT SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, CUSTOMER_CRN = :CUSTOMER_CRN, ACCOUNT_NUMBER = :ACCOUNT_NUMBER, PROCESS_ID = :PROCESS_ID, IS_MASTER_VERSION = :IS_MASTER_VERSION, VERSION_ID = :VERSION_ID WHERE id = :id")
    public int update(@BindBean() FgAlSettlement entity);

    @SqlQuery("DELETE FROM FG_AL_SETTLEMENT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
