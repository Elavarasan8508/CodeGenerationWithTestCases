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
import com.bsit.codegeneration.entity.FgActHiDecIn;

public interface FgActHiDecInDao {

    /**
     * Inserts a new FgActHiDecIn and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_DEC_IN (ID_, DEC_INST_ID_, CLAUSE_ID_, CLAUSE_NAME_, VAR_TYPE_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, TENANT_ID_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :decInstId, :clauseId, :clauseName, :varType, :bytearrayId, :double, :long, :text, :text2, :tenantId, :createTime, :rootProcInstId, :removalTime)")
    public int insert(@BindBean FgActHiDecIn fgacthidecin);

    /**
     * Finds a FgActHiDecIn by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DEC_IN WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiDecIn.class)
    public Optional<FgActHiDecIn> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DEC_IN")
    @RegisterBeanMapper(FgActHiDecIn.class)
    public List<FgActHiDecIn> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DEC_IN ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiDecIn.class)
    public List<FgActHiDecIn> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiDecIn and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_DEC_IN SET DEC_INST_ID_ = :decInstId, CLAUSE_ID_ = :clauseId, CLAUSE_NAME_ = :clauseName, VAR_TYPE_ = :varType, BYTEARRAY_ID_ = :bytearrayId, DOUBLE_ = :double, LONG_ = :long, TEXT_ = :text, TEXT2_ = :text2, TENANT_ID_ = :tenantId, CREATE_TIME_ = :createTime, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int update(@BindBean FgActHiDecIn fgacthidecin);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_DEC_IN WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_DEC_IN")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiDecIn entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_DEC_IN (ID_, DEC_INST_ID_, CLAUSE_ID_, CLAUSE_NAME_, VAR_TYPE_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, TENANT_ID_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :decInstId, :clauseId, :clauseName, :varType, :bytearrayId, :double, :long, :text, :text2, :tenantId, :createTime, :rootProcInstId, :removalTime)")
    public int[] bulkInsert(@BindBean List<FgActHiDecIn> fgacthidecins);

    /**
     * Bulk update multiple FgActHiDecIn entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_DEC_IN SET DEC_INST_ID_ = :decInstId, CLAUSE_ID_ = :clauseId, CLAUSE_NAME_ = :clauseName, VAR_TYPE_ = :varType, BYTEARRAY_ID_ = :bytearrayId, DOUBLE_ = :double, LONG_ = :long, TEXT_ = :text, TEXT2_ = :text2, TENANT_ID_ = :tenantId, CREATE_TIME_ = :createTime, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiDecIn> fgacthidecins);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_DEC_IN WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_DEC_IN WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiDecIn records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DEC_IN WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiDecIn.class)
    public List<FgActHiDecIn> findByIds(@BindList("ids") Collection<String> ids);
}
