package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgDatasource;
import com.bsit.codegeneration.mapper.FgDatasourceMapper;
import java.util.*;

@RegisterRowMapper(FgDatasourceMapper.class)
public interface FgDatasourceDao {

    @SqlQuery("SELECT * FROM FG_DATASOURCE")
    public List<FgDatasource> findAll();

    @SqlQuery("SELECT * FROM FG_DATASOURCE WHERE id = :id")
    public Optional<FgDatasource> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_DATASOURCE(ID, CODE, NAME, CONFIG, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UUID, MASTER_TEMPLATE, MASTER_CONTENT_HASH, IS_MASTER_VERSION, VERSION_ID) VALUES (:ID, :CODE, :NAME, :CONFIG, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :UUID, :MASTER_TEMPLATE, :MASTER_CONTENT_HASH, :IS_MASTER_VERSION, :VERSION_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgDatasource entity);

    @SqlQuery("UPDATE FG_DATASOURCE SET ID = :ID, CODE = :CODE, NAME = :NAME, CONFIG = :CONFIG, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, UUID = :UUID, MASTER_TEMPLATE = :MASTER_TEMPLATE, MASTER_CONTENT_HASH = :MASTER_CONTENT_HASH, IS_MASTER_VERSION = :IS_MASTER_VERSION, VERSION_ID = :VERSION_ID WHERE id = :id")
    public int update(@BindBean() FgDatasource entity);

    @SqlQuery("DELETE FROM FG_DATASOURCE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
