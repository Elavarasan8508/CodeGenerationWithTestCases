package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgEntityCategory;
import com.bsit.codegeneration.mapper.FgEntityCategoryMapper;
import java.util.*;

@RegisterRowMapper(FgEntityCategoryMapper.class)
public interface FgEntityCategoryDao {

    @SqlQuery("SELECT * FROM FG_ENTITY_CATEGORY")
    public List<FgEntityCategory> findAll();

    @SqlQuery("SELECT * FROM FG_ENTITY_CATEGORY WHERE id = :id")
    public Optional<FgEntityCategory> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ENTITY_CATEGORY(ID, CODE, CONFIG_STATUS_CODE, NAME, PARENT_CATEGORY_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :CODE, :CONFIG_STATUS_CODE, :NAME, :PARENT_CATEGORY_CODE, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgEntityCategory entity);

    @SqlQuery("UPDATE FG_ENTITY_CATEGORY SET ID = :ID, CODE = :CODE, CONFIG_STATUS_CODE = :CONFIG_STATUS_CODE, NAME = :NAME, PARENT_CATEGORY_CODE = :PARENT_CATEGORY_CODE, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgEntityCategory entity);

    @SqlQuery("DELETE FROM FG_ENTITY_CATEGORY WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
