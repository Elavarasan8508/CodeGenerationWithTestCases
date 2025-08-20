package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgModCampaign;
import com.bsit.codegeneration.mapper.FgModCampaignMapper;
import java.util.*;

@RegisterRowMapper(FgModCampaignMapper.class)
public interface FgModCampaignDao {

    @SqlQuery("SELECT * FROM FG_MOD_CAMPAIGN")
    public List<FgModCampaign> findAll();

    @SqlQuery("SELECT * FROM FG_MOD_CAMPAIGN WHERE id = :id")
    public Optional<FgModCampaign> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MOD_CAMPAIGN(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_TEMPLATE, PROCESS_ID, BO_RESPONSE, BO_STATUS, STATUS_ID, COMMENTS, DESCRIPTION, TEMPLATE_REF_ID, PURPOSE_CODE, TITLE, APPLICATION_DATE, EFFECTIVE_FROM, EFFECTIVE_TO, TEMPLATE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :IS_TEMPLATE, :PROCESS_ID, :BO_RESPONSE, :BO_STATUS, :STATUS_ID, :COMMENTS, :DESCRIPTION, :TEMPLATE_REF_ID, :PURPOSE_CODE, :TITLE, :APPLICATION_DATE, :EFFECTIVE_FROM, :EFFECTIVE_TO, :TEMPLATE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgModCampaign entity);

    @SqlQuery("UPDATE FG_MOD_CAMPAIGN SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, IS_TEMPLATE = :IS_TEMPLATE, PROCESS_ID = :PROCESS_ID, BO_RESPONSE = :BO_RESPONSE, BO_STATUS = :BO_STATUS, STATUS_ID = :STATUS_ID, COMMENTS = :COMMENTS, DESCRIPTION = :DESCRIPTION, TEMPLATE_REF_ID = :TEMPLATE_REF_ID, PURPOSE_CODE = :PURPOSE_CODE, TITLE = :TITLE, APPLICATION_DATE = :APPLICATION_DATE, EFFECTIVE_FROM = :EFFECTIVE_FROM, EFFECTIVE_TO = :EFFECTIVE_TO, TEMPLATE = :TEMPLATE WHERE id = :id")
    public int update(@BindBean() FgModCampaign entity);

    @SqlQuery("DELETE FROM FG_MOD_CAMPAIGN WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
