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
import com.bsit.codegeneration.entity.FgDatasetBkp191224;

public interface FgDatasetBkp191224Dao {

    /**
     * Inserts a new FgDatasetBkp191224 and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_DATASET_BKP191224 (ID, DATASOURCE_ID, CODE, NAME, MODEL_CODE, CONFIG, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UUID) VALUES (:id, :datasourceId, :code, :name, :modelCode, :config, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :uuid)")
    public int insert(@BindBean FgDatasetBkp191224 fgdatasetbkp191224);

    /**
     * Finds a FgDatasetBkp191224 by its ID.
     */
    @SqlQuery("SELECT * FROM FG_DATASET_BKP191224 WHERE FG_DATASET_BKP191224_id = :id")
    @RegisterBeanMapper(FgDatasetBkp191224.class)
    public Optional<FgDatasetBkp191224> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_DATASET_BKP191224")
    @RegisterBeanMapper(FgDatasetBkp191224.class)
    public List<FgDatasetBkp191224> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_DATASET_BKP191224 ORDER BY FG_DATASET_BKP191224_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgDatasetBkp191224.class)
    public List<FgDatasetBkp191224> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgDatasetBkp191224 and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_DATASET_BKP191224 SET ID = :id, DATASOURCE_ID = :datasourceId, CODE = :code, NAME = :name, MODEL_CODE = :modelCode, CONFIG = :config, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, UUID = :uuid WHERE FG_DATASET_BKP191224_id = :fgDatasetBkp191224Id")
    public int update(@BindBean FgDatasetBkp191224 fgdatasetbkp191224);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DATASET_BKP191224 WHERE FG_DATASET_BKP191224_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_DATASET_BKP191224")
    public long countAll();

    /**
     * Bulk insert multiple FgDatasetBkp191224 entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_DATASET_BKP191224 (ID, DATASOURCE_ID, CODE, NAME, MODEL_CODE, CONFIG, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UUID) VALUES (:id, :datasourceId, :code, :name, :modelCode, :config, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :uuid)")
    public int[] bulkInsert(@BindBean List<FgDatasetBkp191224> fgdatasetbkp191224s);

    /**
     * Bulk update multiple FgDatasetBkp191224 entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_DATASET_BKP191224 SET ID = :id, DATASOURCE_ID = :datasourceId, CODE = :code, NAME = :name, MODEL_CODE = :modelCode, CONFIG = :config, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, UUID = :uuid WHERE FG_DATASET_BKP191224_id = :fgDatasetBkp191224Id")
    public int[] bulkUpdate(@BindBean List<FgDatasetBkp191224> fgdatasetbkp191224s);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DATASET_BKP191224 WHERE FG_DATASET_BKP191224_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_DATASET_BKP191224 WHERE FG_DATASET_BKP191224_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgDatasetBkp191224 records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_DATASET_BKP191224 WHERE FG_DATASET_BKP191224_id IN (<ids>)")
    @RegisterBeanMapper(FgDatasetBkp191224.class)
    public List<FgDatasetBkp191224> findByIds(@BindList("ids") Collection<Integer> ids);
}
