package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblProductDao;
import project.vo.ProductVo;

@WebServlet(urlPatterns= {"/products.cc"}, description= "상품 전체 조회")
public class ProductServlet extends HttpServlet{
	private static final long serialVersionUID =1L;
	private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);
	
	
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	
	TblProductDao dao = new TblProductDao();
	List<ProductVo> list = dao.selectAll();
	logger.info("[@.,@] 상품 전체 조회 :{}",list);
	
	
	req.setAttribute("list",list);
	
	RequestDispatcher dispatcher = req.getRequestDispatcher("day3/products.jsp");
	dispatcher.forward(req, resp);
	
	
	
	
	}
}
