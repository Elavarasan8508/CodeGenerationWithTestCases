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
import com.bsit.codegeneration.entity.FgActHiDecinst;

public interface FgActHiDecinstDao {

    /**
     * Inserts a new FgActHiDecinst and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_DECINST (ID_, DEC_DEF_ID_, DEC_DEF_KEY_, DEC_DEF_NAME_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, ACT_INST_ID_, ACT_ID_, EVAL_TIME_, COLLECT_VALUE_, USER_ID_, ROOT_DEC_INST_ID_, DEC_REQ_ID_, DEC_REQ_KEY_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :decDefId, :decDefKey, :decDefName, :procDefKey, :procDefId, :procInstId, :caseDefKey, :caseDefId, :caseInstId, :actInstId, :actId, :evalTime, :collectValue, :userId, :rootDecInstId, :decReqId, :decReqKey, :tenantId, :rootProcInstId, :removalTime)")
    public int insert(@BindBean FgActHiDecinst fgacthidecinst);

    /**
     * Finds a FgActHiDecinst by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DECINST WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiDecinst.class)
    public Optional<FgActHiDecinst> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DECINST")
    @RegisterBeanMapper(FgActHiDecinst.class)
    public List<FgActHiDecinst> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DECINST ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiDecinst.class)
    public List<FgActHiDecinst> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiDecinst and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_DECINST SET DEC_DEF_ID_ = :decDefId, DEC_DEF_KEY_ = :decDefKey, DEC_DEF_NAME_ = :decDefName, PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, CASE_DEF_KEY_ = :caseDefKey, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, ACT_INST_ID_ = :actInstId, ACT_ID_ = :actId, EVAL_TIME_ = :evalTime, COLLECT_VALUE_ = :collectValue, USER_ID_ = :userId, ROOT_DEC_INST_ID_ = :rootDecInstId, DEC_REQ_ID_ = :decReqId, DEC_REQ_KEY_ = :decReqKey, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int update(@BindBean FgActHiDecinst fgacthidecinst);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_DECINST WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_DECINST")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiDecinst entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_DECINST (ID_, DEC_DEF_ID_, DEC_DEF_KEY_, DEC_DEF_NAME_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, ACT_INST_ID_, ACT_ID_, EVAL_TIME_, COLLECT_VALUE_, USER_ID_, ROOT_DEC_INST_ID_, DEC_REQ_ID_, DEC_REQ_KEY_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :decDefId, :decDefKey, :decDefName, :procDefKey, :procDefId, :procInstId, :caseDefKey, :caseDefId, :caseInstId, :actInstId, :actId, :evalTime, :collectValue, :userId, :rootDecInstId, :decReqId, :decReqKey, :tenantId, :rootProcInstId, :removalTime)")
    public int[] bulkInsert(@BindBean List<FgActHiDecinst> fgacthidecinsts);

    /**
     * Bulk update multiple FgActHiDecinst entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_DECINST SET DEC_DEF_ID_ = :decDefId, DEC_DEF_KEY_ = :decDefKey, DEC_DEF_NAME_ = :decDefName, PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, CASE_DEF_KEY_ = :caseDefKey, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, ACT_INST_ID_ = :actInstId, ACT_ID_ = :actId, EVAL_TIME_ = :evalTime, COLLECT_VALUE_ = :collectValue, USER_ID_ = :userId, ROOT_DEC_INST_ID_ = :rootDecInstId, DEC_REQ_ID_ = :decReqId, DEC_REQ_KEY_ = :decReqKey, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiDecinst> fgacthidecinsts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_DECINST WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_DECINST WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiDecinst records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DECINST WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiDecinst.class)
    public List<FgActHiDecinst> findByIds(@BindList("ids") Collection<String> ids);
}
