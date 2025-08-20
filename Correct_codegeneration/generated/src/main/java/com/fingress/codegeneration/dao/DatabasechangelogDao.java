package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.Databasechangelog;
import com.bsit.codegeneration.mapper.DatabasechangelogMapper;
import java.util.*;

@RegisterRowMapper(DatabasechangelogMapper.class)
public interface DatabasechangelogDao {

    @SqlQuery("SELECT * FROM DATABASECHANGELOG")
    public List<Databasechangelog> findAll();

    @SqlQuery("SELECT * FROM DATABASECHANGELOG WHERE id = :id")
    public Optional<Databasechangelog> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO DATABASECHANGELOG(ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, EXECTYPE, MD5SUM, DESCRIPTION, COMMENTS, TAG, LIQUIBASE, CONTEXTS, LABELS, DEPLOYMENT_ID) VALUES (:ID, :AUTHOR, :FILENAME, :DATEEXECUTED, :ORDEREXECUTED, :EXECTYPE, :MD5SUM, :DESCRIPTION, :COMMENTS, :TAG, :LIQUIBASE, :CONTEXTS, :LABELS, :DEPLOYMENT_ID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() Databasechangelog entity);

    @SqlQuery("UPDATE DATABASECHANGELOG SET ID = :ID, AUTHOR = :AUTHOR, FILENAME = :FILENAME, DATEEXECUTED = :DATEEXECUTED, ORDEREXECUTED = :ORDEREXECUTED, EXECTYPE = :EXECTYPE, MD5SUM = :MD5SUM, DESCRIPTION = :DESCRIPTION, COMMENTS = :COMMENTS, TAG = :TAG, LIQUIBASE = :LIQUIBASE, CONTEXTS = :CONTEXTS, LABELS = :LABELS, DEPLOYMENT_ID = :DEPLOYMENT_ID WHERE id = :id")
    public int update(@BindBean() Databasechangelog entity);

    @SqlQuery("DELETE FROM DATABASECHANGELOG WHERE id = :id")
    public int delete(@Bind("id") String id);
}
