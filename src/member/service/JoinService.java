package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {
	private MemberDao memberDao = new MemberDao();
	//member의 값들 모아서 Memberdao에 보내주기 는 멤버에 담았으므로 필요없음
	//connection 연결
	//id가 중복인지 확인
	
	
	public void join(Member member) {
		
		Connection con = null;
		try {
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			
			//member.에 있는 아이디랑 비교
				
			Member m = memberDao.selectById(con, member.getMemberid());
			Member n = memberDao.selectByNn(con, member.getNickname());
		   
			//아이디가 같을 경우 찾기			
			//아이디는 다르고, 닉네임이 같을 경우 찾기
			
			
			if(m != null) {
				throw new DuplicateIdException();
				//아이디 또는 닉네임이 기존에 있으면
				//중복 익셉션 실행
				//중복 익셉션을 만들어주자,,
				
			}
			if(n != null) {
				throw new DuplicateNnException();
			}
			
			memberDao.insert(con, member);
		
			con.commit();
		} //익셉션 잡고 있으면 다시 넘겨주고
			//익셉션을 만들어주장,,
		 catch(SQLException e) {
			 e.printStackTrace(); //임시 넣음
			 //rollback 해줘야함.
		 }
			 finally {
				JdbcUtil.close(con);
			}
		
	}
}
