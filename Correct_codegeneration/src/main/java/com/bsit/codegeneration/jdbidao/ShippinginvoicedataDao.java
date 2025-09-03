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
import com.bsit.codegeneration.entity.Shippinginvoicedata;

public interface ShippinginvoicedataDao {

    /**
     * Inserts a new Shippinginvoicedata and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO SHIPPINGINVOICEDATA (BILL_NO, SHIPBILLNO, SHIPBILLDATE, FORMNO, INV_SL_NO, INV_NO, INV_DATE, IE_CODE) VALUES (:billNo, :shipbillno, :shipbilldate, :formno, :invSlNo, :invNo, :invDate, :ieCode)")
    public int insert(@BindBean Shippinginvoicedata shippinginvoicedata);

    /**
     * Finds a Shippinginvoicedata by its ID.
     */
    @SqlQuery("SELECT * FROM SHIPPINGINVOICEDATA WHERE SHIPPINGINVOICEDATA_id = :id")
    @RegisterBeanMapper(Shippinginvoicedata.class)
    public Optional<Shippinginvoicedata> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM SHIPPINGINVOICEDATA")
    @RegisterBeanMapper(Shippinginvoicedata.class)
    public List<Shippinginvoicedata> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM SHIPPINGINVOICEDATA ORDER BY SHIPPINGINVOICEDATA_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Shippinginvoicedata.class)
    public List<Shippinginvoicedata> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Shippinginvoicedata and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE SHIPPINGINVOICEDATA SET BILL_NO = :billNo, SHIPBILLNO = :shipbillno, SHIPBILLDATE = :shipbilldate, FORMNO = :formno, INV_SL_NO = :invSlNo, INV_NO = :invNo, INV_DATE = :invDate, IE_CODE = :ieCode WHERE SHIPPINGINVOICEDATA_id = :shippinginvoicedataId")
    public int update(@BindBean Shippinginvoicedata shippinginvoicedata);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM SHIPPINGINVOICEDATA WHERE SHIPPINGINVOICEDATA_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM SHIPPINGINVOICEDATA")
    public long countAll();

    /**
     * Bulk insert multiple Shippinginvoicedata entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SHIPPINGINVOICEDATA (BILL_NO, SHIPBILLNO, SHIPBILLDATE, FORMNO, INV_SL_NO, INV_NO, INV_DATE, IE_CODE) VALUES (:billNo, :shipbillno, :shipbilldate, :formno, :invSlNo, :invNo, :invDate, :ieCode)")
    public int[] bulkInsert(@BindBean List<Shippinginvoicedata> shippinginvoicedatas);

    /**
     * Bulk update multiple Shippinginvoicedata entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SHIPPINGINVOICEDATA SET BILL_NO = :billNo, SHIPBILLNO = :shipbillno, SHIPBILLDATE = :shipbilldate, FORMNO = :formno, INV_SL_NO = :invSlNo, INV_NO = :invNo, INV_DATE = :invDate, IE_CODE = :ieCode WHERE SHIPPINGINVOICEDATA_id = :shippinginvoicedataId")
    public int[] bulkUpdate(@BindBean List<Shippinginvoicedata> shippinginvoicedatas);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM SHIPPINGINVOICEDATA WHERE SHIPPINGINVOICEDATA_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM SHIPPINGINVOICEDATA WHERE SHIPPINGINVOICEDATA_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Shippinginvoicedata records by their IDs.
     */
    @SqlQuery("SELECT * FROM SHIPPINGINVOICEDATA WHERE SHIPPINGINVOICEDATA_id IN (<ids>)")
    @RegisterBeanMapper(Shippinginvoicedata.class)
    public List<Shippinginvoicedata> findByIds(@BindList("ids") Collection<Integer> ids);
}
