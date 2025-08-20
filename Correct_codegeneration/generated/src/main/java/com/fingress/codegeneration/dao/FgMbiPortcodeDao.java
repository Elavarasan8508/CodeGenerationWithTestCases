package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgMbiPortcode;
import com.bsit.codegeneration.mapper.FgMbiPortcodeMapper;
import java.util.*;

@RegisterRowMapper(FgMbiPortcodeMapper.class)
public interface FgMbiPortcodeDao {

    @SqlQuery("SELECT * FROM FG_MBI_PORTCODE")
    public List<FgMbiPortcode> findAll();

    @SqlQuery("SELECT * FROM FG_MBI_PORTCODE WHERE id = :id")
    public Optional<FgMbiPortcode> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_MBI_PORTCODE(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PORT_OF_DEST, DESCRIPTION) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :PORT_OF_DEST, :DESCRIPTION)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgMbiPortcode entity);

    @SqlQuery("UPDATE FG_MBI_PORTCODE SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, PORT_OF_DEST = :PORT_OF_DEST, DESCRIPTION = :DESCRIPTION WHERE id = :id")
    public int update(@BindBean() FgMbiPortcode entity);

    @SqlQuery("DELETE FROM FG_MBI_PORTCODE WHERE id = :id")
    public int delete(@Bind("id") String id);
}
