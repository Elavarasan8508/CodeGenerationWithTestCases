package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgLayoutMapping;
import com.bsit.codegeneration.mapper.FgLayoutMappingMapper;
import java.util.*;

@RegisterRowMapper(FgLayoutMappingMapper.class)
public interface FgLayoutMappingDao {

    @SqlQuery("SELECT * FROM FG_LAYOUT_MAPPING")
    public List<FgLayoutMapping> findAll();

    @SqlQuery("SELECT * FROM FG_LAYOUT_MAPPING WHERE id = :id")
    public Optional<FgLayoutMapping> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_LAYOUT_MAPPING(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LAYOUT_MAPPING, LIST_MAPPING, LAYOUT_ID, LIST_ID, LAYOUT_UUID, LIST_UUID, TYPE, FORM_ID, FORM_MAPPING, FORM_UUID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :LAYOUT_MAPPING, :LIST_MAPPING, :LAYOUT_ID, :LIST_ID, :LAYOUT_UUID, :LIST_UUID, :TYPE, :FORM_ID, :FORM_MAPPING, :FORM_UUID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgLayoutMapping entity);

    @SqlQuery("UPDATE FG_LAYOUT_MAPPING SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, LAYOUT_MAPPING = :LAYOUT_MAPPING, LIST_MAPPING = :LIST_MAPPING, LAYOUT_ID = :LAYOUT_ID, LIST_ID = :LIST_ID, LAYOUT_UUID = :LAYOUT_UUID, LIST_UUID = :LIST_UUID, TYPE = :TYPE, FORM_ID = :FORM_ID, FORM_MAPPING = :FORM_MAPPING, FORM_UUID = :FORM_UUID WHERE id = :id")
    public int update(@BindBean() FgLayoutMapping entity);

    @SqlQuery("DELETE FROM FG_LAYOUT_MAPPING WHERE id = :id")
    public int delete(@Bind("id") String id);
}
