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
import com.bsit.codegeneration.entity.FccOrmStagging;

public interface FccOrmStaggingDao {

    /**
     * Inserts a new FccOrmStagging and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FCC_ORM_STAGGING (SEQ_ID, REFERENCEID, UPLOAD_REF_ID, UPLOAD_TNX_ID, REQUEST, RESPONSE, ERROR_MSG, INSERTED_ON, TNX_STAT_CODE, PROD_STAT_CODE) VALUES (:seqId, :referenceid, :uploadRefId, :uploadTnxId, :request, :response, :errorMsg, :insertedOn, :tnxStatCode, :prodStatCode)")
    public int insert(@BindBean FccOrmStagging fccormstagging);

    /**
     * Finds a FccOrmStagging by its ID.
     */
    @SqlQuery("SELECT * FROM FCC_ORM_STAGGING WHERE FCC_ORM_STAGGING_id = :id")
    @RegisterBeanMapper(FccOrmStagging.class)
    public Optional<FccOrmStagging> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FCC_ORM_STAGGING")
    @RegisterBeanMapper(FccOrmStagging.class)
    public List<FccOrmStagging> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FCC_ORM_STAGGING ORDER BY FCC_ORM_STAGGING_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FccOrmStagging.class)
    public List<FccOrmStagging> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FccOrmStagging and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FCC_ORM_STAGGING SET SEQ_ID = :seqId, REFERENCEID = :referenceid, UPLOAD_REF_ID = :uploadRefId, UPLOAD_TNX_ID = :uploadTnxId, REQUEST = :request, RESPONSE = :response, ERROR_MSG = :errorMsg, INSERTED_ON = :insertedOn, TNX_STAT_CODE = :tnxStatCode, PROD_STAT_CODE = :prodStatCode WHERE FCC_ORM_STAGGING_id = :fccOrmStaggingId")
    public int update(@BindBean FccOrmStagging fccormstagging);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FCC_ORM_STAGGING WHERE FCC_ORM_STAGGING_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FCC_ORM_STAGGING")
    public long countAll();

    /**
     * Bulk insert multiple FccOrmStagging entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FCC_ORM_STAGGING (SEQ_ID, REFERENCEID, UPLOAD_REF_ID, UPLOAD_TNX_ID, REQUEST, RESPONSE, ERROR_MSG, INSERTED_ON, TNX_STAT_CODE, PROD_STAT_CODE) VALUES (:seqId, :referenceid, :uploadRefId, :uploadTnxId, :request, :response, :errorMsg, :insertedOn, :tnxStatCode, :prodStatCode)")
    public int[] bulkInsert(@BindBean List<FccOrmStagging> fccormstaggings);

    /**
     * Bulk update multiple FccOrmStagging entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FCC_ORM_STAGGING SET SEQ_ID = :seqId, REFERENCEID = :referenceid, UPLOAD_REF_ID = :uploadRefId, UPLOAD_TNX_ID = :uploadTnxId, REQUEST = :request, RESPONSE = :response, ERROR_MSG = :errorMsg, INSERTED_ON = :insertedOn, TNX_STAT_CODE = :tnxStatCode, PROD_STAT_CODE = :prodStatCode WHERE FCC_ORM_STAGGING_id = :fccOrmStaggingId")
    public int[] bulkUpdate(@BindBean List<FccOrmStagging> fccormstaggings);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FCC_ORM_STAGGING WHERE FCC_ORM_STAGGING_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FCC_ORM_STAGGING WHERE FCC_ORM_STAGGING_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FccOrmStagging records by their IDs.
     */
    @SqlQuery("SELECT * FROM FCC_ORM_STAGGING WHERE FCC_ORM_STAGGING_id IN (<ids>)")
    @RegisterBeanMapper(FccOrmStagging.class)
    public List<FccOrmStagging> findByIds(@BindList("ids") Collection<Integer> ids);
}
