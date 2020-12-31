package member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import member.service.DeleteMemberService;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;

public class DeleteMemberHandler implements CommandHandler {
	private final String form_view = "deleteForm";
	//일단 냅두고
	
	
	DeleteMemberService deleteMemberService = new DeleteMemberService(); 
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
		//정보 요청온 경로 확인
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return form_view;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("memberid");
		String password = req.getParameter("memberpw");
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		if(id == null || id.isEmpty()) {
			errors.put("emptyid", true);
		}
		
		if(password == null || password.isEmpty()) {
			errors.put("emptypw", true);
			
		}
		
	
		
	
		//데이터 값이 확인
		//패스워드가 다른지 또는 비어있는 지
		
		
		
		
		
		 HttpSession session = req.getSession();
			/* User user = (User) session.getAttribute("authUser"); */
		
		
		try {
			deleteMemberService.DeleteMember(id, password);
			session.invalidate();
		//서비스에게 일 시키기
		//=> 필요한 것 user / password
		//user은 세션에서 가져오기
		//password는 폼에서 보낸 데이터값
		
		//성공페이지로 이동
			res.sendRedirect(req.getContextPath()+"/index.jsp");
			return null;
		} catch(MemberNotFoundException e) {
			errors.put("MemberNotFound", true);
			
		} catch(InvalidPasswordException e) {
			errors.put("InvalidPw", true);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	
			return form_view;
			
			
	}
	
}
