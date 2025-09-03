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
import com.bsit.codegeneration.entity.Shippingbilldata;

public interface ShippingbilldataDao {

    /**
     * Inserts a new Shippingbilldata and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO SHIPPINGBILLDATA (STATUS, SHIPBILLNO, SHIPBILLDATE, PORTCODE, FORMNO, SHIPPINGBILLAMOUNT, SHIPPINGBILLCURR, UTILIZED_AMT, UNUTILIZED_AMT, BILLREFNO, COUNTER_PARTY) VALUES (:status, :shipbillno, :shipbilldate, :portcode, :formno, :shippingbillamount, :shippingbillcurr, :utilizedAmt, :unutilizedAmt, :billrefno, :counterParty)")
    public int insert(@BindBean Shippingbilldata shippingbilldata);

    /**
     * Finds a Shippingbilldata by its ID.
     */
    @SqlQuery("SELECT * FROM SHIPPINGBILLDATA WHERE SHIPPINGBILLDATA_id = :id")
    @RegisterBeanMapper(Shippingbilldata.class)
    public Optional<Shippingbilldata> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM SHIPPINGBILLDATA")
    @RegisterBeanMapper(Shippingbilldata.class)
    public List<Shippingbilldata> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM SHIPPINGBILLDATA ORDER BY SHIPPINGBILLDATA_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Shippingbilldata.class)
    public List<Shippingbilldata> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Shippingbilldata and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE SHIPPINGBILLDATA SET STATUS = :status, SHIPBILLNO = :shipbillno, SHIPBILLDATE = :shipbilldate, PORTCODE = :portcode, FORMNO = :formno, SHIPPINGBILLAMOUNT = :shippingbillamount, SHIPPINGBILLCURR = :shippingbillcurr, UTILIZED_AMT = :utilizedAmt, UNUTILIZED_AMT = :unutilizedAmt, BILLREFNO = :billrefno, COUNTER_PARTY = :counterParty WHERE SHIPPINGBILLDATA_id = :shippingbilldataId")
    public int update(@BindBean Shippingbilldata shippingbilldata);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM SHIPPINGBILLDATA WHERE SHIPPINGBILLDATA_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM SHIPPINGBILLDATA")
    public long countAll();

    /**
     * Bulk insert multiple Shippingbilldata entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SHIPPINGBILLDATA (STATUS, SHIPBILLNO, SHIPBILLDATE, PORTCODE, FORMNO, SHIPPINGBILLAMOUNT, SHIPPINGBILLCURR, UTILIZED_AMT, UNUTILIZED_AMT, BILLREFNO, COUNTER_PARTY) VALUES (:status, :shipbillno, :shipbilldate, :portcode, :formno, :shippingbillamount, :shippingbillcurr, :utilizedAmt, :unutilizedAmt, :billrefno, :counterParty)")
    public int[] bulkInsert(@BindBean List<Shippingbilldata> shippingbilldatas);

    /**
     * Bulk update multiple Shippingbilldata entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SHIPPINGBILLDATA SET STATUS = :status, SHIPBILLNO = :shipbillno, SHIPBILLDATE = :shipbilldate, PORTCODE = :portcode, FORMNO = :formno, SHIPPINGBILLAMOUNT = :shippingbillamount, SHIPPINGBILLCURR = :shippingbillcurr, UTILIZED_AMT = :utilizedAmt, UNUTILIZED_AMT = :unutilizedAmt, BILLREFNO = :billrefno, COUNTER_PARTY = :counterParty WHERE SHIPPINGBILLDATA_id = :shippingbilldataId")
    public int[] bulkUpdate(@BindBean List<Shippingbilldata> shippingbilldatas);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM SHIPPINGBILLDATA WHERE SHIPPINGBILLDATA_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM SHIPPINGBILLDATA WHERE SHIPPINGBILLDATA_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Shippingbilldata records by their IDs.
     */
    @SqlQuery("SELECT * FROM SHIPPINGBILLDATA WHERE SHIPPINGBILLDATA_id IN (<ids>)")
    @RegisterBeanMapper(Shippingbilldata.class)
    public List<Shippingbilldata> findByIds(@BindList("ids") Collection<Integer> ids);
}
