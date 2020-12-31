package member.model;

import java.util.Date;

public class Member {
	//public static String abc;
	
	private String memberid;
	private String memberpw;
	private String name;
	private String nickname;
	private Date regdate;
	private String memberpwConfirm; //join 비밀번호 확인
	

	
	public String getMemberpwConfirm() {
		return memberpwConfirm;
	}
	public void setMemberpwConfirm(String memberpwConfirm) {
		this.memberpwConfirm = memberpwConfirm;
	} //join 비밀번호 확인 메소드
		
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMemberpw() {
		return memberpw;
	}
	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	public boolean matchPassword(String pwd) {
		return memberpw.equals(pwd);
	}
	
	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", memberpw=" + memberpw + ", name=" + name + ", nickname=" + nickname
				+ ", regdate=" + regdate + ", memberpw_confirm=" + memberpwConfirm + "]";
	}
	
	

	
}
