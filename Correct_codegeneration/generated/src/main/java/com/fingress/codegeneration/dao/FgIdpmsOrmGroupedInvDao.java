package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgIdpmsOrmGroupedInv;
import com.bsit.codegeneration.mapper.FgIdpmsOrmGroupedInvMapper;
import java.util.*;

@RegisterRowMapper(FgIdpmsOrmGroupedInvMapper.class)
public interface FgIdpmsOrmGroupedInvDao {

    @SqlQuery("SELECT * FROM FG_IDPMS_ORM_GROUPED_INV")
    public List<FgIdpmsOrmGroupedInv> findAll();

    @SqlQuery("SELECT * FROM FG_IDPMS_ORM_GROUPED_INV WHERE id = :id")
    public Optional<FgIdpmsOrmGroupedInv> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_IDPMS_ORM_GROUPED_INV(INV_NUM, UTIL_AMT, ENDORSED_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TEMPLATE, ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, LAST_UPDATED_ON, LAST_AUTHORISED_ON, CREATED_BY, LAST_UPDATED_BY, LAST_AUTHORISED_BY) VALUES (:INV_NUM, :UTIL_AMT, :ENDORSED_AMT, :PARENT_REF_ID, :PARENT_VERSION_ID, :IS_TEMPLATE, :TEMPLATE, :ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :LAST_UPDATED_ON, :LAST_AUTHORISED_ON, :CREATED_BY, :LAST_UPDATED_BY, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgIdpmsOrmGroupedInv entity);

    @SqlQuery("UPDATE FG_IDPMS_ORM_GROUPED_INV SET INV_NUM = :INV_NUM, UTIL_AMT = :UTIL_AMT, ENDORSED_AMT = :ENDORSED_AMT, PARENT_REF_ID = :PARENT_REF_ID, PARENT_VERSION_ID = :PARENT_VERSION_ID, IS_TEMPLATE = :IS_TEMPLATE, TEMPLATE = :TEMPLATE, ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgIdpmsOrmGroupedInv entity);

    @SqlQuery("DELETE FROM FG_IDPMS_ORM_GROUPED_INV WHERE id = :id")
    public int delete(@Bind("id") String id);
}
