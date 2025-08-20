package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTdInterestMaster;
import com.bsit.codegeneration.mapper.FgTdInterestMasterMapper;
import java.util.*;

@RegisterRowMapper(FgTdInterestMasterMapper.class)
public interface FgTdInterestMasterDao {

    @SqlQuery("SELECT * FROM FG_TD_INTEREST_MASTER")
    public List<FgTdInterestMaster> findAll();

    @SqlQuery("SELECT * FROM FG_TD_INTEREST_MASTER WHERE id = :id")
    public Optional<FgTdInterestMaster> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TD_INTEREST_MASTER(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INTEREST_CODE, INTEREST_VALUE, INTEREST_DESCRIPTION, ORIGIN) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :INTEREST_CODE, :INTEREST_VALUE, :INTEREST_DESCRIPTION, :ORIGIN)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTdInterestMaster entity);

    @SqlQuery("UPDATE FG_TD_INTEREST_MASTER SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, INTEREST_CODE = :INTEREST_CODE, INTEREST_VALUE = :INTEREST_VALUE, INTEREST_DESCRIPTION = :INTEREST_DESCRIPTION, ORIGIN = :ORIGIN WHERE id = :id")
    public int update(@BindBean() FgTdInterestMaster entity);

    @SqlQuery("DELETE FROM FG_TD_INTEREST_MASTER WHERE id = :id")
    public int delete(@Bind("id") String id);
}
