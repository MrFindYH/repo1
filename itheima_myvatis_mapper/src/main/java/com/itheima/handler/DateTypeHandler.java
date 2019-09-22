package com.itheima.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {
    //將java類型轉換為數據庫類型
    public void setNonNullParameter(PreparedStatement ps, int i, Date date, JdbcType jdbcType) throws SQLException {

        long time = date.getTime();
        ps.setLong(i,time);
    }

    //將數據庫類型轉換為java類型
    //String參數,要轉換的字段名稱
    //ResultSet 查詢出的結果集
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {

        //獲得結果集中需要的數據(long)轉換為Date類型返回
        long aLong = rs.getLong(columnName);
        Date date = new Date(aLong);
        return date;
    }
    //將數據庫類型轉換為java類型
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        long aLong = rs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }
    //將數據庫類型轉換為java類型
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long aLong = cs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }
}
