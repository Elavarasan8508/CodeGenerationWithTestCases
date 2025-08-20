package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.Shippinginvoicedata;
import com.bsit.codegeneration.mapper.ShippinginvoicedataMapper;
import java.util.*;

@RegisterRowMapper(ShippinginvoicedataMapper.class)
public interface ShippinginvoicedataDao {

    @SqlQuery("SELECT * FROM SHIPPINGINVOICEDATA")
    public List<Shippinginvoicedata> findAll();

    @SqlQuery("SELECT * FROM SHIPPINGINVOICEDATA WHERE id = :id")
    public Optional<Shippinginvoicedata> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO SHIPPINGINVOICEDATA(BILL_NO, SHIPBILLNO, SHIPBILLDATE, FORMNO, INV_SL_NO, INV_NO, INV_DATE, IE_CODE) VALUES (:BILL_NO, :SHIPBILLNO, :SHIPBILLDATE, :FORMNO, :INV_SL_NO, :INV_NO, :INV_DATE, :IE_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() Shippinginvoicedata entity);

    @SqlQuery("UPDATE SHIPPINGINVOICEDATA SET BILL_NO = :BILL_NO, SHIPBILLNO = :SHIPBILLNO, SHIPBILLDATE = :SHIPBILLDATE, FORMNO = :FORMNO, INV_SL_NO = :INV_SL_NO, INV_NO = :INV_NO, INV_DATE = :INV_DATE, IE_CODE = :IE_CODE WHERE id = :id")
    public int update(@BindBean() Shippinginvoicedata entity);

    @SqlQuery("DELETE FROM SHIPPINGINVOICEDATA WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
