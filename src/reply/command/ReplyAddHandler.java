package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import mvc.command.CommandHandler;
import reply.service.ReplyAddService;

public class ReplyAddHandler implements CommandHandler {
	//service에 일을 시키기
	//Connection conn, User user, int articleNum, String body
	
	private ReplyAddService service = new ReplyAddService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("authUser");
		//왜 형변환? => 세션의 getAttribute는 object 타입으로 꺼냄
		
		System.out.println("handler 여긴 되나?");
		
		int articleNo = Integer.parseInt(req.getParameter("no"));
		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		String body = req.getParameter("body");
		
		service.add(user, articleNo, body);
				
		System.out.println("handler 성공");
		res.sendRedirect(req.getContextPath()+"/read.do?no="+articleNo+"&pageNo="+pageNo);
		return null;
	}
	
}
