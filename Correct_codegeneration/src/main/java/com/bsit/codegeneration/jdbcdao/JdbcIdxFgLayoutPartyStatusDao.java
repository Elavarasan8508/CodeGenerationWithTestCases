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

public class JdbcIdxFgLayoutPartyStatusDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcIdxFgLayoutPartyStatusDao.class);

    private static final String TABLE = "IDX_FG_LAYOUT_PARTY_STATUS";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_LAYOUT_ID = "LAYOUT_ID";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_LAYOUT_VERSION_ID = "LAYOUT_VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_LAYOUT_ID, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_LAYOUT_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, LAYOUT_ID, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, LAYOUT_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, LAYOUT_ID, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, LAYOUT_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_BY_LAYOUT_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, LAYOUT_ID, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, LAYOUT_VERSION_ID", TABLE, COL_LAYOUT_ID);

    private static final String SELECT_BY_LAYOUT_VERSION_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, LAYOUT_ID, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, LAYOUT_VERSION_ID", TABLE, COL_LAYOUT_VERSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_LAYOUT_ID, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_LAYOUT_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, IdxFgLayoutPartyStatus idxfglayoutpartystatus) throws SQLException {
        logger.debug("Inserting idxfglayoutpartystatus: {}", idxfglayoutpartystatus);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setIdxFgLayoutPartyStatusParams(ps, idxfglayoutpartystatus);
            ps.executeUpdate();
            return idxfglayoutpartystatus.getID();
        }
    }

    public int[] insertAll(Connection conn, List<IdxFgLayoutPartyStatus> idxfglayoutpartystatuss) throws SQLException {
        if (idxfglayoutpartystatuss == null || idxfglayoutpartystatuss.isEmpty())
            return new int[0];
        for (int i = 0; i < idxfglayoutpartystatuss.size(); i++) {
            if (idxfglayoutpartystatuss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<IdxFgLayoutPartyStatus>> batches = chunkList(idxfglayoutpartystatuss, batchSize);
        int[] totalResults = new int[idxfglayoutpartystatuss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<IdxFgLayoutPartyStatus> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (IdxFgLayoutPartyStatus idxfglayoutpartystatus : batch) {
                        setIdxFgLayoutPartyStatusParams(ps, idxfglayoutpartystatus);
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

    public IdxFgLayoutPartyStatus findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<IdxFgLayoutPartyStatus> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<IdxFgLayoutPartyStatus> list = new ArrayList<>();
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

    public boolean update(Connection conn, IdxFgLayoutPartyStatus idxfglayoutpartystatus) throws SQLException {
        if (idxfglayoutpartystatus.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setIdxFgLayoutPartyStatusParams(ps, idxfglayoutpartystatus);
            ps.setInt(15, idxfglayoutpartystatus.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<IdxFgLayoutPartyStatus> idxfglayoutpartystatuss) throws SQLException {
        if (idxfglayoutpartystatuss == null || idxfglayoutpartystatuss.isEmpty())
            return new int[0];
        for (IdxFgLayoutPartyStatus idxfglayoutpartystatus : idxfglayoutpartystatuss) {
            if (idxfglayoutpartystatus == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (idxfglayoutpartystatus.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<IdxFgLayoutPartyStatus>> batches = chunkList(idxfglayoutpartystatuss, batchSize);
        int[] totalResults = new int[idxfglayoutpartystatuss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<IdxFgLayoutPartyStatus> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (IdxFgLayoutPartyStatus idxfglayoutpartystatus : batch) {
                        setIdxFgLayoutPartyStatusParams(ps, idxfglayoutpartystatus);
                        ps.setInt(15, idxfglayoutpartystatus.getID());
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

    public List<IdxFgLayoutPartyStatus> findByLayoutID(Connection conn, int layoutID) throws SQLException {
        List<IdxFgLayoutPartyStatus> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_LAYOUT_ID_SQL)) {
            ps.setInt(1, layoutID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<IdxFgLayoutPartyStatus> findByLayoutVersionID(Connection conn, int layoutVersionID) throws SQLException {
        List<IdxFgLayoutPartyStatus> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_LAYOUT_VERSION_ID_SQL)) {
            ps.setInt(1, layoutVersionID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setIdxFgLayoutPartyStatusParams(PreparedStatement ps, IdxFgLayoutPartyStatus idxfglayoutpartystatus) throws SQLException {
        Integer val1 = idxfglayoutpartystatus.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = idxfglayoutpartystatus.getPartyID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = idxfglayoutpartystatus.getPartyVersionID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        if (idxfglayoutpartystatus.getLayout() != null) {
            ps.setInt(4, idxfglayoutpartystatus.getLayout().getFgLayoutTemplateID());
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, idxfglayoutpartystatus.getDescription());
        ps.setString(6, idxfglayoutpartystatus.getActiveCode());
        ps.setString(7, idxfglayoutpartystatus.getStatusCode());
        ps.setString(8, idxfglayoutpartystatus.getCreatedOn());
        java.math.BigDecimal val9 = idxfglayoutpartystatus.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, idxfglayoutpartystatus.getLastUpdatedOn());
        java.math.BigDecimal val11 = idxfglayoutpartystatus.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, idxfglayoutpartystatus.getLastAuthorisedOn());
        java.math.BigDecimal val13 = idxfglayoutpartystatus.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, idxfglayoutpartystatus.getTemplate());
        if (idxfglayoutpartystatus.getLayoutVersion() != null) {
            ps.setInt(15, idxfglayoutpartystatus.getLayoutVersion().getFgLayoutTemplateID());
        } else {
            ps.setNull(15, Types.INTEGER);
        }
    }

    private IdxFgLayoutPartyStatus extract(ResultSet rs) throws SQLException {
        IdxFgLayoutPartyStatus idxfglayoutpartystatus = new IdxFgLayoutPartyStatus();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        idxfglayoutpartystatus.setID(ID);
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        idxfglayoutpartystatus.setPartyID(PARTY_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        idxfglayoutpartystatus.setPartyVersionID(PARTY_VERSION_ID);
        Integer LAYOUT_ID = rs.getObject(COL_LAYOUT_ID, Integer.class);
        idxfglayoutpartystatus.setLayoutID(LAYOUT_ID);
        if (LAYOUT_ID != null) {
            FgLayoutTemplate layout = new FgLayoutTemplate();
            layout.setFgLayoutTemplateID(LAYOUT_ID);
            idxfglayoutpartystatus.setLayout(layout);
        }
        idxfglayoutpartystatus.setDescription(rs.getString(COL_DESCRIPTION));
        idxfglayoutpartystatus.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        idxfglayoutpartystatus.setStatusCode(rs.getString(COL_STATUS_CODE));
        idxfglayoutpartystatus.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        idxfglayoutpartystatus.setCreatedBy(CREATED_BY);
        idxfglayoutpartystatus.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        idxfglayoutpartystatus.setLastUpdatedBy(LAST_UPDATED_BY);
        idxfglayoutpartystatus.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        idxfglayoutpartystatus.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        idxfglayoutpartystatus.setTemplate(rs.getString(COL_TEMPLATE));
        Integer LAYOUT_VERSION_ID = rs.getObject(COL_LAYOUT_VERSION_ID, Integer.class);
        idxfglayoutpartystatus.setLayoutVersionID(LAYOUT_VERSION_ID);
        if (LAYOUT_VERSION_ID != null) {
            FgLayoutTemplate layoutVersion = new FgLayoutTemplate();
            layoutVersion.setFgLayoutTemplateID(LAYOUT_VERSION_ID);
            idxfglayoutpartystatus.setLayoutVersion(layoutVersion);
        }
        return idxfglayoutpartystatus;
    }
}
