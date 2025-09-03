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
import com.bsit.codegeneration.entity.FgActRuCaseSentryPart;

public interface FgActRuCaseSentryPartDao {

    /**
     * Inserts a new FgActRuCaseSentryPart and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_CASE_SENTRY_PART (ID_, REV_, CASE_INST_ID_, CASE_EXEC_ID_, SENTRY_ID_, TYPE_, SOURCE_CASE_EXEC_ID_, STANDARD_EVENT_, SOURCE_, VARIABLE_EVENT_, VARIABLE_NAME_, SATISFIED_, TENANT_ID_) VALUES (:id, :rev, :caseInstId, :caseExecId, :sentryId, :type, :sourceCaseExecId, :standardEvent, :source, :variableEvent, :variableName, :satisfied, :tenantId)")
    public int insert(@BindBean FgActRuCaseSentryPart fgactrucasesentrypart);

    /**
     * Finds a FgActRuCaseSentryPart by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_SENTRY_PART WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuCaseSentryPart.class)
    public Optional<FgActRuCaseSentryPart> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_SENTRY_PART")
    @RegisterBeanMapper(FgActRuCaseSentryPart.class)
    public List<FgActRuCaseSentryPart> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_SENTRY_PART ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuCaseSentryPart.class)
    public List<FgActRuCaseSentryPart> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuCaseSentryPart and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_CASE_SENTRY_PART SET REV_ = :rev, CASE_INST_ID_ = :caseInstId, CASE_EXEC_ID_ = :caseExecId, SENTRY_ID_ = :sentryId, TYPE_ = :type, SOURCE_CASE_EXEC_ID_ = :sourceCaseExecId, STANDARD_EVENT_ = :standardEvent, SOURCE_ = :source, VARIABLE_EVENT_ = :variableEvent, VARIABLE_NAME_ = :variableName, SATISFIED_ = :satisfied, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int update(@BindBean FgActRuCaseSentryPart fgactrucasesentrypart);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_CASE_SENTRY_PART WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_CASE_SENTRY_PART")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuCaseSentryPart entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_CASE_SENTRY_PART (ID_, REV_, CASE_INST_ID_, CASE_EXEC_ID_, SENTRY_ID_, TYPE_, SOURCE_CASE_EXEC_ID_, STANDARD_EVENT_, SOURCE_, VARIABLE_EVENT_, VARIABLE_NAME_, SATISFIED_, TENANT_ID_) VALUES (:id, :rev, :caseInstId, :caseExecId, :sentryId, :type, :sourceCaseExecId, :standardEvent, :source, :variableEvent, :variableName, :satisfied, :tenantId)")
    public int[] bulkInsert(@BindBean List<FgActRuCaseSentryPart> fgactrucasesentryparts);

    /**
     * Bulk update multiple FgActRuCaseSentryPart entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_CASE_SENTRY_PART SET REV_ = :rev, CASE_INST_ID_ = :caseInstId, CASE_EXEC_ID_ = :caseExecId, SENTRY_ID_ = :sentryId, TYPE_ = :type, SOURCE_CASE_EXEC_ID_ = :sourceCaseExecId, STANDARD_EVENT_ = :standardEvent, SOURCE_ = :source, VARIABLE_EVENT_ = :variableEvent, VARIABLE_NAME_ = :variableName, SATISFIED_ = :satisfied, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuCaseSentryPart> fgactrucasesentryparts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_CASE_SENTRY_PART WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_CASE_SENTRY_PART WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuCaseSentryPart records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_SENTRY_PART WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuCaseSentryPart.class)
    public List<FgActRuCaseSentryPart> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActRuCaseSentryPart records by caseExecId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_SENTRY_PART WHERE CASE_EXEC_ID_ = :caseExecId")
    @RegisterBeanMapper(FgActRuCaseSentryPart.class)
    public List<FgActRuCaseSentryPart> findByCaseExecId(@Bind("caseExecId") int caseExecId);

    /**
     * Finds all FgActRuCaseSentryPart records by caseInstId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_SENTRY_PART WHERE CASE_INST_ID_ = :caseInstId")
    @RegisterBeanMapper(FgActRuCaseSentryPart.class)
    public List<FgActRuCaseSentryPart> findByCaseInstId(@Bind("caseInstId") int caseInstId);
}
