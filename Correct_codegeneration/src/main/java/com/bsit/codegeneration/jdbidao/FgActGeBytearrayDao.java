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
import com.bsit.codegeneration.entity.FgActGeBytearray;

public interface FgActGeBytearrayDao {

    /**
     * Inserts a new FgActGeBytearray and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_GE_BYTEARRAY (ID_, REV_, NAME_, DEPLOYMENT_ID_, BYTES_, GENERATED_, TENANT_ID_, TYPE_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :rev, :name, :deploymentId, :bytes, :generated, :tenantId, :type, :createTime, :rootProcInstId, :removalTime)")
    public int insert(@BindBean FgActGeBytearray fgactgebytearray);

    /**
     * Finds a FgActGeBytearray by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_BYTEARRAY WHERE ID_ = :id")
    @RegisterBeanMapper(FgActGeBytearray.class)
    public Optional<FgActGeBytearray> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_BYTEARRAY")
    @RegisterBeanMapper(FgActGeBytearray.class)
    public List<FgActGeBytearray> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_BYTEARRAY ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActGeBytearray.class)
    public List<FgActGeBytearray> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActGeBytearray and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_GE_BYTEARRAY SET REV_ = :rev, NAME_ = :name, DEPLOYMENT_ID_ = :deploymentId, BYTES_ = :bytes, GENERATED_ = :generated, TENANT_ID_ = :tenantId, TYPE_ = :type, CREATE_TIME_ = :createTime, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int update(@BindBean FgActGeBytearray fgactgebytearray);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_GE_BYTEARRAY WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_GE_BYTEARRAY")
    public long countAll();

    /**
     * Bulk insert multiple FgActGeBytearray entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_GE_BYTEARRAY (ID_, REV_, NAME_, DEPLOYMENT_ID_, BYTES_, GENERATED_, TENANT_ID_, TYPE_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :rev, :name, :deploymentId, :bytes, :generated, :tenantId, :type, :createTime, :rootProcInstId, :removalTime)")
    public int[] bulkInsert(@BindBean List<FgActGeBytearray> fgactgebytearrays);

    /**
     * Bulk update multiple FgActGeBytearray entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_GE_BYTEARRAY SET REV_ = :rev, NAME_ = :name, DEPLOYMENT_ID_ = :deploymentId, BYTES_ = :bytes, GENERATED_ = :generated, TENANT_ID_ = :tenantId, TYPE_ = :type, CREATE_TIME_ = :createTime, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActGeBytearray> fgactgebytearrays);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_GE_BYTEARRAY WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_GE_BYTEARRAY WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActGeBytearray records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_BYTEARRAY WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActGeBytearray.class)
    public List<FgActGeBytearray> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActGeBytearray records by deploymentId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_BYTEARRAY WHERE DEPLOYMENT_ID_ = :deploymentId")
    @RegisterBeanMapper(FgActGeBytearray.class)
    public List<FgActGeBytearray> findByDeploymentId(@Bind("deploymentId") int deploymentId);
}
