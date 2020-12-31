package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class WriterArticleService {
	//다오 객체들 가져오기
	private ArticleDao articleDao = new ArticleDao();	
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public Integer write(WriterRequest req) {
		Connection conn = null;
		
	try {
		conn = ConnectionProvider.getConnection();
		conn.setAutoCommit(false);
		
		Article article = toArticle(req);
		Article savedArticle = articleDao.insert(conn, article);
		
		if (savedArticle == null) {
			throw new RuntimeException ("fail to insert article");
	}
		
		ArticleContent content = new ArticleContent(
								savedArticle.getNumber(),
								req.getContent());
		ArticleContent savedContent = contentDao.insert(conn, content);
		
		if(savedContent == null) {
			throw new RuntimeException ("fail to insert content");
		}
		
		conn.commit();
		
		return savedArticle.getNumber();
	} catch(SQLException e) {
		throw new RuntimeException (e);
	} catch(RuntimeException e) {
		throw e;
	} finally {
		JdbcUtil.close(conn);
	}
	}	

	
	private Article toArticle(WriterRequest req) {
		return new Article (null, req.getTitle(), req.getWriterId(), req.getWriterNickname(), 0, null, null);
	}

	
	//write 메소드 생성
	//커넥션 연결
	//article 가져오기
	//content 가져오기
	

}
