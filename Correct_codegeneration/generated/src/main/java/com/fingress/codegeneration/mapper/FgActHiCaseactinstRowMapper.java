package com.bsit.codegeneration.mapper;

public class FgActHiCaseactinstRowMapper implements org.jdbi.v3.core.mapper.RowMapper<FgActHiCaseactinst> {

    @Override()
    public FgActHiCaseactinst map(ResultSet rs, org.jdbi.v3.core.statement.StatementContext ctx) {
        return return new FgActHiCaseactinst(rs.getString("TABLE_CAT"), rs.getString("TABLE_SCHEM"), rs.getString("TABLE_NAME"), rs.getString("COLUMN_NAME"), rs.getLong("DATA_TYPE"), rs.getString("TYPE_NAME"), rs.getLong("COLUMN_SIZE"), rs.getLong("BUFFER_LENGTH"), rs.getLong("DECIMAL_DIGITS"), rs.getLong("NUM_PREC_RADIX"), rs.getLong("NULLABLE"), rs.getString("REMARKS"), rs.getString("COLUMN_DEF"), rs.getLong("SQL_DATA_TYPE"), rs.getLong("SQL_DATETIME_SUB"), rs.getLong("CHAR_OCTET_LENGTH"), rs.getLong("ORDINAL_POSITION"), rs.getString("IS_NULLABLE"), rs.getString("SCOPE_CATALOG"), rs.getString("SCOPE_SCHEMA"), rs.getString("SCOPE_TABLE"), rs.getString("SOURCE_DATA_TYPE"), rs.getString("IS_AUTOINCREMENT"), rs.getString("IS_GENERATEDCOLUMN"));;
    }
}
