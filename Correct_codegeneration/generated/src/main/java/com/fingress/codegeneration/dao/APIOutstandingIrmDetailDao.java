package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.APIOutstandingIrmDetail;
import com.bsit.codegeneration.mapper.APIOutstandingIrmDetailMapper;
import java.util.*;

@RegisterRowMapper(APIOutstandingIrmDetailMapper.class)
public interface APIOutstandingIrmDetailDao {

    @SqlQuery("SELECT * FROM API_OUTSTANDING_IRM_DETAIL")
    public List<APIOutstandingIrmDetail> findAll();

    @SqlQuery("SELECT * FROM API_OUTSTANDING_IRM_DETAIL WHERE id = :id")
    public Optional<APIOutstandingIrmDetail> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO API_OUTSTANDING_IRM_DETAIL(IRM_NUMBER, AD_CODE, REMITTANCE_AMOUNT, AMOUNT_OUTSTANDING, REMITTANCE_CURRENCY, REMITTANCE_DATE, IE_CODE, REMITTER_NAME) VALUES (:IRM_NUMBER, :AD_CODE, :REMITTANCE_AMOUNT, :AMOUNT_OUTSTANDING, :REMITTANCE_CURRENCY, :REMITTANCE_DATE, :IE_CODE, :REMITTER_NAME)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() APIOutstandingIrmDetail entity);

    @SqlQuery("UPDATE API_OUTSTANDING_IRM_DETAIL SET IRM_NUMBER = :IRM_NUMBER, AD_CODE = :AD_CODE, REMITTANCE_AMOUNT = :REMITTANCE_AMOUNT, AMOUNT_OUTSTANDING = :AMOUNT_OUTSTANDING, REMITTANCE_CURRENCY = :REMITTANCE_CURRENCY, REMITTANCE_DATE = :REMITTANCE_DATE, IE_CODE = :IE_CODE, REMITTER_NAME = :REMITTER_NAME WHERE id = :id")
    public int update(@BindBean() APIOutstandingIrmDetail entity);

    @SqlQuery("DELETE FROM API_OUTSTANDING_IRM_DETAIL WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
