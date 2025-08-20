package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.ScfTxnBatchItem;
import com.bsit.codegeneration.mapper.ScfTxnBatchItemMapper;
import java.util.*;

@RegisterRowMapper(ScfTxnBatchItemMapper.class)
public interface ScfTxnBatchItemDao {

    @SqlQuery("SELECT * FROM SCF_TXN_BATCH_ITEM")
    public List<ScfTxnBatchItem> findAll();

    @SqlQuery("SELECT * FROM SCF_TXN_BATCH_ITEM WHERE id = :id")
    public Optional<ScfTxnBatchItem> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO SCF_TXN_BATCH_ITEM(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BATCH_REF_ID, TXN_REF_ID, ANCHOR_CRN, TXN_TYPE_CODE, TXN_SUB_TYPE_CODE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :BATCH_REF_ID, :TXN_REF_ID, :ANCHOR_CRN, :TXN_TYPE_CODE, :TXN_SUB_TYPE_CODE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() ScfTxnBatchItem entity);

    @SqlQuery("UPDATE SCF_TXN_BATCH_ITEM SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, BATCH_REF_ID = :BATCH_REF_ID, TXN_REF_ID = :TXN_REF_ID, ANCHOR_CRN = :ANCHOR_CRN, TXN_TYPE_CODE = :TXN_TYPE_CODE, TXN_SUB_TYPE_CODE = :TXN_SUB_TYPE_CODE WHERE id = :id")
    public int update(@BindBean() ScfTxnBatchItem entity);

    @SqlQuery("DELETE FROM SCF_TXN_BATCH_ITEM WHERE id = :id")
    public int delete(@Bind("id") String id);
}
