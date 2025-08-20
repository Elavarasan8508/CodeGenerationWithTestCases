package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgAutoloanAcct;
import com.bsit.codegeneration.mapper.FgAutoloanAcctMapper;
import java.util.*;

@RegisterRowMapper(FgAutoloanAcctMapper.class)
public interface FgAutoloanAcctDao {

    @SqlQuery("SELECT * FROM FG_AUTOLOAN_ACCT")
    public List<FgAutoloanAcct> findAll();

    @SqlQuery("SELECT * FROM FG_AUTOLOAN_ACCT WHERE id = :id")
    public Optional<FgAutoloanAcct> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_AUTOLOAN_ACCT(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, ACCT_NUM, PRODUCT_CODE, MAX_SET_PERCENT, MAX_SET_AMOUNT, PARENT_REF_ID, PARENT_VERSION_ID, LOGIC_SETTLE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :ACCT_NUM, :PRODUCT_CODE, :MAX_SET_PERCENT, :MAX_SET_AMOUNT, :PARENT_REF_ID, :PARENT_VERSION_ID, :LOGIC_SETTLE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgAutoloanAcct entity);

    @SqlQuery("UPDATE FG_AUTOLOAN_ACCT SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, ACCT_NUM = :ACCT_NUM, PRODUCT_CODE = :PRODUCT_CODE, MAX_SET_PERCENT = :MAX_SET_PERCENT, MAX_SET_AMOUNT = :MAX_SET_AMOUNT, PARENT_REF_ID = :PARENT_REF_ID, PARENT_VERSION_ID = :PARENT_VERSION_ID, LOGIC_SETTLE = :LOGIC_SETTLE WHERE id = :id")
    public int update(@BindBean() FgAutoloanAcct entity);

    @SqlQuery("DELETE FROM FG_AUTOLOAN_ACCT WHERE id = :id")
    public int delete(@Bind("id") String id);
}
