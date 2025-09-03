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
import com.bsit.codegeneration.entity.FgModProductLink;

public interface FgModProductLinkDao {

    /**
     * Inserts a new FgModProductLink and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_PRODUCT_LINK (ID, REF_ID, TYPE_CODE, SUB_TYPE_CODE, CHILD_REF_ID, CHILD_TYPE_CODE, CHILD_SUB_TYPE_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, AMOUNT, FACE_VALUE, DISCOUNT_PERCENTAGE, REQUEST_PERCENTAGE, REQUESTED_AMOUNT, PROGRAM_CODE, OFFER_CODE) VALUES (:id, :refId, :typeCode, :subTypeCode, :childRefId, :childTypeCode, :childSubTypeCode, :lastAuthorisedOn, :lastAuthorisedBy, :amount, :faceValue, :discountPercentage, :requestPercentage, :requestedAmount, :programCode, :offerCode)")
    public int insert(@BindBean FgModProductLink fgmodproductlink);

    /**
     * Finds a FgModProductLink by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_LINK WHERE ID = :id")
    @RegisterBeanMapper(FgModProductLink.class)
    public Optional<FgModProductLink> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_LINK")
    @RegisterBeanMapper(FgModProductLink.class)
    public List<FgModProductLink> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_LINK ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModProductLink.class)
    public List<FgModProductLink> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModProductLink and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_PRODUCT_LINK SET REF_ID = :refId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, CHILD_REF_ID = :childRefId, CHILD_TYPE_CODE = :childTypeCode, CHILD_SUB_TYPE_CODE = :childSubTypeCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, AMOUNT = :amount, FACE_VALUE = :faceValue, DISCOUNT_PERCENTAGE = :discountPercentage, REQUEST_PERCENTAGE = :requestPercentage, REQUESTED_AMOUNT = :requestedAmount, PROGRAM_CODE = :programCode, OFFER_CODE = :offerCode WHERE ID = :id")
    public int update(@BindBean FgModProductLink fgmodproductlink);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_PRODUCT_LINK WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_PRODUCT_LINK")
    public long countAll();

    /**
     * Bulk insert multiple FgModProductLink entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_PRODUCT_LINK (ID, REF_ID, TYPE_CODE, SUB_TYPE_CODE, CHILD_REF_ID, CHILD_TYPE_CODE, CHILD_SUB_TYPE_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, AMOUNT, FACE_VALUE, DISCOUNT_PERCENTAGE, REQUEST_PERCENTAGE, REQUESTED_AMOUNT, PROGRAM_CODE, OFFER_CODE) VALUES (:id, :refId, :typeCode, :subTypeCode, :childRefId, :childTypeCode, :childSubTypeCode, :lastAuthorisedOn, :lastAuthorisedBy, :amount, :faceValue, :discountPercentage, :requestPercentage, :requestedAmount, :programCode, :offerCode)")
    public int[] bulkInsert(@BindBean List<FgModProductLink> fgmodproductlinks);

    /**
     * Bulk update multiple FgModProductLink entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_PRODUCT_LINK SET REF_ID = :refId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, CHILD_REF_ID = :childRefId, CHILD_TYPE_CODE = :childTypeCode, CHILD_SUB_TYPE_CODE = :childSubTypeCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, AMOUNT = :amount, FACE_VALUE = :faceValue, DISCOUNT_PERCENTAGE = :discountPercentage, REQUEST_PERCENTAGE = :requestPercentage, REQUESTED_AMOUNT = :requestedAmount, PROGRAM_CODE = :programCode, OFFER_CODE = :offerCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgModProductLink> fgmodproductlinks);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_PRODUCT_LINK WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_PRODUCT_LINK WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgModProductLink records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_LINK WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgModProductLink.class)
    public List<FgModProductLink> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
