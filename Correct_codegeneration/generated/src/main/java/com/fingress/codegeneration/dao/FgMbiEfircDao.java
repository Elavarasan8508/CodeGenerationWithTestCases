package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgMbiEfirc;
import com.bsit.codegeneration.mapper.FgMbiEfircMapper;
import java.util.*;

@RegisterRowMapper(FgMbiEfircMapper.class)
public interface FgMbiEfircDao {

    @SqlQuery("SELECT * FROM FG_MBI_EFIRC")
    public List<FgMbiEfirc> findAll();

    @SqlQuery("SELECT * FROM FG_MBI_EFIRC WHERE id = :id")
    public Optional<FgMbiEfirc> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MBI_EFIRC(FIRC_NUMBER, AD_CODE, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, FIRC_CCY, FIRC_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY) VALUES (:FIRC_NUMBER, :AD_CODE, :FIRC_AMT, :FIRC_UTIL_AMT, :FIRC_OS_AMT, :FIRC_CCY, :FIRC_DATE, :IE_CODE, :REMITTER_NAME, :REMITTER_COUNTRY, :REMIT_BANK_COUNTRY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgMbiEfirc entity);

    @SqlQuery("UPDATE FG_MBI_EFIRC SET FIRC_NUMBER = :FIRC_NUMBER, AD_CODE = :AD_CODE, FIRC_AMT = :FIRC_AMT, FIRC_UTIL_AMT = :FIRC_UTIL_AMT, FIRC_OS_AMT = :FIRC_OS_AMT, FIRC_CCY = :FIRC_CCY, FIRC_DATE = :FIRC_DATE, IE_CODE = :IE_CODE, REMITTER_NAME = :REMITTER_NAME, REMITTER_COUNTRY = :REMITTER_COUNTRY, REMIT_BANK_COUNTRY = :REMIT_BANK_COUNTRY WHERE id = :id")
    public int update(@BindBean() FgMbiEfirc entity);

    @SqlQuery("DELETE FROM FG_MBI_EFIRC WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
