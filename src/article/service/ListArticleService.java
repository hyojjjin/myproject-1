package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.ConnectionProvider;

public class ListArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private int size = 10;
	
	public ArticlePage articlePage(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			// 전체 total 구하기
			int total = articleDao.selectCount(conn);
			//List content 구하기
			List<Article> content = articleDao.select(conn, pageNum, size);
		
			return new ArticlePage(total, pageNum, content, size);
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException (e);
		}
		
	}
	

}
