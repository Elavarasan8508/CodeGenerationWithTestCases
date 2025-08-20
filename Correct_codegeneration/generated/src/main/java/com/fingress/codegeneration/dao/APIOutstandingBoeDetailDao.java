package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.APIOutstandingBoeDetail;
import com.bsit.codegeneration.mapper.APIOutstandingBoeDetailMapper;
import java.util.*;

@RegisterRowMapper(APIOutstandingBoeDetailMapper.class)
public interface APIOutstandingBoeDetailDao {

    @SqlQuery("SELECT * FROM API_OUTSTANDING_BOE_DETAIL")
    public List<APIOutstandingBoeDetail> findAll();

    @SqlQuery("SELECT * FROM API_OUTSTANDING_BOE_DETAIL WHERE id = :id")
    public Optional<APIOutstandingBoeDetail> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO API_OUTSTANDING_BOE_DETAIL(BOE_NUMBER, BOE_DATE, DISCHARGE_PORT, IMPORT_AGENCY, IE_CODE, INVOICE_SERIAL_NUMBER, INVOICE_NUMBER, INVOICE_TERM, SUPPLIER_NAME, SUPPLIER_ADDRESS, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDRESS, SELLER_COUNTRY, FOB_CURRENCY, FOB_VALUE, UTILIZED_FOB_VALUE, REFERENCE_ID) VALUES (:BOE_NUMBER, :BOE_DATE, :DISCHARGE_PORT, :IMPORT_AGENCY, :IE_CODE, :INVOICE_SERIAL_NUMBER, :INVOICE_NUMBER, :INVOICE_TERM, :SUPPLIER_NAME, :SUPPLIER_ADDRESS, :SUPPLIER_COUNTRY, :SELLER_NAME, :SELLER_ADDRESS, :SELLER_COUNTRY, :FOB_CURRENCY, :FOB_VALUE, :UTILIZED_FOB_VALUE, :REFERENCE_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() APIOutstandingBoeDetail entity);

    @SqlQuery("UPDATE API_OUTSTANDING_BOE_DETAIL SET BOE_NUMBER = :BOE_NUMBER, BOE_DATE = :BOE_DATE, DISCHARGE_PORT = :DISCHARGE_PORT, IMPORT_AGENCY = :IMPORT_AGENCY, IE_CODE = :IE_CODE, INVOICE_SERIAL_NUMBER = :INVOICE_SERIAL_NUMBER, INVOICE_NUMBER = :INVOICE_NUMBER, INVOICE_TERM = :INVOICE_TERM, SUPPLIER_NAME = :SUPPLIER_NAME, SUPPLIER_ADDRESS = :SUPPLIER_ADDRESS, SUPPLIER_COUNTRY = :SUPPLIER_COUNTRY, SELLER_NAME = :SELLER_NAME, SELLER_ADDRESS = :SELLER_ADDRESS, SELLER_COUNTRY = :SELLER_COUNTRY, FOB_CURRENCY = :FOB_CURRENCY, FOB_VALUE = :FOB_VALUE, UTILIZED_FOB_VALUE = :UTILIZED_FOB_VALUE, REFERENCE_ID = :REFERENCE_ID WHERE id = :id")
    public int update(@BindBean() APIOutstandingBoeDetail entity);

    @SqlQuery("DELETE FROM API_OUTSTANDING_BOE_DETAIL WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
