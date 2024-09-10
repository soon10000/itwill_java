package com.itwill.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.itwill.jdbc.OracleJdbc.*;

import oracle.jdbc.driver.OracleDriver;

public class JdbcMain04 {

	public static void main(String[] args) throws SQLException {
		// 오라클 드라이버 등록
		DriverManager.registerDriver(new OracleDriver());
		
		// 오라클 드라이버 접속
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		//PaeparedStatement 객체 생성
		final String sql = "delete from blogs where id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, 4);
		int result = stmt.executeUpdate();
		
		System.out.println(result + "개의 행이 삭제되었습니다.");
		
		stmt.close();
		conn.close();
		

	}

}
