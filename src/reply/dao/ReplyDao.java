package reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auth.service.User;
import reply.model.Reply;

public class ReplyDao {

	public void insert (Connection conn, User user, int articleNo, String body) throws SQLException {
	
		String sql = "INSERT INTO reply ("
				+ " memberid, article_no, body, name, nickname, regdate)"
				+ " VALUES (?,?,?,?,?, SYSDATE)";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getId());
			pstmt.setInt(2, articleNo);
			pstmt.setString(3, body);
			pstmt.setString(4, user.getName());
			pstmt.setString(5, user.getNickname());
			
			pstmt.executeUpdate();
		}
	}
	
	public List<Reply> listReply(Connection conn, int articleNo) throws SQLException {
		String sql = "SELECT replyid, memberid, article_no,"
				+ " body, name, nickname, regdate"
				+ " FROM reply"
				+ " WHERE article_no = ?"
				+ " ORDER BY replyid DESC";
		
		List<Reply> list = new ArrayList<>();
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, articleNo);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reply r = new Reply();
				r.setReplyId(rs.getInt(1));
				r.setMemberId(rs.getString(2));
				r.setArticleNo(rs.getInt(3));
				r.setBody(rs.getString(4));
				r.setName(rs.getString(5));
				r.setNickname(rs.getString(6));
				r.setRegDate(rs.getTimestamp(7));
			
				list.add(r);
			}

		}
		return list;
		
	}
}
