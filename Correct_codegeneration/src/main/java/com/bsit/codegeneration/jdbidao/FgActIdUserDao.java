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
import com.bsit.codegeneration.entity.FgActIdUser;

public interface FgActIdUserDao {

    /**
     * Inserts a new FgActIdUser and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_ID_USER (ID_, REV_, FIRST_, LAST_, EMAIL_, PWD_, SALT_, PICTURE_ID_, LOCK_EXP_TIME_, ATTEMPTS_) VALUES (:id, :rev, :first, :last, :email, :pwd, :salt, :pictureId, :lockExpTime, :attempts)")
    public int insert(@BindBean FgActIdUser fgactiduser);

    /**
     * Finds a FgActIdUser by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_USER WHERE ID_ = :id")
    @RegisterBeanMapper(FgActIdUser.class)
    public Optional<FgActIdUser> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_USER")
    @RegisterBeanMapper(FgActIdUser.class)
    public List<FgActIdUser> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_USER ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActIdUser.class)
    public List<FgActIdUser> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActIdUser and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_ID_USER SET REV_ = :rev, FIRST_ = :first, LAST_ = :last, EMAIL_ = :email, PWD_ = :pwd, SALT_ = :salt, PICTURE_ID_ = :pictureId, LOCK_EXP_TIME_ = :lockExpTime, ATTEMPTS_ = :attempts WHERE ID_ = :id")
    public int update(@BindBean FgActIdUser fgactiduser);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_ID_USER WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_ID_USER")
    public long countAll();

    /**
     * Bulk insert multiple FgActIdUser entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_ID_USER (ID_, REV_, FIRST_, LAST_, EMAIL_, PWD_, SALT_, PICTURE_ID_, LOCK_EXP_TIME_, ATTEMPTS_) VALUES (:id, :rev, :first, :last, :email, :pwd, :salt, :pictureId, :lockExpTime, :attempts)")
    public int[] bulkInsert(@BindBean List<FgActIdUser> fgactidusers);

    /**
     * Bulk update multiple FgActIdUser entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_ID_USER SET REV_ = :rev, FIRST_ = :first, LAST_ = :last, EMAIL_ = :email, PWD_ = :pwd, SALT_ = :salt, PICTURE_ID_ = :pictureId, LOCK_EXP_TIME_ = :lockExpTime, ATTEMPTS_ = :attempts WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActIdUser> fgactidusers);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_ID_USER WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_ID_USER WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActIdUser records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_USER WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActIdUser.class)
    public List<FgActIdUser> findByIds(@BindList("ids") Collection<String> ids);
}
