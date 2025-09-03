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
import com.bsit.codegeneration.entity.FgProductRole;

public interface FgProductRoleDao {

    /**
     * Inserts a new FgProductRole and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PRODUCT_ROLE (ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, PARTY_ROLE_CODE, ENTITY_REF_ID, ENTITY_VERSION_NO, PARTY_CODE, VALID_FROM, VALID_TO, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UPLOAD_REF_ID, ID) VALUES (:entityTypeCode, :entitySubTypeCode, :partyTypeCode, :partySubTypeCode, :partyRoleCode, :entityRefId, :entityVersionNo, :partyCode, :validFrom, :validTo, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :uploadRefId, :id)")
    public int insert(@BindBean FgProductRole fgproductrole);

    /**
     * Finds a FgProductRole by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_ROLE WHERE FG_PRODUCT_ROLE_id = :id")
    @RegisterBeanMapper(FgProductRole.class)
    public Optional<FgProductRole> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_ROLE")
    @RegisterBeanMapper(FgProductRole.class)
    public List<FgProductRole> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_ROLE ORDER BY FG_PRODUCT_ROLE_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProductRole.class)
    public List<FgProductRole> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProductRole and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PRODUCT_ROLE SET ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, PARTY_TYPE_CODE = :partyTypeCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PARTY_ROLE_CODE = :partyRoleCode, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_NO = :entityVersionNo, PARTY_CODE = :partyCode, VALID_FROM = :validFrom, VALID_TO = :validTo, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, UPLOAD_REF_ID = :uploadRefId, ID = :id WHERE FG_PRODUCT_ROLE_id = :fgProductRoleId")
    public int update(@BindBean FgProductRole fgproductrole);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_ROLE WHERE FG_PRODUCT_ROLE_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PRODUCT_ROLE")
    public long countAll();

    /**
     * Bulk insert multiple FgProductRole entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PRODUCT_ROLE (ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, PARTY_ROLE_CODE, ENTITY_REF_ID, ENTITY_VERSION_NO, PARTY_CODE, VALID_FROM, VALID_TO, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UPLOAD_REF_ID, ID) VALUES (:entityTypeCode, :entitySubTypeCode, :partyTypeCode, :partySubTypeCode, :partyRoleCode, :entityRefId, :entityVersionNo, :partyCode, :validFrom, :validTo, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :uploadRefId, :id)")
    public int[] bulkInsert(@BindBean List<FgProductRole> fgproductroles);

    /**
     * Bulk update multiple FgProductRole entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PRODUCT_ROLE SET ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, PARTY_TYPE_CODE = :partyTypeCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PARTY_ROLE_CODE = :partyRoleCode, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_NO = :entityVersionNo, PARTY_CODE = :partyCode, VALID_FROM = :validFrom, VALID_TO = :validTo, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, UPLOAD_REF_ID = :uploadRefId, ID = :id WHERE FG_PRODUCT_ROLE_id = :fgProductRoleId")
    public int[] bulkUpdate(@BindBean List<FgProductRole> fgproductroles);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_ROLE WHERE FG_PRODUCT_ROLE_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PRODUCT_ROLE WHERE FG_PRODUCT_ROLE_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgProductRole records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_ROLE WHERE FG_PRODUCT_ROLE_id IN (<ids>)")
    @RegisterBeanMapper(FgProductRole.class)
    public List<FgProductRole> findByIds(@BindList("ids") Collection<Integer> ids);
}
