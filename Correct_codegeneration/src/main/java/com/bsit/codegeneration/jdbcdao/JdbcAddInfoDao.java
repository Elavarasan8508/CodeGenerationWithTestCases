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

public class JdbcAddInfoDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcAddInfoDao.class);

    private static final String TABLE = "ADD_INFO";

    private static final String COL_ID = "ID";

    private static final String COL_ADDRESS = "ADDRESS";

    private static final String COL_EMPLOYEE_ID = "EMPLOYEE_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_ADDRESS, COL_EMPLOYEE_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, ADDRESS, EMPLOYEE_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, ADDRESS, EMPLOYEE_ID", TABLE, COL_ID);

    private static final String SELECT_BY_EMPLOYEE_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, ADDRESS, EMPLOYEE_ID", TABLE, COL_EMPLOYEE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ADDRESS, COL_EMPLOYEE_ID, COL_ID);

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

    public int insert(Connection conn, AddInfo addinfo) throws SQLException {
        logger.debug("Inserting addinfo: {}", addinfo);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setAddInfoParams(ps, addinfo);
            ps.executeUpdate();
            return addinfo.getID();
        }
    }

    public int[] insertAll(Connection conn, List<AddInfo> addinfos) throws SQLException {
        if (addinfos == null || addinfos.isEmpty())
            return new int[0];
        for (int i = 0; i < addinfos.size(); i++) {
            if (addinfos.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<AddInfo>> batches = chunkList(addinfos, batchSize);
        int[] totalResults = new int[addinfos.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<AddInfo> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (AddInfo addinfo : batch) {
                        setAddInfoParams(ps, addinfo);
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

    public AddInfo findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<AddInfo> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<AddInfo> list = new ArrayList<>();
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

    public boolean update(Connection conn, AddInfo addinfo) throws SQLException {
        if (addinfo.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setAddInfoParams(ps, addinfo);
            ps.setInt(3, addinfo.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<AddInfo> addinfos) throws SQLException {
        if (addinfos == null || addinfos.isEmpty())
            return new int[0];
        for (AddInfo addinfo : addinfos) {
            if (addinfo == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (addinfo.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<AddInfo>> batches = chunkList(addinfos, batchSize);
        int[] totalResults = new int[addinfos.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<AddInfo> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (AddInfo addinfo : batch) {
                        setAddInfoParams(ps, addinfo);
                        ps.setInt(3, addinfo.getID());
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

    public List<AddInfo> findByEmployeeID(Connection conn, int employeeID) throws SQLException {
        List<AddInfo> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_EMPLOYEE_ID_SQL)) {
            ps.setInt(1, employeeID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setAddInfoParams(PreparedStatement ps, AddInfo addinfo) throws SQLException {
        Integer val1 = addinfo.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        ps.setString(2, addinfo.getAddress());
        if (addinfo.getEmployee() != null) {
            ps.setInt(3, addinfo.getEmployee().getEmpInfoID());
        } else {
            ps.setNull(3, Types.INTEGER);
        }
    }

    private AddInfo extract(ResultSet rs) throws SQLException {
        AddInfo addinfo = new AddInfo();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        addinfo.setID(ID);
        addinfo.setAddress(rs.getString(COL_ADDRESS));
        Integer EMPLOYEE_ID = rs.getObject(COL_EMPLOYEE_ID, Integer.class);
        addinfo.setEmployeeID(EMPLOYEE_ID);
        if (EMPLOYEE_ID != null) {
            EmpInfo employee = new EmpInfo();
            employee.setEmpInfoID(EMPLOYEE_ID);
            addinfo.setEmployee(employee);
        }
        return addinfo;
    }
}
