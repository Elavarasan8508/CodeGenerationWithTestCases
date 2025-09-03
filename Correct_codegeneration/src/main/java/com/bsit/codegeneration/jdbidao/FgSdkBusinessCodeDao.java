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
import com.bsit.codegeneration.entity.FgSdkBusinessCode;

public interface FgSdkBusinessCodeDao {

    /**
     * Inserts a new FgSdkBusinessCode and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SDK_BUSINESS_CODE (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CODE_TYPE, PARENT_TYPE, PARENT_CODE, TEMPLATE_CODE, DESCRIPTION, CODE_VALUE, NAME, ACTIVECODE, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :codeType, :parentType, :parentCode, :templateCode, :description, :codeValue, :name, :activecode, :parentRefId, :parentVersionId)")
    public int insert(@BindBean FgSdkBusinessCode fgsdkbusinesscode);

    /**
     * Finds a FgSdkBusinessCode by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SDK_BUSINESS_CODE WHERE FG_SDK_BUSINESS_CODE_id = :id")
    @RegisterBeanMapper(FgSdkBusinessCode.class)
    public Optional<FgSdkBusinessCode> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SDK_BUSINESS_CODE")
    @RegisterBeanMapper(FgSdkBusinessCode.class)
    public List<FgSdkBusinessCode> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SDK_BUSINESS_CODE ORDER BY FG_SDK_BUSINESS_CODE_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSdkBusinessCode.class)
    public List<FgSdkBusinessCode> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSdkBusinessCode and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SDK_BUSINESS_CODE SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CODE_TYPE = :codeType, PARENT_TYPE = :parentType, PARENT_CODE = :parentCode, TEMPLATE_CODE = :templateCode, DESCRIPTION = :description, CODE_VALUE = :codeValue, NAME = :name, ACTIVECODE = :activecode, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE FG_SDK_BUSINESS_CODE_id = :fgSdkBusinessCodeId")
    public int update(@BindBean FgSdkBusinessCode fgsdkbusinesscode);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_BUSINESS_CODE WHERE FG_SDK_BUSINESS_CODE_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SDK_BUSINESS_CODE")
    public long countAll();

    /**
     * Bulk insert multiple FgSdkBusinessCode entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SDK_BUSINESS_CODE (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CODE_TYPE, PARENT_TYPE, PARENT_CODE, TEMPLATE_CODE, DESCRIPTION, CODE_VALUE, NAME, ACTIVECODE, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :codeType, :parentType, :parentCode, :templateCode, :description, :codeValue, :name, :activecode, :parentRefId, :parentVersionId)")
    public int[] bulkInsert(@BindBean List<FgSdkBusinessCode> fgsdkbusinesscodes);

    /**
     * Bulk update multiple FgSdkBusinessCode entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SDK_BUSINESS_CODE SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CODE_TYPE = :codeType, PARENT_TYPE = :parentType, PARENT_CODE = :parentCode, TEMPLATE_CODE = :templateCode, DESCRIPTION = :description, CODE_VALUE = :codeValue, NAME = :name, ACTIVECODE = :activecode, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE FG_SDK_BUSINESS_CODE_id = :fgSdkBusinessCodeId")
    public int[] bulkUpdate(@BindBean List<FgSdkBusinessCode> fgsdkbusinesscodes);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_BUSINESS_CODE WHERE FG_SDK_BUSINESS_CODE_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SDK_BUSINESS_CODE WHERE FG_SDK_BUSINESS_CODE_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgSdkBusinessCode records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SDK_BUSINESS_CODE WHERE FG_SDK_BUSINESS_CODE_id IN (<ids>)")
    @RegisterBeanMapper(FgSdkBusinessCode.class)
    public List<FgSdkBusinessCode> findByIds(@BindList("ids") Collection<Integer> ids);
}
