package member.service;

import java.util.Map;
import member.model.Member;
//서로 다른 패키지에 있으면

public class JoinErrors {
	//조인에서 일어나는 에러들
	public void validate(Map<String, Boolean> errors, Member m) {
		//값들이 잘 들어왔는 지 확인
		checkEmpty(errors, m.getMemberid(), "memberid");
		checkEmpty(errors, m.getMemberpw(), "memberpw");
		checkEmpty(errors, m.getName(), "name");
		checkEmpty(errors, m.getNickname(), "nickname");
		checkEmpty(errors, m.getMemberpwConfirm(), "memberpwConfirm");
		
			//비밀번호 확인키는
			//입력되어있지만 값이 다를 경우.
		
		if(!errors.containsKey("memberpwConfirm")) {
			//값이 비어있지 않을 경우 errors에 없음!
			if(m.getMemberpwConfirm() != null &&
					!m.getMemberpw().equals(m.getMemberpwConfirm())) {
				errors.put("pwNotMatch", true);
			}
		}
		
	}
	
	public void checkEmpty(Map<String, Boolean> errors,
			String value, String FieldName) {
		//values 값이 없으면
		//map에 넣어준다.
		
		if(value == null || value.isEmpty()) {
			errors.put(FieldName, true);
		}
	}
	
}
