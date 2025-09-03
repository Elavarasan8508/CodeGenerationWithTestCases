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
import com.bsit.codegeneration.entity.Gfpf;

public interface GfpfDao {

    /**
     * Inserts a new Gfpf and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO GFPF (IE_CODE, CIF) VALUES (:ieCode, :cif)")
    public int insert(@Bind("ieCode") String ieCode, @Bind("cif") String cif);

    /**
     * Finds a Gfpf by its ID.
     */
    @SqlQuery("SELECT * FROM GFPF WHERE GFPF_id = :id")
    @RegisterBeanMapper(Gfpf.class)
    public Optional<Gfpf> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM GFPF")
    @RegisterBeanMapper(Gfpf.class)
    public List<Gfpf> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM GFPF ORDER BY GFPF_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Gfpf.class)
    public List<Gfpf> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Gfpf and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE GFPF SET IE_CODE = :ieCode, CIF = :cif WHERE GFPF_id = :gfpfId")
    public int update(@BindBean Gfpf gfpf);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM GFPF WHERE GFPF_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM GFPF")
    public long countAll();

    /**
     * Bulk insert multiple Gfpf entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO GFPF (IE_CODE, CIF) VALUES (:ieCode, :cif)")
    public int[] bulkInsert(@BindBean List<Gfpf> gfpfs);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO GFPF (IE_CODE, CIF) VALUES (:ieCode, :cif)")
    public int[] bulkInsertParams(@Bind("ieCode") List<String> ieCodes, @Bind("cif") List<String> cifs);

    /**
     * Bulk update multiple Gfpf entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE GFPF SET IE_CODE = :ieCode, CIF = :cif WHERE GFPF_id = :gfpfId")
    public int[] bulkUpdate(@BindBean List<Gfpf> gfpfs);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE GFPF SET IE_CODE = :ieCode, CIF = :cif WHERE GFPF_id = :gfpfId")
    public int[] bulkUpdateParams(@Bind("ieCode") List<String> ieCodes, @Bind("cif") List<String> cifs, @Bind("gfpfId") List<Integer> gfpfIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM GFPF WHERE GFPF_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM GFPF WHERE GFPF_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Gfpf records by their IDs.
     */
    @SqlQuery("SELECT * FROM GFPF WHERE GFPF_id IN (<ids>)")
    @RegisterBeanMapper(Gfpf.class)
    public List<Gfpf> findByIds(@BindList("ids") Collection<Integer> ids);
}
