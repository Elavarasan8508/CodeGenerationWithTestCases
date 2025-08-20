package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgUpload;
import com.bsit.codegeneration.mapper.FgUploadMapper;
import java.util.*;

@RegisterRowMapper(FgUploadMapper.class)
public interface FgUploadDao {

    @SqlQuery("SELECT * FROM FG_UPLOAD")
    public List<FgUpload> findAll();

    @SqlQuery("SELECT * FROM FG_UPLOAD WHERE id = :id")
    public Optional<FgUpload> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_UPLOAD(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, NAME, AGE, CONTACT, UPLOAD_REF_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :NAME, :AGE, :CONTACT, :UPLOAD_REF_ID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgUpload entity);

    @SqlQuery("UPDATE FG_UPLOAD SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, NAME = :NAME, AGE = :AGE, CONTACT = :CONTACT, UPLOAD_REF_ID = :UPLOAD_REF_ID WHERE id = :id")
    public int update(@BindBean() FgUpload entity);

    @SqlQuery("DELETE FROM FG_UPLOAD WHERE id = :id")
    public int delete(@Bind("id") String id);
}
