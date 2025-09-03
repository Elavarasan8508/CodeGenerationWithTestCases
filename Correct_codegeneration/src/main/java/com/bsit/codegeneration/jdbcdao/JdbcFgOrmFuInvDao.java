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

public class JdbcFgOrmFuInvDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFgOrmFuInvDao.class);

    private static final String TABLE = "FG_ORM_FU_INV";

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

    private static final String COL_INV_NO = "INV_NO";

    private static final String COL_HS_CODE = "HS_CODE";

    private static final String COL_PORT_OF_LOADING = "PORT_OF_LOADING";

    private static final String COL_VESSEL_NAME = "VESSEL_NAME";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_INV_DATE = "INV_DATE";

    private static final String COL_INV_AMOUNT = "INV_AMOUNT";

    private static final String COL_INV_CCY = "INV_CCY";

    private static final String COL_BOE_NUM = "BOE_NUM";

    private static final String COL_BOE_DATE = "BOE_DATE";

    private static final String COL_TRANSPORT_DOC_NUM = "TRANSPORT_DOC_NUM";

    private static final String COL_PORT_OF_DISCHARGE = "PORT_OF_DISCHARGE";

    private static final String COL_GOODS_DES = "GOODS_DES";

    private static final String COL_BOE_AD_CODE = "BOE_AD_CODE";

    private static final String COL_COUNTRY_ORIG_GOOD = "COUNTRY_ORIG_GOOD";

    private static final String COL_BOE_NUMBER = "BOE_NUMBER";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String COL_MIGRATION_BOE_SUPL_COUNTRY = "MIGRATION_BOE_SUPL_COUNTRY";

    private static final String COL_SELLER_NAME = "SELLER_NAME";

    private static final String COL_SUPPLIER_ADDR = "SUPPLIER_ADDR";

    private static final String COL_SUPPLIER_COUNTRY = "SUPPLIER_COUNTRY";

    private static final String COL_SUPPLIER_NAME = "SUPPLIER_NAME";

    private static final String COL_OS_INV_AMT = "OS_INV_AMT";

    private static final String COL_INV_AMT = "INV_AMT";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_INV_NO, COL_HS_CODE, COL_PORT_OF_LOADING, COL_VESSEL_NAME, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_INV_DATE, COL_INV_AMOUNT, COL_INV_CCY, COL_BOE_NUM, COL_BOE_DATE, COL_TRANSPORT_DOC_NUM, COL_PORT_OF_DISCHARGE, COL_GOODS_DES, COL_BOE_AD_CODE, COL_COUNTRY_ORIG_GOOD, COL_BOE_NUMBER, COL_LINE_NO, COL_MIGRATION_BOE_SUPL_COUNTRY, COL_SELLER_NAME, COL_SUPPLIER_ADDR, COL_SUPPLIER_COUNTRY, COL_SUPPLIER_NAME, COL_OS_INV_AMT, COL_INV_AMT);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INV_NO, HS_CODE, PORT_OF_LOADING, VESSEL_NAME, PARENT_REF_ID, PARENT_VERSION_ID, INV_DATE, INV_AMOUNT, INV_CCY, BOE_NUM, BOE_DATE, TRANSPORT_DOC_NUM, PORT_OF_DISCHARGE, GOODS_DES, BOE_AD_CODE, COUNTRY_ORIG_GOOD, BOE_NUMBER, LINE_NO, MIGRATION_BOE_SUPL_COUNTRY, SELLER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SUPPLIER_NAME, OS_INV_AMT, INV_AMT", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INV_NO, HS_CODE, PORT_OF_LOADING, VESSEL_NAME, PARENT_REF_ID, PARENT_VERSION_ID, INV_DATE, INV_AMOUNT, INV_CCY, BOE_NUM, BOE_DATE, TRANSPORT_DOC_NUM, PORT_OF_DISCHARGE, GOODS_DES, BOE_AD_CODE, COUNTRY_ORIG_GOOD, BOE_NUMBER, LINE_NO, MIGRATION_BOE_SUPL_COUNTRY, SELLER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SUPPLIER_NAME, OS_INV_AMT, INV_AMT", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_INV_NO, COL_HS_CODE, COL_PORT_OF_LOADING, COL_VESSEL_NAME, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_INV_DATE, COL_INV_AMOUNT, COL_INV_CCY, COL_BOE_NUM, COL_BOE_DATE, COL_TRANSPORT_DOC_NUM, COL_PORT_OF_DISCHARGE, COL_GOODS_DES, COL_BOE_AD_CODE, COL_COUNTRY_ORIG_GOOD, COL_BOE_NUMBER, COL_LINE_NO, COL_MIGRATION_BOE_SUPL_COUNTRY, COL_SELLER_NAME, COL_SUPPLIER_ADDR, COL_SUPPLIER_COUNTRY, COL_SUPPLIER_NAME, COL_OS_INV_AMT, COL_INV_AMT, COL_ID);

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

    public int insert(Connection conn, FgOrmFuInv fgormfuinv) throws SQLException {
        logger.debug("Inserting fgormfuinv: {}", fgormfuinv);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFgOrmFuInvParams(ps, fgormfuinv);
            ps.executeUpdate();
            return fgormfuinv.getID();
        }
    }

    public int[] insertAll(Connection conn, List<FgOrmFuInv> fgormfuinvs) throws SQLException {
        if (fgormfuinvs == null || fgormfuinvs.isEmpty())
            return new int[0];
        for (int i = 0; i < fgormfuinvs.size(); i++) {
            if (fgormfuinvs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgOrmFuInv>> batches = chunkList(fgormfuinvs, batchSize);
        int[] totalResults = new int[fgormfuinvs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgOrmFuInv> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FgOrmFuInv fgormfuinv : batch) {
                        setFgOrmFuInvParams(ps, fgormfuinv);
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

    public FgOrmFuInv findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FgOrmFuInv> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FgOrmFuInv> list = new ArrayList<>();
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

    public boolean update(Connection conn, FgOrmFuInv fgormfuinv) throws SQLException {
        if (fgormfuinv.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFgOrmFuInvParams(ps, fgormfuinv);
            ps.setInt(43, fgormfuinv.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FgOrmFuInv> fgormfuinvs) throws SQLException {
        if (fgormfuinvs == null || fgormfuinvs.isEmpty())
            return new int[0];
        for (FgOrmFuInv fgormfuinv : fgormfuinvs) {
            if (fgormfuinv == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (fgormfuinv.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<FgOrmFuInv>> batches = chunkList(fgormfuinvs, batchSize);
        int[] totalResults = new int[fgormfuinvs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<FgOrmFuInv> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FgOrmFuInv fgormfuinv : batch) {
                        setFgOrmFuInvParams(ps, fgormfuinv);
                        ps.setInt(43, fgormfuinv.getID());
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

    private void setFgOrmFuInvParams(PreparedStatement ps, FgOrmFuInv fgormfuinv) throws SQLException {
        Integer val1 = fgormfuinv.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = fgormfuinv.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, fgormfuinv.getTypeCode());
        ps.setString(4, fgormfuinv.getSubTypeCode());
        ps.setString(5, fgormfuinv.getActiveCode());
        ps.setString(6, fgormfuinv.getStageCode());
        ps.setString(7, fgormfuinv.getStatusCode());
        Integer val8 = fgormfuinv.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, fgormfuinv.getCreatedOn());
        java.math.BigDecimal val10 = fgormfuinv.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, fgormfuinv.getLastUpdatedOn());
        java.math.BigDecimal val12 = fgormfuinv.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, fgormfuinv.getLastAuthorisedOn());
        java.math.BigDecimal val14 = fgormfuinv.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, fgormfuinv.getTemplate());
        ps.setString(16, fgormfuinv.getApplicantParty());
        ps.setString(17, fgormfuinv.getFulfillmentParty());
        java.math.BigDecimal val18 = fgormfuinv.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, fgormfuinv.getInvNo());
        ps.setString(20, fgormfuinv.getHsCode());
        ps.setString(21, fgormfuinv.getPortOfLoading());
        ps.setString(22, fgormfuinv.getVesselName());
        Integer val23 = fgormfuinv.getParentRefID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        Integer val24 = fgormfuinv.getParentVersionID();
        if (val24 != null) {
            ps.setInt(24, val24);
        } else {
            ps.setNull(24, Types.INTEGER);
        }
        java.time.LocalDateTime val25 = fgormfuinv.getInvDate();
        if (val25 != null) {
            ps.setTimestamp(25, java.sql.Timestamp.valueOf(val25));
        } else {
            ps.setNull(25, Types.TIMESTAMP);
        }
        java.math.BigDecimal val26 = fgormfuinv.getInvAmount();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, fgormfuinv.getInvCcy());
        ps.setString(28, fgormfuinv.getBoeNum());
        java.time.LocalDateTime val29 = fgormfuinv.getBoeDate();
        if (val29 != null) {
            ps.setTimestamp(29, java.sql.Timestamp.valueOf(val29));
        } else {
            ps.setNull(29, Types.TIMESTAMP);
        }
        ps.setString(30, fgormfuinv.getTransportDocNum());
        ps.setString(31, fgormfuinv.getPortOfDischarge());
        ps.setString(32, fgormfuinv.getGoodsDes());
        ps.setString(33, fgormfuinv.getBoeAdCode());
        ps.setString(34, fgormfuinv.getCountryOrigGood());
        ps.setString(35, fgormfuinv.getBoeNumber());
        java.math.BigDecimal val36 = fgormfuinv.getLineNo();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        ps.setString(37, fgormfuinv.getMigrationBoeSuplCountry());
        ps.setString(38, fgormfuinv.getSellerName());
        ps.setString(39, fgormfuinv.getSupplierAddr());
        ps.setString(40, fgormfuinv.getSupplierCountry());
        ps.setString(41, fgormfuinv.getSupplierName());
        java.math.BigDecimal val42 = fgormfuinv.getOsInvAmt();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        java.math.BigDecimal val43 = fgormfuinv.getInvAmt();
        if (val43 != null) {
            ps.setBigDecimal(43, val43);
        } else {
            ps.setNull(43, Types.DECIMAL);
        }
    }

    private FgOrmFuInv extract(ResultSet rs) throws SQLException {
        FgOrmFuInv fgormfuinv = new FgOrmFuInv();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        fgormfuinv.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        fgormfuinv.setReferenceID(REFERENCE_ID);
        fgormfuinv.setTypeCode(rs.getString(COL_TYPE_CODE));
        fgormfuinv.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        fgormfuinv.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        fgormfuinv.setStageCode(rs.getString(COL_STAGE_CODE));
        fgormfuinv.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        fgormfuinv.setProcessID(PROCESS_ID);
        fgormfuinv.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        fgormfuinv.setCreatedBy(CREATED_BY);
        fgormfuinv.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        fgormfuinv.setLastUpdatedBy(LAST_UPDATED_BY);
        fgormfuinv.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        fgormfuinv.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        fgormfuinv.setTemplate(rs.getString(COL_TEMPLATE));
        fgormfuinv.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        fgormfuinv.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        fgormfuinv.setIsTemplate(IS_TEMPLATE);
        fgormfuinv.setInvNo(rs.getString(COL_INV_NO));
        fgormfuinv.setHsCode(rs.getString(COL_HS_CODE));
        fgormfuinv.setPortOfLoading(rs.getString(COL_PORT_OF_LOADING));
        fgormfuinv.setVesselName(rs.getString(COL_VESSEL_NAME));
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        fgormfuinv.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        fgormfuinv.setParentVersionID(PARENT_VERSION_ID);
        Timestamp INV_DATE = rs.getTimestamp(COL_INV_DATE);
        if (INV_DATE != null)
            fgormfuinv.setInvDate(INV_DATE.toLocalDateTime());
        java.math.BigDecimal INV_AMOUNT = rs.getObject(COL_INV_AMOUNT, java.math.BigDecimal.class);
        fgormfuinv.setInvAmount(INV_AMOUNT);
        fgormfuinv.setInvCcy(rs.getString(COL_INV_CCY));
        fgormfuinv.setBoeNum(rs.getString(COL_BOE_NUM));
        Timestamp BOE_DATE = rs.getTimestamp(COL_BOE_DATE);
        if (BOE_DATE != null)
            fgormfuinv.setBoeDate(BOE_DATE.toLocalDateTime());
        fgormfuinv.setTransportDocNum(rs.getString(COL_TRANSPORT_DOC_NUM));
        fgormfuinv.setPortOfDischarge(rs.getString(COL_PORT_OF_DISCHARGE));
        fgormfuinv.setGoodsDes(rs.getString(COL_GOODS_DES));
        fgormfuinv.setBoeAdCode(rs.getString(COL_BOE_AD_CODE));
        fgormfuinv.setCountryOrigGood(rs.getString(COL_COUNTRY_ORIG_GOOD));
        fgormfuinv.setBoeNumber(rs.getString(COL_BOE_NUMBER));
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        fgormfuinv.setLineNo(LINE_NO);
        fgormfuinv.setMigrationBoeSuplCountry(rs.getString(COL_MIGRATION_BOE_SUPL_COUNTRY));
        fgormfuinv.setSellerName(rs.getString(COL_SELLER_NAME));
        fgormfuinv.setSupplierAddr(rs.getString(COL_SUPPLIER_ADDR));
        fgormfuinv.setSupplierCountry(rs.getString(COL_SUPPLIER_COUNTRY));
        fgormfuinv.setSupplierName(rs.getString(COL_SUPPLIER_NAME));
        java.math.BigDecimal OS_INV_AMT = rs.getObject(COL_OS_INV_AMT, java.math.BigDecimal.class);
        fgormfuinv.setOsInvAmt(OS_INV_AMT);
        java.math.BigDecimal INV_AMT = rs.getObject(COL_INV_AMT, java.math.BigDecimal.class);
        fgormfuinv.setInvAmt(INV_AMT);
        return fgormfuinv;
    }
}
