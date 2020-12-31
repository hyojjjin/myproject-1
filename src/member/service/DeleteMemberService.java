package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.User;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class DeleteMemberService {
	
	MemberDao memberdao = new MemberDao();
	
	
	public void DeleteMember(String memberid, String memberpw) {
		//커넥션 얻기
		
		Connection conn = ConnectionProvider.getConnection();
		
		try {
			Member m = memberdao.selectById(conn, memberid);
			
			if(m == null) {
				throw new MemberNotFoundException(); //멤버 없음 익셉션
			}
			if(!m.getMemberpw().equals(memberpw)) {
				throw new InvalidPasswordException();//사용할 수 없는 비밀번호 입니다. 익셉션
			}
			memberdao.delete(conn, memberid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn);
		}
			
	
	}
	//다오에서 객체를 꺼내서
	//멤버에 있는 지 확인
	//받은 것과 비밀번호가 다른 지 확인
	//delete 메소드 실행

}
