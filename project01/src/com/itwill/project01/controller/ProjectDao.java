package com.itwill.project01.controller;

import static com.itwill.project01.jdbc.OracleJdbc.PASSWORD;
import static com.itwill.project01.jdbc.OracleJdbc.URL;
import static com.itwill.project01.jdbc.OracleJdbc.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itwill.project01.model.Project;

import oracle.jdbc.driver.OracleDriver;

public class ProjectDao {

	private static ProjectDao instance = null;

	public static ProjectDao getInstance() { // 싱글톤 객체 생성
		if (instance == null) {
			instance = new ProjectDao();
		}
		return instance;
	}

	private ProjectDao() {
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static final String SQL_SELECT_CITY = "SELECT DISTINCT CITY FROM ADDRESS "; 

	public List<String> getCities() { // 첫번째 콤보박스 목록
		List<String> cities = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_CITY);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String city = rs.getString("CITY");
				cities.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return cities;
	}
	
	
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static final String SQL_SELECT_CITYTWO = "SELECT BOROUGH FROM ADDRESS WHERE CITY = ?"; // 두번째 콤보박스 목록 

	public List<String> getBoroughs(String city) { // 두번째 콤보박스 목록
		List<String> boroughs = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_CITYTWO);
			stmt.setString(1, city);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String borough = rs.getString("BOROUGH");
				boroughs.add(borough);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return boroughs;
	}

}
