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
import com.bsit.codegeneration.entity.FgActRuMeterLog;

public interface FgActRuMeterLogDao {

    /**
     * Inserts a new FgActRuMeterLog and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_METER_LOG (ID_, NAME_, REPORTER_, VALUE_, TIMESTAMP_, MILLISECONDS_) VALUES (:id, :name, :reporter, :value, :timestamp, :milliseconds)")
    public int insert(@BindBean FgActRuMeterLog fgactrumeterlog);

    /**
     * Finds a FgActRuMeterLog by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_METER_LOG WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuMeterLog.class)
    public Optional<FgActRuMeterLog> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_METER_LOG")
    @RegisterBeanMapper(FgActRuMeterLog.class)
    public List<FgActRuMeterLog> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_METER_LOG ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuMeterLog.class)
    public List<FgActRuMeterLog> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuMeterLog and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_METER_LOG SET NAME_ = :name, REPORTER_ = :reporter, VALUE_ = :value, TIMESTAMP_ = :timestamp, MILLISECONDS_ = :milliseconds WHERE ID_ = :id")
    public int update(@BindBean FgActRuMeterLog fgactrumeterlog);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_METER_LOG WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_METER_LOG")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuMeterLog entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_METER_LOG (ID_, NAME_, REPORTER_, VALUE_, TIMESTAMP_, MILLISECONDS_) VALUES (:id, :name, :reporter, :value, :timestamp, :milliseconds)")
    public int[] bulkInsert(@BindBean List<FgActRuMeterLog> fgactrumeterlogs);

    /**
     * Bulk update multiple FgActRuMeterLog entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_METER_LOG SET NAME_ = :name, REPORTER_ = :reporter, VALUE_ = :value, TIMESTAMP_ = :timestamp, MILLISECONDS_ = :milliseconds WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuMeterLog> fgactrumeterlogs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_METER_LOG WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_METER_LOG WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuMeterLog records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_METER_LOG WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuMeterLog.class)
    public List<FgActRuMeterLog> findByIds(@BindList("ids") Collection<String> ids);
}
