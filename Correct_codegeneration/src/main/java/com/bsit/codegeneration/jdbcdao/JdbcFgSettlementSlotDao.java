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

public class JdbcFgSettlementSlotDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgSettlementSlotDao.class);

    private static final String TABLE = "FG_SETTLEMENT_SLOT";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STAGE_CODE = "STAGE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_PROCESS_ID = "PROCESS_ID";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_TEMPLATE = "TEMPLATE";

    private static final String COL_APPLICANT_PARTY = "APPLICANT_PARTY";

    private static final String COL_FULFILLMENT_PARTY = "FULFILLMENT_PARTY";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_CRON_EXPRESSION = "CRON_EXPRESSION";

    private static final String COL_MINUTES = "MINUTES";

    private static final String COL_HOURS = "HOURS";

    private static final String COL_DAYS = "DAYS";

    private static final String COL_SLOT = "SLOT";

    private static final String COL_PACKAGE_NAME = "PACKAGE_NAME";

    private static final String COL_IDENTIFIER = "IDENTIFIER";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_CRON_DESCRIPTION = "CRON_DESCRIPTION";

    private static final String COL_FROM_HOUR = "FROM_HOUR";

    private static final String COL_TO_HOUR = "TO_HOUR";

    private static final String COL_SLOT_TYPE = "SLOT_TYPE";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_CRON_EXPRESSION, COL_MINUTES, COL_HOURS, COL_DAYS, COL_SLOT, COL_PACKAGE_NAME, COL_IDENTIFIER, COL_STATUS, COL_CRON_DESCRIPTION, COL_FROM_HOUR, COL_TO_HOUR, COL_SLOT_TYPE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CRON_EXPRESSION, MINUTES, HOURS, DAYS, SLOT, PACKAGE_NAME, IDENTIFIER, STATUS, CRON_DESCRIPTION, FROM_HOUR, TO_HOUR, SLOT_TYPE", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CRON_EXPRESSION, MINUTES, HOURS, DAYS, SLOT, PACKAGE_NAME, IDENTIFIER, STATUS, CRON_DESCRIPTION, FROM_HOUR, TO_HOUR, SLOT_TYPE", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_CRON_EXPRESSION, COL_MINUTES, COL_HOURS, COL_DAYS, COL_SLOT, COL_PACKAGE_NAME, COL_IDENTIFIER, COL_STATUS, COL_CRON_DESCRIPTION, COL_FROM_HOUR, COL_TO_HOUR, COL_SLOT_TYPE, COL_ID);

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

    public int insert(Connection conn, FgSettlementSlot fgsettlementslot) throws SQLException {
        logger.debug("Inserting fgsettlementslot: {}", fgsettlementslot);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgSettlementSlotParams(ps, fgsettlementslot);
            ps.executeUpdate();
            return fgsettlementslot.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgSettlementSlot> fgsettlementslots) throws SQLException {
        if (fgsettlementslots == null || fgsettlementslots.isEmpty())
            return new int[0];
        for (int i = 0; i < fgsettlementslots.size(); i++) {
            if (fgsettlementslots.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSettlementSlot>> batches = chunkList(fgsettlementslots, batchSize);
        int[] totalResults = new int[fgsettlementslots.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSettlementSlot> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgSettlementSlot fgsettlementslot : batch) {
                        setFgSettlementSlotParams(ps, fgsettlementslot);
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

    public FgSettlementSlot findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgSettlementSlot> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgSettlementSlot> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgSettlementSlot fgsettlementslot) throws SQLException {
        if (fgsettlementslot.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgSettlementSlotParams(ps, fgsettlementslot);
            ps.setInt(30, fgsettlementslot.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgSettlementSlot> fgsettlementslots) throws SQLException {
        if (fgsettlementslots == null || fgsettlementslots.isEmpty())
            return new int[0];
        for (FgSettlementSlot fgsettlementslot : fgsettlementslots) {
            if (fgsettlementslot == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgsettlementslot.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgSettlementSlot>> batches = chunkList(fgsettlementslots, batchSize);
        int[] totalResults = new int[fgsettlementslots.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgSettlementSlot> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgSettlementSlot fgsettlementslot : batch) {
                        setFgSettlementSlotParams(ps, fgsettlementslot);
                        ps.setInt(30, fgsettlementslot.getID());
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

    private void setFgSettlementSlotParams(PreparedStatement ps, FgSettlementSlot fgsettlementslot) throws SQLException {
        Integer val1 = fgsettlementslot.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgsettlementslot.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgsettlementslot.getTypeCode());
        ps.setString(4, fgsettlementslot.getSubTypeCode());
        ps.setString(5, fgsettlementslot.getActiveCode());
        ps.setString(6, fgsettlementslot.getStageCode());
        ps.setString(7, fgsettlementslot.getStatusCode());
        Integer val8 = fgsettlementslot.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgsettlementslot.getCreatedOn());
        java.math.BigDecimal val10 = fgsettlementslot.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgsettlementslot.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgsettlementslot.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgsettlementslot.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgsettlementslot.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgsettlementslot.getTemplate());
        ps.setString(16, fgsettlementslot.getApplicantParty());
        ps.setString(17, fgsettlementslot.getFulfillmentParty());
        java.math.BigDecimal val18 = fgsettlementslot.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgsettlementslot.getCronExpression());
        ps.setString(20, fgsettlementslot.getMinutes());
        ps.setString(21, fgsettlementslot.getHours());
        ps.setString(22, fgsettlementslot.getDays());
        ps.setString(23, fgsettlementslot.getSlot());
        ps.setString(24, fgsettlementslot.getPackageName());
        ps.setString(25, fgsettlementslot.getIdentifier());
        ps.setString(26, fgsettlementslot.getStatus());
        ps.setString(27, fgsettlementslot.getCronDescription());
        ps.setString(28, fgsettlementslot.getFromHour());
        ps.setString(29, fgsettlementslot.getToHour());
        ps.setString(30, fgsettlementslot.getSlotType());
    }

    private FgSettlementSlot extract(ResultSet rs) throws SQLException {
        FgSettlementSlot fgsettlementslot = new FgSettlementSlot();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgsettlementslot.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgsettlementslot.setReferenceID(REFERENCE_ID);
        fgsettlementslot.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgsettlementslot.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgsettlementslot.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgsettlementslot.setStageCode(rs.getString(COL_STAGE_CODE));
        fgsettlementslot.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgsettlementslot.setProcessID(PROCESS_ID);
        fgsettlementslot.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgsettlementslot.setCreatedBy(CREATED_BY);
        fgsettlementslot.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgsettlementslot.setLastUpdatedBy(LAST_UPDATED_BY);
        fgsettlementslot.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgsettlementslot.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgsettlementslot.setTemplate(rs.getString(COL_TEMPLATE));
        fgsettlementslot.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgsettlementslot.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgsettlementslot.setIsTemplate(IS_TEMPLATE);
        fgsettlementslot.setCronExpression(rs.getString(COL_CRON_EXPRESSION));
        fgsettlementslot.setMinutes(rs.getString(COL_MINUTES));
        fgsettlementslot.setHours(rs.getString(COL_HOURS));
        fgsettlementslot.setDays(rs.getString(COL_DAYS));
        fgsettlementslot.setSlot(rs.getString(COL_SLOT));
        fgsettlementslot.setPackageName(rs.getString(COL_PACKAGE_NAME));
        fgsettlementslot.setIdentifier(rs.getString(COL_IDENTIFIER));
        fgsettlementslot.setStatus(rs.getString(COL_STATUS));
        fgsettlementslot.setCronDescription(rs.getString(COL_CRON_DESCRIPTION));
        fgsettlementslot.setFromHour(rs.getString(COL_FROM_HOUR));
        fgsettlementslot.setToHour(rs.getString(COL_TO_HOUR));
        fgsettlementslot.setSlotType(rs.getString(COL_SLOT_TYPE));
        return fgsettlementslot;
    }
}
