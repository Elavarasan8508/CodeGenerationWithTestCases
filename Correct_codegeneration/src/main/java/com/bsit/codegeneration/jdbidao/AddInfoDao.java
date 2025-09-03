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
import com.bsit.codegeneration.entity.AddInfo;

public interface AddInfoDao {

    /**
     * Inserts a new AddInfo and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO ADD_INFO (ID, ADDRESS, EMPLOYEE_ID) VALUES (:id, :address, :employeeId)")
    public int insert(@Bind("id") java.math.BigDecimal id, @Bind("address") String address, @Bind("employeeId") int employeeId);

    /**
     * Finds a AddInfo by its ID.
     */
    @SqlQuery("SELECT * FROM ADD_INFO WHERE ID = :id")
    @RegisterBeanMapper(AddInfo.class)
    public Optional<AddInfo> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM ADD_INFO")
    @RegisterBeanMapper(AddInfo.class)
    public List<AddInfo> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM ADD_INFO ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(AddInfo.class)
    public List<AddInfo> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a AddInfo and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE ADD_INFO SET ADDRESS = :address, EMPLOYEE_ID = :employeeId WHERE ID = :id")
    public int update(@BindBean AddInfo addinfo);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM ADD_INFO WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM ADD_INFO")
    public long countAll();

    /**
     * Bulk insert multiple AddInfo entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO ADD_INFO (ID, ADDRESS, EMPLOYEE_ID) VALUES (:id, :address, :employeeId)")
    public int[] bulkInsert(@BindBean List<AddInfo> addinfos);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO ADD_INFO (ID, ADDRESS, EMPLOYEE_ID) VALUES (:id, :address, :employeeId)")
    public int[] bulkInsertParams(@Bind("id") List<java.math.BigDecimal> ids, @Bind("address") List<String> addresss, @Bind("employeeId") List<Integer> employeeIds);

    /**
     * Bulk update multiple AddInfo entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE ADD_INFO SET ADDRESS = :address, EMPLOYEE_ID = :employeeId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<AddInfo> addinfos);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE ADD_INFO SET ADDRESS = :address, EMPLOYEE_ID = :employeeId WHERE ID = :id")
    public int[] bulkUpdateParams(@Bind("address") List<String> addresss, @Bind("employeeId") List<Integer> employeeIds, @Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM ADD_INFO WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM ADD_INFO WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple AddInfo records by their IDs.
     */
    @SqlQuery("SELECT * FROM ADD_INFO WHERE ID IN (<ids>)")
    @RegisterBeanMapper(AddInfo.class)
    public List<AddInfo> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all AddInfo records by employeeId.
     */
    @SqlQuery("SELECT * FROM ADD_INFO WHERE EMPLOYEE_ID = :employeeId")
    @RegisterBeanMapper(AddInfo.class)
    public List<AddInfo> findByEmployeeId(@Bind("employeeId") int employeeId);
}
