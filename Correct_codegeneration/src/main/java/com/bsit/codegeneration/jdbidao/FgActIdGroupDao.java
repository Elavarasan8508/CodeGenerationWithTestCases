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
import com.bsit.codegeneration.entity.FgActIdGroup;

public interface FgActIdGroupDao {

    /**
     * Inserts a new FgActIdGroup and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_ID_GROUP (ID_, REV_, NAME_, TYPE_) VALUES (:id, :rev, :name, :type)")
    public int insert(@BindBean FgActIdGroup fgactidgroup);

    /**
     * Finds a FgActIdGroup by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_GROUP WHERE ID_ = :id")
    @RegisterBeanMapper(FgActIdGroup.class)
    public Optional<FgActIdGroup> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_GROUP")
    @RegisterBeanMapper(FgActIdGroup.class)
    public List<FgActIdGroup> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_GROUP ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActIdGroup.class)
    public List<FgActIdGroup> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActIdGroup and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_ID_GROUP SET REV_ = :rev, NAME_ = :name, TYPE_ = :type WHERE ID_ = :id")
    public int update(@BindBean FgActIdGroup fgactidgroup);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_ID_GROUP WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_ID_GROUP")
    public long countAll();

    /**
     * Bulk insert multiple FgActIdGroup entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_ID_GROUP (ID_, REV_, NAME_, TYPE_) VALUES (:id, :rev, :name, :type)")
    public int[] bulkInsert(@BindBean List<FgActIdGroup> fgactidgroups);

    /**
     * Bulk update multiple FgActIdGroup entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_ID_GROUP SET REV_ = :rev, NAME_ = :name, TYPE_ = :type WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActIdGroup> fgactidgroups);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_ID_GROUP SET REV_ = :rev, NAME_ = :name, TYPE_ = :type WHERE ID_ = :id")
    public int[] bulkUpdateParams(@Bind("rev") List<java.math.BigDecimal> revs, @Bind("name") List<String> names, @Bind("type") List<String> types, @Bind("id") List<String> ids);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_ID_GROUP WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_ID_GROUP WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActIdGroup records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_GROUP WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActIdGroup.class)
    public List<FgActIdGroup> findByIds(@BindList("ids") Collection<String> ids);
}
