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
import com.bsit.codegeneration.entity.FgTdItTypeMaster;

public interface FgTdItTypeMasterDao {

    /**
     * Inserts a new FgTdItTypeMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_IT_TYPE_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IT_TYPE, CUST_CLASSIFICATION, TYPE, DESCRIPTION, APPLICANT_PARTY, FULFILLMENT_PARTY, VERSION_ID, IS_MASTER_VERSION, TYPE_DUMMY, TASK_REASON, PARENT_VERSION_ID, PARENT_REF_ID, ORIGIN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :itType, :custClassification, :type, :description, :applicantParty, :fulfillmentParty, :versionId, :isMasterVersion, :typeDummy, :taskReason, :parentVersionId, :parentRefId, :origin)")
    public int insert(@BindBean FgTdItTypeMaster fgtdittypemaster);

    /**
     * Finds a FgTdItTypeMaster by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_IT_TYPE_MASTER WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgTdItTypeMaster.class)
    public Optional<FgTdItTypeMaster> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_IT_TYPE_MASTER")
    @RegisterBeanMapper(FgTdItTypeMaster.class)
    public List<FgTdItTypeMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_IT_TYPE_MASTER ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdItTypeMaster.class)
    public List<FgTdItTypeMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdItTypeMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_IT_TYPE_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IT_TYPE = :itType, CUST_CLASSIFICATION = :custClassification, TYPE = :type, DESCRIPTION = :description, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_MASTER_VERSION = :isMasterVersion, TYPE_DUMMY = :typeDummy, TASK_REASON = :taskReason, PARENT_VERSION_ID = :parentVersionId, PARENT_REF_ID = :parentRefId, ORIGIN = :origin WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgTdItTypeMaster fgtdittypemaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_IT_TYPE_MASTER WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_IT_TYPE_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple FgTdItTypeMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_IT_TYPE_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IT_TYPE, CUST_CLASSIFICATION, TYPE, DESCRIPTION, APPLICANT_PARTY, FULFILLMENT_PARTY, VERSION_ID, IS_MASTER_VERSION, TYPE_DUMMY, TASK_REASON, PARENT_VERSION_ID, PARENT_REF_ID, ORIGIN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :itType, :custClassification, :type, :description, :applicantParty, :fulfillmentParty, :versionId, :isMasterVersion, :typeDummy, :taskReason, :parentVersionId, :parentRefId, :origin)")
    public int[] bulkInsert(@BindBean List<FgTdItTypeMaster> fgtdittypemasters);

    /**
     * Bulk update multiple FgTdItTypeMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_IT_TYPE_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IT_TYPE = :itType, CUST_CLASSIFICATION = :custClassification, TYPE = :type, DESCRIPTION = :description, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_MASTER_VERSION = :isMasterVersion, TYPE_DUMMY = :typeDummy, TASK_REASON = :taskReason, PARENT_VERSION_ID = :parentVersionId, PARENT_REF_ID = :parentRefId, ORIGIN = :origin WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgTdItTypeMaster> fgtdittypemasters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_IT_TYPE_MASTER WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_IT_TYPE_MASTER WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTdItTypeMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_IT_TYPE_MASTER WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgTdItTypeMaster.class)
    public List<FgTdItTypeMaster> findByIds(@BindList("ids") Collection<String> ids);
}
