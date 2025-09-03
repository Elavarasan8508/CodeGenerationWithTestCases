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

public class JdbcFgOrmDataDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgOrmDataDao.class);

    private static final String TABLE = "FG_ORM_DATA";

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

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_ORM_NUMBER = "ORM_NUMBER";

    private static final String COL_AD_CODE = "AD_CODE";

    private static final String COL_ORM_AMOUNT = "ORM_AMOUNT";

    private static final String COL_ORM_UTILIZED_AMT = "ORM_UTILIZED_AMT";

    private static final String COL_ORM_OS_AMT = "ORM_OS_AMT";

    private static final String COL_ORM_CCY = "ORM_CCY";

    private static final String COL_ORM_DATE = "ORM_DATE";

    private static final String COL_IE_NAME = "IE_NAME";

    private static final String COL_IE_CODE = "IE_CODE";

    private static final String COL_BENE_NAME = "BENE_NAME";

    private static final String COL_BENE_COUNTRY = "BENE_COUNTRY";

    private static final String COL_REMITTER_BANK_NAME = "REMITTER_BANK_NAME";

    private static final String COL_PUR_OF_REMIT = "PUR_OF_REMIT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ORM_NUMBER, COL_AD_CODE, COL_ORM_AMOUNT, COL_ORM_UTILIZED_AMT, COL_ORM_OS_AMT, COL_ORM_CCY, COL_ORM_DATE, COL_IE_NAME, COL_IE_CODE, COL_BENE_NAME, COL_BENE_COUNTRY, COL_REMITTER_BANK_NAME, COL_PUR_OF_REMIT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_OS_AMT, ORM_CCY, ORM_DATE, IE_NAME, IE_CODE, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_OS_AMT, ORM_CCY, ORM_DATE, IE_NAME, IE_CODE, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_IS_TEMPLATE, COL_ORM_NUMBER, COL_AD_CODE, COL_ORM_AMOUNT, COL_ORM_UTILIZED_AMT, COL_ORM_OS_AMT, COL_ORM_CCY, COL_ORM_DATE, COL_IE_NAME, COL_IE_CODE, COL_BENE_NAME, COL_BENE_COUNTRY, COL_REMITTER_BANK_NAME, COL_PUR_OF_REMIT, COL_ID);

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

    public int insert(Connection conn, FgOrmData fgormdata) throws SQLException {
        logger.debug("Inserting fgormdata: {}", fgormdata);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgOrmDataParams(ps, fgormdata);
            ps.executeUpdate();
            return fgormdata.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgOrmData> fgormdatas) throws SQLException {
        if (fgormdatas == null || fgormdatas.isEmpty())
            return new int[0];
        for (int i = 0; i < fgormdatas.size(); i++) {
            if (fgormdatas.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgOrmData>> batches = chunkList(fgormdatas, batchSize);
        int[] totalResults = new int[fgormdatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgOrmData> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgOrmData fgormdata : batch) {
                        setFgOrmDataParams(ps, fgormdata);
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

    public FgOrmData findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgOrmData> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgOrmData> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgOrmData fgormdata) throws SQLException {
        if (fgormdata.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgOrmDataParams(ps, fgormdata);
            ps.setInt(28, fgormdata.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgOrmData> fgormdatas) throws SQLException {
        if (fgormdatas == null || fgormdatas.isEmpty())
            return new int[0];
        for (FgOrmData fgormdata : fgormdatas) {
            if (fgormdata == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgormdata.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgOrmData>> batches = chunkList(fgormdatas, batchSize);
        int[] totalResults = new int[fgormdatas.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgOrmData> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgOrmData fgormdata : batch) {
                        setFgOrmDataParams(ps, fgormdata);
                        ps.setInt(28, fgormdata.getID());
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

    private void setFgOrmDataParams(PreparedStatement ps, FgOrmData fgormdata) throws SQLException {
        Integer val1 = fgormdata.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgormdata.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgormdata.getTypeCode());
        ps.setString(4, fgormdata.getSubTypeCode());
        ps.setString(5, fgormdata.getActiveCode());
        ps.setString(6, fgormdata.getStageCode());
        ps.setString(7, fgormdata.getStatusCode());
        ps.setString(8, fgormdata.getCreatedOn());
        java.math.BigDecimal val9 = fgormdata.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgormdata.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgormdata.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgormdata.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgormdata.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, fgormdata.getTemplate());
        java.math.BigDecimal val15 = fgormdata.getIsTemplate();
        if (val15 != null) {
            ps.setBigDecimal(15, val15);
        } else {
            ps.setNull(15, Types.DECIMAL);
        }
        ps.setString(16, fgormdata.getOrmNumber());
        ps.setString(17, fgormdata.getAdCode());
        java.math.BigDecimal val18 = fgormdata.getOrmAmount();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        java.math.BigDecimal val19 = fgormdata.getOrmUtilizedAmt();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        java.math.BigDecimal val20 = fgormdata.getOrmOsAmt();
        if (val20 != null) {
            ps.setBigDecimal(20, val20);
        } else {
            ps.setNull(20, Types.DECIMAL);
        }
        ps.setString(21, fgormdata.getOrmCcy());
        java.time.LocalDateTime val22 = fgormdata.getOrmDate();
        if (val22 != null) {
            ps.setTimestamp(22, java.sql.Timestamp.valueOf(val22));
        } else {
            ps.setNull(22, Types.TIMESTAMP);
        }
        ps.setString(23, fgormdata.getIeName());
        ps.setString(24, fgormdata.getIeCode());
        ps.setString(25, fgormdata.getBeneName());
        ps.setString(26, fgormdata.getBeneCountry());
        ps.setString(27, fgormdata.getRemitterBankName());
        ps.setString(28, fgormdata.getPurOfRemit());
    }

    private FgOrmData extract(ResultSet rs) throws SQLException {
        FgOrmData fgormdata = new FgOrmData();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgormdata.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgormdata.setReferenceID(REFERENCE_ID);
        fgormdata.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgormdata.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgormdata.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgormdata.setStageCode(rs.getString(COL_STAGE_CODE));
        fgormdata.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgormdata.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgormdata.setCreatedBy(CREATED_BY);
        fgormdata.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgormdata.setLastUpdatedBy(LAST_UPDATED_BY);
        fgormdata.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgormdata.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgormdata.setTemplate(rs.getString(COL_TEMPLATE));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgormdata.setIsTemplate(IS_TEMPLATE);
        fgormdata.setOrmNumber(rs.getString(COL_ORM_NUMBER));
        fgormdata.setAdCode(rs.getString(COL_AD_CODE));
        java.math.BigDecimal ORM_AMOUNT = rs.getObject(COL_ORM_AMOUNT, java.math.BigDecimal.class);
        fgormdata.setOrmAmount(ORM_AMOUNT);
        java.math.BigDecimal ORM_UTILIZED_AMT = rs.getObject(COL_ORM_UTILIZED_AMT, java.math.BigDecimal.class);
        fgormdata.setOrmUtilizedAmt(ORM_UTILIZED_AMT);
        java.math.BigDecimal ORM_OS_AMT = rs.getObject(COL_ORM_OS_AMT, java.math.BigDecimal.class);
        fgormdata.setOrmOsAmt(ORM_OS_AMT);
        fgormdata.setOrmCcy(rs.getString(COL_ORM_CCY));
        Timestamp ORM_DATE = rs.getTimestamp(COL_ORM_DATE);
        if (ORM_DATE != null)
            fgormdata.setOrmDate(ORM_DATE.toLocalDateTime());
        fgormdata.setIeName(rs.getString(COL_IE_NAME));
        fgormdata.setIeCode(rs.getString(COL_IE_CODE));
        fgormdata.setBeneName(rs.getString(COL_BENE_NAME));
        fgormdata.setBeneCountry(rs.getString(COL_BENE_COUNTRY));
        fgormdata.setRemitterBankName(rs.getString(COL_REMITTER_BANK_NAME));
        fgormdata.setPurOfRemit(rs.getString(COL_PUR_OF_REMIT));
        return fgormdata;
    }
}
