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
import com.bsit.codegeneration.entity.GtpXchRates;

public interface GtpXchRatesDao {

    /**
     * Inserts a new GtpXchRates and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO GTP_XCH_RATES (BANK_ABBV_NAME, ISO_CODE, BASE_ISO_CODE, BRCH_CODE, BUY_TT_RATE, EURO_IN_CURRENCY, EURO_RATE, MID_TT_RATE, PATY_VAL, SELL_TT_RATE, UPDATE_DATE, START_VALUE_DATE, END_VALUE_DATE) VALUES (:bankAbbvName, :isoCode, :baseIsoCode, :brchCode, :buyTtRate, :euroInCurrency, :euroRate, :midTtRate, :patyVal, :sellTtRate, :updateDate, :startValueDate, :endValueDate)")
    public int insert(@BindBean GtpXchRates gtpxchrates);

    /**
     * Finds a GtpXchRates by its ID.
     */
    @SqlQuery("SELECT * FROM GTP_XCH_RATES WHERE ISO_CODE = :id")
    @RegisterBeanMapper(GtpXchRates.class)
    public Optional<GtpXchRates> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM GTP_XCH_RATES")
    @RegisterBeanMapper(GtpXchRates.class)
    public List<GtpXchRates> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM GTP_XCH_RATES ORDER BY ISO_CODE LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(GtpXchRates.class)
    public List<GtpXchRates> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a GtpXchRates and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE GTP_XCH_RATES SET BRCH_CODE = :brchCode, BUY_TT_RATE = :buyTtRate, EURO_IN_CURRENCY = :euroInCurrency, EURO_RATE = :euroRate, MID_TT_RATE = :midTtRate, PATY_VAL = :patyVal, SELL_TT_RATE = :sellTtRate, UPDATE_DATE = :updateDate, START_VALUE_DATE = :startValueDate, END_VALUE_DATE = :endValueDate WHERE ISO_CODE = :isoCode")
    public int update(@BindBean GtpXchRates gtpxchrates);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM GTP_XCH_RATES WHERE ISO_CODE = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM GTP_XCH_RATES")
    public long countAll();

    /**
     * Bulk insert multiple GtpXchRates entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO GTP_XCH_RATES (BANK_ABBV_NAME, ISO_CODE, BASE_ISO_CODE, BRCH_CODE, BUY_TT_RATE, EURO_IN_CURRENCY, EURO_RATE, MID_TT_RATE, PATY_VAL, SELL_TT_RATE, UPDATE_DATE, START_VALUE_DATE, END_VALUE_DATE) VALUES (:bankAbbvName, :isoCode, :baseIsoCode, :brchCode, :buyTtRate, :euroInCurrency, :euroRate, :midTtRate, :patyVal, :sellTtRate, :updateDate, :startValueDate, :endValueDate)")
    public int[] bulkInsert(@BindBean List<GtpXchRates> gtpxchratess);

    /**
     * Bulk update multiple GtpXchRates entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE GTP_XCH_RATES SET BRCH_CODE = :brchCode, BUY_TT_RATE = :buyTtRate, EURO_IN_CURRENCY = :euroInCurrency, EURO_RATE = :euroRate, MID_TT_RATE = :midTtRate, PATY_VAL = :patyVal, SELL_TT_RATE = :sellTtRate, UPDATE_DATE = :updateDate, START_VALUE_DATE = :startValueDate, END_VALUE_DATE = :endValueDate WHERE ISO_CODE = :isoCode")
    public int[] bulkUpdate(@BindBean List<GtpXchRates> gtpxchratess);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM GTP_XCH_RATES WHERE ISO_CODE IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM GTP_XCH_RATES WHERE ISO_CODE = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple GtpXchRates records by their IDs.
     */
    @SqlQuery("SELECT * FROM GTP_XCH_RATES WHERE ISO_CODE IN (<ids>)")
    @RegisterBeanMapper(GtpXchRates.class)
    public List<GtpXchRates> findByIds(@BindList("ids") Collection<String> ids);
}
