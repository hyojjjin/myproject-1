package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;




/**
 * Servlet implementation class ControllerUsingURI
 */

public class ControllerUsingURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private String prefix = "/WEB-INF/view/";
		private String suffix = ".jsp";
		private Map<String, CommandHandler> map;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUsingURI() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	map = new HashMap<>();
    	//commandHandler 만들어야댐!
    	
    	ServletConfig config = getServletConfig();
    		//config : web의 정보를 알고있다.
    	String configFilePath
    		= config.getInitParameter("configFile").trim();
    	//web에 저장된 configfile의 파라미터 경로를 받아오기.
    	
    	ServletContext application = getServletContext();
    		String filePath = application.getRealPath(configFilePath);
    		
    		try(FileReader fr = new FileReader(filePath)) {
    			
    			Properties properties = new Properties();
    			properties.load(fr);
    			//properties 읽어오기
    			
    			Set<Object> keys = properties.keySet();
    			//Set<k> keySet() 모든 키를 set에 담아서 리턴
    			
    			//담은 keys를 object key로 키와 값을 함께 저장
    			for(Object key : keys) {
    				Object value = properties.get(key);
    				//key로 프로퍼티에서 values 값을 얻기
    				String className = (String) value;
    				//value 값을 String으로 강제 형변환해서 className으로 바꿈. 정말 이름임.
    				
    				try {
    					Class c = Class.forName(className);
    					Object o = c.newInstance();
    					//동적 객체 생성 메소드로 객체를 만들어주고. 
    					CommandHandler handler = (CommandHandler) o;
    					//만든 객체를 핸들러 타입으로 변환
    					map.put((String) key, handler);
    					//키, value(handler)값이 들어간 map 생성
    				} catch (Exception e) {
    					e.printStackTrace();
    				}    				
    			}  		
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청을 핸들러에게 전달함
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String root = request.getContextPath();
		
		//url에서 요청 정보를 뜯어서 command에 저장.
		String command = null;
		
		if(uri.startsWith(root)) {
			command=uri.substring(root.length());
			}
		CommandHandler handler = map.get(command);
		//command값을 map에서 찾아서 핸들러에 전달! command를 키로 가지는 값을 handler가 갖게댐.
		
		if(handler == null) {
			return;
		}
		//handler 값이 없으면 걍 null;
		
		String view = null;
		//view의 값 만들기
		
		try {
		view = handler.process(request, response);
				//halder만들어야댐
		} catch (Exception e) {
			e.printStackTrace();
		}
		//핸들러에서 일을 해서 나온 값을 view에 담고
		
		if(view != null) {
			request.getRequestDispatcher(prefix + view + suffix)
			.forward(request, response);
		}
		//view에 값이 담겨져 있으면
		//view를 보내줌
		
		//RequestDispatcher : 현재 request에 담긴 정보를 저장하고 있다가 계속 사용할 수 있게 저장하는 기능)
		
		
				
	}
	
}
