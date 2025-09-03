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
import com.bsit.codegeneration.entity.FgRole;

public interface FgRoleDao {

    /**
     * Inserts a new FgRole and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ROLE (ID, VERSION_ID, IS_MASTER_VERSION, CODE, NAME, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TYPE_CODE, SUB_TYPE_CODE, TYPE) VALUES (:id, :versionId, :isMasterVersion, :code, :name, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :typeCode, :subTypeCode, :type)")
    public int insert(@BindBean FgRole fgrole);

    /**
     * Finds a FgRole by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ROLE WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgRole.class)
    public Optional<FgRole> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ROLE")
    @RegisterBeanMapper(FgRole.class)
    public List<FgRole> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ROLE ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgRole.class)
    public List<FgRole> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgRole and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ROLE SET IS_MASTER_VERSION = :isMasterVersion, CODE = :code, NAME = :name, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, TYPE = :type WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgRole fgrole);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ROLE WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ROLE")
    public long countAll();

    /**
     * Bulk insert multiple FgRole entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ROLE (ID, VERSION_ID, IS_MASTER_VERSION, CODE, NAME, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TYPE_CODE, SUB_TYPE_CODE, TYPE) VALUES (:id, :versionId, :isMasterVersion, :code, :name, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :typeCode, :subTypeCode, :type)")
    public int[] bulkInsert(@BindBean List<FgRole> fgroles);

    /**
     * Bulk update multiple FgRole entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ROLE SET IS_MASTER_VERSION = :isMasterVersion, CODE = :code, NAME = :name, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, TYPE = :type WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgRole> fgroles);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ROLE WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ROLE WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgRole records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ROLE WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgRole.class)
    public List<FgRole> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
