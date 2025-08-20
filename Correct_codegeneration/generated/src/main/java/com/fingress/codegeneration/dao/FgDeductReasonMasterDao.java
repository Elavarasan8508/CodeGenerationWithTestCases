package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgDeductReasonMaster;
import com.bsit.codegeneration.mapper.FgDeductReasonMasterMapper;
import java.util.*;

@RegisterRowMapper(FgDeductReasonMasterMapper.class)
public interface FgDeductReasonMasterDao {

    @SqlQuery("SELECT * FROM FG_DEDUCT_REASON_MASTER")
    public List<FgDeductReasonMaster> findAll();

    @SqlQuery("SELECT * FROM FG_DEDUCT_REASON_MASTER WHERE id = :id")
    public Optional<FgDeductReasonMaster> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_DEDUCT_REASON_MASTER(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, REASON) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :REASON)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgDeductReasonMaster entity);

    @SqlQuery("UPDATE FG_DEDUCT_REASON_MASTER SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, REASON = :REASON WHERE id = :id")
    public int update(@BindBean() FgDeductReasonMaster entity);

    @SqlQuery("DELETE FROM FG_DEDUCT_REASON_MASTER WHERE id = :id")
    public int delete(@Bind("id") String id);
}
