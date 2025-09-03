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
import com.bsit.codegeneration.entity.FgActHiCaseinst;

public interface FgActHiCaseinstDao {

    /**
     * Inserts a new FgActHiCaseinst and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_CASEINST (ID_, CASE_INST_ID_, BUSINESS_KEY_, CASE_DEF_ID_, CREATE_TIME_, CLOSE_TIME_, DURATION_, STATE_, CREATE_USER_ID_, SUPER_CASE_INSTANCE_ID_, SUPER_PROCESS_INSTANCE_ID_, TENANT_ID_) VALUES (:id, :caseInstId, :businessKey, :caseDefId, :createTime, :closeTime, :duration, :state, :createUserId, :superCaseInstanceId, :superProcessInstanceId, :tenantId)")
    public int insert(@BindBean FgActHiCaseinst fgacthicaseinst);

    /**
     * Finds a FgActHiCaseinst by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEINST WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiCaseinst.class)
    public Optional<FgActHiCaseinst> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEINST")
    @RegisterBeanMapper(FgActHiCaseinst.class)
    public List<FgActHiCaseinst> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEINST ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiCaseinst.class)
    public List<FgActHiCaseinst> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiCaseinst and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_CASEINST SET CASE_INST_ID_ = :caseInstId, BUSINESS_KEY_ = :businessKey, CASE_DEF_ID_ = :caseDefId, CREATE_TIME_ = :createTime, CLOSE_TIME_ = :closeTime, DURATION_ = :duration, STATE_ = :state, CREATE_USER_ID_ = :createUserId, SUPER_CASE_INSTANCE_ID_ = :superCaseInstanceId, SUPER_PROCESS_INSTANCE_ID_ = :superProcessInstanceId, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int update(@BindBean FgActHiCaseinst fgacthicaseinst);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_CASEINST WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_CASEINST")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiCaseinst entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_CASEINST (ID_, CASE_INST_ID_, BUSINESS_KEY_, CASE_DEF_ID_, CREATE_TIME_, CLOSE_TIME_, DURATION_, STATE_, CREATE_USER_ID_, SUPER_CASE_INSTANCE_ID_, SUPER_PROCESS_INSTANCE_ID_, TENANT_ID_) VALUES (:id, :caseInstId, :businessKey, :caseDefId, :createTime, :closeTime, :duration, :state, :createUserId, :superCaseInstanceId, :superProcessInstanceId, :tenantId)")
    public int[] bulkInsert(@BindBean List<FgActHiCaseinst> fgacthicaseinsts);

    /**
     * Bulk update multiple FgActHiCaseinst entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_CASEINST SET CASE_INST_ID_ = :caseInstId, BUSINESS_KEY_ = :businessKey, CASE_DEF_ID_ = :caseDefId, CREATE_TIME_ = :createTime, CLOSE_TIME_ = :closeTime, DURATION_ = :duration, STATE_ = :state, CREATE_USER_ID_ = :createUserId, SUPER_CASE_INSTANCE_ID_ = :superCaseInstanceId, SUPER_PROCESS_INSTANCE_ID_ = :superProcessInstanceId, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiCaseinst> fgacthicaseinsts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_CASEINST WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_CASEINST WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiCaseinst records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEINST WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiCaseinst.class)
    public List<FgActHiCaseinst> findByIds(@BindList("ids") Collection<String> ids);
}
