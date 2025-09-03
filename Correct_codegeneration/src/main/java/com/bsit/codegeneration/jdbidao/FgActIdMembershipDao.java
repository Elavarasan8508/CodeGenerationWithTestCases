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
import com.bsit.codegeneration.entity.FgActIdMembership;

public interface FgActIdMembershipDao {

    /**
     * Inserts a new join record and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_ID_MEMBERSHIP (GROUP_ID_, USER_ID_) VALUES (:groupId, :userId)")
    public int insert(@Bind("groupId") int groupId, @Bind("userId") int userId);

    /**
     * Finds join records by groupId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_MEMBERSHIP WHERE GROUP_ID_ = :groupId")
    @RegisterBeanMapper(FgActIdMembership.class)
    public List<FgActIdMembership> findByFgActIdGroupId(@Bind("groupId") int groupId);

    /**
     * Finds join records by userId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_MEMBERSHIP WHERE USER_ID_ = :userId")
    @RegisterBeanMapper(FgActIdMembership.class)
    public List<FgActIdMembership> findByFgActIdUserId(@Bind("userId") int userId);

    /**
     * Deletes a join record and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_ID_MEMBERSHIP WHERE GROUP_ID_ = :groupId AND USER_ID_ = :userId")
    public int delete(@Bind("groupId") int groupId, @Bind("userId") int userId);

    /**
     * Bulk insert join records and returns affected row counts for each.
     */
    @SqlBatch("INSERT INTO FG_ACT_ID_MEMBERSHIP (GROUP_ID_, USER_ID_) VALUES (:groupId, :userId)")
    public int[] bulkInsert(@Bind("groupId") List<Integer> groupIds, @Bind("userId") List<Integer> userIds);

    /**
     * Bulk delete join records and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_ID_MEMBERSHIP WHERE GROUP_ID_ = :groupId AND USER_ID_ = :userId")
    public int[] bulkDelete(@Bind("groupId") List<Integer> groupIds, @Bind("userId") List<Integer> userIds);
}
