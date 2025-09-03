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
import com.bsit.codegeneration.entity.FgAlertCode;

public interface FgAlertCodeDao {

    /**
     * Inserts a new FgAlertCode and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ALERT_CODE (ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, PARTY_ID, PARTY_VERSION_ID, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE) VALUES (:id, :entitySubTypeCode, :entityTypeCode, :name, :template, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :referenceId, :partyId, :partyVersionId, :versionId, :isMasterVersion, :stageCode, :applicantPartyCode)")
    public int insert(@BindBean FgAlertCode fgalertcode);

    /**
     * Finds a FgAlertCode by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ALERT_CODE WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgAlertCode.class)
    public Optional<FgAlertCode> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ALERT_CODE")
    @RegisterBeanMapper(FgAlertCode.class)
    public List<FgAlertCode> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ALERT_CODE ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAlertCode.class)
    public List<FgAlertCode> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAlertCode and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ALERT_CODE SET ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, NAME = :name, TEMPLATE = :template, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, REFERENCE_ID = :referenceId, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, IS_MASTER_VERSION = :isMasterVersion, STAGE_CODE = :stageCode, APPLICANT_PARTY_CODE = :applicantPartyCode WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgAlertCode fgalertcode);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALERT_CODE WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ALERT_CODE")
    public long countAll();

    /**
     * Bulk insert multiple FgAlertCode entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ALERT_CODE (ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, PARTY_ID, PARTY_VERSION_ID, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE) VALUES (:id, :entitySubTypeCode, :entityTypeCode, :name, :template, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :referenceId, :partyId, :partyVersionId, :versionId, :isMasterVersion, :stageCode, :applicantPartyCode)")
    public int[] bulkInsert(@BindBean List<FgAlertCode> fgalertcodes);

    /**
     * Bulk update multiple FgAlertCode entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ALERT_CODE SET ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, NAME = :name, TEMPLATE = :template, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, REFERENCE_ID = :referenceId, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, IS_MASTER_VERSION = :isMasterVersion, STAGE_CODE = :stageCode, APPLICANT_PARTY_CODE = :applicantPartyCode WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgAlertCode> fgalertcodes);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALERT_CODE WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ALERT_CODE WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgAlertCode records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ALERT_CODE WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgAlertCode.class)
    public List<FgAlertCode> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
