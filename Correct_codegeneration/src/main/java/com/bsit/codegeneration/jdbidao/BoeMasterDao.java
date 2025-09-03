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
import com.bsit.codegeneration.entity.BoeMaster;

public interface BoeMasterDao {

    /**
     * Inserts a new BoeMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO BOE_MASTER (BOE_NUMBER, AD_CODE_ID) VALUES (:boeNumber, :adCodeId)")
    public int insert(@Bind("boeNumber") String boeNumber, @Bind("adCodeId") int adCodeId);

    /**
     * Finds a BoeMaster by its ID.
     */
    @SqlQuery("SELECT * FROM BOE_MASTER WHERE BOE_MASTER_id = :id")
    @RegisterBeanMapper(BoeMaster.class)
    public Optional<BoeMaster> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM BOE_MASTER")
    @RegisterBeanMapper(BoeMaster.class)
    public List<BoeMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM BOE_MASTER ORDER BY BOE_MASTER_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(BoeMaster.class)
    public List<BoeMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a BoeMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE BOE_MASTER SET BOE_NUMBER = :boeNumber, AD_CODE_ID = :adCodeId WHERE BOE_MASTER_id = :boeMasterId")
    public int update(@BindBean BoeMaster boemaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM BOE_MASTER WHERE BOE_MASTER_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM BOE_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple BoeMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO BOE_MASTER (BOE_NUMBER, AD_CODE_ID) VALUES (:boeNumber, :adCodeId)")
    public int[] bulkInsert(@BindBean List<BoeMaster> boemasters);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO BOE_MASTER (BOE_NUMBER, AD_CODE_ID) VALUES (:boeNumber, :adCodeId)")
    public int[] bulkInsertParams(@Bind("boeNumber") List<String> boeNumbers, @Bind("adCodeId") List<Integer> adCodeIds);

    /**
     * Bulk update multiple BoeMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BOE_MASTER SET BOE_NUMBER = :boeNumber, AD_CODE_ID = :adCodeId WHERE BOE_MASTER_id = :boeMasterId")
    public int[] bulkUpdate(@BindBean List<BoeMaster> boemasters);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BOE_MASTER SET BOE_NUMBER = :boeNumber, AD_CODE_ID = :adCodeId WHERE BOE_MASTER_id = :boeMasterId")
    public int[] bulkUpdateParams(@Bind("boeNumber") List<String> boeNumbers, @Bind("adCodeId") List<Integer> adCodeIds, @Bind("boeMasterId") List<Integer> boeMasterIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM BOE_MASTER WHERE BOE_MASTER_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM BOE_MASTER WHERE BOE_MASTER_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple BoeMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM BOE_MASTER WHERE BOE_MASTER_id IN (<ids>)")
    @RegisterBeanMapper(BoeMaster.class)
    public List<BoeMaster> findByIds(@BindList("ids") Collection<Integer> ids);
}
