package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.WriterArticleService;
import article.service.WriterRequest;
import auth.service.User;
import mvc.command.CommandHandler;

public class WriterArticleHandler implements CommandHandler {
	private final String form_view = "newArticleForm";
	private WriterArticleService writerSerice = new WriterArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}		
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return form_view;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		
		User user = (User) req.getSession().getAttribute("authUser");
		WriterRequest writeReq = createWriterRequest(user, req);
		
		if(!errors.isEmpty()) {
			return form_view;
		}
		//writeRequst 객체 완성 시키기
		//user, req 보내기
		//에러검사하기
		
		// 에러 있으면 원래로 돌아가기
			
		//에러 없으면
		int articleNo = writerSerice.write(writeReq);
		req.setAttribute("aricleNo", articleNo);
		
		
		//서비스에 writeReq를 파라미터로 보내서 articleNo 알아내기
		//articleNo를 어트리뷰트로 넣어주기
		//성공했으면 성공!
		
		//res.sendRedirect(req.getContextPath()+"/boardForm.jsp");
		res.sendRedirect(req.getContextPath()+"/list.do");
		
		return null;
		
	}

	private WriterRequest createWriterRequest(User user, HttpServletRequest req) {
		return new WriterRequest(user.getId(), user.getNickname(),
						req.getParameter("title"), req.getParameter("content"));
	}
	
	//생성하는 메소드 createWriteRequest
	//new WrterRequest 만들깅

	
	
}
