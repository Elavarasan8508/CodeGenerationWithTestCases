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
import com.bsit.codegeneration.entity.FgSdkDataSet;

public interface FgSdkDataSetDao {

    /**
     * Inserts a new FgSdkDataSet and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SDK_DATA_SET (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, DATASOURCE_ID, MODEL_CODE, DESCRIPTION, DATASOURCE_NAME) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name, :datasourceId, :modelCode, :description, :datasourceName)")
    public int insert(@BindBean FgSdkDataSet fgsdkdataset);

    /**
     * Finds a FgSdkDataSet by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SDK_DATA_SET WHERE FG_SDK_DATA_SET_id = :id")
    @RegisterBeanMapper(FgSdkDataSet.class)
    public Optional<FgSdkDataSet> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SDK_DATA_SET")
    @RegisterBeanMapper(FgSdkDataSet.class)
    public List<FgSdkDataSet> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SDK_DATA_SET ORDER BY FG_SDK_DATA_SET_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSdkDataSet.class)
    public List<FgSdkDataSet> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSdkDataSet and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SDK_DATA_SET SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name, DATASOURCE_ID = :datasourceId, MODEL_CODE = :modelCode, DESCRIPTION = :description, DATASOURCE_NAME = :datasourceName WHERE FG_SDK_DATA_SET_id = :fgSdkDataSetId")
    public int update(@BindBean FgSdkDataSet fgsdkdataset);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_DATA_SET WHERE FG_SDK_DATA_SET_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SDK_DATA_SET")
    public long countAll();

    /**
     * Bulk insert multiple FgSdkDataSet entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SDK_DATA_SET (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, DATASOURCE_ID, MODEL_CODE, DESCRIPTION, DATASOURCE_NAME) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name, :datasourceId, :modelCode, :description, :datasourceName)")
    public int[] bulkInsert(@BindBean List<FgSdkDataSet> fgsdkdatasets);

    /**
     * Bulk update multiple FgSdkDataSet entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SDK_DATA_SET SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name, DATASOURCE_ID = :datasourceId, MODEL_CODE = :modelCode, DESCRIPTION = :description, DATASOURCE_NAME = :datasourceName WHERE FG_SDK_DATA_SET_id = :fgSdkDataSetId")
    public int[] bulkUpdate(@BindBean List<FgSdkDataSet> fgsdkdatasets);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_DATA_SET WHERE FG_SDK_DATA_SET_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SDK_DATA_SET WHERE FG_SDK_DATA_SET_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgSdkDataSet records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SDK_DATA_SET WHERE FG_SDK_DATA_SET_id IN (<ids>)")
    @RegisterBeanMapper(FgSdkDataSet.class)
    public List<FgSdkDataSet> findByIds(@BindList("ids") Collection<Integer> ids);
}
