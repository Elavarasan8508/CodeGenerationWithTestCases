package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.DateDimension;
import com.bsit.codegeneration.mapper.DateDimensionMapper;
import java.util.*;

@RegisterRowMapper(DateDimensionMapper.class)
public interface DateDimensionDao {

    @SqlQuery("SELECT * FROM DATE_DIMENSION")
    public List<DateDimension> findAll();

    @SqlQuery("SELECT * FROM DATE_DIMENSION WHERE id = :id")
    public Optional<DateDimension> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO DATE_DIMENSION(PRESENT_DATE, GENERICENDDATERANGE, YEAR, MONTH_NUM, DATE_DD, WEEK_DAY, WEEK, GENERICWEEKDAYSTARTONMONDAY, DAY, DAY_SHORT, MONTH, MONTH_SHORT, GENERICWEEKNUMBER, QUARTER, GENERICLASTDAY, GENERICNUMBERCONSTANT, GENERICDATECOUNTER) VALUES (:PRESENT_DATE, :GENERICENDDATERANGE, :YEAR, :MONTH_NUM, :DATE_DD, :WEEK_DAY, :WEEK, :GENERICWEEKDAYSTARTONMONDAY, :DAY, :DAY_SHORT, :MONTH, :MONTH_SHORT, :GENERICWEEKNUMBER, :QUARTER, :GENERICLASTDAY, :GENERICNUMBERCONSTANT, :GENERICDATECOUNTER)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() DateDimension entity);

    @SqlQuery("UPDATE DATE_DIMENSION SET PRESENT_DATE = :PRESENT_DATE, GENERICENDDATERANGE = :GENERICENDDATERANGE, YEAR = :YEAR, MONTH_NUM = :MONTH_NUM, DATE_DD = :DATE_DD, WEEK_DAY = :WEEK_DAY, WEEK = :WEEK, GENERICWEEKDAYSTARTONMONDAY = :GENERICWEEKDAYSTARTONMONDAY, DAY = :DAY, DAY_SHORT = :DAY_SHORT, MONTH = :MONTH, MONTH_SHORT = :MONTH_SHORT, GENERICWEEKNUMBER = :GENERICWEEKNUMBER, QUARTER = :QUARTER, GENERICLASTDAY = :GENERICLASTDAY, GENERICNUMBERCONSTANT = :GENERICNUMBERCONSTANT, GENERICDATECOUNTER = :GENERICDATECOUNTER WHERE id = :id")
    public int update(@BindBean() DateDimension entity);

    @SqlQuery("DELETE FROM DATE_DIMENSION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
