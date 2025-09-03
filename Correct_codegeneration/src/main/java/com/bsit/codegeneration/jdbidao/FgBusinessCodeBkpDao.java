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
import com.bsit.codegeneration.entity.FgBusinessCodeBkp;

public interface FgBusinessCodeBkpDao {

    /**
     * Inserts a new FgBusinessCodeBkp and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_BUSINESS_CODE_BKP (ID, NAME, CODE_TYPE, CODE_VALUE, PARENT_CODE, PARTY_ID, PARTY_VERSION_ID, PARENT_TYPE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_REF_ID, TAGS) VALUES (:id, :name, :codeType, :codeValue, :parentCode, :partyId, :partyVersionId, :parentType, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :parentRefId, :tags)")
    public int insert(@BindBean FgBusinessCodeBkp fgbusinesscodebkp);

    /**
     * Finds a FgBusinessCodeBkp by its ID.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_BKP WHERE FG_BUSINESS_CODE_BKP_id = :id")
    @RegisterBeanMapper(FgBusinessCodeBkp.class)
    public Optional<FgBusinessCodeBkp> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_BKP")
    @RegisterBeanMapper(FgBusinessCodeBkp.class)
    public List<FgBusinessCodeBkp> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_BKP ORDER BY FG_BUSINESS_CODE_BKP_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgBusinessCodeBkp.class)
    public List<FgBusinessCodeBkp> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgBusinessCodeBkp and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_BUSINESS_CODE_BKP SET ID = :id, NAME = :name, CODE_TYPE = :codeType, CODE_VALUE = :codeValue, PARENT_CODE = :parentCode, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, PARENT_TYPE = :parentType, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, PARENT_REF_ID = :parentRefId, TAGS = :tags WHERE FG_BUSINESS_CODE_BKP_id = :fgBusinessCodeBkpId")
    public int update(@BindBean FgBusinessCodeBkp fgbusinesscodebkp);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_BUSINESS_CODE_BKP WHERE FG_BUSINESS_CODE_BKP_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_BUSINESS_CODE_BKP")
    public long countAll();

    /**
     * Bulk insert multiple FgBusinessCodeBkp entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_BUSINESS_CODE_BKP (ID, NAME, CODE_TYPE, CODE_VALUE, PARENT_CODE, PARTY_ID, PARTY_VERSION_ID, PARENT_TYPE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_REF_ID, TAGS) VALUES (:id, :name, :codeType, :codeValue, :parentCode, :partyId, :partyVersionId, :parentType, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :parentRefId, :tags)")
    public int[] bulkInsert(@BindBean List<FgBusinessCodeBkp> fgbusinesscodebkps);

    /**
     * Bulk update multiple FgBusinessCodeBkp entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_BUSINESS_CODE_BKP SET ID = :id, NAME = :name, CODE_TYPE = :codeType, CODE_VALUE = :codeValue, PARENT_CODE = :parentCode, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, PARENT_TYPE = :parentType, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, PARENT_REF_ID = :parentRefId, TAGS = :tags WHERE FG_BUSINESS_CODE_BKP_id = :fgBusinessCodeBkpId")
    public int[] bulkUpdate(@BindBean List<FgBusinessCodeBkp> fgbusinesscodebkps);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_BUSINESS_CODE_BKP WHERE FG_BUSINESS_CODE_BKP_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_BUSINESS_CODE_BKP WHERE FG_BUSINESS_CODE_BKP_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgBusinessCodeBkp records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_BKP WHERE FG_BUSINESS_CODE_BKP_id IN (<ids>)")
    @RegisterBeanMapper(FgBusinessCodeBkp.class)
    public List<FgBusinessCodeBkp> findByIds(@BindList("ids") Collection<Integer> ids);
}
