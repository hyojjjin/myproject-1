package article.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.ReadArticleService;
import mvc.command.CommandHandler;
import reply.model.Reply;
import reply.service.ReplyService;

public class ReadArticleHandler implements CommandHandler {
	
	ReadArticleService readService = new ReadArticleService();
	ReplyService replyService = new ReplyService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//폼에서 받은 정보
		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		
		try {
			ArticleData articleData = readService.readArticle(articleNum, true);
			//서비스에 일을 시키고
			List<Reply> replylist = replyService.getReplyList(articleNum);
			
			req.setAttribute("articleData", articleData);
			req.setAttribute("replylist", replylist);
			//reply은 게시물 읽어올때 같이 읽어서 넘겨준다.
			return "readArticleForm";
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		
		}
	}
}
