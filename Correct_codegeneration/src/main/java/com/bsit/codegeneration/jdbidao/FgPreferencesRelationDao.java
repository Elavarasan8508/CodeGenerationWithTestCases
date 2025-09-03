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
import com.bsit.codegeneration.entity.FgPreferencesRelation;

public interface FgPreferencesRelationDao {

    /**
     * Inserts a new FgPreferencesRelation and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PREFERENCES_RELATION (ID, PREF_CATEGORY_CODE, PREF_TYPE_CODE, PREF_CODE, SCOPE_CODE, SCOPE_VALUE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :prefCategoryCode, :prefTypeCode, :prefCode, :scopeCode, :scopeValue, :description, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int insert(@BindBean FgPreferencesRelation fgpreferencesrelation);

    /**
     * Finds a FgPreferencesRelation by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES_RELATION WHERE FG_PREFERENCES_RELATION_id = :id")
    @RegisterBeanMapper(FgPreferencesRelation.class)
    public Optional<FgPreferencesRelation> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES_RELATION")
    @RegisterBeanMapper(FgPreferencesRelation.class)
    public List<FgPreferencesRelation> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES_RELATION ORDER BY FG_PREFERENCES_RELATION_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPreferencesRelation.class)
    public List<FgPreferencesRelation> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPreferencesRelation and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PREFERENCES_RELATION SET ID = :id, PREF_CATEGORY_CODE = :prefCategoryCode, PREF_TYPE_CODE = :prefTypeCode, PREF_CODE = :prefCode, SCOPE_CODE = :scopeCode, SCOPE_VALUE = :scopeValue, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_PREFERENCES_RELATION_id = :fgPreferencesRelationId")
    public int update(@BindBean FgPreferencesRelation fgpreferencesrelation);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PREFERENCES_RELATION WHERE FG_PREFERENCES_RELATION_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PREFERENCES_RELATION")
    public long countAll();

    /**
     * Bulk insert multiple FgPreferencesRelation entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PREFERENCES_RELATION (ID, PREF_CATEGORY_CODE, PREF_TYPE_CODE, PREF_CODE, SCOPE_CODE, SCOPE_VALUE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :prefCategoryCode, :prefTypeCode, :prefCode, :scopeCode, :scopeValue, :description, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int[] bulkInsert(@BindBean List<FgPreferencesRelation> fgpreferencesrelations);

    /**
     * Bulk update multiple FgPreferencesRelation entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PREFERENCES_RELATION SET ID = :id, PREF_CATEGORY_CODE = :prefCategoryCode, PREF_TYPE_CODE = :prefTypeCode, PREF_CODE = :prefCode, SCOPE_CODE = :scopeCode, SCOPE_VALUE = :scopeValue, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_PREFERENCES_RELATION_id = :fgPreferencesRelationId")
    public int[] bulkUpdate(@BindBean List<FgPreferencesRelation> fgpreferencesrelations);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PREFERENCES_RELATION WHERE FG_PREFERENCES_RELATION_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PREFERENCES_RELATION WHERE FG_PREFERENCES_RELATION_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgPreferencesRelation records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES_RELATION WHERE FG_PREFERENCES_RELATION_id IN (<ids>)")
    @RegisterBeanMapper(FgPreferencesRelation.class)
    public List<FgPreferencesRelation> findByIds(@BindList("ids") Collection<Integer> ids);
}
