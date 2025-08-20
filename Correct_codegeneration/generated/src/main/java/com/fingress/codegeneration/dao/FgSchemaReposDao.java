package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSchemaRepos;
import com.bsit.codegeneration.mapper.FgSchemaReposMapper;
import java.util.*;

@RegisterRowMapper(FgSchemaReposMapper.class)
public interface FgSchemaReposDao {

    @SqlQuery("SELECT * FROM FG_SCHEMA_REPOS")
    public List<FgSchemaRepos> findAll();

    @SqlQuery("SELECT * FROM FG_SCHEMA_REPOS WHERE id = :id")
    public Optional<FgSchemaRepos> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SCHEMA_REPOS(FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, REFERENCE_ID, CATEGORY, CONTENT, ID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, STAGE_CODE, APPLICANT_PARTY_CODE) VALUES (:FILE_EXTENSION, :FILE_TYPE, :NAME, :TEMPLATE, :TYPE_CODE, :SUB_TYPE_CODE, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :REFERENCE_ID, :CATEGORY, :CONTENT, :ID, :CATEGORY_TYPE, :CATEGORY_SUB_TYPE, :TAGS, :STAGE_CODE, :APPLICANT_PARTY_CODE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSchemaRepos entity);

    @SqlQuery("UPDATE FG_SCHEMA_REPOS SET FILE_EXTENSION = :FILE_EXTENSION, FILE_TYPE = :FILE_TYPE, NAME = :NAME, TEMPLATE = :TEMPLATE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, REFERENCE_ID = :REFERENCE_ID, CATEGORY = :CATEGORY, CONTENT = :CONTENT, ID = :ID, CATEGORY_TYPE = :CATEGORY_TYPE, CATEGORY_SUB_TYPE = :CATEGORY_SUB_TYPE, TAGS = :TAGS, STAGE_CODE = :STAGE_CODE, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE WHERE id = :id")
    public int update(@BindBean() FgSchemaRepos entity);

    @SqlQuery("DELETE FROM FG_SCHEMA_REPOS WHERE id = :id")
    public int delete(@Bind("id") String id);
}
