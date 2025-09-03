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
import com.bsit.codegeneration.entity.FgActIdInfo;

public interface FgActIdInfoDao {

    /**
     * Inserts a new FgActIdInfo and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_ID_INFO (ID_, REV_, USER_ID_, TYPE_, KEY_, VALUE_, PASSWORD_, PARENT_ID_) VALUES (:id, :rev, :userId, :type, :key, :value, :password, :parentId)")
    public int insert(@BindBean FgActIdInfo fgactidinfo);

    /**
     * Finds a FgActIdInfo by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_INFO WHERE ID_ = :id")
    @RegisterBeanMapper(FgActIdInfo.class)
    public Optional<FgActIdInfo> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_INFO")
    @RegisterBeanMapper(FgActIdInfo.class)
    public List<FgActIdInfo> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_INFO ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActIdInfo.class)
    public List<FgActIdInfo> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActIdInfo and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_ID_INFO SET REV_ = :rev, USER_ID_ = :userId, TYPE_ = :type, KEY_ = :key, VALUE_ = :value, PASSWORD_ = :password, PARENT_ID_ = :parentId WHERE ID_ = :id")
    public int update(@BindBean FgActIdInfo fgactidinfo);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_ID_INFO WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_ID_INFO")
    public long countAll();

    /**
     * Bulk insert multiple FgActIdInfo entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_ID_INFO (ID_, REV_, USER_ID_, TYPE_, KEY_, VALUE_, PASSWORD_, PARENT_ID_) VALUES (:id, :rev, :userId, :type, :key, :value, :password, :parentId)")
    public int[] bulkInsert(@BindBean List<FgActIdInfo> fgactidinfos);

    /**
     * Bulk update multiple FgActIdInfo entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_ID_INFO SET REV_ = :rev, USER_ID_ = :userId, TYPE_ = :type, KEY_ = :key, VALUE_ = :value, PASSWORD_ = :password, PARENT_ID_ = :parentId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActIdInfo> fgactidinfos);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_ID_INFO WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_ID_INFO WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActIdInfo records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_INFO WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActIdInfo.class)
    public List<FgActIdInfo> findByIds(@BindList("ids") Collection<String> ids);
}
