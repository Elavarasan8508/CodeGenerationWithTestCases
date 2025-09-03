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
import com.bsit.codegeneration.entity.FgEdpmsSbInv;

public interface FgEdpmsSbInvDao {

    /**
     * Inserts a new FgEdpmsSbInv and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_EDPMS_SB_INV (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, BILL_NO, SHIPBILLNO, FORMNO, INV_SL_NO, INV_NO, INV_DATE, FOBCURRCODE, FOB_AMT, FRIEGHTCURRCODE, FRIEGHT_AMT, INSCURRCODE, INS_AMT, IE_CODE, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :billNo, :shipbillno, :formno, :invSlNo, :invNo, :invDate, :fobcurrcode, :fobAmt, :frieghtcurrcode, :frieghtAmt, :inscurrcode, :insAmt, :ieCode, :parentRefId, :parentVersionId)")
    public int insert(@BindBean FgEdpmsSbInv fgedpmssbinv);

    /**
     * Finds a FgEdpmsSbInv by its ID.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_SB_INV WHERE ID = :id")
    @RegisterBeanMapper(FgEdpmsSbInv.class)
    public Optional<FgEdpmsSbInv> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_SB_INV")
    @RegisterBeanMapper(FgEdpmsSbInv.class)
    public List<FgEdpmsSbInv> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_SB_INV ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgEdpmsSbInv.class)
    public List<FgEdpmsSbInv> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgEdpmsSbInv and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_EDPMS_SB_INV SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, BILL_NO = :billNo, SHIPBILLNO = :shipbillno, FORMNO = :formno, INV_SL_NO = :invSlNo, INV_NO = :invNo, INV_DATE = :invDate, FOBCURRCODE = :fobcurrcode, FOB_AMT = :fobAmt, FRIEGHTCURRCODE = :frieghtcurrcode, FRIEGHT_AMT = :frieghtAmt, INSCURRCODE = :inscurrcode, INS_AMT = :insAmt, IE_CODE = :ieCode, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE ID = :id")
    public int update(@BindBean FgEdpmsSbInv fgedpmssbinv);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EDPMS_SB_INV WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_EDPMS_SB_INV")
    public long countAll();

    /**
     * Bulk insert multiple FgEdpmsSbInv entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_EDPMS_SB_INV (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, BILL_NO, SHIPBILLNO, FORMNO, INV_SL_NO, INV_NO, INV_DATE, FOBCURRCODE, FOB_AMT, FRIEGHTCURRCODE, FRIEGHT_AMT, INSCURRCODE, INS_AMT, IE_CODE, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :billNo, :shipbillno, :formno, :invSlNo, :invNo, :invDate, :fobcurrcode, :fobAmt, :frieghtcurrcode, :frieghtAmt, :inscurrcode, :insAmt, :ieCode, :parentRefId, :parentVersionId)")
    public int[] bulkInsert(@BindBean List<FgEdpmsSbInv> fgedpmssbinvs);

    /**
     * Bulk update multiple FgEdpmsSbInv entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_EDPMS_SB_INV SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, BILL_NO = :billNo, SHIPBILLNO = :shipbillno, FORMNO = :formno, INV_SL_NO = :invSlNo, INV_NO = :invNo, INV_DATE = :invDate, FOBCURRCODE = :fobcurrcode, FOB_AMT = :fobAmt, FRIEGHTCURRCODE = :frieghtcurrcode, FRIEGHT_AMT = :frieghtAmt, INSCURRCODE = :inscurrcode, INS_AMT = :insAmt, IE_CODE = :ieCode, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgEdpmsSbInv> fgedpmssbinvs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EDPMS_SB_INV WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_EDPMS_SB_INV WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgEdpmsSbInv records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_SB_INV WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgEdpmsSbInv.class)
    public List<FgEdpmsSbInv> findByIds(@BindList("ids") Collection<String> ids);
}
