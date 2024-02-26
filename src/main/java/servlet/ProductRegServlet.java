package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblProductDao;
import project.vo.ProductVo;


@WebServlet(urlPatterns= {"/productsReg.cc"}, description= "상품 등록")
public class ProductRegServlet extends HttpServlet {
	private static final long serialVersionUID =1L;
	private static final Logger logger= LoggerFactory.getLogger(ProductRegServlet.class);
	
	
	//화면을 보여주는 서블릿이므로 GET
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.info("[Myinfo]상품등록 화면 요청되었습니다.");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/day3/productsReg.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("[Myinfo]상품등록 데이터 저장이 요청되었습니다.");
		
		//POST : 요청값 인코딩 필수
		request.setCharacterEncoding("UTF-8");
		
		String pcode= request.getParameter("pcode");
		String category= request.getParameter("category");
		String pname= request.getParameter("pname");
		String temp= request.getParameter("price");
		int price= 0;
		
		if(temp.length()!=0)
			price= Integer.parseInt(temp);
		
		ProductVo vo= new ProductVo(pcode, category, pname, price); 
		logger.info("\t 입력 값 vo : {}", vo);
		
		TblProductDao dao = new TblProductDao();
		int result = dao.insert(vo);
		
//		response.sendRedirect("products.cc");		--> 대신에 alert 출력
		
		String message = "상품이 등록이 완료되었습니다. ";
		if(result ==0) {
			message = "상품 등록 오류 발생!";
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('"+message+"');");
		out.print("location.href='products.cc';");
		out.print("</script>");
					
		
		
		

	}
	
	
	
	
}
