package article.service;

import java.util.Map;

public class WriterRequest {
	private String writerId;
	private String writerNickname;
	private String title;
	private String content;
	
	
	
	public WriterRequest(String writerId, String writerNickname, String title, String content) {
		super();
		this.writerId = writerId;
		this.writerNickname = writerNickname;
		this.title = title;
		this.content = content;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", true);
		}
		//타이틀이 비어있다면 오류
	}
	
}
	