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
import com.bsit.codegeneration.entity.DateDimension;

public interface DateDimensionDao {

    /**
     * Inserts a new DateDimension and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO DATE_DIMENSION (PRESENT_DATE, GENERICENDDATERANGE, YEAR, MONTH_NUM, DATE_DD, WEEK_DAY, WEEK, GENERICWEEKDAYSTARTONMONDAY, DAY, DAY_SHORT, MONTH, MONTH_SHORT, GENERICWEEKNUMBER, QUARTER, GENERICLASTDAY, GENERICNUMBERCONSTANT, GENERICDATECOUNTER) VALUES (:presentDate, :genericenddaterange, :year, :monthNum, :dateDd, :weekDay, :week, :genericweekdaystartonmonday, :day, :dayShort, :month, :monthShort, :genericweeknumber, :quarter, :genericlastday, :genericnumberconstant, :genericdatecounter)")
    public int insert(@BindBean DateDimension datedimension);

    /**
     * Finds a DateDimension by its ID.
     */
    @SqlQuery("SELECT * FROM DATE_DIMENSION WHERE DATE_DIMENSION_id = :id")
    @RegisterBeanMapper(DateDimension.class)
    public Optional<DateDimension> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM DATE_DIMENSION")
    @RegisterBeanMapper(DateDimension.class)
    public List<DateDimension> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM DATE_DIMENSION ORDER BY DATE_DIMENSION_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(DateDimension.class)
    public List<DateDimension> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a DateDimension and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE DATE_DIMENSION SET PRESENT_DATE = :presentDate, GENERICENDDATERANGE = :genericenddaterange, YEAR = :year, MONTH_NUM = :monthNum, DATE_DD = :dateDd, WEEK_DAY = :weekDay, WEEK = :week, GENERICWEEKDAYSTARTONMONDAY = :genericweekdaystartonmonday, DAY = :day, DAY_SHORT = :dayShort, MONTH = :month, MONTH_SHORT = :monthShort, GENERICWEEKNUMBER = :genericweeknumber, QUARTER = :quarter, GENERICLASTDAY = :genericlastday, GENERICNUMBERCONSTANT = :genericnumberconstant, GENERICDATECOUNTER = :genericdatecounter WHERE DATE_DIMENSION_id = :dateDimensionId")
    public int update(@BindBean DateDimension datedimension);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM DATE_DIMENSION WHERE DATE_DIMENSION_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM DATE_DIMENSION")
    public long countAll();

    /**
     * Bulk insert multiple DateDimension entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO DATE_DIMENSION (PRESENT_DATE, GENERICENDDATERANGE, YEAR, MONTH_NUM, DATE_DD, WEEK_DAY, WEEK, GENERICWEEKDAYSTARTONMONDAY, DAY, DAY_SHORT, MONTH, MONTH_SHORT, GENERICWEEKNUMBER, QUARTER, GENERICLASTDAY, GENERICNUMBERCONSTANT, GENERICDATECOUNTER) VALUES (:presentDate, :genericenddaterange, :year, :monthNum, :dateDd, :weekDay, :week, :genericweekdaystartonmonday, :day, :dayShort, :month, :monthShort, :genericweeknumber, :quarter, :genericlastday, :genericnumberconstant, :genericdatecounter)")
    public int[] bulkInsert(@BindBean List<DateDimension> datedimensions);

    /**
     * Bulk update multiple DateDimension entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE DATE_DIMENSION SET PRESENT_DATE = :presentDate, GENERICENDDATERANGE = :genericenddaterange, YEAR = :year, MONTH_NUM = :monthNum, DATE_DD = :dateDd, WEEK_DAY = :weekDay, WEEK = :week, GENERICWEEKDAYSTARTONMONDAY = :genericweekdaystartonmonday, DAY = :day, DAY_SHORT = :dayShort, MONTH = :month, MONTH_SHORT = :monthShort, GENERICWEEKNUMBER = :genericweeknumber, QUARTER = :quarter, GENERICLASTDAY = :genericlastday, GENERICNUMBERCONSTANT = :genericnumberconstant, GENERICDATECOUNTER = :genericdatecounter WHERE DATE_DIMENSION_id = :dateDimensionId")
    public int[] bulkUpdate(@BindBean List<DateDimension> datedimensions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM DATE_DIMENSION WHERE DATE_DIMENSION_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM DATE_DIMENSION WHERE DATE_DIMENSION_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple DateDimension records by their IDs.
     */
    @SqlQuery("SELECT * FROM DATE_DIMENSION WHERE DATE_DIMENSION_id IN (<ids>)")
    @RegisterBeanMapper(DateDimension.class)
    public List<DateDimension> findByIds(@BindList("ids") Collection<Integer> ids);
}
