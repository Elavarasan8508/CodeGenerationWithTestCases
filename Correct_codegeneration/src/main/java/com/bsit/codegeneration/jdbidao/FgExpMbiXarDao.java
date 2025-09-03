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
import com.bsit.codegeneration.entity.FgExpMbiXar;

public interface FgExpMbiXarDao {

    /**
     * Inserts a new FgExpMbiXar and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_EXP_MBI_XAR (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NO, AD_CODE, IRM_AMT, IRM_UTIL_AMT, IRM_OS_AMT, IRM_CCY, IRM_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, REMIT_BANK_NAME, XAR_BANK_REF, PURPOSE_OF_REMITTANCE, BILL_NO, PARENT_REF_ID, PARENT_VERSION_ID, SETTLED_AMT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :irmNo, :adCode, :irmAmt, :irmUtilAmt, :irmOsAmt, :irmCcy, :irmDate, :ieCode, :remitterName, :remitterCountry, :remitBankCountry, :remitBankName, :xarBankRef, :purposeOfRemittance, :billNo, :parentRefId, :parentVersionId, :settledAmt)")
    public int insert(@BindBean FgExpMbiXar fgexpmbixar);

    /**
     * Finds a FgExpMbiXar by its ID.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_XAR WHERE ID = :id")
    @RegisterBeanMapper(FgExpMbiXar.class)
    public Optional<FgExpMbiXar> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_XAR")
    @RegisterBeanMapper(FgExpMbiXar.class)
    public List<FgExpMbiXar> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_XAR ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgExpMbiXar.class)
    public List<FgExpMbiXar> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgExpMbiXar and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_EXP_MBI_XAR SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IRM_NO = :irmNo, AD_CODE = :adCode, IRM_AMT = :irmAmt, IRM_UTIL_AMT = :irmUtilAmt, IRM_OS_AMT = :irmOsAmt, IRM_CCY = :irmCcy, IRM_DATE = :irmDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry, REMIT_BANK_NAME = :remitBankName, XAR_BANK_REF = :xarBankRef, PURPOSE_OF_REMITTANCE = :purposeOfRemittance, BILL_NO = :billNo, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, SETTLED_AMT = :settledAmt WHERE ID = :id")
    public int update(@BindBean FgExpMbiXar fgexpmbixar);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EXP_MBI_XAR WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_EXP_MBI_XAR")
    public long countAll();

    /**
     * Bulk insert multiple FgExpMbiXar entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_EXP_MBI_XAR (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IRM_NO, AD_CODE, IRM_AMT, IRM_UTIL_AMT, IRM_OS_AMT, IRM_CCY, IRM_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, REMIT_BANK_NAME, XAR_BANK_REF, PURPOSE_OF_REMITTANCE, BILL_NO, PARENT_REF_ID, PARENT_VERSION_ID, SETTLED_AMT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :irmNo, :adCode, :irmAmt, :irmUtilAmt, :irmOsAmt, :irmCcy, :irmDate, :ieCode, :remitterName, :remitterCountry, :remitBankCountry, :remitBankName, :xarBankRef, :purposeOfRemittance, :billNo, :parentRefId, :parentVersionId, :settledAmt)")
    public int[] bulkInsert(@BindBean List<FgExpMbiXar> fgexpmbixars);

    /**
     * Bulk update multiple FgExpMbiXar entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_EXP_MBI_XAR SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IRM_NO = :irmNo, AD_CODE = :adCode, IRM_AMT = :irmAmt, IRM_UTIL_AMT = :irmUtilAmt, IRM_OS_AMT = :irmOsAmt, IRM_CCY = :irmCcy, IRM_DATE = :irmDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry, REMIT_BANK_NAME = :remitBankName, XAR_BANK_REF = :xarBankRef, PURPOSE_OF_REMITTANCE = :purposeOfRemittance, BILL_NO = :billNo, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, SETTLED_AMT = :settledAmt WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgExpMbiXar> fgexpmbixars);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EXP_MBI_XAR WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_EXP_MBI_XAR WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgExpMbiXar records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_XAR WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgExpMbiXar.class)
    public List<FgExpMbiXar> findByIds(@BindList("ids") Collection<String> ids);
}
