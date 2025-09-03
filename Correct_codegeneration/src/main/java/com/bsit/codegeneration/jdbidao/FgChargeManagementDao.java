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
import com.bsit.codegeneration.entity.FgChargeManagement;

public interface FgChargeManagementDao {

    /**
     * Inserts a new FgChargeManagement and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_CHARGE_MANAGEMENT (ID, REFERENCE_ID, VERSION_ID, PARTY_CODE, PARTY_SUB_TYPE_CODE, PRODUCT_CODE, EVENT_CODE, CATEGORY_CODE, CHARGE_TYPE_CODE, CHARGE_STATUS_CODE, CHARGE_CODE, CURRENCY_CODE, TAX_CODE, CHARGE_BASIS_CODE, IS_RECURRING, VALID_FROM, VALID_TO, CHARGE_AMOUNT, UOM_CODE, LIMIT_AMOUNT, FREE_LIMIT, LIMIT_PERIOD_CODE, CHARGE_PERCENTAGE, STATUS_CODE, ACTIVE_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE) VALUES (:id, :referenceId, :versionId, :partyCode, :partySubTypeCode, :productCode, :eventCode, :categoryCode, :chargeTypeCode, :chargeStatusCode, :chargeCode, :currencyCode, :taxCode, :chargeBasisCode, :isRecurring, :validFrom, :validTo, :chargeAmount, :uomCode, :limitAmount, :freeLimit, :limitPeriodCode, :chargePercentage, :statusCode, :activeCode, :lastAuthorisedOn, :lastAuthorisedBy, :template)")
    public int insert(@BindBean FgChargeManagement fgchargemanagement);

    /**
     * Finds a FgChargeManagement by its ID.
     */
    @SqlQuery("SELECT * FROM FG_CHARGE_MANAGEMENT WHERE FG_CHARGE_MANAGEMENT_id = :id")
    @RegisterBeanMapper(FgChargeManagement.class)
    public Optional<FgChargeManagement> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_CHARGE_MANAGEMENT")
    @RegisterBeanMapper(FgChargeManagement.class)
    public List<FgChargeManagement> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_CHARGE_MANAGEMENT ORDER BY FG_CHARGE_MANAGEMENT_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgChargeManagement.class)
    public List<FgChargeManagement> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgChargeManagement and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_CHARGE_MANAGEMENT SET ID = :id, REFERENCE_ID = :referenceId, VERSION_ID = :versionId, PARTY_CODE = :partyCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PRODUCT_CODE = :productCode, EVENT_CODE = :eventCode, CATEGORY_CODE = :categoryCode, CHARGE_TYPE_CODE = :chargeTypeCode, CHARGE_STATUS_CODE = :chargeStatusCode, CHARGE_CODE = :chargeCode, CURRENCY_CODE = :currencyCode, TAX_CODE = :taxCode, CHARGE_BASIS_CODE = :chargeBasisCode, IS_RECURRING = :isRecurring, VALID_FROM = :validFrom, VALID_TO = :validTo, CHARGE_AMOUNT = :chargeAmount, UOM_CODE = :uomCode, LIMIT_AMOUNT = :limitAmount, FREE_LIMIT = :freeLimit, LIMIT_PERIOD_CODE = :limitPeriodCode, CHARGE_PERCENTAGE = :chargePercentage, STATUS_CODE = :statusCode, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template WHERE FG_CHARGE_MANAGEMENT_id = :fgChargeManagementId")
    public int update(@BindBean FgChargeManagement fgchargemanagement);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CHARGE_MANAGEMENT WHERE FG_CHARGE_MANAGEMENT_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_CHARGE_MANAGEMENT")
    public long countAll();

    /**
     * Bulk insert multiple FgChargeManagement entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_CHARGE_MANAGEMENT (ID, REFERENCE_ID, VERSION_ID, PARTY_CODE, PARTY_SUB_TYPE_CODE, PRODUCT_CODE, EVENT_CODE, CATEGORY_CODE, CHARGE_TYPE_CODE, CHARGE_STATUS_CODE, CHARGE_CODE, CURRENCY_CODE, TAX_CODE, CHARGE_BASIS_CODE, IS_RECURRING, VALID_FROM, VALID_TO, CHARGE_AMOUNT, UOM_CODE, LIMIT_AMOUNT, FREE_LIMIT, LIMIT_PERIOD_CODE, CHARGE_PERCENTAGE, STATUS_CODE, ACTIVE_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE) VALUES (:id, :referenceId, :versionId, :partyCode, :partySubTypeCode, :productCode, :eventCode, :categoryCode, :chargeTypeCode, :chargeStatusCode, :chargeCode, :currencyCode, :taxCode, :chargeBasisCode, :isRecurring, :validFrom, :validTo, :chargeAmount, :uomCode, :limitAmount, :freeLimit, :limitPeriodCode, :chargePercentage, :statusCode, :activeCode, :lastAuthorisedOn, :lastAuthorisedBy, :template)")
    public int[] bulkInsert(@BindBean List<FgChargeManagement> fgchargemanagements);

    /**
     * Bulk update multiple FgChargeManagement entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_CHARGE_MANAGEMENT SET ID = :id, REFERENCE_ID = :referenceId, VERSION_ID = :versionId, PARTY_CODE = :partyCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PRODUCT_CODE = :productCode, EVENT_CODE = :eventCode, CATEGORY_CODE = :categoryCode, CHARGE_TYPE_CODE = :chargeTypeCode, CHARGE_STATUS_CODE = :chargeStatusCode, CHARGE_CODE = :chargeCode, CURRENCY_CODE = :currencyCode, TAX_CODE = :taxCode, CHARGE_BASIS_CODE = :chargeBasisCode, IS_RECURRING = :isRecurring, VALID_FROM = :validFrom, VALID_TO = :validTo, CHARGE_AMOUNT = :chargeAmount, UOM_CODE = :uomCode, LIMIT_AMOUNT = :limitAmount, FREE_LIMIT = :freeLimit, LIMIT_PERIOD_CODE = :limitPeriodCode, CHARGE_PERCENTAGE = :chargePercentage, STATUS_CODE = :statusCode, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template WHERE FG_CHARGE_MANAGEMENT_id = :fgChargeManagementId")
    public int[] bulkUpdate(@BindBean List<FgChargeManagement> fgchargemanagements);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CHARGE_MANAGEMENT WHERE FG_CHARGE_MANAGEMENT_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_CHARGE_MANAGEMENT WHERE FG_CHARGE_MANAGEMENT_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgChargeManagement records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_CHARGE_MANAGEMENT WHERE FG_CHARGE_MANAGEMENT_id IN (<ids>)")
    @RegisterBeanMapper(FgChargeManagement.class)
    public List<FgChargeManagement> findByIds(@BindList("ids") Collection<Integer> ids);
}
