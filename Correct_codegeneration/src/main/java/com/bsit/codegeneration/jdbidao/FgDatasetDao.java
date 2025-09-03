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
import com.bsit.codegeneration.entity.FgDataset;

public interface FgDatasetDao {

    /**
     * Inserts a new FgDataset and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_DATASET (ID, DATASOURCE_ID, CODE, NAME, MODEL_CODE, CONFIG, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UUID, MASTER_TEMPLATE, MASTER_CONTENT_HASH, IS_MASTER_VERSION, VERSION_ID) VALUES (:id, :datasourceId, :code, :name, :modelCode, :config, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :uuid, :masterTemplate, :masterContentHash, :isMasterVersion, :versionId)")
    public int insert(@BindBean FgDataset fgdataset);

    /**
     * Finds a FgDataset by its ID.
     */
    @SqlQuery("SELECT * FROM FG_DATASET WHERE ID = :id")
    @RegisterBeanMapper(FgDataset.class)
    public Optional<FgDataset> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_DATASET")
    @RegisterBeanMapper(FgDataset.class)
    public List<FgDataset> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_DATASET ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgDataset.class)
    public List<FgDataset> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgDataset and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_DATASET SET DATASOURCE_ID = :datasourceId, CODE = :code, NAME = :name, MODEL_CODE = :modelCode, CONFIG = :config, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, UUID = :uuid, MASTER_TEMPLATE = :masterTemplate, MASTER_CONTENT_HASH = :masterContentHash, IS_MASTER_VERSION = :isMasterVersion, VERSION_ID = :versionId WHERE ID = :id")
    public int update(@BindBean FgDataset fgdataset);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DATASET WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_DATASET")
    public long countAll();

    /**
     * Bulk insert multiple FgDataset entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_DATASET (ID, DATASOURCE_ID, CODE, NAME, MODEL_CODE, CONFIG, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UUID, MASTER_TEMPLATE, MASTER_CONTENT_HASH, IS_MASTER_VERSION, VERSION_ID) VALUES (:id, :datasourceId, :code, :name, :modelCode, :config, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :uuid, :masterTemplate, :masterContentHash, :isMasterVersion, :versionId)")
    public int[] bulkInsert(@BindBean List<FgDataset> fgdatasets);

    /**
     * Bulk update multiple FgDataset entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_DATASET SET DATASOURCE_ID = :datasourceId, CODE = :code, NAME = :name, MODEL_CODE = :modelCode, CONFIG = :config, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, UUID = :uuid, MASTER_TEMPLATE = :masterTemplate, MASTER_CONTENT_HASH = :masterContentHash, IS_MASTER_VERSION = :isMasterVersion, VERSION_ID = :versionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgDataset> fgdatasets);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DATASET WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_DATASET WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgDataset records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_DATASET WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgDataset.class)
    public List<FgDataset> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
