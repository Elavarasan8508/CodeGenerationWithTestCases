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

public class JdbcServicelogBkDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcServicelogBkDao.class);

    private static final String TABLE = "SERVICELOG_BK";

    private static final String COL_ID = "ID";

    private static final String COL_SERVICE = "SERVICE";

    private static final String COL_OPERATION = "OPERATION";

    private static final String COL_ZONE = "ZONE";

    private static final String COL_BRANCH = "BRANCH";

    private static final String COL_SOURCESYSTEM = "SOURCESYSTEM";

    private static final String COL_TARGETSYSTEM = "TARGETSYSTEM";

    private static final String COL_MASTERREFERENCE = "MASTERREFERENCE";

    private static final String COL_EVENTREFERENCE = "EVENTREFERENCE";

    private static final String COL_STATUS = "STATUS";

    private static final String COL_PROCESSTIME = "PROCESSTIME";

    private static final String COL_TIREQUEST = "TIREQUEST";

    private static final String COL_TIRESPONSE = "TIRESPONSE";

    private static final String COL_BANKREQUEST = "BANKREQUEST";

    private static final String COL_BANKRESPONSE = "BANKRESPONSE";

    private static final String COL_TIREQTIME = "TIREQTIME";

    private static final String COL_BANKREQTIME = "BANKREQTIME";

    private static final String COL_BANKRESTIME = "BANKRESTIME";

    private static final String COL_TIRESTIME = "TIRESTIME";

    private static final String COL_TRANSACTIONKEY1 = "TRANSACTIONKEY1";

    private static final String COL_STATICKEY1 = "STATICKEY1";

    private static final String COL_NARRATIVE1 = "NARRATIVE1";

    private static final String COL_NARRATIVE2 = "NARRATIVE2";

    private static final String COL_ISRESUBMITTED = "ISRESUBMITTED";

    private static final String COL_RESUBMITTEDCOUNT = "RESUBMITTEDCOUNT";

    private static final String COL_RESUBMITTEDTIME = "RESUBMITTEDTIME";

    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String COL_TYPEFLAG = "TYPEFLAG";

    private static final String COL_NODE = "NODE";

    private static final String COL_VALUEDATE = "VALUEDATE";

    private static final String COL_NUMBER1 = "NUMBER1";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_SERVICE, COL_OPERATION, COL_ZONE, COL_BRANCH, COL_SOURCESYSTEM, COL_TARGETSYSTEM, COL_MASTERREFERENCE, COL_EVENTREFERENCE, COL_STATUS, COL_PROCESSTIME, COL_TIREQUEST, COL_TIRESPONSE, COL_BANKREQUEST, COL_BANKRESPONSE, COL_TIREQTIME, COL_BANKREQTIME, COL_BANKRESTIME, COL_TIRESTIME, COL_TRANSACTIONKEY1, COL_STATICKEY1, COL_NARRATIVE1, COL_NARRATIVE2, COL_ISRESUBMITTED, COL_RESUBMITTEDCOUNT, COL_RESUBMITTEDTIME, COL_DESCRIPTION, COL_TYPEFLAG, COL_NODE, COL_VALUEDATE, COL_NUMBER1);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, SERVICE, OPERATION, ZONE, BRANCH, SOURCESYSTEM, TARGETSYSTEM, MASTERREFERENCE, EVENTREFERENCE, STATUS, PROCESSTIME, TIREQUEST, TIRESPONSE, BANKREQUEST, BANKRESPONSE, TIREQTIME, BANKREQTIME, BANKRESTIME, TIRESTIME, TRANSACTIONKEY1, STATICKEY1, NARRATIVE1, NARRATIVE2, ISRESUBMITTED, RESUBMITTEDCOUNT, RESUBMITTEDTIME, DESCRIPTION, TYPEFLAG, NODE, VALUEDATE, NUMBER1", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, SERVICE, OPERATION, ZONE, BRANCH, SOURCESYSTEM, TARGETSYSTEM, MASTERREFERENCE, EVENTREFERENCE, STATUS, PROCESSTIME, TIREQUEST, TIRESPONSE, BANKREQUEST, BANKRESPONSE, TIREQTIME, BANKREQTIME, BANKRESTIME, TIRESTIME, TRANSACTIONKEY1, STATICKEY1, NARRATIVE1, NARRATIVE2, ISRESUBMITTED, RESUBMITTEDCOUNT, RESUBMITTEDTIME, DESCRIPTION, TYPEFLAG, NODE, VALUEDATE, NUMBER1", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_SERVICE, COL_OPERATION, COL_ZONE, COL_BRANCH, COL_SOURCESYSTEM, COL_TARGETSYSTEM, COL_MASTERREFERENCE, COL_EVENTREFERENCE, COL_STATUS, COL_PROCESSTIME, COL_TIREQUEST, COL_TIRESPONSE, COL_BANKREQUEST, COL_BANKRESPONSE, COL_TIREQTIME, COL_BANKREQTIME, COL_BANKRESTIME, COL_TIRESTIME, COL_TRANSACTIONKEY1, COL_STATICKEY1, COL_NARRATIVE1, COL_NARRATIVE2, COL_ISRESUBMITTED, COL_RESUBMITTEDCOUNT, COL_RESUBMITTEDTIME, COL_DESCRIPTION, COL_TYPEFLAG, COL_NODE, COL_VALUEDATE, COL_NUMBER1, COL_ID);

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

    public int insert(Connection conn, ServicelogBk servicelogbk) throws SQLException {
        logger.debug("Inserting servicelogbk: {}", servicelogbk);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setServicelogBkParams(ps, servicelogbk);
            ps.executeUpdate();
            return servicelogbk.getID();
        }
    }

    public int[] insertAll(Connection conn, List<ServicelogBk> servicelogbks) throws SQLException {
        if (servicelogbks == null || servicelogbks.isEmpty())
            return new int[0];
        for (int i = 0; i < servicelogbks.size(); i++) {
            if (servicelogbks.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ServicelogBk>> batches = chunkList(servicelogbks, batchSize);
        int[] totalResults = new int[servicelogbks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ServicelogBk> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (ServicelogBk servicelogbk : batch) {
                        setServicelogBkParams(ps, servicelogbk);
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

    public ServicelogBk findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<ServicelogBk> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<ServicelogBk> list = new ArrayList<>();
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

    public boolean update(Connection conn, ServicelogBk servicelogbk) throws SQLException {
        if (servicelogbk.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setServicelogBkParams(ps, servicelogbk);
            ps.setInt(31, servicelogbk.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<ServicelogBk> servicelogbks) throws SQLException {
        if (servicelogbks == null || servicelogbks.isEmpty())
            return new int[0];
        for (ServicelogBk servicelogbk : servicelogbks) {
            if (servicelogbk == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (servicelogbk.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<ServicelogBk>> batches = chunkList(servicelogbks, batchSize);
        int[] totalResults = new int[servicelogbks.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<ServicelogBk> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (ServicelogBk servicelogbk : batch) {
                        setServicelogBkParams(ps, servicelogbk);
                        ps.setInt(31, servicelogbk.getID());
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

    private void setServicelogBkParams(PreparedStatement ps, ServicelogBk servicelogbk) throws SQLException {
        Integer val1 = servicelogbk.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, servicelogbk.getService());
        ps.setString(3, servicelogbk.getOperation());
        ps.setString(4, servicelogbk.getZone());
        ps.setString(5, servicelogbk.getBranch());
        ps.setString(6, servicelogbk.getSourcesystem());
        ps.setString(7, servicelogbk.getTargetsystem());
        ps.setString(8, servicelogbk.getMasterreference());
        ps.setString(9, servicelogbk.getEventreference());
        ps.setString(10, servicelogbk.getStatus());
        ps.setString(11, servicelogbk.getProcesstime());
        ps.setString(12, servicelogbk.getTirequest());
        ps.setString(13, servicelogbk.getTiresponse());
        ps.setString(14, servicelogbk.getBankrequest());
        ps.setString(15, servicelogbk.getBankresponse());
        ps.setString(16, servicelogbk.getTireqtime());
        ps.setString(17, servicelogbk.getBankreqtime());
        ps.setString(18, servicelogbk.getBankrestime());
        ps.setString(19, servicelogbk.getTirestime());
        ps.setString(20, servicelogbk.getTransactionkey1());
        ps.setString(21, servicelogbk.getStatickey1());
        ps.setString(22, servicelogbk.getNarrative1());
        ps.setString(23, servicelogbk.getNarrative2());
        ps.setString(24, servicelogbk.getIsresubmitted());
        java.math.BigDecimal val25 = servicelogbk.getResubmittedcount();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, servicelogbk.getResubmittedtime());
        ps.setString(27, servicelogbk.getDescription());
        ps.setString(28, servicelogbk.getTypeflag());
        ps.setString(29, servicelogbk.getNode());
        java.time.LocalDateTime val30 = servicelogbk.getValuedate();
        if (val30 != null) {
            ps.setTimestamp(30, java.sql.Timestamp.valueOf(val30));
        } else {
            ps.setNull(30, Types.TIMESTAMP);
        }
        java.math.BigDecimal val31 = servicelogbk.getNumber1();
        if (val31 != null) {
            ps.setBigDecimal(31, val31);
        } else {
            ps.setNull(31, Types.DECIMAL);
        }
    }

    private ServicelogBk extract(ResultSet rs) throws SQLException {
        ServicelogBk servicelogbk = new ServicelogBk();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        servicelogbk.setID(ID);
        servicelogbk.setService(rs.getString(COL_SERVICE));
        servicelogbk.setOperation(rs.getString(COL_OPERATION));
        servicelogbk.setZone(rs.getString(COL_ZONE));
        servicelogbk.setBranch(rs.getString(COL_BRANCH));
        servicelogbk.setSourcesystem(rs.getString(COL_SOURCESYSTEM));
        servicelogbk.setTargetsystem(rs.getString(COL_TARGETSYSTEM));
        servicelogbk.setMasterreference(rs.getString(COL_MASTERREFERENCE));
        servicelogbk.setEventreference(rs.getString(COL_EVENTREFERENCE));
        servicelogbk.setStatus(rs.getString(COL_STATUS));
        servicelogbk.setProcesstime(rs.getString(COL_PROCESSTIME));
        servicelogbk.setTirequest(rs.getString(COL_TIREQUEST));
        servicelogbk.setTiresponse(rs.getString(COL_TIRESPONSE));
        servicelogbk.setBankrequest(rs.getString(COL_BANKREQUEST));
        servicelogbk.setBankresponse(rs.getString(COL_BANKRESPONSE));
        servicelogbk.setTireqtime(rs.getString(COL_TIREQTIME));
        servicelogbk.setBankreqtime(rs.getString(COL_BANKREQTIME));
        servicelogbk.setBankrestime(rs.getString(COL_BANKRESTIME));
        servicelogbk.setTirestime(rs.getString(COL_TIRESTIME));
        servicelogbk.setTransactionkey1(rs.getString(COL_TRANSACTIONKEY1));
        servicelogbk.setStatickey1(rs.getString(COL_STATICKEY1));
        servicelogbk.setNarrative1(rs.getString(COL_NARRATIVE1));
        servicelogbk.setNarrative2(rs.getString(COL_NARRATIVE2));
        servicelogbk.setIsresubmitted(rs.getString(COL_ISRESUBMITTED));
        java.math.BigDecimal RESUBMITTEDCOUNT = rs.getObject(COL_RESUBMITTEDCOUNT, java.math.BigDecimal.class);
        servicelogbk.setResubmittedcount(RESUBMITTEDCOUNT);
        servicelogbk.setResubmittedtime(rs.getString(COL_RESUBMITTEDTIME));
        servicelogbk.setDescription(rs.getString(COL_DESCRIPTION));
        servicelogbk.setTypeflag(rs.getString(COL_TYPEFLAG));
        servicelogbk.setNode(rs.getString(COL_NODE));
        Timestamp VALUEDATE = rs.getTimestamp(COL_VALUEDATE);
        if (VALUEDATE != null)
            servicelogbk.setValuedate(VALUEDATE.toLocalDateTime());
        java.math.BigDecimal NUMBER1 = rs.getObject(COL_NUMBER1, java.math.BigDecimal.class);
        servicelogbk.setNumber1(NUMBER1);
        return servicelogbk;
    }
}
