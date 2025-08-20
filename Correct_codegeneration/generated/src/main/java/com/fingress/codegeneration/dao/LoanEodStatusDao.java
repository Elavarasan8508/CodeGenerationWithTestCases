package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.LoanEodStatus;
import com.bsit.codegeneration.mapper.LoanEodStatusMapper;
import java.util.*;

@RegisterRowMapper(LoanEodStatusMapper.class)
public interface LoanEodStatusDao {

    @SqlQuery("SELECT * FROM LOAN_EOD_STATUS")
    public List<LoanEodStatus> findAll();

    @SqlQuery("SELECT * FROM LOAN_EOD_STATUS WHERE id = :id")
    public Optional<LoanEodStatus> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO LOAN_EOD_STATUS(JOB_ID, JOB_NAME, JOB_STATUS, JOB_EXIT_CODE, EOD_START_DATE, EOD_END_DATE, REMARKS, STATUS) VALUES (:JOB_ID, :JOB_NAME, :JOB_STATUS, :JOB_EXIT_CODE, :EOD_START_DATE, :EOD_END_DATE, :REMARKS, :STATUS)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() LoanEodStatus entity);

    @SqlQuery("UPDATE LOAN_EOD_STATUS SET JOB_ID = :JOB_ID, JOB_NAME = :JOB_NAME, JOB_STATUS = :JOB_STATUS, JOB_EXIT_CODE = :JOB_EXIT_CODE, EOD_START_DATE = :EOD_START_DATE, EOD_END_DATE = :EOD_END_DATE, REMARKS = :REMARKS, STATUS = :STATUS WHERE id = :id")
    public int update(@BindBean() LoanEodStatus entity);

    @SqlQuery("DELETE FROM LOAN_EOD_STATUS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
