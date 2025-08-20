package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.APIOutstandingEfircDetail;
import com.bsit.codegeneration.mapper.APIOutstandingEfircDetailMapper;
import java.util.*;

@RegisterRowMapper(APIOutstandingEfircDetailMapper.class)
public interface APIOutstandingEfircDetailDao {

    @SqlQuery("SELECT * FROM API_OUTSTANDING_EFIRC_DETAIL")
    public List<APIOutstandingEfircDetail> findAll();

    @SqlQuery("SELECT * FROM API_OUTSTANDING_EFIRC_DETAIL WHERE id = :id")
    public Optional<APIOutstandingEfircDetail> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO API_OUTSTANDING_EFIRC_DETAIL(FIRC_NUMBER, REMITTANCE_AMOUNT, AMOUNT_UTILIZED, AMOUNT_OUTSTANDING, SWIFT_CODE, FIRC_ISSUE_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMITTER_BANK_COUNTRY, FIRC_AD_CODE) VALUES (:FIRC_NUMBER, :REMITTANCE_AMOUNT, :AMOUNT_UTILIZED, :AMOUNT_OUTSTANDING, :SWIFT_CODE, :FIRC_ISSUE_DATE, :IE_CODE, :REMITTER_NAME, :REMITTER_COUNTRY, :REMITTER_BANK_COUNTRY, :FIRC_AD_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() APIOutstandingEfircDetail entity);

    @SqlQuery("UPDATE API_OUTSTANDING_EFIRC_DETAIL SET FIRC_NUMBER = :FIRC_NUMBER, REMITTANCE_AMOUNT = :REMITTANCE_AMOUNT, AMOUNT_UTILIZED = :AMOUNT_UTILIZED, AMOUNT_OUTSTANDING = :AMOUNT_OUTSTANDING, SWIFT_CODE = :SWIFT_CODE, FIRC_ISSUE_DATE = :FIRC_ISSUE_DATE, IE_CODE = :IE_CODE, REMITTER_NAME = :REMITTER_NAME, REMITTER_COUNTRY = :REMITTER_COUNTRY, REMITTER_BANK_COUNTRY = :REMITTER_BANK_COUNTRY, FIRC_AD_CODE = :FIRC_AD_CODE WHERE id = :id")
    public int update(@BindBean() APIOutstandingEfircDetail entity);

    @SqlQuery("DELETE FROM API_OUTSTANDING_EFIRC_DETAIL WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
