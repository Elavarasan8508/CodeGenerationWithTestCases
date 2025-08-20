package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTdLiqView;
import com.bsit.codegeneration.mapper.FgTdLiqViewMapper;
import java.util.*;

@RegisterRowMapper(FgTdLiqViewMapper.class)
public interface FgTdLiqViewDao {

    @SqlQuery("SELECT * FROM FG_TD_LIQ_VIEW")
    public List<FgTdLiqView> findAll();

    @SqlQuery("SELECT * FROM FG_TD_LIQ_VIEW WHERE id = :id")
    public Optional<FgTdLiqView> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_TD_LIQ_VIEW(REFERENCE_ID, PRODUCT_STATUS, STATUS_CODE, STAGE_CODE, SUB_TYPE_CODE, TYPE_CODE, CREATED_ON, LAST_UPDATED_ON, PROCESS_ID) VALUES (:REFERENCE_ID, :PRODUCT_STATUS, :STATUS_CODE, :STAGE_CODE, :SUB_TYPE_CODE, :TYPE_CODE, :CREATED_ON, :LAST_UPDATED_ON, :PROCESS_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgTdLiqView entity);

    @SqlQuery("UPDATE FG_TD_LIQ_VIEW SET REFERENCE_ID = :REFERENCE_ID, PRODUCT_STATUS = :PRODUCT_STATUS, STATUS_CODE = :STATUS_CODE, STAGE_CODE = :STAGE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, TYPE_CODE = :TYPE_CODE, CREATED_ON = :CREATED_ON, LAST_UPDATED_ON = :LAST_UPDATED_ON, PROCESS_ID = :PROCESS_ID WHERE id = :id")
    public int update(@BindBean() FgTdLiqView entity);

    @SqlQuery("DELETE FROM FG_TD_LIQ_VIEW WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
