package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSettlementSlot;
import com.bsit.codegeneration.mapper.FgSettlementSlotMapper;
import java.util.*;

@RegisterRowMapper(FgSettlementSlotMapper.class)
public interface FgSettlementSlotDao {

    @SqlQuery("SELECT * FROM FG_SETTLEMENT_SLOT")
    public List<FgSettlementSlot> findAll();

    @SqlQuery("SELECT * FROM FG_SETTLEMENT_SLOT WHERE id = :id")
    public Optional<FgSettlementSlot> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SETTLEMENT_SLOT(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CRON_EXPRESSION, MINUTES, HOURS, DAYS, SLOT, PACKAGE_NAME, IDENTIFIER, STATUS, CRON_DESCRIPTION, FROM_HOUR, TO_HOUR, SLOT_TYPE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :CRON_EXPRESSION, :MINUTES, :HOURS, :DAYS, :SLOT, :PACKAGE_NAME, :IDENTIFIER, :STATUS, :CRON_DESCRIPTION, :FROM_HOUR, :TO_HOUR, :SLOT_TYPE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSettlementSlot entity);

    @SqlQuery("UPDATE FG_SETTLEMENT_SLOT SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, CRON_EXPRESSION = :CRON_EXPRESSION, MINUTES = :MINUTES, HOURS = :HOURS, DAYS = :DAYS, SLOT = :SLOT, PACKAGE_NAME = :PACKAGE_NAME, IDENTIFIER = :IDENTIFIER, STATUS = :STATUS, CRON_DESCRIPTION = :CRON_DESCRIPTION, FROM_HOUR = :FROM_HOUR, TO_HOUR = :TO_HOUR, SLOT_TYPE = :SLOT_TYPE WHERE id = :id")
    public int update(@BindBean() FgSettlementSlot entity);

    @SqlQuery("DELETE FROM FG_SETTLEMENT_SLOT WHERE id = :id")
    public int delete(@Bind("id") String id);
}
