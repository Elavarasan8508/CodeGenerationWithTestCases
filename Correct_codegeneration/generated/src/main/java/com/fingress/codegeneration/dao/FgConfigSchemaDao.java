package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgConfigSchema;
import com.bsit.codegeneration.mapper.FgConfigSchemaMapper;
import java.util.*;

@RegisterRowMapper(FgConfigSchemaMapper.class)
public interface FgConfigSchemaDao {

    @SqlQuery("SELECT * FROM FG_CONFIG_SCHEMA")
    public List<FgConfigSchema> findAll();

    @SqlQuery("SELECT * FROM FG_CONFIG_SCHEMA WHERE id = :id")
    public Optional<FgConfigSchema> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_CONFIG_SCHEMA(ID, CONFIG_CODE, NAME, PARENT_CODE, FIELD_DATA, FORM_DATA, AUTH_FORM_DATA, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CATEGORY_CODE, TYPE_CODE) VALUES (:ID, :CONFIG_CODE, :NAME, :PARENT_CODE, :FIELD_DATA, :FORM_DATA, :AUTH_FORM_DATA, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :CATEGORY_CODE, :TYPE_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgConfigSchema entity);

    @SqlQuery("UPDATE FG_CONFIG_SCHEMA SET ID = :ID, CONFIG_CODE = :CONFIG_CODE, NAME = :NAME, PARENT_CODE = :PARENT_CODE, FIELD_DATA = :FIELD_DATA, FORM_DATA = :FORM_DATA, AUTH_FORM_DATA = :AUTH_FORM_DATA, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, CATEGORY_CODE = :CATEGORY_CODE, TYPE_CODE = :TYPE_CODE WHERE id = :id")
    public int update(@BindBean() FgConfigSchema entity);

    @SqlQuery("DELETE FROM FG_CONFIG_SCHEMA WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
