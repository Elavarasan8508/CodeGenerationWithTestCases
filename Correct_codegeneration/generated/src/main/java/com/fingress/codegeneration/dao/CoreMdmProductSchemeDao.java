package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.CoreMdmProductScheme;
import com.bsit.codegeneration.mapper.CoreMdmProductSchemeMapper;
import java.util.*;

@RegisterRowMapper(CoreMdmProductSchemeMapper.class)
public interface CoreMdmProductSchemeDao {

    @SqlQuery("SELECT * FROM CORE_MDM_PRODUCT_SCHEME")
    public List<CoreMdmProductScheme> findAll();

    @SqlQuery("SELECT * FROM CORE_MDM_PRODUCT_SCHEME WHERE id = :id")
    public Optional<CoreMdmProductScheme> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO CORE_MDM_PRODUCT_SCHEME(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEME_TYPE, SCHEME_NAME, SCHEME_CODE, SCHEME_DESCRIPTION, EFFECTIVE_DATE, EXPIRY_DATE, UPLOAD_REF_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :SCHEME_TYPE, :SCHEME_NAME, :SCHEME_CODE, :SCHEME_DESCRIPTION, :EFFECTIVE_DATE, :EXPIRY_DATE, :UPLOAD_REF_ID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() CoreMdmProductScheme entity);

    @SqlQuery("UPDATE CORE_MDM_PRODUCT_SCHEME SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, SCHEME_TYPE = :SCHEME_TYPE, SCHEME_NAME = :SCHEME_NAME, SCHEME_CODE = :SCHEME_CODE, SCHEME_DESCRIPTION = :SCHEME_DESCRIPTION, EFFECTIVE_DATE = :EFFECTIVE_DATE, EXPIRY_DATE = :EXPIRY_DATE, UPLOAD_REF_ID = :UPLOAD_REF_ID WHERE id = :id")
    public int update(@BindBean() CoreMdmProductScheme entity);

    @SqlQuery("DELETE FROM CORE_MDM_PRODUCT_SCHEME WHERE id = :id")
    public int delete(@Bind("id") String id);
}
