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
import com.bsit.codegeneration.entity.FgExpMbiFirc;

public interface FgExpMbiFircDao {

    /**
     * Inserts a new FgExpMbiFirc and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_EXP_MBI_FIRC (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FIRC_NUMBER, AD_CODE, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, FIRC_CCY, FIRC_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, BILL_NO, PARENT_REF_ID, PARENT_VERSION_ID, SETTLED_AMT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :fircNumber, :adCode, :fircAmt, :fircUtilAmt, :fircOsAmt, :fircCcy, :fircDate, :ieCode, :remitterName, :remitterCountry, :remitBankCountry, :billNo, :parentRefId, :parentVersionId, :settledAmt)")
    public int insert(@BindBean FgExpMbiFirc fgexpmbifirc);

    /**
     * Finds a FgExpMbiFirc by its ID.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_FIRC WHERE ID = :id")
    @RegisterBeanMapper(FgExpMbiFirc.class)
    public Optional<FgExpMbiFirc> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_FIRC")
    @RegisterBeanMapper(FgExpMbiFirc.class)
    public List<FgExpMbiFirc> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_FIRC ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgExpMbiFirc.class)
    public List<FgExpMbiFirc> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgExpMbiFirc and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_EXP_MBI_FIRC SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, FIRC_NUMBER = :fircNumber, AD_CODE = :adCode, FIRC_AMT = :fircAmt, FIRC_UTIL_AMT = :fircUtilAmt, FIRC_OS_AMT = :fircOsAmt, FIRC_CCY = :fircCcy, FIRC_DATE = :fircDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry, BILL_NO = :billNo, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, SETTLED_AMT = :settledAmt WHERE ID = :id")
    public int update(@BindBean FgExpMbiFirc fgexpmbifirc);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EXP_MBI_FIRC WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_EXP_MBI_FIRC")
    public long countAll();

    /**
     * Bulk insert multiple FgExpMbiFirc entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_EXP_MBI_FIRC (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FIRC_NUMBER, AD_CODE, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, FIRC_CCY, FIRC_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, BILL_NO, PARENT_REF_ID, PARENT_VERSION_ID, SETTLED_AMT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :fircNumber, :adCode, :fircAmt, :fircUtilAmt, :fircOsAmt, :fircCcy, :fircDate, :ieCode, :remitterName, :remitterCountry, :remitBankCountry, :billNo, :parentRefId, :parentVersionId, :settledAmt)")
    public int[] bulkInsert(@BindBean List<FgExpMbiFirc> fgexpmbifircs);

    /**
     * Bulk update multiple FgExpMbiFirc entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_EXP_MBI_FIRC SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, FIRC_NUMBER = :fircNumber, AD_CODE = :adCode, FIRC_AMT = :fircAmt, FIRC_UTIL_AMT = :fircUtilAmt, FIRC_OS_AMT = :fircOsAmt, FIRC_CCY = :fircCcy, FIRC_DATE = :fircDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry, BILL_NO = :billNo, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, SETTLED_AMT = :settledAmt WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgExpMbiFirc> fgexpmbifircs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EXP_MBI_FIRC WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_EXP_MBI_FIRC WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgExpMbiFirc records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_FIRC WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgExpMbiFirc.class)
    public List<FgExpMbiFirc> findByIds(@BindList("ids") Collection<String> ids);
}
