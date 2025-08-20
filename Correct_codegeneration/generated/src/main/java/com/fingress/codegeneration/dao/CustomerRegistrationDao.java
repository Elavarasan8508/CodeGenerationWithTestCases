package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.CustomerRegistration;
import com.bsit.codegeneration.mapper.CustomerRegistrationMapper;
import java.util.*;

@RegisterRowMapper(CustomerRegistrationMapper.class)
public interface CustomerRegistrationDao {

    @SqlQuery("SELECT * FROM CUSTOMER_REGISTRATION")
    public List<CustomerRegistration> findAll();

    @SqlQuery("SELECT * FROM CUSTOMER_REGISTRATION WHERE id = :id")
    public Optional<CustomerRegistration> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO CUSTOMER_REGISTRATION(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, ADDRESS, MOBILE, ALTERNATE_CONTACT_NUMBER) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :FIRST_NAME, :LAST_NAME, :DATE_OF_BIRTH, :ADDRESS, :MOBILE, :ALTERNATE_CONTACT_NUMBER)")
    @GetGeneratedKeys()
    public String insert(@BindBean() CustomerRegistration entity);

    @SqlQuery("UPDATE CUSTOMER_REGISTRATION SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, FIRST_NAME = :FIRST_NAME, LAST_NAME = :LAST_NAME, DATE_OF_BIRTH = :DATE_OF_BIRTH, ADDRESS = :ADDRESS, MOBILE = :MOBILE, ALTERNATE_CONTACT_NUMBER = :ALTERNATE_CONTACT_NUMBER WHERE id = :id")
    public int update(@BindBean() CustomerRegistration entity);

    @SqlQuery("DELETE FROM CUSTOMER_REGISTRATION WHERE id = :id")
    public int delete(@Bind("id") String id);
}
