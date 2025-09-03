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
import com.bsit.codegeneration.entity.CustomerRegistration;

public interface CustomerRegistrationDao {

    /**
     * Inserts a new CustomerRegistration and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO CUSTOMER_REGISTRATION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, ADDRESS, MOBILE, ALTERNATE_CONTACT_NUMBER) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :firstName, :lastName, :dateOfBirth, :address, :mobile, :alternateContactNumber)")
    public int insert(@BindBean CustomerRegistration customerregistration);

    /**
     * Finds a CustomerRegistration by its ID.
     */
    @SqlQuery("SELECT * FROM CUSTOMER_REGISTRATION WHERE ID = :id")
    @RegisterBeanMapper(CustomerRegistration.class)
    public Optional<CustomerRegistration> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM CUSTOMER_REGISTRATION")
    @RegisterBeanMapper(CustomerRegistration.class)
    public List<CustomerRegistration> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM CUSTOMER_REGISTRATION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(CustomerRegistration.class)
    public List<CustomerRegistration> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a CustomerRegistration and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE CUSTOMER_REGISTRATION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, FIRST_NAME = :firstName, LAST_NAME = :lastName, DATE_OF_BIRTH = :dateOfBirth, ADDRESS = :address, MOBILE = :mobile, ALTERNATE_CONTACT_NUMBER = :alternateContactNumber WHERE ID = :id")
    public int update(@BindBean CustomerRegistration customerregistration);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM CUSTOMER_REGISTRATION WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM CUSTOMER_REGISTRATION")
    public long countAll();

    /**
     * Bulk insert multiple CustomerRegistration entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO CUSTOMER_REGISTRATION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, ADDRESS, MOBILE, ALTERNATE_CONTACT_NUMBER) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :firstName, :lastName, :dateOfBirth, :address, :mobile, :alternateContactNumber)")
    public int[] bulkInsert(@BindBean List<CustomerRegistration> customerregistrations);

    /**
     * Bulk update multiple CustomerRegistration entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE CUSTOMER_REGISTRATION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, FIRST_NAME = :firstName, LAST_NAME = :lastName, DATE_OF_BIRTH = :dateOfBirth, ADDRESS = :address, MOBILE = :mobile, ALTERNATE_CONTACT_NUMBER = :alternateContactNumber WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<CustomerRegistration> customerregistrations);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM CUSTOMER_REGISTRATION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM CUSTOMER_REGISTRATION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple CustomerRegistration records by their IDs.
     */
    @SqlQuery("SELECT * FROM CUSTOMER_REGISTRATION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(CustomerRegistration.class)
    public List<CustomerRegistration> findByIds(@BindList("ids") Collection<String> ids);
}
