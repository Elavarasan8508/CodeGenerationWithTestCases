package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgDocumentTemplateParty;
import com.bsit.codegeneration.mapper.FgDocumentTemplatePartyMapper;
import java.util.*;

@RegisterRowMapper(FgDocumentTemplatePartyMapper.class)
public interface FgDocumentTemplatePartyDao {

    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE_PARTY")
    public List<FgDocumentTemplateParty> findAll();

    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE_PARTY WHERE id = :id")
    public Optional<FgDocumentTemplateParty> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_DOCUMENT_TEMPLATE_PARTY(ID, PARTY_ID, PARTY_VERSION_ID, DOCUMENT_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :PARTY_ID, :PARTY_VERSION_ID, :DOCUMENT_ID, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgDocumentTemplateParty entity);

    @SqlQuery("UPDATE FG_DOCUMENT_TEMPLATE_PARTY SET ID = :ID, PARTY_ID = :PARTY_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, DOCUMENT_ID = :DOCUMENT_ID, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgDocumentTemplateParty entity);

    @SqlQuery("DELETE FROM FG_DOCUMENT_TEMPLATE_PARTY WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
