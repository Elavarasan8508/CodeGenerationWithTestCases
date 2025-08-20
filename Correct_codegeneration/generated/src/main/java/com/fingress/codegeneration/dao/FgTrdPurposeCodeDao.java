package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTrdPurposeCode;
import com.bsit.codegeneration.mapper.FgTrdPurposeCodeMapper;
import java.util.*;

@RegisterRowMapper(FgTrdPurposeCodeMapper.class)
public interface FgTrdPurposeCodeDao {

    @SqlQuery("SELECT * FROM FG_TRD_PURPOSE_CODE")
    public List<FgTrdPurposeCode> findAll();

    @SqlQuery("SELECT * FROM FG_TRD_PURPOSE_CODE WHERE id = :id")
    public Optional<FgTrdPurposeCode> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TRD_PURPOSE_CODE(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, DESCRIPTION, TYPE, CUR_CODE, AMT, PARENT_REF_ID, PARENT_VERSION_ID, PRODUCT_CODE, IR_REFERENCE_ID, XAR_LTEA_INDICATOR) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :PURPOSE_CODE, :DESCRIPTION, :TYPE, :CUR_CODE, :AMT, :PARENT_REF_ID, :PARENT_VERSION_ID, :PRODUCT_CODE, :IR_REFERENCE_ID, :XAR_LTEA_INDICATOR)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTrdPurposeCode entity);

    @SqlQuery("UPDATE FG_TRD_PURPOSE_CODE SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, PURPOSE_CODE = :PURPOSE_CODE, DESCRIPTION = :DESCRIPTION, TYPE = :TYPE, CUR_CODE = :CUR_CODE, AMT = :AMT, PARENT_REF_ID = :PARENT_REF_ID, PARENT_VERSION_ID = :PARENT_VERSION_ID, PRODUCT_CODE = :PRODUCT_CODE, IR_REFERENCE_ID = :IR_REFERENCE_ID, XAR_LTEA_INDICATOR = :XAR_LTEA_INDICATOR WHERE id = :id")
    public int update(@BindBean() FgTrdPurposeCode entity);

    @SqlQuery("DELETE FROM FG_TRD_PURPOSE_CODE WHERE id = :id")
    public int delete(@Bind("id") String id);
}
