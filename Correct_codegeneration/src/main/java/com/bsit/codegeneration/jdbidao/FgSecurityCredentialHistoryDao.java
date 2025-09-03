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
import com.bsit.codegeneration.entity.FgSecurityCredentialHistory;

public interface FgSecurityCredentialHistoryDao {

    /**
     * Inserts a new FgSecurityCredentialHistory and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SECURITY_CREDENTIAL_HISTORY (ID, PURPOSE_CODE, PARTY_CODE, PARTY_SUB_TYPE_CODE, USER_CODE, USER_SUB_TYPE_CODE, CREDENTIAL_TYPE_CODE, CREDENTIAL_VALUE, USER_NAME, MOBILE_NO, IMEI_NO, DEVICE, DEVICE_ID, DEVICE_BRAND, DEVICE_MFCT, DEVICE_MODEL, DEVICE_PRODUCT, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ACTIVE_CODE, STATUS_CODE) VALUES (:id, :purposeCode, :partyCode, :partySubTypeCode, :userCode, :userSubTypeCode, :credentialTypeCode, :credentialValue, :userName, :mobileNo, :imeiNo, :device, :deviceId, :deviceBrand, :deviceMfct, :deviceModel, :deviceProduct, :lastAuthorisedOn, :lastAuthorisedBy, :activeCode, :statusCode)")
    public int insert(@BindBean FgSecurityCredentialHistory fgsecuritycredentialhistory);

    /**
     * Finds a FgSecurityCredentialHistory by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SECURITY_CREDENTIAL_HISTORY WHERE ID = :id")
    @RegisterBeanMapper(FgSecurityCredentialHistory.class)
    public Optional<FgSecurityCredentialHistory> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SECURITY_CREDENTIAL_HISTORY")
    @RegisterBeanMapper(FgSecurityCredentialHistory.class)
    public List<FgSecurityCredentialHistory> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SECURITY_CREDENTIAL_HISTORY ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSecurityCredentialHistory.class)
    public List<FgSecurityCredentialHistory> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSecurityCredentialHistory and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SECURITY_CREDENTIAL_HISTORY SET PURPOSE_CODE = :purposeCode, PARTY_CODE = :partyCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, USER_CODE = :userCode, USER_SUB_TYPE_CODE = :userSubTypeCode, CREDENTIAL_TYPE_CODE = :credentialTypeCode, CREDENTIAL_VALUE = :credentialValue, USER_NAME = :userName, MOBILE_NO = :mobileNo, IMEI_NO = :imeiNo, DEVICE = :device, DEVICE_ID = :deviceId, DEVICE_BRAND = :deviceBrand, DEVICE_MFCT = :deviceMfct, DEVICE_MODEL = :deviceModel, DEVICE_PRODUCT = :deviceProduct, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode WHERE ID = :id")
    public int update(@BindBean FgSecurityCredentialHistory fgsecuritycredentialhistory);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SECURITY_CREDENTIAL_HISTORY WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SECURITY_CREDENTIAL_HISTORY")
    public long countAll();

    /**
     * Bulk insert multiple FgSecurityCredentialHistory entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SECURITY_CREDENTIAL_HISTORY (ID, PURPOSE_CODE, PARTY_CODE, PARTY_SUB_TYPE_CODE, USER_CODE, USER_SUB_TYPE_CODE, CREDENTIAL_TYPE_CODE, CREDENTIAL_VALUE, USER_NAME, MOBILE_NO, IMEI_NO, DEVICE, DEVICE_ID, DEVICE_BRAND, DEVICE_MFCT, DEVICE_MODEL, DEVICE_PRODUCT, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ACTIVE_CODE, STATUS_CODE) VALUES (:id, :purposeCode, :partyCode, :partySubTypeCode, :userCode, :userSubTypeCode, :credentialTypeCode, :credentialValue, :userName, :mobileNo, :imeiNo, :device, :deviceId, :deviceBrand, :deviceMfct, :deviceModel, :deviceProduct, :lastAuthorisedOn, :lastAuthorisedBy, :activeCode, :statusCode)")
    public int[] bulkInsert(@BindBean List<FgSecurityCredentialHistory> fgsecuritycredentialhistorys);

    /**
     * Bulk update multiple FgSecurityCredentialHistory entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SECURITY_CREDENTIAL_HISTORY SET PURPOSE_CODE = :purposeCode, PARTY_CODE = :partyCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, USER_CODE = :userCode, USER_SUB_TYPE_CODE = :userSubTypeCode, CREDENTIAL_TYPE_CODE = :credentialTypeCode, CREDENTIAL_VALUE = :credentialValue, USER_NAME = :userName, MOBILE_NO = :mobileNo, IMEI_NO = :imeiNo, DEVICE = :device, DEVICE_ID = :deviceId, DEVICE_BRAND = :deviceBrand, DEVICE_MFCT = :deviceMfct, DEVICE_MODEL = :deviceModel, DEVICE_PRODUCT = :deviceProduct, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgSecurityCredentialHistory> fgsecuritycredentialhistorys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SECURITY_CREDENTIAL_HISTORY WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SECURITY_CREDENTIAL_HISTORY WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgSecurityCredentialHistory records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SECURITY_CREDENTIAL_HISTORY WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgSecurityCredentialHistory.class)
    public List<FgSecurityCredentialHistory> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
