package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgLayoutTemplateColumns;
import com.bsit.codegeneration.mapper.FgLayoutTemplateColumnsMapper;
import java.util.*;

@RegisterRowMapper(FgLayoutTemplateColumnsMapper.class)
public interface FgLayoutTemplateColumnsDao {

    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_COLUMNS")
    public List<FgLayoutTemplateColumns> findAll();

    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_COLUMNS WHERE id = :id")
    public Optional<FgLayoutTemplateColumns> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_LAYOUT_TEMPLATE_COLUMNS(ID, NAME, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE_COLUMNS) VALUES (:ID, :NAME, :TYPE_CODE, :SUB_TYPE_CODE, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE_COLUMNS)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgLayoutTemplateColumns entity);

    @SqlQuery("UPDATE FG_LAYOUT_TEMPLATE_COLUMNS SET ID = :ID, NAME = :NAME, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE_COLUMNS = :TEMPLATE_COLUMNS WHERE id = :id")
    public int update(@BindBean() FgLayoutTemplateColumns entity);

    @SqlQuery("DELETE FROM FG_LAYOUT_TEMPLATE_COLUMNS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
