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
import com.bsit.codegeneration.entity.ServicelogBk;

public interface ServicelogBkDao {

    /**
     * Inserts a new ServicelogBk and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO SERVICELOG_BK (ID, SERVICE, OPERATION, ZONE, BRANCH, SOURCESYSTEM, TARGETSYSTEM, MASTERREFERENCE, EVENTREFERENCE, STATUS, PROCESSTIME, TIREQUEST, TIRESPONSE, BANKREQUEST, BANKRESPONSE, TIREQTIME, BANKREQTIME, BANKRESTIME, TIRESTIME, TRANSACTIONKEY1, STATICKEY1, NARRATIVE1, NARRATIVE2, ISRESUBMITTED, RESUBMITTEDCOUNT, RESUBMITTEDTIME, DESCRIPTION, TYPEFLAG, NODE, VALUEDATE, NUMBER1) VALUES (:id, :service, :operation, :zone, :branch, :sourcesystem, :targetsystem, :masterreference, :eventreference, :status, :processtime, :tirequest, :tiresponse, :bankrequest, :bankresponse, :tireqtime, :bankreqtime, :bankrestime, :tirestime, :transactionkey1, :statickey1, :narrative1, :narrative2, :isresubmitted, :resubmittedcount, :resubmittedtime, :description, :typeflag, :node, :valuedate, :number1)")
    public int insert(@BindBean ServicelogBk servicelogbk);

    /**
     * Finds a ServicelogBk by its ID.
     */
    @SqlQuery("SELECT * FROM SERVICELOG_BK WHERE SERVICELOG_BK_id = :id")
    @RegisterBeanMapper(ServicelogBk.class)
    public Optional<ServicelogBk> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM SERVICELOG_BK")
    @RegisterBeanMapper(ServicelogBk.class)
    public List<ServicelogBk> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM SERVICELOG_BK ORDER BY SERVICELOG_BK_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(ServicelogBk.class)
    public List<ServicelogBk> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a ServicelogBk and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE SERVICELOG_BK SET ID = :id, SERVICE = :service, OPERATION = :operation, ZONE = :zone, BRANCH = :branch, SOURCESYSTEM = :sourcesystem, TARGETSYSTEM = :targetsystem, MASTERREFERENCE = :masterreference, EVENTREFERENCE = :eventreference, STATUS = :status, PROCESSTIME = :processtime, TIREQUEST = :tirequest, TIRESPONSE = :tiresponse, BANKREQUEST = :bankrequest, BANKRESPONSE = :bankresponse, TIREQTIME = :tireqtime, BANKREQTIME = :bankreqtime, BANKRESTIME = :bankrestime, TIRESTIME = :tirestime, TRANSACTIONKEY1 = :transactionkey1, STATICKEY1 = :statickey1, NARRATIVE1 = :narrative1, NARRATIVE2 = :narrative2, ISRESUBMITTED = :isresubmitted, RESUBMITTEDCOUNT = :resubmittedcount, RESUBMITTEDTIME = :resubmittedtime, DESCRIPTION = :description, TYPEFLAG = :typeflag, NODE = :node, VALUEDATE = :valuedate, NUMBER1 = :number1 WHERE SERVICELOG_BK_id = :servicelogBkId")
    public int update(@BindBean ServicelogBk servicelogbk);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM SERVICELOG_BK WHERE SERVICELOG_BK_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM SERVICELOG_BK")
    public long countAll();

    /**
     * Bulk insert multiple ServicelogBk entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SERVICELOG_BK (ID, SERVICE, OPERATION, ZONE, BRANCH, SOURCESYSTEM, TARGETSYSTEM, MASTERREFERENCE, EVENTREFERENCE, STATUS, PROCESSTIME, TIREQUEST, TIRESPONSE, BANKREQUEST, BANKRESPONSE, TIREQTIME, BANKREQTIME, BANKRESTIME, TIRESTIME, TRANSACTIONKEY1, STATICKEY1, NARRATIVE1, NARRATIVE2, ISRESUBMITTED, RESUBMITTEDCOUNT, RESUBMITTEDTIME, DESCRIPTION, TYPEFLAG, NODE, VALUEDATE, NUMBER1) VALUES (:id, :service, :operation, :zone, :branch, :sourcesystem, :targetsystem, :masterreference, :eventreference, :status, :processtime, :tirequest, :tiresponse, :bankrequest, :bankresponse, :tireqtime, :bankreqtime, :bankrestime, :tirestime, :transactionkey1, :statickey1, :narrative1, :narrative2, :isresubmitted, :resubmittedcount, :resubmittedtime, :description, :typeflag, :node, :valuedate, :number1)")
    public int[] bulkInsert(@BindBean List<ServicelogBk> servicelogbks);

    /**
     * Bulk update multiple ServicelogBk entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SERVICELOG_BK SET ID = :id, SERVICE = :service, OPERATION = :operation, ZONE = :zone, BRANCH = :branch, SOURCESYSTEM = :sourcesystem, TARGETSYSTEM = :targetsystem, MASTERREFERENCE = :masterreference, EVENTREFERENCE = :eventreference, STATUS = :status, PROCESSTIME = :processtime, TIREQUEST = :tirequest, TIRESPONSE = :tiresponse, BANKREQUEST = :bankrequest, BANKRESPONSE = :bankresponse, TIREQTIME = :tireqtime, BANKREQTIME = :bankreqtime, BANKRESTIME = :bankrestime, TIRESTIME = :tirestime, TRANSACTIONKEY1 = :transactionkey1, STATICKEY1 = :statickey1, NARRATIVE1 = :narrative1, NARRATIVE2 = :narrative2, ISRESUBMITTED = :isresubmitted, RESUBMITTEDCOUNT = :resubmittedcount, RESUBMITTEDTIME = :resubmittedtime, DESCRIPTION = :description, TYPEFLAG = :typeflag, NODE = :node, VALUEDATE = :valuedate, NUMBER1 = :number1 WHERE SERVICELOG_BK_id = :servicelogBkId")
    public int[] bulkUpdate(@BindBean List<ServicelogBk> servicelogbks);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM SERVICELOG_BK WHERE SERVICELOG_BK_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM SERVICELOG_BK WHERE SERVICELOG_BK_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple ServicelogBk records by their IDs.
     */
    @SqlQuery("SELECT * FROM SERVICELOG_BK WHERE SERVICELOG_BK_id IN (<ids>)")
    @RegisterBeanMapper(ServicelogBk.class)
    public List<ServicelogBk> findByIds(@BindList("ids") Collection<Integer> ids);
}
