package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgProductCodeMaster;
import com.bsit.codegeneration.mapper.FgProductCodeMasterMapper;
import java.util.*;

@RegisterRowMapper(FgProductCodeMasterMapper.class)
public interface FgProductCodeMasterDao {

    @SqlQuery("SELECT * FROM FG_PRODUCT_CODE_MASTER")
    public List<FgProductCodeMaster> findAll();

    @SqlQuery("SELECT * FROM FG_PRODUCT_CODE_MASTER WHERE id = :id")
    public Optional<FgProductCodeMaster> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_PRODUCT_CODE_MASTER(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CODE, PRODUCT_TYPE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :CODE, :PRODUCT_TYPE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgProductCodeMaster entity);

    @SqlQuery("UPDATE FG_PRODUCT_CODE_MASTER SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, CODE = :CODE, PRODUCT_TYPE = :PRODUCT_TYPE WHERE id = :id")
    public int update(@BindBean() FgProductCodeMaster entity);

    @SqlQuery("DELETE FROM FG_PRODUCT_CODE_MASTER WHERE id = :id")
    public int delete(@Bind("id") String id);
}
