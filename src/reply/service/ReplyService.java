package reply.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import reply.dao.ReplyDao;
import reply.model.Reply;

public class ReplyService {
	//다오에 일을 시킴
	private ReplyDao dao = new ReplyDao();
	
	public List<Reply> getReplyList(int articleNo) {
		Connection conn = ConnectionProvider.getConnection();
		
		List<Reply> list;
		//list 바구니 선언
		//트라이문 안에다가 선언하게되면 트러이캐치 밖에서 선언하면 리턴이 안 돼! 트라이 실패하면 변수가 없는 거니까
		try {
			list = dao.listReply(conn, articleNo);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return list;
		
	}
}
