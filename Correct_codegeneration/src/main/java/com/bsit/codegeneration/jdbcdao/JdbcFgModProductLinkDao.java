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

public class JdbcFgModProductLinkDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModProductLinkDao.class);

    private static final String TABLE = "FG_MOD_PRODUCT_LINK";

    private static final String COL_ID = "ID";

    private static final String COL_REF_ID = "REF_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_CHILD_REF_ID = "CHILD_REF_ID";

    private static final String COL_CHILD_TYPE_CODE = "CHILD_TYPE_CODE";

    private static final String COL_CHILD_SUB_TYPE_CODE = "CHILD_SUB_TYPE_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_AMOUNT = "AMOUNT";

    private static final String COL_FACE_VALUE = "FACE_VALUE";

    private static final String COL_DISCOUNT_PERCENTAGE = "DISCOUNT_PERCENTAGE";

    private static final String COL_REQUEST_PERCENTAGE = "REQUEST_PERCENTAGE";

    private static final String COL_REQUESTED_AMOUNT = "REQUESTED_AMOUNT";

    private static final String COL_PROGRAM_CODE = "PROGRAM_CODE";

    private static final String COL_OFFER_CODE = "OFFER_CODE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REF_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_CHILD_REF_ID, COL_CHILD_TYPE_CODE, COL_CHILD_SUB_TYPE_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_AMOUNT, COL_FACE_VALUE, COL_DISCOUNT_PERCENTAGE, COL_REQUEST_PERCENTAGE, COL_REQUESTED_AMOUNT, COL_PROGRAM_CODE, COL_OFFER_CODE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REF_ID, TYPE_CODE, SUB_TYPE_CODE, CHILD_REF_ID, CHILD_TYPE_CODE, CHILD_SUB_TYPE_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, AMOUNT, FACE_VALUE, DISCOUNT_PERCENTAGE, REQUEST_PERCENTAGE, REQUESTED_AMOUNT, PROGRAM_CODE, OFFER_CODE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REF_ID, TYPE_CODE, SUB_TYPE_CODE, CHILD_REF_ID, CHILD_TYPE_CODE, CHILD_SUB_TYPE_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, AMOUNT, FACE_VALUE, DISCOUNT_PERCENTAGE, REQUEST_PERCENTAGE, REQUESTED_AMOUNT, PROGRAM_CODE, OFFER_CODE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REF_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_CHILD_REF_ID, COL_CHILD_TYPE_CODE, COL_CHILD_SUB_TYPE_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_AMOUNT, COL_FACE_VALUE, COL_DISCOUNT_PERCENTAGE, COL_REQUEST_PERCENTAGE, COL_REQUESTED_AMOUNT, COL_PROGRAM_CODE, COL_OFFER_CODE, COL_ID);

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

    public int insert(Connection conn, FgModProductLink fgmodproductlink) throws SQLException {
        logger.debug("Inserting fgmodproductlink: {}", fgmodproductlink);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModProductLinkParams(ps, fgmodproductlink);
            ps.executeUpdate();
            return fgmodproductlink.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModProductLink> fgmodproductlinks) throws SQLException {
        if (fgmodproductlinks == null || fgmodproductlinks.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodproductlinks.size(); i++) {
            if (fgmodproductlinks.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModProductLink>> batches = chunkList(fgmodproductlinks, batchSize);
        int[] totalResults = new int[fgmodproductlinks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModProductLink> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModProductLink fgmodproductlink : batch) {
                        setFgModProductLinkParams(ps, fgmodproductlink);
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

    public FgModProductLink findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModProductLink> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModProductLink> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModProductLink fgmodproductlink) throws SQLException {
        if (fgmodproductlink.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModProductLinkParams(ps, fgmodproductlink);
            ps.setInt(20, fgmodproductlink.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModProductLink> fgmodproductlinks) throws SQLException {
        if (fgmodproductlinks == null || fgmodproductlinks.isEmpty())
            return new int[0];
        for (FgModProductLink fgmodproductlink : fgmodproductlinks) {
            if (fgmodproductlink == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodproductlink.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModProductLink>> batches = chunkList(fgmodproductlinks, batchSize);
        int[] totalResults = new int[fgmodproductlinks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModProductLink> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModProductLink fgmodproductlink : batch) {
                        setFgModProductLinkParams(ps, fgmodproductlink);
                        ps.setInt(20, fgmodproductlink.getID());
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

    private void setFgModProductLinkParams(PreparedStatement ps, FgModProductLink fgmodproductlink) throws SQLException {
        Integer val1 = fgmodproductlink.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmodproductlink.getRefID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgmodproductlink.getTypeCode());
        ps.setString(4, fgmodproductlink.getSubTypeCode());
        Integer val5 = fgmodproductlink.getChildRefID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        ps.setString(6, fgmodproductlink.getChildTypeCode());
        ps.setString(7, fgmodproductlink.getChildSubTypeCode());
        ps.setString(8, fgmodproductlink.getCreatedOn());
        java.math.BigDecimal val9 = fgmodproductlink.getCreatedBy();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, fgmodproductlink.getLastUpdatedOn());
        java.math.BigDecimal val11 = fgmodproductlink.getLastUpdatedBy();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, fgmodproductlink.getLastAuthorisedOn());
        java.math.BigDecimal val13 = fgmodproductlink.getLastAuthorisedBy();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        java.math.BigDecimal val14 = fgmodproductlink.getAmount();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        Float val15 = fgmodproductlink.getFaceValue();
        if (val15 != null) {
            ps.setFloat(15, val15);
        } else {
            ps.setNull(15, Types.FLOAT);
        }
        ps.setString(16, fgmodproductlink.getDiscountPercentage());
        ps.setString(17, fgmodproductlink.getRequestPercentage());
        java.math.BigDecimal val18 = fgmodproductlink.getRequestedAmount();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgmodproductlink.getProgramCode());
        ps.setString(20, fgmodproductlink.getOfferCode());
    }

    private FgModProductLink extract(ResultSet rs) throws SQLException {
        FgModProductLink fgmodproductlink = new FgModProductLink();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodproductlink.setID(ID);
        Integer REF_ID = rs.getObject(COL_REF_ID, Integer.class);
        fgmodproductlink.setRefID(REF_ID);
        fgmodproductlink.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgmodproductlink.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        Integer CHILD_REF_ID = rs.getObject(COL_CHILD_REF_ID, Integer.class);
        fgmodproductlink.setChildRefID(CHILD_REF_ID);
        fgmodproductlink.setChildTypeCode(rs.getString(COL_CHILD_TYPE_CODE));
        fgmodproductlink.setChildSubTypeCode(rs.getString(COL_CHILD_SUB_TYPE_CODE));
        fgmodproductlink.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodproductlink.setCreatedBy(CREATED_BY);
        fgmodproductlink.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodproductlink.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodproductlink.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodproductlink.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        java.math.BigDecimal AMOUNT = rs.getObject(COL_AMOUNT, java.math.BigDecimal.class);
        fgmodproductlink.setAmount(AMOUNT);
        Float FACE_VALUE = rs.getObject(COL_FACE_VALUE, Float.class);
        fgmodproductlink.setFaceValue(FACE_VALUE);
        fgmodproductlink.setDiscountPercentage(rs.getString(COL_DISCOUNT_PERCENTAGE));
        fgmodproductlink.setRequestPercentage(rs.getString(COL_REQUEST_PERCENTAGE));
        java.math.BigDecimal REQUESTED_AMOUNT = rs.getObject(COL_REQUESTED_AMOUNT, java.math.BigDecimal.class);
        fgmodproductlink.setRequestedAmount(REQUESTED_AMOUNT);
        fgmodproductlink.setProgramCode(rs.getString(COL_PROGRAM_CODE));
        fgmodproductlink.setOfferCode(rs.getString(COL_OFFER_CODE));
        return fgmodproductlink;
    }
}
