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

public class JdbcAPIOutstandingOrmDetailDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcAPIOutstandingOrmDetailDao.class);

    private static final String TABLE = "API_OUTSTANDING_ORM_DETAIL";

    private static final String COL_ORM_NUMBER = "ORM_NUMBER";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_REMITTANCE_AMOUNT = "REMITTANCE_AMOUNT";

    private static final String COL_REMITTANCE_UTILIZED_AMOUNT = "REMITTANCE_UTILIZED_AMOUNT";

    private static final String COL_REMITTANCE_UNUTILIZED_AMOUNT = "REMITTANCE_UNUTILIZED_AMOUNT";

    private static final String COL_REMITTANCE_CURRENCY = "REMITTANCE_CURRENCY";

    private static final String COL_REMITTANCE_DATE = "REMITTANCE_DATE";

    private static final String COL_IE_NAME = "IE_NAME";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_BENEFICIARY_NAME = "BENEFICIARY_NAME";

    private static final String COL_BENEFICIARY_COUNTRY = "BENEFICIARY_COUNTRY";

    private static final String COL_PURPOSE_OF_REMITTANCE = "PURPOSE_OF_REMITTANCE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ORM_NUMBER, COL_AD_CODE, COL_REMITTANCE_AMOUNT, COL_REMITTANCE_UTILIZED_AMOUNT, COL_REMITTANCE_UNUTILIZED_AMOUNT, COL_REMITTANCE_CURRENCY, COL_REMITTANCE_DATE, COL_IE_NAME, COL_IE_CODE, COL_BENEFICIARY_NAME, COL_BENEFICIARY_COUNTRY, COL_PURPOSE_OF_REMITTANCE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ORM_NUMBER, AD_CODE, REMITTANCE_AMOUNT, REMITTANCE_UTILIZED_AMOUNT, REMITTANCE_UNUTILIZED_AMOUNT, REMITTANCE_CURRENCY, REMITTANCE_DATE, IE_NAME, IE_CODE, BENEFICIARY_NAME, BENEFICIARY_COUNTRY, PURPOSE_OF_REMITTANCE", TABLE, COL_ORM_NUMBER);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ORM_NUMBER, AD_CODE, REMITTANCE_AMOUNT, REMITTANCE_UTILIZED_AMOUNT, REMITTANCE_UNUTILIZED_AMOUNT, REMITTANCE_CURRENCY, REMITTANCE_DATE, IE_NAME, IE_CODE, BENEFICIARY_NAME, BENEFICIARY_COUNTRY, PURPOSE_OF_REMITTANCE", TABLE, COL_ORM_NUMBER);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_AD_CODE, COL_REMITTANCE_AMOUNT, COL_REMITTANCE_UTILIZED_AMOUNT, COL_REMITTANCE_UNUTILIZED_AMOUNT, COL_REMITTANCE_CURRENCY, COL_REMITTANCE_DATE, COL_IE_NAME, COL_IE_CODE, COL_BENEFICIARY_NAME, COL_BENEFICIARY_COUNTRY, COL_PURPOSE_OF_REMITTANCE, COL_ORM_NUMBER);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ORM_NUMBER);

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

    public String insert(Connection conn, APIOutstandingOrmDetail apioutstandingormdetail) throws SQLException {
        logger.debug("Inserting apioutstandingormdetail: {}", apioutstandingormdetail);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setAPIOutstandingOrmDetailParams(ps, apioutstandingormdetail);
            ps.executeUpdate();
            return apioutstandingormdetail.getOrmNumber();
        }
    }

    public int[] insertAll(Connection conn, List<APIOutstandingOrmDetail> apioutstandingormdetails) throws SQLException {
        if (apioutstandingormdetails == null || apioutstandingormdetails.isEmpty())
            return new int[0];
        for (int i = 0; i < apioutstandingormdetails.size(); i++) {
            if (apioutstandingormdetails.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<APIOutstandingOrmDetail>> batches = chunkList(apioutstandingormdetails, batchSize);
        int[] totalResults = new int[apioutstandingormdetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<APIOutstandingOrmDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (APIOutstandingOrmDetail apioutstandingormdetail : batch) {
                        setAPIOutstandingOrmDetailParams(ps, apioutstandingormdetail);
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

    public APIOutstandingOrmDetail findById(Connection conn, String id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<APIOutstandingOrmDetail> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<APIOutstandingOrmDetail> list = new ArrayList<>();
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

    public boolean update(Connection conn, APIOutstandingOrmDetail apioutstandingormdetail) throws SQLException {
        if (apioutstandingormdetail.getOrmNumber() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setAPIOutstandingOrmDetailParams(ps, apioutstandingormdetail);
            ps.setString(12, apioutstandingormdetail.getOrmNumber());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<APIOutstandingOrmDetail> apioutstandingormdetails) throws SQLException {
        if (apioutstandingormdetails == null || apioutstandingormdetails.isEmpty())
            return new int[0];
        for (APIOutstandingOrmDetail apioutstandingormdetail : apioutstandingormdetails) {
            if (apioutstandingormdetail == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (apioutstandingormdetail.getOrmNumber() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<APIOutstandingOrmDetail>> batches = chunkList(apioutstandingormdetails, batchSize);
        int[] totalResults = new int[apioutstandingormdetails.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<APIOutstandingOrmDetail> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (APIOutstandingOrmDetail apioutstandingormdetail : batch) {
                        setAPIOutstandingOrmDetailParams(ps, apioutstandingormdetail);
                        ps.setString(12, apioutstandingormdetail.getOrmNumber());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ORM_NUMBER, placeholders);
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

    private void setAPIOutstandingOrmDetailParams(PreparedStatement ps, APIOutstandingOrmDetail apioutstandingormdetail) throws SQLException {
        ps.setString(1, apioutstandingormdetail.getOrmNumber());
        ps.setString(2, apioutstandingormdetail.getAdCode());
        java.math.BigDecimal val3 = apioutstandingormdetail.getRemittanceAmount();
        if (val3 != null) {
            ps.setBigDecimal(3, val3);
        } else {
            ps.setNull(3, Types.DECIMAL);
        }
        java.math.BigDecimal val4 = apioutstandingormdetail.getRemittanceUtilizedAmount();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        java.math.BigDecimal val5 = apioutstandingormdetail.getRemittanceUnutilizedAmount();
        if (val5 != null) {
            ps.setBigDecimal(5, val5);
        } else {
            ps.setNull(5, Types.DECIMAL);
        }
        ps.setString(6, apioutstandingormdetail.getRemittanceCurrency());
        java.time.LocalDateTime val7 = apioutstandingormdetail.getRemittanceDate();
        if (val7 != null) {
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(val7));
        } else {
            ps.setNull(7, Types.TIMESTAMP);
        }
        ps.setString(8, apioutstandingormdetail.getIeName());
        ps.setString(9, apioutstandingormdetail.getIeCode());
        ps.setString(10, apioutstandingormdetail.getBeneficiaryName());
        ps.setString(11, apioutstandingormdetail.getBeneficiaryCountry());
        ps.setString(12, apioutstandingormdetail.getPurposeOfRemittance());
    }

    private APIOutstandingOrmDetail extract(ResultSet rs) throws SQLException {
        APIOutstandingOrmDetail apioutstandingormdetail = new APIOutstandingOrmDetail();
        apioutstandingormdetail.setOrmNumber(rs.getString(COL_ORM_NUMBER));
        apioutstandingormdetail.setAdCode(rs.getString(COL_AD_CODE));
        java.math.BigDecimal REMITTANCE_AMOUNT = rs.getObject(COL_REMITTANCE_AMOUNT, java.math.BigDecimal.class);
        apioutstandingormdetail.setRemittanceAmount(REMITTANCE_AMOUNT);
        java.math.BigDecimal REMITTANCE_UTILIZED_AMOUNT = rs.getObject(COL_REMITTANCE_UTILIZED_AMOUNT, java.math.BigDecimal.class);
        apioutstandingormdetail.setRemittanceUtilizedAmount(REMITTANCE_UTILIZED_AMOUNT);
        java.math.BigDecimal REMITTANCE_UNUTILIZED_AMOUNT = rs.getObject(COL_REMITTANCE_UNUTILIZED_AMOUNT, java.math.BigDecimal.class);
        apioutstandingormdetail.setRemittanceUnutilizedAmount(REMITTANCE_UNUTILIZED_AMOUNT);
        apioutstandingormdetail.setRemittanceCurrency(rs.getString(COL_REMITTANCE_CURRENCY));
        Timestamp REMITTANCE_DATE = rs.getTimestamp(COL_REMITTANCE_DATE);
        if (REMITTANCE_DATE != null)
            apioutstandingormdetail.setRemittanceDate(REMITTANCE_DATE.toLocalDateTime());
        apioutstandingormdetail.setIeName(rs.getString(COL_IE_NAME));
        apioutstandingormdetail.setIeCode(rs.getString(COL_IE_CODE));
        apioutstandingormdetail.setBeneficiaryName(rs.getString(COL_BENEFICIARY_NAME));
        apioutstandingormdetail.setBeneficiaryCountry(rs.getString(COL_BENEFICIARY_COUNTRY));
        apioutstandingormdetail.setPurposeOfRemittance(rs.getString(COL_PURPOSE_OF_REMITTANCE));
        return apioutstandingormdetail;
    }
}
