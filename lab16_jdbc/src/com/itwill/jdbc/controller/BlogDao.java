package com.itwill.jdbc.controller;

import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jdbc.model.Blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*; // 인터페이스(SQL 접속) 임폴트
import static com.itwill.jdbc.model.Blog.Entity.*;

// MVC 아키텍쳐에서 Controller를 담당하는 클래스. DAO(Date Access Object)
// CRUD(Create Read Update Delete) 기능 담당: INSERT, SELECT, UPDATE, DELETE SQL
public class BlogDao {

	// -----> singleton
	private static BlogDao instance = null;

	private BlogDao() {
		try {
			// Oracle 드라이버(라이브러리)를 등록
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static BlogDao getInstance() {
		if (instance == null) {
			instance = new BlogDao();
		}
		return instance;
	}

	// <----- singleton

	/**
	 * CRUD 메서드들에서 사용했던 리소스들을 해제
	 * 
	 * @param conn Connection 객체
	 * @param stmt Statement 객체
	 * @param rs   ResultSet 객체
	 */
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

	/**
	 * CRUD 메서드들에서 사용했던 리소스들을 해제
	 * 
	 * @param conn Connection 객체
	 * @param stmt Statement 객체
	 */
	private void closeResources(Connection conn, Statement stmt) {
		closeResources(conn, stmt, null);
	}

	// ResultSet에서 각 컬럼의 값들을 읽어서 Blog 타입 객체를 생성하고 리턴.
	private Blog makeBlogFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt(COL_ID);
		String title = rs.getString(COL_TITLE);
		String content = rs.getString(COL_CONTENT);
		String writer = rs.getString(COL_WRITER);
		LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
		LocalDateTime modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME).toLocalDateTime();

		Blog blog = new Blog(id, title, content, writer, createdTime, modifiedTime);

		return blog;
	}

	// read() 메서드에서 사용할 SQL 문장
	private static final String SQL_SELECT_ALL = String.format("select * from %s order by %s desc", TBL_BLOGS, COL_ID);

	/**
	 * 데이터베이스 테이블 BLOGS 테이블에서 모든 레코드(행)를 검색해서 ID(고유키)의 내리차순으로 정렬된 리스트를 반환. 테이블에 행이
	 * 없는 경우 빈 리스트를 리턴
	 * 
	 * @return Blog를 원소로 갖는 ArrayList.
	 */
	public List<Blog> read() {// 모델에 있는 블로그를 엘리먼트로
		List<Blog> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 데이터베이스에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			// SQL 문장을 데이터베이스로 전송해서 실행
			rs = stmt.executeQuery();
			// 결과 처리
			while (rs.next()) {
				Blog blog = makeBlogFromResultSet(rs);
				result.add(blog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return result;
	}

	// CRETATE (BLOG blog) 메서드에서 사용할 SQL:
	// SQL INSERT INTO BLOGS (TITLE, CONTENT, WRITER) VALUES (?, ?, ?)
	private static final String SQL_INSERT = String.format("INSERT INTO %s (%s, %s, %s) VALUES(?, ?,?)", TBL_BLOGS,
			COL_TITLE, COL_CONTENT, COL_WRITER);

	/**
	 * 데이터베이스의 BLOGS 테이블에 행을 삽입.
	 * 
	 * @param blog 테이블에 삽입할 제목, 내용, 작성자 정보를 가지고 있는 객체
	 * @return 테이블에 삽입된 행의 개수.
	 */
	public int create(Blog blog) {
		int result = 0;

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB 접속
			stmt = conn.prepareStatement(SQL_INSERT); // statement 객체 생성
			stmt.setString(1, blog.getTitle()); // Statement의 첫번째 ? 채우기
			stmt.setString(2, blog.getContent()); // Statement의 두번째 ? 채우기
			stmt.setString(3, blog.getWriter()); // Statement의 세번째 ? 채우기
			result = stmt.executeUpdate(); // SQL 실행
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		return result;
	}

	// delete(int t) 메서드에서 사용할 SQL:delete from blogs where id = ?
	private static final String SQL_DELETE = String.format("DELETE FROM %s WHERE %s = ?", TBL_BLOGS, COL_ID);

	/**
	 * 테이블 BLOGS에서 고유키(PK) id에 해당하는 레코드(행)를 삭제.
	 * 
	 * @param id 삭제하려는 레코드의 고유키.
	 * @return 테이블에서 삭제된 행의 개수.
	 */
	public int delete(int id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id); // Statement 첫번째 물음표에 들어갈 아규먼트
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}

		return result;
	}

	// 제목에 검색 키워드가 포함된 검색 결과:
	// SELECT * FROM BLOGS WHERE lower(title) like ? order by desc
	private static final String SQL_SELECT_BY_TITLE = String
			.format("SELECT * FROM %s WHERE lower(%s) like ? order by %s desc", TBL_BLOGS, COL_TITLE, COL_ID);

	// 내용에 검색 키워드가 포함된 검색 결과:
	// SELECT * FROM BLOGS WHERE LOWER(CONTENT) LIKE ? ORDER BY ID DESC;
	private static final String SQL_SELECT_BY_CONTENT = String
			.format("SELECT * FROM %s WHERE lower(%s) like ? order by %s desc", TBL_BLOGS, COL_CONTENT, COL_ID);

	// 제목 또는 내용에 검색 키워드가 포함된 검색 결과
	// SELECT * FROM BLOGS WHERE LOWER(TITLE) LIKE ? OR LOWER(CONTENT) LIKE ? ORDER
	// BY ID DESC
	private static final String SQL_SELECT_BY_TITLE_OR_CONTENT = String.format(
			"SELECT * FROM %s WHERE LOWER(%s) LIKE ? OR LOWER(%s) LIKE ? ORDER BY %s DESC", TBL_BLOGS, COL_TITLE,
			COL_CONTENT, COL_ID);

	// 작성자에 검색 키워드가 포함된 검색결과
	// SELECT * FROM BLOGS WHERE LOWER(WRITER) LIKE ? ORDER BY ID DESC
	private static final String SQL_SELECT_BY_WRITER = String
			.format("SELECT * FROM %s WHERE lower(%s) like ? order by %s desc", TBL_BLOGS, COL_WRITER, COL_ID);

	/**
	 * 제목, 내용, 제목 또는 내용, 작성자로 검색하기. 검색 타입과 검색어를 전달받아서, 해당 SQL 문장을 실행하고 그 결과를 리턴.
	 * 
	 * @param type    0 - 제목검색, 1 - 내용검색 , 2 - 제목 또는 내용 검색, 3 - 작성자 검색
	 * @param keyword 검색 문자열.
	 * @return 검색 결과 리스트. 검색 결과가 없으면 빈 리스트.
	 */
	public List<Blog> search(int type, String keyword) {
		List<Blog> result = new ArrayList<Blog>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String searchKeyword = "%" + keyword.toLowerCase() + "%"; // like 검색에서 사용할 파라미터
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			switch (type) {
			case 0: // 제목검색
				stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
				break;
			case 1:
				stmt = conn.prepareStatement(SQL_SELECT_BY_CONTENT);
				break;
			case 2: // 제목 또는 내용 검색
				stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE_OR_CONTENT);
				stmt.setString(2, searchKeyword);
				break;
			case 3: // 작성자 검색
				stmt = conn.prepareStatement(SQL_SELECT_BY_WRITER);
				break;
			}
			stmt.setString(1, searchKeyword);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Blog blog = makeBlogFromResultSet(rs);
				result.add(blog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return result;
	}

}
