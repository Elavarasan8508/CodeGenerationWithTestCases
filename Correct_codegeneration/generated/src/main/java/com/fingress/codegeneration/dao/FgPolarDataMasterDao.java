package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPolarDataMaster;
import com.bsit.codegeneration.mapper.FgPolarDataMasterMapper;
import java.util.*;

@RegisterRowMapper(FgPolarDataMasterMapper.class)
public interface FgPolarDataMasterDao {

    @SqlQuery("SELECT * FROM FG_POLAR_DATA_MASTER")
    public List<FgPolarDataMaster> findAll();

    @SqlQuery("SELECT * FROM FG_POLAR_DATA_MASTER WHERE id = :id")
    public Optional<FgPolarDataMaster> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_POLAR_DATA_MASTER(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VALUE_CODE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :VALUE_CODE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgPolarDataMaster entity);

    @SqlQuery("UPDATE FG_POLAR_DATA_MASTER SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, VALUE_CODE = :VALUE_CODE WHERE id = :id")
    public int update(@BindBean() FgPolarDataMaster entity);

    @SqlQuery("DELETE FROM FG_POLAR_DATA_MASTER WHERE id = :id")
    public int delete(@Bind("id") String id);
}
