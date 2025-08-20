package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgVault;
import com.bsit.codegeneration.mapper.FgVaultMapper;
import java.util.*;

@RegisterRowMapper(FgVaultMapper.class)
public interface FgVaultDao {

    @SqlQuery("SELECT * FROM FG_VAULT")
    public List<FgVault> findAll();

    @SqlQuery("SELECT * FROM FG_VAULT WHERE id = :id")
    public Optional<FgVault> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_VAULT(ID, ENTITY_REF_ID, ENTITY_SUB_TYPE_CODE, VAULT_TYPE, VAULT_DATA, ACTIVE_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_ID, ENTITY_VERSION_ID) VALUES (:ID, :ENTITY_REF_ID, :ENTITY_SUB_TYPE_CODE, :VAULT_TYPE, :VAULT_DATA, :ACTIVE_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :ENTITY_ID, :ENTITY_VERSION_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgVault entity);

    @SqlQuery("UPDATE FG_VAULT SET ID = :ID, ENTITY_REF_ID = :ENTITY_REF_ID, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE, VAULT_TYPE = :VAULT_TYPE, VAULT_DATA = :VAULT_DATA, ACTIVE_CODE = :ACTIVE_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, ENTITY_ID = :ENTITY_ID, ENTITY_VERSION_ID = :ENTITY_VERSION_ID WHERE id = :id")
    public int update(@BindBean() FgVault entity);

    @SqlQuery("DELETE FROM FG_VAULT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
