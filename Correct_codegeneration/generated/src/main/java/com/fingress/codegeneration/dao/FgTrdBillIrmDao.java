package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTrdBillIrm;
import com.bsit.codegeneration.mapper.FgTrdBillIrmMapper;
import java.util.*;

@RegisterRowMapper(FgTrdBillIrmMapper.class)
public interface FgTrdBillIrmDao {

    @SqlQuery("SELECT * FROM FG_TRD_BILL_IRM")
    public List<FgTrdBillIrm> findAll();

    @SqlQuery("SELECT * FROM FG_TRD_BILL_IRM WHERE id = :id")
    public Optional<FgTrdBillIrm> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_TRD_BILL_IRM(IRM_NUMBER, AD_CODE, IRM_AMT, IRM_OS_AMT, IRM_CCY, REMITTANCE_DATE, IE_CODE, REMITTER_NAME) VALUES (:IRM_NUMBER, :AD_CODE, :IRM_AMT, :IRM_OS_AMT, :IRM_CCY, :REMITTANCE_DATE, :IE_CODE, :REMITTER_NAME)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgTrdBillIrm entity);

    @SqlQuery("UPDATE FG_TRD_BILL_IRM SET IRM_NUMBER = :IRM_NUMBER, AD_CODE = :AD_CODE, IRM_AMT = :IRM_AMT, IRM_OS_AMT = :IRM_OS_AMT, IRM_CCY = :IRM_CCY, REMITTANCE_DATE = :REMITTANCE_DATE, IE_CODE = :IE_CODE, REMITTER_NAME = :REMITTER_NAME WHERE id = :id")
    public int update(@BindBean() FgTrdBillIrm entity);

    @SqlQuery("DELETE FROM FG_TRD_BILL_IRM WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
