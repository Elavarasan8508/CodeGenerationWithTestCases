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
import com.bsit.codegeneration.entity.FgEdpmsFircReq;

public interface FgEdpmsFircReqDao {

    /**
     * Inserts a new FgEdpmsFircReq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_EDPMS_FIRC_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NUMBER, REMITTANCE_DATE, IRM_CCY, IRM_AMT, IRM_UTIL_AMT, IRM_OS_AMT, IE_CODE, AD_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, PARENT_REF_ID, PARENT_VERSION_ID, FIRC_AMT, FIRC_NUMBER, FINAL_ERROR_DESC, FINAL_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :irmNumber, :remittanceDate, :irmCcy, :irmAmt, :irmUtilAmt, :irmOsAmt, :ieCode, :adCode, :remitterName, :remitterCountry, :remitBankCountry, :parentRefId, :parentVersionId, :fircAmt, :fircNumber, :finalErrorDesc, :finalStatus)")
    public int insert(@BindBean FgEdpmsFircReq fgedpmsfircreq);

    /**
     * Finds a FgEdpmsFircReq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_FIRC_REQ WHERE ID = :id")
    @RegisterBeanMapper(FgEdpmsFircReq.class)
    public Optional<FgEdpmsFircReq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_FIRC_REQ")
    @RegisterBeanMapper(FgEdpmsFircReq.class)
    public List<FgEdpmsFircReq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_FIRC_REQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgEdpmsFircReq.class)
    public List<FgEdpmsFircReq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgEdpmsFircReq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_EDPMS_FIRC_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IRM_NUMBER = :irmNumber, REMITTANCE_DATE = :remittanceDate, IRM_CCY = :irmCcy, IRM_AMT = :irmAmt, IRM_UTIL_AMT = :irmUtilAmt, IRM_OS_AMT = :irmOsAmt, IE_CODE = :ieCode, AD_CODE = :adCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, FIRC_AMT = :fircAmt, FIRC_NUMBER = :fircNumber, FINAL_ERROR_DESC = :finalErrorDesc, FINAL_STATUS = :finalStatus WHERE ID = :id")
    public int update(@BindBean FgEdpmsFircReq fgedpmsfircreq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EDPMS_FIRC_REQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_EDPMS_FIRC_REQ")
    public long countAll();

    /**
     * Bulk insert multiple FgEdpmsFircReq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_EDPMS_FIRC_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NUMBER, REMITTANCE_DATE, IRM_CCY, IRM_AMT, IRM_UTIL_AMT, IRM_OS_AMT, IE_CODE, AD_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, PARENT_REF_ID, PARENT_VERSION_ID, FIRC_AMT, FIRC_NUMBER, FINAL_ERROR_DESC, FINAL_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :irmNumber, :remittanceDate, :irmCcy, :irmAmt, :irmUtilAmt, :irmOsAmt, :ieCode, :adCode, :remitterName, :remitterCountry, :remitBankCountry, :parentRefId, :parentVersionId, :fircAmt, :fircNumber, :finalErrorDesc, :finalStatus)")
    public int[] bulkInsert(@BindBean List<FgEdpmsFircReq> fgedpmsfircreqs);

    /**
     * Bulk update multiple FgEdpmsFircReq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_EDPMS_FIRC_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IRM_NUMBER = :irmNumber, REMITTANCE_DATE = :remittanceDate, IRM_CCY = :irmCcy, IRM_AMT = :irmAmt, IRM_UTIL_AMT = :irmUtilAmt, IRM_OS_AMT = :irmOsAmt, IE_CODE = :ieCode, AD_CODE = :adCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, FIRC_AMT = :fircAmt, FIRC_NUMBER = :fircNumber, FINAL_ERROR_DESC = :finalErrorDesc, FINAL_STATUS = :finalStatus WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgEdpmsFircReq> fgedpmsfircreqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EDPMS_FIRC_REQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_EDPMS_FIRC_REQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgEdpmsFircReq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_FIRC_REQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgEdpmsFircReq.class)
    public List<FgEdpmsFircReq> findByIds(@BindList("ids") Collection<String> ids);
}
