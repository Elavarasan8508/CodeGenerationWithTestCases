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
import com.bsit.codegeneration.entity.FgPerson;

public interface FgPersonDao {

    /**
     * Inserts a new FgPerson and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PERSON (ID, BIRTH_COUNTRY_CODE, BIRTH_NAME, CITY_OF_BIRTH, DOMICILE_COUNTRY_CODE, GENDER_CODE, GIVEN_NAME, LANGUAGE_CODE, MIDDLE_NAME, MINOR_INDICATOR, NAME, NAME_PREFIX_CODE, NAME_SUFFIX, NATIONALITY_CODE, PROFESSION, PROVINCE_OF_BIRTH, RESIDENCE_COUNTRY_CODE, RESIDENTIAL_STATUS_CODE, TAXATION_COUNTRY_CODE, PARTY_ID, PARTY_VERSION_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, EMPLOYEE_NO, DATE_OF_BIRTH, DATE_OF_JOINING, DESIGNATION) VALUES (:id, :birthCountryCode, :birthName, :cityOfBirth, :domicileCountryCode, :genderCode, :givenName, :languageCode, :middleName, :minorIndicator, :name, :namePrefixCode, :nameSuffix, :nationalityCode, :profession, :provinceOfBirth, :residenceCountryCode, :residentialStatusCode, :taxationCountryCode, :partyId, :partyVersionId, :lastAuthorisedOn, :lastAuthorisedBy, :employeeNo, :dateOfBirth, :dateOfJoining, :designation)")
    public int insert(@BindBean FgPerson fgperson);

    /**
     * Finds a FgPerson by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PERSON WHERE ID = :id")
    @RegisterBeanMapper(FgPerson.class)
    public Optional<FgPerson> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PERSON")
    @RegisterBeanMapper(FgPerson.class)
    public List<FgPerson> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PERSON ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPerson.class)
    public List<FgPerson> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPerson and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PERSON SET BIRTH_COUNTRY_CODE = :birthCountryCode, BIRTH_NAME = :birthName, CITY_OF_BIRTH = :cityOfBirth, DOMICILE_COUNTRY_CODE = :domicileCountryCode, GENDER_CODE = :genderCode, GIVEN_NAME = :givenName, LANGUAGE_CODE = :languageCode, MIDDLE_NAME = :middleName, MINOR_INDICATOR = :minorIndicator, NAME = :name, NAME_PREFIX_CODE = :namePrefixCode, NAME_SUFFIX = :nameSuffix, NATIONALITY_CODE = :nationalityCode, PROFESSION = :profession, PROVINCE_OF_BIRTH = :provinceOfBirth, RESIDENCE_COUNTRY_CODE = :residenceCountryCode, RESIDENTIAL_STATUS_CODE = :residentialStatusCode, TAXATION_COUNTRY_CODE = :taxationCountryCode, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, EMPLOYEE_NO = :employeeNo, DATE_OF_BIRTH = :dateOfBirth, DATE_OF_JOINING = :dateOfJoining, DESIGNATION = :designation WHERE ID = :id")
    public int update(@BindBean FgPerson fgperson);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PERSON WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PERSON")
    public long countAll();

    /**
     * Bulk insert multiple FgPerson entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PERSON (ID, BIRTH_COUNTRY_CODE, BIRTH_NAME, CITY_OF_BIRTH, DOMICILE_COUNTRY_CODE, GENDER_CODE, GIVEN_NAME, LANGUAGE_CODE, MIDDLE_NAME, MINOR_INDICATOR, NAME, NAME_PREFIX_CODE, NAME_SUFFIX, NATIONALITY_CODE, PROFESSION, PROVINCE_OF_BIRTH, RESIDENCE_COUNTRY_CODE, RESIDENTIAL_STATUS_CODE, TAXATION_COUNTRY_CODE, PARTY_ID, PARTY_VERSION_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, EMPLOYEE_NO, DATE_OF_BIRTH, DATE_OF_JOINING, DESIGNATION) VALUES (:id, :birthCountryCode, :birthName, :cityOfBirth, :domicileCountryCode, :genderCode, :givenName, :languageCode, :middleName, :minorIndicator, :name, :namePrefixCode, :nameSuffix, :nationalityCode, :profession, :provinceOfBirth, :residenceCountryCode, :residentialStatusCode, :taxationCountryCode, :partyId, :partyVersionId, :lastAuthorisedOn, :lastAuthorisedBy, :employeeNo, :dateOfBirth, :dateOfJoining, :designation)")
    public int[] bulkInsert(@BindBean List<FgPerson> fgpersons);

    /**
     * Bulk update multiple FgPerson entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PERSON SET BIRTH_COUNTRY_CODE = :birthCountryCode, BIRTH_NAME = :birthName, CITY_OF_BIRTH = :cityOfBirth, DOMICILE_COUNTRY_CODE = :domicileCountryCode, GENDER_CODE = :genderCode, GIVEN_NAME = :givenName, LANGUAGE_CODE = :languageCode, MIDDLE_NAME = :middleName, MINOR_INDICATOR = :minorIndicator, NAME = :name, NAME_PREFIX_CODE = :namePrefixCode, NAME_SUFFIX = :nameSuffix, NATIONALITY_CODE = :nationalityCode, PROFESSION = :profession, PROVINCE_OF_BIRTH = :provinceOfBirth, RESIDENCE_COUNTRY_CODE = :residenceCountryCode, RESIDENTIAL_STATUS_CODE = :residentialStatusCode, TAXATION_COUNTRY_CODE = :taxationCountryCode, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, EMPLOYEE_NO = :employeeNo, DATE_OF_BIRTH = :dateOfBirth, DATE_OF_JOINING = :dateOfJoining, DESIGNATION = :designation WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPerson> fgpersons);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PERSON WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PERSON WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgPerson records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PERSON WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPerson.class)
    public List<FgPerson> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
