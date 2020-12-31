package article.model;

import java.util.Date;

public class Article {
	
	private Integer number;
	private String title;
	private String writerId;
	private String writerNickname;
	private Date regdate;
	private Date moddate;
	private int readCnt;
	
	
	
	
	
	public Article(Integer number, String title, String writerId,
			String writerNickname, int readCnt, Date regdate, Date moddate
			){
		super();
		this.number = number;
		this.title = title;
		this.writerId = writerId;
		this.writerNickname = writerNickname;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readCnt = readCnt;
	}
	
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getWriterNickname() {
		return writerNickname;
	}
	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModdate() {
		return moddate;
	}
	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	
	
	
	
	


				
	//번호
	//아이디
	//닉네임
	//타이틀
	//작성날짜
	//수정날짜
	//조회수
	
	
}
