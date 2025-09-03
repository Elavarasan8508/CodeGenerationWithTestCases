package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.batch.SqlBatch;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindList;
import java.util.List;
import java.util.Optional;
import java.util.Collection;
import com.bsit.codegeneration.entity.Databasechangelog;

public interface DatabasechangelogDao {

    /**
     * Inserts a new Databasechangelog and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, EXECTYPE, MD5SUM, DESCRIPTION, COMMENTS, TAG, LIQUIBASE, CONTEXTS, LABELS, DEPLOYMENT_ID) VALUES (:id, :author, :filename, :dateexecuted, :orderexecuted, :exectype, :md5sum, :description, :comments, :tag, :liquibase, :contexts, :labels, :deploymentId)")
    public int insert(@BindBean Databasechangelog databasechangelog);

    /**
     * Finds a Databasechangelog by its ID.
     */
    @SqlQuery("SELECT * FROM DATABASECHANGELOG WHERE DATABASECHANGELOG_id = :id")
    @RegisterBeanMapper(Databasechangelog.class)
    public Optional<Databasechangelog> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM DATABASECHANGELOG")
    @RegisterBeanMapper(Databasechangelog.class)
    public List<Databasechangelog> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM DATABASECHANGELOG ORDER BY DATABASECHANGELOG_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Databasechangelog.class)
    public List<Databasechangelog> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Databasechangelog and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE DATABASECHANGELOG SET ID = :id, AUTHOR = :author, FILENAME = :filename, DATEEXECUTED = :dateexecuted, ORDEREXECUTED = :orderexecuted, EXECTYPE = :exectype, MD5SUM = :md5sum, DESCRIPTION = :description, COMMENTS = :comments, TAG = :tag, LIQUIBASE = :liquibase, CONTEXTS = :contexts, LABELS = :labels, DEPLOYMENT_ID = :deploymentId WHERE DATABASECHANGELOG_id = :databasechangelogId")
    public int update(@BindBean Databasechangelog databasechangelog);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM DATABASECHANGELOG WHERE DATABASECHANGELOG_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM DATABASECHANGELOG")
    public long countAll();

    /**
     * Bulk insert multiple Databasechangelog entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, EXECTYPE, MD5SUM, DESCRIPTION, COMMENTS, TAG, LIQUIBASE, CONTEXTS, LABELS, DEPLOYMENT_ID) VALUES (:id, :author, :filename, :dateexecuted, :orderexecuted, :exectype, :md5sum, :description, :comments, :tag, :liquibase, :contexts, :labels, :deploymentId)")
    public int[] bulkInsert(@BindBean List<Databasechangelog> databasechangelogs);

    /**
     * Bulk update multiple Databasechangelog entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE DATABASECHANGELOG SET ID = :id, AUTHOR = :author, FILENAME = :filename, DATEEXECUTED = :dateexecuted, ORDEREXECUTED = :orderexecuted, EXECTYPE = :exectype, MD5SUM = :md5sum, DESCRIPTION = :description, COMMENTS = :comments, TAG = :tag, LIQUIBASE = :liquibase, CONTEXTS = :contexts, LABELS = :labels, DEPLOYMENT_ID = :deploymentId WHERE DATABASECHANGELOG_id = :databasechangelogId")
    public int[] bulkUpdate(@BindBean List<Databasechangelog> databasechangelogs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM DATABASECHANGELOG WHERE DATABASECHANGELOG_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM DATABASECHANGELOG WHERE DATABASECHANGELOG_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Databasechangelog records by their IDs.
     */
    @SqlQuery("SELECT * FROM DATABASECHANGELOG WHERE DATABASECHANGELOG_id IN (<ids>)")
    @RegisterBeanMapper(Databasechangelog.class)
    public List<Databasechangelog> findByIds(@BindList("ids") Collection<Integer> ids);
}
