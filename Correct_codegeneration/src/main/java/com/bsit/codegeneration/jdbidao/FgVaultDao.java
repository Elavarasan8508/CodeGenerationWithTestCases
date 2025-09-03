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
import com.bsit.codegeneration.entity.FgVault;

public interface FgVaultDao {

    /**
     * Inserts a new FgVault and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_VAULT (ID, ENTITY_REF_ID, ENTITY_SUB_TYPE_CODE, VAULT_TYPE, VAULT_DATA, ACTIVE_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_ID, ENTITY_VERSION_ID) VALUES (:id, :entityRefId, :entitySubTypeCode, :vaultType, :vaultData, :activeCode, :lastAuthorisedOn, :lastAuthorisedBy, :entityId, :entityVersionId)")
    public int insert(@BindBean FgVault fgvault);

    /**
     * Finds a FgVault by its ID.
     */
    @SqlQuery("SELECT * FROM FG_VAULT WHERE ID = :id")
    @RegisterBeanMapper(FgVault.class)
    public Optional<FgVault> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_VAULT")
    @RegisterBeanMapper(FgVault.class)
    public List<FgVault> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_VAULT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgVault.class)
    public List<FgVault> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgVault and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_VAULT SET ENTITY_REF_ID = :entityRefId, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, VAULT_TYPE = :vaultType, VAULT_DATA = :vaultData, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ENTITY_ID = :entityId, ENTITY_VERSION_ID = :entityVersionId WHERE ID = :id")
    public int update(@BindBean FgVault fgvault);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_VAULT WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_VAULT")
    public long countAll();

    /**
     * Bulk insert multiple FgVault entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_VAULT (ID, ENTITY_REF_ID, ENTITY_SUB_TYPE_CODE, VAULT_TYPE, VAULT_DATA, ACTIVE_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_ID, ENTITY_VERSION_ID) VALUES (:id, :entityRefId, :entitySubTypeCode, :vaultType, :vaultData, :activeCode, :lastAuthorisedOn, :lastAuthorisedBy, :entityId, :entityVersionId)")
    public int[] bulkInsert(@BindBean List<FgVault> fgvaults);

    /**
     * Bulk update multiple FgVault entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_VAULT SET ENTITY_REF_ID = :entityRefId, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, VAULT_TYPE = :vaultType, VAULT_DATA = :vaultData, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ENTITY_ID = :entityId, ENTITY_VERSION_ID = :entityVersionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgVault> fgvaults);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_VAULT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_VAULT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgVault records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_VAULT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgVault.class)
    public List<FgVault> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
