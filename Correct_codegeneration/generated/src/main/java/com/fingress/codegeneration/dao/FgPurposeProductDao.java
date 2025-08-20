package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPurposeProduct;
import com.bsit.codegeneration.mapper.FgPurposeProductMapper;
import java.util.*;

@RegisterRowMapper(FgPurposeProductMapper.class)
public interface FgPurposeProductDao {

    @SqlQuery("SELECT * FROM FG_PURPOSE_PRODUCT")
    public List<FgPurposeProduct> findAll();

    @SqlQuery("SELECT * FROM FG_PURPOSE_PRODUCT WHERE id = :id")
    public Optional<FgPurposeProduct> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_PURPOSE_PRODUCT(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CODE, PRODUCT_TYPE, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :CODE, :PRODUCT_TYPE, :PARENT_REF_ID, :PARENT_VERSION_ID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgPurposeProduct entity);

    @SqlQuery("UPDATE FG_PURPOSE_PRODUCT SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, CODE = :CODE, PRODUCT_TYPE = :PRODUCT_TYPE, PARENT_REF_ID = :PARENT_REF_ID, PARENT_VERSION_ID = :PARENT_VERSION_ID WHERE id = :id")
    public int update(@BindBean() FgPurposeProduct entity);

    @SqlQuery("DELETE FROM FG_PURPOSE_PRODUCT WHERE id = :id")
    public int delete(@Bind("id") String id);
}
