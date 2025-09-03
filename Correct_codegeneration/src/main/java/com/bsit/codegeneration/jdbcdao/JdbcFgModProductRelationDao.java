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

public class JdbcFgModProductRelationDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgModProductRelationDao.class);

    private static final String TABLE = "FG_MOD_PRODUCT_RELATION";

    private static final String COL_ID = "ID";

    private static final String COL_REFERENCE_ID = "REFERENCE_ID";

    private static final String COL_TYPE_CODE = "TYPE_CODE";

    private static final String COL_SUB_TYPE_CODE = "SUB_TYPE_CODE";

    private static final String COL_SRC_REF_ID = "SRC_REF_ID";

    private static final String COL_SRC_TYPE_CODE = "SRC_TYPE_CODE";

    private static final String COL_SRC_SUB_TYPE_CODE = "SRC_SUB_TYPE_CODE";

    private static final String COL_SRC_RELATION_CODE = "SRC_RELATION_CODE";

    private static final String COL_SRC_APPLICANT_PARTY_ROLE = "SRC_APPLICANT_PARTY_ROLE";

    private static final String COL_SRC_APPLICANT_PARTY_CODE = "SRC_APPLICANT_PARTY_CODE";

    private static final String COL_SRC_ISSUING_PARTY_ROLE = "SRC_ISSUING_PARTY_ROLE";

    private static final String COL_SRC_ISSUING_PARTY_CODE = "SRC_ISSUING_PARTY_CODE";

    private static final String COL_TRG_REF_ID = "TRG_REF_ID";

    private static final String COL_TRG_TYPE_CODE = "TRG_TYPE_CODE";

    private static final String COL_TRG_SUB_TYPE_CODE = "TRG_SUB_TYPE_CODE";

    private static final String COL_TRG_RELATION_CODE = "TRG_RELATION_CODE";

    private static final String COL_TRG_APPLICANT_PARTY_ROLE = "TRG_APPLICANT_PARTY_ROLE";

    private static final String COL_TRG_APPLICANT_PARTY_CODE = "TRG_APPLICANT_PARTY_CODE";

    private static final String COL_TRG_ISSUING_PARTY_ROLE = "TRG_ISSUING_PARTY_ROLE";

    private static final String COL_TRG_ISSUING_PARTY_CODE = "TRG_ISSUING_PARTY_CODE";

    private static final String COL_TRG_FORM_ID = "TRG_FORM_ID";

    private static final String COL_ACTIVE_CODE = "ACTIVE_CODE";

    private static final String COL_STATUS_CODE = "STATUS_CODE";

    private static final String COL_CREATED_ON = "CREATED_ON";

    private static final String COL_CREATED_BY = "CREATED_BY";

    private static final String COL_LAST_UPDATED_ON = "LAST_UPDATED_ON";

    private static final String COL_LAST_UPDATED_BY = "LAST_UPDATED_BY";

    private static final String COL_LAST_AUTHORISED_ON = "LAST_AUTHORISED_ON";

    private static final String COL_LAST_AUTHORISED_BY = "LAST_AUTHORISED_BY";

    private static final String COL_SRC_VERSION_ID = "SRC_VERSION_ID";

    private static final String COL_TRG_VERSION_ID = "TRG_VERSION_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_SRC_REF_ID, COL_SRC_TYPE_CODE, COL_SRC_SUB_TYPE_CODE, COL_SRC_RELATION_CODE, COL_SRC_APPLICANT_PARTY_ROLE, COL_SRC_APPLICANT_PARTY_CODE, COL_SRC_ISSUING_PARTY_ROLE, COL_SRC_ISSUING_PARTY_CODE, COL_TRG_REF_ID, COL_TRG_TYPE_CODE, COL_TRG_SUB_TYPE_CODE, COL_TRG_RELATION_CODE, COL_TRG_APPLICANT_PARTY_ROLE, COL_TRG_APPLICANT_PARTY_CODE, COL_TRG_ISSUING_PARTY_ROLE, COL_TRG_ISSUING_PARTY_CODE, COL_TRG_FORM_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_SRC_VERSION_ID, COL_TRG_VERSION_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, SRC_REF_ID, SRC_TYPE_CODE, SRC_SUB_TYPE_CODE, SRC_RELATION_CODE, SRC_APPLICANT_PARTY_ROLE, SRC_APPLICANT_PARTY_CODE, SRC_ISSUING_PARTY_ROLE, SRC_ISSUING_PARTY_CODE, TRG_REF_ID, TRG_TYPE_CODE, TRG_SUB_TYPE_CODE, TRG_RELATION_CODE, TRG_APPLICANT_PARTY_ROLE, TRG_APPLICANT_PARTY_CODE, TRG_ISSUING_PARTY_ROLE, TRG_ISSUING_PARTY_CODE, TRG_FORM_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SRC_VERSION_ID, TRG_VERSION_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, SRC_REF_ID, SRC_TYPE_CODE, SRC_SUB_TYPE_CODE, SRC_RELATION_CODE, SRC_APPLICANT_PARTY_ROLE, SRC_APPLICANT_PARTY_CODE, SRC_ISSUING_PARTY_ROLE, SRC_ISSUING_PARTY_CODE, TRG_REF_ID, TRG_TYPE_CODE, TRG_SUB_TYPE_CODE, TRG_RELATION_CODE, TRG_APPLICANT_PARTY_ROLE, TRG_APPLICANT_PARTY_CODE, TRG_ISSUING_PARTY_ROLE, TRG_ISSUING_PARTY_CODE, TRG_FORM_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SRC_VERSION_ID, TRG_VERSION_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_SRC_REF_ID, COL_SRC_TYPE_CODE, COL_SRC_SUB_TYPE_CODE, COL_SRC_RELATION_CODE, COL_SRC_APPLICANT_PARTY_ROLE, COL_SRC_APPLICANT_PARTY_CODE, COL_SRC_ISSUING_PARTY_ROLE, COL_SRC_ISSUING_PARTY_CODE, COL_TRG_REF_ID, COL_TRG_TYPE_CODE, COL_TRG_SUB_TYPE_CODE, COL_TRG_RELATION_CODE, COL_TRG_APPLICANT_PARTY_ROLE, COL_TRG_APPLICANT_PARTY_CODE, COL_TRG_ISSUING_PARTY_ROLE, COL_TRG_ISSUING_PARTY_CODE, COL_TRG_FORM_ID, COL_ACTIVE_CODE, COL_STATUS_CODE, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_SRC_VERSION_ID, COL_TRG_VERSION_ID, COL_ID);

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

    public int insert(Connection conn, FgModProductRelation fgmodproductrelation) throws SQLException {
        logger.debug("Inserting fgmodproductrelation: {}", fgmodproductrelation);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgModProductRelationParams(ps, fgmodproductrelation);
            ps.executeUpdate();
            return fgmodproductrelation.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgModProductRelation> fgmodproductrelations) throws SQLException {
        if (fgmodproductrelations == null || fgmodproductrelations.isEmpty())
            return new int[0];
        for (int i = 0; i < fgmodproductrelations.size(); i++) {
            if (fgmodproductrelations.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModProductRelation>> batches = chunkList(fgmodproductrelations, batchSize);
        int[] totalResults = new int[fgmodproductrelations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModProductRelation> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgModProductRelation fgmodproductrelation : batch) {
                        setFgModProductRelationParams(ps, fgmodproductrelation);
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

    public FgModProductRelation findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgModProductRelation> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgModProductRelation> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgModProductRelation fgmodproductrelation) throws SQLException {
        if (fgmodproductrelation.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgModProductRelationParams(ps, fgmodproductrelation);
            ps.setInt(31, fgmodproductrelation.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgModProductRelation> fgmodproductrelations) throws SQLException {
        if (fgmodproductrelations == null || fgmodproductrelations.isEmpty())
            return new int[0];
        for (FgModProductRelation fgmodproductrelation : fgmodproductrelations) {
            if (fgmodproductrelation == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgmodproductrelation.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgModProductRelation>> batches = chunkList(fgmodproductrelations, batchSize);
        int[] totalResults = new int[fgmodproductrelations.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgModProductRelation> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgModProductRelation fgmodproductrelation : batch) {
                        setFgModProductRelationParams(ps, fgmodproductrelation);
                        ps.setInt(31, fgmodproductrelation.getID());
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

    private void setFgModProductRelationParams(PreparedStatement ps, FgModProductRelation fgmodproductrelation) throws SQLException {
        Integer val1 = fgmodproductrelation.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgmodproductrelation.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgmodproductrelation.getTypeCode());
        ps.setString(4, fgmodproductrelation.getSubTypeCode());
        Integer val5 = fgmodproductrelation.getSrcRefID();
        if (val5 != null) {
            ps.setInt(5, val5);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        ps.setString(6, fgmodproductrelation.getSrcTypeCode());
        ps.setString(7, fgmodproductrelation.getSrcSubTypeCode());
        ps.setString(8, fgmodproductrelation.getSrcRelationCode());
        ps.setString(9, fgmodproductrelation.getSrcApplicantPartyRole());
        ps.setString(10, fgmodproductrelation.getSrcApplicantPartyCode());
        ps.setString(11, fgmodproductrelation.getSrcIssuingPartyRole());
        ps.setString(12, fgmodproductrelation.getSrcIssuingPartyCode());
        Integer val13 = fgmodproductrelation.getTrgRefID();
        if (val13 != null) {
            ps.setInt(13, val13);
        } else {
            ps.setNull(13, Types.INTEGER);
        }
        ps.setString(14, fgmodproductrelation.getTrgTypeCode());
        ps.setString(15, fgmodproductrelation.getTrgSubTypeCode());
        ps.setString(16, fgmodproductrelation.getTrgRelationCode());
        ps.setString(17, fgmodproductrelation.getTrgApplicantPartyRole());
        ps.setString(18, fgmodproductrelation.getTrgApplicantPartyCode());
        ps.setString(19, fgmodproductrelation.getTrgIssuingPartyRole());
        ps.setString(20, fgmodproductrelation.getTrgIssuingPartyCode());
        Integer val21 = fgmodproductrelation.getTrgFormID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        ps.setString(22, fgmodproductrelation.getActiveCode());
        ps.setString(23, fgmodproductrelation.getStatusCode());
        ps.setString(24, fgmodproductrelation.getCreatedOn());
        java.math.BigDecimal val25 = fgmodproductrelation.getCreatedBy();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        ps.setString(26, fgmodproductrelation.getLastUpdatedOn());
        java.math.BigDecimal val27 = fgmodproductrelation.getLastUpdatedBy();
        if (val27 != null) {
            ps.setBigDecimal(27, val27);
        } else {
            ps.setNull(27, Types.DECIMAL);
        }
        ps.setString(28, fgmodproductrelation.getLastAuthorisedOn());
        java.math.BigDecimal val29 = fgmodproductrelation.getLastAuthorisedBy();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        Integer val30 = fgmodproductrelation.getSrcVersionID();
        if (val30 != null) {
            ps.setInt(30, val30);
        } else {
            ps.setNull(30, Types.INTEGER);
        }
        Integer val31 = fgmodproductrelation.getTrgVersionID();
        if (val31 != null) {
            ps.setInt(31, val31);
        } else {
            ps.setNull(31, Types.INTEGER);
        }
    }

    private FgModProductRelation extract(ResultSet rs) throws SQLException {
        FgModProductRelation fgmodproductrelation = new FgModProductRelation();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgmodproductrelation.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgmodproductrelation.setReferenceID(REFERENCE_ID);
        fgmodproductrelation.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgmodproductrelation.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        Integer SRC_REF_ID = rs.getObject(COL_SRC_REF_ID, Integer.class);
        fgmodproductrelation.setSrcRefID(SRC_REF_ID);
        fgmodproductrelation.setSrcTypeCode(rs.getString(COL_SRC_TYPE_CODE));
        fgmodproductrelation.setSrcSubTypeCode(rs.getString(COL_SRC_SUB_TYPE_CODE));
        fgmodproductrelation.setSrcRelationCode(rs.getString(COL_SRC_RELATION_CODE));
        fgmodproductrelation.setSrcApplicantPartyRole(rs.getString(COL_SRC_APPLICANT_PARTY_ROLE));
        fgmodproductrelation.setSrcApplicantPartyCode(rs.getString(COL_SRC_APPLICANT_PARTY_CODE));
        fgmodproductrelation.setSrcIssuingPartyRole(rs.getString(COL_SRC_ISSUING_PARTY_ROLE));
        fgmodproductrelation.setSrcIssuingPartyCode(rs.getString(COL_SRC_ISSUING_PARTY_CODE));
        Integer TRG_REF_ID = rs.getObject(COL_TRG_REF_ID, Integer.class);
        fgmodproductrelation.setTrgRefID(TRG_REF_ID);
        fgmodproductrelation.setTrgTypeCode(rs.getString(COL_TRG_TYPE_CODE));
        fgmodproductrelation.setTrgSubTypeCode(rs.getString(COL_TRG_SUB_TYPE_CODE));
        fgmodproductrelation.setTrgRelationCode(rs.getString(COL_TRG_RELATION_CODE));
        fgmodproductrelation.setTrgApplicantPartyRole(rs.getString(COL_TRG_APPLICANT_PARTY_ROLE));
        fgmodproductrelation.setTrgApplicantPartyCode(rs.getString(COL_TRG_APPLICANT_PARTY_CODE));
        fgmodproductrelation.setTrgIssuingPartyRole(rs.getString(COL_TRG_ISSUING_PARTY_ROLE));
        fgmodproductrelation.setTrgIssuingPartyCode(rs.getString(COL_TRG_ISSUING_PARTY_CODE));
        Integer TRG_FORM_ID = rs.getObject(COL_TRG_FORM_ID, Integer.class);
        fgmodproductrelation.setTrgFormID(TRG_FORM_ID);
        fgmodproductrelation.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgmodproductrelation.setStatusCode(rs.getString(COL_STATUS_CODE));
        fgmodproductrelation.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgmodproductrelation.setCreatedBy(CREATED_BY);
        fgmodproductrelation.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgmodproductrelation.setLastUpdatedBy(LAST_UPDATED_BY);
        fgmodproductrelation.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgmodproductrelation.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        Integer SRC_VERSION_ID = rs.getObject(COL_SRC_VERSION_ID, Integer.class);
        fgmodproductrelation.setSrcVersionID(SRC_VERSION_ID);
        Integer TRG_VERSION_ID = rs.getObject(COL_TRG_VERSION_ID, Integer.class);
        fgmodproductrelation.setTrgVersionID(TRG_VERSION_ID);
        return fgmodproductrelation;
    }
}
