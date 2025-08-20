package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgOrmData;
import com.bsit.codegeneration.mapper.FgOrmDataMapper;
import java.util.*;

@RegisterRowMapper(FgOrmDataMapper.class)
public interface FgOrmDataDao {

    @SqlQuery("SELECT * FROM FG_ORM_DATA")
    public List<FgOrmData> findAll();

    @SqlQuery("SELECT * FROM FG_ORM_DATA WHERE id = :id")
    public Optional<FgOrmData> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_ORM_DATA(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_OS_AMT, ORM_CCY, ORM_DATE, IE_NAME, IE_CODE, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :ORM_NUMBER, :AD_CODE, :ORM_AMOUNT, :ORM_UTILIZED_AMT, :ORM_OS_AMT, :ORM_CCY, :ORM_DATE, :IE_NAME, :IE_CODE, :BENE_NAME, :BENE_COUNTRY, :REMITTER_BANK_NAME, :PUR_OF_REMIT)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgOrmData entity);

    @SqlQuery("UPDATE FG_ORM_DATA SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, ORM_NUMBER = :ORM_NUMBER, AD_CODE = :AD_CODE, ORM_AMOUNT = :ORM_AMOUNT, ORM_UTILIZED_AMT = :ORM_UTILIZED_AMT, ORM_OS_AMT = :ORM_OS_AMT, ORM_CCY = :ORM_CCY, ORM_DATE = :ORM_DATE, IE_NAME = :IE_NAME, IE_CODE = :IE_CODE, BENE_NAME = :BENE_NAME, BENE_COUNTRY = :BENE_COUNTRY, REMITTER_BANK_NAME = :REMITTER_BANK_NAME, PUR_OF_REMIT = :PUR_OF_REMIT WHERE id = :id")
    public int update(@BindBean() FgOrmData entity);

    @SqlQuery("DELETE FROM FG_ORM_DATA WHERE id = :id")
    public int delete(@Bind("id") String id);
}
