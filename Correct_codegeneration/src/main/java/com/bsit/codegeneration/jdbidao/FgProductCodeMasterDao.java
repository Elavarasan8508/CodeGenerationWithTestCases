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
import com.bsit.codegeneration.entity.FgProductCodeMaster;

public interface FgProductCodeMasterDao {

    /**
     * Inserts a new FgProductCodeMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PRODUCT_CODE_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CODE, PRODUCT_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :code, :productType)")
    public int insert(@BindBean FgProductCodeMaster fgproductcodemaster);

    /**
     * Finds a FgProductCodeMaster by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_CODE_MASTER WHERE ID = :id")
    @RegisterBeanMapper(FgProductCodeMaster.class)
    public Optional<FgProductCodeMaster> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_CODE_MASTER")
    @RegisterBeanMapper(FgProductCodeMaster.class)
    public List<FgProductCodeMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_CODE_MASTER ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProductCodeMaster.class)
    public List<FgProductCodeMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProductCodeMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PRODUCT_CODE_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CODE = :code, PRODUCT_TYPE = :productType WHERE ID = :id")
    public int update(@BindBean FgProductCodeMaster fgproductcodemaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_CODE_MASTER WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PRODUCT_CODE_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple FgProductCodeMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PRODUCT_CODE_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CODE, PRODUCT_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :code, :productType)")
    public int[] bulkInsert(@BindBean List<FgProductCodeMaster> fgproductcodemasters);

    /**
     * Bulk update multiple FgProductCodeMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PRODUCT_CODE_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CODE = :code, PRODUCT_TYPE = :productType WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgProductCodeMaster> fgproductcodemasters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_CODE_MASTER WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PRODUCT_CODE_MASTER WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgProductCodeMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_CODE_MASTER WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgProductCodeMaster.class)
    public List<FgProductCodeMaster> findByIds(@BindList("ids") Collection<String> ids);
}
