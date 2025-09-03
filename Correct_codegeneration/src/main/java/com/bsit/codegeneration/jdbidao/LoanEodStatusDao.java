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
import com.bsit.codegeneration.entity.LoanEodStatus;

public interface LoanEodStatusDao {

    /**
     * Inserts a new LoanEodStatus and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LOAN_EOD_STATUS (JOB_ID, JOB_NAME, JOB_STATUS, JOB_EXIT_CODE, EOD_START_DATE, EOD_END_DATE, REMARKS, STATUS) VALUES (:jobId, :jobName, :jobStatus, :jobExitCode, :eodStartDate, :eodEndDate, :remarks, :status)")
    public int insert(@BindBean LoanEodStatus loaneodstatus);

    /**
     * Finds a LoanEodStatus by its ID.
     */
    @SqlQuery("SELECT * FROM LOAN_EOD_STATUS WHERE LOAN_EOD_STATUS_id = :id")
    @RegisterBeanMapper(LoanEodStatus.class)
    public Optional<LoanEodStatus> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LOAN_EOD_STATUS")
    @RegisterBeanMapper(LoanEodStatus.class)
    public List<LoanEodStatus> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LOAN_EOD_STATUS ORDER BY LOAN_EOD_STATUS_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LoanEodStatus.class)
    public List<LoanEodStatus> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LoanEodStatus and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LOAN_EOD_STATUS SET JOB_ID = :jobId, JOB_NAME = :jobName, JOB_STATUS = :jobStatus, JOB_EXIT_CODE = :jobExitCode, EOD_START_DATE = :eodStartDate, EOD_END_DATE = :eodEndDate, REMARKS = :remarks, STATUS = :status WHERE LOAN_EOD_STATUS_id = :loanEodStatusId")
    public int update(@BindBean LoanEodStatus loaneodstatus);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LOAN_EOD_STATUS WHERE LOAN_EOD_STATUS_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LOAN_EOD_STATUS")
    public long countAll();

    /**
     * Bulk insert multiple LoanEodStatus entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LOAN_EOD_STATUS (JOB_ID, JOB_NAME, JOB_STATUS, JOB_EXIT_CODE, EOD_START_DATE, EOD_END_DATE, REMARKS, STATUS) VALUES (:jobId, :jobName, :jobStatus, :jobExitCode, :eodStartDate, :eodEndDate, :remarks, :status)")
    public int[] bulkInsert(@BindBean List<LoanEodStatus> loaneodstatuss);

    /**
     * Bulk update multiple LoanEodStatus entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LOAN_EOD_STATUS SET JOB_ID = :jobId, JOB_NAME = :jobName, JOB_STATUS = :jobStatus, JOB_EXIT_CODE = :jobExitCode, EOD_START_DATE = :eodStartDate, EOD_END_DATE = :eodEndDate, REMARKS = :remarks, STATUS = :status WHERE LOAN_EOD_STATUS_id = :loanEodStatusId")
    public int[] bulkUpdate(@BindBean List<LoanEodStatus> loaneodstatuss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LOAN_EOD_STATUS WHERE LOAN_EOD_STATUS_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LOAN_EOD_STATUS WHERE LOAN_EOD_STATUS_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple LoanEodStatus records by their IDs.
     */
    @SqlQuery("SELECT * FROM LOAN_EOD_STATUS WHERE LOAN_EOD_STATUS_id IN (<ids>)")
    @RegisterBeanMapper(LoanEodStatus.class)
    public List<LoanEodStatus> findByIds(@BindList("ids") Collection<Integer> ids);
}
