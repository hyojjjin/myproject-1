package auth.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler{
	private final String form_view = "loginForm";
	private LoginService loginService = new LoginService();
	//데이터를 받고 get인지, post인지 확인
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
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
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		//받은 걸 일단 정리해서 넣어주고
		
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		if(id == null || id.isEmpty()) {
			errors.put("id", true);
			//아이디가 널이면 오류 잡고
		}
		
		if(pw == null || pw.isEmpty()) {
			errors.put("pw", true); 
			//비밀번확 널이면 오류 잡고
		}
		
		if(!errors.isEmpty()) {
			return form_view;
			//에러가 있으면 돌려주기
		}
		
		try {
			User user = loginService.login(id, pw);
			//로그인정보를 가지고 넘겨주기
			req.getSession().setAttribute("authUser", user);
			res.sendRedirect(req.getContextPath()+"/index.jsp");
			return null;		
		} catch (LoginFailException e) {
			errors.put("IdOrPwNotMatch", true);
			return form_view;
		}
	}
	
	//get방식일때
	//post 방식일때
	
}
