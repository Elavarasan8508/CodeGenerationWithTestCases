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

public class JdbcCoreMdmProductDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcCoreMdmProductDao.class);

    private static final String TABLE = "CORE_MDM_PRODUCT";

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

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_PRODUCT_NAME = "PRODUCT_NAME";

    private static final String COL_PRODUCT_STATUS_CODE = "PRODUCT_STATUS_CODE";

    private static final String COL_PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION";

    private static final String COL_BORROWER_PARTY = "BORROWER_PARTY";

    private static final String COL_ASSET_LIABILITY_APPLICABLE = "ASSET_LIABILITY_APPLICABLE";

    private static final String COL_CREDIT_LINE_APPLICABLE = "CREDIT_LINE_APPLICABLE";

    private static final String COL_EXPOSURE_MAINTENANCE_REQ = "EXPOSURE_MAINTENANCE_REQ";

    private static final String COL_INVOICE_RAISED_BY = "INVOICE_RAISED_BY";

    private static final String COL_FINANCE_REQUEST_BY = "FINANCE_REQUEST_BY";

    private static final String COL_INTEREST_CALCULATION = "INTEREST_CALCULATION";

    private static final String COL_ACCRUAL_AMORTIZE = "ACCRUAL_AMORTIZE";

    private static final String COL_ANCHOR_PARTY = "ANCHOR_PARTY";

    private static final String COL_FINANCE_DEBIT_PARTY = "FINANCE_DEBIT_PARTY";

    private static final String COL_FINANCE_TO_PARTY = "FINANCE_TO_PARTY";

    private static final String COL_SEGMENT_CODE = "SEGMENT_CODE";

    private static final String COL_CUTOFF_APPLICABLE = "CUTOFF_APPLICABLE";

    private static final String COL_CHARGES_APPLICABLE = "CHARGES_APPLICABLE";

    private static final String COL_HOLIDAY_APPLICABLE = "HOLIDAY_APPLICABLE";

    private static final String COL_ALLOW_PAYMENT = "ALLOW_PAYMENT";

    private static final String COL_ALLOW_COLLECTION = "ALLOW_COLLECTION";

    private static final String COL_BA_SHORT_NAME = "BA_SHORT_NAME";

    private static final String COL_PRODUCT_GROUP_CODE = "PRODUCT_GROUP_CODE";

    private static final String COL_PRODUCT_SUBGROUP_CODE = "PRODUCT_SUBGROUP_CODE";

    private static final String COL_CLASSIFICATION = "CLASSIFICATION";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_PRODUCT_CODE, COL_PRODUCT_NAME, COL_PRODUCT_STATUS_CODE, COL_PRODUCT_DESCRIPTION, COL_BORROWER_PARTY, COL_ASSET_LIABILITY_APPLICABLE, COL_CREDIT_LINE_APPLICABLE, COL_EXPOSURE_MAINTENANCE_REQ, COL_INVOICE_RAISED_BY, COL_FINANCE_REQUEST_BY, COL_INTEREST_CALCULATION, COL_ACCRUAL_AMORTIZE, COL_ANCHOR_PARTY, COL_FINANCE_DEBIT_PARTY, COL_FINANCE_TO_PARTY, COL_SEGMENT_CODE, COL_CUTOFF_APPLICABLE, COL_CHARGES_APPLICABLE, COL_HOLIDAY_APPLICABLE, COL_ALLOW_PAYMENT, COL_ALLOW_COLLECTION, COL_BA_SHORT_NAME, COL_PRODUCT_GROUP_CODE, COL_PRODUCT_SUBGROUP_CODE, COL_CLASSIFICATION, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_UPLOAD_REF_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PRODUCT_CODE, PRODUCT_NAME, PRODUCT_STATUS_CODE, PRODUCT_DESCRIPTION, BORROWER_PARTY, ASSET_LIABILITY_APPLICABLE, CREDIT_LINE_APPLICABLE, EXPOSURE_MAINTENANCE_REQ, INVOICE_RAISED_BY, FINANCE_REQUEST_BY, INTEREST_CALCULATION, ACCRUAL_AMORTIZE, ANCHOR_PARTY, FINANCE_DEBIT_PARTY, FINANCE_TO_PARTY, SEGMENT_CODE, CUTOFF_APPLICABLE, CHARGES_APPLICABLE, HOLIDAY_APPLICABLE, ALLOW_PAYMENT, ALLOW_COLLECTION, BA_SHORT_NAME, PRODUCT_GROUP_CODE, PRODUCT_SUBGROUP_CODE, CLASSIFICATION, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PRODUCT_CODE, PRODUCT_NAME, PRODUCT_STATUS_CODE, PRODUCT_DESCRIPTION, BORROWER_PARTY, ASSET_LIABILITY_APPLICABLE, CREDIT_LINE_APPLICABLE, EXPOSURE_MAINTENANCE_REQ, INVOICE_RAISED_BY, FINANCE_REQUEST_BY, INTEREST_CALCULATION, ACCRUAL_AMORTIZE, ANCHOR_PARTY, FINANCE_DEBIT_PARTY, FINANCE_TO_PARTY, SEGMENT_CODE, CUTOFF_APPLICABLE, CHARGES_APPLICABLE, HOLIDAY_APPLICABLE, ALLOW_PAYMENT, ALLOW_COLLECTION, BA_SHORT_NAME, PRODUCT_GROUP_CODE, PRODUCT_SUBGROUP_CODE, CLASSIFICATION, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_IS_TEMPLATE, COL_PRODUCT_CODE, COL_PRODUCT_NAME, COL_PRODUCT_STATUS_CODE, COL_PRODUCT_DESCRIPTION, COL_BORROWER_PARTY, COL_ASSET_LIABILITY_APPLICABLE, COL_CREDIT_LINE_APPLICABLE, COL_EXPOSURE_MAINTENANCE_REQ, COL_INVOICE_RAISED_BY, COL_FINANCE_REQUEST_BY, COL_INTEREST_CALCULATION, COL_ACCRUAL_AMORTIZE, COL_ANCHOR_PARTY, COL_FINANCE_DEBIT_PARTY, COL_FINANCE_TO_PARTY, COL_SEGMENT_CODE, COL_CUTOFF_APPLICABLE, COL_CHARGES_APPLICABLE, COL_HOLIDAY_APPLICABLE, COL_ALLOW_PAYMENT, COL_ALLOW_COLLECTION, COL_BA_SHORT_NAME, COL_PRODUCT_GROUP_CODE, COL_PRODUCT_SUBGROUP_CODE, COL_CLASSIFICATION, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_UPLOAD_REF_ID, COL_ID);

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

    public int insert(Connection conn, CoreMdmProduct coremdmproduct) throws SQLException {
        logger.debug("Inserting coremdmproduct: {}", coremdmproduct);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setCoreMdmProductParams(ps, coremdmproduct);
            ps.executeUpdate();
            return coremdmproduct.getID();
        }
    }

    public int[] insertAll(Connection conn, List<CoreMdmProduct> coremdmproducts) throws SQLException {
        if (coremdmproducts == null || coremdmproducts.isEmpty())
            return new int[0];
        for (int i = 0; i < coremdmproducts.size(); i++) {
            if (coremdmproducts.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CoreMdmProduct>> batches = chunkList(coremdmproducts, batchSize);
        int[] totalResults = new int[coremdmproducts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CoreMdmProduct> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (CoreMdmProduct coremdmproduct : batch) {
                        setCoreMdmProductParams(ps, coremdmproduct);
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

    public CoreMdmProduct findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<CoreMdmProduct> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<CoreMdmProduct> list = new ArrayList<>();
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

    public boolean update(Connection conn, CoreMdmProduct coremdmproduct) throws SQLException {
        if (coremdmproduct.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCoreMdmProductParams(ps, coremdmproduct);
            ps.setInt(46, coremdmproduct.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<CoreMdmProduct> coremdmproducts) throws SQLException {
        if (coremdmproducts == null || coremdmproducts.isEmpty())
            return new int[0];
        for (CoreMdmProduct coremdmproduct : coremdmproducts) {
            if (coremdmproduct == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (coremdmproduct.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CoreMdmProduct>> batches = chunkList(coremdmproducts, batchSize);
        int[] totalResults = new int[coremdmproducts.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CoreMdmProduct> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (CoreMdmProduct coremdmproduct : batch) {
                        setCoreMdmProductParams(ps, coremdmproduct);
                        ps.setInt(46, coremdmproduct.getID());
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

    private void setCoreMdmProductParams(PreparedStatement ps, CoreMdmProduct coremdmproduct) throws SQLException {
        Integer val1 = coremdmproduct.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = coremdmproduct.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, coremdmproduct.getTypeCode());
        ps.setString(4, coremdmproduct.getSubTypeCode());
        ps.setString(5, coremdmproduct.getActiveCode());
        ps.setString(6, coremdmproduct.getStageCode());
        ps.setString(7, coremdmproduct.getStatusCode());
        Integer val8 = coremdmproduct.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, coremdmproduct.getCreatedOn());
        java.math.BigDecimal val10 = coremdmproduct.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, coremdmproduct.getLastUpdatedOn());
        java.math.BigDecimal val12 = coremdmproduct.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, coremdmproduct.getLastAuthorisedOn());
        java.math.BigDecimal val14 = coremdmproduct.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, coremdmproduct.getTemplate());
        ps.setString(16, coremdmproduct.getApplicantParty());
        ps.setString(17, coremdmproduct.getFulfillmentParty());
        java.math.BigDecimal val18 = coremdmproduct.getIsTemplate();
        if (val18 != null) {
            ps.setBigDecimal(18, val18);
        } else {
            ps.setNull(18, Types.DECIMAL);
        }
        ps.setString(19, coremdmproduct.getProductCode());
        ps.setString(20, coremdmproduct.getProductName());
        ps.setString(21, coremdmproduct.getProductStatusCode());
        ps.setString(22, coremdmproduct.getProductDescription());
        ps.setString(23, coremdmproduct.getBorrowerParty());
        java.math.BigDecimal val24 = coremdmproduct.getAssetLiabilityApplicable();
        if (val24 != null) {
            ps.setBigDecimal(24, val24);
        } else {
            ps.setNull(24, Types.DECIMAL);
        }
        java.math.BigDecimal val25 = coremdmproduct.getCreditLineApplicable();
        if (val25 != null) {
            ps.setBigDecimal(25, val25);
        } else {
            ps.setNull(25, Types.DECIMAL);
        }
        java.math.BigDecimal val26 = coremdmproduct.getExposureMaintenanceReq();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, coremdmproduct.getInvoiceRaisedBy());
        ps.setString(28, coremdmproduct.getFinanceRequestBy());
        java.math.BigDecimal val29 = coremdmproduct.getInterestCalculation();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        java.math.BigDecimal val30 = coremdmproduct.getAccrualAmortize();
        if (val30 != null) {
            ps.setBigDecimal(30, val30);
        } else {
            ps.setNull(30, Types.DECIMAL);
        }
        ps.setString(31, coremdmproduct.getAnchorParty());
        ps.setString(32, coremdmproduct.getFinanceDebitParty());
        ps.setString(33, coremdmproduct.getFinanceToParty());
        ps.setString(34, coremdmproduct.getSegmentCode());
        java.math.BigDecimal val35 = coremdmproduct.getCutoffApplicable();
        if (val35 != null) {
            ps.setBigDecimal(35, val35);
        } else {
            ps.setNull(35, Types.DECIMAL);
        }
        java.math.BigDecimal val36 = coremdmproduct.getChargesApplicable();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        java.math.BigDecimal val37 = coremdmproduct.getHolidayApplicable();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        java.math.BigDecimal val38 = coremdmproduct.getAllowPayment();
        if (val38 != null) {
            ps.setBigDecimal(38, val38);
        } else {
            ps.setNull(38, Types.DECIMAL);
        }
        java.math.BigDecimal val39 = coremdmproduct.getAllowCollection();
        if (val39 != null) {
            ps.setBigDecimal(39, val39);
        } else {
            ps.setNull(39, Types.DECIMAL);
        }
        ps.setString(40, coremdmproduct.getBaShortName());
        ps.setString(41, coremdmproduct.getProductGroupCode());
        ps.setString(42, coremdmproduct.getProductSubgroupCode());
        ps.setString(43, coremdmproduct.getClassification());
        Integer val44 = coremdmproduct.getVersionID();
        if (val44 != null) {
            ps.setInt(44, val44);
        } else {
            ps.setNull(44, Types.INTEGER);
        }
        java.math.BigDecimal val45 = coremdmproduct.getIsMasterVersion();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        Integer val46 = coremdmproduct.getUploadRefID();
        if (val46 != null) {
            ps.setInt(46, val46);
        } else {
            ps.setNull(46, Types.INTEGER);
        }
    }

    private CoreMdmProduct extract(ResultSet rs) throws SQLException {
        CoreMdmProduct coremdmproduct = new CoreMdmProduct();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        coremdmproduct.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        coremdmproduct.setReferenceID(REFERENCE_ID);
        coremdmproduct.setTypeCode(rs.getString(COL_TYPE_CODE));
        coremdmproduct.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        coremdmproduct.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        coremdmproduct.setStageCode(rs.getString(COL_STAGE_CODE));
        coremdmproduct.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        coremdmproduct.setProcessID(PROCESS_ID);
        coremdmproduct.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        coremdmproduct.setCreatedBy(CREATED_BY);
        coremdmproduct.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        coremdmproduct.setLastUpdatedBy(LAST_UPDATED_BY);
        coremdmproduct.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        coremdmproduct.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        coremdmproduct.setTemplate(rs.getString(COL_TEMPLATE));
        coremdmproduct.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        coremdmproduct.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        coremdmproduct.setIsTemplate(IS_TEMPLATE);
        coremdmproduct.setProductCode(rs.getString(COL_PRODUCT_CODE));
        coremdmproduct.setProductName(rs.getString(COL_PRODUCT_NAME));
        coremdmproduct.setProductStatusCode(rs.getString(COL_PRODUCT_STATUS_CODE));
        coremdmproduct.setProductDescription(rs.getString(COL_PRODUCT_DESCRIPTION));
        coremdmproduct.setBorrowerParty(rs.getString(COL_BORROWER_PARTY));
        java.math.BigDecimal ASSET_LIABILITY_APPLICABLE = rs.getObject(COL_ASSET_LIABILITY_APPLICABLE, java.math.BigDecimal.class);
        coremdmproduct.setAssetLiabilityApplicable(ASSET_LIABILITY_APPLICABLE);
        java.math.BigDecimal CREDIT_LINE_APPLICABLE = rs.getObject(COL_CREDIT_LINE_APPLICABLE, java.math.BigDecimal.class);
        coremdmproduct.setCreditLineApplicable(CREDIT_LINE_APPLICABLE);
        java.math.BigDecimal EXPOSURE_MAINTENANCE_REQ = rs.getObject(COL_EXPOSURE_MAINTENANCE_REQ, java.math.BigDecimal.class);
        coremdmproduct.setExposureMaintenanceReq(EXPOSURE_MAINTENANCE_REQ);
        coremdmproduct.setInvoiceRaisedBy(rs.getString(COL_INVOICE_RAISED_BY));
        coremdmproduct.setFinanceRequestBy(rs.getString(COL_FINANCE_REQUEST_BY));
        java.math.BigDecimal INTEREST_CALCULATION = rs.getObject(COL_INTEREST_CALCULATION, java.math.BigDecimal.class);
        coremdmproduct.setInterestCalculation(INTEREST_CALCULATION);
        java.math.BigDecimal ACCRUAL_AMORTIZE = rs.getObject(COL_ACCRUAL_AMORTIZE, java.math.BigDecimal.class);
        coremdmproduct.setAccrualAmortize(ACCRUAL_AMORTIZE);
        coremdmproduct.setAnchorParty(rs.getString(COL_ANCHOR_PARTY));
        coremdmproduct.setFinanceDebitParty(rs.getString(COL_FINANCE_DEBIT_PARTY));
        coremdmproduct.setFinanceToParty(rs.getString(COL_FINANCE_TO_PARTY));
        coremdmproduct.setSegmentCode(rs.getString(COL_SEGMENT_CODE));
        java.math.BigDecimal CUTOFF_APPLICABLE = rs.getObject(COL_CUTOFF_APPLICABLE, java.math.BigDecimal.class);
        coremdmproduct.setCutoffApplicable(CUTOFF_APPLICABLE);
        java.math.BigDecimal CHARGES_APPLICABLE = rs.getObject(COL_CHARGES_APPLICABLE, java.math.BigDecimal.class);
        coremdmproduct.setChargesApplicable(CHARGES_APPLICABLE);
        java.math.BigDecimal HOLIDAY_APPLICABLE = rs.getObject(COL_HOLIDAY_APPLICABLE, java.math.BigDecimal.class);
        coremdmproduct.setHolidayApplicable(HOLIDAY_APPLICABLE);
        java.math.BigDecimal ALLOW_PAYMENT = rs.getObject(COL_ALLOW_PAYMENT, java.math.BigDecimal.class);
        coremdmproduct.setAllowPayment(ALLOW_PAYMENT);
        java.math.BigDecimal ALLOW_COLLECTION = rs.getObject(COL_ALLOW_COLLECTION, java.math.BigDecimal.class);
        coremdmproduct.setAllowCollection(ALLOW_COLLECTION);
        coremdmproduct.setBaShortName(rs.getString(COL_BA_SHORT_NAME));
        coremdmproduct.setProductGroupCode(rs.getString(COL_PRODUCT_GROUP_CODE));
        coremdmproduct.setProductSubgroupCode(rs.getString(COL_PRODUCT_SUBGROUP_CODE));
        coremdmproduct.setClassification(rs.getString(COL_CLASSIFICATION));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        coremdmproduct.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        coremdmproduct.setIsMasterVersion(IS_MASTER_VERSION);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        coremdmproduct.setUploadRefID(UPLOAD_REF_ID);
        return coremdmproduct;
    }
}
