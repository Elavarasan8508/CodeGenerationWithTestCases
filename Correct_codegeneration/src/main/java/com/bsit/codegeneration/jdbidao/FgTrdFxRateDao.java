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
import com.bsit.codegeneration.entity.FgTrdFxRate;

public interface FgTrdFxRateDao {

    /**
     * Inserts a new FgTrdFxRate and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_FX_RATE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, DEAL_REFERENCE, BUYING_CUR, BUYING_AMT, SELLING_CUR, SELLING_AMT, FX_RATE, PARENT_REF_ID, PARENT_VERSION_ID, FX_AMT, IR_REFERENCE_ID, DEAL_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :dealReference, :buyingCur, :buyingAmt, :sellingCur, :sellingAmt, :fxRate, :parentRefId, :parentVersionId, :fxAmt, :irReferenceId, :dealType)")
    public int insert(@BindBean FgTrdFxRate fgtrdfxrate);

    /**
     * Finds a FgTrdFxRate by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FX_RATE WHERE ID = :id")
    @RegisterBeanMapper(FgTrdFxRate.class)
    public Optional<FgTrdFxRate> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FX_RATE")
    @RegisterBeanMapper(FgTrdFxRate.class)
    public List<FgTrdFxRate> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FX_RATE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdFxRate.class)
    public List<FgTrdFxRate> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdFxRate and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_FX_RATE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, DEAL_REFERENCE = :dealReference, BUYING_CUR = :buyingCur, BUYING_AMT = :buyingAmt, SELLING_CUR = :sellingCur, SELLING_AMT = :sellingAmt, FX_RATE = :fxRate, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, FX_AMT = :fxAmt, IR_REFERENCE_ID = :irReferenceId, DEAL_TYPE = :dealType WHERE ID = :id")
    public int update(@BindBean FgTrdFxRate fgtrdfxrate);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_FX_RATE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_FX_RATE")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdFxRate entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_FX_RATE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, DEAL_REFERENCE, BUYING_CUR, BUYING_AMT, SELLING_CUR, SELLING_AMT, FX_RATE, PARENT_REF_ID, PARENT_VERSION_ID, FX_AMT, IR_REFERENCE_ID, DEAL_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :dealReference, :buyingCur, :buyingAmt, :sellingCur, :sellingAmt, :fxRate, :parentRefId, :parentVersionId, :fxAmt, :irReferenceId, :dealType)")
    public int[] bulkInsert(@BindBean List<FgTrdFxRate> fgtrdfxrates);

    /**
     * Bulk update multiple FgTrdFxRate entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_FX_RATE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, DEAL_REFERENCE = :dealReference, BUYING_CUR = :buyingCur, BUYING_AMT = :buyingAmt, SELLING_CUR = :sellingCur, SELLING_AMT = :sellingAmt, FX_RATE = :fxRate, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, FX_AMT = :fxAmt, IR_REFERENCE_ID = :irReferenceId, DEAL_TYPE = :dealType WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdFxRate> fgtrdfxrates);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_FX_RATE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_FX_RATE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdFxRate records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FX_RATE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdFxRate.class)
    public List<FgTrdFxRate> findByIds(@BindList("ids") Collection<String> ids);
}
