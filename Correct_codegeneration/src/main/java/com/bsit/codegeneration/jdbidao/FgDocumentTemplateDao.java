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
import com.bsit.codegeneration.entity.FgDocumentTemplate;

public interface FgDocumentTemplateDao {

    /**
     * Inserts a new FgDocumentTemplate and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_DOCUMENT_TEMPLATE (ID, REFERENCE_ID, NAME, TYPE_CODE, SUB_TYPE_CODE, IS_DEFAULT, PURPOSE_CODE, RENDER_TYPE_CODE, DESCRIPTION, TEMPLATE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :referenceId, :name, :typeCode, :subTypeCode, :isDefault, :purposeCode, :renderTypeCode, :description, :template, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgDocumentTemplate fgdocumenttemplate);

    /**
     * Finds a FgDocumentTemplate by its ID.
     */
    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE WHERE ID = :id")
    @RegisterBeanMapper(FgDocumentTemplate.class)
    public Optional<FgDocumentTemplate> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE")
    @RegisterBeanMapper(FgDocumentTemplate.class)
    public List<FgDocumentTemplate> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgDocumentTemplate.class)
    public List<FgDocumentTemplate> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgDocumentTemplate and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_DOCUMENT_TEMPLATE SET REFERENCE_ID = :referenceId, NAME = :name, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, IS_DEFAULT = :isDefault, PURPOSE_CODE = :purposeCode, RENDER_TYPE_CODE = :renderTypeCode, DESCRIPTION = :description, TEMPLATE = :template, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgDocumentTemplate fgdocumenttemplate);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DOCUMENT_TEMPLATE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_DOCUMENT_TEMPLATE")
    public long countAll();

    /**
     * Bulk insert multiple FgDocumentTemplate entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_DOCUMENT_TEMPLATE (ID, REFERENCE_ID, NAME, TYPE_CODE, SUB_TYPE_CODE, IS_DEFAULT, PURPOSE_CODE, RENDER_TYPE_CODE, DESCRIPTION, TEMPLATE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :referenceId, :name, :typeCode, :subTypeCode, :isDefault, :purposeCode, :renderTypeCode, :description, :template, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgDocumentTemplate> fgdocumenttemplates);

    /**
     * Bulk update multiple FgDocumentTemplate entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_DOCUMENT_TEMPLATE SET REFERENCE_ID = :referenceId, NAME = :name, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, IS_DEFAULT = :isDefault, PURPOSE_CODE = :purposeCode, RENDER_TYPE_CODE = :renderTypeCode, DESCRIPTION = :description, TEMPLATE = :template, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgDocumentTemplate> fgdocumenttemplates);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DOCUMENT_TEMPLATE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_DOCUMENT_TEMPLATE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgDocumentTemplate records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_DOCUMENT_TEMPLATE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgDocumentTemplate.class)
    public List<FgDocumentTemplate> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
