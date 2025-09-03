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
import com.bsit.codegeneration.entity.FgProjects;

public interface FgProjectsDao {

    /**
     * Inserts a new FgProjects and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PROJECTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROJECT_NAME, START_DATE, END_DATE, PROJECT_TITLE, DESCRIPTION, SUB_PROJECT, CATEGORY, PROCESS_ID, VERSION_ID, IS_MASTER_VERSION, ATTRIBUTE_GUARANTEE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :projectName, :startDate, :endDate, :projectTitle, :description, :subProject, :category, :processId, :versionId, :isMasterVersion, :attributeGuarantee)")
    public int insert(@BindBean FgProjects fgprojects);

    /**
     * Finds a FgProjects by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PROJECTS WHERE ID = :id")
    @RegisterBeanMapper(FgProjects.class)
    public Optional<FgProjects> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PROJECTS")
    @RegisterBeanMapper(FgProjects.class)
    public List<FgProjects> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PROJECTS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProjects.class)
    public List<FgProjects> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProjects and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PROJECTS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PROJECT_NAME = :projectName, START_DATE = :startDate, END_DATE = :endDate, PROJECT_TITLE = :projectTitle, DESCRIPTION = :description, SUB_PROJECT = :subProject, CATEGORY = :category, PROCESS_ID = :processId, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, ATTRIBUTE_GUARANTEE = :attributeGuarantee WHERE ID = :id")
    public int update(@BindBean FgProjects fgprojects);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PROJECTS WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PROJECTS")
    public long countAll();

    /**
     * Bulk insert multiple FgProjects entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PROJECTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROJECT_NAME, START_DATE, END_DATE, PROJECT_TITLE, DESCRIPTION, SUB_PROJECT, CATEGORY, PROCESS_ID, VERSION_ID, IS_MASTER_VERSION, ATTRIBUTE_GUARANTEE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :projectName, :startDate, :endDate, :projectTitle, :description, :subProject, :category, :processId, :versionId, :isMasterVersion, :attributeGuarantee)")
    public int[] bulkInsert(@BindBean List<FgProjects> fgprojectss);

    /**
     * Bulk update multiple FgProjects entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PROJECTS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PROJECT_NAME = :projectName, START_DATE = :startDate, END_DATE = :endDate, PROJECT_TITLE = :projectTitle, DESCRIPTION = :description, SUB_PROJECT = :subProject, CATEGORY = :category, PROCESS_ID = :processId, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, ATTRIBUTE_GUARANTEE = :attributeGuarantee WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgProjects> fgprojectss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PROJECTS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PROJECTS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgProjects records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PROJECTS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgProjects.class)
    public List<FgProjects> findByIds(@BindList("ids") Collection<String> ids);
}
