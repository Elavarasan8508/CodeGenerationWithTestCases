package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgDataset;
import com.bsit.codegeneration.mapper.FgDatasetMapper;
import java.util.*;

@RegisterRowMapper(FgDatasetMapper.class)
public interface FgDatasetDao {

    @SqlQuery("SELECT * FROM FG_DATASET")
    public List<FgDataset> findAll();

    @SqlQuery("SELECT * FROM FG_DATASET WHERE id = :id")
    public Optional<FgDataset> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_DATASET(ID, DATASOURCE_ID, CODE, NAME, MODEL_CODE, CONFIG, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UUID, MASTER_TEMPLATE, MASTER_CONTENT_HASH, IS_MASTER_VERSION, VERSION_ID) VALUES (:ID, :DATASOURCE_ID, :CODE, :NAME, :MODEL_CODE, :CONFIG, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :UUID, :MASTER_TEMPLATE, :MASTER_CONTENT_HASH, :IS_MASTER_VERSION, :VERSION_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgDataset entity);

    @SqlQuery("UPDATE FG_DATASET SET ID = :ID, DATASOURCE_ID = :DATASOURCE_ID, CODE = :CODE, NAME = :NAME, MODEL_CODE = :MODEL_CODE, CONFIG = :CONFIG, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, UUID = :UUID, MASTER_TEMPLATE = :MASTER_TEMPLATE, MASTER_CONTENT_HASH = :MASTER_CONTENT_HASH, IS_MASTER_VERSION = :IS_MASTER_VERSION, VERSION_ID = :VERSION_ID WHERE id = :id")
    public int update(@BindBean() FgDataset entity);

    @SqlQuery("DELETE FROM FG_DATASET WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
