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
import com.bsit.codegeneration.entity.FgRules;

public interface FgRulesDao {

    /**
     * Inserts a new FgRules and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_RULES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, DESCRIPTION, TYPE, GUIDANCE, SEVERITY, CONDITION, CONFIG_KEY, KEY_VALUE, COUNT, COLUMN_DATA, DATA_SOURCE, DATA_SET) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name, :description, :type, :guidance, :severity, :condition, :configKey, :keyValue, :count, :columnData, :dataSource, :dataSet)")
    public int insert(@BindBean FgRules fgrules);

    /**
     * Finds a FgRules by its ID.
     */
    @SqlQuery("SELECT * FROM FG_RULES WHERE FG_RULES_id = :id")
    @RegisterBeanMapper(FgRules.class)
    public Optional<FgRules> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_RULES")
    @RegisterBeanMapper(FgRules.class)
    public List<FgRules> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_RULES ORDER BY FG_RULES_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgRules.class)
    public List<FgRules> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgRules and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_RULES SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name, DESCRIPTION = :description, TYPE = :type, GUIDANCE = :guidance, SEVERITY = :severity, CONDITION = :condition, CONFIG_KEY = :configKey, KEY_VALUE = :keyValue, COUNT = :count, COLUMN_DATA = :columnData, DATA_SOURCE = :dataSource, DATA_SET = :dataSet WHERE FG_RULES_id = :fgRulesId")
    public int update(@BindBean FgRules fgrules);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_RULES WHERE FG_RULES_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_RULES")
    public long countAll();

    /**
     * Bulk insert multiple FgRules entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_RULES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, DESCRIPTION, TYPE, GUIDANCE, SEVERITY, CONDITION, CONFIG_KEY, KEY_VALUE, COUNT, COLUMN_DATA, DATA_SOURCE, DATA_SET) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name, :description, :type, :guidance, :severity, :condition, :configKey, :keyValue, :count, :columnData, :dataSource, :dataSet)")
    public int[] bulkInsert(@BindBean List<FgRules> fgruless);

    /**
     * Bulk update multiple FgRules entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_RULES SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name, DESCRIPTION = :description, TYPE = :type, GUIDANCE = :guidance, SEVERITY = :severity, CONDITION = :condition, CONFIG_KEY = :configKey, KEY_VALUE = :keyValue, COUNT = :count, COLUMN_DATA = :columnData, DATA_SOURCE = :dataSource, DATA_SET = :dataSet WHERE FG_RULES_id = :fgRulesId")
    public int[] bulkUpdate(@BindBean List<FgRules> fgruless);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_RULES WHERE FG_RULES_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_RULES WHERE FG_RULES_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgRules records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_RULES WHERE FG_RULES_id IN (<ids>)")
    @RegisterBeanMapper(FgRules.class)
    public List<FgRules> findByIds(@BindList("ids") Collection<Integer> ids);
}
