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
import com.bsit.codegeneration.entity.FgBusinessCodeTypeBkp;

public interface FgBusinessCodeTypeBkpDao {

    /**
     * Inserts a new FgBusinessCodeTypeBkp and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_BUSINESS_CODE_TYPE_BKP (ID, PARTY_ID, PARTY_VERSION_ID, CODE_TYPE, NAME, DESCRIPTION, ACTIVE_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TAGS) VALUES (:id, :partyId, :partyVersionId, :codeType, :name, :description, :activeCode, :lastAuthorisedOn, :lastAuthorisedBy, :tags)")
    public int insert(@BindBean FgBusinessCodeTypeBkp fgbusinesscodetypebkp);

    /**
     * Finds a FgBusinessCodeTypeBkp by its ID.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_TYPE_BKP WHERE FG_BUSINESS_CODE_TYPE_BKP_id = :id")
    @RegisterBeanMapper(FgBusinessCodeTypeBkp.class)
    public Optional<FgBusinessCodeTypeBkp> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_TYPE_BKP")
    @RegisterBeanMapper(FgBusinessCodeTypeBkp.class)
    public List<FgBusinessCodeTypeBkp> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_TYPE_BKP ORDER BY FG_BUSINESS_CODE_TYPE_BKP_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgBusinessCodeTypeBkp.class)
    public List<FgBusinessCodeTypeBkp> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgBusinessCodeTypeBkp and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_BUSINESS_CODE_TYPE_BKP SET ID = :id, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, CODE_TYPE = :codeType, NAME = :name, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TAGS = :tags WHERE FG_BUSINESS_CODE_TYPE_BKP_id = :fgBusinessCodeTypeBkpId")
    public int update(@BindBean FgBusinessCodeTypeBkp fgbusinesscodetypebkp);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_BUSINESS_CODE_TYPE_BKP WHERE FG_BUSINESS_CODE_TYPE_BKP_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_BUSINESS_CODE_TYPE_BKP")
    public long countAll();

    /**
     * Bulk insert multiple FgBusinessCodeTypeBkp entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_BUSINESS_CODE_TYPE_BKP (ID, PARTY_ID, PARTY_VERSION_ID, CODE_TYPE, NAME, DESCRIPTION, ACTIVE_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TAGS) VALUES (:id, :partyId, :partyVersionId, :codeType, :name, :description, :activeCode, :lastAuthorisedOn, :lastAuthorisedBy, :tags)")
    public int[] bulkInsert(@BindBean List<FgBusinessCodeTypeBkp> fgbusinesscodetypebkps);

    /**
     * Bulk update multiple FgBusinessCodeTypeBkp entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_BUSINESS_CODE_TYPE_BKP SET ID = :id, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, CODE_TYPE = :codeType, NAME = :name, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TAGS = :tags WHERE FG_BUSINESS_CODE_TYPE_BKP_id = :fgBusinessCodeTypeBkpId")
    public int[] bulkUpdate(@BindBean List<FgBusinessCodeTypeBkp> fgbusinesscodetypebkps);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_BUSINESS_CODE_TYPE_BKP WHERE FG_BUSINESS_CODE_TYPE_BKP_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_BUSINESS_CODE_TYPE_BKP WHERE FG_BUSINESS_CODE_TYPE_BKP_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgBusinessCodeTypeBkp records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_TYPE_BKP WHERE FG_BUSINESS_CODE_TYPE_BKP_id IN (<ids>)")
    @RegisterBeanMapper(FgBusinessCodeTypeBkp.class)
    public List<FgBusinessCodeTypeBkp> findByIds(@BindList("ids") Collection<Integer> ids);
}
