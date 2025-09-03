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

public class JdbcCreditOfferPartyMapDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcCreditOfferPartyMapDao.class);

    private static final String TABLE = "CREDIT_OFFER_PARTY_MAP";

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

    private static final String COL_ATTACHMENT_ID = "ATTACHMENT_ID";

    private static final String COL_PARENT_ID = "PARENT_ID";

    private static final String COL_PARENT_REF_ID = "PARENT_REF_ID";

    private static final String COL_PARENT_VERSION_ID = "PARENT_VERSION_ID";

    private static final String COL_IS_TEMPLATE = "IS_TEMPLATE";

    private static final String COL_OFFER_ID = "OFFER_ID";

    private static final String COL_MAPPING_STATUS = "MAPPING_STATUS";

    private static final String COL_VERSION_ID = "VERSION_ID";

    private static final String COL_IS_MASTER_VERSION = "IS_MASTER_VERSION";

    private static final String COL_UPLOAD_REF_ID = "UPLOAD_REF_ID";

    private static final String COL_USAGE_LIMIT = "USAGE_LIMIT";

    private static final String COL_CUSTOMER_ID = "CUSTOMER_ID";

    private static final String COL_CRN_BOR = "CRN_BOR";

    private static final String COL_ACC_NO = "ACC_NO";

    private static final String COL_ROI = "ROI";

    private static final String COL_PROC_FEE = "PROC_FEE";

    private static final String COL_OVERALL_LIMIT = "OVERALL_LIMIT";

    private static final String COL_PORTFOLIO = "PORTFOLIO";

    private static final String COL_PRODUCT_CODE = "PRODUCT_CODE";

    private static final String COL_VALID_FROM = "VALID_FROM";

    private static final String COL_VALID_TO = "VALID_TO";

    private static final String COL_DECLARATION_TYPE = "DECLARATION_TYPE";

    private static final String COL_BRANCH_ADDRESS = "BRANCH_ADDRESS";

    private static final String COL_BRANCH_LOCATION = "BRANCH_LOCATION";

    private static final String COL_SOLID = "SOLID";

    private static final String COL_FINANCIAL_YEAR = "FINANCIAL_YEAR";

    private static final String COL_GSTIN_NUM = "GSTIN_NUM";

    private static final String COL_TYP_OF_PROC_FEE = "TYP_OF_PROC_FEE";

    private static final String COL_MIN_LOAN_AMT = "MIN_LOAN_AMT";

    private static final String COL_MAX_LOAN_AMT = "MAX_LOAN_AMT";

    private static final String COL_MIN_TENURE_DAYS = "MIN_TENURE_DAYS";

    private static final String COL_MAX_TENURE_DAYS = "MAX_TENURE_DAYS";

    private static final String COL_ADHOC_TYPE = "ADHOC_TYPE";

    private static final String COL_EXISTING_FAC = "EXISTING_FAC";

    private static final String COL_AVAILABLE_LOAN_LIMIT = "AVAILABLE_LOAN_LIMIT";

    private static final String COL_SANC_LOAN_LIMIT = "SANC_LOAN_LIMIT";

    private static final String COL_UTL_LOAN_DEM = "UTL_LOAN_DEM";

    private static final String COL_GST = "GST";

    private static final String COL_SPREAD_OF_ROI = "SPREAD_OF_ROI";

    private static final String COL_ROI_NEXT_YR = "ROI_NEXT_YR";

    private static final String COL_SANC_LTR_REFNO = "SANC_LTR_REFNO";

    private static final String COL_ROI_BENCHMARK = "ROI_BENCHMARK";

    private static final String COL_BENCHMARK = "BENCHMARK";

    private static final String COL_ADMIN_CHRGS = "ADMIN_CHRGS";

    private static final String COL_TECHNICAL_FEES = "TECHNICAL_FEES";

    private static final String COL_REMARKS = "REMARKS";

    private static final String COL_GST_NEXT_YR = "GST_NEXT_YR";

    private static final String COL_PROC_FEES_NEXT_YR = "PROC_FEES_NEXT_YR";

    private static final String COL_ROI_TYPE = "ROI_TYPE";

    private static final String COL_MSME_STATUS = "MSME_STATUS";

    private static final String COL_PSL_STATUS = "PSL_STATUS";

    private static final String COL_NATURE_OF_BUSINESS = "NATURE_OF_BUSINESS";

    private static final String COL_SCHEME_CODE = "SCHEME_CODE";

    private static final String COL_LIMIT_ID = "LIMIT_ID";

    private static final String COL_SUBSECTOR_CODE = "SUBSECTOR_CODE";

    private static final String COL_BRANCH_CODE = "BRANCH_CODE";

    private static final String COL_OPERATION_TYPE = "OPERATION_TYPE";

    private static final String COL_USER_ID = "USER_ID";

    private static final String COL_UPLOADED_DATE = "UPLOADED_DATE";

    private static final String COL_SUB_PRODUCT_CODE = "SUB_PRODUCT_CODE";

    private static final String COL_SEGMENT_CODE = "SEGMENT_CODE";

    private static final String COL_SEGMENT_TEAMS = "SEGMENT_TEAMS";

    private static final String COL_LINE_NO = "LINE_NO";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ID, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_OFFER_ID, COL_MAPPING_STATUS, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_UPLOAD_REF_ID, COL_USAGE_LIMIT, COL_CUSTOMER_ID, COL_CRN_BOR, COL_ACC_NO, COL_ROI, COL_PROC_FEE, COL_OVERALL_LIMIT, COL_PORTFOLIO, COL_PRODUCT_CODE, COL_VALID_FROM, COL_VALID_TO, COL_DECLARATION_TYPE, COL_BRANCH_ADDRESS, COL_BRANCH_LOCATION, COL_SOLID, COL_FINANCIAL_YEAR, COL_GSTIN_NUM, COL_TYP_OF_PROC_FEE, COL_MIN_LOAN_AMT, COL_MAX_LOAN_AMT, COL_MIN_TENURE_DAYS, COL_MAX_TENURE_DAYS, COL_ADHOC_TYPE, COL_EXISTING_FAC, COL_AVAILABLE_LOAN_LIMIT, COL_SANC_LOAN_LIMIT, COL_UTL_LOAN_DEM, COL_GST, COL_SPREAD_OF_ROI, COL_ROI_NEXT_YR, COL_SANC_LTR_REFNO, COL_ROI_BENCHMARK, COL_BENCHMARK, COL_ADMIN_CHRGS, COL_TECHNICAL_FEES, COL_REMARKS, COL_GST_NEXT_YR, COL_PROC_FEES_NEXT_YR, COL_ROI_TYPE, COL_MSME_STATUS, COL_PSL_STATUS, COL_NATURE_OF_BUSINESS, COL_SCHEME_CODE, COL_LIMIT_ID, COL_SUBSECTOR_CODE, COL_BRANCH_CODE, COL_OPERATION_TYPE, COL_USER_ID, COL_UPLOADED_DATE, COL_SUB_PRODUCT_CODE, COL_SEGMENT_CODE, COL_SEGMENT_TEAMS, COL_LINE_NO);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, OFFER_ID, MAPPING_STATUS, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID, USAGE_LIMIT, CUSTOMER_ID, CRN_BOR, ACC_NO, ROI, PROC_FEE, OVERALL_LIMIT, PORTFOLIO, PRODUCT_CODE, VALID_FROM, VALID_TO, DECLARATION_TYPE, BRANCH_ADDRESS, BRANCH_LOCATION, SOLID, FINANCIAL_YEAR, GSTIN_NUM, TYP_OF_PROC_FEE, MIN_LOAN_AMT, MAX_LOAN_AMT, MIN_TENURE_DAYS, MAX_TENURE_DAYS, ADHOC_TYPE, EXISTING_FAC, AVAILABLE_LOAN_LIMIT, SANC_LOAN_LIMIT, UTL_LOAN_DEM, GST, SPREAD_OF_ROI, ROI_NEXT_YR, SANC_LTR_REFNO, ROI_BENCHMARK, BENCHMARK, ADMIN_CHRGS, TECHNICAL_FEES, REMARKS, GST_NEXT_YR, PROC_FEES_NEXT_YR, ROI_TYPE, MSME_STATUS, PSL_STATUS, NATURE_OF_BUSINESS, SCHEME_CODE, LIMIT_ID, SUBSECTOR_CODE, BRANCH_CODE, OPERATION_TYPE, USER_ID, UPLOADED_DATE, SUB_PRODUCT_CODE, SEGMENT_CODE, SEGMENT_TEAMS, LINE_NO", TABLE, COL_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, OFFER_ID, MAPPING_STATUS, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID, USAGE_LIMIT, CUSTOMER_ID, CRN_BOR, ACC_NO, ROI, PROC_FEE, OVERALL_LIMIT, PORTFOLIO, PRODUCT_CODE, VALID_FROM, VALID_TO, DECLARATION_TYPE, BRANCH_ADDRESS, BRANCH_LOCATION, SOLID, FINANCIAL_YEAR, GSTIN_NUM, TYP_OF_PROC_FEE, MIN_LOAN_AMT, MAX_LOAN_AMT, MIN_TENURE_DAYS, MAX_TENURE_DAYS, ADHOC_TYPE, EXISTING_FAC, AVAILABLE_LOAN_LIMIT, SANC_LOAN_LIMIT, UTL_LOAN_DEM, GST, SPREAD_OF_ROI, ROI_NEXT_YR, SANC_LTR_REFNO, ROI_BENCHMARK, BENCHMARK, ADMIN_CHRGS, TECHNICAL_FEES, REMARKS, GST_NEXT_YR, PROC_FEES_NEXT_YR, ROI_TYPE, MSME_STATUS, PSL_STATUS, NATURE_OF_BUSINESS, SCHEME_CODE, LIMIT_ID, SUBSECTOR_CODE, BRANCH_CODE, OPERATION_TYPE, USER_ID, UPLOADED_DATE, SUB_PRODUCT_CODE, SEGMENT_CODE, SEGMENT_TEAMS, LINE_NO", TABLE, COL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_REFERENCE_ID, COL_TYPE_CODE, COL_SUB_TYPE_CODE, COL_ACTIVE_CODE, COL_STAGE_CODE, COL_STATUS_CODE, COL_PROCESS_ID, COL_CREATED_ON, COL_CREATED_BY, COL_LAST_UPDATED_ON, COL_LAST_UPDATED_BY, COL_LAST_AUTHORISED_ON, COL_LAST_AUTHORISED_BY, COL_TEMPLATE, COL_APPLICANT_PARTY, COL_FULFILLMENT_PARTY, COL_ATTACHMENT_ID, COL_PARENT_ID, COL_PARENT_REF_ID, COL_PARENT_VERSION_ID, COL_IS_TEMPLATE, COL_OFFER_ID, COL_MAPPING_STATUS, COL_VERSION_ID, COL_IS_MASTER_VERSION, COL_UPLOAD_REF_ID, COL_USAGE_LIMIT, COL_CUSTOMER_ID, COL_CRN_BOR, COL_ACC_NO, COL_ROI, COL_PROC_FEE, COL_OVERALL_LIMIT, COL_PORTFOLIO, COL_PRODUCT_CODE, COL_VALID_FROM, COL_VALID_TO, COL_DECLARATION_TYPE, COL_BRANCH_ADDRESS, COL_BRANCH_LOCATION, COL_SOLID, COL_FINANCIAL_YEAR, COL_GSTIN_NUM, COL_TYP_OF_PROC_FEE, COL_MIN_LOAN_AMT, COL_MAX_LOAN_AMT, COL_MIN_TENURE_DAYS, COL_MAX_TENURE_DAYS, COL_ADHOC_TYPE, COL_EXISTING_FAC, COL_AVAILABLE_LOAN_LIMIT, COL_SANC_LOAN_LIMIT, COL_UTL_LOAN_DEM, COL_GST, COL_SPREAD_OF_ROI, COL_ROI_NEXT_YR, COL_SANC_LTR_REFNO, COL_ROI_BENCHMARK, COL_BENCHMARK, COL_ADMIN_CHRGS, COL_TECHNICAL_FEES, COL_REMARKS, COL_GST_NEXT_YR, COL_PROC_FEES_NEXT_YR, COL_ROI_TYPE, COL_MSME_STATUS, COL_PSL_STATUS, COL_NATURE_OF_BUSINESS, COL_SCHEME_CODE, COL_LIMIT_ID, COL_SUBSECTOR_CODE, COL_BRANCH_CODE, COL_OPERATION_TYPE, COL_USER_ID, COL_UPLOADED_DATE, COL_SUB_PRODUCT_CODE, COL_SEGMENT_CODE, COL_SEGMENT_TEAMS, COL_LINE_NO, COL_ID);

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

    public int insert(Connection conn, CreditOfferPartyMap creditofferpartymap) throws SQLException {
        logger.debug("Inserting creditofferpartymap: {}", creditofferpartymap);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setCreditOfferPartyMapParams(ps, creditofferpartymap);
            ps.executeUpdate();
            return creditofferpartymap.getID();
        }
    }

    public int[] insertAll(Connection conn, List<CreditOfferPartyMap> creditofferpartymaps) throws SQLException {
        if (creditofferpartymaps == null || creditofferpartymaps.isEmpty())
            return new int[0];
        for (int i = 0; i < creditofferpartymaps.size(); i++) {
            if (creditofferpartymaps.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CreditOfferPartyMap>> batches = chunkList(creditofferpartymaps, batchSize);
        int[] totalResults = new int[creditofferpartymaps.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CreditOfferPartyMap> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (CreditOfferPartyMap creditofferpartymap : batch) {
                        setCreditOfferPartyMapParams(ps, creditofferpartymap);
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

    public CreditOfferPartyMap findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<CreditOfferPartyMap> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<CreditOfferPartyMap> list = new ArrayList<>();
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

    public boolean update(Connection conn, CreditOfferPartyMap creditofferpartymap) throws SQLException {
        if (creditofferpartymap.getID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCreditOfferPartyMapParams(ps, creditofferpartymap);
            ps.setInt(80, creditofferpartymap.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<CreditOfferPartyMap> creditofferpartymaps) throws SQLException {
        if (creditofferpartymaps == null || creditofferpartymaps.isEmpty())
            return new int[0];
        for (CreditOfferPartyMap creditofferpartymap : creditofferpartymaps) {
            if (creditofferpartymap == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (creditofferpartymap.getID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<CreditOfferPartyMap>> batches = chunkList(creditofferpartymaps, batchSize);
        int[] totalResults = new int[creditofferpartymaps.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<CreditOfferPartyMap> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (CreditOfferPartyMap creditofferpartymap : batch) {
                        setCreditOfferPartyMapParams(ps, creditofferpartymap);
                        ps.setInt(80, creditofferpartymap.getID());
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

    private void setCreditOfferPartyMapParams(PreparedStatement ps, CreditOfferPartyMap creditofferpartymap) throws SQLException {
        Integer val1 = creditofferpartymap.getID();
        if (val1 != null) {
            ps.setInt(1, val1);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        Integer val2 = creditofferpartymap.getReferenceID();
        if (val2 != null) {
            ps.setInt(2, val2);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        ps.setString(3, creditofferpartymap.getTypeCode());
        ps.setString(4, creditofferpartymap.getSubTypeCode());
        ps.setString(5, creditofferpartymap.getActiveCode());
        ps.setString(6, creditofferpartymap.getStageCode());
        ps.setString(7, creditofferpartymap.getStatusCode());
        Integer val8 = creditofferpartymap.getProcessID();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        ps.setString(9, creditofferpartymap.getCreatedOn());
        java.math.BigDecimal val10 = creditofferpartymap.getCreatedBy();
        if (val10 != null) {
            ps.setBigDecimal(10, val10);
        } else {
            ps.setNull(10, Types.DECIMAL);
        }
        ps.setString(11, creditofferpartymap.getLastUpdatedOn());
        java.math.BigDecimal val12 = creditofferpartymap.getLastUpdatedBy();
        if (val12 != null) {
            ps.setBigDecimal(12, val12);
        } else {
            ps.setNull(12, Types.DECIMAL);
        }
        ps.setString(13, creditofferpartymap.getLastAuthorisedOn());
        java.math.BigDecimal val14 = creditofferpartymap.getLastAuthorisedBy();
        if (val14 != null) {
            ps.setBigDecimal(14, val14);
        } else {
            ps.setNull(14, Types.DECIMAL);
        }
        ps.setString(15, creditofferpartymap.getTemplate());
        ps.setString(16, creditofferpartymap.getApplicantParty());
        ps.setString(17, creditofferpartymap.getFulfillmentParty());
        Integer val18 = creditofferpartymap.getAttachmentID();
        if (val18 != null) {
            ps.setInt(18, val18);
        } else {
            ps.setNull(18, Types.INTEGER);
        }
        Integer val19 = creditofferpartymap.getParentID();
        if (val19 != null) {
            ps.setInt(19, val19);
        } else {
            ps.setNull(19, Types.INTEGER);
        }
        Integer val20 = creditofferpartymap.getParentRefID();
        if (val20 != null) {
            ps.setInt(20, val20);
        } else {
            ps.setNull(20, Types.INTEGER);
        }
        Integer val21 = creditofferpartymap.getParentVersionID();
        if (val21 != null) {
            ps.setInt(21, val21);
        } else {
            ps.setNull(21, Types.INTEGER);
        }
        java.math.BigDecimal val22 = creditofferpartymap.getIsTemplate();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        Integer val23 = creditofferpartymap.getOfferID();
        if (val23 != null) {
            ps.setInt(23, val23);
        } else {
            ps.setNull(23, Types.INTEGER);
        }
        ps.setString(24, creditofferpartymap.getMappingStatus());
        Integer val25 = creditofferpartymap.getVersionID();
        if (val25 != null) {
            ps.setInt(25, val25);
        } else {
            ps.setNull(25, Types.INTEGER);
        }
        java.math.BigDecimal val26 = creditofferpartymap.getIsMasterVersion();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        Integer val27 = creditofferpartymap.getUploadRefID();
        if (val27 != null) {
            ps.setInt(27, val27);
        } else {
            ps.setNull(27, Types.INTEGER);
        }
        java.math.BigDecimal val28 = creditofferpartymap.getUsageLimit();
        if (val28 != null) {
            ps.setBigDecimal(28, val28);
        } else {
            ps.setNull(28, Types.DECIMAL);
        }
        Integer val29 = creditofferpartymap.getCustomerID();
        if (val29 != null) {
            ps.setInt(29, val29);
        } else {
            ps.setNull(29, Types.INTEGER);
        }
        ps.setString(30, creditofferpartymap.getCrnBor());
        ps.setString(31, creditofferpartymap.getAccNo());
        ps.setString(32, creditofferpartymap.getRoi());
        java.math.BigDecimal val33 = creditofferpartymap.getProcFee();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        java.math.BigDecimal val34 = creditofferpartymap.getOverallLimit();
        if (val34 != null) {
            ps.setBigDecimal(34, val34);
        } else {
            ps.setNull(34, Types.DECIMAL);
        }
        ps.setString(35, creditofferpartymap.getPortfolio());
        ps.setString(36, creditofferpartymap.getProductCode());
        java.time.LocalDateTime val37 = creditofferpartymap.getValidFrom();
        if (val37 != null) {
            ps.setTimestamp(37, java.sql.Timestamp.valueOf(val37));
        } else {
            ps.setNull(37, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val38 = creditofferpartymap.getValidTo();
        if (val38 != null) {
            ps.setTimestamp(38, java.sql.Timestamp.valueOf(val38));
        } else {
            ps.setNull(38, Types.TIMESTAMP);
        }
        ps.setString(39, creditofferpartymap.getDeclarationType());
        ps.setString(40, creditofferpartymap.getBranchAddress());
        ps.setString(41, creditofferpartymap.getBranchLocation());
        ps.setString(42, creditofferpartymap.getSolid());
        ps.setString(43, creditofferpartymap.getFinancialYear());
        ps.setString(44, creditofferpartymap.getGstinNum());
        java.math.BigDecimal val45 = creditofferpartymap.getTypOfProcFee();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        java.math.BigDecimal val46 = creditofferpartymap.getMinLoanAmt();
        if (val46 != null) {
            ps.setBigDecimal(46, val46);
        } else {
            ps.setNull(46, Types.DECIMAL);
        }
        java.math.BigDecimal val47 = creditofferpartymap.getMaxLoanAmt();
        if (val47 != null) {
            ps.setBigDecimal(47, val47);
        } else {
            ps.setNull(47, Types.DECIMAL);
        }
        java.math.BigDecimal val48 = creditofferpartymap.getMinTenureDays();
        if (val48 != null) {
            ps.setBigDecimal(48, val48);
        } else {
            ps.setNull(48, Types.DECIMAL);
        }
        java.math.BigDecimal val49 = creditofferpartymap.getMaxTenureDays();
        if (val49 != null) {
            ps.setBigDecimal(49, val49);
        } else {
            ps.setNull(49, Types.DECIMAL);
        }
        ps.setString(50, creditofferpartymap.getAdhocType());
        java.math.BigDecimal val51 = creditofferpartymap.getExistingFac();
        if (val51 != null) {
            ps.setBigDecimal(51, val51);
        } else {
            ps.setNull(51, Types.DECIMAL);
        }
        java.math.BigDecimal val52 = creditofferpartymap.getAvailableLoanLimit();
        if (val52 != null) {
            ps.setBigDecimal(52, val52);
        } else {
            ps.setNull(52, Types.DECIMAL);
        }
        java.math.BigDecimal val53 = creditofferpartymap.getSancLoanLimit();
        if (val53 != null) {
            ps.setBigDecimal(53, val53);
        } else {
            ps.setNull(53, Types.DECIMAL);
        }
        java.math.BigDecimal val54 = creditofferpartymap.getUtlLoanDem();
        if (val54 != null) {
            ps.setBigDecimal(54, val54);
        } else {
            ps.setNull(54, Types.DECIMAL);
        }
        java.math.BigDecimal val55 = creditofferpartymap.getGst();
        if (val55 != null) {
            ps.setBigDecimal(55, val55);
        } else {
            ps.setNull(55, Types.DECIMAL);
        }
        java.math.BigDecimal val56 = creditofferpartymap.getSpreadOfRoi();
        if (val56 != null) {
            ps.setBigDecimal(56, val56);
        } else {
            ps.setNull(56, Types.DECIMAL);
        }
        java.math.BigDecimal val57 = creditofferpartymap.getRoiNextYr();
        if (val57 != null) {
            ps.setBigDecimal(57, val57);
        } else {
            ps.setNull(57, Types.DECIMAL);
        }
        ps.setString(58, creditofferpartymap.getSancLtrRefno());
        java.math.BigDecimal val59 = creditofferpartymap.getRoiBenchmark();
        if (val59 != null) {
            ps.setBigDecimal(59, val59);
        } else {
            ps.setNull(59, Types.DECIMAL);
        }
        ps.setString(60, creditofferpartymap.getBenchmark());
        java.math.BigDecimal val61 = creditofferpartymap.getAdminChrgs();
        if (val61 != null) {
            ps.setBigDecimal(61, val61);
        } else {
            ps.setNull(61, Types.DECIMAL);
        }
        java.math.BigDecimal val62 = creditofferpartymap.getTechnicalFees();
        if (val62 != null) {
            ps.setBigDecimal(62, val62);
        } else {
            ps.setNull(62, Types.DECIMAL);
        }
        ps.setString(63, creditofferpartymap.getRemarks());
        java.math.BigDecimal val64 = creditofferpartymap.getGstNextYr();
        if (val64 != null) {
            ps.setBigDecimal(64, val64);
        } else {
            ps.setNull(64, Types.DECIMAL);
        }
        java.math.BigDecimal val65 = creditofferpartymap.getProcFeesNextYr();
        if (val65 != null) {
            ps.setBigDecimal(65, val65);
        } else {
            ps.setNull(65, Types.DECIMAL);
        }
        ps.setString(66, creditofferpartymap.getRoiType());
        ps.setString(67, creditofferpartymap.getMsmeStatus());
        ps.setString(68, creditofferpartymap.getPslStatus());
        ps.setString(69, creditofferpartymap.getNatureOfBusiness());
        ps.setString(70, creditofferpartymap.getSchemeCode());
        Integer val71 = creditofferpartymap.getLimitID();
        if (val71 != null) {
            ps.setInt(71, val71);
        } else {
            ps.setNull(71, Types.INTEGER);
        }
        ps.setString(72, creditofferpartymap.getSubsectorCode());
        ps.setString(73, creditofferpartymap.getBranchCode());
        ps.setString(74, creditofferpartymap.getOperationType());
        Integer val75 = creditofferpartymap.getUserID();
        if (val75 != null) {
            ps.setInt(75, val75);
        } else {
            ps.setNull(75, Types.INTEGER);
        }
        java.time.LocalDateTime val76 = creditofferpartymap.getUploadedDate();
        if (val76 != null) {
            ps.setTimestamp(76, java.sql.Timestamp.valueOf(val76));
        } else {
            ps.setNull(76, Types.TIMESTAMP);
        }
        ps.setString(77, creditofferpartymap.getSubProductCode());
        ps.setString(78, creditofferpartymap.getSegmentCode());
        ps.setString(79, creditofferpartymap.getSegmentTeams());
        java.math.BigDecimal val80 = creditofferpartymap.getLineNo();
        if (val80 != null) {
            ps.setBigDecimal(80, val80);
        } else {
            ps.setNull(80, Types.DECIMAL);
        }
    }

    private CreditOfferPartyMap extract(ResultSet rs) throws SQLException {
        CreditOfferPartyMap creditofferpartymap = new CreditOfferPartyMap();
        Integer ID = rs.getObject(COL_ID, Integer.class);
        creditofferpartymap.setID(ID);
        Integer REFERENCE_ID = rs.getObject(COL_REFERENCE_ID, Integer.class);
        creditofferpartymap.setReferenceID(REFERENCE_ID);
        creditofferpartymap.setTypeCode(rs.getString(COL_TYPE_CODE));
        creditofferpartymap.setSubTypeCode(rs.getString(COL_SUB_TYPE_CODE));
        creditofferpartymap.setActiveCode(rs.getString(COL_ACTIVE_CODE));
        creditofferpartymap.setStageCode(rs.getString(COL_STAGE_CODE));
        creditofferpartymap.setStatusCode(rs.getString(COL_STATUS_CODE));
        Integer PROCESS_ID = rs.getObject(COL_PROCESS_ID, Integer.class);
        creditofferpartymap.setProcessID(PROCESS_ID);
        creditofferpartymap.setCreatedOn(rs.getString(COL_CREATED_ON));
        java.math.BigDecimal CREATED_BY = rs.getObject(COL_CREATED_BY, java.math.BigDecimal.class);
        creditofferpartymap.setCreatedBy(CREATED_BY);
        creditofferpartymap.setLastUpdatedOn(rs.getString(COL_LAST_UPDATED_ON));
        java.math.BigDecimal LAST_UPDATED_BY = rs.getObject(COL_LAST_UPDATED_BY, java.math.BigDecimal.class);
        creditofferpartymap.setLastUpdatedBy(LAST_UPDATED_BY);
        creditofferpartymap.setLastAuthorisedOn(rs.getString(COL_LAST_AUTHORISED_ON));
        java.math.BigDecimal LAST_AUTHORISED_BY = rs.getObject(COL_LAST_AUTHORISED_BY, java.math.BigDecimal.class);
        creditofferpartymap.setLastAuthorisedBy(LAST_AUTHORISED_BY);
        creditofferpartymap.setTemplate(rs.getString(COL_TEMPLATE));
        creditofferpartymap.setApplicantParty(rs.getString(COL_APPLICANT_PARTY));
        creditofferpartymap.setFulfillmentParty(rs.getString(COL_FULFILLMENT_PARTY));
        Integer ATTACHMENT_ID = rs.getObject(COL_ATTACHMENT_ID, Integer.class);
        creditofferpartymap.setAttachmentID(ATTACHMENT_ID);
        Integer PARENT_ID = rs.getObject(COL_PARENT_ID, Integer.class);
        creditofferpartymap.setParentID(PARENT_ID);
        Integer PARENT_REF_ID = rs.getObject(COL_PARENT_REF_ID, Integer.class);
        creditofferpartymap.setParentRefID(PARENT_REF_ID);
        Integer PARENT_VERSION_ID = rs.getObject(COL_PARENT_VERSION_ID, Integer.class);
        creditofferpartymap.setParentVersionID(PARENT_VERSION_ID);
        java.math.BigDecimal IS_TEMPLATE = rs.getObject(COL_IS_TEMPLATE, java.math.BigDecimal.class);
        creditofferpartymap.setIsTemplate(IS_TEMPLATE);
        Integer OFFER_ID = rs.getObject(COL_OFFER_ID, Integer.class);
        creditofferpartymap.setOfferID(OFFER_ID);
        creditofferpartymap.setMappingStatus(rs.getString(COL_MAPPING_STATUS));
        Integer VERSION_ID = rs.getObject(COL_VERSION_ID, Integer.class);
        creditofferpartymap.setVersionID(VERSION_ID);
        java.math.BigDecimal IS_MASTER_VERSION = rs.getObject(COL_IS_MASTER_VERSION, java.math.BigDecimal.class);
        creditofferpartymap.setIsMasterVersion(IS_MASTER_VERSION);
        Integer UPLOAD_REF_ID = rs.getObject(COL_UPLOAD_REF_ID, Integer.class);
        creditofferpartymap.setUploadRefID(UPLOAD_REF_ID);
        java.math.BigDecimal USAGE_LIMIT = rs.getObject(COL_USAGE_LIMIT, java.math.BigDecimal.class);
        creditofferpartymap.setUsageLimit(USAGE_LIMIT);
        Integer CUSTOMER_ID = rs.getObject(COL_CUSTOMER_ID, Integer.class);
        creditofferpartymap.setCustomerID(CUSTOMER_ID);
        creditofferpartymap.setCrnBor(rs.getString(COL_CRN_BOR));
        creditofferpartymap.setAccNo(rs.getString(COL_ACC_NO));
        creditofferpartymap.setRoi(rs.getString(COL_ROI));
        java.math.BigDecimal PROC_FEE = rs.getObject(COL_PROC_FEE, java.math.BigDecimal.class);
        creditofferpartymap.setProcFee(PROC_FEE);
        java.math.BigDecimal OVERALL_LIMIT = rs.getObject(COL_OVERALL_LIMIT, java.math.BigDecimal.class);
        creditofferpartymap.setOverallLimit(OVERALL_LIMIT);
        creditofferpartymap.setPortfolio(rs.getString(COL_PORTFOLIO));
        creditofferpartymap.setProductCode(rs.getString(COL_PRODUCT_CODE));
        Timestamp VALID_FROM = rs.getTimestamp(COL_VALID_FROM);
        if (VALID_FROM != null)
            creditofferpartymap.setValidFrom(VALID_FROM.toLocalDateTime());
        Timestamp VALID_TO = rs.getTimestamp(COL_VALID_TO);
        if (VALID_TO != null)
            creditofferpartymap.setValidTo(VALID_TO.toLocalDateTime());
        creditofferpartymap.setDeclarationType(rs.getString(COL_DECLARATION_TYPE));
        creditofferpartymap.setBranchAddress(rs.getString(COL_BRANCH_ADDRESS));
        creditofferpartymap.setBranchLocation(rs.getString(COL_BRANCH_LOCATION));
        creditofferpartymap.setSolid(rs.getString(COL_SOLID));
        creditofferpartymap.setFinancialYear(rs.getString(COL_FINANCIAL_YEAR));
        creditofferpartymap.setGstinNum(rs.getString(COL_GSTIN_NUM));
        java.math.BigDecimal TYP_OF_PROC_FEE = rs.getObject(COL_TYP_OF_PROC_FEE, java.math.BigDecimal.class);
        creditofferpartymap.setTypOfProcFee(TYP_OF_PROC_FEE);
        java.math.BigDecimal MIN_LOAN_AMT = rs.getObject(COL_MIN_LOAN_AMT, java.math.BigDecimal.class);
        creditofferpartymap.setMinLoanAmt(MIN_LOAN_AMT);
        java.math.BigDecimal MAX_LOAN_AMT = rs.getObject(COL_MAX_LOAN_AMT, java.math.BigDecimal.class);
        creditofferpartymap.setMaxLoanAmt(MAX_LOAN_AMT);
        java.math.BigDecimal MIN_TENURE_DAYS = rs.getObject(COL_MIN_TENURE_DAYS, java.math.BigDecimal.class);
        creditofferpartymap.setMinTenureDays(MIN_TENURE_DAYS);
        java.math.BigDecimal MAX_TENURE_DAYS = rs.getObject(COL_MAX_TENURE_DAYS, java.math.BigDecimal.class);
        creditofferpartymap.setMaxTenureDays(MAX_TENURE_DAYS);
        creditofferpartymap.setAdhocType(rs.getString(COL_ADHOC_TYPE));
        java.math.BigDecimal EXISTING_FAC = rs.getObject(COL_EXISTING_FAC, java.math.BigDecimal.class);
        creditofferpartymap.setExistingFac(EXISTING_FAC);
        java.math.BigDecimal AVAILABLE_LOAN_LIMIT = rs.getObject(COL_AVAILABLE_LOAN_LIMIT, java.math.BigDecimal.class);
        creditofferpartymap.setAvailableLoanLimit(AVAILABLE_LOAN_LIMIT);
        java.math.BigDecimal SANC_LOAN_LIMIT = rs.getObject(COL_SANC_LOAN_LIMIT, java.math.BigDecimal.class);
        creditofferpartymap.setSancLoanLimit(SANC_LOAN_LIMIT);
        java.math.BigDecimal UTL_LOAN_DEM = rs.getObject(COL_UTL_LOAN_DEM, java.math.BigDecimal.class);
        creditofferpartymap.setUtlLoanDem(UTL_LOAN_DEM);
        java.math.BigDecimal GST = rs.getObject(COL_GST, java.math.BigDecimal.class);
        creditofferpartymap.setGst(GST);
        java.math.BigDecimal SPREAD_OF_ROI = rs.getObject(COL_SPREAD_OF_ROI, java.math.BigDecimal.class);
        creditofferpartymap.setSpreadOfRoi(SPREAD_OF_ROI);
        java.math.BigDecimal ROI_NEXT_YR = rs.getObject(COL_ROI_NEXT_YR, java.math.BigDecimal.class);
        creditofferpartymap.setRoiNextYr(ROI_NEXT_YR);
        creditofferpartymap.setSancLtrRefno(rs.getString(COL_SANC_LTR_REFNO));
        java.math.BigDecimal ROI_BENCHMARK = rs.getObject(COL_ROI_BENCHMARK, java.math.BigDecimal.class);
        creditofferpartymap.setRoiBenchmark(ROI_BENCHMARK);
        creditofferpartymap.setBenchmark(rs.getString(COL_BENCHMARK));
        java.math.BigDecimal ADMIN_CHRGS = rs.getObject(COL_ADMIN_CHRGS, java.math.BigDecimal.class);
        creditofferpartymap.setAdminChrgs(ADMIN_CHRGS);
        java.math.BigDecimal TECHNICAL_FEES = rs.getObject(COL_TECHNICAL_FEES, java.math.BigDecimal.class);
        creditofferpartymap.setTechnicalFees(TECHNICAL_FEES);
        creditofferpartymap.setRemarks(rs.getString(COL_REMARKS));
        java.math.BigDecimal GST_NEXT_YR = rs.getObject(COL_GST_NEXT_YR, java.math.BigDecimal.class);
        creditofferpartymap.setGstNextYr(GST_NEXT_YR);
        java.math.BigDecimal PROC_FEES_NEXT_YR = rs.getObject(COL_PROC_FEES_NEXT_YR, java.math.BigDecimal.class);
        creditofferpartymap.setProcFeesNextYr(PROC_FEES_NEXT_YR);
        creditofferpartymap.setRoiType(rs.getString(COL_ROI_TYPE));
        creditofferpartymap.setMsmeStatus(rs.getString(COL_MSME_STATUS));
        creditofferpartymap.setPslStatus(rs.getString(COL_PSL_STATUS));
        creditofferpartymap.setNatureOfBusiness(rs.getString(COL_NATURE_OF_BUSINESS));
        creditofferpartymap.setSchemeCode(rs.getString(COL_SCHEME_CODE));
        Integer LIMIT_ID = rs.getObject(COL_LIMIT_ID, Integer.class);
        creditofferpartymap.setLimitID(LIMIT_ID);
        creditofferpartymap.setSubsectorCode(rs.getString(COL_SUBSECTOR_CODE));
        creditofferpartymap.setBranchCode(rs.getString(COL_BRANCH_CODE));
        creditofferpartymap.setOperationType(rs.getString(COL_OPERATION_TYPE));
        Integer USER_ID = rs.getObject(COL_USER_ID, Integer.class);
        creditofferpartymap.setUserID(USER_ID);
        Timestamp UPLOADED_DATE = rs.getTimestamp(COL_UPLOADED_DATE);
        if (UPLOADED_DATE != null)
            creditofferpartymap.setUploadedDate(UPLOADED_DATE.toLocalDateTime());
        creditofferpartymap.setSubProductCode(rs.getString(COL_SUB_PRODUCT_CODE));
        creditofferpartymap.setSegmentCode(rs.getString(COL_SEGMENT_CODE));
        creditofferpartymap.setSegmentTeams(rs.getString(COL_SEGMENT_TEAMS));
        java.math.BigDecimal LINE_NO = rs.getObject(COL_LINE_NO, java.math.BigDecimal.class);
        creditofferpartymap.setLineNo(LINE_NO);
        return creditofferpartymap;
    }
}
