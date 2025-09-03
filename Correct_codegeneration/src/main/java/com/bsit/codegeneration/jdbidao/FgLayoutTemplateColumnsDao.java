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
import com.bsit.codegeneration.entity.FgLayoutTemplateColumns;

public interface FgLayoutTemplateColumnsDao {

    /**
     * Inserts a new FgLayoutTemplateColumns and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_LAYOUT_TEMPLATE_COLUMNS (ID, NAME, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE_COLUMNS) VALUES (:id, :name, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :templateColumns)")
    public int insert(@BindBean FgLayoutTemplateColumns fglayouttemplatecolumns);

    /**
     * Finds a FgLayoutTemplateColumns by its ID.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_COLUMNS WHERE ID = :id")
    @RegisterBeanMapper(FgLayoutTemplateColumns.class)
    public Optional<FgLayoutTemplateColumns> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_COLUMNS")
    @RegisterBeanMapper(FgLayoutTemplateColumns.class)
    public List<FgLayoutTemplateColumns> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_COLUMNS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgLayoutTemplateColumns.class)
    public List<FgLayoutTemplateColumns> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgLayoutTemplateColumns and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_LAYOUT_TEMPLATE_COLUMNS SET NAME = :name, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE_COLUMNS = :templateColumns WHERE ID = :id")
    public int update(@BindBean FgLayoutTemplateColumns fglayouttemplatecolumns);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_TEMPLATE_COLUMNS WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_LAYOUT_TEMPLATE_COLUMNS")
    public long countAll();

    /**
     * Bulk insert multiple FgLayoutTemplateColumns entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_LAYOUT_TEMPLATE_COLUMNS (ID, NAME, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE_COLUMNS) VALUES (:id, :name, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :templateColumns)")
    public int[] bulkInsert(@BindBean List<FgLayoutTemplateColumns> fglayouttemplatecolumnss);

    /**
     * Bulk update multiple FgLayoutTemplateColumns entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_LAYOUT_TEMPLATE_COLUMNS SET NAME = :name, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE_COLUMNS = :templateColumns WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgLayoutTemplateColumns> fglayouttemplatecolumnss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_TEMPLATE_COLUMNS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_LAYOUT_TEMPLATE_COLUMNS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgLayoutTemplateColumns records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_COLUMNS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgLayoutTemplateColumns.class)
    public List<FgLayoutTemplateColumns> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
