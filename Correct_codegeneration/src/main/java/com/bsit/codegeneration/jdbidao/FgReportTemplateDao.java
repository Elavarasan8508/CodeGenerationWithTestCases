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
import com.bsit.codegeneration.entity.FgReportTemplate;

public interface FgReportTemplateDao {

    /**
     * Inserts a new FgReportTemplate and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_REPORT_TEMPLATE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, PARTY_CODE, TEMPLATE_TYPE, REPORT_TYPE, FILE_NAME, FILE_TYPE, FILE_SIZE, TEMPLATE_VALUE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, NAME, ATTACHMENT_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :partyCode, :templateType, :reportType, :fileName, :fileType, :fileSize, :templateValue, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :name, :attachmentId)")
    public int insert(@BindBean FgReportTemplate fgreporttemplate);

    /**
     * Finds a FgReportTemplate by its ID.
     */
    @SqlQuery("SELECT * FROM FG_REPORT_TEMPLATE WHERE ID = :id")
    @RegisterBeanMapper(FgReportTemplate.class)
    public Optional<FgReportTemplate> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_REPORT_TEMPLATE")
    @RegisterBeanMapper(FgReportTemplate.class)
    public List<FgReportTemplate> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_REPORT_TEMPLATE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgReportTemplate.class)
    public List<FgReportTemplate> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgReportTemplate and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_REPORT_TEMPLATE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PARTY_CODE = :partyCode, TEMPLATE_TYPE = :templateType, REPORT_TYPE = :reportType, FILE_NAME = :fileName, FILE_TYPE = :fileType, FILE_SIZE = :fileSize, TEMPLATE_VALUE = :templateValue, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, NAME = :name, ATTACHMENT_ID = :attachmentId WHERE ID = :id")
    public int update(@BindBean FgReportTemplate fgreporttemplate);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_REPORT_TEMPLATE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_REPORT_TEMPLATE")
    public long countAll();

    /**
     * Bulk insert multiple FgReportTemplate entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_REPORT_TEMPLATE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, PARTY_CODE, TEMPLATE_TYPE, REPORT_TYPE, FILE_NAME, FILE_TYPE, FILE_SIZE, TEMPLATE_VALUE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, NAME, ATTACHMENT_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :partyCode, :templateType, :reportType, :fileName, :fileType, :fileSize, :templateValue, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :name, :attachmentId)")
    public int[] bulkInsert(@BindBean List<FgReportTemplate> fgreporttemplates);

    /**
     * Bulk update multiple FgReportTemplate entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_REPORT_TEMPLATE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PARTY_CODE = :partyCode, TEMPLATE_TYPE = :templateType, REPORT_TYPE = :reportType, FILE_NAME = :fileName, FILE_TYPE = :fileType, FILE_SIZE = :fileSize, TEMPLATE_VALUE = :templateValue, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, NAME = :name, ATTACHMENT_ID = :attachmentId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgReportTemplate> fgreporttemplates);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_REPORT_TEMPLATE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_REPORT_TEMPLATE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgReportTemplate records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_REPORT_TEMPLATE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgReportTemplate.class)
    public List<FgReportTemplate> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
