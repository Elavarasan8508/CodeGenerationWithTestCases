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
import com.bsit.codegeneration.entity.FgTrracs;

public interface FgTrracsDao {

    /**
     * Inserts a new FgTrracs and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRRACS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SB_NO, SB_DATE, INVOICE_CCY, IE_CODE_SB, PORT_CODE, FORM_NO, INV_SL_NO, IRM_NO, IRM_AD, IRM_AMT, IRM_CCY, IRM_DATE, IRM_NAME, IRM_COUNTRY, IRM_BANK_COUNTRY, BOE_NUM, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, INV_NUM, TERMS_OF_INV, INVOICE_SL_NO, INV_AMT, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_CCY, ORM_DATE, IE_NAME, INV_NO, IRM_BANK_NAME, IRM_SWIFT_BANK_REF_NO, OS_AMT_IRM, INV_CCY, OS_INV_AMT, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT, OVERDUE_PERIOD, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, IE_CODE, UTILIZED_INV_AMT, ORM_OS_AMT, IE_CODE_ORM) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :sbNo, :sbDate, :invoiceCcy, :ieCodeSb, :portCode, :formNo, :invSlNo, :irmNo, :irmAd, :irmAmt, :irmCcy, :irmDate, :irmName, :irmCountry, :irmBankCountry, :boeNum, :boeDate, :portOfDis, :importAgency, :invNum, :termsOfInv, :invoiceSlNo, :invAmt, :ormNumber, :adCode, :ormAmount, :ormUtilizedAmt, :ormCcy, :ormDate, :ieName, :invNo, :irmBankName, :irmSwiftBankRefNo, :osAmtIrm, :invCcy, :osInvAmt, :beneName, :beneCountry, :remitterBankName, :purOfRemit, :overduePeriod, :supplierName, :supplierAddr, :supplierCountry, :sellerName, :sellerAddr, :sellerCountry, :ieCode, :utilizedInvAmt, :ormOsAmt, :ieCodeOrm)")
    public int insert(@BindBean FgTrracs fgtrracs);

    /**
     * Finds a FgTrracs by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRRACS WHERE ID = :id")
    @RegisterBeanMapper(FgTrracs.class)
    public Optional<FgTrracs> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRRACS")
    @RegisterBeanMapper(FgTrracs.class)
    public List<FgTrracs> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRRACS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrracs.class)
    public List<FgTrracs> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrracs and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRRACS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SB_NO = :sbNo, SB_DATE = :sbDate, INVOICE_CCY = :invoiceCcy, IE_CODE_SB = :ieCodeSb, PORT_CODE = :portCode, FORM_NO = :formNo, INV_SL_NO = :invSlNo, IRM_NO = :irmNo, IRM_AD = :irmAd, IRM_AMT = :irmAmt, IRM_CCY = :irmCcy, IRM_DATE = :irmDate, IRM_NAME = :irmName, IRM_COUNTRY = :irmCountry, IRM_BANK_COUNTRY = :irmBankCountry, BOE_NUM = :boeNum, BOE_DATE = :boeDate, PORT_OF_DIS = :portOfDis, IMPORT_AGENCY = :importAgency, INV_NUM = :invNum, TERMS_OF_INV = :termsOfInv, INVOICE_SL_NO = :invoiceSlNo, INV_AMT = :invAmt, ORM_NUMBER = :ormNumber, AD_CODE = :adCode, ORM_AMOUNT = :ormAmount, ORM_UTILIZED_AMT = :ormUtilizedAmt, ORM_CCY = :ormCcy, ORM_DATE = :ormDate, IE_NAME = :ieName, INV_NO = :invNo, IRM_BANK_NAME = :irmBankName, IRM_SWIFT_BANK_REF_NO = :irmSwiftBankRefNo, OS_AMT_IRM = :osAmtIrm, INV_CCY = :invCcy, OS_INV_AMT = :osInvAmt, BENE_NAME = :beneName, BENE_COUNTRY = :beneCountry, REMITTER_BANK_NAME = :remitterBankName, PUR_OF_REMIT = :purOfRemit, OVERDUE_PERIOD = :overduePeriod, SUPPLIER_NAME = :supplierName, SUPPLIER_ADDR = :supplierAddr, SUPPLIER_COUNTRY = :supplierCountry, SELLER_NAME = :sellerName, SELLER_ADDR = :sellerAddr, SELLER_COUNTRY = :sellerCountry, IE_CODE = :ieCode, UTILIZED_INV_AMT = :utilizedInvAmt, ORM_OS_AMT = :ormOsAmt, IE_CODE_ORM = :ieCodeOrm WHERE ID = :id")
    public int update(@BindBean FgTrracs fgtrracs);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRRACS WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRRACS")
    public long countAll();

    /**
     * Bulk insert multiple FgTrracs entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRRACS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SB_NO, SB_DATE, INVOICE_CCY, IE_CODE_SB, PORT_CODE, FORM_NO, INV_SL_NO, IRM_NO, IRM_AD, IRM_AMT, IRM_CCY, IRM_DATE, IRM_NAME, IRM_COUNTRY, IRM_BANK_COUNTRY, BOE_NUM, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, INV_NUM, TERMS_OF_INV, INVOICE_SL_NO, INV_AMT, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_CCY, ORM_DATE, IE_NAME, INV_NO, IRM_BANK_NAME, IRM_SWIFT_BANK_REF_NO, OS_AMT_IRM, INV_CCY, OS_INV_AMT, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT, OVERDUE_PERIOD, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, IE_CODE, UTILIZED_INV_AMT, ORM_OS_AMT, IE_CODE_ORM) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :sbNo, :sbDate, :invoiceCcy, :ieCodeSb, :portCode, :formNo, :invSlNo, :irmNo, :irmAd, :irmAmt, :irmCcy, :irmDate, :irmName, :irmCountry, :irmBankCountry, :boeNum, :boeDate, :portOfDis, :importAgency, :invNum, :termsOfInv, :invoiceSlNo, :invAmt, :ormNumber, :adCode, :ormAmount, :ormUtilizedAmt, :ormCcy, :ormDate, :ieName, :invNo, :irmBankName, :irmSwiftBankRefNo, :osAmtIrm, :invCcy, :osInvAmt, :beneName, :beneCountry, :remitterBankName, :purOfRemit, :overduePeriod, :supplierName, :supplierAddr, :supplierCountry, :sellerName, :sellerAddr, :sellerCountry, :ieCode, :utilizedInvAmt, :ormOsAmt, :ieCodeOrm)")
    public int[] bulkInsert(@BindBean List<FgTrracs> fgtrracss);

    /**
     * Bulk update multiple FgTrracs entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRRACS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SB_NO = :sbNo, SB_DATE = :sbDate, INVOICE_CCY = :invoiceCcy, IE_CODE_SB = :ieCodeSb, PORT_CODE = :portCode, FORM_NO = :formNo, INV_SL_NO = :invSlNo, IRM_NO = :irmNo, IRM_AD = :irmAd, IRM_AMT = :irmAmt, IRM_CCY = :irmCcy, IRM_DATE = :irmDate, IRM_NAME = :irmName, IRM_COUNTRY = :irmCountry, IRM_BANK_COUNTRY = :irmBankCountry, BOE_NUM = :boeNum, BOE_DATE = :boeDate, PORT_OF_DIS = :portOfDis, IMPORT_AGENCY = :importAgency, INV_NUM = :invNum, TERMS_OF_INV = :termsOfInv, INVOICE_SL_NO = :invoiceSlNo, INV_AMT = :invAmt, ORM_NUMBER = :ormNumber, AD_CODE = :adCode, ORM_AMOUNT = :ormAmount, ORM_UTILIZED_AMT = :ormUtilizedAmt, ORM_CCY = :ormCcy, ORM_DATE = :ormDate, IE_NAME = :ieName, INV_NO = :invNo, IRM_BANK_NAME = :irmBankName, IRM_SWIFT_BANK_REF_NO = :irmSwiftBankRefNo, OS_AMT_IRM = :osAmtIrm, INV_CCY = :invCcy, OS_INV_AMT = :osInvAmt, BENE_NAME = :beneName, BENE_COUNTRY = :beneCountry, REMITTER_BANK_NAME = :remitterBankName, PUR_OF_REMIT = :purOfRemit, OVERDUE_PERIOD = :overduePeriod, SUPPLIER_NAME = :supplierName, SUPPLIER_ADDR = :supplierAddr, SUPPLIER_COUNTRY = :supplierCountry, SELLER_NAME = :sellerName, SELLER_ADDR = :sellerAddr, SELLER_COUNTRY = :sellerCountry, IE_CODE = :ieCode, UTILIZED_INV_AMT = :utilizedInvAmt, ORM_OS_AMT = :ormOsAmt, IE_CODE_ORM = :ieCodeOrm WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrracs> fgtrracss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRRACS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRRACS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrracs records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRRACS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrracs.class)
    public List<FgTrracs> findByIds(@BindList("ids") Collection<String> ids);
}
