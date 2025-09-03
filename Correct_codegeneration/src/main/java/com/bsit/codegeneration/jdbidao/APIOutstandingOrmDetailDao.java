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
import com.bsit.codegeneration.entity.APIOutstandingOrmDetail;

public interface APIOutstandingOrmDetailDao {

    /**
     * Inserts a new APIOutstandingOrmDetail and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO API_OUTSTANDING_ORM_DETAIL (ORM_NUMBER, AD_CODE, REMITTANCE_AMOUNT, REMITTANCE_UTILIZED_AMOUNT, REMITTANCE_UNUTILIZED_AMOUNT, REMITTANCE_CURRENCY, REMITTANCE_DATE, IE_NAME, IE_CODE, BENEFICIARY_NAME, BENEFICIARY_COUNTRY, PURPOSE_OF_REMITTANCE) VALUES (:ormNumber, :adCode, :remittanceAmount, :remittanceUtilizedAmount, :remittanceUnutilizedAmount, :remittanceCurrency, :remittanceDate, :ieName, :ieCode, :beneficiaryName, :beneficiaryCountry, :purposeOfRemittance)")
    public int insert(@BindBean APIOutstandingOrmDetail apioutstandingormdetail);

    /**
     * Finds a APIOutstandingOrmDetail by its ID.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_ORM_DETAIL WHERE API_OUTSTANDING_ORM_DETAIL_id = :id")
    @RegisterBeanMapper(APIOutstandingOrmDetail.class)
    public Optional<APIOutstandingOrmDetail> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_ORM_DETAIL")
    @RegisterBeanMapper(APIOutstandingOrmDetail.class)
    public List<APIOutstandingOrmDetail> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_ORM_DETAIL ORDER BY API_OUTSTANDING_ORM_DETAIL_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(APIOutstandingOrmDetail.class)
    public List<APIOutstandingOrmDetail> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a APIOutstandingOrmDetail and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE API_OUTSTANDING_ORM_DETAIL SET ORM_NUMBER = :ormNumber, AD_CODE = :adCode, REMITTANCE_AMOUNT = :remittanceAmount, REMITTANCE_UTILIZED_AMOUNT = :remittanceUtilizedAmount, REMITTANCE_UNUTILIZED_AMOUNT = :remittanceUnutilizedAmount, REMITTANCE_CURRENCY = :remittanceCurrency, REMITTANCE_DATE = :remittanceDate, IE_NAME = :ieName, IE_CODE = :ieCode, BENEFICIARY_NAME = :beneficiaryName, BENEFICIARY_COUNTRY = :beneficiaryCountry, PURPOSE_OF_REMITTANCE = :purposeOfRemittance WHERE API_OUTSTANDING_ORM_DETAIL_id = :APIOutstandingOrmDetailId")
    public int update(@BindBean APIOutstandingOrmDetail apioutstandingormdetail);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM API_OUTSTANDING_ORM_DETAIL WHERE API_OUTSTANDING_ORM_DETAIL_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM API_OUTSTANDING_ORM_DETAIL")
    public long countAll();

    /**
     * Bulk insert multiple APIOutstandingOrmDetail entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO API_OUTSTANDING_ORM_DETAIL (ORM_NUMBER, AD_CODE, REMITTANCE_AMOUNT, REMITTANCE_UTILIZED_AMOUNT, REMITTANCE_UNUTILIZED_AMOUNT, REMITTANCE_CURRENCY, REMITTANCE_DATE, IE_NAME, IE_CODE, BENEFICIARY_NAME, BENEFICIARY_COUNTRY, PURPOSE_OF_REMITTANCE) VALUES (:ormNumber, :adCode, :remittanceAmount, :remittanceUtilizedAmount, :remittanceUnutilizedAmount, :remittanceCurrency, :remittanceDate, :ieName, :ieCode, :beneficiaryName, :beneficiaryCountry, :purposeOfRemittance)")
    public int[] bulkInsert(@BindBean List<APIOutstandingOrmDetail> apioutstandingormdetails);

    /**
     * Bulk update multiple APIOutstandingOrmDetail entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE API_OUTSTANDING_ORM_DETAIL SET ORM_NUMBER = :ormNumber, AD_CODE = :adCode, REMITTANCE_AMOUNT = :remittanceAmount, REMITTANCE_UTILIZED_AMOUNT = :remittanceUtilizedAmount, REMITTANCE_UNUTILIZED_AMOUNT = :remittanceUnutilizedAmount, REMITTANCE_CURRENCY = :remittanceCurrency, REMITTANCE_DATE = :remittanceDate, IE_NAME = :ieName, IE_CODE = :ieCode, BENEFICIARY_NAME = :beneficiaryName, BENEFICIARY_COUNTRY = :beneficiaryCountry, PURPOSE_OF_REMITTANCE = :purposeOfRemittance WHERE API_OUTSTANDING_ORM_DETAIL_id = :APIOutstandingOrmDetailId")
    public int[] bulkUpdate(@BindBean List<APIOutstandingOrmDetail> apioutstandingormdetails);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM API_OUTSTANDING_ORM_DETAIL WHERE API_OUTSTANDING_ORM_DETAIL_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM API_OUTSTANDING_ORM_DETAIL WHERE API_OUTSTANDING_ORM_DETAIL_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple APIOutstandingOrmDetail records by their IDs.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_ORM_DETAIL WHERE API_OUTSTANDING_ORM_DETAIL_id IN (<ids>)")
    @RegisterBeanMapper(APIOutstandingOrmDetail.class)
    public List<APIOutstandingOrmDetail> findByIds(@BindList("ids") Collection<Integer> ids);
}
