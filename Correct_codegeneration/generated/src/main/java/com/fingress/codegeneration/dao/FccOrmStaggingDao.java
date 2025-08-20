package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FccOrmStagging;
import com.bsit.codegeneration.mapper.FccOrmStaggingMapper;
import java.util.*;

@RegisterRowMapper(FccOrmStaggingMapper.class)
public interface FccOrmStaggingDao {

    @SqlQuery("SELECT * FROM FCC_ORM_STAGGING")
    public List<FccOrmStagging> findAll();

    @SqlQuery("SELECT * FROM FCC_ORM_STAGGING WHERE id = :id")
    public Optional<FccOrmStagging> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FCC_ORM_STAGGING(SEQ_ID, REFERENCEID, UPLOAD_REF_ID, UPLOAD_TNX_ID, REQUEST, RESPONSE, ERROR_MSG, INSERTED_ON, TNX_STAT_CODE, PROD_STAT_CODE) VALUES (:SEQ_ID, :REFERENCEID, :UPLOAD_REF_ID, :UPLOAD_TNX_ID, :REQUEST, :RESPONSE, :ERROR_MSG, :INSERTED_ON, :TNX_STAT_CODE, :PROD_STAT_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FccOrmStagging entity);

    @SqlQuery("UPDATE FCC_ORM_STAGGING SET SEQ_ID = :SEQ_ID, REFERENCEID = :REFERENCEID, UPLOAD_REF_ID = :UPLOAD_REF_ID, UPLOAD_TNX_ID = :UPLOAD_TNX_ID, REQUEST = :REQUEST, RESPONSE = :RESPONSE, ERROR_MSG = :ERROR_MSG, INSERTED_ON = :INSERTED_ON, TNX_STAT_CODE = :TNX_STAT_CODE, PROD_STAT_CODE = :PROD_STAT_CODE WHERE id = :id")
    public int update(@BindBean() FccOrmStagging entity);

    @SqlQuery("DELETE FROM FCC_ORM_STAGGING WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
