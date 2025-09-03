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
import com.bsit.codegeneration.entity.APIOutstandingEfircDetail;

public interface APIOutstandingEfircDetailDao {

    /**
     * Inserts a new APIOutstandingEfircDetail and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO API_OUTSTANDING_EFIRC_DETAIL (FIRC_NUMBER, REMITTANCE_AMOUNT, AMOUNT_UTILIZED, AMOUNT_OUTSTANDING, SWIFT_CODE, FIRC_ISSUE_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMITTER_BANK_COUNTRY, FIRC_AD_CODE) VALUES (:fircNumber, :remittanceAmount, :amountUtilized, :amountOutstanding, :swiftCode, :fircIssueDate, :ieCode, :remitterName, :remitterCountry, :remitterBankCountry, :fircAdCode)")
    public int insert(@BindBean APIOutstandingEfircDetail apioutstandingefircdetail);

    /**
     * Finds a APIOutstandingEfircDetail by its ID.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_EFIRC_DETAIL WHERE API_OUTSTANDING_EFIRC_DETAIL_id = :id")
    @RegisterBeanMapper(APIOutstandingEfircDetail.class)
    public Optional<APIOutstandingEfircDetail> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_EFIRC_DETAIL")
    @RegisterBeanMapper(APIOutstandingEfircDetail.class)
    public List<APIOutstandingEfircDetail> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_EFIRC_DETAIL ORDER BY API_OUTSTANDING_EFIRC_DETAIL_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(APIOutstandingEfircDetail.class)
    public List<APIOutstandingEfircDetail> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a APIOutstandingEfircDetail and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE API_OUTSTANDING_EFIRC_DETAIL SET FIRC_NUMBER = :fircNumber, REMITTANCE_AMOUNT = :remittanceAmount, AMOUNT_UTILIZED = :amountUtilized, AMOUNT_OUTSTANDING = :amountOutstanding, SWIFT_CODE = :swiftCode, FIRC_ISSUE_DATE = :fircIssueDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMITTER_BANK_COUNTRY = :remitterBankCountry, FIRC_AD_CODE = :fircAdCode WHERE API_OUTSTANDING_EFIRC_DETAIL_id = :APIOutstandingEfircDetailId")
    public int update(@BindBean APIOutstandingEfircDetail apioutstandingefircdetail);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM API_OUTSTANDING_EFIRC_DETAIL WHERE API_OUTSTANDING_EFIRC_DETAIL_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM API_OUTSTANDING_EFIRC_DETAIL")
    public long countAll();

    /**
     * Bulk insert multiple APIOutstandingEfircDetail entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO API_OUTSTANDING_EFIRC_DETAIL (FIRC_NUMBER, REMITTANCE_AMOUNT, AMOUNT_UTILIZED, AMOUNT_OUTSTANDING, SWIFT_CODE, FIRC_ISSUE_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMITTER_BANK_COUNTRY, FIRC_AD_CODE) VALUES (:fircNumber, :remittanceAmount, :amountUtilized, :amountOutstanding, :swiftCode, :fircIssueDate, :ieCode, :remitterName, :remitterCountry, :remitterBankCountry, :fircAdCode)")
    public int[] bulkInsert(@BindBean List<APIOutstandingEfircDetail> apioutstandingefircdetails);

    /**
     * Bulk update multiple APIOutstandingEfircDetail entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE API_OUTSTANDING_EFIRC_DETAIL SET FIRC_NUMBER = :fircNumber, REMITTANCE_AMOUNT = :remittanceAmount, AMOUNT_UTILIZED = :amountUtilized, AMOUNT_OUTSTANDING = :amountOutstanding, SWIFT_CODE = :swiftCode, FIRC_ISSUE_DATE = :fircIssueDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMITTER_BANK_COUNTRY = :remitterBankCountry, FIRC_AD_CODE = :fircAdCode WHERE API_OUTSTANDING_EFIRC_DETAIL_id = :APIOutstandingEfircDetailId")
    public int[] bulkUpdate(@BindBean List<APIOutstandingEfircDetail> apioutstandingefircdetails);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM API_OUTSTANDING_EFIRC_DETAIL WHERE API_OUTSTANDING_EFIRC_DETAIL_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM API_OUTSTANDING_EFIRC_DETAIL WHERE API_OUTSTANDING_EFIRC_DETAIL_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple APIOutstandingEfircDetail records by their IDs.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_EFIRC_DETAIL WHERE API_OUTSTANDING_EFIRC_DETAIL_id IN (<ids>)")
    @RegisterBeanMapper(APIOutstandingEfircDetail.class)
    public List<APIOutstandingEfircDetail> findByIds(@BindList("ids") Collection<Integer> ids);
}
