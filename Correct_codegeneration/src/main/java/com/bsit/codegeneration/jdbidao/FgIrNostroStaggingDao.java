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
import com.bsit.codegeneration.entity.FgIrNostroStagging;

public interface FgIrNostroStaggingDao {

    /**
     * Inserts a new FgIrNostroStagging and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_IR_NOSTRO_STAGGING (ID, NOSTRO_NUMBER, NOSTRO_XML, INSERTED_ON, STATUS, NODE) VALUES (:id, :nostroNumber, :nostroXml, :insertedOn, :status, :node)")
    public int insert(@BindBean FgIrNostroStagging fgirnostrostagging);

    /**
     * Finds a FgIrNostroStagging by its ID.
     */
    @SqlQuery("SELECT * FROM FG_IR_NOSTRO_STAGGING WHERE FG_IR_NOSTRO_STAGGING_id = :id")
    @RegisterBeanMapper(FgIrNostroStagging.class)
    public Optional<FgIrNostroStagging> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_IR_NOSTRO_STAGGING")
    @RegisterBeanMapper(FgIrNostroStagging.class)
    public List<FgIrNostroStagging> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_IR_NOSTRO_STAGGING ORDER BY FG_IR_NOSTRO_STAGGING_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgIrNostroStagging.class)
    public List<FgIrNostroStagging> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgIrNostroStagging and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_IR_NOSTRO_STAGGING SET ID = :id, NOSTRO_NUMBER = :nostroNumber, NOSTRO_XML = :nostroXml, INSERTED_ON = :insertedOn, STATUS = :status, NODE = :node WHERE FG_IR_NOSTRO_STAGGING_id = :fgIrNostroStaggingId")
    public int update(@BindBean FgIrNostroStagging fgirnostrostagging);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_IR_NOSTRO_STAGGING WHERE FG_IR_NOSTRO_STAGGING_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_IR_NOSTRO_STAGGING")
    public long countAll();

    /**
     * Bulk insert multiple FgIrNostroStagging entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_IR_NOSTRO_STAGGING (ID, NOSTRO_NUMBER, NOSTRO_XML, INSERTED_ON, STATUS, NODE) VALUES (:id, :nostroNumber, :nostroXml, :insertedOn, :status, :node)")
    public int[] bulkInsert(@BindBean List<FgIrNostroStagging> fgirnostrostaggings);

    /**
     * Bulk update multiple FgIrNostroStagging entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_IR_NOSTRO_STAGGING SET ID = :id, NOSTRO_NUMBER = :nostroNumber, NOSTRO_XML = :nostroXml, INSERTED_ON = :insertedOn, STATUS = :status, NODE = :node WHERE FG_IR_NOSTRO_STAGGING_id = :fgIrNostroStaggingId")
    public int[] bulkUpdate(@BindBean List<FgIrNostroStagging> fgirnostrostaggings);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_IR_NOSTRO_STAGGING WHERE FG_IR_NOSTRO_STAGGING_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_IR_NOSTRO_STAGGING WHERE FG_IR_NOSTRO_STAGGING_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgIrNostroStagging records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_IR_NOSTRO_STAGGING WHERE FG_IR_NOSTRO_STAGGING_id IN (<ids>)")
    @RegisterBeanMapper(FgIrNostroStagging.class)
    public List<FgIrNostroStagging> findByIds(@BindList("ids") Collection<Integer> ids);
}
