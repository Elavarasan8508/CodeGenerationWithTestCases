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

public class JdbcFgActHiDecInDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiDecInDao.class);

    private static final String TABLE = "FG_ACT_HI_DEC_IN";

    private static final String COL_ID_ = "ID_";

    private static final String COL_DEC_INST_ID_ = "DEC_INST_ID_";

    private static final String COL_CLAUSE_ID_ = "CLAUSE_ID_";

    private static final String COL_CLAUSE_NAME_ = "CLAUSE_NAME_";

    private static final String COL_VAR_TYPE_ = "VAR_TYPE_";

    private static final String COL_BYTEARRAY_ID_ = "BYTEARRAY_ID_";

    private static final String COL_DOUBLE_ = "DOUBLE_";

    private static final String COL_LONG_ = "LONG_";

    private static final String COL_TEXT_ = "TEXT_";

    private static final String COL_TEXT2_ = "TEXT2_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_CREATE_TIME_ = "CREATE_TIME_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_DEC_INST_ID_, COL_CLAUSE_ID_, COL_CLAUSE_NAME_, COL_VAR_TYPE_, COL_BYTEARRAY_ID_, COL_DOUBLE_, COL_LONG_, COL_TEXT_, COL_TEXT2_, COL_TENANT_ID_, COL_CREATE_TIME_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, DEC_INST_ID_, CLAUSE_ID_, CLAUSE_NAME_, VAR_TYPE_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, TENANT_ID_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, DEC_INST_ID_, CLAUSE_ID_, CLAUSE_NAME_, VAR_TYPE_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, TENANT_ID_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_DEC_INST_ID_, COL_CLAUSE_ID_, COL_CLAUSE_NAME_, COL_VAR_TYPE_, COL_BYTEARRAY_ID_, COL_DOUBLE_, COL_LONG_, COL_TEXT_, COL_TEXT2_, COL_TENANT_ID_, COL_CREATE_TIME_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_ID_);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ID_);

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

    public String insert(Connection conn, FgActHiDecIn fgacthidecin) throws SQLException {
        logger.debug("Inserting fgacthidecin: {}", fgacthidecin);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiDecInParams(ps, fgacthidecin);
            ps.executeUpdate();
            return fgacthidecin.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiDecIn> fgacthidecins) throws SQLException {
        if (fgacthidecins == null || fgacthidecins.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthidecins.size(); i++) {
            if (fgacthidecins.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiDecIn>> batches = chunkList(fgacthidecins, batchSize);
        int[] totalResults = new int[fgacthidecins.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiDecIn> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiDecIn fgacthidecin : batch) {
                        setFgActHiDecInParams(ps, fgacthidecin);
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

    public FgActHiDecIn findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiDecIn> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiDecIn> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiDecIn fgacthidecin) throws SQLException {
        if (fgacthidecin.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiDecInParams(ps, fgacthidecin);
            ps.setString(14, fgacthidecin.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiDecIn> fgacthidecins) throws SQLException {
        if (fgacthidecins == null || fgacthidecins.isEmpty())
            return new int[0];
        for (FgActHiDecIn fgacthidecin : fgacthidecins) {
            if (fgacthidecin == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthidecin.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiDecIn>> batches = chunkList(fgacthidecins, batchSize);
        int[] totalResults = new int[fgacthidecins.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiDecIn> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiDecIn fgacthidecin : batch) {
                        setFgActHiDecInParams(ps, fgacthidecin);
                        ps.setString(14, fgacthidecin.getID_());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ID_, placeholders);
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

    private void setFgActHiDecInParams(PreparedStatement ps, FgActHiDecIn fgacthidecin) throws SQLException {
        ps.setString(1, fgacthidecin.getID_());
        ps.setString(2, fgacthidecin.getDecInstID_());
        ps.setString(3, fgacthidecin.getClauseID_());
        ps.setString(4, fgacthidecin.getClauseName_());
        ps.setString(5, fgacthidecin.getVarType_());
        ps.setString(6, fgacthidecin.getBytearrayID_());
        java.math.BigDecimal val7 = fgacthidecin.getDouble_();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        java.math.BigDecimal val8 = fgacthidecin.getLong_();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fgacthidecin.getText_());
        ps.setString(10, fgacthidecin.getText2_());
        ps.setString(11, fgacthidecin.getTenantID_());
        ps.setString(12, fgacthidecin.getCreateTime_());
        ps.setString(13, fgacthidecin.getRootProcInstID_());
        ps.setString(14, fgacthidecin.getRemovalTime_());
    }

    private FgActHiDecIn extract(ResultSet rs) throws SQLException {
        FgActHiDecIn fgacthidecin = new FgActHiDecIn();
        fgacthidecin.setID_(rs.getString(COL_ID_));
        fgacthidecin.setDecInstID_(rs.getString(COL_DEC_INST_ID_));
        fgacthidecin.setClauseID_(rs.getString(COL_CLAUSE_ID_));
        fgacthidecin.setClauseName_(rs.getString(COL_CLAUSE_NAME_));
        fgacthidecin.setVarType_(rs.getString(COL_VAR_TYPE_));
        fgacthidecin.setBytearrayID_(rs.getString(COL_BYTEARRAY_ID_));
        java.math.BigDecimal DOUBLE_ = rs.getObject(COL_DOUBLE_, java.math.BigDecimal.class);
        fgacthidecin.setDouble_(DOUBLE_);
        java.math.BigDecimal LONG_ = rs.getObject(COL_LONG_, java.math.BigDecimal.class);
        fgacthidecin.setLong_(LONG_);
        fgacthidecin.setText_(rs.getString(COL_TEXT_));
        fgacthidecin.setText2_(rs.getString(COL_TEXT2_));
        fgacthidecin.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthidecin.setCreateTime_(rs.getString(COL_CREATE_TIME_));
        fgacthidecin.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthidecin.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        return fgacthidecin;
    }
}
