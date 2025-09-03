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
import com.bsit.codegeneration.entity.Ivs;

public interface IvsDao {

    /**
     * Inserts a new Ivs and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO IVS (ID, SCHEMECODE, DEBITINTEREST) VALUES (:id, :schemecode, :debitinterest)")
    public int insert(@Bind("id") String id, @Bind("schemecode") String schemecode, @Bind("debitinterest") java.math.BigDecimal debitinterest);

    /**
     * Finds a Ivs by its ID.
     */
    @SqlQuery("SELECT * FROM IVS WHERE IVS_id = :id")
    @RegisterBeanMapper(Ivs.class)
    public Optional<Ivs> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM IVS")
    @RegisterBeanMapper(Ivs.class)
    public List<Ivs> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM IVS ORDER BY IVS_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Ivs.class)
    public List<Ivs> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Ivs and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE IVS SET ID = :id, SCHEMECODE = :schemecode, DEBITINTEREST = :debitinterest WHERE IVS_id = :ivsId")
    public int update(@BindBean Ivs ivs);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM IVS WHERE IVS_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM IVS")
    public long countAll();

    /**
     * Bulk insert multiple Ivs entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO IVS (ID, SCHEMECODE, DEBITINTEREST) VALUES (:id, :schemecode, :debitinterest)")
    public int[] bulkInsert(@BindBean List<Ivs> ivss);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO IVS (ID, SCHEMECODE, DEBITINTEREST) VALUES (:id, :schemecode, :debitinterest)")
    public int[] bulkInsertParams(@Bind("id") List<String> ids, @Bind("schemecode") List<String> schemecodes, @Bind("debitinterest") List<java.math.BigDecimal> debitinterests);

    /**
     * Bulk update multiple Ivs entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE IVS SET ID = :id, SCHEMECODE = :schemecode, DEBITINTEREST = :debitinterest WHERE IVS_id = :ivsId")
    public int[] bulkUpdate(@BindBean List<Ivs> ivss);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE IVS SET ID = :id, SCHEMECODE = :schemecode, DEBITINTEREST = :debitinterest WHERE IVS_id = :ivsId")
    public int[] bulkUpdateParams(@Bind("id") List<String> ids, @Bind("schemecode") List<String> schemecodes, @Bind("debitinterest") List<java.math.BigDecimal> debitinterests, @Bind("ivsId") List<Integer> ivsIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM IVS WHERE IVS_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM IVS WHERE IVS_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Ivs records by their IDs.
     */
    @SqlQuery("SELECT * FROM IVS WHERE IVS_id IN (<ids>)")
    @RegisterBeanMapper(Ivs.class)
    public List<Ivs> findByIds(@BindList("ids") Collection<Integer> ids);
}
