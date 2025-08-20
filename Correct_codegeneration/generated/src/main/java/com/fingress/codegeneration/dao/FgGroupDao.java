package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgGroup;
import com.bsit.codegeneration.mapper.FgGroupMapper;
import java.util.*;

@RegisterRowMapper(FgGroupMapper.class)
public interface FgGroupDao {

    @SqlQuery("SELECT * FROM FG_GROUP")
    public List<FgGroup> findAll();

    @SqlQuery("SELECT * FROM FG_GROUP WHERE id = :id")
    public Optional<FgGroup> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_GROUP(ID, NAME, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CODE, TYPE_CODE, SUB_TYPE_CODE, PARTY_TYPE_CODE, REFERENCE_ID, CONFIG_STATUS_CODE, ORG_TYPE_CODE, ORG_CODE) VALUES (:ID, :NAME, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :CODE, :TYPE_CODE, :SUB_TYPE_CODE, :PARTY_TYPE_CODE, :REFERENCE_ID, :CONFIG_STATUS_CODE, :ORG_TYPE_CODE, :ORG_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgGroup entity);

    @SqlQuery("UPDATE FG_GROUP SET ID = :ID, NAME = :NAME, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, CODE = :CODE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, PARTY_TYPE_CODE = :PARTY_TYPE_CODE, REFERENCE_ID = :REFERENCE_ID, CONFIG_STATUS_CODE = :CONFIG_STATUS_CODE, ORG_TYPE_CODE = :ORG_TYPE_CODE, ORG_CODE = :ORG_CODE WHERE id = :id")
    public int update(@BindBean() FgGroup entity);

    @SqlQuery("DELETE FROM FG_GROUP WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
