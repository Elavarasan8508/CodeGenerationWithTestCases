package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTdMaturityMaster;
import com.bsit.codegeneration.mapper.FgTdMaturityMasterMapper;
import java.util.*;

@RegisterRowMapper(FgTdMaturityMasterMapper.class)
public interface FgTdMaturityMasterDao {

    @SqlQuery("SELECT * FROM FG_TD_MATURITY_MASTER")
    public List<FgTdMaturityMaster> findAll();

    @SqlQuery("SELECT * FROM FG_TD_MATURITY_MASTER WHERE id = :id")
    public Optional<FgTdMaturityMaster> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TD_MATURITY_MASTER(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, MATURITY_CODE, MATURITY_VALUE, MATURITY_DESCRIPTION, ORIGIN) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :MATURITY_CODE, :MATURITY_VALUE, :MATURITY_DESCRIPTION, :ORIGIN)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTdMaturityMaster entity);

    @SqlQuery("UPDATE FG_TD_MATURITY_MASTER SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, MATURITY_CODE = :MATURITY_CODE, MATURITY_VALUE = :MATURITY_VALUE, MATURITY_DESCRIPTION = :MATURITY_DESCRIPTION, ORIGIN = :ORIGIN WHERE id = :id")
    public int update(@BindBean() FgTdMaturityMaster entity);

    @SqlQuery("DELETE FROM FG_TD_MATURITY_MASTER WHERE id = :id")
    public int delete(@Bind("id") String id);
}
