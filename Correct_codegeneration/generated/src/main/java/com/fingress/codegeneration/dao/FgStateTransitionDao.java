package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgStateTransition;
import com.bsit.codegeneration.mapper.FgStateTransitionMapper;
import java.util.*;

@RegisterRowMapper(FgStateTransitionMapper.class)
public interface FgStateTransitionDao {

    @SqlQuery("SELECT * FROM FG_STATE_TRANSITION")
    public List<FgStateTransition> findAll();

    @SqlQuery("SELECT * FROM FG_STATE_TRANSITION WHERE id = :id")
    public Optional<FgStateTransition> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_STATE_TRANSITION(ID, ACTION_CODE, ACTION_NAME, START_STATE_CODE, TARGET_STATE_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:ID, :ACTION_CODE, :ACTION_NAME, :START_STATE_CODE, :TARGET_STATE_CODE, :ACTIVE_CODE, :STATUS_CODE, :CREATED_BY, :CREATED_ON, :LAST_UPDATED_BY, :LAST_UPDATED_ON, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgStateTransition entity);

    @SqlQuery("UPDATE FG_STATE_TRANSITION SET ID = :ID, ACTION_CODE = :ACTION_CODE, ACTION_NAME = :ACTION_NAME, START_STATE_CODE = :START_STATE_CODE, TARGET_STATE_CODE = :TARGET_STATE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_BY = :CREATED_BY, CREATED_ON = :CREATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON WHERE id = :id")
    public int update(@BindBean() FgStateTransition entity);

    @SqlQuery("DELETE FROM FG_STATE_TRANSITION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
