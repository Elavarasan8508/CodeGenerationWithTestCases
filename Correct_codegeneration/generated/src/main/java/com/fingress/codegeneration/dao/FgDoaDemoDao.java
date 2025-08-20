package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgDoaDemo;
import com.bsit.codegeneration.mapper.FgDoaDemoMapper;
import java.util.*;

@RegisterRowMapper(FgDoaDemoMapper.class)
public interface FgDoaDemoDao {

    @SqlQuery("SELECT * FROM FG_DOA_DEMO")
    public List<FgDoaDemo> findAll();

    @SqlQuery("SELECT * FROM FG_DOA_DEMO WHERE id = :id")
    public Optional<FgDoaDemo> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_DOA_DEMO(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUSTOMER_CRN, USER_NAME) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :CUSTOMER_CRN, :USER_NAME)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgDoaDemo entity);

    @SqlQuery("UPDATE FG_DOA_DEMO SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, CUSTOMER_CRN = :CUSTOMER_CRN, USER_NAME = :USER_NAME WHERE id = :id")
    public int update(@BindBean() FgDoaDemo entity);

    @SqlQuery("DELETE FROM FG_DOA_DEMO WHERE id = :id")
    public int delete(@Bind("id") String id);
}
