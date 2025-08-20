package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.IntMetadataStore;
import com.bsit.codegeneration.mapper.IntMetadataStoreMapper;
import java.util.*;

@RegisterRowMapper(IntMetadataStoreMapper.class)
public interface IntMetadataStoreDao {

    @SqlQuery("SELECT * FROM INT_METADATA_STORE")
    public List<IntMetadataStore> findAll();

    @SqlQuery("SELECT * FROM INT_METADATA_STORE WHERE id = :id")
    public Optional<IntMetadataStore> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO INT_METADATA_STORE(METADATA_KEY, METADATA_VALUE, REGION) VALUES (:METADATA_KEY, :METADATA_VALUE, :REGION)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() IntMetadataStore entity);

    @SqlQuery("UPDATE INT_METADATA_STORE SET METADATA_KEY = :METADATA_KEY, METADATA_VALUE = :METADATA_VALUE, REGION = :REGION WHERE id = :id")
    public int update(@BindBean() IntMetadataStore entity);

    @SqlQuery("DELETE FROM INT_METADATA_STORE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
