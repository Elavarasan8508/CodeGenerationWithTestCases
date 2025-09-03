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

public class JdbcFgMockFynAccountDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgMockFynAccountDao.class);

    private static final String TABLE = "FG_MOCK_FYN_ACCOUNT";

    private static final String COL_CUST_MNM = "CUST_MNM";

    private static final String COL_ACCOUNT_NO = "ACCOUNT_NO";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_ACCOUNT_STATUS = "ACCOUNT_STATUS";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_CUST_MNM, COL_ACCOUNT_NO, COL_TEMPLATE, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_IS_TEMPLATE, COL_ACCOUNT_STATUS);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("CUST_MNM, ACCOUNT_NO, TEMPLATE, VERSION_ID, IS_MASTER_VERSION, ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_TEMPLATE, ACCOUNT_STATUS", TABLE, COL_VERSION_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("CUST_MNM, ACCOUNT_NO, TEMPLATE, VERSION_ID, IS_MASTER_VERSION, ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_TEMPLATE, ACCOUNT_STATUS", TABLE, COL_VERSION_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CUST_MNM, COL_ACCOUNT_NO, COL_TEMPLATE, COL_IS_MASTER_VERSION, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_IS_TEMPLATE, COL_ACCOUNT_STATUS, COL_VERSION_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_VERSION_ID);

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

    public int insert(Connection conn, FgMockFynAccount fgmockfynaccount) throws SQLException {
        logger.debug("Inserting fgmockfynaccount: {}", fgmockfynaccount);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgMockFynAccountParams(ps, fgmockfynaccount);
            ps.executeUpdate();
            return fgmockfynaccount.getVersionID();
        }
    }

    public int[] insertAll(Connection conn, List<FgMockFynAccount> fgmockfynaccounts) throws SQLException {
        if (fgmockfynaccounts == null || fgmockfynaccounts.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmockfynaccounts.size(); i++) {
            if (fgmockfynaccounts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMockFynAccount>> batches = chunkList(fgmockfynaccounts, batchSize);
        int[] totalResults = new int[fgmockfynaccounts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMockFynAccount> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgMockFynAccount fgmockfynaccount : batch) {
                        setFgMockFynAccountParams(ps, fgmockfynaccount);
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

    public FgMockFynAccount findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgMockFynAccount> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgMockFynAccount> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgMockFynAccount fgmockfynaccount) throws SQLException {
        if (fgmockfynaccount.getVersionID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgMockFynAccountParams(ps, fgmockfynaccount);
            ps.setInt(20, fgmockfynaccount.getVersionID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgMockFynAccount> fgmockfynaccounts) throws SQLException {
        if (fgmockfynaccounts == null || fgmockfynaccounts.isEmpty())
            return new int[0];
        for (FgMockFynAccount fgmockfynaccount : fgmockfynaccounts) {
            if (fgmockfynaccount == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmockfynaccount.getVersionID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgMockFynAccount>> batches = chunkList(fgmockfynaccounts, batchSize);
        int[] totalResults = new int[fgmockfynaccounts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgMockFynAccount> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgMockFynAccount fgmockfynaccount : batch) {
                        setFgMockFynAccountParams(ps, fgmockfynaccount);
                        ps.setInt(20, fgmockfynaccount.getVersionID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_VERSION_ID, placeholders);
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

    private void setFgMockFynAccountParams(PreparedStatement ps, FgMockFynAccount fgmockfynaccount) throws SQLException {
        ps.setString(1, fgmockfynaccount.getCustMnm());
        ps.setString(2, fgmockfynaccount.getAccountNo());
        ps.setString(3, fgmockfynaccount.getTemplate());
        Integer val4 = fgmockfynaccount.getVersionID();
        if (val4 != null) {
            ps.setInt(4, val4);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        java.math.BigDecimal val5 = fgmockfynaccount.getIsMasterVersion();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        Integer val6 = fgmockfynaccount.getID();
        if (val6 != null) {
            ps.setInt(6, val6);
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        Integer val7 = fgmockfynaccount.getReferenceID();
        if (val7 != null) {
            ps.setInt(7, val7);
        } else {
            ps.setNull(7, Types.INTEGER);
        }
        ps.setString(8, fgmockfynaccount.getTypeCode());
        ps.setString(9, fgmockfynaccount.getSubTypeCode());
        ps.setString(10, fgmockfynaccount.getActiveCode());
        ps.setString(11, fgmockfynaccount.getStageCode());
        ps.setString(12, fgmockfynaccount.getStatusCode());
        ps.setString(13, fgmockfynaccount.getCreatedOn());
        java.math.BigDecimal val14 = fgmockfynaccount.getCreatedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgmockfynaccount.getLastUpdatedOn());
        java.math.BigDecimal val16 = fgmockfynaccount.getLastUpdatedBy();
        if (val16 != null) {
            ps.setBigDecimal(16, val16);
        } else {
            ps.setNull(16, Types.DECIMAL);
        }
        ps.setString(17, fgmockfynaccount.getLastAuthorisedOn());
        java.math.BigDecimal val18 = fgmockfynaccount.getLastAuthorisedBy();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = fgmockfynaccount.getIsTemplate();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, fgmockfynaccount.getAccountStatus());
    }

    private FgMockFynAccount extract(ResultSet rs) throws SQLException {
        FgMockFynAccount fgmockfynaccount = new FgMockFynAccount();
        fgmockfynaccount.setCustMnm(rs.getString(COL_CUST_MNM));
        fgmockfynaccount.setAccountNo(rs.getString(COL_ACCOUNT_NO));
        fgmockfynaccount.setTemplate(rs.getString(COL_TEMPLATE));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        fgmockfynaccount.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        fgmockfynaccount.setIsMasterVersion(IS_MASTER_VERSION);
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmockfynaccount.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgmockfynaccount.setReferenceID(REFERENCE_ID);
        fgmockfynaccount.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgmockfynaccount.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgmockfynaccount.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmockfynaccount.setStageCode(rs.getString(COL_STAGE_CODE));
        fgmockfynaccount.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmockfynaccount.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmockfynaccount.setCreatedBy(CREATED_BY);
        fgmockfynaccount.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmockfynaccount.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmockfynaccount.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmockfynaccount.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgmockfynaccount.setIsTemplate(IS_TEMPLATE);
        fgmockfynaccount.setAccountStatus(rs.getString(COL_ACCOUNT_STATUS));
        return fgmockfynaccount;
    }
}
