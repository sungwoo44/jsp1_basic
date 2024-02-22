package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FristServlet2
 */
@WebServlet(name = "first.cc", urlPatterns = { "/first.cc" },description=" 처음 만드는 서블릿")
public class FristServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger= LoggerFactory.getLogger(FristServlet2.class);
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FristServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
//    get 요청응ㄹ 처리하는 메소드 -인자 타입 2개 xxx Request, xxxResponse
//    							요청과 응답에 대한 처리를 할 수 있습니다. 
//    		사용자 요청을 request 객체에 저장하면서ㅗ 동시에 응답을 전달할 객체 response 가 만들어집니다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			사용자의 요청에 대한 정보 출력(request 객체의 속성값)_ : 로그 출력에서 {}는 결과값 표시
		logger.info("\n[MyInfo] : request URL: {} , URI : {} , 컨텍스트 패스: {}", 
					request.getRequestURL(),request.getRequestURI(),request.getContextPath());
		
//		테스트 : 서블릿에서 html ㅣ출력 응답도 만들어 봅시다.	
//		out은 jsp 는 내장 객체(선언없이 사용), 서블릿은 직접 생성(response 객체로 생성합니다.)
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		//response 객체의 출력 스트림 생성
		out.print("<html>");
		out.print("<head><meta charset=\"UTF-8\"><title>WELCOME</title></head>");
		out.print("<body><h2>Hello World!!</h2>");
		out.print("현재 날짜와 시간 :" + LocalDateTime.now());
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
