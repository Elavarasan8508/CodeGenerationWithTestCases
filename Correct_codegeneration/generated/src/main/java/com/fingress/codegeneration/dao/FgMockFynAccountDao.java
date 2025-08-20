package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgMockFynAccount;
import com.bsit.codegeneration.mapper.FgMockFynAccountMapper;
import java.util.*;

@RegisterRowMapper(FgMockFynAccountMapper.class)
public interface FgMockFynAccountDao {

    @SqlQuery("SELECT * FROM FG_MOCK_FYN_ACCOUNT")
    public List<FgMockFynAccount> findAll();

    @SqlQuery("SELECT * FROM FG_MOCK_FYN_ACCOUNT WHERE id = :id")
    public Optional<FgMockFynAccount> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_MOCK_FYN_ACCOUNT(CUST_MNM, ACCOUNT_NO, TEMPLATE, VERSION_ID, IS_MASTER_VERSION, ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_TEMPLATE, ACCOUNT_STATUS) VALUES (:CUST_MNM, :ACCOUNT_NO, :TEMPLATE, :VERSION_ID, :IS_MASTER_VERSION, :ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :IS_TEMPLATE, :ACCOUNT_STATUS)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgMockFynAccount entity);

    @SqlQuery("UPDATE FG_MOCK_FYN_ACCOUNT SET CUST_MNM = :CUST_MNM, ACCOUNT_NO = :ACCOUNT_NO, TEMPLATE = :TEMPLATE, VERSION_ID = :VERSION_ID, IS_MASTER_VERSION = :IS_MASTER_VERSION, ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, IS_TEMPLATE = :IS_TEMPLATE, ACCOUNT_STATUS = :ACCOUNT_STATUS WHERE id = :id")
    public int update(@BindBean() FgMockFynAccount entity);

    @SqlQuery("DELETE FROM FG_MOCK_FYN_ACCOUNT WHERE id = :id")
    public int delete(@Bind("id") String id);
}
