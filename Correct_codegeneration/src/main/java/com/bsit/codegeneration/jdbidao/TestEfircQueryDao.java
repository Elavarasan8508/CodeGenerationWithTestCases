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
import com.bsit.codegeneration.entity.TestEfircQuery;

public interface TestEfircQueryDao {

    /**
     * Inserts a new TestEfircQuery and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO TEST_EFIRC_QUERY (FIRC_NUMBER, FIRC_AD_CODE, REMITTANCE_AMOUNT, AMOUNT_UTILIZED, AMOUNT_OUTSTANDING, SWIFT_CODE, FIRC_ISSUE_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMITTER_BANK_COUNTRY) VALUES (:fircNumber, :fircAdCode, :remittanceAmount, :amountUtilized, :amountOutstanding, :swiftCode, :fircIssueDate, :ieCode, :remitterName, :remitterCountry, :remitterBankCountry)")
    public int insert(@BindBean TestEfircQuery testefircquery);

    /**
     * Finds a TestEfircQuery by its ID.
     */
    @SqlQuery("SELECT * FROM TEST_EFIRC_QUERY WHERE TEST_EFIRC_QUERY_id = :id")
    @RegisterBeanMapper(TestEfircQuery.class)
    public Optional<TestEfircQuery> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM TEST_EFIRC_QUERY")
    @RegisterBeanMapper(TestEfircQuery.class)
    public List<TestEfircQuery> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM TEST_EFIRC_QUERY ORDER BY TEST_EFIRC_QUERY_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(TestEfircQuery.class)
    public List<TestEfircQuery> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a TestEfircQuery and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE TEST_EFIRC_QUERY SET FIRC_NUMBER = :fircNumber, FIRC_AD_CODE = :fircAdCode, REMITTANCE_AMOUNT = :remittanceAmount, AMOUNT_UTILIZED = :amountUtilized, AMOUNT_OUTSTANDING = :amountOutstanding, SWIFT_CODE = :swiftCode, FIRC_ISSUE_DATE = :fircIssueDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMITTER_BANK_COUNTRY = :remitterBankCountry WHERE TEST_EFIRC_QUERY_id = :testEfircQueryId")
    public int update(@BindBean TestEfircQuery testefircquery);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM TEST_EFIRC_QUERY WHERE TEST_EFIRC_QUERY_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM TEST_EFIRC_QUERY")
    public long countAll();

    /**
     * Bulk insert multiple TestEfircQuery entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO TEST_EFIRC_QUERY (FIRC_NUMBER, FIRC_AD_CODE, REMITTANCE_AMOUNT, AMOUNT_UTILIZED, AMOUNT_OUTSTANDING, SWIFT_CODE, FIRC_ISSUE_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMITTER_BANK_COUNTRY) VALUES (:fircNumber, :fircAdCode, :remittanceAmount, :amountUtilized, :amountOutstanding, :swiftCode, :fircIssueDate, :ieCode, :remitterName, :remitterCountry, :remitterBankCountry)")
    public int[] bulkInsert(@BindBean List<TestEfircQuery> testefircquerys);

    /**
     * Bulk update multiple TestEfircQuery entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE TEST_EFIRC_QUERY SET FIRC_NUMBER = :fircNumber, FIRC_AD_CODE = :fircAdCode, REMITTANCE_AMOUNT = :remittanceAmount, AMOUNT_UTILIZED = :amountUtilized, AMOUNT_OUTSTANDING = :amountOutstanding, SWIFT_CODE = :swiftCode, FIRC_ISSUE_DATE = :fircIssueDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMITTER_BANK_COUNTRY = :remitterBankCountry WHERE TEST_EFIRC_QUERY_id = :testEfircQueryId")
    public int[] bulkUpdate(@BindBean List<TestEfircQuery> testefircquerys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM TEST_EFIRC_QUERY WHERE TEST_EFIRC_QUERY_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM TEST_EFIRC_QUERY WHERE TEST_EFIRC_QUERY_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple TestEfircQuery records by their IDs.
     */
    @SqlQuery("SELECT * FROM TEST_EFIRC_QUERY WHERE TEST_EFIRC_QUERY_id IN (<ids>)")
    @RegisterBeanMapper(TestEfircQuery.class)
    public List<TestEfircQuery> findByIds(@BindList("ids") Collection<Integer> ids);
}
