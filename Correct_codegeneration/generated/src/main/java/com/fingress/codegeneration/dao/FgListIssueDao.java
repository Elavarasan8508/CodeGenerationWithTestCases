package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgListIssue;
import com.bsit.codegeneration.mapper.FgListIssueMapper;
import java.util.*;

@RegisterRowMapper(FgListIssueMapper.class)
public interface FgListIssueDao {

    @SqlQuery("SELECT * FROM FG_LIST_ISSUE")
    public List<FgListIssue> findAll();

    @SqlQuery("SELECT * FROM FG_LIST_ISSUE WHERE id = :id")
    public Optional<FgListIssue> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_LIST_ISSUE(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgListIssue entity);

    @SqlQuery("UPDATE FG_LIST_ISSUE SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE WHERE id = :id")
    public int update(@BindBean() FgListIssue entity);

    @SqlQuery("DELETE FROM FG_LIST_ISSUE WHERE id = :id")
    public int delete(@Bind("id") String id);
}
