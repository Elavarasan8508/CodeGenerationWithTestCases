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

public class JdbcShippinginvoicedataDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcShippinginvoicedataDao.class);

    private static final String TABLE = "SHIPPINGINVOICEDATA";

    private static final String COL_BILL_NO = "BILL_NO";

    private static final String COL_SHIPBILLNO = "SHIPBILLNO";

    private static final String COL_SHIPBILLDATE = "SHIPBILLDATE";

    private static final String COL_FORMNO = "FORMNO";

    private static final String COL_INV_SL_NO = "INV_SL_NO";

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_BILL_NO, COL_SHIPBILLNO, COL_SHIPBILLDATE, COL_FORMNO, COL_INV_SL_NO, COL_INV_NO, COL_INV_DATE, COL_IE_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("BILL_NO, SHIPBILLNO, SHIPBILLDATE, FORMNO, INV_SL_NO, INV_NO, INV_DATE, IE_CODE", TABLE, COL_BILL_NO);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("BILL_NO, SHIPBILLNO, SHIPBILLDATE, FORMNO, INV_SL_NO, INV_NO, INV_DATE, IE_CODE", TABLE, COL_BILL_NO);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_SHIPBILLNO, COL_SHIPBILLDATE, COL_FORMNO, COL_INV_SL_NO, COL_INV_NO, COL_INV_DATE, COL_IE_CODE, COL_BILL_NO);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_BILL_NO);

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

    public String insert(Connection conn, Shippinginvoicedata shippinginvoicedata) throws SQLException {
        logger.debug("Inserting shippinginvoicedata: {}", shippinginvoicedata);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setShippinginvoicedataParams(ps, shippinginvoicedata);
            ps.executeUpdate();
            return shippinginvoicedata.getBillNo();
        }
    }

    public int[] insertAll(Connection conn, List<Shippinginvoicedata> shippinginvoicedatas) throws SQLException {
        if (shippinginvoicedatas == null || shippinginvoicedatas.isEmpty())
            return new int[0];
        for (int i = 0; i < shippinginvoicedatas.size(); i++) {
            if (shippinginvoicedatas.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Shippinginvoicedata>> batches = chunkList(shippinginvoicedatas, batchSize);
        int[] totalResults = new int[shippinginvoicedatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Shippinginvoicedata> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (Shippinginvoicedata shippinginvoicedata : batch) {
                        setShippinginvoicedataParams(ps, shippinginvoicedata);
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

    public Shippinginvoicedata findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Shippinginvoicedata> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Shippinginvoicedata> list = new ArrayList<>();
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

    public boolean update(Connection conn, Shippinginvoicedata shippinginvoicedata) throws SQLException {
        if (shippinginvoicedata.getBillNo() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setShippinginvoicedataParams(ps, shippinginvoicedata);
            ps.setString(8, shippinginvoicedata.getBillNo());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Shippinginvoicedata> shippinginvoicedatas) throws SQLException {
        if (shippinginvoicedatas == null || shippinginvoicedatas.isEmpty())
            return new int[0];
        for (Shippinginvoicedata shippinginvoicedata : shippinginvoicedatas) {
            if (shippinginvoicedata == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (shippinginvoicedata.getBillNo() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Shippinginvoicedata>> batches = chunkList(shippinginvoicedatas, batchSize);
        int[] totalResults = new int[shippinginvoicedatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Shippinginvoicedata> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Shippinginvoicedata shippinginvoicedata : batch) {
                        setShippinginvoicedataParams(ps, shippinginvoicedata);
                        ps.setString(8, shippinginvoicedata.getBillNo());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_BILL_NO, placeholders);
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

    private void setShippinginvoicedataParams(PreparedStatement ps, Shippinginvoicedata shippinginvoicedata) throws SQLException {
        ps.setString(1, shippinginvoicedata.getBillNo());
        ps.setString(2, shippinginvoicedata.getShipbillno());
        java.time.LocalDateTime val3 = shippinginvoicedata.getShipbilldate();
        if (val3 != null) {
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(val3));
        } else {
            ps.setNull(3, Types.TIMESTAMP);
        }
        ps.setString(4, shippinginvoicedata.getFormno());
        java.math.BigDecimal val5 = shippinginvoicedata.getInvSlNo();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        ps.setString(6, shippinginvoicedata.getInvNo());
        java.time.LocalDateTime val7 = shippinginvoicedata.getInvDate();
        if (val7 != null) {
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(val7));
        } else {
            ps.setNull(7, Types.TIMESTAMP);
        }
        ps.setString(8, shippinginvoicedata.getIeCode());
    }

    private Shippinginvoicedata extract(ResultSet rs) throws SQLException {
        Shippinginvoicedata shippinginvoicedata = new Shippinginvoicedata();
        shippinginvoicedata.setBillNo(rs.getString(COL_BILL_NO));
        shippinginvoicedata.setShipbillno(rs.getString(COL_SHIPBILLNO));
        Timestamp SHIPBILLDATE = rs.getTimestamp(COL_SHIPBILLDATE);
        if (SHIPBILLDATE != null)
            shippinginvoicedata.setShipbilldate(SHIPBILLDATE.toLocalDateTime());
        shippinginvoicedata.setFormno(rs.getString(COL_FORMNO));
        java.math.BigDecimal INV_SL_NO = rs.getObject(COL_INV_SL_NO, java.math.BigDecimal.class);
        shippinginvoicedata.setInvSlNo(INV_SL_NO);
        shippinginvoicedata.setInvNo(rs.getString(COL_INV_NO));
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            shippinginvoicedata.setInvDate(INV_DATE.toLocalDateTime());
        shippinginvoicedata.setIeCode(rs.getString(COL_IE_CODE));
        return shippinginvoicedata;
    }
}
