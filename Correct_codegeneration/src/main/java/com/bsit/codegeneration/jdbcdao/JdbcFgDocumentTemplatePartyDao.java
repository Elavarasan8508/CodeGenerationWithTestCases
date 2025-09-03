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

public class JdbcFgDocumentTemplatePartyDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgDocumentTemplatePartyDao.class);

    private static final String TABLE = "FG_DOCUMENT_TEMPLATE_PARTY";

    private static final String COL_ID = "ID";

    private static final String COL_PARTY_ID = "PARTY_ID";

    private static final String COL_PARTY_VERSION_ID = "PARTY_VERSION_ID";

    private static final String COL_DOCUMENT_ID = "DOCUMENT_ID";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_DOCUMENT_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, DOCUMENT_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, DOCUMENT_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_ID);

    private static final String SELECT_BY_DOCUMENT_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, PARTY_ID, PARTY_VERSION_ID, DOCUMENT_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY", TABLE, COL_DOCUMENT_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PARTY_ID, COL_PARTY_VERSION_ID, COL_DOCUMENT_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_ID);

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

    public int insert(Connection conn, FgDocumentTemplateParty fgdocumenttemplateparty) throws SQLException {
        logger.debug("Inserting fgdocumenttemplateparty: {}", fgdocumenttemplateparty);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgDocumentTemplatePartyParams(ps, fgdocumenttemplateparty);
            ps.executeUpdate();
            return fgdocumenttemplateparty.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgDocumentTemplateParty> fgdocumenttemplatepartys) throws SQLException {
        if (fgdocumenttemplatepartys == null || fgdocumenttemplatepartys.isEmpty())
            return new int[0];
        for (int i = 0; i < fgdocumenttemplatepartys.size(); i++) {
            if (fgdocumenttemplatepartys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDocumentTemplateParty>> batches = chunkList(fgdocumenttemplatepartys, batchSize);
        int[] totalResults = new int[fgdocumenttemplatepartys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDocumentTemplateParty> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgDocumentTemplateParty fgdocumenttemplateparty : batch) {
                        setFgDocumentTemplatePartyParams(ps, fgdocumenttemplateparty);
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

    public FgDocumentTemplateParty findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgDocumentTemplateParty> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgDocumentTemplateParty> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgDocumentTemplateParty fgdocumenttemplateparty) throws SQLException {
        if (fgdocumenttemplateparty.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgDocumentTemplatePartyParams(ps, fgdocumenttemplateparty);
            ps.setInt(12, fgdocumenttemplateparty.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgDocumentTemplateParty> fgdocumenttemplatepartys) throws SQLException {
        if (fgdocumenttemplatepartys == null || fgdocumenttemplatepartys.isEmpty())
            return new int[0];
        for (FgDocumentTemplateParty fgdocumenttemplateparty : fgdocumenttemplatepartys) {
            if (fgdocumenttemplateparty == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgdocumenttemplateparty.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgDocumentTemplateParty>> batches = chunkList(fgdocumenttemplatepartys, batchSize);
        int[] totalResults = new int[fgdocumenttemplatepartys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgDocumentTemplateParty> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgDocumentTemplateParty fgdocumenttemplateparty : batch) {
                        setFgDocumentTemplatePartyParams(ps, fgdocumenttemplateparty);
                        ps.setInt(12, fgdocumenttemplateparty.getID());
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

    public List<FgDocumentTemplateParty> findByDocumentID(Connection conn, int documentID) throws SQLException {
        List<FgDocumentTemplateParty> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_DOCUMENT_ID_SQL)) {
            ps.setInt(1, documentID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFgDocumentTemplatePartyParams(PreparedStatement ps, FgDocumentTemplateParty fgdocumenttemplateparty) throws SQLException {
        Integer val1 = fgdocumenttemplateparty.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgdocumenttemplateparty.getPartyID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        Integer val3 = fgdocumenttemplateparty.getPartyVersionID();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        if (fgdocumenttemplateparty.getDocument() != null) {
            ps.setInt(4, fgdocumenttemplateparty.getDocument().getFgDocumentTemplateID());
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, fgdocumenttemplateparty.getActiveCode());
        ps.setString(6, fgdocumenttemplateparty.getStatusCode());
        ps.setString(7, fgdocumenttemplateparty.getCreatedOn());
        java.math.BigDecimal val8 = fgdocumenttemplateparty.getCreatedBy();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, fgdocumenttemplateparty.getLastUpdatedOn());
        java.math.BigDecimal val10 = fgdocumenttemplateparty.getLastUpdatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgdocumenttemplateparty.getLastAuthorisedOn());
        java.math.BigDecimal val12 = fgdocumenttemplateparty.getLastAuthorisedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
    }

    private FgDocumentTemplateParty extract(ResultSet rs) throws SQLException {
        FgDocumentTemplateParty fgdocumenttemplateparty = new FgDocumentTemplateParty();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgdocumenttemplateparty.setID(ID);
        Integer PARTY_ID = rs.getObject(COL_PARTY_ID, Integer.class);
        fgdocumenttemplateparty.setPartyID(PARTY_ID);
        Integer PARTY_VERSION_ID = rs.getObject(COL_PARTY_VERSION_ID, Integer.class);
        fgdocumenttemplateparty.setPartyVersionID(PARTY_VERSION_ID);
        Integer DOCUMENT_ID = rs.getObject(COL_DOCUMENT_ID, Integer.class);
        fgdocumenttemplateparty.setDocumentID(DOCUMENT_ID);
        if (DOCUMENT_ID != null) {
            FgDocumentTemplate document = new FgDocumentTemplate();
            document.setFgDocumentTemplateID(DOCUMENT_ID);
            fgdocumenttemplateparty.setDocument(document);
        }
        fgdocumenttemplateparty.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgdocumenttemplateparty.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgdocumenttemplateparty.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgdocumenttemplateparty.setCreatedBy(CREATED_BY);
        fgdocumenttemplateparty.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgdocumenttemplateparty.setLastUpdatedBy(LAST_UPDATED_BY);
        fgdocumenttemplateparty.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgdocumenttemplateparty.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        return fgdocumenttemplateparty;
    }
}
