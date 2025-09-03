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
import com.bsit.codegeneration.entity.FgAddress;

public interface FgAddressDao {

    /**
     * Inserts a new FgAddress and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ADDRESS (ID, ADDRESS_LINE1, ADDRESS_LINE2, ADDRESS_LINE3, COUNTRY_CODE, STATE_CODE, CITY_CODE, LAND_MARK, POST_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, LATITUDE, LONGITUDE, SYS_DEFINED, SYSTEM_SOURCE_CODE) VALUES (:id, :addressLine1, :addressLine2, :addressLine3, :countryCode, :stateCode, :cityCode, :landMark, :postCode, :lastAuthorisedOn, :lastAuthorisedBy, :latitude, :longitude, :sysDefined, :systemSourceCode)")
    public int insert(@BindBean FgAddress fgaddress);

    /**
     * Finds a FgAddress by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ADDRESS WHERE ID = :id")
    @RegisterBeanMapper(FgAddress.class)
    public Optional<FgAddress> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ADDRESS")
    @RegisterBeanMapper(FgAddress.class)
    public List<FgAddress> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ADDRESS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAddress.class)
    public List<FgAddress> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAddress and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ADDRESS SET ADDRESS_LINE1 = :addressLine1, ADDRESS_LINE2 = :addressLine2, ADDRESS_LINE3 = :addressLine3, COUNTRY_CODE = :countryCode, STATE_CODE = :stateCode, CITY_CODE = :cityCode, LAND_MARK = :landMark, POST_CODE = :postCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, LATITUDE = :latitude, LONGITUDE = :longitude, SYS_DEFINED = :sysDefined, SYSTEM_SOURCE_CODE = :systemSourceCode WHERE ID = :id")
    public int update(@BindBean FgAddress fgaddress);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ADDRESS WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ADDRESS")
    public long countAll();

    /**
     * Bulk insert multiple FgAddress entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ADDRESS (ID, ADDRESS_LINE1, ADDRESS_LINE2, ADDRESS_LINE3, COUNTRY_CODE, STATE_CODE, CITY_CODE, LAND_MARK, POST_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, LATITUDE, LONGITUDE, SYS_DEFINED, SYSTEM_SOURCE_CODE) VALUES (:id, :addressLine1, :addressLine2, :addressLine3, :countryCode, :stateCode, :cityCode, :landMark, :postCode, :lastAuthorisedOn, :lastAuthorisedBy, :latitude, :longitude, :sysDefined, :systemSourceCode)")
    public int[] bulkInsert(@BindBean List<FgAddress> fgaddresss);

    /**
     * Bulk update multiple FgAddress entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ADDRESS SET ADDRESS_LINE1 = :addressLine1, ADDRESS_LINE2 = :addressLine2, ADDRESS_LINE3 = :addressLine3, COUNTRY_CODE = :countryCode, STATE_CODE = :stateCode, CITY_CODE = :cityCode, LAND_MARK = :landMark, POST_CODE = :postCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, LATITUDE = :latitude, LONGITUDE = :longitude, SYS_DEFINED = :sysDefined, SYSTEM_SOURCE_CODE = :systemSourceCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgAddress> fgaddresss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ADDRESS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ADDRESS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgAddress records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ADDRESS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgAddress.class)
    public List<FgAddress> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
