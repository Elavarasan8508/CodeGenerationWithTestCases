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
import com.bsit.codegeneration.entity.FgPreferencesMaster;

public interface FgPreferencesMasterDao {

    /**
     * Inserts a new FgPreferencesMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PREFERENCES_MASTER (ID, CATEGORY_CODE, TYPE_CODE, CODE, NAME, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :categoryCode, :typeCode, :code, :name, :description, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int insert(@BindBean FgPreferencesMaster fgpreferencesmaster);

    /**
     * Finds a FgPreferencesMaster by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES_MASTER WHERE FG_PREFERENCES_MASTER_id = :id")
    @RegisterBeanMapper(FgPreferencesMaster.class)
    public Optional<FgPreferencesMaster> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES_MASTER")
    @RegisterBeanMapper(FgPreferencesMaster.class)
    public List<FgPreferencesMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES_MASTER ORDER BY FG_PREFERENCES_MASTER_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPreferencesMaster.class)
    public List<FgPreferencesMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPreferencesMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PREFERENCES_MASTER SET ID = :id, CATEGORY_CODE = :categoryCode, TYPE_CODE = :typeCode, CODE = :code, NAME = :name, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_PREFERENCES_MASTER_id = :fgPreferencesMasterId")
    public int update(@BindBean FgPreferencesMaster fgpreferencesmaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PREFERENCES_MASTER WHERE FG_PREFERENCES_MASTER_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PREFERENCES_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple FgPreferencesMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PREFERENCES_MASTER (ID, CATEGORY_CODE, TYPE_CODE, CODE, NAME, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :categoryCode, :typeCode, :code, :name, :description, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int[] bulkInsert(@BindBean List<FgPreferencesMaster> fgpreferencesmasters);

    /**
     * Bulk update multiple FgPreferencesMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PREFERENCES_MASTER SET ID = :id, CATEGORY_CODE = :categoryCode, TYPE_CODE = :typeCode, CODE = :code, NAME = :name, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_PREFERENCES_MASTER_id = :fgPreferencesMasterId")
    public int[] bulkUpdate(@BindBean List<FgPreferencesMaster> fgpreferencesmasters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PREFERENCES_MASTER WHERE FG_PREFERENCES_MASTER_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PREFERENCES_MASTER WHERE FG_PREFERENCES_MASTER_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgPreferencesMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES_MASTER WHERE FG_PREFERENCES_MASTER_id IN (<ids>)")
    @RegisterBeanMapper(FgPreferencesMaster.class)
    public List<FgPreferencesMaster> findByIds(@BindList("ids") Collection<Integer> ids);
}
