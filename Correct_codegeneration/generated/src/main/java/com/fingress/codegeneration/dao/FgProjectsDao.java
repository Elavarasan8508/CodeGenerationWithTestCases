package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgProjects;
import com.bsit.codegeneration.mapper.FgProjectsMapper;
import java.util.*;

@RegisterRowMapper(FgProjectsMapper.class)
public interface FgProjectsDao {

    @SqlQuery("SELECT * FROM FG_PROJECTS")
    public List<FgProjects> findAll();

    @SqlQuery("SELECT * FROM FG_PROJECTS WHERE id = :id")
    public Optional<FgProjects> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_PROJECTS(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROJECT_NAME, START_DATE, END_DATE, PROJECT_TITLE, DESCRIPTION, SUB_PROJECT, CATEGORY, PROCESS_ID, VERSION_ID, IS_MASTER_VERSION, ATTRIBUTE_GUARANTEE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :PROJECT_NAME, :START_DATE, :END_DATE, :PROJECT_TITLE, :DESCRIPTION, :SUB_PROJECT, :CATEGORY, :PROCESS_ID, :VERSION_ID, :IS_MASTER_VERSION, :ATTRIBUTE_GUARANTEE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgProjects entity);

    @SqlQuery("UPDATE FG_PROJECTS SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, PROJECT_NAME = :PROJECT_NAME, START_DATE = :START_DATE, END_DATE = :END_DATE, PROJECT_TITLE = :PROJECT_TITLE, DESCRIPTION = :DESCRIPTION, SUB_PROJECT = :SUB_PROJECT, CATEGORY = :CATEGORY, PROCESS_ID = :PROCESS_ID, VERSION_ID = :VERSION_ID, IS_MASTER_VERSION = :IS_MASTER_VERSION, ATTRIBUTE_GUARANTEE = :ATTRIBUTE_GUARANTEE WHERE id = :id")
    public int update(@BindBean() FgProjects entity);

    @SqlQuery("DELETE FROM FG_PROJECTS WHERE id = :id")
    public int delete(@Bind("id") String id);
}
