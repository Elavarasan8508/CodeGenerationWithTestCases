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
import com.bsit.codegeneration.entity.FgProductEntityLock;

public interface FgProductEntityLockDao {

    /**
     * Inserts a new FgProductEntityLock and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PRODUCT_ENTITY_LOCK (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, USER_CODE, ORG_CODE, ENTITY_VERSION, ATTEMPT_COUNT, ACTION_CODE, LOCK_TIME, EXPIRY_TIME, USER_ROLE, LOCK_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID, RESEND_ATTEMPT_COUNT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :userCode, :orgCode, :entityVersion, :attemptCount, :actionCode, :lockTime, :expiryTime, :userRole, :lockCount, :entityTypeCode, :entitySubTypeCode, :entityReferenceId, :resendAttemptCount)")
    public int insert(@BindBean FgProductEntityLock fgproductentitylock);

    /**
     * Finds a FgProductEntityLock by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_ENTITY_LOCK WHERE ID = :id")
    @RegisterBeanMapper(FgProductEntityLock.class)
    public Optional<FgProductEntityLock> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_ENTITY_LOCK")
    @RegisterBeanMapper(FgProductEntityLock.class)
    public List<FgProductEntityLock> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_ENTITY_LOCK ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProductEntityLock.class)
    public List<FgProductEntityLock> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProductEntityLock and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PRODUCT_ENTITY_LOCK SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, USER_CODE = :userCode, ORG_CODE = :orgCode, ENTITY_VERSION = :entityVersion, ATTEMPT_COUNT = :attemptCount, ACTION_CODE = :actionCode, LOCK_TIME = :lockTime, EXPIRY_TIME = :expiryTime, USER_ROLE = :userRole, LOCK_COUNT = :lockCount, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_REFERENCE_ID = :entityReferenceId, RESEND_ATTEMPT_COUNT = :resendAttemptCount WHERE ID = :id")
    public int update(@BindBean FgProductEntityLock fgproductentitylock);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_ENTITY_LOCK WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PRODUCT_ENTITY_LOCK")
    public long countAll();

    /**
     * Bulk insert multiple FgProductEntityLock entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PRODUCT_ENTITY_LOCK (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, USER_CODE, ORG_CODE, ENTITY_VERSION, ATTEMPT_COUNT, ACTION_CODE, LOCK_TIME, EXPIRY_TIME, USER_ROLE, LOCK_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID, RESEND_ATTEMPT_COUNT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :userCode, :orgCode, :entityVersion, :attemptCount, :actionCode, :lockTime, :expiryTime, :userRole, :lockCount, :entityTypeCode, :entitySubTypeCode, :entityReferenceId, :resendAttemptCount)")
    public int[] bulkInsert(@BindBean List<FgProductEntityLock> fgproductentitylocks);

    /**
     * Bulk update multiple FgProductEntityLock entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PRODUCT_ENTITY_LOCK SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, USER_CODE = :userCode, ORG_CODE = :orgCode, ENTITY_VERSION = :entityVersion, ATTEMPT_COUNT = :attemptCount, ACTION_CODE = :actionCode, LOCK_TIME = :lockTime, EXPIRY_TIME = :expiryTime, USER_ROLE = :userRole, LOCK_COUNT = :lockCount, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_REFERENCE_ID = :entityReferenceId, RESEND_ATTEMPT_COUNT = :resendAttemptCount WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgProductEntityLock> fgproductentitylocks);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_ENTITY_LOCK WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PRODUCT_ENTITY_LOCK WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgProductEntityLock records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_ENTITY_LOCK WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgProductEntityLock.class)
    public List<FgProductEntityLock> findByIds(@BindList("ids") Collection<String> ids);
}
