package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgMbiXar;
import com.bsit.codegeneration.mapper.FgMbiXarMapper;
import java.util.*;

@RegisterRowMapper(FgMbiXarMapper.class)
public interface FgMbiXarDao {

    @SqlQuery("SELECT * FROM FG_MBI_XAR")
    public List<FgMbiXar> findAll();

    @SqlQuery("SELECT * FROM FG_MBI_XAR WHERE id = :id")
    public Optional<FgMbiXar> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MBI_XAR(IRM_NO, IRM_DATE, AD_CODE, IRM_CCY, IRM_AMT, IRM_OS_AMT, IRM_UTIL_AMT, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, PURPOSE_OF_REMITTANCE) VALUES (:IRM_NO, :IRM_DATE, :AD_CODE, :IRM_CCY, :IRM_AMT, :IRM_OS_AMT, :IRM_UTIL_AMT, :IE_CODE, :REMITTER_NAME, :REMITTER_COUNTRY, :REMIT_BANK_COUNTRY, :PURPOSE_OF_REMITTANCE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgMbiXar entity);

    @SqlQuery("UPDATE FG_MBI_XAR SET IRM_NO = :IRM_NO, IRM_DATE = :IRM_DATE, AD_CODE = :AD_CODE, IRM_CCY = :IRM_CCY, IRM_AMT = :IRM_AMT, IRM_OS_AMT = :IRM_OS_AMT, IRM_UTIL_AMT = :IRM_UTIL_AMT, IE_CODE = :IE_CODE, REMITTER_NAME = :REMITTER_NAME, REMITTER_COUNTRY = :REMITTER_COUNTRY, REMIT_BANK_COUNTRY = :REMIT_BANK_COUNTRY, PURPOSE_OF_REMITTANCE = :PURPOSE_OF_REMITTANCE WHERE id = :id")
    public int update(@BindBean() FgMbiXar entity);

    @SqlQuery("DELETE FROM FG_MBI_XAR WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
