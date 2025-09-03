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
import com.bsit.codegeneration.entity.FgModBiDashboardRepos;

public interface FgModBiDashboardReposDao {

    /**
     * Inserts a new FgModBiDashboardRepos and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_BI_DASHBOARD_REPOS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, VERSION_ID, BOARD_ID, BOARD_NAME, CATEGORY_NAME, PARTY_TYPE, PARTY_CODE, PARTY_USER_TYPE, PARTY_USER_CODE, IS_MASTER_VERSION, LAYOUT_JSON, COMPANY_ID, USER_ID, IS_DEFAULT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn, :versionId, :boardId, :boardName, :categoryName, :partyType, :partyCode, :partyUserType, :partyUserCode, :isMasterVersion, :layoutJson, :companyId, :userId, :isDefault)")
    public int insert(@BindBean FgModBiDashboardRepos fgmodbidashboardrepos);

    /**
     * Finds a FgModBiDashboardRepos by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BI_DASHBOARD_REPOS WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgModBiDashboardRepos.class)
    public Optional<FgModBiDashboardRepos> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BI_DASHBOARD_REPOS")
    @RegisterBeanMapper(FgModBiDashboardRepos.class)
    public List<FgModBiDashboardRepos> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BI_DASHBOARD_REPOS ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModBiDashboardRepos.class)
    public List<FgModBiDashboardRepos> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModBiDashboardRepos and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_BI_DASHBOARD_REPOS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, BOARD_ID = :boardId, BOARD_NAME = :boardName, CATEGORY_NAME = :categoryName, PARTY_TYPE = :partyType, PARTY_USER_TYPE = :partyUserType, IS_MASTER_VERSION = :isMasterVersion, LAYOUT_JSON = :layoutJson, COMPANY_ID = :companyId, USER_ID = :userId, IS_DEFAULT = :isDefault WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgModBiDashboardRepos fgmodbidashboardrepos);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_BI_DASHBOARD_REPOS WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_BI_DASHBOARD_REPOS")
    public long countAll();

    /**
     * Bulk insert multiple FgModBiDashboardRepos entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_BI_DASHBOARD_REPOS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, VERSION_ID, BOARD_ID, BOARD_NAME, CATEGORY_NAME, PARTY_TYPE, PARTY_CODE, PARTY_USER_TYPE, PARTY_USER_CODE, IS_MASTER_VERSION, LAYOUT_JSON, COMPANY_ID, USER_ID, IS_DEFAULT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn, :versionId, :boardId, :boardName, :categoryName, :partyType, :partyCode, :partyUserType, :partyUserCode, :isMasterVersion, :layoutJson, :companyId, :userId, :isDefault)")
    public int[] bulkInsert(@BindBean List<FgModBiDashboardRepos> fgmodbidashboardreposs);

    /**
     * Bulk update multiple FgModBiDashboardRepos entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_BI_DASHBOARD_REPOS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, BOARD_ID = :boardId, BOARD_NAME = :boardName, CATEGORY_NAME = :categoryName, PARTY_TYPE = :partyType, PARTY_USER_TYPE = :partyUserType, IS_MASTER_VERSION = :isMasterVersion, LAYOUT_JSON = :layoutJson, COMPANY_ID = :companyId, USER_ID = :userId, IS_DEFAULT = :isDefault WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgModBiDashboardRepos> fgmodbidashboardreposs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_BI_DASHBOARD_REPOS WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_BI_DASHBOARD_REPOS WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgModBiDashboardRepos records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BI_DASHBOARD_REPOS WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgModBiDashboardRepos.class)
    public List<FgModBiDashboardRepos> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
