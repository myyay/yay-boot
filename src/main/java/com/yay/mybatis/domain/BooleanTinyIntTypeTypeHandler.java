package com.yay.mybatis.domain;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooleanTinyIntTypeTypeHandler implements TypeHandler<Boolean> {
	
	@Override
	public Boolean getResult(ResultSet arg0, String arg1) throws SQLException {
		return arg0.getByte(arg1) == 1;
	}

	@Override
	public Boolean getResult(ResultSet arg0, int arg1) throws SQLException {
		return arg0.getByte(arg1) == 1;
	}

	@Override
	public Boolean getResult(CallableStatement arg0, int arg1)
			throws SQLException {
		return arg0.getByte(arg1) == 1;
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, Boolean arg2,
			JdbcType arg3) throws SQLException {
		arg0.setByte(arg1, arg2 != null && arg2.booleanValue() ? (byte)1: (byte)0 );  
	}
    
}  