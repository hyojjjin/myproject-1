package article.service;

import java.util.List;

import article.model.Article;

public class ArticlePage {

	private int total;
	private int currentPage;
	private List<Article> content;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	
	

	
	public ArticlePage(int total, int currentPage,
			List<Article> content, int size) {
		super();
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		if(total != 0) {
			//totalpages 구하기
			this.totalPages = total / size;
			
			if(total % size != 0) {
				this.totalPages++;
			}
		}
		//시작 페이지
		this.startPage = (currentPage-1)/5*5 + 1;
		//끝 페이지
		this.endPage = Math.min(startPage+4, totalPages);
	}
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Article> getContent() {
		return content;
	}
	public void setContent(List<Article> content) {
		this.content = content;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
	
	
	
	//페이지에 필요한 것들
	//총게시물수
	//현재페이지
	//페이지 내용 list <article>
	//총 페이지 수
	//첫페이지
	//끝페이지
	//페이지 사이즈 : 따로 보내줌.
}
