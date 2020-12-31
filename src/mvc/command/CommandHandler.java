package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
	//몸통이 없는 인터페이스. 몸통은 구현하는 곳에서 만들어줌.
	//String => 몸통 타입이 없기때문에 어떤 타입을 리턴해줄 것인지 명시.
	//req, res => 파라미터 이름은 아무거나 지정해줌.
	