package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgModProductLink;
import com.bsit.codegeneration.mapper.FgModProductLinkMapper;
import java.util.*;

@RegisterRowMapper(FgModProductLinkMapper.class)
public interface FgModProductLinkDao {

    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_LINK")
    public List<FgModProductLink> findAll();

    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_LINK WHERE id = :id")
    public Optional<FgModProductLink> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MOD_PRODUCT_LINK(ID, REF_ID, TYPE_CODE, SUB_TYPE_CODE, CHILD_REF_ID, CHILD_TYPE_CODE, CHILD_SUB_TYPE_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, AMOUNT, FACE_VALUE, DISCOUNT_PERCENTAGE, REQUEST_PERCENTAGE, REQUESTED_AMOUNT, PROGRAM_CODE, OFFER_CODE) VALUES (:ID, :REF_ID, :TYPE_CODE, :SUB_TYPE_CODE, :CHILD_REF_ID, :CHILD_TYPE_CODE, :CHILD_SUB_TYPE_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :AMOUNT, :FACE_VALUE, :DISCOUNT_PERCENTAGE, :REQUEST_PERCENTAGE, :REQUESTED_AMOUNT, :PROGRAM_CODE, :OFFER_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgModProductLink entity);

    @SqlQuery("UPDATE FG_MOD_PRODUCT_LINK SET ID = :ID, REF_ID = :REF_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, CHILD_REF_ID = :CHILD_REF_ID, CHILD_TYPE_CODE = :CHILD_TYPE_CODE, CHILD_SUB_TYPE_CODE = :CHILD_SUB_TYPE_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, AMOUNT = :AMOUNT, FACE_VALUE = :FACE_VALUE, DISCOUNT_PERCENTAGE = :DISCOUNT_PERCENTAGE, REQUEST_PERCENTAGE = :REQUEST_PERCENTAGE, REQUESTED_AMOUNT = :REQUESTED_AMOUNT, PROGRAM_CODE = :PROGRAM_CODE, OFFER_CODE = :OFFER_CODE WHERE id = :id")
    public int update(@BindBean() FgModProductLink entity);

    @SqlQuery("DELETE FROM FG_MOD_PRODUCT_LINK WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
