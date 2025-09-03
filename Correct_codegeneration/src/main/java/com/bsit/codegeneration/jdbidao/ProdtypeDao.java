package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.batch.SqlBatch;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindList;
import java.util.List;
import java.util.Optional;
import java.util.Collection;
import com.bsit.codegeneration.entity.Prodtype;

public interface ProdtypeDao {

    /**
     * Inserts a new Prodtype and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO PRODTYPE (KEY97, PRODUCT, SUPERSEDED, NAME, DESCRIP, FACILITY, USELICENSE, SUPERSEDES, CODE, ROUNDING, ECFPRCNT, DEFINTYPE, USESPERATE, INT_CON_CR, INT_CONSOL, INTDISPAY, PENAL_CODE, PENAL_DATE, RATETYPE, DFUSNCEUNT, DFUSNCENUM, PENAL_RATE, DEFPERCENT, INT_CON_DR, PEPEDUNIT, PEPEDNUM, TRINTAPP, OVPUNIT, OVPNUM, MAT_ADJUST, PTNS_REQ, COST_FUNDS, COST_CUST, COFREPTYPE, COFPERUNIT, COFPERNUM, COFPERDAY, COFPERADJ, COFDRTCD, COFCRTCD, COFCONTRA, COFUPDRATE, ISLAMIC, UNEXPECTED, RATETYPEPD, DISABLEINT, DISABLECOF, PSETSTATUS, PARAMSET, TYPEFLAG, TSTAMP, INTPERUNIT, INTPERNUM, INTPERDAY, INT_ADVDYS, INT_CMPND, COF_CMPND, PD_CMPND) VALUES (:key97, :product, :superseded, :name, :descrip, :facility, :uselicense, :supersedes, :code, :rounding, :ecfprcnt, :defintype, :usesperate, :intConCr, :intConsol, :intdispay, :penalCode, :penalDate, :ratetype, :dfusnceunt, :dfusncenum, :penalRate, :defpercent, :intConDr, :pepedunit, :pepednum, :trintapp, :ovpunit, :ovpnum, :matAdjust, :ptnsReq, :costFunds, :costCust, :cofreptype, :cofperunit, :cofpernum, :cofperday, :cofperadj, :cofdrtcd, :cofcrtcd, :cofcontra, :cofupdrate, :islamic, :unexpected, :ratetypepd, :disableint, :disablecof, :psetstatus, :paramset, :typeflag, :tstamp, :intperunit, :intpernum, :intperday, :intAdvdys, :intCmpnd, :cofCmpnd, :pdCmpnd)")
    public int insert(@BindBean Prodtype prodtype);

    /**
     * Finds a Prodtype by its ID.
     */
    @SqlQuery("SELECT * FROM PRODTYPE WHERE KEY97 = :id")
    @RegisterBeanMapper(Prodtype.class)
    public Optional<Prodtype> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM PRODTYPE")
    @RegisterBeanMapper(Prodtype.class)
    public List<Prodtype> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM PRODTYPE ORDER BY KEY97 LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Prodtype.class)
    public List<Prodtype> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Prodtype and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE PRODTYPE SET PRODUCT = :product, SUPERSEDED = :superseded, NAME = :name, DESCRIP = :descrip, FACILITY = :facility, USELICENSE = :uselicense, SUPERSEDES = :supersedes, CODE = :code, ROUNDING = :rounding, ECFPRCNT = :ecfprcnt, DEFINTYPE = :defintype, USESPERATE = :usesperate, INT_CON_CR = :intConCr, INT_CONSOL = :intConsol, INTDISPAY = :intdispay, PENAL_CODE = :penalCode, PENAL_DATE = :penalDate, RATETYPE = :ratetype, DFUSNCEUNT = :dfusnceunt, DFUSNCENUM = :dfusncenum, PENAL_RATE = :penalRate, DEFPERCENT = :defpercent, INT_CON_DR = :intConDr, PEPEDUNIT = :pepedunit, PEPEDNUM = :pepednum, TRINTAPP = :trintapp, OVPUNIT = :ovpunit, OVPNUM = :ovpnum, MAT_ADJUST = :matAdjust, PTNS_REQ = :ptnsReq, COST_FUNDS = :costFunds, COST_CUST = :costCust, COFREPTYPE = :cofreptype, COFPERUNIT = :cofperunit, COFPERNUM = :cofpernum, COFPERDAY = :cofperday, COFPERADJ = :cofperadj, COFDRTCD = :cofdrtcd, COFCRTCD = :cofcrtcd, COFCONTRA = :cofcontra, COFUPDRATE = :cofupdrate, ISLAMIC = :islamic, UNEXPECTED = :unexpected, RATETYPEPD = :ratetypepd, DISABLEINT = :disableint, DISABLECOF = :disablecof, PSETSTATUS = :psetstatus, PARAMSET = :paramset, TYPEFLAG = :typeflag, TSTAMP = :tstamp, INTPERUNIT = :intperunit, INTPERNUM = :intpernum, INTPERDAY = :intperday, INT_ADVDYS = :intAdvdys, INT_CMPND = :intCmpnd, COF_CMPND = :cofCmpnd, PD_CMPND = :pdCmpnd WHERE KEY97 = :key97")
    public int update(@BindBean Prodtype prodtype);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM PRODTYPE WHERE KEY97 = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM PRODTYPE")
    public long countAll();

    /**
     * Bulk insert multiple Prodtype entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO PRODTYPE (KEY97, PRODUCT, SUPERSEDED, NAME, DESCRIP, FACILITY, USELICENSE, SUPERSEDES, CODE, ROUNDING, ECFPRCNT, DEFINTYPE, USESPERATE, INT_CON_CR, INT_CONSOL, INTDISPAY, PENAL_CODE, PENAL_DATE, RATETYPE, DFUSNCEUNT, DFUSNCENUM, PENAL_RATE, DEFPERCENT, INT_CON_DR, PEPEDUNIT, PEPEDNUM, TRINTAPP, OVPUNIT, OVPNUM, MAT_ADJUST, PTNS_REQ, COST_FUNDS, COST_CUST, COFREPTYPE, COFPERUNIT, COFPERNUM, COFPERDAY, COFPERADJ, COFDRTCD, COFCRTCD, COFCONTRA, COFUPDRATE, ISLAMIC, UNEXPECTED, RATETYPEPD, DISABLEINT, DISABLECOF, PSETSTATUS, PARAMSET, TYPEFLAG, TSTAMP, INTPERUNIT, INTPERNUM, INTPERDAY, INT_ADVDYS, INT_CMPND, COF_CMPND, PD_CMPND) VALUES (:key97, :product, :superseded, :name, :descrip, :facility, :uselicense, :supersedes, :code, :rounding, :ecfprcnt, :defintype, :usesperate, :intConCr, :intConsol, :intdispay, :penalCode, :penalDate, :ratetype, :dfusnceunt, :dfusncenum, :penalRate, :defpercent, :intConDr, :pepedunit, :pepednum, :trintapp, :ovpunit, :ovpnum, :matAdjust, :ptnsReq, :costFunds, :costCust, :cofreptype, :cofperunit, :cofpernum, :cofperday, :cofperadj, :cofdrtcd, :cofcrtcd, :cofcontra, :cofupdrate, :islamic, :unexpected, :ratetypepd, :disableint, :disablecof, :psetstatus, :paramset, :typeflag, :tstamp, :intperunit, :intpernum, :intperday, :intAdvdys, :intCmpnd, :cofCmpnd, :pdCmpnd)")
    public int[] bulkInsert(@BindBean List<Prodtype> prodtypes);

    /**
     * Bulk update multiple Prodtype entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE PRODTYPE SET PRODUCT = :product, SUPERSEDED = :superseded, NAME = :name, DESCRIP = :descrip, FACILITY = :facility, USELICENSE = :uselicense, SUPERSEDES = :supersedes, CODE = :code, ROUNDING = :rounding, ECFPRCNT = :ecfprcnt, DEFINTYPE = :defintype, USESPERATE = :usesperate, INT_CON_CR = :intConCr, INT_CONSOL = :intConsol, INTDISPAY = :intdispay, PENAL_CODE = :penalCode, PENAL_DATE = :penalDate, RATETYPE = :ratetype, DFUSNCEUNT = :dfusnceunt, DFUSNCENUM = :dfusncenum, PENAL_RATE = :penalRate, DEFPERCENT = :defpercent, INT_CON_DR = :intConDr, PEPEDUNIT = :pepedunit, PEPEDNUM = :pepednum, TRINTAPP = :trintapp, OVPUNIT = :ovpunit, OVPNUM = :ovpnum, MAT_ADJUST = :matAdjust, PTNS_REQ = :ptnsReq, COST_FUNDS = :costFunds, COST_CUST = :costCust, COFREPTYPE = :cofreptype, COFPERUNIT = :cofperunit, COFPERNUM = :cofpernum, COFPERDAY = :cofperday, COFPERADJ = :cofperadj, COFDRTCD = :cofdrtcd, COFCRTCD = :cofcrtcd, COFCONTRA = :cofcontra, COFUPDRATE = :cofupdrate, ISLAMIC = :islamic, UNEXPECTED = :unexpected, RATETYPEPD = :ratetypepd, DISABLEINT = :disableint, DISABLECOF = :disablecof, PSETSTATUS = :psetstatus, PARAMSET = :paramset, TYPEFLAG = :typeflag, TSTAMP = :tstamp, INTPERUNIT = :intperunit, INTPERNUM = :intpernum, INTPERDAY = :intperday, INT_ADVDYS = :intAdvdys, INT_CMPND = :intCmpnd, COF_CMPND = :cofCmpnd, PD_CMPND = :pdCmpnd WHERE KEY97 = :key97")
    public int[] bulkUpdate(@BindBean List<Prodtype> prodtypes);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM PRODTYPE WHERE KEY97 IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM PRODTYPE WHERE KEY97 = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple Prodtype records by their IDs.
     */
    @SqlQuery("SELECT * FROM PRODTYPE WHERE KEY97 IN (<ids>)")
    @RegisterBeanMapper(Prodtype.class)
    public List<Prodtype> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
