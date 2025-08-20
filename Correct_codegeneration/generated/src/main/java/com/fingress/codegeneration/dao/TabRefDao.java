package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.TabRef;
import com.bsit.codegeneration.mapper.TabRefMapper;
import java.util.*;

@RegisterRowMapper(TabRefMapper.class)
public interface TabRefDao {

    @SqlQuery("SELECT * FROM TAB_REF")
    public List<TabRef> findAll();

    @SqlQuery("SELECT * FROM TAB_REF WHERE id = :id")
    public Optional<TabRef> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO TAB_REF(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TD_CODE1, TD_CODE2, TD_CODE3, TD_CODE4, TD_CODE5, TD_CODE6, TD_CODE7, TD_CODE8, TD_CODE9, TD_CODE10) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :TD_CODE1, :TD_CODE2, :TD_CODE3, :TD_CODE4, :TD_CODE5, :TD_CODE6, :TD_CODE7, :TD_CODE8, :TD_CODE9, :TD_CODE10)")
    @GetGeneratedKeys()
    public String insert(@BindBean() TabRef entity);

    @SqlQuery("UPDATE TAB_REF SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, TD_CODE1 = :TD_CODE1, TD_CODE2 = :TD_CODE2, TD_CODE3 = :TD_CODE3, TD_CODE4 = :TD_CODE4, TD_CODE5 = :TD_CODE5, TD_CODE6 = :TD_CODE6, TD_CODE7 = :TD_CODE7, TD_CODE8 = :TD_CODE8, TD_CODE9 = :TD_CODE9, TD_CODE10 = :TD_CODE10 WHERE id = :id")
    public int update(@BindBean() TabRef entity);

    @SqlQuery("DELETE FROM TAB_REF WHERE id = :id")
    public int delete(@Bind("id") String id);
}
