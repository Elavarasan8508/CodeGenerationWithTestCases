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
import com.bsit.codegeneration.entity.FgPreferences;

public interface FgPreferencesDao {

    /**
     * Inserts a new FgPreferences and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PREFERENCES (ID, VERSION_ID, TYPE_CODE, SUB_TYPE_CODE, PREF_CATEGORY_CODE, PREF_TYPE_CODE, PREF_CODE, ORG_PARTY_CODE, ORG_PARTY_SUB_TYPE_CODE, USER_PARTY_CODE, USER_PARTY_SUB_TYPE_CODE, NAME, DESCRIPTION, TEMPLATE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :versionId, :typeCode, :subTypeCode, :prefCategoryCode, :prefTypeCode, :prefCode, :orgPartyCode, :orgPartySubTypeCode, :userPartyCode, :userPartySubTypeCode, :name, :description, :template, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int insert(@BindBean FgPreferences fgpreferences);

    /**
     * Finds a FgPreferences by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES WHERE FG_PREFERENCES_id = :id")
    @RegisterBeanMapper(FgPreferences.class)
    public Optional<FgPreferences> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES")
    @RegisterBeanMapper(FgPreferences.class)
    public List<FgPreferences> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES ORDER BY FG_PREFERENCES_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPreferences.class)
    public List<FgPreferences> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPreferences and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PREFERENCES SET ID = :id, VERSION_ID = :versionId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PREF_CATEGORY_CODE = :prefCategoryCode, PREF_TYPE_CODE = :prefTypeCode, PREF_CODE = :prefCode, ORG_PARTY_CODE = :orgPartyCode, ORG_PARTY_SUB_TYPE_CODE = :orgPartySubTypeCode, USER_PARTY_CODE = :userPartyCode, USER_PARTY_SUB_TYPE_CODE = :userPartySubTypeCode, NAME = :name, DESCRIPTION = :description, TEMPLATE = :template, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_PREFERENCES_id = :fgPreferencesId")
    public int update(@BindBean FgPreferences fgpreferences);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PREFERENCES WHERE FG_PREFERENCES_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PREFERENCES")
    public long countAll();

    /**
     * Bulk insert multiple FgPreferences entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PREFERENCES (ID, VERSION_ID, TYPE_CODE, SUB_TYPE_CODE, PREF_CATEGORY_CODE, PREF_TYPE_CODE, PREF_CODE, ORG_PARTY_CODE, ORG_PARTY_SUB_TYPE_CODE, USER_PARTY_CODE, USER_PARTY_SUB_TYPE_CODE, NAME, DESCRIPTION, TEMPLATE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :versionId, :typeCode, :subTypeCode, :prefCategoryCode, :prefTypeCode, :prefCode, :orgPartyCode, :orgPartySubTypeCode, :userPartyCode, :userPartySubTypeCode, :name, :description, :template, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int[] bulkInsert(@BindBean List<FgPreferences> fgpreferencess);

    /**
     * Bulk update multiple FgPreferences entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PREFERENCES SET ID = :id, VERSION_ID = :versionId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PREF_CATEGORY_CODE = :prefCategoryCode, PREF_TYPE_CODE = :prefTypeCode, PREF_CODE = :prefCode, ORG_PARTY_CODE = :orgPartyCode, ORG_PARTY_SUB_TYPE_CODE = :orgPartySubTypeCode, USER_PARTY_CODE = :userPartyCode, USER_PARTY_SUB_TYPE_CODE = :userPartySubTypeCode, NAME = :name, DESCRIPTION = :description, TEMPLATE = :template, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_PREFERENCES_id = :fgPreferencesId")
    public int[] bulkUpdate(@BindBean List<FgPreferences> fgpreferencess);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PREFERENCES WHERE FG_PREFERENCES_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PREFERENCES WHERE FG_PREFERENCES_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgPreferences records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PREFERENCES WHERE FG_PREFERENCES_id IN (<ids>)")
    @RegisterBeanMapper(FgPreferences.class)
    public List<FgPreferences> findByIds(@BindList("ids") Collection<Integer> ids);
}
