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
import com.bsit.codegeneration.entity.FgActRuFilter;

public interface FgActRuFilterDao {

    /**
     * Inserts a new FgActRuFilter and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_FILTER (ID_, REV_, RESOURCE_TYPE_, NAME_, OWNER_, QUERY_, PROPERTIES_) VALUES (:id, :rev, :resourceType, :name, :owner, :query, :properties)")
    public int insert(@BindBean FgActRuFilter fgactrufilter);

    /**
     * Finds a FgActRuFilter by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_FILTER WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuFilter.class)
    public Optional<FgActRuFilter> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_FILTER")
    @RegisterBeanMapper(FgActRuFilter.class)
    public List<FgActRuFilter> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_FILTER ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuFilter.class)
    public List<FgActRuFilter> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuFilter and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_FILTER SET REV_ = :rev, RESOURCE_TYPE_ = :resourceType, NAME_ = :name, OWNER_ = :owner, QUERY_ = :query, PROPERTIES_ = :properties WHERE ID_ = :id")
    public int update(@BindBean FgActRuFilter fgactrufilter);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_FILTER WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_FILTER")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuFilter entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_FILTER (ID_, REV_, RESOURCE_TYPE_, NAME_, OWNER_, QUERY_, PROPERTIES_) VALUES (:id, :rev, :resourceType, :name, :owner, :query, :properties)")
    public int[] bulkInsert(@BindBean List<FgActRuFilter> fgactrufilters);

    /**
     * Bulk update multiple FgActRuFilter entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_FILTER SET REV_ = :rev, RESOURCE_TYPE_ = :resourceType, NAME_ = :name, OWNER_ = :owner, QUERY_ = :query, PROPERTIES_ = :properties WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuFilter> fgactrufilters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_FILTER WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_FILTER WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuFilter records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_FILTER WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuFilter.class)
    public List<FgActRuFilter> findByIds(@BindList("ids") Collection<String> ids);
}
