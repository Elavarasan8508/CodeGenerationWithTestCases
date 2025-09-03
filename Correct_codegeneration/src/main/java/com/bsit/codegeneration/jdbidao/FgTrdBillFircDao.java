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
import com.bsit.codegeneration.entity.FgTrdBillFirc;

public interface FgTrdBillFircDao {

    /**
     * Inserts a new FgTrdBillFirc and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_BILL_FIRC (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FIRC_NO, FIRC_DATE, FIRC_CCY, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, AD_CODE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :fircNo, :fircDate, :fircCcy, :fircAmt, :fircUtilAmt, :fircOsAmt, :adCode, :ieCode, :remitterName, :remitterCountry, :remitBankCountry)")
    public int insert(@BindBean FgTrdBillFirc fgtrdbillfirc);

    /**
     * Finds a FgTrdBillFirc by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_FIRC WHERE ID = :id")
    @RegisterBeanMapper(FgTrdBillFirc.class)
    public Optional<FgTrdBillFirc> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_FIRC")
    @RegisterBeanMapper(FgTrdBillFirc.class)
    public List<FgTrdBillFirc> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_FIRC ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdBillFirc.class)
    public List<FgTrdBillFirc> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdBillFirc and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_BILL_FIRC SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, FIRC_NO = :fircNo, FIRC_DATE = :fircDate, FIRC_CCY = :fircCcy, FIRC_AMT = :fircAmt, FIRC_UTIL_AMT = :fircUtilAmt, FIRC_OS_AMT = :fircOsAmt, AD_CODE = :adCode, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry WHERE ID = :id")
    public int update(@BindBean FgTrdBillFirc fgtrdbillfirc);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_BILL_FIRC WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_BILL_FIRC")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdBillFirc entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_BILL_FIRC (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FIRC_NO, FIRC_DATE, FIRC_CCY, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, AD_CODE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :fircNo, :fircDate, :fircCcy, :fircAmt, :fircUtilAmt, :fircOsAmt, :adCode, :ieCode, :remitterName, :remitterCountry, :remitBankCountry)")
    public int[] bulkInsert(@BindBean List<FgTrdBillFirc> fgtrdbillfircs);

    /**
     * Bulk update multiple FgTrdBillFirc entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_BILL_FIRC SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, FIRC_NO = :fircNo, FIRC_DATE = :fircDate, FIRC_CCY = :fircCcy, FIRC_AMT = :fircAmt, FIRC_UTIL_AMT = :fircUtilAmt, FIRC_OS_AMT = :fircOsAmt, AD_CODE = :adCode, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdBillFirc> fgtrdbillfircs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_BILL_FIRC WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_BILL_FIRC WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdBillFirc records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_FIRC WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdBillFirc.class)
    public List<FgTrdBillFirc> findByIds(@BindList("ids") Collection<String> ids);
}
