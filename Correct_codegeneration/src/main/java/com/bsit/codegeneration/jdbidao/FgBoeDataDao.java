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
import com.bsit.codegeneration.entity.FgBoeData;

public interface FgBoeDataDao {

    /**
     * Inserts a new FgBoeData and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_BOE_DATA (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, IE_CODE, OVERDUE_PERIOD, INVOICE_SL_NO, INV_NUM, TERMS_OF_INV, INV_CCY, INV_AMT, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, UTILIZED_INV_AMT, OS_INV_AMT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :boeNumber, :boeDate, :portOfDis, :importAgency, :ieCode, :overduePeriod, :invoiceSlNo, :invNum, :termsOfInv, :invCcy, :invAmt, :supplierName, :supplierAddr, :supplierCountry, :sellerName, :sellerAddr, :sellerCountry, :utilizedInvAmt, :osInvAmt)")
    public int insert(@BindBean FgBoeData fgboedata);

    /**
     * Finds a FgBoeData by its ID.
     */
    @SqlQuery("SELECT * FROM FG_BOE_DATA WHERE ID = :id")
    @RegisterBeanMapper(FgBoeData.class)
    public Optional<FgBoeData> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_BOE_DATA")
    @RegisterBeanMapper(FgBoeData.class)
    public List<FgBoeData> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_BOE_DATA ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgBoeData.class)
    public List<FgBoeData> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgBoeData and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_BOE_DATA SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, PORT_OF_DIS = :portOfDis, IMPORT_AGENCY = :importAgency, IE_CODE = :ieCode, OVERDUE_PERIOD = :overduePeriod, INVOICE_SL_NO = :invoiceSlNo, INV_NUM = :invNum, TERMS_OF_INV = :termsOfInv, INV_CCY = :invCcy, INV_AMT = :invAmt, SUPPLIER_NAME = :supplierName, SUPPLIER_ADDR = :supplierAddr, SUPPLIER_COUNTRY = :supplierCountry, SELLER_NAME = :sellerName, SELLER_ADDR = :sellerAddr, SELLER_COUNTRY = :sellerCountry, UTILIZED_INV_AMT = :utilizedInvAmt, OS_INV_AMT = :osInvAmt WHERE ID = :id")
    public int update(@BindBean FgBoeData fgboedata);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_BOE_DATA WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_BOE_DATA")
    public long countAll();

    /**
     * Bulk insert multiple FgBoeData entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_BOE_DATA (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, IE_CODE, OVERDUE_PERIOD, INVOICE_SL_NO, INV_NUM, TERMS_OF_INV, INV_CCY, INV_AMT, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, UTILIZED_INV_AMT, OS_INV_AMT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :boeNumber, :boeDate, :portOfDis, :importAgency, :ieCode, :overduePeriod, :invoiceSlNo, :invNum, :termsOfInv, :invCcy, :invAmt, :supplierName, :supplierAddr, :supplierCountry, :sellerName, :sellerAddr, :sellerCountry, :utilizedInvAmt, :osInvAmt)")
    public int[] bulkInsert(@BindBean List<FgBoeData> fgboedatas);

    /**
     * Bulk update multiple FgBoeData entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_BOE_DATA SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, PORT_OF_DIS = :portOfDis, IMPORT_AGENCY = :importAgency, IE_CODE = :ieCode, OVERDUE_PERIOD = :overduePeriod, INVOICE_SL_NO = :invoiceSlNo, INV_NUM = :invNum, TERMS_OF_INV = :termsOfInv, INV_CCY = :invCcy, INV_AMT = :invAmt, SUPPLIER_NAME = :supplierName, SUPPLIER_ADDR = :supplierAddr, SUPPLIER_COUNTRY = :supplierCountry, SELLER_NAME = :sellerName, SELLER_ADDR = :sellerAddr, SELLER_COUNTRY = :sellerCountry, UTILIZED_INV_AMT = :utilizedInvAmt, OS_INV_AMT = :osInvAmt WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgBoeData> fgboedatas);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_BOE_DATA WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_BOE_DATA WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgBoeData records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_BOE_DATA WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgBoeData.class)
    public List<FgBoeData> findByIds(@BindList("ids") Collection<String> ids);
}
