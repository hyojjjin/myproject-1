package article.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.ReadArticleService;
import mvc.command.CommandHandler;

public class ReadArticleHandler implements CommandHandler {
	
	ReadArticleService readService = new ReadArticleService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//폼에서 받은 정보
		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		
		try {
			ArticleData articleData = readService.readArticle(articleNum, true);
			//서비스에 일을 시키고
			req.setAttribute("articleData", articleData);
			
			return "readArticleForm";
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		
		}
	}
}
