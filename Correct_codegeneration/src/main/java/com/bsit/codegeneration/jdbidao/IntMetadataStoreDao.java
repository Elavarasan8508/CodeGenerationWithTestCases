package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.batch.SqlBatch;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindList;
import java.util.List;
import java.util.Optional;
import java.util.Collection;
import com.bsit.codegeneration.entity.IntMetadataStore;

public interface IntMetadataStoreDao {

    /**
     * Inserts a new IntMetadataStore and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO INT_METADATA_STORE (METADATA_KEY, METADATA_VALUE, REGION) VALUES (:metadataKey, :metadataValue, :region)")
    public int insert(@Bind("metadataKey") String metadataKey, @Bind("metadataValue") String metadataValue, @Bind("region") String region);

    /**
     * Finds a IntMetadataStore by its ID.
     */
    @SqlQuery("SELECT * FROM INT_METADATA_STORE WHERE METADATA_KEY = :id")
    @RegisterBeanMapper(IntMetadataStore.class)
    public Optional<IntMetadataStore> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM INT_METADATA_STORE")
    @RegisterBeanMapper(IntMetadataStore.class)
    public List<IntMetadataStore> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM INT_METADATA_STORE ORDER BY METADATA_KEY LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(IntMetadataStore.class)
    public List<IntMetadataStore> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a IntMetadataStore and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE INT_METADATA_STORE SET METADATA_VALUE = :metadataValue WHERE METADATA_KEY = :metadataKey")
    public int update(@BindBean IntMetadataStore intmetadatastore);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM INT_METADATA_STORE WHERE METADATA_KEY = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM INT_METADATA_STORE")
    public long countAll();

    /**
     * Bulk insert multiple IntMetadataStore entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO INT_METADATA_STORE (METADATA_KEY, METADATA_VALUE, REGION) VALUES (:metadataKey, :metadataValue, :region)")
    public int[] bulkInsert(@BindBean List<IntMetadataStore> intmetadatastores);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO INT_METADATA_STORE (METADATA_KEY, METADATA_VALUE, REGION) VALUES (:metadataKey, :metadataValue, :region)")
    public int[] bulkInsertParams(@Bind("metadataKey") List<String> metadataKeys, @Bind("metadataValue") List<String> metadataValues, @Bind("region") List<String> regions);

    /**
     * Bulk update multiple IntMetadataStore entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE INT_METADATA_STORE SET METADATA_VALUE = :metadataValue WHERE METADATA_KEY = :metadataKey")
    public int[] bulkUpdate(@BindBean List<IntMetadataStore> intmetadatastores);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE INT_METADATA_STORE SET METADATA_VALUE = :metadataValue WHERE METADATA_KEY = :metadataKey")
    public int[] bulkUpdateParams(@Bind("metadataValue") List<String> metadataValues, @Bind("metadataKey") List<String> metadataKeys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM INT_METADATA_STORE WHERE METADATA_KEY IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM INT_METADATA_STORE WHERE METADATA_KEY = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple IntMetadataStore records by their IDs.
     */
    @SqlQuery("SELECT * FROM INT_METADATA_STORE WHERE METADATA_KEY IN (<ids>)")
    @RegisterBeanMapper(IntMetadataStore.class)
    public List<IntMetadataStore> findByIds(@BindList("ids") Collection<String> ids);
}
