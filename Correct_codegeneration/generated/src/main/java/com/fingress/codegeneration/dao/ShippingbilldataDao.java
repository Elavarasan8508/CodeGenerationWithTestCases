package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.Shippingbilldata;
import com.bsit.codegeneration.mapper.ShippingbilldataMapper;
import java.util.*;

@RegisterRowMapper(ShippingbilldataMapper.class)
public interface ShippingbilldataDao {

    @SqlQuery("SELECT * FROM SHIPPINGBILLDATA")
    public List<Shippingbilldata> findAll();

    @SqlQuery("SELECT * FROM SHIPPINGBILLDATA WHERE id = :id")
    public Optional<Shippingbilldata> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO SHIPPINGBILLDATA(STATUS, SHIPBILLNO, SHIPBILLDATE, PORTCODE, FORMNO, SHIPPINGBILLAMOUNT, SHIPPINGBILLCURR, UTILIZED_AMT, UNUTILIZED_AMT, BILLREFNO, COUNTER_PARTY) VALUES (:STATUS, :SHIPBILLNO, :SHIPBILLDATE, :PORTCODE, :FORMNO, :SHIPPINGBILLAMOUNT, :SHIPPINGBILLCURR, :UTILIZED_AMT, :UNUTILIZED_AMT, :BILLREFNO, :COUNTER_PARTY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() Shippingbilldata entity);

    @SqlQuery("UPDATE SHIPPINGBILLDATA SET STATUS = :STATUS, SHIPBILLNO = :SHIPBILLNO, SHIPBILLDATE = :SHIPBILLDATE, PORTCODE = :PORTCODE, FORMNO = :FORMNO, SHIPPINGBILLAMOUNT = :SHIPPINGBILLAMOUNT, SHIPPINGBILLCURR = :SHIPPINGBILLCURR, UTILIZED_AMT = :UTILIZED_AMT, UNUTILIZED_AMT = :UNUTILIZED_AMT, BILLREFNO = :BILLREFNO, COUNTER_PARTY = :COUNTER_PARTY WHERE id = :id")
    public int update(@BindBean() Shippingbilldata entity);

    @SqlQuery("DELETE FROM SHIPPINGBILLDATA WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
