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
import com.bsit.codegeneration.entity.FgIdpmsOrmGroupedInv;

public interface FgIdpmsOrmGroupedInvDao {

    /**
     * Inserts a new FgIdpmsOrmGroupedInv and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_IDPMS_ORM_GROUPED_INV (INV_NUM, UTIL_AMT, ENDORSED_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TEMPLATE, ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:invNum, :utilAmt, :endorsedAmt, :parentRefId, :parentVersionId, :isTemplate, :template, :id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgIdpmsOrmGroupedInv fgidpmsormgroupedinv);

    /**
     * Finds a FgIdpmsOrmGroupedInv by its ID.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_ORM_GROUPED_INV WHERE FG_IDPMS_ORM_GROUPED_INV_id = :id")
    @RegisterBeanMapper(FgIdpmsOrmGroupedInv.class)
    public Optional<FgIdpmsOrmGroupedInv> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_ORM_GROUPED_INV")
    @RegisterBeanMapper(FgIdpmsOrmGroupedInv.class)
    public List<FgIdpmsOrmGroupedInv> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_ORM_GROUPED_INV ORDER BY FG_IDPMS_ORM_GROUPED_INV_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgIdpmsOrmGroupedInv.class)
    public List<FgIdpmsOrmGroupedInv> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgIdpmsOrmGroupedInv and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_IDPMS_ORM_GROUPED_INV SET INV_NUM = :invNum, UTIL_AMT = :utilAmt, ENDORSED_AMT = :endorsedAmt, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TEMPLATE = :template, ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_IDPMS_ORM_GROUPED_INV_id = :fgIdpmsOrmGroupedInvId")
    public int update(@BindBean FgIdpmsOrmGroupedInv fgidpmsormgroupedinv);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_IDPMS_ORM_GROUPED_INV WHERE FG_IDPMS_ORM_GROUPED_INV_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_IDPMS_ORM_GROUPED_INV")
    public long countAll();

    /**
     * Bulk insert multiple FgIdpmsOrmGroupedInv entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_IDPMS_ORM_GROUPED_INV (INV_NUM, UTIL_AMT, ENDORSED_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TEMPLATE, ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:invNum, :utilAmt, :endorsedAmt, :parentRefId, :parentVersionId, :isTemplate, :template, :id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgIdpmsOrmGroupedInv> fgidpmsormgroupedinvs);

    /**
     * Bulk update multiple FgIdpmsOrmGroupedInv entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_IDPMS_ORM_GROUPED_INV SET INV_NUM = :invNum, UTIL_AMT = :utilAmt, ENDORSED_AMT = :endorsedAmt, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TEMPLATE = :template, ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_IDPMS_ORM_GROUPED_INV_id = :fgIdpmsOrmGroupedInvId")
    public int[] bulkUpdate(@BindBean List<FgIdpmsOrmGroupedInv> fgidpmsormgroupedinvs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_IDPMS_ORM_GROUPED_INV WHERE FG_IDPMS_ORM_GROUPED_INV_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_IDPMS_ORM_GROUPED_INV WHERE FG_IDPMS_ORM_GROUPED_INV_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgIdpmsOrmGroupedInv records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_ORM_GROUPED_INV WHERE FG_IDPMS_ORM_GROUPED_INV_id IN (<ids>)")
    @RegisterBeanMapper(FgIdpmsOrmGroupedInv.class)
    public List<FgIdpmsOrmGroupedInv> findByIds(@BindList("ids") Collection<Integer> ids);
}
