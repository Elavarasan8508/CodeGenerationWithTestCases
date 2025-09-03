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
import com.bsit.codegeneration.entity.TabRef;

public interface TabRefDao {

    /**
     * Inserts a new TabRef and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO TAB_REF (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TD_CODE1, TD_CODE2, TD_CODE3, TD_CODE4, TD_CODE5, TD_CODE6, TD_CODE7, TD_CODE8, TD_CODE9, TD_CODE10) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :tdCode1, :tdCode2, :tdCode3, :tdCode4, :tdCode5, :tdCode6, :tdCode7, :tdCode8, :tdCode9, :tdCode10)")
    public int insert(@BindBean TabRef tabref);

    /**
     * Finds a TabRef by its ID.
     */
    @SqlQuery("SELECT * FROM TAB_REF WHERE ID = :id")
    @RegisterBeanMapper(TabRef.class)
    public Optional<TabRef> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM TAB_REF")
    @RegisterBeanMapper(TabRef.class)
    public List<TabRef> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM TAB_REF ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(TabRef.class)
    public List<TabRef> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a TabRef and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE TAB_REF SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, TD_CODE1 = :tdCode1, TD_CODE2 = :tdCode2, TD_CODE3 = :tdCode3, TD_CODE4 = :tdCode4, TD_CODE5 = :tdCode5, TD_CODE6 = :tdCode6, TD_CODE7 = :tdCode7, TD_CODE8 = :tdCode8, TD_CODE9 = :tdCode9, TD_CODE10 = :tdCode10 WHERE ID = :id")
    public int update(@BindBean TabRef tabref);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM TAB_REF WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM TAB_REF")
    public long countAll();

    /**
     * Bulk insert multiple TabRef entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO TAB_REF (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TD_CODE1, TD_CODE2, TD_CODE3, TD_CODE4, TD_CODE5, TD_CODE6, TD_CODE7, TD_CODE8, TD_CODE9, TD_CODE10) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :tdCode1, :tdCode2, :tdCode3, :tdCode4, :tdCode5, :tdCode6, :tdCode7, :tdCode8, :tdCode9, :tdCode10)")
    public int[] bulkInsert(@BindBean List<TabRef> tabrefs);

    /**
     * Bulk update multiple TabRef entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE TAB_REF SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, TD_CODE1 = :tdCode1, TD_CODE2 = :tdCode2, TD_CODE3 = :tdCode3, TD_CODE4 = :tdCode4, TD_CODE5 = :tdCode5, TD_CODE6 = :tdCode6, TD_CODE7 = :tdCode7, TD_CODE8 = :tdCode8, TD_CODE9 = :tdCode9, TD_CODE10 = :tdCode10 WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<TabRef> tabrefs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM TAB_REF WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM TAB_REF WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple TabRef records by their IDs.
     */
    @SqlQuery("SELECT * FROM TAB_REF WHERE ID IN (<ids>)")
    @RegisterBeanMapper(TabRef.class)
    public List<TabRef> findByIds(@BindList("ids") Collection<String> ids);
}
