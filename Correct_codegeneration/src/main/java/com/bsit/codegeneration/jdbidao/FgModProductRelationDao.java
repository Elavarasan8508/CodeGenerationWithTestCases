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
import com.bsit.codegeneration.entity.FgModProductRelation;

public interface FgModProductRelationDao {

    /**
     * Inserts a new FgModProductRelation and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_PRODUCT_RELATION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, SRC_REF_ID, SRC_TYPE_CODE, SRC_SUB_TYPE_CODE, SRC_RELATION_CODE, SRC_APPLICANT_PARTY_ROLE, SRC_APPLICANT_PARTY_CODE, SRC_ISSUING_PARTY_ROLE, SRC_ISSUING_PARTY_CODE, TRG_REF_ID, TRG_TYPE_CODE, TRG_SUB_TYPE_CODE, TRG_RELATION_CODE, TRG_APPLICANT_PARTY_ROLE, TRG_APPLICANT_PARTY_CODE, TRG_ISSUING_PARTY_ROLE, TRG_ISSUING_PARTY_CODE, TRG_FORM_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SRC_VERSION_ID, TRG_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :srcRefId, :srcTypeCode, :srcSubTypeCode, :srcRelationCode, :srcApplicantPartyRole, :srcApplicantPartyCode, :srcIssuingPartyRole, :srcIssuingPartyCode, :trgRefId, :trgTypeCode, :trgSubTypeCode, :trgRelationCode, :trgApplicantPartyRole, :trgApplicantPartyCode, :trgIssuingPartyRole, :trgIssuingPartyCode, :trgFormId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :srcVersionId, :trgVersionId)")
    public int insert(@BindBean FgModProductRelation fgmodproductrelation);

    /**
     * Finds a FgModProductRelation by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_RELATION WHERE ID = :id")
    @RegisterBeanMapper(FgModProductRelation.class)
    public Optional<FgModProductRelation> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_RELATION")
    @RegisterBeanMapper(FgModProductRelation.class)
    public List<FgModProductRelation> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_RELATION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModProductRelation.class)
    public List<FgModProductRelation> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModProductRelation and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_PRODUCT_RELATION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, SRC_REF_ID = :srcRefId, SRC_TYPE_CODE = :srcTypeCode, SRC_SUB_TYPE_CODE = :srcSubTypeCode, SRC_RELATION_CODE = :srcRelationCode, SRC_APPLICANT_PARTY_ROLE = :srcApplicantPartyRole, SRC_APPLICANT_PARTY_CODE = :srcApplicantPartyCode, SRC_ISSUING_PARTY_ROLE = :srcIssuingPartyRole, SRC_ISSUING_PARTY_CODE = :srcIssuingPartyCode, TRG_REF_ID = :trgRefId, TRG_TYPE_CODE = :trgTypeCode, TRG_SUB_TYPE_CODE = :trgSubTypeCode, TRG_RELATION_CODE = :trgRelationCode, TRG_APPLICANT_PARTY_ROLE = :trgApplicantPartyRole, TRG_APPLICANT_PARTY_CODE = :trgApplicantPartyCode, TRG_ISSUING_PARTY_ROLE = :trgIssuingPartyRole, TRG_ISSUING_PARTY_CODE = :trgIssuingPartyCode, TRG_FORM_ID = :trgFormId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, SRC_VERSION_ID = :srcVersionId, TRG_VERSION_ID = :trgVersionId WHERE ID = :id")
    public int update(@BindBean FgModProductRelation fgmodproductrelation);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_PRODUCT_RELATION WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_PRODUCT_RELATION")
    public long countAll();

    /**
     * Bulk insert multiple FgModProductRelation entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_PRODUCT_RELATION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, SRC_REF_ID, SRC_TYPE_CODE, SRC_SUB_TYPE_CODE, SRC_RELATION_CODE, SRC_APPLICANT_PARTY_ROLE, SRC_APPLICANT_PARTY_CODE, SRC_ISSUING_PARTY_ROLE, SRC_ISSUING_PARTY_CODE, TRG_REF_ID, TRG_TYPE_CODE, TRG_SUB_TYPE_CODE, TRG_RELATION_CODE, TRG_APPLICANT_PARTY_ROLE, TRG_APPLICANT_PARTY_CODE, TRG_ISSUING_PARTY_ROLE, TRG_ISSUING_PARTY_CODE, TRG_FORM_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SRC_VERSION_ID, TRG_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :srcRefId, :srcTypeCode, :srcSubTypeCode, :srcRelationCode, :srcApplicantPartyRole, :srcApplicantPartyCode, :srcIssuingPartyRole, :srcIssuingPartyCode, :trgRefId, :trgTypeCode, :trgSubTypeCode, :trgRelationCode, :trgApplicantPartyRole, :trgApplicantPartyCode, :trgIssuingPartyRole, :trgIssuingPartyCode, :trgFormId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :srcVersionId, :trgVersionId)")
    public int[] bulkInsert(@BindBean List<FgModProductRelation> fgmodproductrelations);

    /**
     * Bulk update multiple FgModProductRelation entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_PRODUCT_RELATION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, SRC_REF_ID = :srcRefId, SRC_TYPE_CODE = :srcTypeCode, SRC_SUB_TYPE_CODE = :srcSubTypeCode, SRC_RELATION_CODE = :srcRelationCode, SRC_APPLICANT_PARTY_ROLE = :srcApplicantPartyRole, SRC_APPLICANT_PARTY_CODE = :srcApplicantPartyCode, SRC_ISSUING_PARTY_ROLE = :srcIssuingPartyRole, SRC_ISSUING_PARTY_CODE = :srcIssuingPartyCode, TRG_REF_ID = :trgRefId, TRG_TYPE_CODE = :trgTypeCode, TRG_SUB_TYPE_CODE = :trgSubTypeCode, TRG_RELATION_CODE = :trgRelationCode, TRG_APPLICANT_PARTY_ROLE = :trgApplicantPartyRole, TRG_APPLICANT_PARTY_CODE = :trgApplicantPartyCode, TRG_ISSUING_PARTY_ROLE = :trgIssuingPartyRole, TRG_ISSUING_PARTY_CODE = :trgIssuingPartyCode, TRG_FORM_ID = :trgFormId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, SRC_VERSION_ID = :srcVersionId, TRG_VERSION_ID = :trgVersionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgModProductRelation> fgmodproductrelations);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_PRODUCT_RELATION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_PRODUCT_RELATION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgModProductRelation records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_RELATION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgModProductRelation.class)
    public List<FgModProductRelation> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
