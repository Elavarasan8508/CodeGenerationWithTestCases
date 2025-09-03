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
import com.bsit.codegeneration.entity.FgUploadEntityAttribute;

public interface FgUploadEntityAttributeDao {

    /**
     * Inserts a new FgUploadEntityAttribute and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_UPLOAD_ENTITY_ATTRIBUTE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, REL_CATEGORY, REL_ENTITY_TYPE, REL_ENTITY_REF_NO, REL_ENTY_REF_VERSION, REL_ATTRIBUTE_TYPE, REL_ATTRIBUTE_KEY, REL_ATTRIBUTE_VALUE, UPLOAD_REF_NO, REL_ENTITY_SUB_TYPE, REL_ENTITY_ATTRIBUTE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :relCategory, :relEntityType, :relEntityRefNo, :relEntyRefVersion, :relAttributeType, :relAttributeKey, :relAttributeValue, :uploadRefNo, :relEntitySubType, :relEntityAttribute)")
    public int insert(@BindBean FgUploadEntityAttribute fguploadentityattribute);

    /**
     * Finds a FgUploadEntityAttribute by its ID.
     */
    @SqlQuery("SELECT * FROM FG_UPLOAD_ENTITY_ATTRIBUTE WHERE ID = :id")
    @RegisterBeanMapper(FgUploadEntityAttribute.class)
    public Optional<FgUploadEntityAttribute> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_UPLOAD_ENTITY_ATTRIBUTE")
    @RegisterBeanMapper(FgUploadEntityAttribute.class)
    public List<FgUploadEntityAttribute> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_UPLOAD_ENTITY_ATTRIBUTE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgUploadEntityAttribute.class)
    public List<FgUploadEntityAttribute> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgUploadEntityAttribute and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_UPLOAD_ENTITY_ATTRIBUTE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, REL_CATEGORY = :relCategory, REL_ENTITY_TYPE = :relEntityType, REL_ENTITY_REF_NO = :relEntityRefNo, REL_ENTY_REF_VERSION = :relEntyRefVersion, REL_ATTRIBUTE_TYPE = :relAttributeType, REL_ATTRIBUTE_KEY = :relAttributeKey, REL_ATTRIBUTE_VALUE = :relAttributeValue, UPLOAD_REF_NO = :uploadRefNo, REL_ENTITY_SUB_TYPE = :relEntitySubType, REL_ENTITY_ATTRIBUTE = :relEntityAttribute WHERE ID = :id")
    public int update(@BindBean FgUploadEntityAttribute fguploadentityattribute);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_UPLOAD_ENTITY_ATTRIBUTE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_UPLOAD_ENTITY_ATTRIBUTE")
    public long countAll();

    /**
     * Bulk insert multiple FgUploadEntityAttribute entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_UPLOAD_ENTITY_ATTRIBUTE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, REL_CATEGORY, REL_ENTITY_TYPE, REL_ENTITY_REF_NO, REL_ENTY_REF_VERSION, REL_ATTRIBUTE_TYPE, REL_ATTRIBUTE_KEY, REL_ATTRIBUTE_VALUE, UPLOAD_REF_NO, REL_ENTITY_SUB_TYPE, REL_ENTITY_ATTRIBUTE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :relCategory, :relEntityType, :relEntityRefNo, :relEntyRefVersion, :relAttributeType, :relAttributeKey, :relAttributeValue, :uploadRefNo, :relEntitySubType, :relEntityAttribute)")
    public int[] bulkInsert(@BindBean List<FgUploadEntityAttribute> fguploadentityattributes);

    /**
     * Bulk update multiple FgUploadEntityAttribute entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_UPLOAD_ENTITY_ATTRIBUTE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, REL_CATEGORY = :relCategory, REL_ENTITY_TYPE = :relEntityType, REL_ENTITY_REF_NO = :relEntityRefNo, REL_ENTY_REF_VERSION = :relEntyRefVersion, REL_ATTRIBUTE_TYPE = :relAttributeType, REL_ATTRIBUTE_KEY = :relAttributeKey, REL_ATTRIBUTE_VALUE = :relAttributeValue, UPLOAD_REF_NO = :uploadRefNo, REL_ENTITY_SUB_TYPE = :relEntitySubType, REL_ENTITY_ATTRIBUTE = :relEntityAttribute WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgUploadEntityAttribute> fguploadentityattributes);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_UPLOAD_ENTITY_ATTRIBUTE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_UPLOAD_ENTITY_ATTRIBUTE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgUploadEntityAttribute records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_UPLOAD_ENTITY_ATTRIBUTE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgUploadEntityAttribute.class)
    public List<FgUploadEntityAttribute> findByIds(@BindList("ids") Collection<String> ids);
}
