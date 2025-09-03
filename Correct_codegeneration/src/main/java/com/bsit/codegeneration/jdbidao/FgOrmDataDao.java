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
import com.bsit.codegeneration.entity.FgOrmData;

public interface FgOrmDataDao {

    /**
     * Inserts a new FgOrmData and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ORM_DATA (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_OS_AMT, ORM_CCY, ORM_DATE, IE_NAME, IE_CODE, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :ormNumber, :adCode, :ormAmount, :ormUtilizedAmt, :ormOsAmt, :ormCcy, :ormDate, :ieName, :ieCode, :beneName, :beneCountry, :remitterBankName, :purOfRemit)")
    public int insert(@BindBean FgOrmData fgormdata);

    /**
     * Finds a FgOrmData by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ORM_DATA WHERE ID = :id")
    @RegisterBeanMapper(FgOrmData.class)
    public Optional<FgOrmData> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ORM_DATA")
    @RegisterBeanMapper(FgOrmData.class)
    public List<FgOrmData> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ORM_DATA ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgOrmData.class)
    public List<FgOrmData> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgOrmData and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ORM_DATA SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ORM_NUMBER = :ormNumber, AD_CODE = :adCode, ORM_AMOUNT = :ormAmount, ORM_UTILIZED_AMT = :ormUtilizedAmt, ORM_OS_AMT = :ormOsAmt, ORM_CCY = :ormCcy, ORM_DATE = :ormDate, IE_NAME = :ieName, IE_CODE = :ieCode, BENE_NAME = :beneName, BENE_COUNTRY = :beneCountry, REMITTER_BANK_NAME = :remitterBankName, PUR_OF_REMIT = :purOfRemit WHERE ID = :id")
    public int update(@BindBean FgOrmData fgormdata);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ORM_DATA WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ORM_DATA")
    public long countAll();

    /**
     * Bulk insert multiple FgOrmData entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ORM_DATA (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_OS_AMT, ORM_CCY, ORM_DATE, IE_NAME, IE_CODE, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :ormNumber, :adCode, :ormAmount, :ormUtilizedAmt, :ormOsAmt, :ormCcy, :ormDate, :ieName, :ieCode, :beneName, :beneCountry, :remitterBankName, :purOfRemit)")
    public int[] bulkInsert(@BindBean List<FgOrmData> fgormdatas);

    /**
     * Bulk update multiple FgOrmData entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ORM_DATA SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ORM_NUMBER = :ormNumber, AD_CODE = :adCode, ORM_AMOUNT = :ormAmount, ORM_UTILIZED_AMT = :ormUtilizedAmt, ORM_OS_AMT = :ormOsAmt, ORM_CCY = :ormCcy, ORM_DATE = :ormDate, IE_NAME = :ieName, IE_CODE = :ieCode, BENE_NAME = :beneName, BENE_COUNTRY = :beneCountry, REMITTER_BANK_NAME = :remitterBankName, PUR_OF_REMIT = :purOfRemit WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgOrmData> fgormdatas);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ORM_DATA WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ORM_DATA WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgOrmData records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ORM_DATA WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgOrmData.class)
    public List<FgOrmData> findByIds(@BindList("ids") Collection<String> ids);
}
