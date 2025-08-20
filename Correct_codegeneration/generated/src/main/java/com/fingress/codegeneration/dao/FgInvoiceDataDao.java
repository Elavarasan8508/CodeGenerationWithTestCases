package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgInvoiceData;
import com.bsit.codegeneration.mapper.FgInvoiceDataMapper;
import java.util.*;

@RegisterRowMapper(FgInvoiceDataMapper.class)
public interface FgInvoiceDataDao {

    @SqlQuery("SELECT * FROM FG_INVOICE_DATA")
    public List<FgInvoiceData> findAll();

    @SqlQuery("SELECT * FROM FG_INVOICE_DATA WHERE id = :id")
    public Optional<FgInvoiceData> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_INVOICE_DATA(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INVOICE_NUMBER, DATE, COMPANY_NAME, CONTACT_NO, SERVICE_FEE, COMPANY_ADDR) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :INVOICE_NUMBER, :DATE, :COMPANY_NAME, :CONTACT_NO, :SERVICE_FEE, :COMPANY_ADDR)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgInvoiceData entity);

    @SqlQuery("UPDATE FG_INVOICE_DATA SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, INVOICE_NUMBER = :INVOICE_NUMBER, DATE = :DATE, COMPANY_NAME = :COMPANY_NAME, CONTACT_NO = :CONTACT_NO, SERVICE_FEE = :SERVICE_FEE, COMPANY_ADDR = :COMPANY_ADDR WHERE id = :id")
    public int update(@BindBean() FgInvoiceData entity);

    @SqlQuery("DELETE FROM FG_INVOICE_DATA WHERE id = :id")
    public int delete(@Bind("id") String id);
}
