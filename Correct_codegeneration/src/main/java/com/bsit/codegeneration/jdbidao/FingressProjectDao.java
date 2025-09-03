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
import com.bsit.codegeneration.entity.FingressProject;

public interface FingressProjectDao {

    /**
     * Inserts a new FingressProject and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FINGRESS_PROJECT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate)")
    public int insert(@BindBean FingressProject fingressproject);

    /**
     * Finds a FingressProject by its ID.
     */
    @SqlQuery("SELECT * FROM FINGRESS_PROJECT WHERE ID = :id")
    @RegisterBeanMapper(FingressProject.class)
    public Optional<FingressProject> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FINGRESS_PROJECT")
    @RegisterBeanMapper(FingressProject.class)
    public List<FingressProject> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FINGRESS_PROJECT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FingressProject.class)
    public List<FingressProject> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FingressProject and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FINGRESS_PROJECT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate WHERE ID = :id")
    public int update(@BindBean FingressProject fingressproject);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FINGRESS_PROJECT WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FINGRESS_PROJECT")
    public long countAll();

    /**
     * Bulk insert multiple FingressProject entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FINGRESS_PROJECT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate)")
    public int[] bulkInsert(@BindBean List<FingressProject> fingressprojects);

    /**
     * Bulk update multiple FingressProject entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FINGRESS_PROJECT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FingressProject> fingressprojects);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FINGRESS_PROJECT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FINGRESS_PROJECT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FingressProject records by their IDs.
     */
    @SqlQuery("SELECT * FROM FINGRESS_PROJECT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FingressProject.class)
    public List<FingressProject> findByIds(@BindList("ids") Collection<String> ids);
}
