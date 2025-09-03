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

public class JdbcFgAuditItemDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgAuditItemDao.class);

    private static final String TABLE = "FG_AUDIT_ITEM";

    private static final String COL_UUID = "UUID";

    private static final String COL_AUDIT_MASTER_ID = "AUDIT_MASTER_ID";

    private static final String COL_OUTPUT_CONTEXT = "OUTPUT_CONTEXT";

    private static final String COL_ERROR_CONTEXT = "ERROR_CONTEXT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s)
        VALUES (?, ?, ?, ?)
        """.formatted(TABLE, COL_UUID, COL_AUDIT_MASTER_ID, COL_OUTPUT_CONTEXT, COL_ERROR_CONTEXT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("UUID, AUDIT_MASTER_ID, OUTPUT_CONTEXT, ERROR_CONTEXT", TABLE, COL_UUID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("UUID, AUDIT_MASTER_ID, OUTPUT_CONTEXT, ERROR_CONTEXT", TABLE, COL_UUID);

    private static final String SELECT_BY_AUDIT_MASTER_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("UUID, AUDIT_MASTER_ID, OUTPUT_CONTEXT, ERROR_CONTEXT", TABLE, COL_AUDIT_MASTER_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_AUDIT_MASTER_ID, COL_OUTPUT_CONTEXT, COL_ERROR_CONTEXT, COL_UUID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_UUID);

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

    public String insert(Connection conn, FgAuditItem fgaudititem) throws SQLException {
        logger.debug("Inserting fgaudititem: {}", fgaudititem);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgAuditItemParams(ps, fgaudititem);
            ps.executeUpdate();
            return fgaudititem.getUuid();
        }
    }

    public int[] insertAll(Connection conn, List<FgAuditItem> fgaudititems) throws SQLException {
        if (fgaudititems == null || fgaudititems.isEmpty())
            return new int[0];
        for (int i = 0; i < fgaudititems.size(); i++) {
            if (fgaudititems.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAuditItem>> batches = chunkList(fgaudititems, batchSize);
        int[] totalResults = new int[fgaudititems.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAuditItem> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgAuditItem fgaudititem : batch) {
                        setFgAuditItemParams(ps, fgaudititem);
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

    public FgAuditItem findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgAuditItem> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgAuditItem> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgAuditItem fgaudititem) throws SQLException {
        if (fgaudititem.getUuid() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgAuditItemParams(ps, fgaudititem);
            ps.setString(4, fgaudititem.getUuid());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgAuditItem> fgaudititems) throws SQLException {
        if (fgaudititems == null || fgaudititems.isEmpty())
            return new int[0];
        for (FgAuditItem fgaudititem : fgaudititems) {
            if (fgaudititem == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgaudititem.getUuid() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgAuditItem>> batches = chunkList(fgaudititems, batchSize);
        int[] totalResults = new int[fgaudititems.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgAuditItem> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgAuditItem fgaudititem : batch) {
                        setFgAuditItemParams(ps, fgaudititem);
                        ps.setString(4, fgaudititem.getUuid());
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

    public boolean deleteById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<String> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (String id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int chunkSize = isOracle ? 1000 : Integer.MAX_VALUE;
        List<List<String>> chunks = chunkList(ids, chunkSize);
        int[] totalResults = new int[ids.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<String> chunk : chunks) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < chunk.size(); k++) {
                    if (k > 0)
                        sb.append(", ");
                    sb.append("?");
                }
                String placeholders = sb.toString();
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_UUID, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setString(i + 1, chunk.get(i));
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

    public List<FgAuditItem> findByAuditMasterID(Connection conn, int auditMasterID) throws SQLException {
        List<FgAuditItem> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_AUDIT_MASTER_ID_SQL)) {
            ps.setInt(1, auditMasterID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgAuditItemParams(PreparedStatement ps, FgAuditItem fgaudititem) throws SQLException {
        ps.setString(1, fgaudititem.getUuid());
        if (fgaudititem.getAuditMaster() != null) {
            ps.setInt(2, fgaudititem.getAuditMaster().getFgAuditMasterID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgaudititem.getOutputContext());
        ps.setString(4, fgaudititem.getErrorContext());
    }

    private FgAuditItem extract(ResultSet rs) throws SQLException {
        FgAuditItem fgaudititem = new FgAuditItem();
        fgaudititem.setUuid(rs.getString(COL_UUID));
        Integer AUDIT_MASTER_ID = rs.getObject(COL_AUDIT_MASTER_ID, Integer.class);
        fgaudititem.setAuditMasterID(AUDIT_MASTER_ID);
        if (AUDIT_MASTER_ID != null) {
            FgAuditMaster auditMaster = new FgAuditMaster();
            auditMaster.setFgAuditMasterID(AUDIT_MASTER_ID);
            fgaudititem.setAuditMaster(auditMaster);
        }
        fgaudititem.setOutputContext(rs.getString(COL_OUTPUT_CONTEXT));
        fgaudititem.setErrorContext(rs.getString(COL_ERROR_CONTEXT));
        return fgaudititem;
    }
}
