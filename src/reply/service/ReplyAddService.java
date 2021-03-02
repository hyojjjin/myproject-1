package reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.User;
import jdbc.ConnectionProvider;
import reply.dao.ReplyDao;

public class ReplyAddService {
	//다오에 일을 시킴
	
	private ReplyDao dao = new ReplyDao();
	
	Connection conn = ConnectionProvider.getConnection();

	public void add(User user, int articleNo, String body) {
		try {
			System.out.println("service 성공");
			dao.insert(conn, user, articleNo, body);
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
