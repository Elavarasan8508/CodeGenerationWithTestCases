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
import com.bsit.codegeneration.entity.Databasechangeloglock;

public interface DatabasechangeloglockDao {

    /**
     * Inserts a new Databasechangeloglock and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO DATABASECHANGELOGLOCK (ID, LOCKED, LOCKGRANTED, LOCKEDBY) VALUES (:id, :locked, :lockgranted, :lockedby)")
    public int insert(@BindBean Databasechangeloglock databasechangeloglock);

    /**
     * Finds a Databasechangeloglock by its ID.
     */
    @SqlQuery("SELECT * FROM DATABASECHANGELOGLOCK WHERE ID = :id")
    @RegisterBeanMapper(Databasechangeloglock.class)
    public Optional<Databasechangeloglock> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM DATABASECHANGELOGLOCK")
    @RegisterBeanMapper(Databasechangeloglock.class)
    public List<Databasechangeloglock> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM DATABASECHANGELOGLOCK ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Databasechangeloglock.class)
    public List<Databasechangeloglock> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Databasechangeloglock and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE DATABASECHANGELOGLOCK SET LOCKED = :locked, LOCKGRANTED = :lockgranted, LOCKEDBY = :lockedby WHERE ID = :id")
    public int update(@BindBean Databasechangeloglock databasechangeloglock);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM DATABASECHANGELOGLOCK WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM DATABASECHANGELOGLOCK")
    public long countAll();

    /**
     * Bulk insert multiple Databasechangeloglock entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO DATABASECHANGELOGLOCK (ID, LOCKED, LOCKGRANTED, LOCKEDBY) VALUES (:id, :locked, :lockgranted, :lockedby)")
    public int[] bulkInsert(@BindBean List<Databasechangeloglock> databasechangeloglocks);

    /**
     * Bulk update multiple Databasechangeloglock entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE DATABASECHANGELOGLOCK SET LOCKED = :locked, LOCKGRANTED = :lockgranted, LOCKEDBY = :lockedby WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<Databasechangeloglock> databasechangeloglocks);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE DATABASECHANGELOGLOCK SET LOCKED = :locked, LOCKGRANTED = :lockgranted, LOCKEDBY = :lockedby WHERE ID = :id")
    public int[] bulkUpdateParams(@Bind("locked") List<java.math.BigDecimal> lockeds, @Bind("lockgranted") List<String> lockgranteds, @Bind("lockedby") List<String> lockedbys, @Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM DATABASECHANGELOGLOCK WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM DATABASECHANGELOGLOCK WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple Databasechangeloglock records by their IDs.
     */
    @SqlQuery("SELECT * FROM DATABASECHANGELOGLOCK WHERE ID IN (<ids>)")
    @RegisterBeanMapper(Databasechangeloglock.class)
    public List<Databasechangeloglock> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
