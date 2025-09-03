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

public class JdbcAPIOutstandingEfircDetailDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcAPIOutstandingEfircDetailDao.class);

    private static final String TABLE = "API_OUTSTANDING_EFIRC_DETAIL";

    private static final String COL_FIRC_NUMBER = "FIRC_NUMBER";

    private static final String COL_REMITTANCE_AMOUNT = "REMITTANCE_AMOUNT";

    private static final String COL_AMOUNT_UTILIZED = "AMOUNT_UTILIZED";

    private static final String COL_AMOUNT_OUTSTANDING = "AMOUNT_OUTSTANDING";

    private static final String COL_SWIFT_CODE = "SWIFT_CODE";

    private static final String COL_FIRC_ISSUE_DATE = "FIRC_ISSUE_DATE";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_REMITTER_NAME = "REMITTER_NAME";

    private static final String COL_REMITTER_COUNTRY = "REMITTER_COUNTRY";

    private static final String COL_REMITTER_BANK_COUNTRY = "REMITTER_BANK_COUNTRY";

    private static final String COL_FIRC_AD_CODE = "FIRC_AD_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_FIRC_NUMBER, COL_REMITTANCE_AMOUNT, COL_AMOUNT_UTILIZED, COL_AMOUNT_OUTSTANDING, COL_SWIFT_CODE, COL_FIRC_ISSUE_DATE, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMITTER_BANK_COUNTRY, COL_FIRC_AD_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("FIRC_NUMBER, REMITTANCE_AMOUNT, AMOUNT_UTILIZED, AMOUNT_OUTSTANDING, SWIFT_CODE, FIRC_ISSUE_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMITTER_BANK_COUNTRY, FIRC_AD_CODE", TABLE, COL_FIRC_NUMBER);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("FIRC_NUMBER, REMITTANCE_AMOUNT, AMOUNT_UTILIZED, AMOUNT_OUTSTANDING, SWIFT_CODE, FIRC_ISSUE_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMITTER_BANK_COUNTRY, FIRC_AD_CODE", TABLE, COL_FIRC_NUMBER);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REMITTANCE_AMOUNT, COL_AMOUNT_UTILIZED, COL_AMOUNT_OUTSTANDING, COL_SWIFT_CODE, COL_FIRC_ISSUE_DATE, COL_IE_CODE, COL_REMITTER_NAME, COL_REMITTER_COUNTRY, COL_REMITTER_BANK_COUNTRY, COL_FIRC_AD_CODE, COL_FIRC_NUMBER);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_FIRC_NUMBER);

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

    public String insert(Connection conn, APIOutstandingEfircDetail apioutstandingefircdetail) throws SQLException {
        logger.debug("Inserting apioutstandingefircdetail: {}", apioutstandingefircdetail);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setAPIOutstandingEfircDetailParams(ps, apioutstandingefircdetail);
            ps.executeUpdate();
            return apioutstandingefircdetail.getFircNumber();
        }
    }

    public int[] insertAll(Connection conn, List<APIOutstandingEfircDetail> apioutstandingefircdetails) throws SQLException {
        if (apioutstandingefircdetails == null || apioutstandingefircdetails.isEmpty())
            return new int[0];
        for (int i = 0; i < apioutstandingefircdetails.size(); i++) {
            if (apioutstandingefircdetails.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<APIOutstandingEfircDetail>> batches = chunkList(apioutstandingefircdetails, batchSize);
        int[] totalResults = new int[apioutstandingefircdetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<APIOutstandingEfircDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (APIOutstandingEfircDetail apioutstandingefircdetail : batch) {
                        setAPIOutstandingEfircDetailParams(ps, apioutstandingefircdetail);
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

    public APIOutstandingEfircDetail findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<APIOutstandingEfircDetail> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<APIOutstandingEfircDetail> list = new ArrayList<>();
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

    public boolean update(Connection conn, APIOutstandingEfircDetail apioutstandingefircdetail) throws SQLException {
        if (apioutstandingefircdetail.getFircNumber() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setAPIOutstandingEfircDetailParams(ps, apioutstandingefircdetail);
            ps.setString(11, apioutstandingefircdetail.getFircNumber());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<APIOutstandingEfircDetail> apioutstandingefircdetails) throws SQLException {
        if (apioutstandingefircdetails == null || apioutstandingefircdetails.isEmpty())
            return new int[0];
        for (APIOutstandingEfircDetail apioutstandingefircdetail : apioutstandingefircdetails) {
            if (apioutstandingefircdetail == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (apioutstandingefircdetail.getFircNumber() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<APIOutstandingEfircDetail>> batches = chunkList(apioutstandingefircdetails, batchSize);
        int[] totalResults = new int[apioutstandingefircdetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<APIOutstandingEfircDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (APIOutstandingEfircDetail apioutstandingefircdetail : batch) {
                        setAPIOutstandingEfircDetailParams(ps, apioutstandingefircdetail);
                        ps.setString(11, apioutstandingefircdetail.getFircNumber());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_FIRC_NUMBER, placeholders);
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

    private void setAPIOutstandingEfircDetailParams(PreparedStatement ps, APIOutstandingEfircDetail apioutstandingefircdetail) throws SQLException {
        ps.setString(1, apioutstandingefircdetail.getFircNumber());
        java.math.BigDecimal val2 = apioutstandingefircdetail.getRemittanceAmount();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        java.math.BigDecimal val3 = apioutstandingefircdetail.getAmountUtilized();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        java.math.BigDecimal val4 = apioutstandingefircdetail.getAmountOutstanding();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        ps.setString(5, apioutstandingefircdetail.getSwiftCode());
        java.time.LocalDateTime val6 = apioutstandingefircdetail.getFircIssueDate();
        if (val6 != null) {
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(val6));
        } else {
            ps.setNull(6, Types.TIMESTAMP);
        }
        ps.setString(7, apioutstandingefircdetail.getIeCode());
        ps.setString(8, apioutstandingefircdetail.getRemitterName());
        ps.setString(9, apioutstandingefircdetail.getRemitterCountry());
        ps.setString(10, apioutstandingefircdetail.getRemitterBankCountry());
        ps.setString(11, apioutstandingefircdetail.getFircAdCode());
    }

    private APIOutstandingEfircDetail extract(ResultSet rs) throws SQLException {
        APIOutstandingEfircDetail apioutstandingefircdetail = new APIOutstandingEfircDetail();
        apioutstandingefircdetail.setFircNumber(rs.getString(COL_FIRC_NUMBER));
        java.math.BigDecimal REMITTANCE_AMOUNT = rs.getObject(COL_REMITTANCE_AMOUNT, java.math.BigDecimal.class);
        apioutstandingefircdetail.setRemittanceAmount(REMITTANCE_AMOUNT);
        java.math.BigDecimal AMOUNT_UTILIZED = rs.getObject(COL_AMOUNT_UTILIZED, java.math.BigDecimal.class);
        apioutstandingefircdetail.setAmountUtilized(AMOUNT_UTILIZED);
        java.math.BigDecimal AMOUNT_OUTSTANDING = rs.getObject(COL_AMOUNT_OUTSTANDING, java.math.BigDecimal.class);
        apioutstandingefircdetail.setAmountOutstanding(AMOUNT_OUTSTANDING);
        apioutstandingefircdetail.setSwiftCode(rs.getString(COL_SWIFT_CODE));
        Timestamp FIRC_ISSUE_DATE = rs.getTimestamp(COL_FIRC_ISSUE_DATE);
        if (FIRC_ISSUE_DATE != null)
            apioutstandingefircdetail.setFircIssueDate(FIRC_ISSUE_DATE.toLocalDateTime());
        apioutstandingefircdetail.setIeCode(rs.getString(COL_IE_CODE));
        apioutstandingefircdetail.setRemitterName(rs.getString(COL_REMITTER_NAME));
        apioutstandingefircdetail.setRemitterCountry(rs.getString(COL_REMITTER_COUNTRY));
        apioutstandingefircdetail.setRemitterBankCountry(rs.getString(COL_REMITTER_BANK_COUNTRY));
        apioutstandingefircdetail.setFircAdCode(rs.getString(COL_FIRC_AD_CODE));
        return apioutstandingefircdetail;
    }
}
