package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.LmsMdmProductGroup;
import com.bsit.codegeneration.mapper.LmsMdmProductGroupMapper;
import java.util.*;

@RegisterRowMapper(LmsMdmProductGroupMapper.class)
public interface LmsMdmProductGroupDao {

    @SqlQuery("SELECT * FROM LMS_MDM_PRODUCT_GROUP")
    public List<LmsMdmProductGroup> findAll();

    @SqlQuery("SELECT * FROM LMS_MDM_PRODUCT_GROUP WHERE id = :id")
    public Optional<LmsMdmProductGroup> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO LMS_MDM_PRODUCT_GROUP(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, GROUPING_NAME, DESCRIPTION, SOURCE_SYSTEM_PRODUCT_TYPE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :GROUPING_NAME, :DESCRIPTION, :SOURCE_SYSTEM_PRODUCT_TYPE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() LmsMdmProductGroup entity);

    @SqlQuery("UPDATE LMS_MDM_PRODUCT_GROUP SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, GROUPING_NAME = :GROUPING_NAME, DESCRIPTION = :DESCRIPTION, SOURCE_SYSTEM_PRODUCT_TYPE = :SOURCE_SYSTEM_PRODUCT_TYPE WHERE id = :id")
    public int update(@BindBean() LmsMdmProductGroup entity);

    @SqlQuery("DELETE FROM LMS_MDM_PRODUCT_GROUP WHERE id = :id")
    public int delete(@Bind("id") String id);
}
