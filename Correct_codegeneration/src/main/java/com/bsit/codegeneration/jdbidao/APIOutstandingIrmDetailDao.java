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
import com.bsit.codegeneration.entity.APIOutstandingIrmDetail;

public interface APIOutstandingIrmDetailDao {

    /**
     * Inserts a new APIOutstandingIrmDetail and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO API_OUTSTANDING_IRM_DETAIL (IRM_NUMBER, AD_CODE, REMITTANCE_AMOUNT, AMOUNT_OUTSTANDING, REMITTANCE_CURRENCY, REMITTANCE_DATE, IE_CODE, REMITTER_NAME) VALUES (:irmNumber, :adCode, :remittanceAmount, :amountOutstanding, :remittanceCurrency, :remittanceDate, :ieCode, :remitterName)")
    public int insert(@BindBean APIOutstandingIrmDetail apioutstandingirmdetail);

    /**
     * Finds a APIOutstandingIrmDetail by its ID.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_IRM_DETAIL WHERE API_OUTSTANDING_IRM_DETAIL_id = :id")
    @RegisterBeanMapper(APIOutstandingIrmDetail.class)
    public Optional<APIOutstandingIrmDetail> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_IRM_DETAIL")
    @RegisterBeanMapper(APIOutstandingIrmDetail.class)
    public List<APIOutstandingIrmDetail> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_IRM_DETAIL ORDER BY API_OUTSTANDING_IRM_DETAIL_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(APIOutstandingIrmDetail.class)
    public List<APIOutstandingIrmDetail> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a APIOutstandingIrmDetail and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE API_OUTSTANDING_IRM_DETAIL SET IRM_NUMBER = :irmNumber, AD_CODE = :adCode, REMITTANCE_AMOUNT = :remittanceAmount, AMOUNT_OUTSTANDING = :amountOutstanding, REMITTANCE_CURRENCY = :remittanceCurrency, REMITTANCE_DATE = :remittanceDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName WHERE API_OUTSTANDING_IRM_DETAIL_id = :APIOutstandingIrmDetailId")
    public int update(@BindBean APIOutstandingIrmDetail apioutstandingirmdetail);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM API_OUTSTANDING_IRM_DETAIL WHERE API_OUTSTANDING_IRM_DETAIL_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM API_OUTSTANDING_IRM_DETAIL")
    public long countAll();

    /**
     * Bulk insert multiple APIOutstandingIrmDetail entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO API_OUTSTANDING_IRM_DETAIL (IRM_NUMBER, AD_CODE, REMITTANCE_AMOUNT, AMOUNT_OUTSTANDING, REMITTANCE_CURRENCY, REMITTANCE_DATE, IE_CODE, REMITTER_NAME) VALUES (:irmNumber, :adCode, :remittanceAmount, :amountOutstanding, :remittanceCurrency, :remittanceDate, :ieCode, :remitterName)")
    public int[] bulkInsert(@BindBean List<APIOutstandingIrmDetail> apioutstandingirmdetails);

    /**
     * Bulk update multiple APIOutstandingIrmDetail entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE API_OUTSTANDING_IRM_DETAIL SET IRM_NUMBER = :irmNumber, AD_CODE = :adCode, REMITTANCE_AMOUNT = :remittanceAmount, AMOUNT_OUTSTANDING = :amountOutstanding, REMITTANCE_CURRENCY = :remittanceCurrency, REMITTANCE_DATE = :remittanceDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName WHERE API_OUTSTANDING_IRM_DETAIL_id = :APIOutstandingIrmDetailId")
    public int[] bulkUpdate(@BindBean List<APIOutstandingIrmDetail> apioutstandingirmdetails);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM API_OUTSTANDING_IRM_DETAIL WHERE API_OUTSTANDING_IRM_DETAIL_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM API_OUTSTANDING_IRM_DETAIL WHERE API_OUTSTANDING_IRM_DETAIL_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple APIOutstandingIrmDetail records by their IDs.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_IRM_DETAIL WHERE API_OUTSTANDING_IRM_DETAIL_id IN (<ids>)")
    @RegisterBeanMapper(APIOutstandingIrmDetail.class)
    public List<APIOutstandingIrmDetail> findByIds(@BindList("ids") Collection<Integer> ids);
}
