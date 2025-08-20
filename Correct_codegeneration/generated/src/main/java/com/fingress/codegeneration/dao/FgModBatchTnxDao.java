package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgModBatchTnx;
import com.bsit.codegeneration.mapper.FgModBatchTnxMapper;
import java.util.*;

@RegisterRowMapper(FgModBatchTnxMapper.class)
public interface FgModBatchTnxDao {

    @SqlQuery("SELECT * FROM FG_MOD_BATCH_TNX")
    public List<FgModBatchTnx> findAll();

    @SqlQuery("SELECT * FROM FG_MOD_BATCH_TNX WHERE id = :id")
    public Optional<FgModBatchTnx> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MOD_BATCH_TNX(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, PARENT_REF_ID, PARENT_REF_VERSION_ID, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_VERSION_ID, IS_TEMPLATE, ENTITY_REF_ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_VERSION_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :PARENT_REF_ID, :PARENT_REF_VERSION_ID, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :PARENT_VERSION_ID, :IS_TEMPLATE, :ENTITY_REF_ID, :ENTITY_SUB_TYPE_CODE, :ENTITY_TYPE_CODE, :ENTITY_VERSION_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgModBatchTnx entity);

    @SqlQuery("UPDATE FG_MOD_BATCH_TNX SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, PARENT_REF_ID = :PARENT_REF_ID, PARENT_REF_VERSION_ID = :PARENT_REF_VERSION_ID, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, PARENT_VERSION_ID = :PARENT_VERSION_ID, IS_TEMPLATE = :IS_TEMPLATE, ENTITY_REF_ID = :ENTITY_REF_ID, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE = :ENTITY_TYPE_CODE, ENTITY_VERSION_ID = :ENTITY_VERSION_ID WHERE id = :id")
    public int update(@BindBean() FgModBatchTnx entity);

    @SqlQuery("DELETE FROM FG_MOD_BATCH_TNX WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
