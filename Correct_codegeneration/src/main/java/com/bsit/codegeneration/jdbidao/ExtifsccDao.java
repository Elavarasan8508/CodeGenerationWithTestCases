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
import com.bsit.codegeneration.entity.Extifscc;

public interface ExtifsccDao {

    /**
     * Inserts a new Extifscc and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO EXTIFSCC (IFSCSN, IFSC, BANK, BRANCH, BRAADD, CITY, STATE, RTGS) VALUES (:ifscsn, :ifsc, :bank, :branch, :braadd, :city, :state, :rtgs)")
    public int insert(@BindBean Extifscc extifscc);

    /**
     * Finds a Extifscc by its ID.
     */
    @SqlQuery("SELECT * FROM EXTIFSCC WHERE EXTIFSCC_id = :id")
    @RegisterBeanMapper(Extifscc.class)
    public Optional<Extifscc> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM EXTIFSCC")
    @RegisterBeanMapper(Extifscc.class)
    public List<Extifscc> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM EXTIFSCC ORDER BY EXTIFSCC_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Extifscc.class)
    public List<Extifscc> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Extifscc and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE EXTIFSCC SET IFSCSN = :ifscsn, IFSC = :ifsc, BANK = :bank, BRANCH = :branch, BRAADD = :braadd, CITY = :city, STATE = :state, RTGS = :rtgs WHERE EXTIFSCC_id = :extifsccId")
    public int update(@BindBean Extifscc extifscc);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM EXTIFSCC WHERE EXTIFSCC_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM EXTIFSCC")
    public long countAll();

    /**
     * Bulk insert multiple Extifscc entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO EXTIFSCC (IFSCSN, IFSC, BANK, BRANCH, BRAADD, CITY, STATE, RTGS) VALUES (:ifscsn, :ifsc, :bank, :branch, :braadd, :city, :state, :rtgs)")
    public int[] bulkInsert(@BindBean List<Extifscc> extifsccs);

    /**
     * Bulk update multiple Extifscc entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE EXTIFSCC SET IFSCSN = :ifscsn, IFSC = :ifsc, BANK = :bank, BRANCH = :branch, BRAADD = :braadd, CITY = :city, STATE = :state, RTGS = :rtgs WHERE EXTIFSCC_id = :extifsccId")
    public int[] bulkUpdate(@BindBean List<Extifscc> extifsccs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM EXTIFSCC WHERE EXTIFSCC_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM EXTIFSCC WHERE EXTIFSCC_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Extifscc records by their IDs.
     */
    @SqlQuery("SELECT * FROM EXTIFSCC WHERE EXTIFSCC_id IN (<ids>)")
    @RegisterBeanMapper(Extifscc.class)
    public List<Extifscc> findByIds(@BindList("ids") Collection<Integer> ids);
}
