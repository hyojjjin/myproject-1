package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {

	public void delete(Connection conn, String memberid) throws SQLException {
		
		String sql = "DELETE member_p"
				+ " WHERE memberid =?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberid);
	
		ResultSet rs = pstmt.executeQuery();
	
		JdbcUtil.close(rs, pstmt);
	
					
		}

	
	
	
	//selectByNn 만들기
	//쿼리문
	//
	
	
	
	public Member selectByNn(Connection conn, String nickname) throws SQLException {
		
		String sql = "SELECT memberid, memberpw, name,"
				+ " nickname, regdate"
				+ " FROM member_p"
				+ " WHERE nickname = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			
			rs = pstmt.executeQuery();
			
				if(rs.next()) {
					member = new Member();
					member.setMemberid(rs.getString(1));
					member.setMemberpw(rs.getString(2));
					member.setName(rs.getString(3));
					member.setNickname(rs.getString(4));
					member.setRegdate(rs.getTimestamp(5));
				}
				
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
				
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		
		return member;
	}

	
	
	public Member selectById(Connection conn, String memberid) throws SQLException{
	
		String sql = "SELECT memberid, memberpw, name,"
				+ " nickname, regdate"
				+ " FROM member_p"
				+ " WHERE memberid = ?";
		
		//쿼리문을 실행해서
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberid);
		
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				member = new Member();
				member.setMemberid(rs.getString(1));
				member.setMemberpw(rs.getString(2));
				member.setName(rs.getString(3));
				member.setNickname(rs.getString(4));
				member.setRegdate(rs.getTimestamp(5));
				//member에 담는다
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		
		return member;
	
}

	
	
	public void insert(Connection con, Member member) throws SQLException {
		//회원가입 : 멤버에 추가하는 쿼리
		String sql = "INSERT INTO member_p"
				+ " (memberid, memberpw, name, nickname, regdate)"
				+ " values(?, ?, ?, ?, SYSDATE)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMemberid());
			pstmt.setString(2, member.getMemberpw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getNickname());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		
	}
}