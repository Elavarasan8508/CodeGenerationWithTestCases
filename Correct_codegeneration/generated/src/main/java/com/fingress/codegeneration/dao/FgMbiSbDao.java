package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgMbiSb;
import com.bsit.codegeneration.mapper.FgMbiSbMapper;
import java.util.*;

@RegisterRowMapper(FgMbiSbMapper.class)
public interface FgMbiSbDao {

    @SqlQuery("SELECT * FROM FG_MBI_SB")
    public List<FgMbiSb> findAll();

    @SqlQuery("SELECT * FROM FG_MBI_SB WHERE id = :id")
    public Optional<FgMbiSb> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MBI_SB(BILL_ID, INVOICE_ID, SHIPPING_BILL_STATUS, BILL_NO, FORMNO, SHIPBILLDATE, LEODATE, ADCODE, PORTCODE, EXPORT_AGENCY, EXP_TYPE, IE_CODE, AD_BILL_NUMBER, INVOICE_STATUS, INV_NO, INV_DATE, INV_SL_NO, FOBCURRCODE, FRIEGHTCURRCODE, INSCURRCODE, FOB_AMT, UTIL_FOB_AMT, FRIEGHT_AMT, UTIL_FRIEGHT_AMT, INS_AMT, UTIL_INS_AMT, LEO_DATE) VALUES (:BILL_ID, :INVOICE_ID, :SHIPPING_BILL_STATUS, :BILL_NO, :FORMNO, :SHIPBILLDATE, :LEODATE, :ADCODE, :PORTCODE, :EXPORT_AGENCY, :EXP_TYPE, :IE_CODE, :AD_BILL_NUMBER, :INVOICE_STATUS, :INV_NO, :INV_DATE, :INV_SL_NO, :FOBCURRCODE, :FRIEGHTCURRCODE, :INSCURRCODE, :FOB_AMT, :UTIL_FOB_AMT, :FRIEGHT_AMT, :UTIL_FRIEGHT_AMT, :INS_AMT, :UTIL_INS_AMT, :LEO_DATE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgMbiSb entity);

    @SqlQuery("UPDATE FG_MBI_SB SET BILL_ID = :BILL_ID, INVOICE_ID = :INVOICE_ID, SHIPPING_BILL_STATUS = :SHIPPING_BILL_STATUS, BILL_NO = :BILL_NO, FORMNO = :FORMNO, SHIPBILLDATE = :SHIPBILLDATE, LEODATE = :LEODATE, ADCODE = :ADCODE, PORTCODE = :PORTCODE, EXPORT_AGENCY = :EXPORT_AGENCY, EXP_TYPE = :EXP_TYPE, IE_CODE = :IE_CODE, AD_BILL_NUMBER = :AD_BILL_NUMBER, INVOICE_STATUS = :INVOICE_STATUS, INV_NO = :INV_NO, INV_DATE = :INV_DATE, INV_SL_NO = :INV_SL_NO, FOBCURRCODE = :FOBCURRCODE, FRIEGHTCURRCODE = :FRIEGHTCURRCODE, INSCURRCODE = :INSCURRCODE, FOB_AMT = :FOB_AMT, UTIL_FOB_AMT = :UTIL_FOB_AMT, FRIEGHT_AMT = :FRIEGHT_AMT, UTIL_FRIEGHT_AMT = :UTIL_FRIEGHT_AMT, INS_AMT = :INS_AMT, UTIL_INS_AMT = :UTIL_INS_AMT, LEO_DATE = :LEO_DATE WHERE id = :id")
    public int update(@BindBean() FgMbiSb entity);

    @SqlQuery("DELETE FROM FG_MBI_SB WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
