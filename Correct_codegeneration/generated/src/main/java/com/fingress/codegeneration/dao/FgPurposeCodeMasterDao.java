package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPurposeCodeMaster;
import com.bsit.codegeneration.mapper.FgPurposeCodeMasterMapper;
import java.util.*;

@RegisterRowMapper(FgPurposeCodeMasterMapper.class)
public interface FgPurposeCodeMasterDao {

    @SqlQuery("SELECT * FROM FG_PURPOSE_CODE_MASTER")
    public List<FgPurposeCodeMaster> findAll();

    @SqlQuery("SELECT * FROM FG_PURPOSE_CODE_MASTER WHERE id = :id")
    public Optional<FgPurposeCodeMaster> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_PURPOSE_CODE_MASTER(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, DESCRIPTION, TYPE, PRODUCT_CODE, MT103, MT202, MT103_202, REQ_TYPE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :PURPOSE_CODE, :DESCRIPTION, :TYPE, :PRODUCT_CODE, :MT103, :MT202, :MT103_202, :REQ_TYPE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgPurposeCodeMaster entity);

    @SqlQuery("UPDATE FG_PURPOSE_CODE_MASTER SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, PURPOSE_CODE = :PURPOSE_CODE, DESCRIPTION = :DESCRIPTION, TYPE = :TYPE, PRODUCT_CODE = :PRODUCT_CODE, MT103 = :MT103, MT202 = :MT202, MT103_202 = :MT103_202, REQ_TYPE = :REQ_TYPE WHERE id = :id")
    public int update(@BindBean() FgPurposeCodeMaster entity);

    @SqlQuery("DELETE FROM FG_PURPOSE_CODE_MASTER WHERE id = :id")
    public int delete(@Bind("id") String id);
}
