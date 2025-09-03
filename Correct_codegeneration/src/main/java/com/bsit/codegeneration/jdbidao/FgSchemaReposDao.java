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
import com.bsit.codegeneration.entity.FgSchemaRepos;

public interface FgSchemaReposDao {

    /**
     * Inserts a new FgSchemaRepos and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SCHEMA_REPOS (FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, REFERENCE_ID, CATEGORY, CONTENT, ID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, STAGE_CODE, APPLICANT_PARTY_CODE) VALUES (:fileExtension, :fileType, :name, :template, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :referenceId, :category, :content, :id, :categoryType, :categorySubType, :tags, :stageCode, :applicantPartyCode)")
    public int insert(@BindBean FgSchemaRepos fgschemarepos);

    /**
     * Finds a FgSchemaRepos by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SCHEMA_REPOS WHERE FG_SCHEMA_REPOS_id = :id")
    @RegisterBeanMapper(FgSchemaRepos.class)
    public Optional<FgSchemaRepos> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SCHEMA_REPOS")
    @RegisterBeanMapper(FgSchemaRepos.class)
    public List<FgSchemaRepos> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SCHEMA_REPOS ORDER BY FG_SCHEMA_REPOS_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSchemaRepos.class)
    public List<FgSchemaRepos> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSchemaRepos and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SCHEMA_REPOS SET FILE_EXTENSION = :fileExtension, FILE_TYPE = :fileType, NAME = :name, TEMPLATE = :template, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, REFERENCE_ID = :referenceId, CATEGORY = :category, CONTENT = :content, ID = :id, CATEGORY_TYPE = :categoryType, CATEGORY_SUB_TYPE = :categorySubType, TAGS = :tags, STAGE_CODE = :stageCode, APPLICANT_PARTY_CODE = :applicantPartyCode WHERE FG_SCHEMA_REPOS_id = :fgSchemaReposId")
    public int update(@BindBean FgSchemaRepos fgschemarepos);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SCHEMA_REPOS WHERE FG_SCHEMA_REPOS_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SCHEMA_REPOS")
    public long countAll();

    /**
     * Bulk insert multiple FgSchemaRepos entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SCHEMA_REPOS (FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, REFERENCE_ID, CATEGORY, CONTENT, ID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, STAGE_CODE, APPLICANT_PARTY_CODE) VALUES (:fileExtension, :fileType, :name, :template, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :referenceId, :category, :content, :id, :categoryType, :categorySubType, :tags, :stageCode, :applicantPartyCode)")
    public int[] bulkInsert(@BindBean List<FgSchemaRepos> fgschemareposs);

    /**
     * Bulk update multiple FgSchemaRepos entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SCHEMA_REPOS SET FILE_EXTENSION = :fileExtension, FILE_TYPE = :fileType, NAME = :name, TEMPLATE = :template, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, REFERENCE_ID = :referenceId, CATEGORY = :category, CONTENT = :content, ID = :id, CATEGORY_TYPE = :categoryType, CATEGORY_SUB_TYPE = :categorySubType, TAGS = :tags, STAGE_CODE = :stageCode, APPLICANT_PARTY_CODE = :applicantPartyCode WHERE FG_SCHEMA_REPOS_id = :fgSchemaReposId")
    public int[] bulkUpdate(@BindBean List<FgSchemaRepos> fgschemareposs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SCHEMA_REPOS WHERE FG_SCHEMA_REPOS_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SCHEMA_REPOS WHERE FG_SCHEMA_REPOS_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgSchemaRepos records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SCHEMA_REPOS WHERE FG_SCHEMA_REPOS_id IN (<ids>)")
    @RegisterBeanMapper(FgSchemaRepos.class)
    public List<FgSchemaRepos> findByIds(@BindList("ids") Collection<Integer> ids);
}
