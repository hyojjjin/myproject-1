package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class LoginService {
	//-handler로부터 받은 데이터 값을 dao에서 꺼내서
	//user에 모아주기
	
	MemberDao memberDao = new MemberDao();
	
	public User login(String id, String pw) {
		// 파라미터는 핸들러에서 리퀘스트로 받은 값들.
		try (Connection conn = ConnectionProvider.getConnection()) {
			Member member = memberDao.selectById(conn, id);
			// -selectById로 멤버를 검색
			// selectById메소드가 실행되면 member에 해당 회원의 모든 정보를 담아 여기로 리턴.
			if (member.getMemberid() == null) {
				// 아이디가 없으면 로그인 실패
			}
			if (!member.matchPassword(member.getMemberpw())) {
				// 비밀번호가 틀리면 로그인 실패
			}
			return new User(member.getMemberid(), member.getName(), member.getNickname());
			// 성공하면 유저에 담아서 보내줌.

		} catch (SQLException e) {
			throw new RuntimeException(e);
			// 왜 다른 익셉션이징?
		}
	}
	
}



	
//로그인이 될 조건

//memberdao에서 아이디를 비교했을때

//비밀번호가 틀리면 로그인 실패
//아이디도 있고, 패스워드도 맞으면 성공


//login 메소드 생성
//memberdao에서 멤버를 찾았을때
//멤버가 없으면 로그인 실패익셉션이 실행

//패스워드가 맞지않으면
//로그인 실패 익셉션 실행
	
//멤버가 있고, 패스워드도 동일할때
//new User에 아이디를 담아서 보냄

//User객체가 담음

	
