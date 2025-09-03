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
import com.bsit.codegeneration.entity.FgPurposeProduct;

public interface FgPurposeProductDao {

    /**
     * Inserts a new FgPurposeProduct and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PURPOSE_PRODUCT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CODE, PRODUCT_TYPE, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :code, :productType, :parentRefId, :parentVersionId)")
    public int insert(@BindBean FgPurposeProduct fgpurposeproduct);

    /**
     * Finds a FgPurposeProduct by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PURPOSE_PRODUCT WHERE ID = :id")
    @RegisterBeanMapper(FgPurposeProduct.class)
    public Optional<FgPurposeProduct> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PURPOSE_PRODUCT")
    @RegisterBeanMapper(FgPurposeProduct.class)
    public List<FgPurposeProduct> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PURPOSE_PRODUCT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPurposeProduct.class)
    public List<FgPurposeProduct> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPurposeProduct and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PURPOSE_PRODUCT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CODE = :code, PRODUCT_TYPE = :productType, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE ID = :id")
    public int update(@BindBean FgPurposeProduct fgpurposeproduct);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PURPOSE_PRODUCT WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PURPOSE_PRODUCT")
    public long countAll();

    /**
     * Bulk insert multiple FgPurposeProduct entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PURPOSE_PRODUCT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CODE, PRODUCT_TYPE, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :code, :productType, :parentRefId, :parentVersionId)")
    public int[] bulkInsert(@BindBean List<FgPurposeProduct> fgpurposeproducts);

    /**
     * Bulk update multiple FgPurposeProduct entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PURPOSE_PRODUCT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CODE = :code, PRODUCT_TYPE = :productType, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPurposeProduct> fgpurposeproducts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PURPOSE_PRODUCT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PURPOSE_PRODUCT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgPurposeProduct records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PURPOSE_PRODUCT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPurposeProduct.class)
    public List<FgPurposeProduct> findByIds(@BindList("ids") Collection<String> ids);
}
