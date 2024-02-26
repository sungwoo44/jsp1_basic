package day5.Servlet;

import java.io.IOException;
//import java.lang.System.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;
import day4.mybatis.dto.cateDto;
import servlet.CustomerServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = {"/search.cc"},description = "상품검색")
public class productSearchServlet extends HttpServlet{
	private static final long serialVersiuonUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CustomerServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		
		
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		logger.info("[MyInfo]파라미터 확인 : {},{},{},{}",category,keyword,from,to);
		
		Map<String, Object> map= new HashMap<>();
		if(category != null && category.trim().length() !=0) {
			map.put("category",category);
			req.setAttribute("cate", category);
		}
		
		if(keyword != null && !keyword.isEmpty()) {
			map.put("keyword",keyword.trim());
			req.setAttribute("keyword", keyword);
			
		}
		if(from!= null && !from.isEmpty() && to!= null && !to.isEmpty() ) {
			map.put("from", from.trim());
			map.put("to", to.trim());
			req.setAttribute("from", from);
			req.setAttribute("to", to);
			
		}
		
		logger.info("[MyInfo]파라미터 map : {}",map);

		
		MybatisProductDao dao = new MybatisProductDao();
		List<ProductDto> list = dao.search(map);
		req.setAttribute("list", list);
		
		
//		 List<String> cateList = List.of("A1","A2","B1","B2","C1"); 
		 List<cateDto> cateList = dao.getCategories();
		 req.setAttribute("cateList",cateList);
		 
		 
		 
		 RequestDispatcher dispatcher = req.getRequestDispatcher("/day5/search.jsp");
		 dispatcher.forward(req, resp);
	}

	
	
	
	

}
