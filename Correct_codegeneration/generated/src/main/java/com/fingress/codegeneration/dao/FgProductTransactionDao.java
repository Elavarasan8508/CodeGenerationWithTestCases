package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgProductTransaction;
import com.bsit.codegeneration.mapper.FgProductTransactionMapper;
import java.util.*;

@RegisterRowMapper(FgProductTransactionMapper.class)
public interface FgProductTransactionDao {

    @SqlQuery("SELECT * FROM FG_PRODUCT_TRANSACTION")
    public List<FgProductTransaction> findAll();

    @SqlQuery("SELECT * FROM FG_PRODUCT_TRANSACTION WHERE id = :id")
    public Optional<FgProductTransaction> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PRODUCT_TRANSACTION(ID, PAYMENT_ID, ENTITY_REFERENCE_ID, TRANSACTION_DATE, CURRENCY_CODE, TRANSACTION_AMOUNT, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :PAYMENT_ID, :ENTITY_REFERENCE_ID, :TRANSACTION_DATE, :CURRENCY_CODE, :TRANSACTION_AMOUNT, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgProductTransaction entity);

    @SqlQuery("UPDATE FG_PRODUCT_TRANSACTION SET ID = :ID, PAYMENT_ID = :PAYMENT_ID, ENTITY_REFERENCE_ID = :ENTITY_REFERENCE_ID, TRANSACTION_DATE = :TRANSACTION_DATE, CURRENCY_CODE = :CURRENCY_CODE, TRANSACTION_AMOUNT = :TRANSACTION_AMOUNT, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgProductTransaction entity);

    @SqlQuery("DELETE FROM FG_PRODUCT_TRANSACTION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
