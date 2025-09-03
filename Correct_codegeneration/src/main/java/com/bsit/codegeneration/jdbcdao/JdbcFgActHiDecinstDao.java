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

public class JdbcFgActHiDecinstDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgActHiDecinstDao.class);

    private static final String TABLE = "FG_ACT_HI_DECINST";

    private static final String COL_ID_ = "ID_";

    private static final String COL_DEC_DEF_ID_ = "DEC_DEF_ID_";

    private static final String COL_DEC_DEF_KEY_ = "DEC_DEF_KEY_";

    private static final String COL_DEC_DEF_NAME_ = "DEC_DEF_NAME_";

    private static final String COL_PROC_DEF_KEY_ = "PROC_DEF_KEY_";

    private static final String COL_PROC_DEF_ID_ = "PROC_DEF_ID_";

    private static final String COL_PROC_INST_ID_ = "PROC_INST_ID_";

    private static final String COL_CASE_DEF_KEY_ = "CASE_DEF_KEY_";

    private static final String COL_CASE_DEF_ID_ = "CASE_DEF_ID_";

    private static final String COL_CASE_INST_ID_ = "CASE_INST_ID_";

    private static final String COL_ACT_INST_ID_ = "ACT_INST_ID_";

    private static final String COL_ACT_ID_ = "ACT_ID_";

    private static final String COL_EVAL_TIME_ = "EVAL_TIME_";

    private static final String COL_COLLECT_VALUE_ = "COLLECT_VALUE_";

    private static final String COL_USER_ID_ = "USER_ID_";

    private static final String COL_ROOT_DEC_INST_ID_ = "ROOT_DEC_INST_ID_";

    private static final String COL_DEC_REQ_ID_ = "DEC_REQ_ID_";

    private static final String COL_DEC_REQ_KEY_ = "DEC_REQ_KEY_";

    private static final String COL_TENANT_ID_ = "TENANT_ID_";

    private static final String COL_ROOT_PROC_INST_ID_ = "ROOT_PROC_INST_ID_";

    private static final String COL_REMOVAL_TIME_ = "REMOVAL_TIME_";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID_, COL_DEC_DEF_ID_, COL_DEC_DEF_KEY_, COL_DEC_DEF_NAME_, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_PROC_INST_ID_, COL_CASE_DEF_KEY_, COL_CASE_DEF_ID_, COL_CASE_INST_ID_, COL_ACT_INST_ID_, COL_ACT_ID_, COL_EVAL_TIME_, COL_COLLECT_VALUE_, COL_USER_ID_, COL_ROOT_DEC_INST_ID_, COL_DEC_REQ_ID_, COL_DEC_REQ_KEY_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID_, DEC_DEF_ID_, DEC_DEF_KEY_, DEC_DEF_NAME_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, ACT_INST_ID_, ACT_ID_, EVAL_TIME_, COLLECT_VALUE_, USER_ID_, ROOT_DEC_INST_ID_, DEC_REQ_ID_, DEC_REQ_KEY_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID_, DEC_DEF_ID_, DEC_DEF_KEY_, DEC_DEF_NAME_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, ACT_INST_ID_, ACT_ID_, EVAL_TIME_, COLLECT_VALUE_, USER_ID_, ROOT_DEC_INST_ID_, DEC_REQ_ID_, DEC_REQ_KEY_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_", TABLE, COL_ID_);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_DEC_DEF_ID_, COL_DEC_DEF_KEY_, COL_DEC_DEF_NAME_, COL_PROC_DEF_KEY_, COL_PROC_DEF_ID_, COL_PROC_INST_ID_, COL_CASE_DEF_KEY_, COL_CASE_DEF_ID_, COL_CASE_INST_ID_, COL_ACT_INST_ID_, COL_ACT_ID_, COL_EVAL_TIME_, COL_COLLECT_VALUE_, COL_USER_ID_, COL_ROOT_DEC_INST_ID_, COL_DEC_REQ_ID_, COL_DEC_REQ_KEY_, COL_TENANT_ID_, COL_ROOT_PROC_INST_ID_, COL_REMOVAL_TIME_, COL_ID_);

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

    public String insert(Connection conn, FgActHiDecinst fgacthidecinst) throws SQLException {
        logger.debug("Inserting fgacthidecinst: {}", fgacthidecinst);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgActHiDecinstParams(ps, fgacthidecinst);
            ps.executeUpdate();
            return fgacthidecinst.getID_();
        }
    }

    public int[] insertAll(Connection conn, List<FgActHiDecinst> fgacthidecinsts) throws SQLException {
        if (fgacthidecinsts == null || fgacthidecinsts.isEmpty())
            return new int[0];
        for (int i = 0; i < fgacthidecinsts.size(); i++) {
            if (fgacthidecinsts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiDecinst>> batches = chunkList(fgacthidecinsts, batchSize);
        int[] totalResults = new int[fgacthidecinsts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiDecinst> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgActHiDecinst fgacthidecinst : batch) {
                        setFgActHiDecinstParams(ps, fgacthidecinst);
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

    public FgActHiDecinst findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgActHiDecinst> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgActHiDecinst> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgActHiDecinst fgacthidecinst) throws SQLException {
        if (fgacthidecinst.getID_() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgActHiDecinstParams(ps, fgacthidecinst);
            ps.setString(21, fgacthidecinst.getID_());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgActHiDecinst> fgacthidecinsts) throws SQLException {
        if (fgacthidecinsts == null || fgacthidecinsts.isEmpty())
            return new int[0];
        for (FgActHiDecinst fgacthidecinst : fgacthidecinsts) {
            if (fgacthidecinst == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgacthidecinst.getID_() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgActHiDecinst>> batches = chunkList(fgacthidecinsts, batchSize);
        int[] totalResults = new int[fgacthidecinsts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgActHiDecinst> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgActHiDecinst fgacthidecinst : batch) {
                        setFgActHiDecinstParams(ps, fgacthidecinst);
                        ps.setString(21, fgacthidecinst.getID_());
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

    private void setFgActHiDecinstParams(PreparedStatement ps, FgActHiDecinst fgacthidecinst) throws SQLException {
        ps.setString(1, fgacthidecinst.getID_());
        ps.setString(2, fgacthidecinst.getDecDefID_());
        ps.setString(3, fgacthidecinst.getDecDefKey_());
        ps.setString(4, fgacthidecinst.getDecDefName_());
        ps.setString(5, fgacthidecinst.getProcDefKey_());
        ps.setString(6, fgacthidecinst.getProcDefID_());
        ps.setString(7, fgacthidecinst.getProcInstID_());
        ps.setString(8, fgacthidecinst.getCaseDefKey_());
        ps.setString(9, fgacthidecinst.getCaseDefID_());
        ps.setString(10, fgacthidecinst.getCaseInstID_());
        ps.setString(11, fgacthidecinst.getActInstID_());
        ps.setString(12, fgacthidecinst.getActID_());
        ps.setString(13, fgacthidecinst.getEvalTime_());
        java.math.BigDecimal val14 = fgacthidecinst.getCollectValue_();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgacthidecinst.getUserID_());
        ps.setString(16, fgacthidecinst.getRootDecInstID_());
        ps.setString(17, fgacthidecinst.getDecReqID_());
        ps.setString(18, fgacthidecinst.getDecReqKey_());
        ps.setString(19, fgacthidecinst.getTenantID_());
        ps.setString(20, fgacthidecinst.getRootProcInstID_());
        ps.setString(21, fgacthidecinst.getRemovalTime_());
    }

    private FgActHiDecinst extract(ResultSet rs) throws SQLException {
        FgActHiDecinst fgacthidecinst = new FgActHiDecinst();
        fgacthidecinst.setID_(rs.getString(COL_ID_));
        fgacthidecinst.setDecDefID_(rs.getString(COL_DEC_DEF_ID_));
        fgacthidecinst.setDecDefKey_(rs.getString(COL_DEC_DEF_KEY_));
        fgacthidecinst.setDecDefName_(rs.getString(COL_DEC_DEF_NAME_));
        fgacthidecinst.setProcDefKey_(rs.getString(COL_PROC_DEF_KEY_));
        fgacthidecinst.setProcDefID_(rs.getString(COL_PROC_DEF_ID_));
        fgacthidecinst.setProcInstID_(rs.getString(COL_PROC_INST_ID_));
        fgacthidecinst.setCaseDefKey_(rs.getString(COL_CASE_DEF_KEY_));
        fgacthidecinst.setCaseDefID_(rs.getString(COL_CASE_DEF_ID_));
        fgacthidecinst.setCaseInstID_(rs.getString(COL_CASE_INST_ID_));
        fgacthidecinst.setActInstID_(rs.getString(COL_ACT_INST_ID_));
        fgacthidecinst.setActID_(rs.getString(COL_ACT_ID_));
        fgacthidecinst.setEvalTime_(rs.getString(COL_EVAL_TIME_));
        java.math.BigDecimal COLLECT_VALUE_ = rs.getObject(COL_COLLECT_VALUE_, java.math.BigDecimal.class);
        fgacthidecinst.setCollectValue_(COLLECT_VALUE_);
        fgacthidecinst.setUserID_(rs.getString(COL_USER_ID_));
        fgacthidecinst.setRootDecInstID_(rs.getString(COL_ROOT_DEC_INST_ID_));
        fgacthidecinst.setDecReqID_(rs.getString(COL_DEC_REQ_ID_));
        fgacthidecinst.setDecReqKey_(rs.getString(COL_DEC_REQ_KEY_));
        fgacthidecinst.setTenantID_(rs.getString(COL_TENANT_ID_));
        fgacthidecinst.setRootProcInstID_(rs.getString(COL_ROOT_PROC_INST_ID_));
        fgacthidecinst.setRemovalTime_(rs.getString(COL_REMOVAL_TIME_));
        return fgacthidecinst;
    }
}
