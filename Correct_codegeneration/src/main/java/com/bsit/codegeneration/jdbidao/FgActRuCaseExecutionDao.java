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
import com.bsit.codegeneration.entity.FgActRuCaseExecution;

public interface FgActRuCaseExecutionDao {

    /**
     * Inserts a new FgActRuCaseExecution and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_CASE_EXECUTION (ID_, REV_, CASE_INST_ID_, SUPER_CASE_EXEC_, SUPER_EXEC_, BUSINESS_KEY_, PARENT_ID_, CASE_DEF_ID_, ACT_ID_, PREV_STATE_, CURRENT_STATE_, REQUIRED_, TENANT_ID_) VALUES (:id, :rev, :caseInstId, :superCaseExec, :superExec, :businessKey, :parentId, :caseDefId, :actId, :prevState, :currentState, :required, :tenantId)")
    public int insert(@BindBean FgActRuCaseExecution fgactrucaseexecution);

    /**
     * Finds a FgActRuCaseExecution by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_EXECUTION WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuCaseExecution.class)
    public Optional<FgActRuCaseExecution> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_EXECUTION")
    @RegisterBeanMapper(FgActRuCaseExecution.class)
    public List<FgActRuCaseExecution> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_EXECUTION ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuCaseExecution.class)
    public List<FgActRuCaseExecution> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuCaseExecution and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_CASE_EXECUTION SET REV_ = :rev, CASE_INST_ID_ = :caseInstId, SUPER_CASE_EXEC_ = :superCaseExec, SUPER_EXEC_ = :superExec, BUSINESS_KEY_ = :businessKey, PARENT_ID_ = :parentId, CASE_DEF_ID_ = :caseDefId, ACT_ID_ = :actId, PREV_STATE_ = :prevState, CURRENT_STATE_ = :currentState, REQUIRED_ = :required, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int update(@BindBean FgActRuCaseExecution fgactrucaseexecution);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_CASE_EXECUTION WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_CASE_EXECUTION")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuCaseExecution entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_CASE_EXECUTION (ID_, REV_, CASE_INST_ID_, SUPER_CASE_EXEC_, SUPER_EXEC_, BUSINESS_KEY_, PARENT_ID_, CASE_DEF_ID_, ACT_ID_, PREV_STATE_, CURRENT_STATE_, REQUIRED_, TENANT_ID_) VALUES (:id, :rev, :caseInstId, :superCaseExec, :superExec, :businessKey, :parentId, :caseDefId, :actId, :prevState, :currentState, :required, :tenantId)")
    public int[] bulkInsert(@BindBean List<FgActRuCaseExecution> fgactrucaseexecutions);

    /**
     * Bulk update multiple FgActRuCaseExecution entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_CASE_EXECUTION SET REV_ = :rev, CASE_INST_ID_ = :caseInstId, SUPER_CASE_EXEC_ = :superCaseExec, SUPER_EXEC_ = :superExec, BUSINESS_KEY_ = :businessKey, PARENT_ID_ = :parentId, CASE_DEF_ID_ = :caseDefId, ACT_ID_ = :actId, PREV_STATE_ = :prevState, CURRENT_STATE_ = :currentState, REQUIRED_ = :required, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuCaseExecution> fgactrucaseexecutions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_CASE_EXECUTION WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_CASE_EXECUTION WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuCaseExecution records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_EXECUTION WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuCaseExecution.class)
    public List<FgActRuCaseExecution> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActRuCaseExecution records by caseDefId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_EXECUTION WHERE CASE_DEF_ID_ = :caseDefId")
    @RegisterBeanMapper(FgActRuCaseExecution.class)
    public List<FgActRuCaseExecution> findByCaseDefId(@Bind("caseDefId") int caseDefId);

    /**
     * Finds all FgActRuCaseExecution records by parentId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_EXECUTION WHERE PARENT_ID_ = :parentId")
    @RegisterBeanMapper(FgActRuCaseExecution.class)
    public List<FgActRuCaseExecution> findByParentId(@Bind("parentId") int parentId);

    /**
     * Finds all FgActRuCaseExecution records by caseInstId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_EXECUTION WHERE CASE_INST_ID_ = :caseInstId")
    @RegisterBeanMapper(FgActRuCaseExecution.class)
    public List<FgActRuCaseExecution> findByCaseInstId(@Bind("caseInstId") int caseInstId);
}
