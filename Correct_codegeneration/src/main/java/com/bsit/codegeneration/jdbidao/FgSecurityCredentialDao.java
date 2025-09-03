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
import com.bsit.codegeneration.entity.FgSecurityCredential;

public interface FgSecurityCredentialDao {

    /**
     * Inserts a new FgSecurityCredential and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SECURITY_CREDENTIAL (ID, PURPOSE_CODE, PARTY_CODE, PARTY_SUB_TYPE_CODE, USER_CODE, USER_SUB_TYPE_CODE, CREDENTIAL_TYPE_CODE, CREDENTIAL_VALUE, EXPIRES_ON, MOBILE_NO, IMEI_NO, DEVICE, DEVICE_ID, DEVICE_BRAND, DEVICE_MFCT, DEVICE_MODEL, DEVICE_PRODUCT, USER_NAME, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CREDENTIAL_KEY) VALUES (:id, :purposeCode, :partyCode, :partySubTypeCode, :userCode, :userSubTypeCode, :credentialTypeCode, :credentialValue, :expiresOn, :mobileNo, :imeiNo, :device, :deviceId, :deviceBrand, :deviceMfct, :deviceModel, :deviceProduct, :userName, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :credentialKey)")
    public int insert(@BindBean FgSecurityCredential fgsecuritycredential);

    /**
     * Finds a FgSecurityCredential by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SECURITY_CREDENTIAL WHERE ID = :id")
    @RegisterBeanMapper(FgSecurityCredential.class)
    public Optional<FgSecurityCredential> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SECURITY_CREDENTIAL")
    @RegisterBeanMapper(FgSecurityCredential.class)
    public List<FgSecurityCredential> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SECURITY_CREDENTIAL ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSecurityCredential.class)
    public List<FgSecurityCredential> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSecurityCredential and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SECURITY_CREDENTIAL SET PURPOSE_CODE = :purposeCode, PARTY_CODE = :partyCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, USER_CODE = :userCode, USER_SUB_TYPE_CODE = :userSubTypeCode, CREDENTIAL_TYPE_CODE = :credentialTypeCode, CREDENTIAL_VALUE = :credentialValue, EXPIRES_ON = :expiresOn, MOBILE_NO = :mobileNo, IMEI_NO = :imeiNo, DEVICE = :device, DEVICE_ID = :deviceId, DEVICE_BRAND = :deviceBrand, DEVICE_MFCT = :deviceMfct, DEVICE_MODEL = :deviceModel, DEVICE_PRODUCT = :deviceProduct, USER_NAME = :userName, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, CREDENTIAL_KEY = :credentialKey WHERE ID = :id")
    public int update(@BindBean FgSecurityCredential fgsecuritycredential);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SECURITY_CREDENTIAL WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SECURITY_CREDENTIAL")
    public long countAll();

    /**
     * Bulk insert multiple FgSecurityCredential entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SECURITY_CREDENTIAL (ID, PURPOSE_CODE, PARTY_CODE, PARTY_SUB_TYPE_CODE, USER_CODE, USER_SUB_TYPE_CODE, CREDENTIAL_TYPE_CODE, CREDENTIAL_VALUE, EXPIRES_ON, MOBILE_NO, IMEI_NO, DEVICE, DEVICE_ID, DEVICE_BRAND, DEVICE_MFCT, DEVICE_MODEL, DEVICE_PRODUCT, USER_NAME, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CREDENTIAL_KEY) VALUES (:id, :purposeCode, :partyCode, :partySubTypeCode, :userCode, :userSubTypeCode, :credentialTypeCode, :credentialValue, :expiresOn, :mobileNo, :imeiNo, :device, :deviceId, :deviceBrand, :deviceMfct, :deviceModel, :deviceProduct, :userName, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :credentialKey)")
    public int[] bulkInsert(@BindBean List<FgSecurityCredential> fgsecuritycredentials);

    /**
     * Bulk update multiple FgSecurityCredential entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SECURITY_CREDENTIAL SET PURPOSE_CODE = :purposeCode, PARTY_CODE = :partyCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, USER_CODE = :userCode, USER_SUB_TYPE_CODE = :userSubTypeCode, CREDENTIAL_TYPE_CODE = :credentialTypeCode, CREDENTIAL_VALUE = :credentialValue, EXPIRES_ON = :expiresOn, MOBILE_NO = :mobileNo, IMEI_NO = :imeiNo, DEVICE = :device, DEVICE_ID = :deviceId, DEVICE_BRAND = :deviceBrand, DEVICE_MFCT = :deviceMfct, DEVICE_MODEL = :deviceModel, DEVICE_PRODUCT = :deviceProduct, USER_NAME = :userName, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, CREDENTIAL_KEY = :credentialKey WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgSecurityCredential> fgsecuritycredentials);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SECURITY_CREDENTIAL WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SECURITY_CREDENTIAL WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgSecurityCredential records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SECURITY_CREDENTIAL WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgSecurityCredential.class)
    public List<FgSecurityCredential> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
