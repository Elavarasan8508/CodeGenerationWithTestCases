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

public class JdbcFgProductTransactionDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgProductTransactionDao.class);

    private static final String TABLE = "FG_PRODUCT_TRANSACTION";

    private static final String COL_ID = "ID";

    private static final String COL_PAYMENT_ID = "PAYMENT_ID";

    private static final String COL_ENTITY_REFERENCE_ID = "ENTITY_REFERENCE_ID";

    private static final String COL_TRANSACTION_DATE = "TRANSACTION_DATE";

    private static final String COL_CURRENCY_CODE = "CURRENCY_CODE";

    private static final String COL_TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PAYMENT_ID, COL_ENTITY_REFERENCE_ID, COL_TRANSACTION_DATE, COL_CURRENCY_CODE, COL_TRANSACTION_AMOUNT, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PAYMENT_ID, ENTITY_REFERENCE_ID, TRANSACTION_DATE, CURRENCY_CODE, TRANSACTION_AMOUNT, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PAYMENT_ID, ENTITY_REFERENCE_ID, TRANSACTION_DATE, CURRENCY_CODE, TRANSACTION_AMOUNT, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PAYMENT_ID, COL_ENTITY_REFERENCE_ID, COL_TRANSACTION_DATE, COL_CURRENCY_CODE, COL_TRANSACTION_AMOUNT, COL_DESCRIPTION, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ID);

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

    public int insert(Connection conn, FgProductTransaction fgproducttransaction) throws SQLException {
        logger.debug("Inserting fgproducttransaction: {}", fgproducttransaction);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgProductTransactionParams(ps, fgproducttransaction);
            ps.executeUpdate();
            return fgproducttransaction.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgProductTransaction> fgproducttransactions) throws SQLException {
        if (fgproducttransactions == null || fgproducttransactions.isEmpty())
            return new int[0];
        for (int i = 0; i < fgproducttransactions.size(); i++) {
            if (fgproducttransactions.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductTransaction>> batches = chunkList(fgproducttransactions, batchSize);
        int[] totalResults = new int[fgproducttransactions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductTransaction> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgProductTransaction fgproducttransaction : batch) {
                        setFgProductTransactionParams(ps, fgproducttransaction);
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

    public FgProductTransaction findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgProductTransaction> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgProductTransaction> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgProductTransaction fgproducttransaction) throws SQLException {
        if (fgproducttransaction.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgProductTransactionParams(ps, fgproducttransaction);
            ps.setInt(15, fgproducttransaction.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgProductTransaction> fgproducttransactions) throws SQLException {
        if (fgproducttransactions == null || fgproducttransactions.isEmpty())
            return new int[0];
        for (FgProductTransaction fgproducttransaction : fgproducttransactions) {
            if (fgproducttransaction == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgproducttransaction.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgProductTransaction>> batches = chunkList(fgproducttransactions, batchSize);
        int[] totalResults = new int[fgproducttransactions.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgProductTransaction> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgProductTransaction fgproducttransaction : batch) {
                        setFgProductTransactionParams(ps, fgproducttransaction);
                        ps.setInt(15, fgproducttransaction.getID());
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

    private void setFgProductTransactionParams(PreparedStatement ps, FgProductTransaction fgproducttransaction) throws SQLException {
        Integer val1 = fgproducttransaction.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgproducttransaction.getPaymentID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fgproducttransaction.getEntityReferenceID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        java.time.LocalDateTime val4 = fgproducttransaction.getTransactionDate();
        if (val4 != null) {
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(val4));
        } else {
            ps.setNull(4, Types.TIMESTAMP);
        }
        ps.setString(5, fgproducttransaction.getCurrencyCode());
        java.math.BigDecimal val6 = fgproducttransaction.getTransactionAmount();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, fgproducttransaction.getDescription());
        ps.setString(8, fgproducttransaction.getActiveCode());
        ps.setString(9, fgproducttransaction.getStatusCode());
        ps.setString(10, fgproducttransaction.getCreatedOn());
        java.math.BigDecimal val11 = fgproducttransaction.getCreatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgproducttransaction.getLastUpdatedOn());
        java.math.BigDecimal val13 = fgproducttransaction.getLastUpdatedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgproducttransaction.getLastAuthorisedOn());
        java.math.BigDecimal val15 = fgproducttransaction.getLastAuthorisedBy();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
    }

    private FgProductTransaction extract(ResultSet rs) throws SQLException {
        FgProductTransaction fgproducttransaction = new FgProductTransaction();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgproducttransaction.setID(ID);
        Integer PAYMENT_ID = rs.getObject(COL_PAYMENT_ID, Integer.class);
        fgproducttransaction.setPaymentID(PAYMENT_ID);
        Integer ENTITY_REFERENCE_ID = rs.getObject(COL_ENTITY_REFERENCE_ID, Integer.class);
        fgproducttransaction.setEntityReferenceID(ENTITY_REFERENCE_ID);
        Timestamp TRANSACTION_DATE = rs.getTimestamp(COL_TRANSACTION_DATE);
        if (TRANSACTION_DATE != null)
            fgproducttransaction.setTransactionDate(TRANSACTION_DATE.toLocalDateTime());
        fgproducttransaction.setCurrencyCode(rs.getString(COL_CURRENCY_CODE));
        java.math.BigDecimal TRANSACTION_AMOUNT = rs.getObject(COL_TRANSACTION_AMOUNT, java.math.BigDecimal.class);
        fgproducttransaction.setTransactionAmount(TRANSACTION_AMOUNT);
        fgproducttransaction.setDescription(rs.getString(COL_DESCRIPTION));
        fgproducttransaction.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgproducttransaction.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgproducttransaction.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgproducttransaction.setCreatedBy(CREATED_BY);
        fgproducttransaction.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgproducttransaction.setLastUpdatedBy(LAST_UPDATED_BY);
        fgproducttransaction.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgproducttransaction.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        return fgproducttransaction;
    }
}
