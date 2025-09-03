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
import com.bsit.codegeneration.entity.EmpInfo;

public interface EmpInfoDao {

    /**
     * Inserts a new EmpInfo and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO EMP_INFO (ID, NAME) VALUES (:id, :name)")
    public int insert(@Bind("id") java.math.BigDecimal id, @Bind("name") String name);

    /**
     * Finds a EmpInfo by its ID.
     */
    @SqlQuery("SELECT * FROM EMP_INFO WHERE ID = :id")
    @RegisterBeanMapper(EmpInfo.class)
    public Optional<EmpInfo> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM EMP_INFO")
    @RegisterBeanMapper(EmpInfo.class)
    public List<EmpInfo> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM EMP_INFO ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(EmpInfo.class)
    public List<EmpInfo> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a EmpInfo and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE EMP_INFO SET NAME = :name WHERE ID = :id")
    public int update(@BindBean EmpInfo empinfo);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM EMP_INFO WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM EMP_INFO")
    public long countAll();

    /**
     * Bulk insert multiple EmpInfo entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO EMP_INFO (ID, NAME) VALUES (:id, :name)")
    public int[] bulkInsert(@BindBean List<EmpInfo> empinfos);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO EMP_INFO (ID, NAME) VALUES (:id, :name)")
    public int[] bulkInsertParams(@Bind("id") List<java.math.BigDecimal> ids, @Bind("name") List<String> names);

    /**
     * Bulk update multiple EmpInfo entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE EMP_INFO SET NAME = :name WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<EmpInfo> empinfos);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE EMP_INFO SET NAME = :name WHERE ID = :id")
    public int[] bulkUpdateParams(@Bind("name") List<String> names, @Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM EMP_INFO WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM EMP_INFO WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple EmpInfo records by their IDs.
     */
    @SqlQuery("SELECT * FROM EMP_INFO WHERE ID IN (<ids>)")
    @RegisterBeanMapper(EmpInfo.class)
    public List<EmpInfo> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
