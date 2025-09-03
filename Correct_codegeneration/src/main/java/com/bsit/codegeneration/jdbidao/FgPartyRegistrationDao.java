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
import com.bsit.codegeneration.entity.FgPartyRegistration;

public interface FgPartyRegistrationDao {

    /**
     * Inserts a new FgPartyRegistration and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_REGISTRATION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, EMAIL, PHONE, COMMENTS, PURPOSE, OTP_VERIFY, LAST_NAME, USER_NAME, PASSWORD, COUNTRY, CUSTOMER_ID, CUSTOMER_NAME, COMPANY_NAME, ADDRESS_LINE_1, ADDRESS_LINE_2, ADDRESS_LINE_3, CITY, STATE, ZIP) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name, :email, :phone, :comments, :purpose, :otpVerify, :lastName, :userName, :password, :country, :customerId, :customerName, :companyName, :addressLine1, :addressLine2, :addressLine3, :city, :state, :zip)")
    public int insert(@BindBean FgPartyRegistration fgpartyregistration);

    /**
     * Finds a FgPartyRegistration by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_REGISTRATION WHERE FG_PARTY_REGISTRATION_id = :id")
    @RegisterBeanMapper(FgPartyRegistration.class)
    public Optional<FgPartyRegistration> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_REGISTRATION")
    @RegisterBeanMapper(FgPartyRegistration.class)
    public List<FgPartyRegistration> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_REGISTRATION ORDER BY FG_PARTY_REGISTRATION_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyRegistration.class)
    public List<FgPartyRegistration> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyRegistration and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_REGISTRATION SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name, EMAIL = :email, PHONE = :phone, COMMENTS = :comments, PURPOSE = :purpose, OTP_VERIFY = :otpVerify, LAST_NAME = :lastName, USER_NAME = :userName, PASSWORD = :password, COUNTRY = :country, CUSTOMER_ID = :customerId, CUSTOMER_NAME = :customerName, COMPANY_NAME = :companyName, ADDRESS_LINE_1 = :addressLine1, ADDRESS_LINE_2 = :addressLine2, ADDRESS_LINE_3 = :addressLine3, CITY = :city, STATE = :state, ZIP = :zip WHERE FG_PARTY_REGISTRATION_id = :fgPartyRegistrationId")
    public int update(@BindBean FgPartyRegistration fgpartyregistration);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_REGISTRATION WHERE FG_PARTY_REGISTRATION_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_REGISTRATION")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyRegistration entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_REGISTRATION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, EMAIL, PHONE, COMMENTS, PURPOSE, OTP_VERIFY, LAST_NAME, USER_NAME, PASSWORD, COUNTRY, CUSTOMER_ID, CUSTOMER_NAME, COMPANY_NAME, ADDRESS_LINE_1, ADDRESS_LINE_2, ADDRESS_LINE_3, CITY, STATE, ZIP) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name, :email, :phone, :comments, :purpose, :otpVerify, :lastName, :userName, :password, :country, :customerId, :customerName, :companyName, :addressLine1, :addressLine2, :addressLine3, :city, :state, :zip)")
    public int[] bulkInsert(@BindBean List<FgPartyRegistration> fgpartyregistrations);

    /**
     * Bulk update multiple FgPartyRegistration entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_REGISTRATION SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name, EMAIL = :email, PHONE = :phone, COMMENTS = :comments, PURPOSE = :purpose, OTP_VERIFY = :otpVerify, LAST_NAME = :lastName, USER_NAME = :userName, PASSWORD = :password, COUNTRY = :country, CUSTOMER_ID = :customerId, CUSTOMER_NAME = :customerName, COMPANY_NAME = :companyName, ADDRESS_LINE_1 = :addressLine1, ADDRESS_LINE_2 = :addressLine2, ADDRESS_LINE_3 = :addressLine3, CITY = :city, STATE = :state, ZIP = :zip WHERE FG_PARTY_REGISTRATION_id = :fgPartyRegistrationId")
    public int[] bulkUpdate(@BindBean List<FgPartyRegistration> fgpartyregistrations);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_REGISTRATION WHERE FG_PARTY_REGISTRATION_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_REGISTRATION WHERE FG_PARTY_REGISTRATION_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgPartyRegistration records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_REGISTRATION WHERE FG_PARTY_REGISTRATION_id IN (<ids>)")
    @RegisterBeanMapper(FgPartyRegistration.class)
    public List<FgPartyRegistration> findByIds(@BindList("ids") Collection<Integer> ids);
}
