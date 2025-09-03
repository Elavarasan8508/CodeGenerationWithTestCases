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
import com.bsit.codegeneration.entity.FgOrmFuInv;

public interface FgOrmFuInvDao {

    /**
     * Inserts a new FgOrmFuInv and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ORM_FU_INV (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INV_NO, HS_CODE, PORT_OF_LOADING, VESSEL_NAME, PARENT_REF_ID, PARENT_VERSION_ID, INV_DATE, INV_AMOUNT, INV_CCY, BOE_NUM, BOE_DATE, TRANSPORT_DOC_NUM, PORT_OF_DISCHARGE, GOODS_DES, BOE_AD_CODE, COUNTRY_ORIG_GOOD, BOE_NUMBER, LINE_NO, MIGRATION_BOE_SUPL_COUNTRY, SELLER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SUPPLIER_NAME, OS_INV_AMT, INV_AMT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :invNo, :hsCode, :portOfLoading, :vesselName, :parentRefId, :parentVersionId, :invDate, :invAmount, :invCcy, :boeNum, :boeDate, :transportDocNum, :portOfDischarge, :goodsDes, :boeAdCode, :countryOrigGood, :boeNumber, :lineNo, :migrationBoeSuplCountry, :sellerName, :supplierAddr, :supplierCountry, :supplierName, :osInvAmt, :invAmt)")
    public int insert(@BindBean FgOrmFuInv fgormfuinv);

    /**
     * Finds a FgOrmFuInv by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ORM_FU_INV WHERE ID = :id")
    @RegisterBeanMapper(FgOrmFuInv.class)
    public Optional<FgOrmFuInv> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ORM_FU_INV")
    @RegisterBeanMapper(FgOrmFuInv.class)
    public List<FgOrmFuInv> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ORM_FU_INV ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgOrmFuInv.class)
    public List<FgOrmFuInv> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgOrmFuInv and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ORM_FU_INV SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, INV_NO = :invNo, HS_CODE = :hsCode, PORT_OF_LOADING = :portOfLoading, VESSEL_NAME = :vesselName, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, INV_DATE = :invDate, INV_AMOUNT = :invAmount, INV_CCY = :invCcy, BOE_NUM = :boeNum, BOE_DATE = :boeDate, TRANSPORT_DOC_NUM = :transportDocNum, PORT_OF_DISCHARGE = :portOfDischarge, GOODS_DES = :goodsDes, BOE_AD_CODE = :boeAdCode, COUNTRY_ORIG_GOOD = :countryOrigGood, BOE_NUMBER = :boeNumber, LINE_NO = :lineNo, MIGRATION_BOE_SUPL_COUNTRY = :migrationBoeSuplCountry, SELLER_NAME = :sellerName, SUPPLIER_ADDR = :supplierAddr, SUPPLIER_COUNTRY = :supplierCountry, SUPPLIER_NAME = :supplierName, OS_INV_AMT = :osInvAmt, INV_AMT = :invAmt WHERE ID = :id")
    public int update(@BindBean FgOrmFuInv fgormfuinv);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ORM_FU_INV WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ORM_FU_INV")
    public long countAll();

    /**
     * Bulk insert multiple FgOrmFuInv entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ORM_FU_INV (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INV_NO, HS_CODE, PORT_OF_LOADING, VESSEL_NAME, PARENT_REF_ID, PARENT_VERSION_ID, INV_DATE, INV_AMOUNT, INV_CCY, BOE_NUM, BOE_DATE, TRANSPORT_DOC_NUM, PORT_OF_DISCHARGE, GOODS_DES, BOE_AD_CODE, COUNTRY_ORIG_GOOD, BOE_NUMBER, LINE_NO, MIGRATION_BOE_SUPL_COUNTRY, SELLER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SUPPLIER_NAME, OS_INV_AMT, INV_AMT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :invNo, :hsCode, :portOfLoading, :vesselName, :parentRefId, :parentVersionId, :invDate, :invAmount, :invCcy, :boeNum, :boeDate, :transportDocNum, :portOfDischarge, :goodsDes, :boeAdCode, :countryOrigGood, :boeNumber, :lineNo, :migrationBoeSuplCountry, :sellerName, :supplierAddr, :supplierCountry, :supplierName, :osInvAmt, :invAmt)")
    public int[] bulkInsert(@BindBean List<FgOrmFuInv> fgormfuinvs);

    /**
     * Bulk update multiple FgOrmFuInv entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ORM_FU_INV SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, INV_NO = :invNo, HS_CODE = :hsCode, PORT_OF_LOADING = :portOfLoading, VESSEL_NAME = :vesselName, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, INV_DATE = :invDate, INV_AMOUNT = :invAmount, INV_CCY = :invCcy, BOE_NUM = :boeNum, BOE_DATE = :boeDate, TRANSPORT_DOC_NUM = :transportDocNum, PORT_OF_DISCHARGE = :portOfDischarge, GOODS_DES = :goodsDes, BOE_AD_CODE = :boeAdCode, COUNTRY_ORIG_GOOD = :countryOrigGood, BOE_NUMBER = :boeNumber, LINE_NO = :lineNo, MIGRATION_BOE_SUPL_COUNTRY = :migrationBoeSuplCountry, SELLER_NAME = :sellerName, SUPPLIER_ADDR = :supplierAddr, SUPPLIER_COUNTRY = :supplierCountry, SUPPLIER_NAME = :supplierName, OS_INV_AMT = :osInvAmt, INV_AMT = :invAmt WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgOrmFuInv> fgormfuinvs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ORM_FU_INV WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ORM_FU_INV WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgOrmFuInv records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ORM_FU_INV WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgOrmFuInv.class)
    public List<FgOrmFuInv> findByIds(@BindList("ids") Collection<String> ids);
}
