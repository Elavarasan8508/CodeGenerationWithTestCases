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
import com.bsit.codegeneration.entity.FgExpMbiInv;

public interface FgExpMbiInvDao {

    /**
     * Inserts a new FgExpMbiInv and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_EXP_MBI_INV (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BILL_NO, SHIPBILLNO, FORMNO, INV_NO, INV_DATE, FOBCURRCODE, FOB_AMT, FRIEGHTCURRCODE, FRIEGHT_AMT, INSCURRCODE, INS_AMT, UTIL_FOB_AMT, UTIL_FRIEGHT_AMT, UTIL_INS_AMT, INV_SL_NO, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :billNo, :shipbillno, :formno, :invNo, :invDate, :fobcurrcode, :fobAmt, :frieghtcurrcode, :frieghtAmt, :inscurrcode, :insAmt, :utilFobAmt, :utilFrieghtAmt, :utilInsAmt, :invSlNo, :parentRefId, :parentVersionId)")
    public int insert(@BindBean FgExpMbiInv fgexpmbiinv);

    /**
     * Finds a FgExpMbiInv by its ID.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_INV WHERE ID = :id")
    @RegisterBeanMapper(FgExpMbiInv.class)
    public Optional<FgExpMbiInv> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_INV")
    @RegisterBeanMapper(FgExpMbiInv.class)
    public List<FgExpMbiInv> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_INV ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgExpMbiInv.class)
    public List<FgExpMbiInv> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgExpMbiInv and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_EXP_MBI_INV SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BILL_NO = :billNo, SHIPBILLNO = :shipbillno, FORMNO = :formno, INV_NO = :invNo, INV_DATE = :invDate, FOBCURRCODE = :fobcurrcode, FOB_AMT = :fobAmt, FRIEGHTCURRCODE = :frieghtcurrcode, FRIEGHT_AMT = :frieghtAmt, INSCURRCODE = :inscurrcode, INS_AMT = :insAmt, UTIL_FOB_AMT = :utilFobAmt, UTIL_FRIEGHT_AMT = :utilFrieghtAmt, UTIL_INS_AMT = :utilInsAmt, INV_SL_NO = :invSlNo, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE ID = :id")
    public int update(@BindBean FgExpMbiInv fgexpmbiinv);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EXP_MBI_INV WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_EXP_MBI_INV")
    public long countAll();

    /**
     * Bulk insert multiple FgExpMbiInv entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_EXP_MBI_INV (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BILL_NO, SHIPBILLNO, FORMNO, INV_NO, INV_DATE, FOBCURRCODE, FOB_AMT, FRIEGHTCURRCODE, FRIEGHT_AMT, INSCURRCODE, INS_AMT, UTIL_FOB_AMT, UTIL_FRIEGHT_AMT, UTIL_INS_AMT, INV_SL_NO, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :billNo, :shipbillno, :formno, :invNo, :invDate, :fobcurrcode, :fobAmt, :frieghtcurrcode, :frieghtAmt, :inscurrcode, :insAmt, :utilFobAmt, :utilFrieghtAmt, :utilInsAmt, :invSlNo, :parentRefId, :parentVersionId)")
    public int[] bulkInsert(@BindBean List<FgExpMbiInv> fgexpmbiinvs);

    /**
     * Bulk update multiple FgExpMbiInv entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_EXP_MBI_INV SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BILL_NO = :billNo, SHIPBILLNO = :shipbillno, FORMNO = :formno, INV_NO = :invNo, INV_DATE = :invDate, FOBCURRCODE = :fobcurrcode, FOB_AMT = :fobAmt, FRIEGHTCURRCODE = :frieghtcurrcode, FRIEGHT_AMT = :frieghtAmt, INSCURRCODE = :inscurrcode, INS_AMT = :insAmt, UTIL_FOB_AMT = :utilFobAmt, UTIL_FRIEGHT_AMT = :utilFrieghtAmt, UTIL_INS_AMT = :utilInsAmt, INV_SL_NO = :invSlNo, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgExpMbiInv> fgexpmbiinvs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EXP_MBI_INV WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_EXP_MBI_INV WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgExpMbiInv records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_INV WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgExpMbiInv.class)
    public List<FgExpMbiInv> findByIds(@BindList("ids") Collection<String> ids);
}
