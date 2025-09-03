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
import com.bsit.codegeneration.entity.Cvpf;

public interface CvpfDao {

    /**
     * Inserts a new Cvpf and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO CVPF (CVYOC, CVCCY, CVCNA, CVCLD, CVDIW, CVDIY, CVDOO, MNT_IN_BO) VALUES (:cvyoc, :cvccy, :cvcna, :cvcld, :cvdiw, :cvdiy, :cvdoo, :mntInBo)")
    public int insert(@BindBean Cvpf cvpf);

    /**
     * Finds a Cvpf by its ID.
     */
    @SqlQuery("SELECT * FROM CVPF WHERE CVPF_id = :id")
    @RegisterBeanMapper(Cvpf.class)
    public Optional<Cvpf> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM CVPF")
    @RegisterBeanMapper(Cvpf.class)
    public List<Cvpf> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM CVPF ORDER BY CVPF_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Cvpf.class)
    public List<Cvpf> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Cvpf and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE CVPF SET CVYOC = :cvyoc, CVCCY = :cvccy, CVCNA = :cvcna, CVCLD = :cvcld, CVDIW = :cvdiw, CVDIY = :cvdiy, CVDOO = :cvdoo, MNT_IN_BO = :mntInBo WHERE CVPF_id = :cvpfId")
    public int update(@BindBean Cvpf cvpf);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM CVPF WHERE CVPF_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM CVPF")
    public long countAll();

    /**
     * Bulk insert multiple Cvpf entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO CVPF (CVYOC, CVCCY, CVCNA, CVCLD, CVDIW, CVDIY, CVDOO, MNT_IN_BO) VALUES (:cvyoc, :cvccy, :cvcna, :cvcld, :cvdiw, :cvdiy, :cvdoo, :mntInBo)")
    public int[] bulkInsert(@BindBean List<Cvpf> cvpfs);

    /**
     * Bulk update multiple Cvpf entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE CVPF SET CVYOC = :cvyoc, CVCCY = :cvccy, CVCNA = :cvcna, CVCLD = :cvcld, CVDIW = :cvdiw, CVDIY = :cvdiy, CVDOO = :cvdoo, MNT_IN_BO = :mntInBo WHERE CVPF_id = :cvpfId")
    public int[] bulkUpdate(@BindBean List<Cvpf> cvpfs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM CVPF WHERE CVPF_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM CVPF WHERE CVPF_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Cvpf records by their IDs.
     */
    @SqlQuery("SELECT * FROM CVPF WHERE CVPF_id IN (<ids>)")
    @RegisterBeanMapper(Cvpf.class)
    public List<Cvpf> findByIds(@BindList("ids") Collection<Integer> ids);
}
