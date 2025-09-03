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
import com.bsit.codegeneration.entity.ScfFileMaster;

public interface ScfFileMasterDao {

    /**
     * Inserts a new ScfFileMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO SCF_FILE_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_NAME, FILE_ATTACH_REF_NO, FILE_STATUS, REMARKS, LINE_COUNT, TXN_COUNT, TXN_VAL_SUCCESS_CNT, TXN_LISTING_CNT, TXN_LISTING_ACK_CNT, FINPAY_REQ_CNT, INTEGRITY_SUCCESS_CNT, STAGESTATUS, FINPAY_RESP_CNT, ANCHOR_NAME, DISPLAY_FILE_NAME, HASH_KEY, PURPOSE_CODE, DISPLAY_STATUS, FULLFILMENT_PARTY, SOURCE_OF_CREATION, NUMBER_OF_FIELDS, FINTECH_SOURCE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :anchorCrn, :fileName, :fileAttachRefNo, :fileStatus, :remarks, :lineCount, :txnCount, :txnValSuccessCnt, :txnListingCnt, :txnListingAckCnt, :finpayReqCnt, :integritySuccessCnt, :stagestatus, :finpayRespCnt, :anchorName, :displayFileName, :hashKey, :purposeCode, :displayStatus, :fullfilmentParty, :sourceOfCreation, :numberOfFields, :fintechSource)")
    public int insert(@BindBean ScfFileMaster scffilemaster);

    /**
     * Finds a ScfFileMaster by its ID.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_MASTER WHERE ID = :id")
    @RegisterBeanMapper(ScfFileMaster.class)
    public Optional<ScfFileMaster> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_MASTER")
    @RegisterBeanMapper(ScfFileMaster.class)
    public List<ScfFileMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_MASTER ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(ScfFileMaster.class)
    public List<ScfFileMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a ScfFileMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE SCF_FILE_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ANCHOR_CRN = :anchorCrn, FILE_NAME = :fileName, FILE_ATTACH_REF_NO = :fileAttachRefNo, FILE_STATUS = :fileStatus, REMARKS = :remarks, LINE_COUNT = :lineCount, TXN_COUNT = :txnCount, TXN_VAL_SUCCESS_CNT = :txnValSuccessCnt, TXN_LISTING_CNT = :txnListingCnt, TXN_LISTING_ACK_CNT = :txnListingAckCnt, FINPAY_REQ_CNT = :finpayReqCnt, INTEGRITY_SUCCESS_CNT = :integritySuccessCnt, STAGESTATUS = :stagestatus, FINPAY_RESP_CNT = :finpayRespCnt, ANCHOR_NAME = :anchorName, DISPLAY_FILE_NAME = :displayFileName, HASH_KEY = :hashKey, PURPOSE_CODE = :purposeCode, DISPLAY_STATUS = :displayStatus, FULLFILMENT_PARTY = :fullfilmentParty, SOURCE_OF_CREATION = :sourceOfCreation, NUMBER_OF_FIELDS = :numberOfFields, FINTECH_SOURCE = :fintechSource WHERE ID = :id")
    public int update(@BindBean ScfFileMaster scffilemaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM SCF_FILE_MASTER WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM SCF_FILE_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple ScfFileMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SCF_FILE_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_NAME, FILE_ATTACH_REF_NO, FILE_STATUS, REMARKS, LINE_COUNT, TXN_COUNT, TXN_VAL_SUCCESS_CNT, TXN_LISTING_CNT, TXN_LISTING_ACK_CNT, FINPAY_REQ_CNT, INTEGRITY_SUCCESS_CNT, STAGESTATUS, FINPAY_RESP_CNT, ANCHOR_NAME, DISPLAY_FILE_NAME, HASH_KEY, PURPOSE_CODE, DISPLAY_STATUS, FULLFILMENT_PARTY, SOURCE_OF_CREATION, NUMBER_OF_FIELDS, FINTECH_SOURCE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :anchorCrn, :fileName, :fileAttachRefNo, :fileStatus, :remarks, :lineCount, :txnCount, :txnValSuccessCnt, :txnListingCnt, :txnListingAckCnt, :finpayReqCnt, :integritySuccessCnt, :stagestatus, :finpayRespCnt, :anchorName, :displayFileName, :hashKey, :purposeCode, :displayStatus, :fullfilmentParty, :sourceOfCreation, :numberOfFields, :fintechSource)")
    public int[] bulkInsert(@BindBean List<ScfFileMaster> scffilemasters);

    /**
     * Bulk update multiple ScfFileMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SCF_FILE_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ANCHOR_CRN = :anchorCrn, FILE_NAME = :fileName, FILE_ATTACH_REF_NO = :fileAttachRefNo, FILE_STATUS = :fileStatus, REMARKS = :remarks, LINE_COUNT = :lineCount, TXN_COUNT = :txnCount, TXN_VAL_SUCCESS_CNT = :txnValSuccessCnt, TXN_LISTING_CNT = :txnListingCnt, TXN_LISTING_ACK_CNT = :txnListingAckCnt, FINPAY_REQ_CNT = :finpayReqCnt, INTEGRITY_SUCCESS_CNT = :integritySuccessCnt, STAGESTATUS = :stagestatus, FINPAY_RESP_CNT = :finpayRespCnt, ANCHOR_NAME = :anchorName, DISPLAY_FILE_NAME = :displayFileName, HASH_KEY = :hashKey, PURPOSE_CODE = :purposeCode, DISPLAY_STATUS = :displayStatus, FULLFILMENT_PARTY = :fullfilmentParty, SOURCE_OF_CREATION = :sourceOfCreation, NUMBER_OF_FIELDS = :numberOfFields, FINTECH_SOURCE = :fintechSource WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<ScfFileMaster> scffilemasters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM SCF_FILE_MASTER WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM SCF_FILE_MASTER WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple ScfFileMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_MASTER WHERE ID IN (<ids>)")
    @RegisterBeanMapper(ScfFileMaster.class)
    public List<ScfFileMaster> findByIds(@BindList("ids") Collection<String> ids);
}
