package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.stream.Collectors;
import java.math.BigDecimal;

public class JdbcFgPartyGroupDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgPartyGroupDao.class);

    private static final String TABLE = "FG_PARTY_GROUP";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_SUB_TYPE_CODE = "PARTY_SUB_TYPE_CODE";

    private static final String COL_PARTY_CODE = "PARTY_CODE";

    private static final String COL_GROUP_ID = "GROUP_ID";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_PARENT_PARTY_CODE = "PARENT_PARTY_CODE";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_SUB_TYPE_CODE, COL_PARTY_CODE, COL_GROUP_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PARENT_PARTY_CODE, COL_REFERENCE_ID, COL_SUB_TYPE_CODE, COL_TYPE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, GROUP_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PARENT_PARTY_CODE, REFERENCE_ID, SUB_TYPE_CODE, TYPE_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, GROUP_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PARENT_PARTY_CODE, REFERENCE_ID, SUB_TYPE_CODE, TYPE_CODE", TABLE, COL_ID);

    private static final String SELECT_BY_GROUP_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, GROUP_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PARENT_PARTY_CODE, REFERENCE_ID, SUB_TYPE_CODE, TYPE_CODE", TABLE, COL_GROUP_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_SUB_TYPE_CODE, COL_PARTY_CODE, COL_GROUP_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_PARENT_PARTY_CODE, COL_REFERENCE_ID, COL_SUB_TYPE_CODE, COL_TYPE_CODE, COL_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ID);

    private static String getDbVendor(Connection conn) throws SQLException {
        String dbName = conn.getMetaData().getDatabaseProductName().toLowerCase();
        if (dbName.contains("oracle"))
            return "oracle";
        if (dbName.contains("postgres"))
            return "postgres";
        return "other";
    }

    private static <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return chunks;
    }

    public int insert(Connection conn, FgPartyGroup fgpartygroup) throws SQLException {
        logger.debug("Inserting fgpartygroup: {}", fgpartygroup);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgPartyGroupParams(ps, fgpartygroup);
            ps.executeUpdate();
            return fgpartygroup.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgPartyGroup> fgpartygroups) throws SQLException {
        if (fgpartygroups == null || fgpartygroups.isEmpty())
            return new int[0];
        for (int i = 0; i < fgpartygroups.size(); i++) {
            if (fgpartygroups.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyGroup>> batches = chunkList(fgpartygroups, batchSize);
        int[] totalResults = new int[fgpartygroups.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyGroup> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgPartyGroup fgpartygroup : batch) {
                        setFgPartyGroupParams(ps, fgpartygroup);
                        ps.addBatch();
                    }
                    int[] results = ps.executeBatch();
                    System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                    resultIndex += results.length;
                }
                conn.commit();
            }
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch insert failed", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    public FgPartyGroup findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgPartyGroup> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgPartyGroup> list = new ArrayList<>();
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        String sql = SELECT_ALL_BASE;
        if (isOracle)
            sql += " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        else
            sql += " LIMIT ? OFFSET ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (isOracle) {
                ps.setInt(1, (page - 1) * pageSize);
                ps.setInt(2, pageSize);
            } else {
                ps.setInt(1, pageSize);
                ps.setInt(2, (page - 1) * pageSize);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public boolean update(Connection conn, FgPartyGroup fgpartygroup) throws SQLException {
        if (fgpartygroup.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgPartyGroupParams(ps, fgpartygroup);
            ps.setInt(16, fgpartygroup.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgPartyGroup> fgpartygroups) throws SQLException {
        if (fgpartygroups == null || fgpartygroups.isEmpty())
            return new int[0];
        for (FgPartyGroup fgpartygroup : fgpartygroups) {
            if (fgpartygroup == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgpartygroup.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgPartyGroup>> batches = chunkList(fgpartygroups, batchSize);
        int[] totalResults = new int[fgpartygroups.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgPartyGroup> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgPartyGroup fgpartygroup : batch) {
                        setFgPartyGroupParams(ps, fgpartygroup);
                        ps.setInt(16, fgpartygroup.getID());
                        ps.addBatch();
                    }
                    int[] results = ps.executeBatch();
                    System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                    resultIndex += results.length;
                }
                conn.commit();
            }
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch update failed", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int chunkSize = isOracle ? 1000 : Integer.MAX_VALUE;
        List<List<Integer>> chunks = chunkList(ids, chunkSize);
        int[] totalResults = new int[ids.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Integer> chunk : chunks) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < chunk.size(); k++) {
                    if (k > 0)
                        sb.append(", ");
                    sb.append("?");
                }
                String placeholders = sb.toString();
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ID, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setInt(i + 1, chunk.get(i));
                    }
                    int affected = ps.executeUpdate();
                    for (int j = 0; j < affected; j++) {
                        totalResults[resultIndex++] = 1;
                    }
                }
                conn.commit();
            }
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch delete failed", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    public List<FgPartyGroup> findByGroupID(Connection conn, int groupID) throws SQLException {
        List<FgPartyGroup> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_GROUP_ID_SQL)) {
            ps.setInt(1, groupID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgPartyGroupParams(PreparedStatement ps, FgPartyGroup fgpartygroup) throws SQLException {
        Integer val1 = fgpartygroup.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, fgpartygroup.getPartySubTypeCode());
        ps.setString(3, fgpartygroup.getPartyCode());
        if (fgpartygroup.getGroup() != null) {
            ps.setInt(4, fgpartygroup.getGroup().getFgGroupID());
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, fgpartygroup.getActiveCode());
        ps.setString(6, fgpartygroup.getStatusCode());
        ps.setString(7, fgpartygroup.getCreatedOn());
        java.math.BigDecimal val8 = fgpartygroup.getCreatedBy();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fgpartygroup.getLastUpdatedOn());
        java.math.BigDecimal val10 = fgpartygroup.getLastUpdatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgpartygroup.getLastAuthorisedOn());
        java.math.BigDecimal val12 = fgpartygroup.getLastAuthorisedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgpartygroup.getParentPartyCode());
        Integer val14 = fgpartygroup.getReferenceID();
        if (val14 != null) {
            ps.setInt(14, val14);
        } else {
            ps.setNull(14, Types.INTEGER);
        }
        ps.setString(15, fgpartygroup.getSubTypeCode());
        ps.setString(16, fgpartygroup.getTypeCode());
    }

    private FgPartyGroup extract(ResultSet rs) throws SQLException {
        FgPartyGroup fgpartygroup = new FgPartyGroup();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgpartygroup.setID(ID);
        fgpartygroup.setPartySubTypeCode(rs.getString(COL_PARTY_SUB_TYPE_CODE));
        fgpartygroup.setPartyCode(rs.getString(COL_PARTY_CODE));
        Integer GROUP_ID = rs.getObject(COL_GROUP_ID, Integer.class);
        fgpartygroup.setGroupID(GROUP_ID);
        if (GROUP_ID != null) {
            FgGroup group = new FgGroup();
            group.setFgGroupID(GROUP_ID);
            fgpartygroup.setGroup(group);
        }
        fgpartygroup.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgpartygroup.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgpartygroup.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgpartygroup.setCreatedBy(CREATED_BY);
        fgpartygroup.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgpartygroup.setLastUpdatedBy(LAST_UPDATED_BY);
        fgpartygroup.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgpartygroup.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgpartygroup.setParentPartyCode(rs.getString(COL_PARENT_PARTY_CODE));
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgpartygroup.setReferenceID(REFERENCE_ID);
        fgpartygroup.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgpartygroup.setTypeCode(rs.getString(COL_TYPE_CODE));
        return fgpartygroup;
    }
}
