package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import member.service.DuplicateIdException;
import member.service.DuplicateNnException;
import member.service.JoinErrors;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class JoinHandler implements CommandHandler {
	private final String form_view = "joinForm";
	private JoinService joinService = new JoinService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else 
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}
	
	//get 방식인지
	//post 방식인지 확인
	//둘 다 아니라면 
	
	
	//get방식이면
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return form_view;
	} 

	
	//post 방식이면
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		
		//받은 데이터를 member에 옮겨주고
		Member m = new Member();
		m.setMemberid(req.getParameter("memberid"));
		m.setMemberpw(req.getParameter("memberpw"));
		m.setMemberpwConfirm(req.getParameter("memberpwConfirm"));
		m.setName(req.getParameter("name"));
		m.setNickname(req.getParameter("nickname"));
		
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		System.out.println(m);
		
		JoinErrors joinErrors = new JoinErrors();
		joinErrors.validate(errors, m);
	
		System.out.println(errors);
		//맵 에러에서 꺼내서 에러 확인하고, 에러있으면 다시 받은 곳으로 넘겨준다.
		if(!errors.isEmpty()) {
			return form_view;
		}
		
		
		//에러가 없으면 joinservice의 join 메소드에 값을 넘겨주고 성공 메시지 띄우기!
		else {
			try {
			joinService.join(m);
			} catch (DuplicateIdException e){
				errors.put("duplicateId", true);
				return form_view;

			} catch (DuplicateNnException e) {
				errors.put("duplicateNn", true);
				return form_view;

			}
			return "joinSuccess";
		}
		
	}
	

	
	
	
	
}
