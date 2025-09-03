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
import com.bsit.codegeneration.entity.FgDocumentTemplateParty;

public interface FgDocumentTemplatePartyDao {

    /**
     * Inserts a new FgDocumentTemplateParty and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_DOCUMENT_TEMPLATE_PARTY (ID, PARTY_ID, PARTY_VERSION_ID, DOCUMENT_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :partyId, :partyVersionId, :documentId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgDocumentTemplateParty fgdocumenttemplateparty);

    /**
     * Finds a FgDocumentTemplateParty by its ID.
     */
    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE_PARTY WHERE ID = :id")
    @RegisterBeanMapper(FgDocumentTemplateParty.class)
    public Optional<FgDocumentTemplateParty> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE_PARTY")
    @RegisterBeanMapper(FgDocumentTemplateParty.class)
    public List<FgDocumentTemplateParty> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE_PARTY ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgDocumentTemplateParty.class)
    public List<FgDocumentTemplateParty> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgDocumentTemplateParty and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_DOCUMENT_TEMPLATE_PARTY SET PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, DOCUMENT_ID = :documentId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgDocumentTemplateParty fgdocumenttemplateparty);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DOCUMENT_TEMPLATE_PARTY WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_DOCUMENT_TEMPLATE_PARTY")
    public long countAll();

    /**
     * Bulk insert multiple FgDocumentTemplateParty entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_DOCUMENT_TEMPLATE_PARTY (ID, PARTY_ID, PARTY_VERSION_ID, DOCUMENT_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :partyId, :partyVersionId, :documentId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgDocumentTemplateParty> fgdocumenttemplatepartys);

    /**
     * Bulk update multiple FgDocumentTemplateParty entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_DOCUMENT_TEMPLATE_PARTY SET PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, DOCUMENT_ID = :documentId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgDocumentTemplateParty> fgdocumenttemplatepartys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DOCUMENT_TEMPLATE_PARTY WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_DOCUMENT_TEMPLATE_PARTY WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgDocumentTemplateParty records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE_PARTY WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgDocumentTemplateParty.class)
    public List<FgDocumentTemplateParty> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgDocumentTemplateParty records by documentId.
     */
    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE_PARTY WHERE DOCUMENT_ID = :documentId")
    @RegisterBeanMapper(FgDocumentTemplateParty.class)
    public List<FgDocumentTemplateParty> findByDocumentId(@Bind("documentId") int documentId);
}
