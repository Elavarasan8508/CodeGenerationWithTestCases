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
import com.bsit.codegeneration.entity.FgModEiFile;

public interface FgModEiFileDao {

    /**
     * Inserts a new FgModEiFile and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_EI_FILE (ID, REFERENCE_ID, PARTY_REF_ID, PARTY_VERSION_ID, ENTITY_REF_ID, ENTITY_VERSION_ID, EVENT_CODE, EVENT_DIRECTION_CODE, ENDPOINT_CODE, ENDPOINT_PATH, ENDPOINT_DIRECTORY, FILE_NAME, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, CATEGORY_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :referenceId, :partyRefId, :partyVersionId, :entityRefId, :entityVersionId, :eventCode, :eventDirectionCode, :endpointCode, :endpointPath, :endpointDirectory, :fileName, :totalCount, :successCount, :errorCount, :categoryCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgModEiFile fgmodeifile);

    /**
     * Finds a FgModEiFile by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_EI_FILE WHERE ID = :id")
    @RegisterBeanMapper(FgModEiFile.class)
    public Optional<FgModEiFile> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_EI_FILE")
    @RegisterBeanMapper(FgModEiFile.class)
    public List<FgModEiFile> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_EI_FILE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModEiFile.class)
    public List<FgModEiFile> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModEiFile and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_EI_FILE SET REFERENCE_ID = :referenceId, PARTY_REF_ID = :partyRefId, PARTY_VERSION_ID = :partyVersionId, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_ID = :entityVersionId, EVENT_CODE = :eventCode, EVENT_DIRECTION_CODE = :eventDirectionCode, ENDPOINT_CODE = :endpointCode, ENDPOINT_PATH = :endpointPath, ENDPOINT_DIRECTORY = :endpointDirectory, FILE_NAME = :fileName, TOTAL_COUNT = :totalCount, SUCCESS_COUNT = :successCount, ERROR_COUNT = :errorCount, CATEGORY_CODE = :categoryCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgModEiFile fgmodeifile);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_EI_FILE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_EI_FILE")
    public long countAll();

    /**
     * Bulk insert multiple FgModEiFile entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_EI_FILE (ID, REFERENCE_ID, PARTY_REF_ID, PARTY_VERSION_ID, ENTITY_REF_ID, ENTITY_VERSION_ID, EVENT_CODE, EVENT_DIRECTION_CODE, ENDPOINT_CODE, ENDPOINT_PATH, ENDPOINT_DIRECTORY, FILE_NAME, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, CATEGORY_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :referenceId, :partyRefId, :partyVersionId, :entityRefId, :entityVersionId, :eventCode, :eventDirectionCode, :endpointCode, :endpointPath, :endpointDirectory, :fileName, :totalCount, :successCount, :errorCount, :categoryCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgModEiFile> fgmodeifiles);

    /**
     * Bulk update multiple FgModEiFile entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_EI_FILE SET REFERENCE_ID = :referenceId, PARTY_REF_ID = :partyRefId, PARTY_VERSION_ID = :partyVersionId, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_ID = :entityVersionId, EVENT_CODE = :eventCode, EVENT_DIRECTION_CODE = :eventDirectionCode, ENDPOINT_CODE = :endpointCode, ENDPOINT_PATH = :endpointPath, ENDPOINT_DIRECTORY = :endpointDirectory, FILE_NAME = :fileName, TOTAL_COUNT = :totalCount, SUCCESS_COUNT = :successCount, ERROR_COUNT = :errorCount, CATEGORY_CODE = :categoryCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgModEiFile> fgmodeifiles);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_EI_FILE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_EI_FILE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgModEiFile records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_EI_FILE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgModEiFile.class)
    public List<FgModEiFile> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
