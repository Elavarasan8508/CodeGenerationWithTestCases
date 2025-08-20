package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgAutoloanSettlement;
import com.bsit.codegeneration.mapper.FgAutoloanSettlementMapper;
import java.util.*;

@RegisterRowMapper(FgAutoloanSettlementMapper.class)
public interface FgAutoloanSettlementDao {

    @SqlQuery("SELECT * FROM FG_AUTOLOAN_SETTLEMENT")
    public List<FgAutoloanSettlement> findAll();

    @SqlQuery("SELECT * FROM FG_AUTOLOAN_SETTLEMENT WHERE id = :id")
    public Optional<FgAutoloanSettlement> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_AUTOLOAN_SETTLEMENT(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CRN, PARTY_NAME) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :CRN, :PARTY_NAME)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgAutoloanSettlement entity);

    @SqlQuery("UPDATE FG_AUTOLOAN_SETTLEMENT SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, CRN = :CRN, PARTY_NAME = :PARTY_NAME WHERE id = :id")
    public int update(@BindBean() FgAutoloanSettlement entity);

    @SqlQuery("DELETE FROM FG_AUTOLOAN_SETTLEMENT WHERE id = :id")
    public int delete(@Bind("id") String id);
}
