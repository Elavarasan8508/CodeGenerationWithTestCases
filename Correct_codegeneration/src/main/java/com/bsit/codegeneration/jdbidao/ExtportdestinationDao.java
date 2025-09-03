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
import com.bsit.codegeneration.entity.Extportdestination;

public interface ExtportdestinationDao {

    /**
     * Inserts a new Extportdestination and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO EXTPORTDESTINATION (PORT_OF_DEST, DESCRIPTION) VALUES (:portOfDest, :description)")
    public int insert(@Bind("portOfDest") String portOfDest, @Bind("description") String description);

    /**
     * Finds a Extportdestination by its ID.
     */
    @SqlQuery("SELECT * FROM EXTPORTDESTINATION WHERE EXTPORTDESTINATION_id = :id")
    @RegisterBeanMapper(Extportdestination.class)
    public Optional<Extportdestination> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM EXTPORTDESTINATION")
    @RegisterBeanMapper(Extportdestination.class)
    public List<Extportdestination> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM EXTPORTDESTINATION ORDER BY EXTPORTDESTINATION_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Extportdestination.class)
    public List<Extportdestination> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Extportdestination and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE EXTPORTDESTINATION SET PORT_OF_DEST = :portOfDest, DESCRIPTION = :description WHERE EXTPORTDESTINATION_id = :extportdestinationId")
    public int update(@BindBean Extportdestination extportdestination);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM EXTPORTDESTINATION WHERE EXTPORTDESTINATION_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM EXTPORTDESTINATION")
    public long countAll();

    /**
     * Bulk insert multiple Extportdestination entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO EXTPORTDESTINATION (PORT_OF_DEST, DESCRIPTION) VALUES (:portOfDest, :description)")
    public int[] bulkInsert(@BindBean List<Extportdestination> extportdestinations);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO EXTPORTDESTINATION (PORT_OF_DEST, DESCRIPTION) VALUES (:portOfDest, :description)")
    public int[] bulkInsertParams(@Bind("portOfDest") List<String> portOfDests, @Bind("description") List<String> descriptions);

    /**
     * Bulk update multiple Extportdestination entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE EXTPORTDESTINATION SET PORT_OF_DEST = :portOfDest, DESCRIPTION = :description WHERE EXTPORTDESTINATION_id = :extportdestinationId")
    public int[] bulkUpdate(@BindBean List<Extportdestination> extportdestinations);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE EXTPORTDESTINATION SET PORT_OF_DEST = :portOfDest, DESCRIPTION = :description WHERE EXTPORTDESTINATION_id = :extportdestinationId")
    public int[] bulkUpdateParams(@Bind("portOfDest") List<String> portOfDests, @Bind("description") List<String> descriptions, @Bind("extportdestinationId") List<Integer> extportdestinationIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM EXTPORTDESTINATION WHERE EXTPORTDESTINATION_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM EXTPORTDESTINATION WHERE EXTPORTDESTINATION_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Extportdestination records by their IDs.
     */
    @SqlQuery("SELECT * FROM EXTPORTDESTINATION WHERE EXTPORTDESTINATION_id IN (<ids>)")
    @RegisterBeanMapper(Extportdestination.class)
    public List<Extportdestination> findByIds(@BindList("ids") Collection<Integer> ids);
}
