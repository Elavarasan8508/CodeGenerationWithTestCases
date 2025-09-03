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
import com.bsit.codegeneration.entity.FgModCaseEntity;

public interface FgModCaseEntityDao {

    /**
     * Inserts a new FgModCaseEntity and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_CASE_ENTITY (ID, VERSION_ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, PROCESS_ID, TEMPLATE_JSON, ACTIVE_CODE, STATUS_CODE, STAGE_CODE, IS_MASTER_VERSION, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, ATTACHMENT_ID) VALUES (:id, :versionId, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :processId, :templateJson, :activeCode, :statusCode, :stageCode, :isMasterVersion, :lastAuthorisedBy, :lastAuthorisedOn, :attachmentId)")
    public int insert(@BindBean FgModCaseEntity fgmodcaseentity);

    /**
     * Finds a FgModCaseEntity by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CASE_ENTITY WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgModCaseEntity.class)
    public Optional<FgModCaseEntity> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CASE_ENTITY")
    @RegisterBeanMapper(FgModCaseEntity.class)
    public List<FgModCaseEntity> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CASE_ENTITY ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModCaseEntity.class)
    public List<FgModCaseEntity> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModCaseEntity and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_CASE_ENTITY SET REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PROCESS_ID = :processId, TEMPLATE_JSON = :templateJson, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, STAGE_CODE = :stageCode, IS_MASTER_VERSION = :isMasterVersion, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, ATTACHMENT_ID = :attachmentId WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgModCaseEntity fgmodcaseentity);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CASE_ENTITY WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_CASE_ENTITY")
    public long countAll();

    /**
     * Bulk insert multiple FgModCaseEntity entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_CASE_ENTITY (ID, VERSION_ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, PROCESS_ID, TEMPLATE_JSON, ACTIVE_CODE, STATUS_CODE, STAGE_CODE, IS_MASTER_VERSION, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, ATTACHMENT_ID) VALUES (:id, :versionId, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :processId, :templateJson, :activeCode, :statusCode, :stageCode, :isMasterVersion, :lastAuthorisedBy, :lastAuthorisedOn, :attachmentId)")
    public int[] bulkInsert(@BindBean List<FgModCaseEntity> fgmodcaseentitys);

    /**
     * Bulk update multiple FgModCaseEntity entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_CASE_ENTITY SET REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PROCESS_ID = :processId, TEMPLATE_JSON = :templateJson, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, STAGE_CODE = :stageCode, IS_MASTER_VERSION = :isMasterVersion, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, ATTACHMENT_ID = :attachmentId WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgModCaseEntity> fgmodcaseentitys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CASE_ENTITY WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_CASE_ENTITY WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgModCaseEntity records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CASE_ENTITY WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgModCaseEntity.class)
    public List<FgModCaseEntity> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
