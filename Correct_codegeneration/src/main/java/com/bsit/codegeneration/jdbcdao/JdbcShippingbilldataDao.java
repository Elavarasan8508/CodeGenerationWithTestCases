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

public class JdbcShippingbilldataDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcShippingbilldataDao.class);

    private static final String TABLE = "SHIPPINGBILLDATA";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_SHIPBILLNO = "SHIPBILLNO";

    private static final String COL_SHIPBILLDATE = "SHIPBILLDATE";

    private static final String COL_PORTCODE = "PORTCODE";

    private static final String COL_FORMNO = "FORMNO";

    private static final String COL_SHIPPINGBILLAMOUNT = "SHIPPINGBILLAMOUNT";

    private static final String COL_SHIPPINGBILLCURR = "SHIPPINGBILLCURR";

    private static final String COL_UTILIZED_AMT = "UTILIZED_AMT";

    private static final String COL_UNUTILIZED_AMT = "UNUTILIZED_AMT";

    private static final String COL_BILLREFNO = "BILLREFNO";

    private static final String COL_COUNTER_PARTY = "COUNTER_PARTY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_STATUS, COL_SHIPBILLNO, COL_SHIPBILLDATE, COL_PORTCODE, COL_FORMNO, COL_SHIPPINGBILLAMOUNT, COL_SHIPPINGBILLCURR, COL_UTILIZED_AMT, COL_UNUTILIZED_AMT, COL_BILLREFNO, COL_COUNTER_PARTY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("STATUS, SHIPBILLNO, SHIPBILLDATE, PORTCODE, FORMNO, SHIPPINGBILLAMOUNT, SHIPPINGBILLCURR, UTILIZED_AMT, UNUTILIZED_AMT, BILLREFNO, COUNTER_PARTY", TABLE, COL_STATUS);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("STATUS, SHIPBILLNO, SHIPBILLDATE, PORTCODE, FORMNO, SHIPPINGBILLAMOUNT, SHIPPINGBILLCURR, UTILIZED_AMT, UNUTILIZED_AMT, BILLREFNO, COUNTER_PARTY", TABLE, COL_STATUS);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_SHIPBILLNO, COL_SHIPBILLDATE, COL_PORTCODE, COL_FORMNO, COL_SHIPPINGBILLAMOUNT, COL_SHIPPINGBILLCURR, COL_UTILIZED_AMT, COL_UNUTILIZED_AMT, COL_BILLREFNO, COL_COUNTER_PARTY, COL_STATUS);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STATUS);

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

    public String insert(Connection conn, Shippingbilldata shippingbilldata) throws SQLException {
        logger.debug("Inserting shippingbilldata: {}", shippingbilldata);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setShippingbilldataParams(ps, shippingbilldata);
            ps.executeUpdate();
            return shippingbilldata.getStatus();
        }
    }

    public int[] insertAll(Connection conn, List<Shippingbilldata> shippingbilldatas) throws SQLException {
        if (shippingbilldatas == null || shippingbilldatas.isEmpty())
            return new int[0];
        for (int i = 0; i < shippingbilldatas.size(); i++) {
            if (shippingbilldatas.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Shippingbilldata>> batches = chunkList(shippingbilldatas, batchSize);
        int[] totalResults = new int[shippingbilldatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Shippingbilldata> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (Shippingbilldata shippingbilldata : batch) {
                        setShippingbilldataParams(ps, shippingbilldata);
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

    public Shippingbilldata findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Shippingbilldata> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Shippingbilldata> list = new ArrayList<>();
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

    public boolean update(Connection conn, Shippingbilldata shippingbilldata) throws SQLException {
        if (shippingbilldata.getStatus() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setShippingbilldataParams(ps, shippingbilldata);
            ps.setString(11, shippingbilldata.getStatus());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Shippingbilldata> shippingbilldatas) throws SQLException {
        if (shippingbilldatas == null || shippingbilldatas.isEmpty())
            return new int[0];
        for (Shippingbilldata shippingbilldata : shippingbilldatas) {
            if (shippingbilldata == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (shippingbilldata.getStatus() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Shippingbilldata>> batches = chunkList(shippingbilldatas, batchSize);
        int[] totalResults = new int[shippingbilldatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Shippingbilldata> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Shippingbilldata shippingbilldata : batch) {
                        setShippingbilldataParams(ps, shippingbilldata);
                        ps.setString(11, shippingbilldata.getStatus());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_STATUS, placeholders);
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

    private void setShippingbilldataParams(PreparedStatement ps, Shippingbilldata shippingbilldata) throws SQLException {
        ps.setString(1, shippingbilldata.getStatus());
        ps.setString(2, shippingbilldata.getShipbillno());
        java.time.LocalDateTime val3 = shippingbilldata.getShipbilldate();
        if (val3 != null) {
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(val3));
        } else {
            ps.setNull(3, Types.TIMESTAMP);
        }
        ps.setString(4, shippingbilldata.getPortcode());
        ps.setString(5, shippingbilldata.getFormno());
        java.math.BigDecimal val6 = shippingbilldata.getShippingbillamount();
        if (val6 != null) {
            ps.setBigDecimal(6, val6);
        } else {
            ps.setNull(6, Types.DECIMAL);
        }
        ps.setString(7, shippingbilldata.getShippingbillcurr());
        java.math.BigDecimal val8 = shippingbilldata.getUtilizedAmt();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        java.math.BigDecimal val9 = shippingbilldata.getUnutilizedAmt();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, shippingbilldata.getBillrefno());
        ps.setString(11, shippingbilldata.getCounterParty());
    }

    private Shippingbilldata extract(ResultSet rs) throws SQLException {
        Shippingbilldata shippingbilldata = new Shippingbilldata();
        shippingbilldata.setStatus(rs.getString(COL_STATUS));
        shippingbilldata.setShipbillno(rs.getString(COL_SHIPBILLNO));
        Timestamp SHIPBILLDATE = rs.getTimestamp(COL_SHIPBILLDATE);
        if (SHIPBILLDATE != null)
            shippingbilldata.setShipbilldate(SHIPBILLDATE.toLocalDateTime());
        shippingbilldata.setPortcode(rs.getString(COL_PORTCODE));
        shippingbilldata.setFormno(rs.getString(COL_FORMNO));
        java.math.BigDecimal SHIPPINGBILLAMOUNT = rs.getObject(COL_SHIPPINGBILLAMOUNT, java.math.BigDecimal.class);
        shippingbilldata.setShippingbillamount(SHIPPINGBILLAMOUNT);
        shippingbilldata.setShippingbillcurr(rs.getString(COL_SHIPPINGBILLCURR));
        java.math.BigDecimal UTILIZED_AMT = rs.getObject(COL_UTILIZED_AMT, java.math.BigDecimal.class);
        shippingbilldata.setUtilizedAmt(UTILIZED_AMT);
        java.math.BigDecimal UNUTILIZED_AMT = rs.getObject(COL_UNUTILIZED_AMT, java.math.BigDecimal.class);
        shippingbilldata.setUnutilizedAmt(UNUTILIZED_AMT);
        shippingbilldata.setBillrefno(rs.getString(COL_BILLREFNO));
        shippingbilldata.setCounterParty(rs.getString(COL_COUNTER_PARTY));
        return shippingbilldata;
    }
}
