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

public class JdbcProdtypeDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcProdtypeDao.class);

    private static final String TABLE = "PRODTYPE";

    private static final String COL_KEY97 = "KEY97";

    private static final String COL_PRODUCT = "PRODUCT";

    private static final String COL_SUPERSEDED = "SUPERSEDED";

    private static final String COL_NAME = "NAME";

    private static final String COL_DESCRIP = "DESCRIP";

    private static final String COL_FACILITY = "FACILITY";

    private static final String COL_USELICENSE = "USELICENSE";

    private static final String COL_SUPERSEDES = "SUPERSEDES";

    private static final String COL_CODE = "CODE";

    private static final String COL_ROUNDING = "ROUNDING";

    private static final String COL_ECFPRCNT = "ECFPRCNT";

    private static final String COL_DEFINTYPE = "DEFINTYPE";

    private static final String COL_USESPERATE = "USESPERATE";

    private static final String COL_INT_CON_CR = "INT_CON_CR";

    private static final String COL_INT_CONSOL = "INT_CONSOL";

    private static final String COL_INTDISPAY = "INTDISPAY";

    private static final String COL_PENAL_CODE = "PENAL_CODE";

    private static final String COL_PENAL_DATE = "PENAL_DATE";

    private static final String COL_RATETYPE = "RATETYPE";

    private static final String COL_DFUSNCEUNT = "DFUSNCEUNT";

    private static final String COL_DFUSNCENUM = "DFUSNCENUM";

    private static final String COL_PENAL_RATE = "PENAL_RATE";

    private static final String COL_DEFPERCENT = "DEFPERCENT";

    private static final String COL_INT_CON_DR = "INT_CON_DR";

    private static final String COL_PEPEDUNIT = "PEPEDUNIT";

    private static final String COL_PEPEDNUM = "PEPEDNUM";

    private static final String COL_TRINTAPP = "TRINTAPP";

    private static final String COL_OVPUNIT = "OVPUNIT";

    private static final String COL_OVPNUM = "OVPNUM";

    private static final String COL_MAT_ADJUST = "MAT_ADJUST";

    private static final String COL_PTNS_REQ = "PTNS_REQ";

    private static final String COL_COST_FUNDS = "COST_FUNDS";

    private static final String COL_COST_CUST = "COST_CUST";

    private static final String COL_COFREPTYPE = "COFREPTYPE";

    private static final String COL_COFPERUNIT = "COFPERUNIT";

    private static final String COL_COFPERNUM = "COFPERNUM";

    private static final String COL_COFPERDAY = "COFPERDAY";

    private static final String COL_COFPERADJ = "COFPERADJ";

    private static final String COL_COFDRTCD = "COFDRTCD";

    private static final String COL_COFCRTCD = "COFCRTCD";

    private static final String COL_COFCONTRA = "COFCONTRA";

    private static final String COL_COFUPDRATE = "COFUPDRATE";

    private static final String COL_ISLAMIC = "ISLAMIC";

    private static final String COL_UNEXPECTED = "UNEXPECTED";

    private static final String COL_RATETYPEPD = "RATETYPEPD";

    private static final String COL_DISABLEINT = "DISABLEINT";

    private static final String COL_DISABLECOF = "DISABLECOF";

    private static final String COL_PSETSTATUS = "PSETSTATUS";

    private static final String COL_PARAMSET = "PARAMSET";

    private static final String COL_TYPEFLAG = "TYPEFLAG";

    private static final String COL_TSTAMP = "TSTAMP";

    private static final String COL_INTPERUNIT = "INTPERUNIT";

    private static final String COL_INTPERNUM = "INTPERNUM";

    private static final String COL_INTPERDAY = "INTPERDAY";

    private static final String COL_INT_ADVDYS = "INT_ADVDYS";

    private static final String COL_INT_CMPND = "INT_CMPND";

    private static final String COL_COF_CMPND = "COF_CMPND";

    private static final String COL_PD_CMPND = "PD_CMPND";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_KEY97, COL_PRODUCT, COL_SUPERSEDED, COL_NAME, COL_DESCRIP, COL_FACILITY, COL_USELICENSE, COL_SUPERSEDES, COL_CODE, COL_ROUNDING, COL_ECFPRCNT, COL_DEFINTYPE, COL_USESPERATE, COL_INT_CON_CR, COL_INT_CONSOL, COL_INTDISPAY, COL_PENAL_CODE, COL_PENAL_DATE, COL_RATETYPE, COL_DFUSNCEUNT, COL_DFUSNCENUM, COL_PENAL_RATE, COL_DEFPERCENT, COL_INT_CON_DR, COL_PEPEDUNIT, COL_PEPEDNUM, COL_TRINTAPP, COL_OVPUNIT, COL_OVPNUM, COL_MAT_ADJUST, COL_PTNS_REQ, COL_COST_FUNDS, COL_COST_CUST, COL_COFREPTYPE, COL_COFPERUNIT, COL_COFPERNUM, COL_COFPERDAY, COL_COFPERADJ, COL_COFDRTCD, COL_COFCRTCD, COL_COFCONTRA, COL_COFUPDRATE, COL_ISLAMIC, COL_UNEXPECTED, COL_RATETYPEPD, COL_DISABLEINT, COL_DISABLECOF, COL_PSETSTATUS, COL_PARAMSET, COL_TYPEFLAG, COL_TSTAMP, COL_INTPERUNIT, COL_INTPERNUM, COL_INTPERDAY, COL_INT_ADVDYS, COL_INT_CMPND, COL_COF_CMPND, COL_PD_CMPND);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("KEY97, PRODUCT, SUPERSEDED, NAME, DESCRIP, FACILITY, USELICENSE, SUPERSEDES, CODE, ROUNDING, ECFPRCNT, DEFINTYPE, USESPERATE, INT_CON_CR, INT_CONSOL, INTDISPAY, PENAL_CODE, PENAL_DATE, RATETYPE, DFUSNCEUNT, DFUSNCENUM, PENAL_RATE, DEFPERCENT, INT_CON_DR, PEPEDUNIT, PEPEDNUM, TRINTAPP, OVPUNIT, OVPNUM, MAT_ADJUST, PTNS_REQ, COST_FUNDS, COST_CUST, COFREPTYPE, COFPERUNIT, COFPERNUM, COFPERDAY, COFPERADJ, COFDRTCD, COFCRTCD, COFCONTRA, COFUPDRATE, ISLAMIC, UNEXPECTED, RATETYPEPD, DISABLEINT, DISABLECOF, PSETSTATUS, PARAMSET, TYPEFLAG, TSTAMP, INTPERUNIT, INTPERNUM, INTPERDAY, INT_ADVDYS, INT_CMPND, COF_CMPND, PD_CMPND", TABLE, COL_KEY97);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("KEY97, PRODUCT, SUPERSEDED, NAME, DESCRIP, FACILITY, USELICENSE, SUPERSEDES, CODE, ROUNDING, ECFPRCNT, DEFINTYPE, USESPERATE, INT_CON_CR, INT_CONSOL, INTDISPAY, PENAL_CODE, PENAL_DATE, RATETYPE, DFUSNCEUNT, DFUSNCENUM, PENAL_RATE, DEFPERCENT, INT_CON_DR, PEPEDUNIT, PEPEDNUM, TRINTAPP, OVPUNIT, OVPNUM, MAT_ADJUST, PTNS_REQ, COST_FUNDS, COST_CUST, COFREPTYPE, COFPERUNIT, COFPERNUM, COFPERDAY, COFPERADJ, COFDRTCD, COFCRTCD, COFCONTRA, COFUPDRATE, ISLAMIC, UNEXPECTED, RATETYPEPD, DISABLEINT, DISABLECOF, PSETSTATUS, PARAMSET, TYPEFLAG, TSTAMP, INTPERUNIT, INTPERNUM, INTPERDAY, INT_ADVDYS, INT_CMPND, COF_CMPND, PD_CMPND", TABLE, COL_KEY97);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_PRODUCT, COL_SUPERSEDED, COL_NAME, COL_DESCRIP, COL_FACILITY, COL_USELICENSE, COL_SUPERSEDES, COL_CODE, COL_ROUNDING, COL_ECFPRCNT, COL_DEFINTYPE, COL_USESPERATE, COL_INT_CON_CR, COL_INT_CONSOL, COL_INTDISPAY, COL_PENAL_CODE, COL_PENAL_DATE, COL_RATETYPE, COL_DFUSNCEUNT, COL_DFUSNCENUM, COL_PENAL_RATE, COL_DEFPERCENT, COL_INT_CON_DR, COL_PEPEDUNIT, COL_PEPEDNUM, COL_TRINTAPP, COL_OVPUNIT, COL_OVPNUM, COL_MAT_ADJUST, COL_PTNS_REQ, COL_COST_FUNDS, COL_COST_CUST, COL_COFREPTYPE, COL_COFPERUNIT, COL_COFPERNUM, COL_COFPERDAY, COL_COFPERADJ, COL_COFDRTCD, COL_COFCRTCD, COL_COFCONTRA, COL_COFUPDRATE, COL_ISLAMIC, COL_UNEXPECTED, COL_RATETYPEPD, COL_DISABLEINT, COL_DISABLECOF, COL_PSETSTATUS, COL_PARAMSET, COL_TYPEFLAG, COL_TSTAMP, COL_INTPERUNIT, COL_INTPERNUM, COL_INTPERDAY, COL_INT_ADVDYS, COL_INT_CMPND, COL_COF_CMPND, COL_PD_CMPND, COL_KEY97);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_KEY97);

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

    public java.math.BigDecimal insert(Connection conn, Prodtype prodtype) throws SQLException {
        logger.debug("Inserting prodtype: {}", prodtype);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setProdtypeParams(ps, prodtype);
            ps.executeUpdate();
            return prodtype.getKey97();
        }
    }

    public int[] insertAll(Connection conn, List<Prodtype> prodtypes) throws SQLException {
        if (prodtypes == null || prodtypes.isEmpty())
            return new int[0];
        for (int i = 0; i < prodtypes.size(); i++) {
            if (prodtypes.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Prodtype>> batches = chunkList(prodtypes, batchSize);
        int[] totalResults = new int[prodtypes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Prodtype> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (Prodtype prodtype : batch) {
                        setProdtypeParams(ps, prodtype);
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

    public Prodtype findById(Connection conn, java.math.BigDecimal id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setBigDecimal(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Prodtype> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Prodtype> list = new ArrayList<>();
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

    public boolean update(Connection conn, Prodtype prodtype) throws SQLException {
        if (prodtype.getKey97() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setProdtypeParams(ps, prodtype);
            ps.setBigDecimal(58, prodtype.getKey97());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Prodtype> prodtypes) throws SQLException {
        if (prodtypes == null || prodtypes.isEmpty())
            return new int[0];
        for (Prodtype prodtype : prodtypes) {
            if (prodtype == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (prodtype.getKey97() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int batchSize = isOracle ? 500 : 1000;
        List<List<Prodtype>> batches = chunkList(prodtypes, batchSize);
        int[] totalResults = new int[prodtypes.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<Prodtype> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Prodtype prodtype : batch) {
                        setProdtypeParams(ps, prodtype);
                        ps.setBigDecimal(58, prodtype.getKey97());
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

    public boolean deleteById(Connection conn, java.math.BigDecimal id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setBigDecimal(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<java.math.BigDecimal> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (java.math.BigDecimal id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        String dbVendor = getDbVendor(conn);
        boolean isOracle = "oracle".equals(dbVendor);
        int chunkSize = isOracle ? 1000 : Integer.MAX_VALUE;
        List<List<java.math.BigDecimal>> chunks = chunkList(ids, chunkSize);
        int[] totalResults = new int[ids.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            for (List<java.math.BigDecimal> chunk : chunks) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < chunk.size(); k++) {
                    if (k > 0)
                        sb.append(", ");
                    sb.append("?");
                }
                String placeholders = sb.toString();
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_KEY97, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setBigDecimal(i + 1, chunk.get(i));
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

    private void setProdtypeParams(PreparedStatement ps, Prodtype prodtype) throws SQLException {
        java.math.BigDecimal val1 = prodtype.getKey97();
        if (val1 != null) {
            ps.setBigDecimal(1, val1);
        } else {
            ps.setNull(1, Types.DECIMAL);
        }
        java.math.BigDecimal val2 = prodtype.getProduct();
        if (val2 != null) {
            ps.setBigDecimal(2, val2);
        } else {
            ps.setNull(2, Types.DECIMAL);
        }
        ps.setString(3, prodtype.getSuperseded());
        ps.setString(4, prodtype.getName());
        ps.setString(5, prodtype.getDescrip());
        ps.setString(6, prodtype.getFacility());
        ps.setString(7, prodtype.getUselicense());
        java.math.BigDecimal val8 = prodtype.getSupersedes();
        if (val8 != null) {
            ps.setBigDecimal(8, val8);
        } else {
            ps.setNull(8, Types.DECIMAL);
        }
        ps.setString(9, prodtype.getCode());
        ps.setString(10, prodtype.getRounding());
        java.math.BigDecimal val11 = prodtype.getEcfprcnt();
        if (val11 != null) {
            ps.setBigDecimal(11, val11);
        } else {
            ps.setNull(11, Types.DECIMAL);
        }
        ps.setString(12, prodtype.getDefintype());
        java.math.BigDecimal val13 = prodtype.getUsesperate();
        if (val13 != null) {
            ps.setBigDecimal(13, val13);
        } else {
            ps.setNull(13, Types.DECIMAL);
        }
        ps.setString(14, prodtype.getIntConCr());
        ps.setString(15, prodtype.getIntConsol());
        ps.setString(16, prodtype.getIntdispay());
        ps.setString(17, prodtype.getPenalCode());
        java.time.LocalDateTime val18 = prodtype.getPenalDate();
        if (val18 != null) {
            ps.setTimestamp(18, java.sql.Timestamp.valueOf(val18));
        } else {
            ps.setNull(18, Types.TIMESTAMP);
        }
        java.math.BigDecimal val19 = prodtype.getRatetype();
        if (val19 != null) {
            ps.setBigDecimal(19, val19);
        } else {
            ps.setNull(19, Types.DECIMAL);
        }
        ps.setString(20, prodtype.getDfusnceunt());
        java.math.BigDecimal val21 = prodtype.getDfusncenum();
        if (val21 != null) {
            ps.setBigDecimal(21, val21);
        } else {
            ps.setNull(21, Types.DECIMAL);
        }
        java.math.BigDecimal val22 = prodtype.getPenalRate();
        if (val22 != null) {
            ps.setBigDecimal(22, val22);
        } else {
            ps.setNull(22, Types.DECIMAL);
        }
        java.math.BigDecimal val23 = prodtype.getDefpercent();
        if (val23 != null) {
            ps.setBigDecimal(23, val23);
        } else {
            ps.setNull(23, Types.DECIMAL);
        }
        ps.setString(24, prodtype.getIntConDr());
        ps.setString(25, prodtype.getPepedunit());
        java.math.BigDecimal val26 = prodtype.getPepednum();
        if (val26 != null) {
            ps.setBigDecimal(26, val26);
        } else {
            ps.setNull(26, Types.DECIMAL);
        }
        ps.setString(27, prodtype.getTrintapp());
        ps.setString(28, prodtype.getOvpunit());
        java.math.BigDecimal val29 = prodtype.getOvpnum();
        if (val29 != null) {
            ps.setBigDecimal(29, val29);
        } else {
            ps.setNull(29, Types.DECIMAL);
        }
        ps.setString(30, prodtype.getMatAdjust());
        ps.setString(31, prodtype.getPtnsReq());
        java.math.BigDecimal val32 = prodtype.getCostFunds();
        if (val32 != null) {
            ps.setBigDecimal(32, val32);
        } else {
            ps.setNull(32, Types.DECIMAL);
        }
        java.math.BigDecimal val33 = prodtype.getCostCust();
        if (val33 != null) {
            ps.setBigDecimal(33, val33);
        } else {
            ps.setNull(33, Types.DECIMAL);
        }
        ps.setString(34, prodtype.getCofreptype());
        ps.setString(35, prodtype.getCofperunit());
        java.math.BigDecimal val36 = prodtype.getCofpernum();
        if (val36 != null) {
            ps.setBigDecimal(36, val36);
        } else {
            ps.setNull(36, Types.DECIMAL);
        }
        java.math.BigDecimal val37 = prodtype.getCofperday();
        if (val37 != null) {
            ps.setBigDecimal(37, val37);
        } else {
            ps.setNull(37, Types.DECIMAL);
        }
        ps.setString(38, prodtype.getCofperadj());
        ps.setString(39, prodtype.getCofdrtcd());
        ps.setString(40, prodtype.getCofcrtcd());
        ps.setString(41, prodtype.getCofcontra());
        java.math.BigDecimal val42 = prodtype.getCofupdrate();
        if (val42 != null) {
            ps.setBigDecimal(42, val42);
        } else {
            ps.setNull(42, Types.DECIMAL);
        }
        ps.setString(43, prodtype.getIslamic());
        ps.setString(44, prodtype.getUnexpected());
        java.math.BigDecimal val45 = prodtype.getRatetypepd();
        if (val45 != null) {
            ps.setBigDecimal(45, val45);
        } else {
            ps.setNull(45, Types.DECIMAL);
        }
        ps.setString(46, prodtype.getDisableint());
        ps.setString(47, prodtype.getDisablecof());
        ps.setString(48, prodtype.getPsetstatus());
        java.math.BigDecimal val49 = prodtype.getParamset();
        if (val49 != null) {
            ps.setBigDecimal(49, val49);
        } else {
            ps.setNull(49, Types.DECIMAL);
        }
        java.math.BigDecimal val50 = prodtype.getTypeflag();
        if (val50 != null) {
            ps.setBigDecimal(50, val50);
        } else {
            ps.setNull(50, Types.DECIMAL);
        }
        java.math.BigDecimal val51 = prodtype.getTstamp();
        if (val51 != null) {
            ps.setBigDecimal(51, val51);
        } else {
            ps.setNull(51, Types.DECIMAL);
        }
        ps.setString(52, prodtype.getIntperunit());
        java.math.BigDecimal val53 = prodtype.getIntpernum();
        if (val53 != null) {
            ps.setBigDecimal(53, val53);
        } else {
            ps.setNull(53, Types.DECIMAL);
        }
        java.math.BigDecimal val54 = prodtype.getIntperday();
        if (val54 != null) {
            ps.setBigDecimal(54, val54);
        } else {
            ps.setNull(54, Types.DECIMAL);
        }
        java.math.BigDecimal val55 = prodtype.getIntAdvdys();
        if (val55 != null) {
            ps.setBigDecimal(55, val55);
        } else {
            ps.setNull(55, Types.DECIMAL);
        }
        ps.setString(56, prodtype.getIntCmpnd());
        ps.setString(57, prodtype.getCofCmpnd());
        ps.setString(58, prodtype.getPdCmpnd());
    }

    private Prodtype extract(ResultSet rs) throws SQLException {
        Prodtype prodtype = new Prodtype();
        java.math.BigDecimal KEY97 = rs.getObject(COL_KEY97, java.math.BigDecimal.class);
        prodtype.setKey97(KEY97);
        java.math.BigDecimal PRODUCT = rs.getObject(COL_PRODUCT, java.math.BigDecimal.class);
        prodtype.setProduct(PRODUCT);
        prodtype.setSuperseded(rs.getString(COL_SUPERSEDED));
        prodtype.setName(rs.getString(COL_NAME));
        prodtype.setDescrip(rs.getString(COL_DESCRIP));
        prodtype.setFacility(rs.getString(COL_FACILITY));
        prodtype.setUselicense(rs.getString(COL_USELICENSE));
        java.math.BigDecimal SUPERSEDES = rs.getObject(COL_SUPERSEDES, java.math.BigDecimal.class);
        prodtype.setSupersedes(SUPERSEDES);
        prodtype.setCode(rs.getString(COL_CODE));
        prodtype.setRounding(rs.getString(COL_ROUNDING));
        java.math.BigDecimal ECFPRCNT = rs.getObject(COL_ECFPRCNT, java.math.BigDecimal.class);
        prodtype.setEcfprcnt(ECFPRCNT);
        prodtype.setDefintype(rs.getString(COL_DEFINTYPE));
        java.math.BigDecimal USESPERATE = rs.getObject(COL_USESPERATE, java.math.BigDecimal.class);
        prodtype.setUsesperate(USESPERATE);
        prodtype.setIntConCr(rs.getString(COL_INT_CON_CR));
        prodtype.setIntConsol(rs.getString(COL_INT_CONSOL));
        prodtype.setIntdispay(rs.getString(COL_INTDISPAY));
        prodtype.setPenalCode(rs.getString(COL_PENAL_CODE));
        Timestamp PENAL_DATE = rs.getTimestamp(COL_PENAL_DATE);
        if (PENAL_DATE != null)
            prodtype.setPenalDate(PENAL_DATE.toLocalDateTime());
        java.math.BigDecimal RATETYPE = rs.getObject(COL_RATETYPE, java.math.BigDecimal.class);
        prodtype.setRatetype(RATETYPE);
        prodtype.setDfusnceunt(rs.getString(COL_DFUSNCEUNT));
        java.math.BigDecimal DFUSNCENUM = rs.getObject(COL_DFUSNCENUM, java.math.BigDecimal.class);
        prodtype.setDfusncenum(DFUSNCENUM);
        java.math.BigDecimal PENAL_RATE = rs.getObject(COL_PENAL_RATE, java.math.BigDecimal.class);
        prodtype.setPenalRate(PENAL_RATE);
        java.math.BigDecimal DEFPERCENT = rs.getObject(COL_DEFPERCENT, java.math.BigDecimal.class);
        prodtype.setDefpercent(DEFPERCENT);
        prodtype.setIntConDr(rs.getString(COL_INT_CON_DR));
        prodtype.setPepedunit(rs.getString(COL_PEPEDUNIT));
        java.math.BigDecimal PEPEDNUM = rs.getObject(COL_PEPEDNUM, java.math.BigDecimal.class);
        prodtype.setPepednum(PEPEDNUM);
        prodtype.setTrintapp(rs.getString(COL_TRINTAPP));
        prodtype.setOvpunit(rs.getString(COL_OVPUNIT));
        java.math.BigDecimal OVPNUM = rs.getObject(COL_OVPNUM, java.math.BigDecimal.class);
        prodtype.setOvpnum(OVPNUM);
        prodtype.setMatAdjust(rs.getString(COL_MAT_ADJUST));
        prodtype.setPtnsReq(rs.getString(COL_PTNS_REQ));
        java.math.BigDecimal COST_FUNDS = rs.getObject(COL_COST_FUNDS, java.math.BigDecimal.class);
        prodtype.setCostFunds(COST_FUNDS);
        java.math.BigDecimal COST_CUST = rs.getObject(COL_COST_CUST, java.math.BigDecimal.class);
        prodtype.setCostCust(COST_CUST);
        prodtype.setCofreptype(rs.getString(COL_COFREPTYPE));
        prodtype.setCofperunit(rs.getString(COL_COFPERUNIT));
        java.math.BigDecimal COFPERNUM = rs.getObject(COL_COFPERNUM, java.math.BigDecimal.class);
        prodtype.setCofpernum(COFPERNUM);
        java.math.BigDecimal COFPERDAY = rs.getObject(COL_COFPERDAY, java.math.BigDecimal.class);
        prodtype.setCofperday(COFPERDAY);
        prodtype.setCofperadj(rs.getString(COL_COFPERADJ));
        prodtype.setCofdrtcd(rs.getString(COL_COFDRTCD));
        prodtype.setCofcrtcd(rs.getString(COL_COFCRTCD));
        prodtype.setCofcontra(rs.getString(COL_COFCONTRA));
        java.math.BigDecimal COFUPDRATE = rs.getObject(COL_COFUPDRATE, java.math.BigDecimal.class);
        prodtype.setCofupdrate(COFUPDRATE);
        prodtype.setIslamic(rs.getString(COL_ISLAMIC));
        prodtype.setUnexpected(rs.getString(COL_UNEXPECTED));
        java.math.BigDecimal RATETYPEPD = rs.getObject(COL_RATETYPEPD, java.math.BigDecimal.class);
        prodtype.setRatetypepd(RATETYPEPD);
        prodtype.setDisableint(rs.getString(COL_DISABLEINT));
        prodtype.setDisablecof(rs.getString(COL_DISABLECOF));
        prodtype.setPsetstatus(rs.getString(COL_PSETSTATUS));
        java.math.BigDecimal PARAMSET = rs.getObject(COL_PARAMSET, java.math.BigDecimal.class);
        prodtype.setParamset(PARAMSET);
        java.math.BigDecimal TYPEFLAG = rs.getObject(COL_TYPEFLAG, java.math.BigDecimal.class);
        prodtype.setTypeflag(TYPEFLAG);
        java.math.BigDecimal TSTAMP = rs.getObject(COL_TSTAMP, java.math.BigDecimal.class);
        prodtype.setTstamp(TSTAMP);
        prodtype.setIntperunit(rs.getString(COL_INTPERUNIT));
        java.math.BigDecimal INTPERNUM = rs.getObject(COL_INTPERNUM, java.math.BigDecimal.class);
        prodtype.setIntpernum(INTPERNUM);
        java.math.BigDecimal INTPERDAY = rs.getObject(COL_INTPERDAY, java.math.BigDecimal.class);
        prodtype.setIntperday(INTPERDAY);
        java.math.BigDecimal INT_ADVDYS = rs.getObject(COL_INT_ADVDYS, java.math.BigDecimal.class);
        prodtype.setIntAdvdys(INT_ADVDYS);
        prodtype.setIntCmpnd(rs.getString(COL_INT_CMPND));
        prodtype.setCofCmpnd(rs.getString(COL_COF_CMPND));
        prodtype.setPdCmpnd(rs.getString(COL_PD_CMPND));
        return prodtype;
    }
}
