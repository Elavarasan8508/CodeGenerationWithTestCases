package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSdkBotSchema;
import com.bsit.codegeneration.mapper.FgSdkBotSchemaMapper;
import java.util.*;

@RegisterRowMapper(FgSdkBotSchemaMapper.class)
public interface FgSdkBotSchemaDao {

    @SqlQuery("SELECT * FROM FG_SDK_BOT_SCHEMA")
    public List<FgSdkBotSchema> findAll();

    @SqlQuery("SELECT * FROM FG_SDK_BOT_SCHEMA WHERE id = :id")
    public Optional<FgSdkBotSchema> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SDK_BOT_SCHEMA(ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOT_NAME, VERSION, STATUS, DESCRIPTION, LANGUAGE, PUBLISH_DATE, SESSION_TIME_OUT, IDLE_TIME_OUT) VALUES (:ID, :REFERENCE_ID, :APPLICANT_PARTY_CODE, :APPLICANT_REF_ID, :ISSUING_PARTY_CODE, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :BOT_NAME, :VERSION, :STATUS, :DESCRIPTION, :LANGUAGE, :PUBLISH_DATE, :SESSION_TIME_OUT, :IDLE_TIME_OUT)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSdkBotSchema entity);

    @SqlQuery("UPDATE FG_SDK_BOT_SCHEMA SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE, APPLICANT_REF_ID = :APPLICANT_REF_ID, ISSUING_PARTY_CODE = :ISSUING_PARTY_CODE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, BOT_NAME = :BOT_NAME, VERSION = :VERSION, STATUS = :STATUS, DESCRIPTION = :DESCRIPTION, LANGUAGE = :LANGUAGE, PUBLISH_DATE = :PUBLISH_DATE, SESSION_TIME_OUT = :SESSION_TIME_OUT, IDLE_TIME_OUT = :IDLE_TIME_OUT WHERE id = :id")
    public int update(@BindBean() FgSdkBotSchema entity);

    @SqlQuery("DELETE FROM FG_SDK_BOT_SCHEMA WHERE id = :id")
    public int delete(@Bind("id") String id);
}
