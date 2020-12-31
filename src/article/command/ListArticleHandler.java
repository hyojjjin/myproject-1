package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticlePage;
import article.service.ListArticleService;
import mvc.command.CommandHandler;


public class ListArticleHandler implements CommandHandler{
	
	private ListArticleService listService = new ListArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		
		int pageNo = 1;
		
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		ArticlePage articlePage = listService.articlePage(pageNo);
		req.setAttribute("articlePage", articlePage);
		
		
		//파라미터로 페이지 번호를 받아서
		//int 타입으로 변환해주고
		//서비스에 일을 시켜서 페이지 정보를 받아서
		//리턴
		
		return "boardForm";
	}
	
	
	//게시글 보기를 누르면
	//게시들을 보여주기
	//- 게시물들을 보여주려면?
	//- dao에서 list로 article의 정보를 저장해서 arraylist 배열로 꺼내와야함
	//- 한 페이지에 10씩 노출되고
	//- 페이지 넘버 (내가 보고시픈 페이지)
	//- 보고싶은 페이지를 얻는 방법 -> list 화면에서 클릭해줄 때 파라미터로 넘어감.

}
