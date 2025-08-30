package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.batch.SqlBatch;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import java.util.List;
import java.util.Optional;
import java.util.Collection;
import com.bsit.codegeneration.entity.Language;

public interface LanguageDao {

    /**
     * Inserts a new Language and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO language (name) VALUES (:name)")
    @GetGeneratedKeys
    public int insert(@Bind("name") String name);

    /**
     * Finds a Language by its ID.
     */
    @SqlQuery("SELECT * FROM language WHERE language_id = :id")
    @RegisterBeanMapper(Language.class)
    public Optional<Language> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM language")
    @RegisterBeanMapper(Language.class)
    public List<Language> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM language ORDER BY language_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Language.class)
    public List<Language> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Language and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE language SET name = :name WHERE language_id = :languageId")
    public int update(@BindBean Language language);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM language WHERE language_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM language")
    public long countAll();

    /**
     * Bulk insert multiple Language entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO language (name) VALUES (:name)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Language> languages);

    /**
     * Bulk insert with individual parameter lists and returns generated IDs.
     */
    @SqlBatch("INSERT INTO language (name) VALUES (:name)")
    @GetGeneratedKeys
    public int[] bulkInsertParams(@Bind("name") List<String> names);

    /**
     * Bulk update multiple Language entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE language SET name = :name WHERE language_id = :languageId")
    public int[] bulkUpdate(@BindBean List<Language> languages);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE language SET name = :name WHERE language_id = :languageId")
    public int[] bulkUpdateParams(@Bind("name") List<String> names, @Bind("languageId") List<Integer> languageIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM language WHERE language_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM language WHERE language_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Language records by their IDs.
     */
    @SqlQuery("SELECT * FROM language WHERE language_id IN (<ids>)")
    @RegisterBeanMapper(Language.class)
    public List<Language> findByIds(@Bind("ids") Collection<Integer> ids);
}
