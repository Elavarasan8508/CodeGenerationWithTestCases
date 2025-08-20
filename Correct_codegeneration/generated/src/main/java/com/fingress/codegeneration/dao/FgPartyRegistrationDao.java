package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyRegistration;
import com.bsit.codegeneration.mapper.FgPartyRegistrationMapper;
import java.util.*;

@RegisterRowMapper(FgPartyRegistrationMapper.class)
public interface FgPartyRegistrationDao {

    @SqlQuery("SELECT * FROM FG_PARTY_REGISTRATION")
    public List<FgPartyRegistration> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_REGISTRATION WHERE id = :id")
    public Optional<FgPartyRegistration> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_PARTY_REGISTRATION(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, EMAIL, PHONE, COMMENTS, PURPOSE, OTP_VERIFY, LAST_NAME, USER_NAME, PASSWORD, COUNTRY, CUSTOMER_ID, CUSTOMER_NAME, COMPANY_NAME, ADDRESS_LINE_1, ADDRESS_LINE_2, ADDRESS_LINE_3, CITY, STATE, ZIP) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :NAME, :EMAIL, :PHONE, :COMMENTS, :PURPOSE, :OTP_VERIFY, :LAST_NAME, :USER_NAME, :PASSWORD, :COUNTRY, :CUSTOMER_ID, :CUSTOMER_NAME, :COMPANY_NAME, :ADDRESS_LINE_1, :ADDRESS_LINE_2, :ADDRESS_LINE_3, :CITY, :STATE, :ZIP)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgPartyRegistration entity);

    @SqlQuery("UPDATE FG_PARTY_REGISTRATION SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, NAME = :NAME, EMAIL = :EMAIL, PHONE = :PHONE, COMMENTS = :COMMENTS, PURPOSE = :PURPOSE, OTP_VERIFY = :OTP_VERIFY, LAST_NAME = :LAST_NAME, USER_NAME = :USER_NAME, PASSWORD = :PASSWORD, COUNTRY = :COUNTRY, CUSTOMER_ID = :CUSTOMER_ID, CUSTOMER_NAME = :CUSTOMER_NAME, COMPANY_NAME = :COMPANY_NAME, ADDRESS_LINE_1 = :ADDRESS_LINE_1, ADDRESS_LINE_2 = :ADDRESS_LINE_2, ADDRESS_LINE_3 = :ADDRESS_LINE_3, CITY = :CITY, STATE = :STATE, ZIP = :ZIP WHERE id = :id")
    public int update(@BindBean() FgPartyRegistration entity);

    @SqlQuery("DELETE FROM FG_PARTY_REGISTRATION WHERE id = :id")
    public int delete(@Bind("id") String id);
}
