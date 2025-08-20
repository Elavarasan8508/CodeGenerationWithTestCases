package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgDocumentTemplate;
import com.bsit.codegeneration.mapper.FgDocumentTemplateMapper;
import java.util.*;

@RegisterRowMapper(FgDocumentTemplateMapper.class)
public interface FgDocumentTemplateDao {

    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE")
    public List<FgDocumentTemplate> findAll();

    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE WHERE id = :id")
    public Optional<FgDocumentTemplate> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_DOCUMENT_TEMPLATE(ID, REFERENCE_ID, NAME, TYPE_CODE, SUB_TYPE_CODE, IS_DEFAULT, PURPOSE_CODE, RENDER_TYPE_CODE, DESCRIPTION, TEMPLATE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :REFERENCE_ID, :NAME, :TYPE_CODE, :SUB_TYPE_CODE, :IS_DEFAULT, :PURPOSE_CODE, :RENDER_TYPE_CODE, :DESCRIPTION, :TEMPLATE, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgDocumentTemplate entity);

    @SqlQuery("UPDATE FG_DOCUMENT_TEMPLATE SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, NAME = :NAME, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, IS_DEFAULT = :IS_DEFAULT, PURPOSE_CODE = :PURPOSE_CODE, RENDER_TYPE_CODE = :RENDER_TYPE_CODE, DESCRIPTION = :DESCRIPTION, TEMPLATE = :TEMPLATE, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgDocumentTemplate entity);

    @SqlQuery("DELETE FROM FG_DOCUMENT_TEMPLATE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
