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
import com.bsit.codegeneration.entity.FgModCmsPtyRole;

public interface FgModCmsPtyRoleDao {

    /**
     * Inserts a new FgModCmsPtyRole and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_CMS_PTY_ROLE (ID, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, PARTY_REF_NO, PARTY_VERSION_ID, PARTY_ROLE, SPACE_REF_NO, SPACE_VERSION_ID, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :partyTypeCode, :partySubTypeCode, :partyRefNo, :partyVersionId, :partyRole, :spaceRefNo, :spaceVersionId, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int insert(@BindBean FgModCmsPtyRole fgmodcmsptyrole);

    /**
     * Finds a FgModCmsPtyRole by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_PTY_ROLE WHERE FG_MOD_CMS_PTY_ROLE_id = :id")
    @RegisterBeanMapper(FgModCmsPtyRole.class)
    public Optional<FgModCmsPtyRole> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_PTY_ROLE")
    @RegisterBeanMapper(FgModCmsPtyRole.class)
    public List<FgModCmsPtyRole> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_PTY_ROLE ORDER BY FG_MOD_CMS_PTY_ROLE_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModCmsPtyRole.class)
    public List<FgModCmsPtyRole> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModCmsPtyRole and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_CMS_PTY_ROLE SET ID = :id, PARTY_TYPE_CODE = :partyTypeCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PARTY_REF_NO = :partyRefNo, PARTY_VERSION_ID = :partyVersionId, PARTY_ROLE = :partyRole, SPACE_REF_NO = :spaceRefNo, SPACE_VERSION_ID = :spaceVersionId, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_MOD_CMS_PTY_ROLE_id = :fgModCmsPtyRoleId")
    public int update(@BindBean FgModCmsPtyRole fgmodcmsptyrole);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CMS_PTY_ROLE WHERE FG_MOD_CMS_PTY_ROLE_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_CMS_PTY_ROLE")
    public long countAll();

    /**
     * Bulk insert multiple FgModCmsPtyRole entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_CMS_PTY_ROLE (ID, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, PARTY_REF_NO, PARTY_VERSION_ID, PARTY_ROLE, SPACE_REF_NO, SPACE_VERSION_ID, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :partyTypeCode, :partySubTypeCode, :partyRefNo, :partyVersionId, :partyRole, :spaceRefNo, :spaceVersionId, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int[] bulkInsert(@BindBean List<FgModCmsPtyRole> fgmodcmsptyroles);

    /**
     * Bulk update multiple FgModCmsPtyRole entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_CMS_PTY_ROLE SET ID = :id, PARTY_TYPE_CODE = :partyTypeCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PARTY_REF_NO = :partyRefNo, PARTY_VERSION_ID = :partyVersionId, PARTY_ROLE = :partyRole, SPACE_REF_NO = :spaceRefNo, SPACE_VERSION_ID = :spaceVersionId, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_MOD_CMS_PTY_ROLE_id = :fgModCmsPtyRoleId")
    public int[] bulkUpdate(@BindBean List<FgModCmsPtyRole> fgmodcmsptyroles);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CMS_PTY_ROLE WHERE FG_MOD_CMS_PTY_ROLE_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_CMS_PTY_ROLE WHERE FG_MOD_CMS_PTY_ROLE_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgModCmsPtyRole records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_PTY_ROLE WHERE FG_MOD_CMS_PTY_ROLE_id IN (<ids>)")
    @RegisterBeanMapper(FgModCmsPtyRole.class)
    public List<FgModCmsPtyRole> findByIds(@BindList("ids") Collection<Integer> ids);
}
