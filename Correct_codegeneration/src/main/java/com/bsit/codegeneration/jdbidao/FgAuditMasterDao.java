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
import com.bsit.codegeneration.entity.FgAuditMaster;

public interface FgAuditMasterDao {

    /**
     * Inserts a new FgAuditMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_AUDIT_MASTER (UUID, PARTY_CODE, USER_CODE, CATEGORY_CODE, TYPE_CODE, SOURCE, ENDPOINT_CODE, ENTITY_CODE, EVENT_CODE, SERVERITY_CODE, STATUS_CODE, OCCURED_ON, SESSION_ID, SESSION_ADDRESS, ENTITY_REF_ID, REL_ORG_CODE, REL_ORG_SUB_TYPE_CODE, REL_ORG_TYPE_CODE, REL_ORG_PARENT_CODE, TOKEN_VALUE, ENDS_ON) VALUES (:uuid, :partyCode, :userCode, :categoryCode, :typeCode, :source, :endpointCode, :entityCode, :eventCode, :serverityCode, :statusCode, :occuredOn, :sessionId, :sessionAddress, :entityRefId, :relOrgCode, :relOrgSubTypeCode, :relOrgTypeCode, :relOrgParentCode, :tokenValue, :endsOn)")
    public int insert(@BindBean FgAuditMaster fgauditmaster);

    /**
     * Finds a FgAuditMaster by its ID.
     */
    @SqlQuery("SELECT * FROM FG_AUDIT_MASTER WHERE UUID = :id")
    @RegisterBeanMapper(FgAuditMaster.class)
    public Optional<FgAuditMaster> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_AUDIT_MASTER")
    @RegisterBeanMapper(FgAuditMaster.class)
    public List<FgAuditMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_AUDIT_MASTER ORDER BY UUID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAuditMaster.class)
    public List<FgAuditMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAuditMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_AUDIT_MASTER SET PARTY_CODE = :partyCode, USER_CODE = :userCode, CATEGORY_CODE = :categoryCode, TYPE_CODE = :typeCode, SOURCE = :source, ENDPOINT_CODE = :endpointCode, ENTITY_CODE = :entityCode, EVENT_CODE = :eventCode, SERVERITY_CODE = :serverityCode, STATUS_CODE = :statusCode, OCCURED_ON = :occuredOn, SESSION_ID = :sessionId, SESSION_ADDRESS = :sessionAddress, ENTITY_REF_ID = :entityRefId, REL_ORG_CODE = :relOrgCode, REL_ORG_SUB_TYPE_CODE = :relOrgSubTypeCode, REL_ORG_TYPE_CODE = :relOrgTypeCode, REL_ORG_PARENT_CODE = :relOrgParentCode, TOKEN_VALUE = :tokenValue, ENDS_ON = :endsOn WHERE UUID = :uuid")
    public int update(@BindBean FgAuditMaster fgauditmaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AUDIT_MASTER WHERE UUID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_AUDIT_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple FgAuditMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_AUDIT_MASTER (UUID, PARTY_CODE, USER_CODE, CATEGORY_CODE, TYPE_CODE, SOURCE, ENDPOINT_CODE, ENTITY_CODE, EVENT_CODE, SERVERITY_CODE, STATUS_CODE, OCCURED_ON, SESSION_ID, SESSION_ADDRESS, ENTITY_REF_ID, REL_ORG_CODE, REL_ORG_SUB_TYPE_CODE, REL_ORG_TYPE_CODE, REL_ORG_PARENT_CODE, TOKEN_VALUE, ENDS_ON) VALUES (:uuid, :partyCode, :userCode, :categoryCode, :typeCode, :source, :endpointCode, :entityCode, :eventCode, :serverityCode, :statusCode, :occuredOn, :sessionId, :sessionAddress, :entityRefId, :relOrgCode, :relOrgSubTypeCode, :relOrgTypeCode, :relOrgParentCode, :tokenValue, :endsOn)")
    public int[] bulkInsert(@BindBean List<FgAuditMaster> fgauditmasters);

    /**
     * Bulk update multiple FgAuditMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_AUDIT_MASTER SET PARTY_CODE = :partyCode, USER_CODE = :userCode, CATEGORY_CODE = :categoryCode, TYPE_CODE = :typeCode, SOURCE = :source, ENDPOINT_CODE = :endpointCode, ENTITY_CODE = :entityCode, EVENT_CODE = :eventCode, SERVERITY_CODE = :serverityCode, STATUS_CODE = :statusCode, OCCURED_ON = :occuredOn, SESSION_ID = :sessionId, SESSION_ADDRESS = :sessionAddress, ENTITY_REF_ID = :entityRefId, REL_ORG_CODE = :relOrgCode, REL_ORG_SUB_TYPE_CODE = :relOrgSubTypeCode, REL_ORG_TYPE_CODE = :relOrgTypeCode, REL_ORG_PARENT_CODE = :relOrgParentCode, TOKEN_VALUE = :tokenValue, ENDS_ON = :endsOn WHERE UUID = :uuid")
    public int[] bulkUpdate(@BindBean List<FgAuditMaster> fgauditmasters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AUDIT_MASTER WHERE UUID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_AUDIT_MASTER WHERE UUID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgAuditMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_AUDIT_MASTER WHERE UUID IN (<ids>)")
    @RegisterBeanMapper(FgAuditMaster.class)
    public List<FgAuditMaster> findByIds(@BindList("ids") Collection<String> ids);
}
