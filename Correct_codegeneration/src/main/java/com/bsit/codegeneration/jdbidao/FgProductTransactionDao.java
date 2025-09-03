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
import com.bsit.codegeneration.entity.FgProductTransaction;

public interface FgProductTransactionDao {

    /**
     * Inserts a new FgProductTransaction and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PRODUCT_TRANSACTION (ID, PAYMENT_ID, ENTITY_REFERENCE_ID, TRANSACTION_DATE, CURRENCY_CODE, TRANSACTION_AMOUNT, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :paymentId, :entityReferenceId, :transactionDate, :currencyCode, :transactionAmount, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgProductTransaction fgproducttransaction);

    /**
     * Finds a FgProductTransaction by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_TRANSACTION WHERE ID = :id")
    @RegisterBeanMapper(FgProductTransaction.class)
    public Optional<FgProductTransaction> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_TRANSACTION")
    @RegisterBeanMapper(FgProductTransaction.class)
    public List<FgProductTransaction> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_TRANSACTION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProductTransaction.class)
    public List<FgProductTransaction> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProductTransaction and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PRODUCT_TRANSACTION SET PAYMENT_ID = :paymentId, ENTITY_REFERENCE_ID = :entityReferenceId, TRANSACTION_DATE = :transactionDate, CURRENCY_CODE = :currencyCode, TRANSACTION_AMOUNT = :transactionAmount, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgProductTransaction fgproducttransaction);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_TRANSACTION WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PRODUCT_TRANSACTION")
    public long countAll();

    /**
     * Bulk insert multiple FgProductTransaction entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PRODUCT_TRANSACTION (ID, PAYMENT_ID, ENTITY_REFERENCE_ID, TRANSACTION_DATE, CURRENCY_CODE, TRANSACTION_AMOUNT, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :paymentId, :entityReferenceId, :transactionDate, :currencyCode, :transactionAmount, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgProductTransaction> fgproducttransactions);

    /**
     * Bulk update multiple FgProductTransaction entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PRODUCT_TRANSACTION SET PAYMENT_ID = :paymentId, ENTITY_REFERENCE_ID = :entityReferenceId, TRANSACTION_DATE = :transactionDate, CURRENCY_CODE = :currencyCode, TRANSACTION_AMOUNT = :transactionAmount, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgProductTransaction> fgproducttransactions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_TRANSACTION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PRODUCT_TRANSACTION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgProductTransaction records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_TRANSACTION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgProductTransaction.class)
    public List<FgProductTransaction> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
