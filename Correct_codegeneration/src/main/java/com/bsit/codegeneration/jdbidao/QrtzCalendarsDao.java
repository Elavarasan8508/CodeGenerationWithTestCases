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
import com.bsit.codegeneration.entity.QrtzCalendars;

public interface QrtzCalendarsDao {

    /**
     * Inserts a new QrtzCalendars and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO QRTZ_CALENDARS (SCHED_NAME, CALENDAR_NAME, CALENDAR) VALUES (:schedName, :calendarName, :calendar)")
    public int insert(@Bind("schedName") String schedName, @Bind("calendarName") String calendarName, @Bind("calendar") byte[] calendar);

    /**
     * Finds a QrtzCalendars by its ID.
     */
    @SqlQuery("SELECT * FROM QRTZ_CALENDARS WHERE SCHED_NAME = :id")
    @RegisterBeanMapper(QrtzCalendars.class)
    public Optional<QrtzCalendars> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM QRTZ_CALENDARS")
    @RegisterBeanMapper(QrtzCalendars.class)
    public List<QrtzCalendars> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM QRTZ_CALENDARS ORDER BY SCHED_NAME LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(QrtzCalendars.class)
    public List<QrtzCalendars> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a QrtzCalendars and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE QRTZ_CALENDARS SET CALENDAR = :calendar WHERE SCHED_NAME = :schedName")
    public int update(@BindBean QrtzCalendars qrtzcalendars);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_CALENDARS WHERE SCHED_NAME = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM QRTZ_CALENDARS")
    public long countAll();

    /**
     * Bulk insert multiple QrtzCalendars entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_CALENDARS (SCHED_NAME, CALENDAR_NAME, CALENDAR) VALUES (:schedName, :calendarName, :calendar)")
    public int[] bulkInsert(@BindBean List<QrtzCalendars> qrtzcalendarss);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_CALENDARS (SCHED_NAME, CALENDAR_NAME, CALENDAR) VALUES (:schedName, :calendarName, :calendar)")
    public int[] bulkInsertParams(@Bind("schedName") List<String> schedNames, @Bind("calendarName") List<String> calendarNames, @Bind("calendar") List<byte[]> calendars);

    /**
     * Bulk update multiple QrtzCalendars entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_CALENDARS SET CALENDAR = :calendar WHERE SCHED_NAME = :schedName")
    public int[] bulkUpdate(@BindBean List<QrtzCalendars> qrtzcalendarss);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_CALENDARS SET CALENDAR = :calendar WHERE SCHED_NAME = :schedName")
    public int[] bulkUpdateParams(@Bind("calendar") List<byte[]> calendars, @Bind("schedName") List<String> schedNames);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_CALENDARS WHERE SCHED_NAME IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM QRTZ_CALENDARS WHERE SCHED_NAME = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple QrtzCalendars records by their IDs.
     */
    @SqlQuery("SELECT * FROM QRTZ_CALENDARS WHERE SCHED_NAME IN (<ids>)")
    @RegisterBeanMapper(QrtzCalendars.class)
    public List<QrtzCalendars> findByIds(@BindList("ids") Collection<String> ids);
}
