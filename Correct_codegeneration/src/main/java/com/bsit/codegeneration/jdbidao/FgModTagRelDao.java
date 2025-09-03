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
import com.bsit.codegeneration.entity.FgModTagRel;

public interface FgModTagRelDao {

    /**
     * Inserts a new FgModTagRel and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_TAG_REL (ID, TAG_REFERENCE_NO, TARGET_ENTITY_TYPE_CODE, TARGET_ENTITY_SUB_TYPE_CODE, TARGET_ENTITY_REF_NO, TARGET_ENTITY_VERSIONID, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :tagReferenceNo, :targetEntityTypeCode, :targetEntitySubTypeCode, :targetEntityRefNo, :targetEntityVersionid, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int insert(@BindBean FgModTagRel fgmodtagrel);

    /**
     * Finds a FgModTagRel by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_TAG_REL WHERE FG_MOD_TAG_REL_id = :id")
    @RegisterBeanMapper(FgModTagRel.class)
    public Optional<FgModTagRel> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_TAG_REL")
    @RegisterBeanMapper(FgModTagRel.class)
    public List<FgModTagRel> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_TAG_REL ORDER BY FG_MOD_TAG_REL_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModTagRel.class)
    public List<FgModTagRel> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModTagRel and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_TAG_REL SET ID = :id, TAG_REFERENCE_NO = :tagReferenceNo, TARGET_ENTITY_TYPE_CODE = :targetEntityTypeCode, TARGET_ENTITY_SUB_TYPE_CODE = :targetEntitySubTypeCode, TARGET_ENTITY_REF_NO = :targetEntityRefNo, TARGET_ENTITY_VERSIONID = :targetEntityVersionid, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_MOD_TAG_REL_id = :fgModTagRelId")
    public int update(@BindBean FgModTagRel fgmodtagrel);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_TAG_REL WHERE FG_MOD_TAG_REL_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_TAG_REL")
    public long countAll();

    /**
     * Bulk insert multiple FgModTagRel entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_TAG_REL (ID, TAG_REFERENCE_NO, TARGET_ENTITY_TYPE_CODE, TARGET_ENTITY_SUB_TYPE_CODE, TARGET_ENTITY_REF_NO, TARGET_ENTITY_VERSIONID, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :tagReferenceNo, :targetEntityTypeCode, :targetEntitySubTypeCode, :targetEntityRefNo, :targetEntityVersionid, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int[] bulkInsert(@BindBean List<FgModTagRel> fgmodtagrels);

    /**
     * Bulk update multiple FgModTagRel entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_TAG_REL SET ID = :id, TAG_REFERENCE_NO = :tagReferenceNo, TARGET_ENTITY_TYPE_CODE = :targetEntityTypeCode, TARGET_ENTITY_SUB_TYPE_CODE = :targetEntitySubTypeCode, TARGET_ENTITY_REF_NO = :targetEntityRefNo, TARGET_ENTITY_VERSIONID = :targetEntityVersionid, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_MOD_TAG_REL_id = :fgModTagRelId")
    public int[] bulkUpdate(@BindBean List<FgModTagRel> fgmodtagrels);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_TAG_REL WHERE FG_MOD_TAG_REL_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_TAG_REL WHERE FG_MOD_TAG_REL_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgModTagRel records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_TAG_REL WHERE FG_MOD_TAG_REL_id IN (<ids>)")
    @RegisterBeanMapper(FgModTagRel.class)
    public List<FgModTagRel> findByIds(@BindList("ids") Collection<Integer> ids);
}
