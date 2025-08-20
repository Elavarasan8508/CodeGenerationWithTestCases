package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.Extportdestination;
import com.bsit.codegeneration.mapper.ExtportdestinationMapper;
import java.util.*;

@RegisterRowMapper(ExtportdestinationMapper.class)
public interface ExtportdestinationDao {

    @SqlQuery("SELECT * FROM EXTPORTDESTINATION")
    public List<Extportdestination> findAll();

    @SqlQuery("SELECT * FROM EXTPORTDESTINATION WHERE id = :id")
    public Optional<Extportdestination> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO EXTPORTDESTINATION(PORT_OF_DEST, DESCRIPTION) VALUES (:PORT_OF_DEST, :DESCRIPTION)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() Extportdestination entity);

    @SqlQuery("UPDATE EXTPORTDESTINATION SET PORT_OF_DEST = :PORT_OF_DEST, DESCRIPTION = :DESCRIPTION WHERE id = :id")
    public int update(@BindBean() Extportdestination entity);

    @SqlQuery("DELETE FROM EXTPORTDESTINATION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
