package jdbc;

public class JdbcUtil {
	
	//자동으로 닫아주는 close() 메소드 생성
	public static void close(AutoCloseable... ins) {
		for(AutoCloseable i : ins) {
			if(i != null) {
				try {
					i.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
