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
import com.bsit.codegeneration.entity.D4pf;

public interface D4pfDao {

    /**
     * Inserts a new D4pf and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO D4PF (D4BRANCH, D4BRR, D4DFLG, D4DTEH, D4DTE, D4BRAR, D4DLM, MNT_IN_BO) VALUES (:d4branch, :d4brr, :d4dflg, :d4dteh, :d4dte, :d4brar, :d4dlm, :mntInBo)")
    public int insert(@BindBean D4pf d4pf);

    /**
     * Finds a D4pf by its ID.
     */
    @SqlQuery("SELECT * FROM D4PF WHERE D4BRANCH = :id")
    @RegisterBeanMapper(D4pf.class)
    public Optional<D4pf> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM D4PF")
    @RegisterBeanMapper(D4pf.class)
    public List<D4pf> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM D4PF ORDER BY D4BRANCH LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(D4pf.class)
    public List<D4pf> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a D4pf and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE D4PF SET D4DTE = :d4dte, D4BRAR = :d4brar, D4DLM = :d4dlm, MNT_IN_BO = :mntInBo WHERE D4BRANCH = :d4branch")
    public int update(@BindBean D4pf d4pf);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM D4PF WHERE D4BRANCH = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM D4PF")
    public long countAll();

    /**
     * Bulk insert multiple D4pf entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO D4PF (D4BRANCH, D4BRR, D4DFLG, D4DTEH, D4DTE, D4BRAR, D4DLM, MNT_IN_BO) VALUES (:d4branch, :d4brr, :d4dflg, :d4dteh, :d4dte, :d4brar, :d4dlm, :mntInBo)")
    public int[] bulkInsert(@BindBean List<D4pf> d4pfs);

    /**
     * Bulk update multiple D4pf entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE D4PF SET D4DTE = :d4dte, D4BRAR = :d4brar, D4DLM = :d4dlm, MNT_IN_BO = :mntInBo WHERE D4BRANCH = :d4branch")
    public int[] bulkUpdate(@BindBean List<D4pf> d4pfs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM D4PF WHERE D4BRANCH IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM D4PF WHERE D4BRANCH = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple D4pf records by their IDs.
     */
    @SqlQuery("SELECT * FROM D4PF WHERE D4BRANCH IN (<ids>)")
    @RegisterBeanMapper(D4pf.class)
    public List<D4pf> findByIds(@BindList("ids") Collection<String> ids);
}
