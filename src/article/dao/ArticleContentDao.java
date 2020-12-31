package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import article.model.Article;
import article.model.ArticleContent;
import jdbc.JdbcUtil;

public class ArticleContentDao {

	public ArticleContent read(Connection conn, int number) throws SQLException {
		String sql = "SELECT article_no, content"
				+ " FROM article_content_p"
				+ " WHERE article_no = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
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
	
	public ArticleContent convertArticle(ResultSet rs) throws SQLException {
		return new ArticleContent (rs.getInt("article_no"),
							rs.getString("content")
				);}
	
	public ArticleContent insert(Connection conn, ArticleContent content)
			throws SQLException {
		String sql = "INSERT INTO article_content_p"
				+ " (article_no, content)"
				+ " VALUES (?, ?)";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 1) {
				return content;
			} else {
				return null;
			}
		} 
	}
}
