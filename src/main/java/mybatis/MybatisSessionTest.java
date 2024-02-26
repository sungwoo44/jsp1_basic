package mybatis;

import java.util.List;

import day4.mybatis.dao.MybatisBuyDao;
import day4.mybatis.dao.MybatisCustomerDao;
import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.CustomerDto;
import day4.mybatis.dto.ProductDto;

public class MybatisSessionTest {

	
	public static void main(String[] args) {
		
testBuy();
//		testCostomer();
	//	testProduct();
		

	}
	

	public static void testBuy() {
		MybatisBuyDao dao = new MybatisBuyDao();
		System.out.println("dao 객체 : " + dao);
		
		System.out.println("====== i n s e r t 테스트======");
		int result = dao.insert(new BuyDto(0,"mina012" , "CJBAb12g",3,null));
		System.out.println("반영된 행 개수: "+ result);
		
		System.out.println("====== D e l e t e 테스트======");
		int result1 = dao.delete(1141);
		System.out.println("반영된 행 개수: "+ result1);
		
		System.out.println("====== selectAll 테스트======");
		List<BuyDto> list = dao.selectAll();
		System.out.println(list);
				
		System.out.println("====== selectCustomerBuyList 테스트======");
		List<BuyDto> list1 = dao.selectCustomerBuyList("twice");
		System.out.println(list1);
		
		
		
		
	}
	/**
	 * 
	 */
	public static void testProduct() {
		MybatisProductDao dao = new MybatisProductDao();
		System.out.println("dao 객체 : "  + dao);
		
//		System.out.println("====== i n s e r t 테스트======");
//		int result = dao.insert(new ProductDto("abcd","m2" , "테스트1",3000));
//		System.out.println("반영된 행 개수: "+ result);
//		
		System.out.println("====== selectByPname 테스트======");
		List<ProductDto> list = dao.selectByPname("테스트1");
		System.out.println("반영된 행 개수: "+ list);
		
		System.out.println("====== selectByCategory 테스트======");
		List<ProductDto> list1 = dao.selectByCategory("m2");
		System.out.println("반영된 행 개수: "+ list1);
		
		
		System.out.println("====== selectAll 테스트======");
		List<ProductDto> list2 = dao.selectAll();
		System.out.println(list2);
		
		
	}
	
	
	
	public static void testCostomer() {
		
		MybatisCustomerDao dao = new MybatisCustomerDao();
		System.out.println("dao 객체 : "  + dao);
		
		System.out.println("====== update 테스트======");
		 dao.update(new CustomerDto("twice",null, "asdfilwe@gaml.com", 12,null));
	    System.out.println("업데이트 결과: " +dao);
		
	    System.out.println("====== D e l e t e 테스트======");
	    int result1 = dao.delete("jacob1");
	    System.out.println("반영된 행 개수: "+ result1);
	    
		System.out.println("====== allCustomers 테스트======");
		List<CustomerDto> list1 = dao.allCustomers();
		System.out.println(list1);
		
		
		
		/*
		 * System.out.println("====== selectCustomerBuyList 테스트======");
		 * List<CustomerDto> list1 = dao.selectByNameAge(null,"박모모",null,29,null);
		 * System.out.println(list1);
		 */
	}

	
}
