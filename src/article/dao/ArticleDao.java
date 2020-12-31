package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import article.model.Article;
import jdbc.JdbcUtil;

public class ArticleDao {
	
	public void increaseReadCnt(Connection conn, int number) throws SQLException {
		String sql = "UPDATE article_p "
				+ "SET read_cnt = read_cnt+1 "
				+ "WHERE article_no =?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();
			
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		
	}
	

	
	public Article read(Connection conn, int number) throws SQLException {
		String sql = "SELECT article_no, writer_id,"
				+ " writer_nickname, title, regdate,"
				+ " moddate, read_cnt FROM article_p"
				+ " WHERE article_no = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println("number: " + number);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return convertArticle(rs);
			}
			
			return null;
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
	}
	
	
	
	public int selectCount(Connection conn) throws SQLException {
		String sql = "SELECT count(*) FROM article_p";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			return 0;
		} finally {
			JdbcUtil.close(rs, stmt);
		}
	}
	
	
	
	
	public List<Article> select(Connection conn, int pageNum, int size) throws SQLException {
		String sql = "SELECT article_no, title, writer_id, writer_nickname, read_cnt, regdate, moddate"
				+ " FROM ("
				+ " SELECT article_no,"
				+ " title,"
				+ " writer_id,"
				+ " writer_nickname,"
				+ " read_cnt,"
				+ " regdate,"
				+ " moddate,"
				+ " row_number() over(order by article_no) rn"
				+ " FROM article_p) "
				+ "WHERE rn BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNum-1) * size + 1);
			pstmt.setInt(2, pageNum * size);
			//한 페이지에 보여지는 목록들
			
			rs = pstmt.executeQuery();
			
			List<Article> result = new ArrayList<>();
			while(rs.next()) {
				result.add(convertArticle(rs));
				//list에 담는다
			
			} 
			
			return result;
		} finally {
				JdbcUtil.close(rs, pstmt);
			}	
	}
	

	
	
	
	
	public Article convertArticle(ResultSet rs) throws SQLException {
		return new Article (rs.getInt("article_no"),
							rs.getString("title"),
							rs.getString("writer_id"),
							rs.getString("writer_nickname"),
							rs.getInt("read_cnt"),
							rs.getTimestamp("regdate"),
							rs.getTimestamp("moddate")
				);}
	
	
	
	
	public Article insert(Connection conn, Article article) throws SQLException {
		String sql = "INSERT INTO article_p"
				+ " (writer_id, writer_nickname,"
				+ " title, regdate, moddate, read_cnt)"
				+ " values (?, ?, ?, SYSDATE, SYSDATE, 0)"; 
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql,
					new String[] {"article_no", "regdate", "moddate"});
					//자동생성된 값을 가져오기 위해 배열 생성
			pstmt.setString(1, article.getWriterId());
			pstmt.setString(2, article.getWriterNickname());
			pstmt.setString(3, article.getTitle());
			
			int cnt =pstmt.executeUpdate();
					//실행시 생성되는 행의 개수
			
		if (cnt == 1 ){
			rs = pstmt.getGeneratedKeys(); //자동 생성 키 검색
			int article_no = 0;
			Date regdate = null;
			Date moddate = null;
			
			if(rs.next()) {
				//자동생성되는 값들을 담아주기
				article_no = rs.getInt(1);
				regdate = rs.getTimestamp(2);
				moddate = rs.getTimestamp(3);
			}
			
			return new Article(
					//Article 객체에 담아서 리턴
					article_no,
					article.getTitle(),					
					article.getWriterId(),
					article.getWriterNickname(),
					0,
					regdate,
					moddate
					);
			
		} else {
			return null;
		}
			
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
	}
 }
