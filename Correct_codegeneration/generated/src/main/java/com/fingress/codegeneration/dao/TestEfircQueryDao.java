package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.TestEfircQuery;
import com.bsit.codegeneration.mapper.TestEfircQueryMapper;
import java.util.*;

@RegisterRowMapper(TestEfircQueryMapper.class)
public interface TestEfircQueryDao {

    @SqlQuery("SELECT * FROM TEST_EFIRC_QUERY")
    public List<TestEfircQuery> findAll();

    @SqlQuery("SELECT * FROM TEST_EFIRC_QUERY WHERE id = :id")
    public Optional<TestEfircQuery> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO TEST_EFIRC_QUERY(FIRC_NUMBER, FIRC_AD_CODE, REMITTANCE_AMOUNT, AMOUNT_UTILIZED, AMOUNT_OUTSTANDING, SWIFT_CODE, FIRC_ISSUE_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMITTER_BANK_COUNTRY) VALUES (:FIRC_NUMBER, :FIRC_AD_CODE, :REMITTANCE_AMOUNT, :AMOUNT_UTILIZED, :AMOUNT_OUTSTANDING, :SWIFT_CODE, :FIRC_ISSUE_DATE, :IE_CODE, :REMITTER_NAME, :REMITTER_COUNTRY, :REMITTER_BANK_COUNTRY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() TestEfircQuery entity);

    @SqlQuery("UPDATE TEST_EFIRC_QUERY SET FIRC_NUMBER = :FIRC_NUMBER, FIRC_AD_CODE = :FIRC_AD_CODE, REMITTANCE_AMOUNT = :REMITTANCE_AMOUNT, AMOUNT_UTILIZED = :AMOUNT_UTILIZED, AMOUNT_OUTSTANDING = :AMOUNT_OUTSTANDING, SWIFT_CODE = :SWIFT_CODE, FIRC_ISSUE_DATE = :FIRC_ISSUE_DATE, IE_CODE = :IE_CODE, REMITTER_NAME = :REMITTER_NAME, REMITTER_COUNTRY = :REMITTER_COUNTRY, REMITTER_BANK_COUNTRY = :REMITTER_BANK_COUNTRY WHERE id = :id")
    public int update(@BindBean() TestEfircQuery entity);

    @SqlQuery("DELETE FROM TEST_EFIRC_QUERY WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
