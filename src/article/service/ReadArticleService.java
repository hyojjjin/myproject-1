package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.ConnectionProvider;

public class ReadArticleService {
	//number가 있는 지 없는 지!
	int readcnt;
	
	public ArticleData readArticle(int number, boolean increaseReadCnt) throws SQLException {
		ArticleDao articleDao = new ArticleDao();
		ArticleContentDao contentDao = new ArticleContentDao();
		
		try(Connection conn = ConnectionProvider.getConnection()){
			
		Article article = articleDao.read(conn, number);
		if (article == null) {
			return null;
		}
		
		ArticleContent content = contentDao.read(conn, number);
		if (content == null) {
			return null;
		}
		
		//조회수 올리는 쿼리 실행하기..
		if(increaseReadCnt) {
			articleDao.increaseReadCnt(conn, number);
		}
		return new ArticleData(article, content);
		
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		
		}
		
	}

}
