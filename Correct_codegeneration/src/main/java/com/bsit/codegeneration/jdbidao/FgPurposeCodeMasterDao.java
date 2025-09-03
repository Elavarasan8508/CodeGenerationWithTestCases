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
import com.bsit.codegeneration.entity.FgPurposeCodeMaster;

public interface FgPurposeCodeMasterDao {

    /**
     * Inserts a new FgPurposeCodeMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PURPOSE_CODE_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, DESCRIPTION, TYPE, PRODUCT_CODE, MT103, MT202, MT103_202, REQ_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :purposeCode, :description, :type, :productCode, :mt103, :mt202, :mt103202, :reqType)")
    public int insert(@BindBean FgPurposeCodeMaster fgpurposecodemaster);

    /**
     * Finds a FgPurposeCodeMaster by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PURPOSE_CODE_MASTER WHERE ID = :id")
    @RegisterBeanMapper(FgPurposeCodeMaster.class)
    public Optional<FgPurposeCodeMaster> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PURPOSE_CODE_MASTER")
    @RegisterBeanMapper(FgPurposeCodeMaster.class)
    public List<FgPurposeCodeMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PURPOSE_CODE_MASTER ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPurposeCodeMaster.class)
    public List<FgPurposeCodeMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPurposeCodeMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PURPOSE_CODE_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PURPOSE_CODE = :purposeCode, DESCRIPTION = :description, TYPE = :type, PRODUCT_CODE = :productCode, MT103 = :mt103, MT202 = :mt202, MT103_202 = :mt103202, REQ_TYPE = :reqType WHERE ID = :id")
    public int update(@BindBean FgPurposeCodeMaster fgpurposecodemaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PURPOSE_CODE_MASTER WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PURPOSE_CODE_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple FgPurposeCodeMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PURPOSE_CODE_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, DESCRIPTION, TYPE, PRODUCT_CODE, MT103, MT202, MT103_202, REQ_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :purposeCode, :description, :type, :productCode, :mt103, :mt202, :mt103202, :reqType)")
    public int[] bulkInsert(@BindBean List<FgPurposeCodeMaster> fgpurposecodemasters);

    /**
     * Bulk update multiple FgPurposeCodeMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PURPOSE_CODE_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PURPOSE_CODE = :purposeCode, DESCRIPTION = :description, TYPE = :type, PRODUCT_CODE = :productCode, MT103 = :mt103, MT202 = :mt202, MT103_202 = :mt103202, REQ_TYPE = :reqType WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPurposeCodeMaster> fgpurposecodemasters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PURPOSE_CODE_MASTER WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PURPOSE_CODE_MASTER WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgPurposeCodeMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PURPOSE_CODE_MASTER WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPurposeCodeMaster.class)
    public List<FgPurposeCodeMaster> findByIds(@BindList("ids") Collection<String> ids);
}
