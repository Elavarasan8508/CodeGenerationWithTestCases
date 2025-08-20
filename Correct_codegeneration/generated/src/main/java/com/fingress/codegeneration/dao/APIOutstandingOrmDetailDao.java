package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.APIOutstandingOrmDetail;
import com.bsit.codegeneration.mapper.APIOutstandingOrmDetailMapper;
import java.util.*;

@RegisterRowMapper(APIOutstandingOrmDetailMapper.class)
public interface APIOutstandingOrmDetailDao {

    @SqlQuery("SELECT * FROM API_OUTSTANDING_ORM_DETAIL")
    public List<APIOutstandingOrmDetail> findAll();

    @SqlQuery("SELECT * FROM API_OUTSTANDING_ORM_DETAIL WHERE id = :id")
    public Optional<APIOutstandingOrmDetail> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO API_OUTSTANDING_ORM_DETAIL(ORM_NUMBER, AD_CODE, REMITTANCE_AMOUNT, REMITTANCE_UTILIZED_AMOUNT, REMITTANCE_UNUTILIZED_AMOUNT, REMITTANCE_CURRENCY, REMITTANCE_DATE, IE_NAME, IE_CODE, BENEFICIARY_NAME, BENEFICIARY_COUNTRY, PURPOSE_OF_REMITTANCE) VALUES (:ORM_NUMBER, :AD_CODE, :REMITTANCE_AMOUNT, :REMITTANCE_UTILIZED_AMOUNT, :REMITTANCE_UNUTILIZED_AMOUNT, :REMITTANCE_CURRENCY, :REMITTANCE_DATE, :IE_NAME, :IE_CODE, :BENEFICIARY_NAME, :BENEFICIARY_COUNTRY, :PURPOSE_OF_REMITTANCE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() APIOutstandingOrmDetail entity);

    @SqlQuery("UPDATE API_OUTSTANDING_ORM_DETAIL SET ORM_NUMBER = :ORM_NUMBER, AD_CODE = :AD_CODE, REMITTANCE_AMOUNT = :REMITTANCE_AMOUNT, REMITTANCE_UTILIZED_AMOUNT = :REMITTANCE_UTILIZED_AMOUNT, REMITTANCE_UNUTILIZED_AMOUNT = :REMITTANCE_UNUTILIZED_AMOUNT, REMITTANCE_CURRENCY = :REMITTANCE_CURRENCY, REMITTANCE_DATE = :REMITTANCE_DATE, IE_NAME = :IE_NAME, IE_CODE = :IE_CODE, BENEFICIARY_NAME = :BENEFICIARY_NAME, BENEFICIARY_COUNTRY = :BENEFICIARY_COUNTRY, PURPOSE_OF_REMITTANCE = :PURPOSE_OF_REMITTANCE WHERE id = :id")
    public int update(@BindBean() APIOutstandingOrmDetail entity);

    @SqlQuery("DELETE FROM API_OUTSTANDING_ORM_DETAIL WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
