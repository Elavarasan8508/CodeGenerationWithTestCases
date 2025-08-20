package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgDatasetBkp191224;
import com.bsit.codegeneration.mapper.FgDatasetBkp191224Mapper;
import java.util.*;

@RegisterRowMapper(FgDatasetBkp191224Mapper.class)
public interface FgDatasetBkp191224Dao {

    @SqlQuery("SELECT * FROM FG_DATASET_BKP191224")
    public List<FgDatasetBkp191224> findAll();

    @SqlQuery("SELECT * FROM FG_DATASET_BKP191224 WHERE id = :id")
    public Optional<FgDatasetBkp191224> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_DATASET_BKP191224(ID, DATASOURCE_ID, CODE, NAME, MODEL_CODE, CONFIG, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UUID) VALUES (:ID, :DATASOURCE_ID, :CODE, :NAME, :MODEL_CODE, :CONFIG, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :UUID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgDatasetBkp191224 entity);

    @SqlQuery("UPDATE FG_DATASET_BKP191224 SET ID = :ID, DATASOURCE_ID = :DATASOURCE_ID, CODE = :CODE, NAME = :NAME, MODEL_CODE = :MODEL_CODE, CONFIG = :CONFIG, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, UUID = :UUID WHERE id = :id")
    public int update(@BindBean() FgDatasetBkp191224 entity);

    @SqlQuery("DELETE FROM FG_DATASET_BKP191224 WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
