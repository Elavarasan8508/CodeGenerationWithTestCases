package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgDmsEvent;
import com.bsit.codegeneration.mapper.FgDmsEventMapper;
import java.util.*;

@RegisterRowMapper(FgDmsEventMapper.class)
public interface FgDmsEventDao {

    @SqlQuery("SELECT * FROM FG_DMS_EVENT")
    public List<FgDmsEvent> findAll();

    @SqlQuery("SELECT * FROM FG_DMS_EVENT WHERE id = :id")
    public Optional<FgDmsEvent> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_DMS_EVENT(ID, ACTION_CODE, ENTITY_REFERENCE_ID, ENTITY_VERSION_ID, PARTY_ID, PARTY_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE) VALUES (:ID, :ACTION_CODE, :ENTITY_REFERENCE_ID, :ENTITY_VERSION_ID, :PARTY_ID, :PARTY_VERSION_ID, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :ENTITY_TYPE_CODE, :ENTITY_SUB_TYPE_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgDmsEvent entity);

    @SqlQuery("UPDATE FG_DMS_EVENT SET ID = :ID, ACTION_CODE = :ACTION_CODE, ENTITY_REFERENCE_ID = :ENTITY_REFERENCE_ID, ENTITY_VERSION_ID = :ENTITY_VERSION_ID, PARTY_ID = :PARTY_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, ENTITY_TYPE_CODE = :ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE WHERE id = :id")
    public int update(@BindBean() FgDmsEvent entity);

    @SqlQuery("DELETE FROM FG_DMS_EVENT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
