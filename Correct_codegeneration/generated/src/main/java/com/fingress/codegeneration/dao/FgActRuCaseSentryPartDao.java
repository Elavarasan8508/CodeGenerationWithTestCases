package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuCaseSentryPart;
import com.bsit.codegeneration.mapper.FgActRuCaseSentryPartMapper;
import java.util.*;

@RegisterRowMapper(FgActRuCaseSentryPartMapper.class)
public interface FgActRuCaseSentryPartDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_SENTRY_PART")
    public List<FgActRuCaseSentryPart> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_SENTRY_PART WHERE id = :id")
    public Optional<FgActRuCaseSentryPart> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_CASE_SENTRY_PART(ID_, REV_, CASE_INST_ID_, CASE_EXEC_ID_, SENTRY_ID_, TYPE_, SOURCE_CASE_EXEC_ID_, STANDARD_EVENT_, SOURCE_, VARIABLE_EVENT_, VARIABLE_NAME_, SATISFIED_, TENANT_ID_) VALUES (:ID_, :REV_, :CASE_INST_ID_, :CASE_EXEC_ID_, :SENTRY_ID_, :TYPE_, :SOURCE_CASE_EXEC_ID_, :STANDARD_EVENT_, :SOURCE_, :VARIABLE_EVENT_, :VARIABLE_NAME_, :SATISFIED_, :TENANT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuCaseSentryPart entity);

    @SqlQuery("UPDATE FG_ACT_RU_CASE_SENTRY_PART SET ID_ = :ID_, REV_ = :REV_, CASE_INST_ID_ = :CASE_INST_ID_, CASE_EXEC_ID_ = :CASE_EXEC_ID_, SENTRY_ID_ = :SENTRY_ID_, TYPE_ = :TYPE_, SOURCE_CASE_EXEC_ID_ = :SOURCE_CASE_EXEC_ID_, STANDARD_EVENT_ = :STANDARD_EVENT_, SOURCE_ = :SOURCE_, VARIABLE_EVENT_ = :VARIABLE_EVENT_, VARIABLE_NAME_ = :VARIABLE_NAME_, SATISFIED_ = :SATISFIED_, TENANT_ID_ = :TENANT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuCaseSentryPart entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_CASE_SENTRY_PART WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
