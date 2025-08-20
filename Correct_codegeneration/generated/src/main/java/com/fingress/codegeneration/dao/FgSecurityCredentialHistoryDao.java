package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSecurityCredentialHistory;
import com.bsit.codegeneration.mapper.FgSecurityCredentialHistoryMapper;
import java.util.*;

@RegisterRowMapper(FgSecurityCredentialHistoryMapper.class)
public interface FgSecurityCredentialHistoryDao {

    @SqlQuery("SELECT * FROM FG_SECURITY_CREDENTIAL_HISTORY")
    public List<FgSecurityCredentialHistory> findAll();

    @SqlQuery("SELECT * FROM FG_SECURITY_CREDENTIAL_HISTORY WHERE id = :id")
    public Optional<FgSecurityCredentialHistory> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_SECURITY_CREDENTIAL_HISTORY(ID, PURPOSE_CODE, PARTY_CODE, PARTY_SUB_TYPE_CODE, USER_CODE, USER_SUB_TYPE_CODE, CREDENTIAL_TYPE_CODE, CREDENTIAL_VALUE, USER_NAME, MOBILE_NO, IMEI_NO, DEVICE, DEVICE_ID, DEVICE_BRAND, DEVICE_MFCT, DEVICE_MODEL, DEVICE_PRODUCT, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ACTIVE_CODE, STATUS_CODE) VALUES (:ID, :PURPOSE_CODE, :PARTY_CODE, :PARTY_SUB_TYPE_CODE, :USER_CODE, :USER_SUB_TYPE_CODE, :CREDENTIAL_TYPE_CODE, :CREDENTIAL_VALUE, :USER_NAME, :MOBILE_NO, :IMEI_NO, :DEVICE, :DEVICE_ID, :DEVICE_BRAND, :DEVICE_MFCT, :DEVICE_MODEL, :DEVICE_PRODUCT, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :ACTIVE_CODE, :STATUS_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgSecurityCredentialHistory entity);

    @SqlQuery("UPDATE FG_SECURITY_CREDENTIAL_HISTORY SET ID = :ID, PURPOSE_CODE = :PURPOSE_CODE, PARTY_CODE = :PARTY_CODE, PARTY_SUB_TYPE_CODE = :PARTY_SUB_TYPE_CODE, USER_CODE = :USER_CODE, USER_SUB_TYPE_CODE = :USER_SUB_TYPE_CODE, CREDENTIAL_TYPE_CODE = :CREDENTIAL_TYPE_CODE, CREDENTIAL_VALUE = :CREDENTIAL_VALUE, USER_NAME = :USER_NAME, MOBILE_NO = :MOBILE_NO, IMEI_NO = :IMEI_NO, DEVICE = :DEVICE, DEVICE_ID = :DEVICE_ID, DEVICE_BRAND = :DEVICE_BRAND, DEVICE_MFCT = :DEVICE_MFCT, DEVICE_MODEL = :DEVICE_MODEL, DEVICE_PRODUCT = :DEVICE_PRODUCT, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE WHERE id = :id")
    public int update(@BindBean() FgSecurityCredentialHistory entity);

    @SqlQuery("DELETE FROM FG_SECURITY_CREDENTIAL_HISTORY WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
