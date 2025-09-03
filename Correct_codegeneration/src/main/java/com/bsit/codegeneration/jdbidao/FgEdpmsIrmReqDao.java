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
import com.bsit.codegeneration.entity.FgEdpmsIrmReq;

public interface FgEdpmsIrmReqDao {

    /**
     * Inserts a new FgEdpmsIrmReq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_EDPMS_IRM_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NO, IRM_AD, IRM_AMT, OS_AMT_IRM, IRM_CCY, IE_CODE_IRM, IRM_DATE, IRM_UTIL_AMT, REMIT_NAME, REMIT_COUNTRY, REMIT_BANK_NAME, REMIT_BANK_COUNTRY, SWIFT_OTHER_BANK_REF, PUR_OF_REMIT, AMT_UTIL, EXT_DATE_IRM, REMARKS_IRME, IRM_ADJ_NO, BANK_REF_NO, ADJ_AMT_IRM, REMARKS_IRMA, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_ERROR_CODE, TRRACS_ERROR_DECS, TRRACS_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :irmNo, :irmAd, :irmAmt, :osAmtIrm, :irmCcy, :ieCodeIrm, :irmDate, :irmUtilAmt, :remitName, :remitCountry, :remitBankName, :remitBankCountry, :swiftOtherBankRef, :purOfRemit, :amtUtil, :extDateIrm, :remarksIrme, :irmAdjNo, :bankRefNo, :adjAmtIrm, :remarksIrma, :parentRefId, :parentVersionId, :trracsErrorCode, :trracsErrorDecs, :trracsStatus)")
    public int insert(@BindBean FgEdpmsIrmReq fgedpmsirmreq);

    /**
     * Finds a FgEdpmsIrmReq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_IRM_REQ WHERE ID = :id")
    @RegisterBeanMapper(FgEdpmsIrmReq.class)
    public Optional<FgEdpmsIrmReq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_IRM_REQ")
    @RegisterBeanMapper(FgEdpmsIrmReq.class)
    public List<FgEdpmsIrmReq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_IRM_REQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgEdpmsIrmReq.class)
    public List<FgEdpmsIrmReq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgEdpmsIrmReq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_EDPMS_IRM_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IRM_NO = :irmNo, IRM_AD = :irmAd, IRM_AMT = :irmAmt, OS_AMT_IRM = :osAmtIrm, IRM_CCY = :irmCcy, IE_CODE_IRM = :ieCodeIrm, IRM_DATE = :irmDate, IRM_UTIL_AMT = :irmUtilAmt, REMIT_NAME = :remitName, REMIT_COUNTRY = :remitCountry, REMIT_BANK_NAME = :remitBankName, REMIT_BANK_COUNTRY = :remitBankCountry, SWIFT_OTHER_BANK_REF = :swiftOtherBankRef, PUR_OF_REMIT = :purOfRemit, AMT_UTIL = :amtUtil, EXT_DATE_IRM = :extDateIrm, REMARKS_IRME = :remarksIrme, IRM_ADJ_NO = :irmAdjNo, BANK_REF_NO = :bankRefNo, ADJ_AMT_IRM = :adjAmtIrm, REMARKS_IRMA = :remarksIrma, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, TRRACS_ERROR_CODE = :trracsErrorCode, TRRACS_ERROR_DECS = :trracsErrorDecs, TRRACS_STATUS = :trracsStatus WHERE ID = :id")
    public int update(@BindBean FgEdpmsIrmReq fgedpmsirmreq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EDPMS_IRM_REQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_EDPMS_IRM_REQ")
    public long countAll();

    /**
     * Bulk insert multiple FgEdpmsIrmReq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_EDPMS_IRM_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NO, IRM_AD, IRM_AMT, OS_AMT_IRM, IRM_CCY, IE_CODE_IRM, IRM_DATE, IRM_UTIL_AMT, REMIT_NAME, REMIT_COUNTRY, REMIT_BANK_NAME, REMIT_BANK_COUNTRY, SWIFT_OTHER_BANK_REF, PUR_OF_REMIT, AMT_UTIL, EXT_DATE_IRM, REMARKS_IRME, IRM_ADJ_NO, BANK_REF_NO, ADJ_AMT_IRM, REMARKS_IRMA, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_ERROR_CODE, TRRACS_ERROR_DECS, TRRACS_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :irmNo, :irmAd, :irmAmt, :osAmtIrm, :irmCcy, :ieCodeIrm, :irmDate, :irmUtilAmt, :remitName, :remitCountry, :remitBankName, :remitBankCountry, :swiftOtherBankRef, :purOfRemit, :amtUtil, :extDateIrm, :remarksIrme, :irmAdjNo, :bankRefNo, :adjAmtIrm, :remarksIrma, :parentRefId, :parentVersionId, :trracsErrorCode, :trracsErrorDecs, :trracsStatus)")
    public int[] bulkInsert(@BindBean List<FgEdpmsIrmReq> fgedpmsirmreqs);

    /**
     * Bulk update multiple FgEdpmsIrmReq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_EDPMS_IRM_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IRM_NO = :irmNo, IRM_AD = :irmAd, IRM_AMT = :irmAmt, OS_AMT_IRM = :osAmtIrm, IRM_CCY = :irmCcy, IE_CODE_IRM = :ieCodeIrm, IRM_DATE = :irmDate, IRM_UTIL_AMT = :irmUtilAmt, REMIT_NAME = :remitName, REMIT_COUNTRY = :remitCountry, REMIT_BANK_NAME = :remitBankName, REMIT_BANK_COUNTRY = :remitBankCountry, SWIFT_OTHER_BANK_REF = :swiftOtherBankRef, PUR_OF_REMIT = :purOfRemit, AMT_UTIL = :amtUtil, EXT_DATE_IRM = :extDateIrm, REMARKS_IRME = :remarksIrme, IRM_ADJ_NO = :irmAdjNo, BANK_REF_NO = :bankRefNo, ADJ_AMT_IRM = :adjAmtIrm, REMARKS_IRMA = :remarksIrma, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, TRRACS_ERROR_CODE = :trracsErrorCode, TRRACS_ERROR_DECS = :trracsErrorDecs, TRRACS_STATUS = :trracsStatus WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgEdpmsIrmReq> fgedpmsirmreqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EDPMS_IRM_REQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_EDPMS_IRM_REQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgEdpmsIrmReq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_IRM_REQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgEdpmsIrmReq.class)
    public List<FgEdpmsIrmReq> findByIds(@BindList("ids") Collection<String> ids);
}
