package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgBusinessCode;
import com.bsit.codegeneration.mapper.FgBusinessCodeMapper;
import java.util.*;

@RegisterRowMapper(FgBusinessCodeMapper.class)
public interface FgBusinessCodeDao {

    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE")
    public List<FgBusinessCode> findAll();

    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE WHERE id = :id")
    public Optional<FgBusinessCode> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_BUSINESS_CODE(ID, NAME, CODE_TYPE, CODE_VALUE, PARENT_CODE, PARTY_ID, PARTY_VERSION_ID, PARENT_TYPE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_REF_ID, TAGS) VALUES (:ID, :NAME, :CODE_TYPE, :CODE_VALUE, :PARENT_CODE, :PARTY_ID, :PARTY_VERSION_ID, :PARENT_TYPE, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :PARENT_REF_ID, :TAGS)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgBusinessCode entity);

    @SqlQuery("UPDATE FG_BUSINESS_CODE SET ID = :ID, NAME = :NAME, CODE_TYPE = :CODE_TYPE, CODE_VALUE = :CODE_VALUE, PARENT_CODE = :PARENT_CODE, PARTY_ID = :PARTY_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, PARENT_TYPE = :PARENT_TYPE, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, PARENT_REF_ID = :PARENT_REF_ID, TAGS = :TAGS WHERE id = :id")
    public int update(@BindBean() FgBusinessCode entity);

    @SqlQuery("DELETE FROM FG_BUSINESS_CODE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
